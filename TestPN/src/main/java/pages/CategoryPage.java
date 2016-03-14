package pages;

import org.openqa.selenium.By;

/**
 * Created by Tetiana_Matiunina on 09.12.2015.
 */
public class CategoryPage extends AbstractPage {

    private String pathToProductLinkPattern = "//a[contains(.,'%s')]";

    public ProductsPage selectCategoryOfProducts(String product) {
        driver.findElement(By.xpath(String.format(pathToProductLinkPattern, product))).click();
        return new ProductsPage();
    }


}
