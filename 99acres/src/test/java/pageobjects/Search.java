package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Search {
	
	 WebDriver driver;
	    WebDriverWait wait;
	    By searchBox = By.id("keyword");   
	    By searchButton = By.id("searchButton"); 
	    By locationDropdown = By.id("locationDropdown");
	    By noidaOption = By.xpath("//option[text()='Noida']");
	    
	    public Search(WebDriver driver)
	    {
	    	 this.driver = driver;
	    	 this.wait = new WebDriverWait(driver, 20); 
	    	 
	    	
	    }
	    
	    public void searchForPGInNoida()
	    {
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
	    WebElement searchInput = driver.findElement(searchBox);
	    searchInput.clear();
	    searchInput.sendKeys("PG");
	    
	    wait.until(ExpectedConditions.elementToBeClickable(locationDropdown));
        driver.findElement(locationDropdown).click();
        driver.findElement(noidaOption).click();
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();
	    
    }

		public boolean isSearchResultsPageDisplayed() {
			// TODO Auto-generated method stub
			return false;
		}
	    
	   
    
    

}
