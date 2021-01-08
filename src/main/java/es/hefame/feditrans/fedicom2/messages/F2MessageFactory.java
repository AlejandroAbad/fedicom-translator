package es.hefame.feditrans.fedicom2.messages;

import es.hefame.feditrans.fedicom2.messages.m01.*;
import es.hefame.feditrans.fedicom2.messages.m10.*;
import es.hefame.feditrans.fedicom2.messages.m20.*;
import es.hefame.feditrans.fedicom2.messages.m30.*;
import es.hefame.feditrans.fedicom2.messages.m99.*;

public class F2MessageFactory {

	public static F2Message parse(String data, int version) {

		String type = data.substring(0, 4);
		
		if (type.equals("0101")) return new F2Message_0101(data, version);
		if (type.equals("0102")) return new F2Message_0101(data, version);
		if (type.equals("0199")) return new F2Message_0199(data, version);
		
		if (type.equals("1010")) return new F2Message_1010(data, version);
		if (type.equals("1020")) return new F2Message_1020(data, version);
		if (type.equals("1030")) return new F2Message_1030(data, version);
		if (type.equals("1040")) return new F2Message_1040(data, version);
		if (type.equals("1050")) return new F2Message_1050(data, version);
		
		if (type.equals("2010")) return new F2Message_2010(data, version);
		if (type.equals("2011")) return new F2Message_2011(data, version);
		if (type.equals("2015")) return new F2Message_2015(data, version);
		if (type.equals("2016")) return new F2Message_2016(data, version);
		if (type.equals("2020")) return new F2Message_2020(data, version);
		if (type.equals("2021")) return new F2Message_2021(data, version);
		if (type.equals("2025")) return new F2Message_2025(data, version);
		if (type.equals("2030")) return new F2Message_2030(data, version);
		
		if (type.equals("3010")) return new F2Message_3010(data, version);
		if (type.equals("3020")) return new F2Message_3020(data, version);
		if (type.equals("3040")) return new F2Message_3040(data, version);
		
		if (type.equals("9999")) return new F2Message_9999(data, version);
		
		
		
		return new F2Message(data, version, MessageType.DESCONOCIDO);
		
	}
	
	
	

}
