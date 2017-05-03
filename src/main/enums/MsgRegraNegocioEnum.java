package main.enums;

public enum MsgRegraNegocioEnum {
	RN012("N�o poder� ser inclu�do um usu�rio com o mesmo CPF que outro.");

	private final String msg;
	
	MsgRegraNegocioEnum(String dsMsg){
		msg = dsMsg;
	}
	
	public String getMsg() {
		return msg;
	}
}
