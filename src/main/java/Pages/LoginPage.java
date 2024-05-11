package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage {

    private WebDriverWait wait;

    @FindBy(xpath = "//input[@data-testid='login-email']")
    private WebElement emailField;

    @FindBy(id = "user_password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@data-testid='login-submit']")
    private WebElement loginButton;

    @FindBy(id = "parsley-id-5")
    private List<WebElement> notLoginError;

    @FindBy(id = "parsley-id-7")
    private List<WebElement> noPasswordError;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    public void inputEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
    }

    public void inputPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
    }

    public List<WebElement> getNotLoginError() {
        return notLoginError;
    }

    public List<WebElement> getNoPasswordError() {
        return noPasswordError;
    }
}
