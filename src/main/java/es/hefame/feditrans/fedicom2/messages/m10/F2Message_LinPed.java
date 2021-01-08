package es.hefame.feditrans.fedicom2.messages.m10;

import org.json.simple.JSONObject;

import es.hefame.feditrans.fedicom2.messages.F2Message;
import es.hefame.feditrans.fedicom2.messages.MessageType;

public abstract class F2Message_LinPed extends F2Message{

	protected String codArti;
	protected String cantidad;
	
	protected String texto = "";
	
	
	public F2Message_LinPed(String data, int version, MessageType type) {
		super(data, version, type);
		
		int idx = 4;
		codArti = data.substring(idx, idx+=13);
		cantidad = data.substring(idx, idx+=4);
	}

	
	@SuppressWarnings("unchecked")
	public JSONObject toFedicom3() {
		JSONObject root = new JSONObject();
		
		root.put("codigoArticulo", Long.parseLong(this.codArti) + "");
		root.put("cantidad", Integer.parseInt(this.cantidad));
		
		
		return root;
	}

	@Override
	public String toString() {
		return super.toString();
	}


	
	
	

}
