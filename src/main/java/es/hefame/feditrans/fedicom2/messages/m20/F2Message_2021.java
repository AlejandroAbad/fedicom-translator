package es.hefame.feditrans.fedicom2.messages.m20;

import es.hefame.feditrans.fedicom2.messages.F2Message;
import es.hefame.feditrans.fedicom2.messages.MessageType;

/**
 * MENSAJE RESPUESTA
 * TEXTO LIBRE EN RESPUESTA
 *
 */
public class F2Message_2021 extends F2Message{

	private String textoLibre;
	
	
	public F2Message_2021(String data, int version) {
		super(data, version, MessageType.TA_TEXTO_LIBRE);

		int idx= 4;
		textoLibre = data.substring(idx, idx+=50);

	}


	@Override
	public String toString() {
		return "[TA]TEXTO_LIBRE   [textoLibre=<" + textoLibre + ">]";
	}
	
	



	
	
	

}
