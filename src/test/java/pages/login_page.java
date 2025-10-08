package pages;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class login_page {
    private WebDriver driver;
 
    // Locators (CSS selectors)
    private By usernameField = By.cssSelector("input[type='email']");
    private By passwordField = By.cssSelector("input[type='password']");
    private By loginButton   = By.cssSelector("[type='submit']");
 
    public login_page(WebDriver driver) {
        this.driver = driver;
    }
 
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }
 
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
 
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
 
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}