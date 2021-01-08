package es.hefame.feditrans.fedicom2.messages.m20;

import es.hefame.feditrans.fedicom2.messages.F2Message;
import es.hefame.feditrans.fedicom2.messages.MessageType;

/**
 * MENSAJE RESPUESTA
 * CABECERA DEL PEDIDO DE TRANSMISIONES ANTERIORES
 *
 */
public class F2Message_2020 extends F2Message{

	private String codCli;
	private String numPedCli;
	private String rechazoPedido;
	private String incTipoPed;
	private String incCondi;
	private String incCargoCoop;
	private String incAplazamientoCargo;
	private String incAplazamientoPago;
	private String incDescAdicional;
	private String incEmpresaFactura;
	private String incAlmacen;
	private String incFechaEnvio;
	private String incDiaEnvio;
	private String incSumasTotales;
	private String textoLibre;
	
	
	public F2Message_2020(String data, int version) {
		super(data, version, MessageType.TA_CABECERA_RESP);

		int idx= 4;
		
		codCli = data.substring(idx, idx+=16);
		numPedCli = data.substring(idx, idx+=10);
		rechazoPedido = data.substring(idx, idx+=1);
		incTipoPed = data.substring(idx, idx+=1);
		incCondi = data.substring(idx, idx+=1);
		incCargoCoop = data.substring(idx, idx+=1);
		incAplazamientoCargo = data.substring(idx, idx+=1);
		incAplazamientoPago = data.substring(idx, idx+=1);
		incDescAdicional = data.substring(idx, idx+=1);
		incEmpresaFactura = data.substring(idx, idx+=1);
		incAlmacen = data.substring(idx, idx+=1);
		incFechaEnvio = data.substring(idx, idx+=1);
		incDiaEnvio = data.substring(idx, idx+=1);
		incSumasTotales = data.substring(idx, idx+=1);
		textoLibre = data.substring(idx, idx+=30);

	}


	@Override
	public String toString() {
		return "[TA]CABECERA_RESP [codCli=<" + codCli + ">, numPedCli=<" + numPedCli + ">, rechazoPedido=<" + rechazoPedido
				+ ">, incTipoPed=<" + incTipoPed + ">, incCondi=<" + incCondi + ">, incCargoCoop=<" + incCargoCoop
				+ ">, incAplazamientoCargo=<" + incAplazamientoCargo + ">, incAplazamientoPago=<" + incAplazamientoPago + ">, incDescAdicional=<" + incDescAdicional
				+ ">, incEmpresaFactura=<" + incEmpresaFactura + ">, incAlmacen=<" + incAlmacen + ">, incFechaEnvio=<"
				+ incFechaEnvio + ">, incDiaEnvio=<" + incDiaEnvio + ">, incSumasTotales=<" + incSumasTotales
				+ ">, textoLibre=<" + textoLibre + ">]";
	}
	
	



	
	
	

}
