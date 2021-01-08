package es.hefame.feditrans.fedicom2.messages.m99;

import es.hefame.feditrans.fedicom2.messages.F2Message;
import es.hefame.feditrans.fedicom2.messages.MessageType;

/**
 * RECHAZO DE LA TRANSMISION
 *
 */
public class F2Message_9999 extends F2Message{

	
	public F2Message_9999(String data, int version) {
		super(data, version, MessageType.RECHAZADO);
	}

	@Override
	public String toString() {
		return "TRANSMISION RECHAZADA";
	}



}
