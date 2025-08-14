package Framework.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wb07_CartPage {

    WebDriver ldriver;

    public Wb07_CartPage(WebDriver rdriver) {
        ldriver = rdriver;

        PageFactory.initElements(rdriver, this);
    }

    // Product Quantity Element
    @FindBy(xpath = "//button[@class='disabled']")
    WebElement ProductQnty;

    // Proceed To Checkout button Element
    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    WebElement Checkoutbtn;

    // Place order button element
    @FindBy(xpath = "//a[text()='Place Order' and @class='btn btn-default check_out']")
    WebElement placeOrderbtn;

    // Card Details Element
    // Name of card
    @FindBy(name = "name_on_card")
    WebElement Cname;

    // Card Number
    @FindBy(name = "card_number")
    WebElement Cnumber;

    // CVC number
    @FindBy(name = "cvc")
    WebElement CVCnumber;

    // Expiry Month & Year
    @FindBy(name = "expiry_month")
    WebElement month;

    @FindBy(name = "expiry_year")
    WebElement Year;

    // Pay and confirm order
    @FindBy(id = "submit")
    WebElement submitbtn;

    // success message
    @FindBy(xpath = "//p[text()='Congratulations! Your order has been confirmed!']")
    WebElement SSmessage;


    // Verify Product Quantity
    public String ProQuantity() {
       return (ProductQnty.getText());
    }

    // click on Place order
    public void ClickOnCheckOutBtn() {
        Checkoutbtn.click();
    }

    // Verify Product Quantity
    public void ClickOnPlaceOrder() {
        placeOrderbtn.click();
    }

    // Enter Cart name
    public void EnterCartName(String Cartname) {
        Cname.sendKeys(Cartname);
    }

    // Enter Cart Number
    public void EnterCartNumber(String CartNum) {
        Cnumber.sendKeys(CartNum);
    }

    // Enter CVC Number
    public void EnterCVC(String CVC) {
        CVCnumber.sendKeys(CVC);
    }

    // Enter month
    public void EnterMonth(String monthname) {
        month.sendKeys(monthname);
    }

    // Enter Year
    public void EnterYear(String Yearname) {
        Year.sendKeys(Yearname);
    }

    // Click on Pay and confirm order
    public void ClickOnSubmit() {
        submitbtn.click();
    }

    // Order place message
    public String OrderPlaceMessage(){
        return (SSmessage.getText());
    }

}
