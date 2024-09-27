package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.PGDetailsPage;

public class PGVerificationSteps {
	
	WebDriver driver;
    PGDetailsPage pgDetailsPage;
    
    @Given("User is on the PG details page")
    public void user_is_on_the_pg_details_page()
    {
    	
    	 WebDriverManager.chromedriver().setup();
    	 driver = new ChromeDriver();
    	 driver.get("https://www.99acres.com/paying-guest-pg-for-rent-in-sector-62-noida-r4-spid-B69284162");
    	 driver.manage().window().maximize();
    	 pgDetailsPage = new PGDetailsPage(driver);
    	
     }
    
    @Then("The image of the PG should be displayed")
    public void the_image_of_the_pg_should_be_displayed() {
        pgDetailsPage.verifyPGImage();
    }
    @Then("All the tabs should be clickable and functional")
    public void all_the_tabs_should_be_clickable_and_functional() {
        pgDetailsPage.verifyTabsAreFunctional();
    }
    
    @Then("All the important information about the PG should be visible")
    public void all_the_important_information_about_the_pg_should_be_visible() {
        pgDetailsPage.verifyPGImage();
        driver.quit();
    }
	
	

}
