package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ModuleSelectionPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	public WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	ModuleSelectionPage moduleSelectionPage;
	DriverFactory driverFactory;
	
	
    @Given("user opens the application")
    public void When_user_opens_the_application() {
    	driverFactory=new DriverFactory();
    	driver=driverFactory.getDriver();
    	 homePage=new HomePage(driver);
    
    }
	
	@Then("the title of the page should be {string}")
	public void the_title_of_the_page_should_be(String expectedTitle) {
	    String actualTitle=homePage.getTitle();
	    Assert.assertEquals(actualTitle,expectedTitle);
	}

	@When("user clicks on signin link")
	public void user_clicks_on_signin_link() {
		loginPage=homePage.ClickonSignInLink();
	}

	
	@And("user enters the username {string}")
	public void user_enters_the_username(String userName) {
		//loginPage=new LoginPage(driver);
		loginPage.EnterUsername(userName);
		
	}
	
	@And("user clicks on Next button")
     public void user_clicks_on_Next_button() {
		loginPage.ClickNextButton();
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	@And("user enters the password {string}")
	public void user_enters_the_password(String Password) {
		loginPage.EnterPassword(Password);  
	}

	@And("clicks on signin button")
	public void clicks_on_signin_button() {
		moduleSelectionPage= loginPage.ClickSignInButton();
		 try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	@And("user clicks on signin image")
     public void user_clicks_on_signin_image() {
		//moduleSelectionPage=new ModuleSelectionPage(driver);
		moduleSelectionPage.ClickOnUserImage();	
	}
	
	
	@Then("username {string} should be displayed in the top right corner")
	public void user_username_should_be_displayed_in_the_top_right_corner(String expectedUserName) {
		String loggedinUserName= moduleSelectionPage.LoggedInUserName(); 
	    Assert.assertEquals(loggedinUserName, expectedUserName);
	}

	

}
