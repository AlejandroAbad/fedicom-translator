package es.hefame.feditrans.fedicom2.messages.m01;

import org.json.simple.JSONObject;

import es.hefame.feditrans.fedicom2.messages.F2Message;
import es.hefame.feditrans.fedicom2.messages.MessageType;

/**
 * MENSAJE DE LOGIN
 * @author Alejandro_AC
 *
 */
public class F2Message_0101 extends F2Message{

	private String fecha;
	private String hora;
	private String usuario;
	private String clave;
	
	
	public F2Message_0101(String data, int version) {
		super(data, version, MessageType.USER_LOGIN);
		
		int idx = 4;
		fecha = data.substring(idx, idx+=8);
		hora = data.substring(idx, idx+=6);
		usuario = data.substring(idx, idx+=16);
		clave = data.substring(idx, idx+=8);
	}

	public boolean isTransfer() {
		return this.usuario.startsWith("TR") || this.usuario.startsWith("TG") || this.usuario.startsWith("TP");
	}
	
	@Override
	public String toString() {
		return super.toString() + " [fecha=<" + fecha + ">, hora=<" + hora + ">, usuario=<" + usuario + ">, clave=<" + clave + ">]";
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject toFedicom3() throws Exception {

		JSONObject root = new JSONObject();
		
		if (this.usuario.trim().length() > 0) root.put("user", this.usuario.trim());
		if (this.clave.trim().length() > 0) root.put("password", this.clave.trim());
		

		return root;		
	}
	
	

}
