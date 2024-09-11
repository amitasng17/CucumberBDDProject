package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtils;

public class HomePage {
	
WebDriver driver;
ElementUtils elementUtils;

public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	elementUtils=new ElementUtils(driver);
}

@FindBy(xpath="//a[text()='Sign in']")
private WebElement SignInLink;


public LoginPage ClickonSignInLink() {
	elementUtils.ClickOnElement(SignInLink);
	return new LoginPage(driver);
}


public String getTitle() {
	return elementUtils.getPageTitle();
}



}
