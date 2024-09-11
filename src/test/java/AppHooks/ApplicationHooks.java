package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	private com.qa.util.ConfigReader ConfigReader;
	Properties prop;
	private WebDriver driver;
	private com.qa.factory.DriverFactory DriverFactory;

	@Before(order=0)
	public void getProperty(){
	 ConfigReader=new com.qa.util.ConfigReader();
	 prop=ConfigReader.init_prop();
	 
	}

	@Before(order=1)
	public void launchBrowser(){
	 String browsername=prop.getProperty("browser");
	 DriverFactory=new com.qa.factory.DriverFactory();
	 driver=DriverFactory.init_driver(browsername);
	  driver.get(prop.getProperty("url"));
	}

	@After(order=0)
	public void quitBrowser(){
	//driver.quit();
	}

	@After(order=1)
	public void tearDown(Scenario scenario){
	    if(scenario.isFailed()){
	      String screenshotName=scenario.getName().replaceAll(" ","_");
	      byte[] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	      scenario.attach(sourcePath,"image/png",screenshotName);
	     }
	}

}
