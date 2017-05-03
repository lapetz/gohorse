package main.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UsuarioExternoService {
	protected EntityManager em;

	public UsuarioExternoService(EntityManager em) {
		this.em = em;
	}

	public UsuarioExterno create(String nu_cpf, String no_usuario, String de_email, String ic_situacao,
			Integer ic_perfil_acesso, Integer co_funcao, String nu_telefone) {
		UsuarioExterno ue = new UsuarioExterno();
		ue.setNu_cpf(nu_cpf);
		ue.setNo_usuario(no_usuario);
		ue.setDe_email(de_email);
		ue.setIc_situacao(ic_situacao);
		ue.setIc_perfil_acesso(ic_perfil_acesso);
		ue.setCo_funcao(co_funcao);
		ue.setNu_telefone(nu_telefone);
		return ue;
	}

	public UsuarioExterno findUsuario(String id) {
		return em.find(UsuarioExterno.class, id);
	}

	public void removeUsuario(String id) {
		UsuarioExterno emp = findUsuario(id);
		if (emp != null) {
			em.remove(emp);
		}
	}

	public List<UsuarioExterno> findAllUsuarios() {
		Query query = em.createQuery("SELECT x FROM UsuarioExterno x");
		return (List<UsuarioExterno>) query.getResultList();
	}
}
