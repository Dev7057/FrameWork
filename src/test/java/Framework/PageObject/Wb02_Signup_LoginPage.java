package Framework.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wb02_Signup_LoginPage {

    // Create an object of Webdriver
    WebDriver ldriver;

    // Constructor
    public Wb02_Signup_LoginPage(WebDriver rdriver) {

        ldriver = rdriver;

        PageFactory.initElements(rdriver, this);
    }

    // Identify Elements for signup
    @FindBy(name = "name")
    WebElement Name;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement EnterEamil;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement sinupBtn;


    // Identify Element For login
    @FindBy(name = "email")
    WebElement EmailID;

    @FindBy(name = "password")
    WebElement loginPass;

    @FindBy(xpath = "//button[text()='Login']")
    WebElement loginbtn;


    // SignUp Action
    public void EnterName(String UName) {
        Name.sendKeys(UName);
    }

    public void EnterEmailID(String Email) {
        EnterEamil.sendKeys(Email);
    }

    public void SignupButton() {
        sinupBtn.click();
    }


   // Login Action
    public void EnterLoginEmail(String LgEmailId) {
        EmailID.sendKeys(LgEmailId);
    }

     public void EnterLoginPassword(String LgPass) {
         loginPass.sendKeys(LgPass);
    }
     public void ClickOnLoginButton() {
         loginbtn.click();
    }
}
