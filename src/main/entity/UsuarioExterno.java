package main.entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: UsuarioExterno
 *
 */
@Entity
@Table(name = "usuario_externo")

public class UsuarioExterno implements Serializable {

	@Id
	private String nu_cpf;
	private String no_usuario;
	private String de_email;
	private String ic_situacao;
	private Integer ic_perfil_acesso;
	private Integer co_funcao;
	private String nu_telefone;
	private static final long serialVersionUID = 1L;

	public String getNu_cpf() {
		return this.nu_cpf;
	}

	public void setNu_cpf(String nu_cpf) {
		this.nu_cpf = nu_cpf;
	}

	public String getNo_usuario() {
		return this.no_usuario;
	}

	public void setNo_usuario(String no_usuario) {
		this.no_usuario = no_usuario;
	}

	public String getDe_email() {
		return this.de_email;
	}

	public void setDe_email(String de_email) {
		this.de_email = de_email;
	}

	public String getIc_situacao() {
		return this.ic_situacao;
	}

	public void setIc_situacao(String ic_situacao) {
		this.ic_situacao = ic_situacao;
	}

	public Integer getIc_perfil_acesso() {
		return this.ic_perfil_acesso;
	}

	public void setIc_perfil_acesso(Integer ic_perfil_acesso) {
		this.ic_perfil_acesso = ic_perfil_acesso;
	}

	public Integer getCo_funcao() {
		return this.co_funcao;
	}

	public void setCo_funcao(Integer co_funcao) {
		this.co_funcao = co_funcao;
	}

	public String getNu_telefone() {
		return this.nu_telefone;
	}

	public void setNu_telefone(String nu_telefone) {
		this.nu_telefone = nu_telefone;
	}

}
