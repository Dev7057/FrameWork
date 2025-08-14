package Framework.TestCases;

import Framework.PageObject.Wb04_RegisterUserAccount_HomePage;
import Framework.PageObject.Wb01_HomePage;
import Framework.PageObject.Wb02_Signup_LoginPage;
import Framework.PageObject.Wb03_AccountCreationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_MyAccountPageTest extends BaseClass {

    @Test(enabled = false)
    public void VerifyRegAndLogin() throws InterruptedException {

        Wb01_HomePage pg = new Wb01_HomePage(driver);
        pg.ClickOnSignup();
        log.info("Clicked on the signup option");

        Wb02_Signup_LoginPage My = new Wb02_Signup_LoginPage(driver);
        My.EnterName("Viru");
        My.EnterEmailID("viru34@yopmail.com");
        My.SignupButton();
        log.info("Signup successfully");

        Wb03_AccountCreationPage ACCD = new Wb03_AccountCreationPage(driver);
        ACCD.SelectTitleMr();
        ACCD.EnterPassword("123456");
        ACCD.EnterAddFName("Viru");
        ACCD.EnterAddLName("Kumar");
        ACCD.EnterAddress("Pune");
        ACCD.SelectCountryName("India");
        ACCD.EnterStateName("MH");
        ACCD.EnterCityName("Pune");
        ACCD.EnterZipCode("1234");
        ACCD.EnterMobileNumber("9876432123");
        ACCD.ClickOnRegistration();
        log.info("Registration successfully");

    }

    @Test()
    public void VerifyLogin() throws IOException {

        Wb01_HomePage pg = new Wb01_HomePage(driver);
        pg.ClickOnSignup();

        Wb02_Signup_LoginPage My = new Wb02_Signup_LoginPage(driver);
        My.EnterLoginEmail("viru34@yopmail.com");
        My.EnterLoginPassword("123456");
        My.ClickOnLoginButton();
        log.info("Log in successfully");

        Wb04_RegisterUserAccount_HomePage rgUser = new Wb04_RegisterUserAccount_HomePage(driver);
        String LoginUser = rgUser.verifyname();

        if (LoginUser.equals("Viru1")) {
            log.info("User name is correct");
            Assert.assertTrue(true);
        } else {
            log.info("User name is Incorrect");
            CaptureScreenShot(driver, "VerifyLogin");
            Assert.assertTrue(false);
        }
    }
}
