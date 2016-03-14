package driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Tetiana_Matiunina on 02.12.2015.
 */
public class DriverFactory {

    private static WebDriver webDriver;
    private static final Logger LOGGER = Logger.getLogger(DriverFactory.class);
    private static final String DEFAULT_WEB_DRIVER_PATH = "src/main/resources/drivers/chromedriver.exe";
    private static String webDriverName = System.getProperty("driver", EnumDriver.FIREFOX.getBrowserName());

    private static void createDriver() {
        EnumDriver driverType = EnumDriver.getByName(webDriverName);
        switch (driverType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", getDriverPath());
                webDriver = new ChromeDriver();
                break;
            default:
                webDriver = new FirefoxDriver();
                break;
        }
    }

    private static String getDriverPath() {
        return System.getProperty("driver.path", DEFAULT_WEB_DRIVER_PATH);
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            createDriver();
            LOGGER.info(webDriverName + " initialized");
        }
        return webDriver;
    }


}