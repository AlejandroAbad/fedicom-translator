package es.hefame.feditrans.fedicom2.messages.m10;

import es.hefame.feditrans.fedicom2.messages.MessageType;

public class F2Message_1020 extends F2Message_LinPed{

	
	public F2Message_1020(String data, int version) {
		super(data, version, MessageType.LINEA_PEDIDO);

		int idx= 21;
		
		if (version == 2)
			try {
				texto = data.substring(idx, idx+=50);
			} catch (IndexOutOfBoundsException e) {
				// Hay tramas Fedicom v2 que no traen el hueco del texto. Se ignora.
				texto = "";
			}
	}


	@Override
	public String toString() {
		if (version == 2)
			return super.toString()  + " [codArti=<" + codArti + ">, cantidad=<" + cantidad + ">, texto=<" + texto + ">]";
		return super.toString()  + " [codArti=<" + codArti + ">, cantidad=<" + cantidad + ">]";
	}




	

	
	
	

}
