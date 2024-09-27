package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.LoginPage;

public class LoginSteps {
	
	WebDriver driver;
    LoginPage loginPage;
    
    @Given("User is on the login page of 99acres")
    public void user_is_on_the_login_page_of_99acres() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.99acres.com/");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
    }
    
    @When("User enters valid credentials")
    
    public void user_enters_valid_credentials() 
    {
    	 loginPage.enterUsername("your-email@example.com");
    	 loginPage.enterPassword("your-password");  
    	 
    	
    	
    }
    
    @And("User clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLoginButton();
    }
    @Then("User should be successfully logged in")
    public void user_should_be_successfully_logged_in() {
        loginPage.verifyLoginSuccess();
        driver.quit();
    }
        


}
