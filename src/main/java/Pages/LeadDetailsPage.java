package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtils;

public class LeadDetailsPage {
	private WebDriver driver;
	private ElementUtils elementUtils;

	public LeadDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils=new ElementUtils(driver);
	}

	@FindBy(id="Crm_Leads_FIRSTNAME_LInput")
	private WebElement FirstNameField;
	
	@FindBy(id="Crm_Leads_LASTNAME_LInput")
	private WebElement LastNameField;
	
	@FindBy(xpath="(//*[@id='inputId'])[2]")
	private WebElement CompanyField;
	
	@FindBy(id="Crm_Leads_EMAIL_LInput")
	private WebElement EmailField;
	
	@FindBy(xpath="//button[@name='save']")
	private WebElement SaveButton;	
	
	
	public void EnterFirstName(String FirstName) {
		elementUtils.typetext(FirstNameField, FirstName);
	}
	public void EnterLastName(String LastName) {
		elementUtils.typetext(LastNameField, LastName);
	}
	public void EnterCompanyField(String Company) {
		elementUtils.typetext(CompanyField, Company);
	}
	public void EnterEmailField(String Email) {
		elementUtils.typetext(EmailField, Email);
	}
	public LeadsDescriptionPage ClickSave() {
		elementUtils.ClickOnElement(SaveButton);
		return new LeadsDescriptionPage(driver);
	}
	
}
