package main;

public class AlarmMsg {
	
	private String msgType;
	
	private Object parameters;
	
	public AlarmMsg(String msgType, Object parameters) {
		this.msgType = msgType;
		this.parameters = parameters;
	}

	public String getMsgType() {
		return msgType;
	}

	public Object getParameters() {
		return parameters;
	}

}
