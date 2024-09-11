package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	ElementUtils elementUtils;
	
public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	elementUtils=new ElementUtils(driver);
}

@FindBy(xpath="//input[@id='login_id']")
private WebElement EmailField;

@FindBy(id="password")
private WebElement PasswordField;

@FindBy(id="nextbtn")
private WebElement NextButton;

@FindBy(xpath="//button[@id='nextbtn']")
private WebElement SignInbutton;

public void EnterUsername(String username) {
	elementUtils.typetext(EmailField, username);
}


public void ClickNextButton() {
	elementUtils.ClickOnElement(NextButton);
}


public void EnterPassword(String Password) {
	elementUtils.typetext(PasswordField, Password);
}

public ModuleSelectionPage ClickSignInButton() {
	elementUtils.ClickOnElement(SignInbutton);
	return new ModuleSelectionPage(driver);
}
	
}
