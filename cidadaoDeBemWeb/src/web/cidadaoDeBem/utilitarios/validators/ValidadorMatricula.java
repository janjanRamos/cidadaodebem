package web.cidadaoDeBem.utilitarios.validators;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import cidadaoDeBem.ejb.facade.PolicialFacade;

//não está funcionando
@FacesValidator(value = "validadorMatricula")
public class ValidadorMatricula implements Validator {

	@EJB
	private PolicialFacade policialFacade;

	public boolean validarMatricula(String matricula) {
		if (!this.policialFacade.BuscarPolicial(null, matricula).isEmpty())
			return false;
		return true;
	}

	@Override
	public void validate(FacesContext context, UIComponent toValidate,
			Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		String matricula = String.valueOf(value);
		if (!validarMatricula(matricula)) {
			((UIInput) toValidate).setValid(false);
			throw new ValidatorException(new FacesMessage(
					"Matricula já cadastrada."));
		}

	}

}
