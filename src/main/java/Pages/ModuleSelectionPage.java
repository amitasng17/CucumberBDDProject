package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtils;

public class ModuleSelectionPage {

	WebDriver driver;
	ElementUtils elementUtils;
	
public ModuleSelectionPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	elementUtils=new ElementUtils(driver);
}

@FindBy(xpath="(//div[@class='zgh-user-box'])[3]/div")
private WebElement UserImage;

@FindBy(xpath="(//div[@class='zgh-userLink']/ul/li[2])[3]")
private WebElement LoggedInUser;

@FindBy(xpath="//ul[@class='myapps']/li[contains(@class,'crm')]")
private WebElement CRMModule;

public void ClickOnUserImage() {
	elementUtils.ClickOnElement(UserImage);
}

public String LoggedInUserName() {
   return elementUtils.getTextFromElement(LoggedInUser);
}

public UserHomePage SelectCRMModule() {
	elementUtils.ClickOnElement(CRMModule);
	return new UserHomePage(driver);
}


}