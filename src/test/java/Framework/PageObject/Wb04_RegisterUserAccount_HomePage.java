package Framework.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wb04_RegisterUserAccount_HomePage {

    WebDriver ldriver;

   public Wb04_RegisterUserAccount_HomePage(WebDriver rdriver){
        ldriver= rdriver;

        PageFactory.initElements(rdriver, this);
    }

    // Identify login user name element
    @FindBy(xpath = "//b[text()='Viru']")
    WebElement LoginUser;

    // sign out Element
   @FindBy(xpath ="//a[text()=' Logout']")
   WebElement SignOut;

   // Product Page link Element
   @FindBy(xpath = "//a[text()=' Products']")
   WebElement ProductPageLink;

   // Search Box Element
   @FindBy(id = "search_product")
   WebElement SearchBox;

   // click on Search button Element
   @FindBy(id = "submit_search")
   WebElement SearchBtn;



   // Action On above Find out elements
    public String verifyname(){

        String text= LoginUser.getText();

        return text;
    }
    public void logout(){
        SignOut.click();
    }

    public void ClickOnProductLink(){
        ProductPageLink.click();
    }

    public void SearchBar(String search){
        SearchBox.sendKeys(search);
    }

    public void ClickOnSearchButton(){
        SearchBtn.click();
    }

}

