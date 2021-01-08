package es.hefame.feditrans.fedicom2.messages.m10;

import org.json.simple.JSONObject;

import es.hefame.feditrans.fedicom2.messages.F2Message;
import es.hefame.feditrans.fedicom2.messages.MessageType;

public class F2Message_1010 extends F2Message{

	private String codCli;
	private String numPedCli;
	private String tipoPed;
	private String condi;
	private String cargoCoop;
	private String aplazaCargo;
	private String aplazaPago;
	private String descuentoAdicional;
	private String empresaFactura;
	private String almacen;
	private String fechaEnvio;
	private String diaEnvio;
	
	
	public F2Message_1010(String data, int version) {
		super(data, version, MessageType.CABECERA_PEDIDO);
		
		int idx = 4;
		codCli = data.substring(idx, idx+=16);
		numPedCli = data.substring(idx, idx+=10);
		tipoPed = data.substring(idx, idx+=6);
		condi = data.substring(idx, idx+=6);
		
		cargoCoop = data.substring(idx, idx+=1);
		aplazaCargo = data.substring(idx, idx+=3);
		aplazaPago = data.substring(idx, idx+=3);
		descuentoAdicional = data.substring(idx, idx+=4);
		empresaFactura = data.substring(idx, idx+=3);
		almacen = data.substring(idx, idx+=4);
		fechaEnvio = data.substring(idx, idx+=8);
		diaEnvio = data.substring(idx, idx+=2);
		
	}
	
	public boolean isTipo(int t) {
		
		try {
			int ti = Integer.parseInt(this.tipoPed.trim());
			return t == ti;
		} catch (Exception e) {
			return false;
		}
		
	}

	
	
	@SuppressWarnings("unchecked")
	public JSONObject toFedicom3() throws Exception {

		JSONObject root = new JSONObject();
		
		if (codCli.trim().length() > 0)root.put("codigoCliente", codCli.trim());
		if (numPedCli.trim().length() > 0) 
			root.put("numeroPedidoOrigen", numPedCli.trim() + "-" + System.currentTimeMillis() + "-" + Math.random()); 
		else 
			root.put("numeroPedidoOrigen", "N/A-" + System.currentTimeMillis() + "-" + Math.random());
		if (tipoPed.trim().length() > 0) root.put("tipoPedido", tipoPed.trim());
		if (almacen.trim().length() > 0) root.put("codigoAlmacenServicio", almacen.trim()); 
		

		return root;		
	}


	@Override
	public String toString() {
		return super.toString() + " [codCli=<" + codCli + ">, numPedCli=<" + numPedCli + ">, tipoPed=<" + tipoPed + ">, condi=<"
				+ condi + ">, cargoCoop=<" + cargoCoop + ">, aplazaCargo=<" + aplazaCargo + ">, aplazaPago=<" + aplazaPago
				+ ">, descuentoAdicional=<" + descuentoAdicional + ">, empresaFactura=<" + empresaFactura + ">, almacen=<"
				+ almacen + ">, fechaEnvio=<" + fechaEnvio + ">, diaEnvio=<" + diaEnvio + ">]";
	}





}
