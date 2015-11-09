package validator;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidatorContext {
    private List<AbstractValidator> validators;

    public ValidatorContext() {
        validators = new ArrayList<>();
    }

    public ValidatorContext addPasswordValidator(String parameterName, String parameterValue) {
        validators.add(new PasswordValidator(parameterName, parameterValue));
        return this;
    }

    public ValidatorContext addConfirmPasswordValidator(String parameterName, String parameterValue, String password) {
        validators.add(new ConfirmPasswordValidator(parameterName, parameterValue, password));
        return this;
    }
    public ValidatorContext addNameValidator(String parameterName, String parameterValue){
        validators.add(new NameValidator(parameterName, parameterValue));
        return this;
    }
    public ValidatorContext addEmailValidator(String parameterName, String parameterValue){
        validators.add(new EmailValidator(parameterName, parameterValue));
        return this;
    }
    public ValidatorContext addLoginValidator(String parameterName, String parameterValue){
        validators.add(new LoginValidator(parameterName, parameterValue));
        return this;
    }

    public Map<String, String> validate() {
        Map<String, String> errors = new HashMap<>();
        for (AbstractValidator validator : validators) {
            if (!validator.isValid()) {
                errors.put(validator.getParameterName(), validator.getError());
            }
        }
        return errors;
    }
}
