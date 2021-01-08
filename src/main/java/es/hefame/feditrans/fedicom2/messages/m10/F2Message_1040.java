package es.hefame.feditrans.fedicom2.messages.m10;

import org.json.simple.JSONObject;

import es.hefame.feditrans.fedicom2.messages.MessageType;

public class F2Message_1040 extends F2Message_LinPed {

	private String descuento;
	private String numeroVale;

	public F2Message_1040(String data, int version) {
		super(data, version, MessageType.LINEA_ESTUPEF);

		int idx = 21;
		descuento = data.substring(idx, idx += 4);
		numeroVale = data.substring(idx, idx += 25);
		texto = data.substring(idx, idx += 50);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject toFedicom3() {
		JSONObject root = super.toFedicom3();
		
		
		root.put("valeEstupefaciente", this.numeroVale.trim());
		if (Integer.parseInt(this.descuento) > 0) root.put("descuentoPorcentaje", Integer.parseInt(this.descuento) / 100);
		if (this.texto.trim().length() > 0) root.put("observaciones", this.texto);
		
		
		return root;
	}

	@Override
	public String toString() {
		return super.toString() + " [codArti=<" + codArti + ">, cantidad=<" + cantidad + ">, descuento=<" + descuento
				+ ">, numeroVale=<" + numeroVale + ">, texto=<" + texto + ">]";
	}

}
