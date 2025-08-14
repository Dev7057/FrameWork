package Framework.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wb01_HomePage {

    // Create an object of Webdriver
    WebDriver ldriver;  // Local driver ldriver

    // Constructor
    public Wb01_HomePage(WebDriver rdriver) { // Remote driver rdriver

        ldriver = rdriver;

        PageFactory.initElements(rdriver, this);
    }

    // Identify Elements => Sign up email field
    @FindBy(xpath = "//a[text()=' Signup / Login']")
    WebElement signup;

    // Click on signup
    public void ClickOnSignup() {
        signup.click();
    }

    public String pagetile(){
        return ldriver.getTitle();
    }
}
