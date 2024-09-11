package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.util.ElementUtils;



public class LeadsPage {
	WebDriver driver;
	ElementUtils elementUtils;

	public LeadsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils=new ElementUtils(driver);
	}
	//*[@id='table_row_1']/lyte-td[3]/span[1]/link-to/button
	@FindBy(xpath="//*[@id='table_row_1']/lyte-td[3]/span[1]")
	private WebElement CreateLeadButton;
	
	
	
	@FindBy(xpath = "//lyte-exptable-tr/lyte-exptable-td[4]")
	private List<WebElement> cells;
	
	
	@FindBy(xpath="//*[@id='moreAct']")
	private WebElement ActionsButton; 
	
	@FindBy(xpath="//div[@class='lytePopover lytePopoverVisible']//li[@data-value='mass_delete']")
	private WebElement DeleteOption;
	
	
	@FindBy(xpath="//*[@class='record_delete_button']")
	private WebElement ConfirmDelete;
	
	public LeadDetailsPage ClickCreateLeadButton() {
		CreateLeadButton.click();
		return new LeadDetailsPage(driver);
	}
	
	public List<WebElement> getLeadNames() {
		return cells;
	}
	
	public void ValidateLeadPresent(String LeadName) {
		int rowNum = elementUtils.GetLeadRowNumWithCellData(LeadName,cells);
		if(rowNum==-1)
			Assert.fail("Lead not found");		
	}
	
	public void ValidateLeadNotPresent(String LeadName) {
		int rowNum = elementUtils.GetLeadRowNumWithCellData(LeadName,cells);
		if(rowNum!=-1)
			Assert.fail("Lead not deleted successfully");		
	}
	
	public void SelectLead(String LeadName) {
		int rowNum = elementUtils.GetLeadRowNumWithCellData(LeadName,cells);
		elementUtils.selectLeadCheckBox(rowNum);
	}
	
	public void ClickActionsButton() {
		elementUtils.ClickOnElement(ActionsButton);
	}	
	
	public void SelectDeleteOption() {
		elementUtils.ClickOnElement(DeleteOption);
	}
	
	public void ConfirmDelete() {
		elementUtils.ClickOnElement(ConfirmDelete);
	}
}
