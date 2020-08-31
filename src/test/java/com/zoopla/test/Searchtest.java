package com.zoopla.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zoopla.pages.Propertypage;
import com.zoopla.pages.Searchpage;
import com.zoopla.testbase.TestBase;

public class Searchtest extends TestBase{

	Searchpage homepage;
	Propertypage proppage;
	
	public Searchtest() {
		super();
	}
	
	@BeforeTest
	public void setup() throws InterruptedException {
		log.info("******************Search Home Test Execution starts***********************");
		init();
		homepage = new Searchpage();
		}
	
	@Test(priority = 1,description = "Zoopla Home Page")
//	@Severity(SeverityLevel.CRITICAL)
//	@Description("Test case description : Zoopla Home Page Test")
//	@Story("Story Name : Varify Home page Label Test")
	public void VarifyHomepagelabeltest() throws InterruptedException {
		log.info("******************starts Label test***********************");
		
		String labelofpage = homepage.pagelabel();
		System.out.println("searchpagelabel : "+ labelofpage);
		Assert.assertEquals(labelofpage, "Search properties for sale or to rent in the UK","search page label not found");
		
		log.info("******************ending Label test***********************");
	}
	
	@Test(priority = 2,description = "Zoopla City Search Page")
//	@Severity(SeverityLevel.NORMAL)
//	@Description("Test case description : Zoopla City Search Page Test")
//	@Story("Story Name : Varify City Name Test")
	public void Varifycitynametest() throws InterruptedException {
		log.info("****************starts city name test*********************");
		
		proppage = homepage.proppertysearch(prop.getProperty("cityname"));
		
		log.info("****************ending city name test*********************");
	}
	
	@AfterTest
	public void teardown() {
		log.info("******************Test Execution Terminated***********************");
		driver.quit();
	}
}
