package validator;

import org.apache.log4j.Logger;

import java.text.MessageFormat;

/**
 * Created by Tetiana_Matiunina on 09.11.2015.
 */
public class NameValidator extends AbstractValidator{
    private static final Logger LOGGER = Logger.getLogger(NameValidator.class);
    public static final String ERROR_MESSAGE = "{0} should be at least 2 chars";

    public NameValidator(String parameterName, String parameterValue) {
        super(parameterName, parameterValue);
        LOGGER.debug("Password " + parameterName + " " + parameterValue);
    }
    @Override
    public boolean isValid() {
        LOGGER.debug("Is valid " + getParameterValue()+ " " + getParameterValue().length());
        LOGGER.debug("NAME "+ ((!getParameterValue().isEmpty())||(getParameterValue().length()>=2)));
        return ((!getParameterValue().isEmpty())&&(getParameterValue().length()>=2));
    }

    @Override
    public String getError() {
        return MessageFormat.format(ERROR_MESSAGE, getParameterName());
    }
}
