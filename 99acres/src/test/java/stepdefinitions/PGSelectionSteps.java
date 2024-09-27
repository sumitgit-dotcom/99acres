package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.PGSearchPage;

public class PGSelectionSteps {
	
	 WebDriver driver;
	    PGSearchPage pgSearchPage;
	    @Given("User is on the 99acres search results page for Noida rental properties")
	    public void user_is_on_the_search_results_page()
	    {
	    	
	    	 WebDriverManager.chromedriver().setup();
	    	   driver = new ChromeDriver();
	    	   driver.get("https://www.99acres.com/search/property/rent/residential/noida?city=7&preference=P&area_unit=1&res_com=R&isPreLeased=N");
	    	   driver.manage().window().maximize();
	           pgSearchPage = new PGSearchPage(driver);
	    	
	 }
	    
	    @When("User applies the price filter for PGs less than 10,000")
	    public void user_applies_the_price_filter() {
	        pgSearchPage.applyPriceFilter();
	    }
	    @When("User selects the first PG from the filtered results")
	    public void user_selects_the_first_pg() {
	        pgSearchPage.clickFirstPG();
	    }
	    @Then("User should be redirected to the PG's details page")
	    public void user_should_be_redirected_to_the_pgs_details_page() {
	        pgSearchPage.verifyNavigationToDetailsPage();
	        driver.quit();
	    }

}
