/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.login;


import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


/**
 *
 * @author asathor
 */
@FacesValidator("rutValidator")
public class ValidadorRut implements Validator {

    // Variables locales.
    public ValidadorRut() {
    }


    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            return;
        }

        if (((String) value).length() < 3) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de validación",
                    value + " debe tener una cantidad de al menos 3 carácteres, favor ingrese un rut válido."));
        }
        if (((String) value).length() > 10) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de validación",
                    value + " debe tener una cantidad hasta 10 carácteres, favor ingrese un rut válido."));
        }
    }


    public Map<String, Object> getMetadata() {
        return null;
    }


    public String getValidatorId() {
        return "emailValidator";
    }


}
