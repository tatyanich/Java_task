package validator;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.text.MessageFormat;

/**
 * Created by Tetiana_Matiunina on 08.11.2015.
 */
public class ConfirmPasswordValidator extends AbstractValidator {
    public static final String ERROR_MESSAGE = "{0} and password doesn't match";
    private static final Logger LOGGER = Logger.getLogger(PasswordValidator.class);
    private String password;

    public ConfirmPasswordValidator(String parameterName, String parameterValue,String password) {
        super(parameterName, parameterValue);
        this.password = password;
        LOGGER.debug("Confirm " + parameterName + " " + parameterValue+"  "+ password);
    }
    @Override
    public boolean isValid() {
        return getParameterValue().equals(password);
    }

    @Override
    public String getError() {
        return MessageFormat.format(ERROR_MESSAGE, getParameterName());
    }
}
