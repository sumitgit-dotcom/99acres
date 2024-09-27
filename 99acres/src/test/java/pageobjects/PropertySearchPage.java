package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class PropertySearchPage {
	
	WebDriver driver;
    WebDriverWait wait;
    
    By priceFilter = By.id("priceRange");
    By bhkFilter = By.xpath("//label[contains(text(),'2 BHK')]");
    By propertyTypeFilter = By.xpath("//label[contains(text(),'Residential Apartment')]");
    By availabilityFilter = By.xpath("//label[contains(text(),'Available for Family')]");
    By postedByFilter = By.xpath("//label[contains(text(),'Owner') or contains(text(),'Builder')]");
    By furnishingFilter = By.xpath("//label[contains(text(),'Semi Furnished')]");
    By locationFilter = By.id("locationDropdown");
    
    public PropertySearchPage(WebDriver driver)
    {
    	 this.driver = driver;
    	 this.wait = new WebDriverWait(driver, 20);
    	 
    	}
    
    public void applyPriceFilter(int maxPrice)
    {
    	 wait.until(ExpectedConditions.elementToBeClickable(priceFilter));
    	 driver.findElement(priceFilter).click();
    	 WebElement priceOption = driver.findElement(By.xpath("//label[contains(text(),'Upto " + maxPrice + "')]"));
    	 priceOption.click();
    	}
    
    public void applyBHKFilter(String bhkType) 
    
    {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(bhkFilter));
        driver.findElement(bhkFilter).click();
    }
    
    public void applyPropertyTypeFilter(String propertyType) 
    {
    	
    	WebElement propertyTypeElement = driver.findElement(By.xpath("//label[contains(text(),'" + propertyType + "')]"));
    	wait.until(ExpectedConditions.elementToBeClickable(propertyTypeElement));
        propertyTypeElement.click();
    	
    }
    
    public void applyAvailabilityFilter(String availability)
    {
    	WebElement availabilityElement = driver.findElement(By.xpath("//label[contains(text(),'" + availability + "')]"));
    	wait.until(ExpectedConditions.elementToBeClickable(availabilityElement));
        availabilityElement.click();
    	 }
    
    public void applyPostedByFilter(String postedBy)
    {
    	String[] options = postedBy.split(" and ");
    	 for (String option : options)
    	 {
    		 WebElement postedByElement = driver.findElement(By.xpath("//label[contains(text(),'" + option.trim() + "')]"));
    		 wait.until(ExpectedConditions.elementToBeClickable(postedByElement));
             postedByElement.click();
    		  }
    	  }
    
    public void applyFurnishingFilter(String furnishing)
    {
    	WebElement furnishingElement = driver.findElement(By.xpath("//label[contains(text(),'" + furnishing + "')]"));
    	wait.until(ExpectedConditions.elementToBeClickable(furnishingElement));
        furnishingElement.click();
         }
    
    public void applyLocationFilter(String location)
    {
    	wait.until(ExpectedConditions.elementToBeClickable(locationFilter));
    	 driver.findElement(locationFilter).click();
    	  WebElement locationOption = driver.findElement(By.xpath("//label[contains(text(),'" + location + "')]"));
    	  locationOption.click();
    }
    
    public void verifyFilteredResults() 
    { 
    	Assert.assertTrue("Filtered results are not displayed", driver.findElements(By.cssSelector(".filtered-properties")).size() > 0);
    
    	System.out.println("Filtered property listings are displayed successfully.");
    	
    	
    }

}
