package Framework.TestCases;

import Framework.PageObject.Wb04_RegisterUserAccount_HomePage;
import Framework.PageObject.Wb01_HomePage;
import Framework.PageObject.Wb02_Signup_LoginPage;
import Framework.PageObject.Wb03_AccountCreationPage;
import Framework.Utilitize.ReadExcelFile;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_Web02SigLPgTestDataDrivenTesting extends BaseClass {

    @Test(enabled = false)
    public void VerifyRegAndLogin() throws InterruptedException {

        Wb01_HomePage pg = new Wb01_HomePage(driver);
        pg.ClickOnSignup();

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

    @Test(dataProvider = "LoginDataProvider")
    public void VerifyLogin(String userEml, String passWrd, String ExpUserName) throws IOException {

        Wb01_HomePage pg = new Wb01_HomePage(driver);
        pg.ClickOnSignup();
        log.info("Successfully click on the sing up link");

        Wb02_Signup_LoginPage My = new Wb02_Signup_LoginPage(driver);
        My.EnterLoginEmail(userEml);
        log.info("Enter Email successfully");
        My.EnterLoginPassword(passWrd);
        log.info("Enter Password successfully");
        My.ClickOnLoginButton();
        log.info("Button clicked successfully");
        log.info("Log in Successfully");

        Wb04_RegisterUserAccount_HomePage rgUser = new Wb04_RegisterUserAccount_HomePage(driver);
        String LoginUser = rgUser.verifyname();

        if (LoginUser.equals(ExpUserName)) {
            log.info("User name is correct");
            Assert.assertTrue(true);
//            System.out.println("Log file path: "+ System.getProperty("user.dir") + "/logs/mylog.log");
//            logger.debug("This is a debug message");
//            logger.info("This is an info message");
            rgUser.logout();
        } else {
            log.info("User name is Incorrect");
            CaptureScreenShot(driver, "VerifyLogin");
            Assert.assertTrue(false);
        }


    }

    @DataProvider(name = "LoginDataProvider")
    public String [][] LoginDataProvider() {

//        System.out.println(System.getProperty("user.dir"));
        String fileName = System.getProperty("user.dir") + "\\TestData\\Test Data.xlsx";

        // Using Apache POI's DataFormatter to read different types of data
        DataFormatter dataFormatter = new DataFormatter();

        int TotalRow = ReadExcelFile.getRowCount(fileName, "Sheet1");
        int TotalColumn = ReadExcelFile.getColCount(fileName, "Sheet1");

        String[][] data= new String[TotalRow -1][TotalColumn];

        for (int i=1; i<TotalRow; i++)
        {
            for (int j=0; j<TotalColumn;j++)
            {
                data[i -1][j] = ReadExcelFile.getCellValue(fileName, "Sheet1", i,j, dataFormatter );
                System.out.println( data[i -1][j]);
            }
        } log.info("Data is successfully fetch from Excel file");
        return data;

    }
}
