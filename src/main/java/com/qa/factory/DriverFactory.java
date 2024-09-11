package com.qa.factory;

import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
	public WebDriver init_driver(String browser){
	  System.out.println("Browser is "+ browser);
	  if(browser.equals("chrome")){
	   //WebDriverManager.chromedriver().setup();
		  System.setProperty("webdriver.chrome.driver","C:\\D Drive\\Test Automation\\Drivers\\AllDrivers\\chromedriver.exe");
	   //tlDriver.set(new ChromeDriver());
	   ChromeOptions ops = new ChromeOptions();
		ops.setPageLoadStrategy(PageLoadStrategy.EAGER);
		ops.addArguments("--disable-notifications");
		ops.addArguments("--start-maximized");
		ops.addArguments("ignore-certificate-errors");
		tlDriver.set(new ChromeDriver(ops));
	  } else if(browser.equals("firefox")){
	   WebDriverManager.firefoxdriver().setup();
	   tlDriver.set(new FirefoxDriver());
	  }else if(browser.equals("edge")){
	   WebDriverManager.edgedriver().setup();
	   tlDriver.set(new EdgeDriver());
	  }
	  getDriver().manage().deleteAllCookies();
	  getDriver().manage().window().maximize();
	  getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	   return getDriver();
	}


	public  WebDriver getDriver(){
	  return tlDriver.get();
	}
}
