package main.enums;

public enum MsgSistemaEnum {
	MN001("Cadastro efetuado com sucesso!"),
	MN005("Exclusão efetuada com sucesso."),
	MN030("Alteração efetuada com sucesso!"),
	MN031("Deseja realmente excluir o usuário "),
	MN032("Usuário desabilitado com sucesso!"),
	MN033("Usuário habilitado com sucesso!"),
	MN034("Operação não realizada. Usuário já incluído."),
	MN035("Operação não realizada. CPF digitado é inválido.");
	
	private final String msg;
	
	MsgSistemaEnum(String dsMsg){
		msg = dsMsg;
	}
	
	public String getMsg() {
		return msg;
	}
}
