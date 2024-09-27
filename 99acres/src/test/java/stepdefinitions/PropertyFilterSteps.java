package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.PropertySearchPage;

public class PropertyFilterSteps {
	WebDriver driver;
    PropertySearchPage propertySearchPage;
    
    @Given("User is on the 99acres property rental search page for Delhi NCR")
    public void user_is_on_the_99acres_property_rental_search_page()
    {
    	
    	 WebDriverManager.chromedriver().setup();
    	 driver = new ChromeDriver();
    	 driver.get("https://www.99acres.com/property-for-rent-in-delhi-ncr-ffid");
    	 driver.manage().window().maximize();
    	 propertySearchPage = new PropertySearchPage(driver);
    }
    
    @When("User applies the filter for properties under Rs 20,000")
    public void user_applies_the_price_filter()
    {
    	 propertySearchPage.applyPriceFilter(20000);
    	
    }
    
    @When("User applies the filter for 2BHK")
    public void user_applies_bhk_filter()
    {
    	
    	propertySearchPage.applyBHKFilter("2BHK");
    }
    
    @When("User applies the filter for {string}")
    public void user_applies_property_type_filter(String propertyType)
    {
    	
    	 propertySearchPage.applyPropertyTypeFilter(propertyType);
    }
    
    @When("User applies the filter for {string}")
    public void user_applies_availability_filter(String availability)
    {
    	
    	  propertySearchPage.applyAvailabilityFilter(availability);
    }
    
    @When("User applies the filter for {string}")
    public void user_applies_posted_by_filter(String postedBy)
    {
    	
    	propertySearchPage.applyPostedByFilter(postedBy);
    }
    @When("User applies the filter for {string}")
    public void user_applies_furnishing_filter(String furnishing)
    {
    	
    	propertySearchPage.applyFurnishingFilter(furnishing);
    }
    
    @When("User applies the filter for {string}")
    public void user_applies_location_filter(String location)
    {
    	
    	propertySearchPage.applyLocationFilter(location);
 }
    
    @Then("User should see the filtered property listings")
    
    public void user_should_see_filtered_property_listings()
    {
    	propertySearchPage.verifyFilteredResults();
        driver.quit();
    	
    	
    }
    

}
