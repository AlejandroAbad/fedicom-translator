package es.hefame.feditrans.fedicom2.messages.m20;

import es.hefame.feditrans.fedicom2.messages.F2Message;
import es.hefame.feditrans.fedicom2.messages.MessageType;

/**
 * MENSAJE RESPUESTA
 * FALTA VERIFICACION DE PEDIDOS
 *
 */
public class F2Message_2030 extends F2Message{

	private String textoLibre;
	
	
	public F2Message_2030(String data, int version) {
		super(data, version, MessageType.FALTA_VERIF_PED);

		int idx= 4;
		textoLibre = data.substring(idx, idx+=50);

	}


	@Override
	public String toString() {
		return "FALTA_VERIF_PED   [textoLibre=<" + textoLibre + ">]";
	}
	
	



	
	
	

}
