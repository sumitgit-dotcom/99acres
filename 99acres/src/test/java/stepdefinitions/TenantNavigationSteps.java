package stepdefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.LoginPage;
import pageobjects.NavigationPage;

public class TenantNavigationSteps {
	
	 WebDriver driver;
	    LoginPage loginPage;
	    NavigationPage navigationPage;
	    
	    @Given("User is logged into 99acres")
	    public void user_is_logged_into_99acres()
	    {
	    	
	    	WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://www.99acres.com/");
	        driver.manage().window().maximize();
	        
	        
	        loginPage = new LoginPage(driver);
	        loginPage.goToLoginPage();
	        loginPage.enterUsername("your-email@example.com");
	        loginPage.enterPassword("your-password");
	        loginPage.clickLoginButton();
	        		
	    }
	    
	    @When("User hovers over the {string} option in the header")
	    public void user_hovers_over_the_tenants_option(String option)
	    {
	    	
	    	
	    	 navigationPage = new NavigationPage(driver);
	    	 navigationPage.hoverOnHeaderOption(option); 
	    }
	    
	    @When("User selects {string}")
	    public void user_selects_property_for_rent_in_delhi_ncr(String menuOption)
	    {
	    	
	    	 navigationPage.selectMenuOption(menuOption);
	    	 
	    }
	    
	    @Then("User should be navigated to the {string} page")
	    public void user_should_be_navigated_to_the_page(String pageTitle) 
	    {
	    	
	    	navigationPage.verifyNavigationToPage(pageTitle);
	        driver.quit();
	    }

}
