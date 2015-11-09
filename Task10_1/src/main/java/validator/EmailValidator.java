package validator;

import org.apache.log4j.Logger;

import java.text.MessageFormat;

/**
 * Created by Tetiana_Matiunina on 09.11.2015.
 */
public class EmailValidator extends AbstractValidator{
    private static final Logger LOGGER = Logger.getLogger(NameValidator.class);
    public static final String ERROR_MESSAGE = "Please input valid email";
    public static final String REQUIRED_FIELD = "Required field";

    public EmailValidator(String parameterName, String parameterValue) {
        super(parameterName, parameterValue);
        LOGGER.debug("Password " + parameterName + " " + parameterValue);
    }
    @Override
    public boolean isValid() {
        LOGGER.debug("Is valid " + getParameterValue()+ " " + getParameterValue().length());
        LOGGER.debug((!getParameterValue().isEmpty())||(getParameterValue().length()>=2));
        return ((!getParameterValue().isEmpty())&&(isValidEmailAddress(getParameterValue())));
    }
    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    @Override
    public String getError() {
        if(getParameterValue().isEmpty()){
            return REQUIRED_FIELD;
        }
        return ERROR_MESSAGE;
    }
}
