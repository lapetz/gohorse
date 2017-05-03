package main.enums;

public enum MsgRegraNegocioEnum {
	RN012("Não poderá ser incluído um usuário com o mesmo CPF que outro.");

	private final String msg;
	
	MsgRegraNegocioEnum(String dsMsg){
		msg = dsMsg;
	}
	
	public String getMsg() {
		return msg;
	}
}
