package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath="//a[@id='login2']")
	private WebElement login;
	
//    @FindBy(xpath="")
//    private WebElement close;
	@FindBy(id = "loginusername")
    private WebElement usernameField;

    @FindBy(id = "loginpassword")
    private WebElement passwordField;

    @FindBy(xpath = "//button[normalize-space()='Log in']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        login.click();
    	usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
