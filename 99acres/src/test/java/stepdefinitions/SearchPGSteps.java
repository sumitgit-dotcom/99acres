package stepdefinitions;

import pageobjects.SearchPagefilter;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;




public class SearchPGSteps {
	
	  WebDriver driver;
	    SearchPage searchPage;
	    @Given("User is on the 99acres PG search results page")
	    
	    public void user_is_on_the_pg_search_results_page()
	    {
	    	
	    	WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://www.99acres.com/search/property/buy/pg-in-noida?city=7&keyword=pg%20in%20noida&preference=S&area_unit=1&res_com=R");
	        driver.manage().window().maximize();
	        searchPage = new SearchPage(driver);
	    	
	    }
	    
	    @When("User applies a budget filter of up to 10,000")
	    public void user_applies_a_budget_filter() {
	        searchPage.applyBudgetFilter(10000);
	    }
	    
	    @When("User applies a filter for {string} sharing +2 room")
	    public void user_applies_room_filter(String sharingType) {
	        searchPage.applyRoomSharingFilter(sharingType, "+2 Room");
	    }
	    
	    @When("User applies the location filter for {string}")
	    public void user_applies_location_filter(String location) {
	        searchPage.applyLocationFilter(location);
	    }
	    
	    @Then("User should see PG listings filtered accordingly")
	    public void user_should_see_filtered_pg_listings() {
	        boolean isFiltered = searchPage.verifyFilteredResults();
	        if (isFiltered) {
	            System.out.println("Listings are successfully filtered.");
	        } else {
	            System.out.println("Filter did not work as expected.");
	        }
	        
	        driver.quit();

}
