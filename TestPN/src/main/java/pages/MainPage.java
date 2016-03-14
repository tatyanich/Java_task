package pages;

import org.openqa.selenium.By;


/**
 * Created by Tetiana_Matiunina on 09.12.2015.
 */
public class MainPage extends AbstractPage {

    public static final String URL = "http://pn.com.ua/";
    private String pathToCategoryLinkPattern = "//a[contains(.,'%s')]";

    public MainPage() {
        driver.manage().window().maximize();
    }

    public MainPage goToPnUAMainPage() {
        driver.get(URL);
        return this;
    }

    public CategoryPage selectCategory(String string) {
        driver.findElement(By.xpath(String.format(pathToCategoryLinkPattern, string))).click();
        return new CategoryPage();
    }


}
