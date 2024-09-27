package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPagefilter {
	
	WebDriver driver;
    WebDriverWait wait;
    
    By budgetDropdown = By.id("budgetDropdown");
    
    By budgetOption = By.xpath("//label[contains(text(),'Upto 10,000')]");
    By sharingDropdown = By.id("sharingDropdown");
    By boysOption = By.xpath("//label[contains(text(),'Boys')]");
    By twoRoomOption = By.xpath("//label[contains(text(),'+2 Room')]");
    By twoRoomOption = By.xpath("//label[contains(text(),'+2 Room')]");
    By sector62Option = By.xpath("//label[contains(text(),'Sector 62')]");
    
    public SearchPage(WebDriver driver)
    {
    	 this.driver = driver;
    	 this.wait = new WebDriverWait(driver, 20);
    	
    	
    }
    
    public void applyBudgetFilter(int budget)
    {
    	wait.until(ExpectedConditions.elementToBeClickable(budgetDropdown));
    	 driver.findElement(budgetDropdown).click();
    	 wait.until(ExpectedConditions.elementToBeClickable(budgetOption));
    	 driver.findElement(budgetOption).click();
    	
    	
    }
    
    public void applyRoomSharingFilter(String sharingType, String roomType)
    {
    	wait.until(ExpectedConditions.elementToBeClickable(sharingDropdown));
        driver.findElement(sharingDropdown).click(); 
        
        if (sharingType.equals("Boys"))
        {
        	
        	 wait.until(ExpectedConditions.elementToBeClickable(boysOption));
        	 driver.findElement(boysOption).click();
        	
        }
        wait.until(ExpectedConditions.elementToBeClickable(twoRoomOption));
        driver.findElement(twoRoomOption).click();
    	
    }
    public void applyLocationFilter(String location) 
    {
    	wait.until(ExpectedConditions.elementToBeClickable(locationDropdown));
    	 driver.findElement(locationDropdown).click();
    	 wait.until(ExpectedConditions.elementToBeClickable(sector62Option));
    	 driver.findElement(sector62Option).click();
    	
    	
    }
    
    public boolean verifyFilteredResults()
    {
    	
    	 By resultLocator = By.xpath("//span[contains(text(),'results for PG in Noida')]");
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(resultLocator)).isDisplayed();
    	
    	
    	
    	
    }

}
