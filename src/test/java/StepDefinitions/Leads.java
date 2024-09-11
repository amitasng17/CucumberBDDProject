package StepDefinitions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.factory.DriverFactory;

import Pages.LeadDetailsPage;
import Pages.LeadsDescriptionPage;
import Pages.LeadsPage;
import Pages.ModuleSelectionPage;
import Pages.UserHomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Leads {
	public WebDriver driver;
	public ModuleSelectionPage moduleSelectionPage;
	public UserHomePage userHomePage;
	public LeadsPage leadsPage;
	LeadDetailsPage leadsDetailsPage;
	LeadsDescriptionPage leadsdescriptionPage;
	DriverFactory driverFactory;

	@And("user selects the CRM module")
	public void user_selects_the_CRM_module() {
		driverFactory = new DriverFactory();
		driver = driverFactory.getDriver();
		moduleSelectionPage = new ModuleSelectionPage(driver);
		userHomePage = moduleSelectionPage.SelectCRMModule();
	}

	@Given("user clicks on Leads in top menu")
	public void i_click_on_in_top_menu() {
		           
		leadsPage = userHomePage.ClickOnLeadsTopMenu();
	}

	@When("I go to create lead page")
	public void i_go_to_create_lead_page() {
		leadsDetailsPage = leadsPage.ClickCreateLeadButton();
	}

	@When("enter and submit lead details")
	public void enter_and_submit_lead_details(DataTable dataTable) {

		List<Map<String, String>> DataMap = dataTable.asMaps(String.class, String.class);
		leadsDetailsPage = new LeadDetailsPage(driver);
		leadsDetailsPage.EnterFirstName(DataMap.get(0).get("FirstName"));
		leadsDetailsPage.EnterLastName(DataMap.get(0).get("LastName"));
		leadsDetailsPage.EnterCompanyField(DataMap.get(0).get("Company"));
		leadsDetailsPage.EnterEmailField(DataMap.get(0).get("Email"));
		leadsdescriptionPage = leadsDetailsPage.ClickSave();
	}

	@Then("Lead Description Page should load  with leadname {string}")
	public void lead_description_page_should_load(String LeadName) {
		String actualLeadName = leadsdescriptionPage.GetActualLeadName();
		Assert.assertEquals(LeadName, actualLeadName);

	}

	@Then("I verify lead details")
	public void i_verify_lead_details() {
		System.out.println("needs to be done");

	}

	@Then("^Lead (.+) should (.+) inside the grid$")
	public void lead_should_inside_the_grid(String leadName, String condition) {
		if (condition.equals("be present")) {
			leadsPage.ValidateLeadPresent(leadName);
		} else {
			leadsPage.ValidateLeadNotPresent(leadName);
		}

	}

	@When("^I select the lead (.+)$")
	public void i_select_the_lead(String leadName) throws InterruptedException {
		Thread.sleep(10000);
		leadsPage.SelectLead(leadName);
	}

	@When("I click on delete button")
	public void i_click_on_delete_button() {
		leadsPage.ClickActionsButton();
		leadsPage.SelectDeleteOption();
		leadsPage.ConfirmDelete();
	}

}
