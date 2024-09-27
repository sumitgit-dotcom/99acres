package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PGSearchPage {
	WebDriver driver;
    WebDriverWait wait;
    
    By priceFilter = By.id("priceRange");
    By priceOptionUnder10000 = By.xpath("//label[contains(text(),'Upto 10,000')]");
    By firstPGListing = By.cssSelector(".srpTuple__tupleContainer a");
    
    public PGSearchPage(WebDriver driver)
    {
    	
    	 this.driver = driver;
         this.wait = new WebDriverWait(driver, 20);
    	
    	
    }
    
    public void applyPriceFilter()
    {
    	
    	 wait.until(ExpectedConditions.elementToBeClickable(priceFilter));
         driver.findElement(priceFilter).click();
         wait.until(ExpectedConditions.elementToBeClickable(priceOptionUnder10000));
         driver.findElement(priceOptionUnder10000).click();
    	
    	
    }
    
    public void clickFirstPG()
    {
    	 wait.until(ExpectedConditions.elementToBeClickable(firstPGListing));
         WebElement firstListing = driver.findElement(firstPGListing);
         firstListing.click();
    	
    	
    }
    
    
    public void verifyNavigationToDetailsPage() {
        String currentURL = driver.getCurrentUrl();
        System.out.println("Navigated to URL: " + currentURL);

        if (currentURL.contains("property")) {
            System.out.println("Successfully navigated to the PG details page.");
        } else {
            throw new IllegalStateException("Failed to navigate to the PG details page.");
        }
	

}}
