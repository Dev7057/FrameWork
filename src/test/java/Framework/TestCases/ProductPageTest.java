package Framework.TestCases;

import Framework.PageObject.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class ProductPageTest extends BaseClass {

    @Test(enabled = false)
    public void VerifyProduct() throws InterruptedException {

        String keyword = "jeans";

        Wb01_HomePage pg = new Wb01_HomePage(driver);
        pg.ClickOnSignup();

        Wb02_Signup_LoginPage My = new Wb02_Signup_LoginPage(driver);
        My.EnterLoginEmail("viru34@yopmail.com");
        My.EnterLoginPassword("123456");
        My.ClickOnLoginButton();
        log.info("Log in successfully");

        Wb04_RegisterUserAccount_HomePage Hm = new Wb04_RegisterUserAccount_HomePage(driver);
        Hm.ClickOnProductLink();
        Hm.SearchBar(keyword);
        Hm.ClickOnSearchButton();

        Wb05_SearchResultPage result = new Wb05_SearchResultPage(driver);
        String searchRslt = result.SearchResultProductName();
//        System.out.println("Product Name:"+ searchRslt);

        if (searchRslt.toLowerCase().contains(keyword)) {
            System.out.println("Product search test case is pass");
            Assert.assertTrue(true);
        } else {
            System.out.println("Product search test case is fail");
            Assert.assertTrue(false);

        }
        result.ClickOnViewProduct();
    }


    @Test
    public void CheckOutProduct() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String keyword = "jeans";

        Wb01_HomePage pg = new Wb01_HomePage(driver);
        pg.ClickOnSignup();

        Wb02_Signup_LoginPage My = new Wb02_Signup_LoginPage(driver);
        My.EnterLoginEmail("viru34@yopmail.com");
        My.EnterLoginPassword("123456");
        My.ClickOnLoginButton();
        log.info("Log in successfully");

        Wb04_RegisterUserAccount_HomePage Hm = new Wb04_RegisterUserAccount_HomePage(driver);
        Hm.ClickOnProductLink();
        Hm.SearchBar(keyword);
        Hm.ClickOnSearchButton();

        Wb05_SearchResultPage result = new Wb05_SearchResultPage(driver);
        String searchRslt = result.SearchResultProductName();
//        System.out.println("Product Name:"+ searchRslt);

        if (searchRslt.toLowerCase().contains(keyword)) {
            System.out.println("Product search test case is pass");
            Assert.assertTrue(true);
        } else {
            System.out.println("Product search test case is fail");
            Assert.assertTrue(false);

        }
//        WebElement prod = driver.findElement(By.xpath("//a[text()='Add to cart']"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", prod);
//
//        Actions act = new Actions(driver);
//        act.moveToElement(prod).pause(Duration.ofSeconds(1)).perform();
        result.hoverOnAddToCart();

        result.ClickOnViewProduct();

//        try {
//
//        } catch (ElementClickInterceptedException e) {
//            System.out.println("Exception message: " + e.getMessage());
//        }
//
//        System.out.println("Clicked successfully in the view product option");


        Wb06_ViewProductPage View = new Wb06_ViewProductPage(driver);
        View.ClickOnQuantity();
        View.ClickOnAddToCartButton();
        View.ClickOnPop_up();
        View.ClickOnCartLink();

        Wb07_CartPage cp = new Wb07_CartPage(driver);
        String QuntNumber = cp.ProQuantity();
        System.out.println("Quantity Of Product is: " + QuntNumber);

        cp.ClickOnCheckOutBtn();
        cp.ClickOnPlaceOrder();
        cp.EnterCartName("Viru");
        cp.EnterCartNumber("4242424242424242");
        cp.EnterCVC("123");
        cp.EnterMonth("010");
        cp.EnterYear("2026");
        cp.ClickOnSubmit();

        String SuccessMessage = cp.OrderPlaceMessage();

        if (SuccessMessage.equals("Congratulations! Your order has been confirmed!")) {
            System.out.println("Check out product - Pass");
            Assert.assertTrue(true);
        } else {
            System.out.println("Check out product - fail");
            Assert.assertFalse(false);
        }

        Wb04_RegisterUserAccount_HomePage Lg = new Wb04_RegisterUserAccount_HomePage(driver);
        Lg.logout();

        if (pg.pagetile().equals("Automation Exercise")) {
            System.out.println("Verify logout Pass");
            Assert.assertTrue(true);
        } else {
            System.out.println("Verify logout fail");
            CaptureScreenShot(driver, "Verify logout");
            Assert.assertTrue(false);
        }

    }
}