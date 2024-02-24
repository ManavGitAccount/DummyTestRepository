package Tests;

import Tests.TestComponents.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrder extends BaseTest {

    String prodName = "ZARA COAT 3";

    @Test(dataProvider="getData", groups={"Purchase"})
    public void submitOrder(HashMap<String, String> input) throws IOException {

        ProductCatalogue prodCat = landingPage.loginApplication(input.get("email"), input.get("password"));
        List<WebElement> products = prodCat.getProductList();
        prodCat.addProductToCart(input.get("product"));
        CartPage cartPage = prodCat.gotoCartPage();

        //Boolean match = cartPage.VerifyProductDisplay(prodName);
        //Assert.assertTrue(match);
        // CheckOutPage checkout = cartPage.goToCheckout();
        // checkout.selectCountry("India");
        //ConfirmationPage confirmationPage = checkout.submitOrder();
        // String confirmationMessage = confirmationPage.verifyConfirmationMessage();
        //Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }


    @Test(dependsOnMethods = {"submitOrder"})
    public void orderHistoryTest(){
        ProductCatalogue productCatalogue = landingPage.loginApplication("automtionscientist@gmail.com", "Abc123$$");
        OrderPage ordersPage = productCatalogue.gotoOrdersPage();
        Assert.assertTrue(ordersPage.VerifyOrderDisplay(prodName));
    }

    @DataProvider
    public Object[][] getData() throws IOException {
//        HashMap<String, String> map = new HashMap<>();
//        HashMap<String, String> map1 = new HashMap<>();
//
//        map.put("email", "automationscientist@gmail.com");
//        map.put("password", "Abc123$$");
//        map.put("product", "ZARA COAT 3");
//
//        map1.put("email", "manav.rattan@gmail.com");
//        map1.put("password", "Abc1234$$");
//        map1.put("product", "ADIDAS ORIGINAL");

        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//Tests//TrackData//data//PurchaseOrder.json");
        return new Object[][]{{data.get(0)}, {data.get(1)}};
    }

}
