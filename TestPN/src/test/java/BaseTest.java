import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import pages.CategoryPage;
import pages.MainPage;
import utils.ExcelReader;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by Tetiana_Matiunina on 09.12.2015.
 */
public abstract class BaseTest {

    protected MainPage mainPage;
    protected CategoryPage categoryPage;
    private static final Logger LOGGER = Logger.getLogger(BaseTest.class);

    @BeforeClass
    public void beforeClass() {
        mainPage = new MainPage();
        categoryPage = new CategoryPage();
    }

    @AfterClass
    public void afterClass() {
        mainPage.closeWebDriver();
    }

    @DataProvider(name = "priceData")
    public Object[][] getData(Method testMethodName) {
        String sheetName = testMethodName.getName();
        String filename = "src/test/resources/pnCom.xlsx";
        Object[][] testObjArray = null;
        try {
            testObjArray = ExcelReader.excelRead(filename, sheetName);
        } catch (IOException e) {
            LOGGER.error("Couldn't read excel file. Error message: " + e.getMessage(), e);
        }

        if (testObjArray == null) {
            throw new IllegalArgumentException("Test data wasn't found on sheet with name " + sheetName
                    + " or test data is corrupted. Please review data in " + filename + " file.");
        }
        return testObjArray;
    }
}
