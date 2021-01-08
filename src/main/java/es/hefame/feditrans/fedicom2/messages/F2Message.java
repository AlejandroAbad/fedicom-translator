package es.hefame.feditrans.fedicom2.messages;

public class F2Message {
	
	protected String original;
	protected int version;
	protected MessageType type;

	public F2Message(String data, int version, MessageType type) {
		this.original = data;
		this.version = version;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.type.name() + " V" + version;
	}
	

}
