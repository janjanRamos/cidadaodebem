package web.cidadaoDeBem.utilitarios.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "validadorMandado")
public class ValidadorMandado implements Validator {

	protected boolean verificarSomenteNumeros(String numeroMandado) {
		if (!numeroMandado.matches("[0-9]+"))
			return false;
		return true;
	}

	@Override
	public void validate(FacesContext context, UIComponent toValidate,
			Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		String numeroMandado = (String) value;
		if (!this.verificarSomenteNumeros(numeroMandado)) {
			((UIInput) toValidate).setValid(false);
			throw new ValidatorException(new FacesMessage(
					"Campo aceita somente números."));
		}

	}

}
