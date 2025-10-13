//package testcases;
//
//import config.Constants;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.*;
//import pages.LoginPage;
//import utils.ExcelUtils;
//import utils.WebDriverManager;
//
//public class LoginTest {
//    private WebDriver driver;
//    private LoginPage loginPage;
//    private static final String SHEET_NAME = "LoginTest";
//
//    @BeforeClass
//    public void setup() {
//        driver = WebDriverManager.getDriver();
//        driver.get(Constants.URL);
//        loginPage = new LoginPage(driver);
//    }
//
//    @DataProvider(name = "loginData")
//    public Object[][] getLoginData() {
//        return ExcelUtils.getTestData(SHEET_NAME); // Pass only the sheet name
//    }
//
//    @Test(dataProvider = "loginData")
//    public void testLogin(String username, String password) {
//        loginPage.login(username, password);
//    }
//
//    @AfterClass
//    public void tearDown() {
//        WebDriverManager.quitDriver();
//    }
//}






package testcases;

import config.Constants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.WebDriverManager;

@Test
public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private static final String SHEET_NAME = "LoginTest";

    @BeforeMethod
    public void setup() {
        driver = WebDriverManager.getDriver();
        driver.get(Constants.URL);
        loginPage = new LoginPage(driver);
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return ExcelUtils.getTestData(SHEET_NAME);
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) throws InterruptedException {
        System.out.println("Testing login with: " + username + " / " + password);
        loginPage.login(username, password);
        Thread.sleep(5000);
        WebElement logoutButton = driver.findElement(By.id("logout2"));
        Assert.assertTrue(logoutButton.isDisplayed(), "Login failed: Logout button not found!");
        
        System.out.println("Login successful! Test Passed.");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverManager.quitDriver();
    }
}

















