package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.LoginPage;
import pageobjects.Search;

public class Searchsteps {
	
	WebDriver driver;
    LoginPage loginPage;
    Search searchPage;
    
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
    
    @When("User searches for PGs in Noida")
    
    public void user_searches_for_pgs_in_noida() {
        searchPage = new Search(driver);
        searchPage.searchForPGInNoida();
    }
    @Then("User should see the search results page for PGs in Noida")
    
    public void user_should_see_the_search_results_page_for_pgs_in_noida()
    {
    	
    	boolean isDisplayed = searchPage.isSearchResultsPageDisplayed();
    	if (isDisplayed) {
            System.out.println("Search results page for PG in Noida is displayed.");
        } else {
            System.out.println("Failed to navigate to the search results page.");
        }
        driver.quit();
    	
    	
    	
    	
    }

}
