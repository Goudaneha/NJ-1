package com.zoopla.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zoopla.pages.Propertypage;
import com.zoopla.pages.Searchpage;
import com.zoopla.testbase.TestBase;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class Propertytest extends TestBase{

	Propertypage prop_page;
	Searchpage home_page;	
	
	public Propertytest() {
		super();
	}

	@BeforeTest
	public void setup() throws InterruptedException {
	log.info("***************************Property Test Execution starts******************************");
		init(); 
		home_page = new Searchpage();
		prop_page = new Propertypage();
		home_page.pagelabel();
		String label = home_page.pagelabel();
		Assert.assertTrue(true, label);
		System.out.println("search page label :"+ label);
		Thread.sleep(2000);
		prop_page = home_page.proppertysearch(prop.getProperty("cityname"));
			}
	
	@Test(priority = 1,description = "Zoopla Title Test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case description : Zoopla Title Test")
	@Story("Story Name : Varify Title Test")
	public void Varifytitletest() throws InterruptedException {
		log.info("****************starts Property page title test*********************");
		String proptitle = prop_page.ZooplapropTitle();	
		Assert.assertEquals(proptitle, "Property for Sale in London - Buy Properties in London - Zoopla");
		Thread.sleep(2000);
		System.out.println("HeaderTitleTest : " + proptitle);
	log.info("****************ending Property page title test*********************");
		//Thread.sleep(3000);
	}
	
	@Test(priority = 2,description = "Zoopla Property List Page")
	@Severity(SeverityLevel.MINOR)
	@Description("Test case description : Zoopla Property List Test")
	@Story("Story Name : Varify Property List Test")
	public void VarifyListofPropTest() throws InterruptedException {
	log.info("****************strats Property list values test*********************");
		boolean logotest = prop_page.Zooplalogo();
	    Assert.assertTrue(logotest);
	    System.out.println(logotest);
		log.info("****************ending Property list values test*********************");

	}
	
	@Test(priority =3,description = "Get List of Property values")
	public void VarifyPropertyListValuesTest() {
		log.info("****************strats print Property values test*********************");
		//System.out.println("Total no of property values"+ prop_page.listofprop);
		prop_page.Zooplalistofpropvalues();
		log.info("****************ending print Property values test*********************");

	}
	@Test(priority = 4,description = "Get Fifty property values from list")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test case description : Zoopla Fifty property value Test")
	@Story("Story Name : Varify Fifty property value Test")
	public void Varify5thPropertyValuesTest() throws InterruptedException {
		log.info("****************starts click on fifth Property values test*********************");
		prop_page.ZooplaFifthPropValue();
    	log.info("****************ending click on fifth Property values test*********************");

	}
	
	@AfterTest
	private void teardown() {
	log.info("***************************Test Execution Terminates******************************");
	driver.quit();
	}
}
