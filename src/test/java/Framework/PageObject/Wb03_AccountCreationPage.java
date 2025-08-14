package Framework.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Wb03_AccountCreationPage {

    // Create an object of Webdriver
    WebDriver ldriver;

    // Constructor
    public Wb03_AccountCreationPage(WebDriver rdriver) {

        ldriver = rdriver;

        PageFactory.initElements(rdriver, this);
    }

    // Title Mr
    @FindBy(id = "uniform-id_gender1")
    WebElement TitleMr;

    // Enter Password
    @FindBy(id = "password")
    WebElement Pass;

    // Enter First name in Address
    @FindBy(id = "first_name")
    WebElement AddressFName;

    // Enter Last name in Address
    @FindBy(id = "last_name")
    WebElement AddressLName;

    // Enter Address
    @FindBy(id = "address1")
    WebElement Address;

    // Select Contry
    @FindBy(id = "country")
    WebElement County;

    // Enter State Name
    @FindBy(id = "state")
    WebElement State;

    // Enter City Name
    @FindBy(id = "city")
    WebElement City;

    // Enter Zipcode
    @FindBy(id = "zipcode")
    WebElement Zip;

    // Enter Mobile Number
    @FindBy(id = "mobile_number")
    WebElement MobileNum;

    // Click on the Create Account Button
    @FindBy(xpath = "//button[text()='Create Account']")
    WebElement CreateAccountbtn;

    public void SelectTitleMr() {
        TitleMr.click();
    }

    public void EnterPassword(String Password) {
        Pass.sendKeys(Password);
    }

    public void EnterAddFName(String FirstName) {
        AddressFName.sendKeys(FirstName);
    }

    public void EnterAddLName(String LastName) {
        AddressLName.sendKeys(LastName);
    }

    public void EnterAddress(String address) {
        Address.sendKeys(address);
    }

    public void SelectCountryName(String text) {
        Select dropdwon = new Select(County);
        dropdwon.selectByVisibleText(text);
    }


    public void EnterStateName(String state) {
        State.sendKeys(state);
    }

    public void EnterCityName(String city) {
        City.sendKeys(city);
    }

    public void EnterZipCode(String ZipCode) {
        Zip.sendKeys(ZipCode);
    }

    public void EnterMobileNumber(String Mobile) {
        MobileNum.sendKeys(Mobile);
    }

    public void ClickOnRegistration() {
        CreateAccountbtn.click();
    }

}
