package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtils;

public class UserHomePage {
	WebDriver driver;
	ElementUtils elementUtils;
	
public UserHomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	elementUtils=new ElementUtils(driver);
}

@FindBy(xpath="//*[@id='mainMenuTabDiv']/crm-menu/div[1]/crm-tab/div[2]/div[2]/a")
private WebElement LeadsTopMenu;


public LeadsPage ClickOnLeadsTopMenu() {
	elementUtils.WaitForElement(LeadsTopMenu);
	elementUtils.ClickOnElement(LeadsTopMenu);
	return new LeadsPage(driver);
}


}