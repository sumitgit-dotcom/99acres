package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationPage {
	
	WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    
    By tenantsOption = By.xpath("//header[@id='headerId']//a[text()='Tenants']");
    By propertyForRentDelhiNCR = By.xpath("//a[text()='Property for Rent in Delhi NCR']");
    
    public NavigationPage(WebDriver driver)
    
    {
    	
    	
    	this.driver = driver;
    	this.wait = new WebDriverWait(driver, 20); 
    	this.actions = new Actions(driver);
    }
    
    public void hoverOnHeaderOption(String option)
    {
    	 WebElement headerOption = wait.until(ExpectedConditions.visibilityOfElementLocated(tenantsOption));
    	 actions.moveToElement(headerOption).perform();
    	 
    	  }
    
    
    public void selectMenuOption(String menuOption)
    {
    	
    	WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(propertyForRentDelhiNCR));
    	 menu.click();  
    }
    
    public void verifyNavigationToPage(String pageTitle)
    {
    	
    	
    	wait.until(ExpectedConditions.titleContains(pageTitle));
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(pageTitle)) {
            System.out.println("Successfully navigated to: " + actualTitle);
        } else {
            throw new IllegalStateException("Failed to navigate to the target page. Current page title: " + actualTitle);
        }
    }

}
