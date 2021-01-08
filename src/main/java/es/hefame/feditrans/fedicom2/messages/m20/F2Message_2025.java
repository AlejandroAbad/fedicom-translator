package es.hefame.feditrans.fedicom2.messages.m20;

import es.hefame.feditrans.fedicom2.messages.F2Message;
import es.hefame.feditrans.fedicom2.messages.MessageType;

/**
 * MENSAJE RESPUESTA
 * MENSAJE DE LINEA CON INCIDENCIA
 *
 */
public class F2Message_2025 extends F2Message{

	private String codigoArti;
	private String cantidadPedida;
	private String cantidadFalta;
	private String bonifPedida;
	private String bonifFalta;
	private String codigoIncidencia;
	private String artiSustituyente;
	
	
	public F2Message_2025(String data, int version) {
		super(data, version, MessageType.TA_LINEA_INCIDENCIA);

		int idx= 4;
		codigoArti = data.substring(idx, idx+=13);
		
		cantidadPedida = data.substring(idx, idx+=4);
		cantidadFalta = data.substring(idx, idx+=4);
		bonifPedida = data.substring(idx, idx+=4);
		bonifFalta = data.substring(idx, idx+=4);
		codigoIncidencia = data.substring(idx, idx+=2);
		artiSustituyente = data.substring(idx, idx+=13);

	}


	@Override
	public String toString() {
		return "[TA]LINEA_INCIDENC [codigoArti=" + codigoArti + ", cantidadPedida=" + cantidadPedida + ", cantidadFalta="
				+ cantidadFalta + ", bonifPedida=" + bonifPedida + ", bonifFalta=" + bonifFalta + ", codigoIncidencia="
				+ codigoIncidencia + ", artiSustituyente=" + artiSustituyente + "]";
	}


	
	



	
	
	

}
