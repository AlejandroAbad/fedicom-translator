package es.hefame.feditrans.fedicom2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import es.hefame.feditrans.fedicom2.messages.F2Message;
import es.hefame.feditrans.fedicom2.messages.F2MessageFactory;
import es.hefame.feditrans.fedicom2.messages.m01.F2Message_0101;
import es.hefame.feditrans.fedicom2.messages.m10.F2Message_1010;
import es.hefame.feditrans.fedicom2.messages.m10.F2Message_LinPed;
public class F2Transmission {

	private String originalData;
	
	
	private List<F2Message> messages = new LinkedList<F2Message>();
	
	public F2Transmission(String data) {
		
		originalData = data;

		int version = Integer.parseInt(data.substring(2, 4));		
		String[] chunks = originalData.split("\\.\\.");

		for (int i = 0 ; i < chunks.length ; i++) {
			F2Message msg = F2MessageFactory.parse(chunks[i], version);
			messages.add(msg);
		}
	}
	
	
	public F2Message_0101 getAutenticacion() {
		for(F2Message msg : messages) {
			if (msg != null && msg instanceof F2Message_0101) {
				return (F2Message_0101) msg;
			}
		}
		return null;
	}
	
	public F2Message_1010 getCabecera() {
		for(F2Message msg : messages) {
			if (msg != null && msg instanceof F2Message_1010) {
				return (F2Message_1010) msg;
			}
		}
		return null;
	}
	
	public boolean isTipo(int t) {
		F2Message_1010 cab = this.getCabecera();
		if (cab == null) return false;
		return cab.isTipo(t);
	}
	
	public List<F2Message_LinPed> getLineas() {
		List<F2Message_LinPed> res = new LinkedList<F2Message_LinPed>();
		
		for(F2Message msg : messages) {
			if (msg != null && msg instanceof F2Message_LinPed) {
				res.add( (F2Message_LinPed) msg );
			}
		}
		return res;
	}
	
	public boolean isTransfer() {
		F2Message_0101 auth = this.getAutenticacion();
		if (auth != null)
			return auth.isTransfer();
			
		return false;
	}
	
	
	public JSONObject toFedicom3Authentication() throws Exception {
		F2Message_0101 auth = this.getAutenticacion();
		if (auth == null) throw new Exception("No se encuentra la auth del pedido");
		
		return auth.toFedicom3();
	}
	
	
	@SuppressWarnings("unchecked")
	public JSONObject toFedicom3() throws Exception {
		
		F2Message_1010 cabecera = this.getCabecera();
		if (cabecera == null) throw new Exception("No se encuentra la cabecera del pedido");
		
		JSONObject root = cabecera.toFedicom3();
		JSONArray lineasJson = new JSONArray();
		root.put("lineas", lineasJson);
		
		List<F2Message_LinPed> lineas = this.getLineas();
		for (F2Message_LinPed linea : lineas) {
			lineasJson.add( linea.toFedicom3());
		}

		return root;		
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (F2Message f2Message : messages) {
			sb.append(f2Message.toString()).append('\n');
		}
		return sb.toString();
		
	}
	
	
	public void lanzarCobete() {
		
		
		// if (this.isTransfer()) return;
		
		
		
		
		Thread t = new Thread() {
			
			private String auth() throws Exception{
				
				JSONObject f3jsonauth = toFedicom3Authentication();
				URL url = new URL("https://fedicom3-dev.hefame.es/authenticate");
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("POST");
				con.setDoOutput(true);
				con.setInstanceFollowRedirects(true);
				con.setRequestProperty("Content-Type", "application/json");
				con.setRequestProperty("Software-Id", "9100");
			
				DataOutputStream out = new DataOutputStream(con.getOutputStream());
				out.writeBytes(f3jsonauth.toJSONString());
				out.flush();
				out.close();

				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				/*
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					content.append(inputLine);
				}
				in.close();
				*/
				JSONParser parser = new JSONParser();
				JSONObject authRes = (JSONObject) parser.parse(in);
				
				if (authRes.containsKey("auth_token")) {
					return  	(String) authRes.get("auth_token");						
				}
				
				return null;
				
			}
			
			public void run() {
				try {
					
					String token = this.auth();
					
					JSONObject f3json = toFedicom3();


					URL url = new URL("https://fedicom3-dev.hefame.es/pedidos");
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					con.setRequestMethod("POST");
					con.setDoOutput(true);
					con.setInstanceFollowRedirects(true);
					con.setRequestProperty("Content-Type", "application/json");
					con.setRequestProperty("Software-Id", "9100");
					con.setRequestProperty("Authorization", "Bearer " + token);
				
					DataOutputStream out = new DataOutputStream(con.getOutputStream());
					out.writeBytes(f3json.toJSONString());
					out.flush();
					out.close();

					BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
					String inputLine;
					StringBuffer content = new StringBuffer();
					while ((inputLine = in.readLine()) != null) {
						content.append(inputLine);
					}
					in.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		t.start();
		
	}
	

}
