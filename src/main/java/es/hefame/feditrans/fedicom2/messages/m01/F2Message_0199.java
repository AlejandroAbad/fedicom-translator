package es.hefame.feditrans.fedicom2.messages.m01;

import es.hefame.feditrans.fedicom2.messages.F2Message;
import es.hefame.feditrans.fedicom2.messages.MessageType;

/**
 * CIERRE DE TRANSIMISION
 * @author Alejandro_AC
 *
 */
public class F2Message_0199 extends F2Message{

	
	public F2Message_0199(String data, int version) {
		super(data, version, MessageType.BYE);
	}

	@Override
	public String toString() {
		return super.toString()  ;
	}



}
