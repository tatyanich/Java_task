package pages;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Tetiana_Matiunina on 09.12.2015.
 */
public abstract class AbstractPage {

    protected WebDriver driver = DriverFactory.getWebDriver();
    protected Wait wait;
    private static final int WAIT_TIME = 10;

    public AbstractPage() {
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, WAIT_TIME);
        PageFactory.initElements(driver, this);
    }

    public void closeWebDriver() {
        driver.close();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}

