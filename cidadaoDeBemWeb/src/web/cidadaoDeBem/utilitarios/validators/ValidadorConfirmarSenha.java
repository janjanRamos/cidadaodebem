package web.cidadaoDeBem.utilitarios.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "validadorConfirmarSenha")
public class ValidadorConfirmarSenha implements Validator {

	public static boolean compararSenhas(String confirmaSenha, String senha) {
		if (!confirmaSenha.equals(senha))
			return false;
		return true;
	}

	@Override
	public void validate(FacesContext context, UIComponent toValidate,
			Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		String senha = (String) toValidate.getAttributes().get("senha");
		String confirmaSenha = (String) value;
		if (!compararSenhas(confirmaSenha, senha)) {
			((UIInput) toValidate).setValid(false);
			throw new ValidatorException(new FacesMessage());
		}

	}

}
