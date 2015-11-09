package validator;

public abstract class AbstractValidator implements IValidator {
    private  String parameterName = "";
    private  String parameterValue="";

    public String getParameterName() {
        return parameterName;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public AbstractValidator(String parameterName, String parameterValue) {
        this.parameterName = parameterName;
        this.parameterValue = parameterValue;
    }

}