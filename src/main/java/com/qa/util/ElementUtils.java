package com.qa.util;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.factory.DriverFactory;

public class ElementUtils {
	WebDriver driver;
	//DriverFactory driverFactory;
	

	public ElementUtils(WebDriver driver) {
		this.driver = driver;

	}

	public void ClickOnElement(WebElement e) {
		
		WaitForElement(e);
		e.click();
		
	}

	public void WaitForElement(WebElement e) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			 wait.until(ExpectedConditions.visibilityOf(e));
			 wait.until(ExpectedConditions.elementToBeClickable(e));
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public void typetext(WebElement e, String text) {
		WaitForElement(e);
		e.click();
		e.clear();
		e.sendKeys(text);
	}

	public void SelectOptionInDropdown(WebElement element, String dropDownOption) {
		
		WaitForElement(element);
		Select select = new Select(element);
		select.selectByVisibleText(dropDownOption);
	}

	public void acceptAlert() {
		Alert alert = WaitForAlert();
		alert.accept();
	}

	public Alert WaitForAlert() {
		Alert alert = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return alert;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	
	public void MouseHoverAndClickElement(WebElement webElement){
        WaitForElement(webElement);
        Actions actions=new Actions(driver);
        actions.moveToElement(webElement).click().build().perform();
      }
      
     public void JavascriptClick(WebElement webElement){
       WaitForElement(webElement);
       JavascriptExecutor executor = ((JavascriptExecutor)driver);
       executor.executeScript("arguments[0].click();", webElement);
    }

     public void JavascriptType(WebElement webElement, String text){
       WaitForElement(webElement);
       JavascriptExecutor executor = ((JavascriptExecutor)driver);
       executor.executeScript("arguments[0].value='"+text+"'", webElement);
    }

    public String getTextFromElement(WebElement webElement){
      WaitForElement(webElement);
      return webElement.getText();
    }

    public boolean isElementDisplayed(WebElement webElement){
      try{
        WaitForElement(webElement);
        return webElement.isDisplayed();
        }catch(Throwable e){
          return false;
        }
     }
    
    public int GetLeadRowNumWithCellData(String LeadName, List<WebElement> Cells) {
    
    	for(int i=0;i<Cells.size();i++) {
			if(LeadName.replace("'","").equalsIgnoreCase(Cells.get(i).getText()))
				return (i+1);
		}
		return -1;// not found
    }
    
    public void selectLeadCheckBox(int rowNum) {
		
		WebElement e = driver.findElement(By.xpath("//lyte-exptable-tr["+rowNum+"]/lyte-exptable-td[2]"));
		 Actions actions = new Actions(driver);
		 actions.moveToElement(e).click().build().perform();
	}
    
    

}
