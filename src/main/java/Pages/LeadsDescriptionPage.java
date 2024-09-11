package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementUtils;

public class LeadsDescriptionPage {
	WebDriver driver;
	ElementUtils elementUtils;

	public LeadsDescriptionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils=new ElementUtils(driver);
	}

	@FindBy(xpath="//*[@id='titlecard_LASTNAME']")
	private WebElement ActualLeadName;


	public String GetActualLeadName() {
		return elementUtils.getTextFromElement(ActualLeadName);
	}

}
