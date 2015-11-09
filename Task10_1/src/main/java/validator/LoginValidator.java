package validator;

import org.apache.log4j.Logger;

import java.text.MessageFormat;

/**
 * Created by Tetiana_Matiunina on 09.11.2015.
 */
public class LoginValidator extends AbstractValidator {
    private static final Logger LOGGER = Logger.getLogger(LoginValidator.class);
    public static final String REQUIRED_FIELD = "Required field";
    public static final String VALID_CHARACTER = "Use only numbers, alphabetic and _ characters";
    public static final String ERROR_MESSAGE = "{0} should be at least 6 chars";

    public LoginValidator(String parameterName, String parameterValue) {
        super(parameterName, parameterValue);
        LOGGER.debug("Password " + parameterName + " " + parameterValue);
    }
    @Override
    public boolean isValid() {
        LOGGER.debug("Is valid " + getParameterValue()+ " " + getParameterValue().length());
        LOGGER.debug((!getParameterValue().isEmpty())||(getParameterValue().length()<=6));
        return ((!getParameterValue().isEmpty())&&(getParameterValue().length()>=6));
    }

    public boolean isValidLogin(String login) {
        String pattern = "^[a-z0-9_-]$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(pattern);
        java.util.regex.Matcher m = p.matcher(login);
        return m.matches();
    }

    @Override
    public String getError() {
        if(getParameterValue().isEmpty()){
            return REQUIRED_FIELD;
        }
        if(getParameterName().length()<=6){
            return MessageFormat.format(ERROR_MESSAGE, getParameterName());
        }
        return VALID_CHARACTER;
    }
}
