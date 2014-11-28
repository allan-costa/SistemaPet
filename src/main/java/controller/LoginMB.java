package controller;



import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import model.Usuario;

public class LoginMB {

	private Usuario usuario = new Usuario();
	
	// Método chamado no começo da página para verificar se o usuário já realizou login
	public void verificaLogin(ComponentSystemEvent event) {
		if (usuario.getLogin() == null) {
			
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("login.jsf");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}
	
	public void logout() {
		try {
			usuario.setLogin(null);
			FacesContext.getCurrentInstance().getExternalContext().redirect("login.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void doEfetuarLogin() {
		if ("admin".equals(usuario.getLogin()) && "123".equals(usuario.getSenha())) {
			
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	      FacesMessage msg = new FacesMessage("Usuário ou senha inválido!");

	      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
	      FacesContext.getCurrentInstance().addMessage("erro", msg);


	}

	public Usuario getUsuario() {
		return usuario;

	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}