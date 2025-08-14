package Framework.PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class Wb05_SearchResultPage {

    WebDriver ldriver;

    public Wb05_SearchResultPage(WebDriver rdriver) {
        ldriver = rdriver;

        PageFactory.initElements(rdriver, this);
    }

    // WebElement SearchResult;
    @FindBy(xpath = "//div[@class='features_items']")
    WebElement SearchResult;

    @FindBy(xpath = "//a[text()='Add to cart']")
    WebElement hoveronAdtcart;

    // View Product Element
    @FindBy(xpath = "//a[text()='View Product' and contains(@href,'/product_details/33')]")   // //ul[@class='nav nav-pills nav-justified']//a[@href='/product_details/33']
            WebElement ViewProductBtn;

//    // Change Quantity Element
//    @FindBy(id = "quantity")
//    WebElement ChangeQuantity;
//
//    // Click on Add TO Cart Button Element
//    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
//    WebElement AddTOCartBtn;
//
//    // Confirmation Pop-up Element
//    @FindBy(xpath = "//button[text()='Continue Shopping']")
//    WebElement ConfirmationPop_up;
//
//    // Click on Cart option Element
//    @FindBy(xpath = "//a[text()=' Cart']")
//    WebElement CartOption;


    public String SearchResultProductName() {
        return (SearchResult.getText());
    }

    public void hoverOnAddToCart() {
        ((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", hoveronAdtcart);
        Actions act = new Actions(ldriver);
        act.moveToElement(hoveronAdtcart).pause(Duration.ofSeconds(1)).perform();
    }

    public void ClickOnViewProduct() {
        try {
            if (ViewProductBtn.isEnabled()) {
                ViewProductBtn.click();
                System.out.println("View button is clickable");
            } else {
                System.out.println("Not clicking on view button");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


//    public void ClickOnQuantity(){
//        ChangeQuantity.click();
//        ChangeQuantity.sendKeys(Keys.BACK_SPACE);
//        ChangeQuantity.sendKeys("2");
//    }
//
//    public void ClickOnAddToCartButton(){
//        AddTOCartBtn.click();
//    }
//
//    public void ClickOnPop_up(){
//        ConfirmationPop_up.click();
//    }
//
//    public void ClickOnCartLink(){
//        CartOption.click();
//    }
}
