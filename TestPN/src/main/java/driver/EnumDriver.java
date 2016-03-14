package driver;

/**
 * Created by Tetiana_Matiunina on 14.12.2015.
 */
public enum EnumDriver {

    FIREFOX("firefox"), CHROME("chrome");

    private String browserName;

    private EnumDriver(String name) {
        browserName = name;
    }

    public static EnumDriver getByName(String name) {
        if (name != null) {
            for (EnumDriver type : EnumDriver.values()) {
                if (name.equalsIgnoreCase(type.getBrowserName())) {
                    return type;
                }
            }
        }
        throw new RuntimeException("Browser type " + name + " is not supported");
    }

    public String getBrowserName() {
        return browserName;
    }
}
