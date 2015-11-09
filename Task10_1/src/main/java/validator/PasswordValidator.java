package validator;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.text.MessageFormat;

/**
 * Created by Администратор on 08.11.2015.
 */
public class PasswordValidator extends AbstractValidator {
    private static final Logger LOGGER = Logger.getLogger(PasswordValidator.class);
    public static final String REQUIRED_FIELD = "Required field";
    public static final String ERROR_MESSAGE = "{0} should be at least 8 chars";

    public PasswordValidator(String parameterName, String parameterValue) {
        super(parameterName, parameterValue);
        LOGGER.debug("Password " + parameterName + " " + parameterValue);
    }
    @Override
    public boolean isValid() {
        LOGGER.debug("Is valid " + getParameterValue()+ " " + getParameterValue().length());
        LOGGER.debug("Password"+((!getParameterValue().isEmpty())&&(getParameterValue().length()<=8)));
        return ((!getParameterValue().isEmpty())&&(getParameterValue().length()>=8));
    }

    @Override
    public String getError() {
        if (getParameterValue().isEmpty()) {
            return REQUIRED_FIELD;
        }

        return MessageFormat.format(ERROR_MESSAGE, getParameterName());

    }
}
