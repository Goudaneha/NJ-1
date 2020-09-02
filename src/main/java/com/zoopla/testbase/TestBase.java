package com.zoopla.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.zoopla.utility.EventListener;
//import com.zoopla.utility.EventListener;
import com.zoopla.utility.Testutility;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop; 
	
	public static WebElement webelw;
	public static Logger log = Logger.getLogger(TestBase.class);
	
	/***********Created event listener obj******************/
	public  static EventFiringWebDriver event_driver;
	public static EventListener elistener;

	public TestBase() {
		
	try {
		prop = new Properties();
		FileInputStream fips = new FileInputStream(
		"D:\\NJ\\TestAutomation-1\\src\\main\\java\\com\\zoopla\\config\\config.properties");
			prop.load(fips);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void init() throws InterruptedException {
		
	String browsername = prop.getProperty("browser");
	
	if(browsername.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromevalue"));
		driver = new ChromeDriver();
	}
	else if(browsername.equalsIgnoreCase("FF")){
		System.setProperty("webdriver.gecko.driver",prop.getProperty("geckovalue"));
		driver = new FirefoxDriver();
			}
	/********* Now create object of EventListerHandler to register it with EventFiringWebDriver*********/
	event_driver = new  EventFiringWebDriver(driver);
	elistener = new  EventListener();
	event_driver.register(elistener);
	driver = event_driver;
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Testutility.implicity_time, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Testutility.pageload_time, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
			}
}
