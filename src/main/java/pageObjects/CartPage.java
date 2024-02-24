package pageObjects;

import AbsComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponent {

    WebDriver driver;

    @FindBy(css=".totalRow button")
    WebElement checkOutElm;

    @FindBy(css=".cartSection h3")
    private List<WebElement> productTitles;


    public CartPage( WebDriver driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public Boolean VerifyProductDisplay(String productName){
        Boolean match = productTitles.stream().anyMatch(p -> p.getText().equalsIgnoreCase(productName));
        return match;
    }

    public CheckOutPage goToCheckout(){
        checkOutElm.click();
        return new CheckOutPage(driver);
    }
}
