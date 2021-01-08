package es.hefame.feditrans.fedicom2.messages.m20;

import es.hefame.feditrans.fedicom2.messages.F2Message;
import es.hefame.feditrans.fedicom2.messages.MessageType;

/**
 * MENSAJE RESPUESTA
 * ARTICULOS A ENTREGAR EN CICLO NO HABITUAL
 *
 */
public class F2Message_2016 extends F2Message{

	private String proveedor;
	private String almacen;
	private String codigoArti;
	private String cantidadPedida;
	private String cantidadServida;
	private String bonifPedida;
	private String bonifServida;
	private String codigoIncidencia;
	private String fechaEntrega;
	private String horaEntrega;
	private String textoLibre;
	
	
	public F2Message_2016(String data, int version) {
		super(data, version, MessageType.CICLO_NO_HABIT);

		int idx= 4;
		proveedor = data.substring(idx, idx+=4);
		almacen = data.substring(idx, idx+=4);
		codigoArti = data.substring(idx, idx+=13);
		cantidadPedida = data.substring(idx, idx+=4);
		cantidadServida = data.substring(idx, idx+=4);
		bonifPedida = data.substring(idx, idx+=4);
		bonifServida = data.substring(idx, idx+=4);
		codigoIncidencia = data.substring(idx, idx+=2);
		fechaEntrega = data.substring(idx, idx+=8);
		horaEntrega = data.substring(idx, idx+=6);
		textoLibre = data.substring(idx, idx+=50);

	}


	@Override
	public String toString() {
		return "ARTI_NO_HABIT [proveedor=" + proveedor + ", almacen=" + almacen + ", codigoArti=" + codigoArti
				+ ", cantidadPedida=" + cantidadPedida + ", cantidadServida=" + cantidadServida + ", bonifPedida="
				+ bonifPedida + ", bonifServida=" + bonifServida + ", codigoIncidencia=" + codigoIncidencia
				+ ", fechaEntrega=" + fechaEntrega + ", horaEntrega=" + horaEntrega + ", textoLibre=" + textoLibre
				+ "]";
	}

	
	

	

	
	



	
	
	

}
