package es.hefame.feditrans.fedicom2.messages.m30;

import org.json.simple.JSONObject;

import es.hefame.feditrans.fedicom2.messages.F2Message;
import es.hefame.feditrans.fedicom2.messages.MessageType;

public class F2Message_3020 extends F2Message {

	protected String codArti;
	protected String cantidad;
	protected String lote;
	protected String caducidad;
	protected String motivo;

	protected String texto = "";

	public F2Message_3020(String data, int version) {
		super(data, version, MessageType.LINEA_ABONO);

		int idx = 4;
		codArti = data.substring(idx, idx += 13);
		cantidad = data.substring(idx, idx += 4);
		lote = data.substring(idx, idx += 20);
		caducidad = data.substring(idx, idx += 8);
		motivo = data.substring(idx, idx += 2);

		try {
			texto = data.substring(idx, idx += 50);
		} catch (IndexOutOfBoundsException e) {
			// Hay tramas que no traen el hueco del texto. Se ignora.
			texto = "";
		}
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
		return super.toString() + " [codArti=<" + codArti + ">, cantidad=<" + cantidad + ">, lote=<" + lote
				+ ">, caducidad=<" + caducidad + ">, motivo=<" + motivo + ">, texto=<" + texto + ">]";
	}
}
