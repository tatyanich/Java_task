import org.testng.annotations.Test;
import pages.ProductsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Tetiana_Matiunina on 09.12.2015.
 */
public class TestPnSite extends BaseTest {

    @Test(dataProvider = "priceData")
    public void shouldOpenCategory(String category, String expectedUrl) {
        mainPage.goToPnUAMainPage().selectCategory(category);
        assertThat(categoryPage.getCurrentUrl(), equalTo(expectedUrl));
    }

    @Test(dataProvider = "priceData")
    public void shouldSelectProduct(String category, String subCategory, String minPrice, String maxPrice, String amountOfProducts) {
        ProductsPage productsPage = mainPage.goToPnUAMainPage().selectCategory(category).selectCategoryOfProducts(subCategory)
                .selectMinPrice(minPrice).selectMaxPrice(maxPrice);
        assertThat(productsPage.getResultOfSearch(), equalTo(amountOfProducts));
    }

    @Test(dataProvider = "priceData")
    public void shouldSelectProdUseDataProvider(String category, String subCategory, String minPrice, String maxPrice, String amountOfProducts) {
        ProductsPage productsPage = mainPage.goToPnUAMainPage().selectCategory(category).selectCategoryOfProducts(subCategory)
                .selectMinPrice(minPrice).selectMaxPrice(maxPrice);
        assertThat(productsPage.getResultOfSearch(), equalTo(amountOfProducts));
    }


}
