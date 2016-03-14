package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Tetiana_Matiunina on 09.12.2015.
 */
public class ProductsPage extends AbstractPage {

    @FindBy(xpath = ".//*[@id='page-content-wrap']//div[@class='total']/b")
    WebElement resultOfFilterData;
    private String pathToMinPriceLinkPattern = "//div[@class='group'][1]//a[contains(.,'%s')]";
    private String pathToMaxPriceLinkPattern = "//div[@class='group'][2]//a[contains(.,'%s')]";


    public ProductsPage selectMaxPrice(int max) {
        driver.findElement(By.xpath(String.format(pathToMaxPriceLinkPattern, max))).click();
        return this;
    }

    public ProductsPage selectMinPrice(int min) {
        driver.findElement(By.xpath(String.format(pathToMinPriceLinkPattern, min))).click();
        return this;
    }

    public ProductsPage selectMinPrice(String min) {
        return selectMinPrice(Integer.valueOf(min));
    }

    public ProductsPage selectMaxPrice(String min) {
        return selectMaxPrice(Integer.valueOf(min));
    }

    public String getResultOfSearch() {
        return resultOfFilterData.getText();
    }
}
