package main.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import main.entity.UsuarioExterno;
import main.entity.UsuarioExternoService;
import main.enums.MsgSistemaEnum;
import main.tool.ValidaCPF;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource
	private UserTransaction ut;

	@PersistenceContext
	private EntityManager em;

	private Writer w;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cpf = request.getParameter("cpf");

		if (!validaCPF(cpf)) {
			w = response.getWriter();
			w.append(MsgSistemaEnum.MN035.getMsg());
		} else if (verificaDuplicidade(cpf)) {
			w = response.getWriter();
			w.append(MsgSistemaEnum.MN034.getMsg());
		} else {
			doInsert(request, response);
		}
	}

	/**
	 * Verifica CPF duplicado
	 * 
	 * @return true se a PK já existe
	 */
	private Boolean verificaDuplicidade(String PK) {
		try {
			UsuarioExternoService ues = new UsuarioExternoService(em);
			if (ues.findUsuario(PK) != null) {
				return true;
			} else {
				return false;
			}
		} catch (PersistenceException e) {
			return false;
		}
	}

	private Boolean validaCPF(String CPF) {
		return ValidaCPF.isValidSsn(CPF);
	}

	private void doInsert(HttpServletRequest request, HttpServletResponse response) {
		try {
			UsuarioExterno ue = new UsuarioExternoService(em).create(request.getParameter("cpf"),
					request.getParameter("nome"), request.getParameter("email"), request.getParameter("situacao"),
					request.getParameter("perfil") != null ? Integer.parseInt(request.getParameter("perfil")) : null,
					request.getParameter("funcao") != null ? Integer.parseInt(request.getParameter("funcao")) : null,
					request.getParameter("telefone"));

			ut.begin();
			em.persist(ue);
			ut.commit();
			
			w = response.getWriter();
			w.append(MsgSistemaEnum.MN001.getMsg());
			
		} catch (NotSupportedException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (RollbackException e) {
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
