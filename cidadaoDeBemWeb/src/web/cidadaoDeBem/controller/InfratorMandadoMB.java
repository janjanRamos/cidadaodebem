package web.cidadaoDeBem.controller;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class InfratorMandadoMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Conversation conversation;

	private String teste;

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}

	public String iniciarConversacao() {
		conversation.begin();
		return "/protect/policial/cadastro_mandato.xhtml?faces-redirect=true";
	}

	public String navegarConversacao() {

		if (conversation.isTransient())
			return null;

		return "/protect/policial/cadastro_mandato.xhtml?faces-redirect=true";
	}
}
