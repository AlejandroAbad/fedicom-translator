package es.hefame.feditrans.fedicom2.messages.m10;

import org.json.simple.JSONObject;

import es.hefame.feditrans.fedicom2.messages.MessageType;

public class F2Message_1030 extends F2Message_LinPed{

	
	private String bonificacion;
	private String descuentoLinea;
	
	
	public F2Message_1030(String data, int version) {
		super(data, version, MessageType.LINEA_BONIFIC);
		
		int idx = 21;
		bonificacion = data.substring(idx, idx+=4);
		descuentoLinea = data.substring(idx, idx+=4);
		
		
		if (version == 2)
			texto = data.substring(idx, idx+=50);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject toFedicom3() {
		JSONObject root = super.toFedicom3();
		
		if (Integer.parseInt(this.bonificacion) > 0) root.put("cantidadBonificacion", Integer.parseInt(this.bonificacion));
		if (Integer.parseInt(this.descuentoLinea) > 0) root.put("descuentoPorcentaje", Integer.parseInt(this.descuentoLinea) / 100);
		
		
		return root;
	}


	@Override
	public String toString() {
		if (version == 2)
			return super.toString() + " [codArti=<"+ codArti + ">, cantidad=<" + cantidad + ">, bonificacion=<" + bonificacion + ">, descuentoLinea=<" + descuentoLinea + ">, texto=<" + texto + ">]";
		return super.toString() + " [codArti=<"+ codArti + ">, cantidad=<" + cantidad + ">, bonificacion=<" + bonificacion + ">, descuentoLinea=<" + descuentoLinea + ">]";
	}



	
	
	
	

}
