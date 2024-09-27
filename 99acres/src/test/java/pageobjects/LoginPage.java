package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	By loginLink = By.xpath("//a[@id='loginLink']");
    By emailField = By.id("emailField");
    By passwordField = By.id("passwordField");
    By loginButton = By.id("submitButton");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void goToLoginPage() {
        driver.findElement(loginLink).click(); 
    }
    
    public void enterUsername(String username) {
        WebElement email = driver.findElement(emailField);
        email.clear();
        email.sendKeys(username);
    }
    
    public void enterPassword(String password) {
        WebElement pass = driver.findElement(passwordField);
        pass.clear();
        pass.sendKeys(password);
    }
    
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    
    public void verifyLoginSuccess() {
        
        boolean isLoggedIn = driver.findElement(By.id("logoutLink")).isDisplayed();
        assert(isLoggedIn);
    }
	
	

}
