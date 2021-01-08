package es.hefame.feditrans.fedicom2.messages.m10;

import es.hefame.feditrans.fedicom2.messages.F2Message;
import es.hefame.feditrans.fedicom2.messages.MessageType;

public class F2Message_1050 extends F2Message{

	private String sumaLineas;
	private String sumaCantidades;
	private String sumaBonificaciones;
	
	
	public F2Message_1050(String data, int version) {
		super(data, version, MessageType.PEDIDO_SUMAS);
		
		int idx = 4;
		sumaLineas = data.substring(idx, idx+=4);
		sumaCantidades = data.substring(idx, idx+=6);
		sumaBonificaciones = data.substring(idx, idx+=6);
		
	}


	@Override
	public String toString() {
		return super.toString() + " [sumaLineas=" + sumaLineas + ", sumaCantidades=" + sumaCantidades
				+ ", sumaBonificaciones=" + sumaBonificaciones + "]";
	}

	
		

	

	
	
	

}
