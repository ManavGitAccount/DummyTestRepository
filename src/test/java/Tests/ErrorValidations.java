package Tests;

import Tests.TestComponents.BaseTest;
import Tests.TestComponents.Retry;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.ProductCatalogue;

import java.io.IOException;
import java.util.List;

public class ErrorValidations extends BaseTest {

    @Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
    public void submitOrder() throws IOException {

        String prodName = "ZARA COAT 3";
        landingPage.loginApplication("automationscientist@gmail.com", "Ab23$$");
        Assert.assertEquals("Incorrect email or password." , landingPage.getErrorMessage());
    }

    @Test
    public void ProductErrorValidation() throws IOException {

        String prodName = "ZARA COAT 3";
        ProductCatalogue prodCat = landingPage.loginApplication("automationscientist@gmail.com", "Abc123$$");
        List<WebElement> products = prodCat.getProductList();
        prodCat.addProductToCart(prodName);
        CartPage cartPage = prodCat.gotoCartPage();
        Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 13");
        Assert.assertFalse(match);
    }
}
