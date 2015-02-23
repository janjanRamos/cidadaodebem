package web.cidadaoDeBem.validators.utilitarios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "validarSenha")
public class ValidarSenha implements Validator {

	public static boolean senhaValida(String senha) {
		Pattern pattern = Pattern
				.compile("^(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
		Matcher pesquisa = pattern.matcher(senha);
		if (!pesquisa.matches())
			return false;
		return true;
	}

	@Override
	public void validate(FacesContext context, UIComponent toValidate,
			Object value) throws ValidatorException {
		String senha = (String) value;
		// TODO Auto-generated method stub

		if (!senhaValida(senha)) {
			((UIInput) toValidate).setValid(false);
			throw new ValidatorException(new FacesMessage());
		}

	}
}
