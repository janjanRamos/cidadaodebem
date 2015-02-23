package web.cidadaoDeBem.controller;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.springframework.util.DigestUtils;

import cidadaoDeBem.ejb.facade.PolicialFacade;
import cidadaoDeBem.ejb.modelo.Policial;

@ManagedBean
@RequestScoped
public class PolicialMB implements Validator {

	private String senha;
	private String confirmarSenha;
	private Policial policial;

	@EJB
	private PolicialFacade policialFacade;

	public Policial getPolicial() {
		if (policial == null)
			policial = new Policial();
		return policial;
	}

	public void setPolicial(Policial policial) {
		this.policial = policial;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public String salvarPolicial() {
		String senhaCripto = DigestUtils.md5DigestAsHex(senha.getBytes());
		this.policial.setSenha(senhaCripto);
		this.policial.getPermissao().add("ROLE_POLICIAL");

		// if (!policialFacade.BuscarPolicial(null,
		// this.policial.getMatricula())
		// .isEmpty()) {
		// FacesContext context = FacesContext.getCurrentInstance();
		// FacesMessage message = new FacesMessage("Matricula já cadastrada");
		// context.addMessage(null, message);
		// return null;
		//
		// }

		policialFacade.salvarPolicial(policial);
		this.policial = null;
		return null;
	}

	@Override
	public void validate(FacesContext context, UIComponent toValidate,
			Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		String matricula = (String) value;
		if (!existMatricula(matricula)) {
			((UIInput) toValidate).setValid(false);
			throw new ValidatorException(new FacesMessage(
					"Matricula já cadastrada."));

		}

		if (matricula.length() < 4 || matricula.length() > 12) {
			((UIInput) toValidate).setValid(false);
			throw new ValidatorException(
					new FacesMessage(
							"Matricula deve conter no mínimo 4 e no máximo 12 algarismos."));

		}

		if (!matricula.matches("[0-9]+")) { // regex digitos de 0 a 9
			// converte para inteiro
			((UIInput) toValidate).setValid(false);
			throw new ValidatorException(new FacesMessage(
					"Campo aceita somente números."));
		}

	}

	// método testa se já existe matricula cadastrada no banco de mesmo valor
	public boolean existMatricula(String matricula) {
		if (!policialFacade.BuscarPolicial(null, matricula).isEmpty())
			return false;
		return true;

	}
}
