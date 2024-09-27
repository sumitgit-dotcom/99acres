package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;


public class PGDetailsPage {
	
	WebDriver driver;
    WebDriverWait wait;
    
    By pgImage = By.cssSelector(".pg-image-class");
    By allTabs = By.cssSelector(".tab-selector");
    By importantInfo = By.cssSelector(".important-info-class");
    
    public PGDetailsPage(WebDriver driver)
    {
    	
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    	
    	}
    
    public void verifyPGImage()
    {
    	WebElement image = wait.until(ExpectedConditions.visibilityOfElementLocated(pgImage));
    	Assert.assertTrue("PG Image is not displayed.", image.isDisplayed());
        System.out.println("PG Image is displayed successfully.");
    	
    }
    
    public void verifyTabsAreFunctional() 
    {
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(allTabs));
    	 for (WebElement tab : driver.findElements(allTabs))
    	 {
    		 
    		 Assert.assertTrue("Tab is not clickable.", tab.isEnabled());
    		  tab.click(); 
    		  System.out.println("Tab clicked successfully.");
    		 
    		 
    	 }
    	 
    	 public void verifyPGInfo()
    	 {
    		 
    		 
    		 
    		 WebElement info = wait.until(ExpectedConditions.visibilityOfElementLocated(importantInfo));
    		 Assert.assertTrue("Important information is not displayed.", info.isDisplayed());
    		 System.out.println("Important information is displayed successfully.");
    	 }
    	
    	
    	
    }

}
