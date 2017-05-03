package main.enums;

public enum MsgSistemaEnum {
	MN001("Cadastro efetuado com sucesso!"),
	MN005("Exclus�o efetuada com sucesso."),
	MN030("Altera��o efetuada com sucesso!"),
	MN031("Deseja realmente excluir o usu�rio "),
	MN032("Usu�rio desabilitado com sucesso!"),
	MN033("Usu�rio habilitado com sucesso!"),
	MN034("Opera��o n�o realizada. Usu�rio j� inclu�do."),
	MN035("Opera��o n�o realizada. CPF digitado � inv�lido.");
	
	private final String msg;
	
	MsgSistemaEnum(String dsMsg){
		msg = dsMsg;
	}
	
	public String getMsg() {
		return msg;
	}
}
