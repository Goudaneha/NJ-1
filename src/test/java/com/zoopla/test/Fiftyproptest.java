package com.zoopla.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zoopla.pages.Fiftyproppage;
import com.zoopla.pages.Propertypage;
import com.zoopla.pages.Searchpage;
import com.zoopla.testbase.TestBase;

public class Fiftyproptest extends TestBase{

	Searchpage searchpage;	
	Propertypage proppage;
	Fiftyproppage fiftypage;
	Searchtest searchtest;
	Propertytest proptest;
	
	public Fiftyproptest() {
		super();
	}
	
	@BeforeTest
	public void setup() throws InterruptedException {
		/***************************Test Execution starts******************************/
		init();
		searchpage = new Searchpage();
		fiftypage = new Fiftyproppage();
		proptest = new Propertytest();
		String pagelabel = searchpage.pagelabel();
		Assert.assertTrue(true, pagelabel);
		System.out.println("search page label :"+ pagelabel);
		Thread.sleep(2000);
		proppage = searchpage.proppertysearch(prop.getProperty("cityname"));
	}
	
	@Test(priority = 1,description = "Agent Logo")
	public void Varifyagentlogotest() throws InterruptedException {
		//log.info("********Starts Agent log test*********");		
		fiftypage.agentlogo();		
		//log.info("****************ending Agent log test*********************");

	}
	
	@Test(priority = 2,description = "Agent Name")
	public void Varifyagentnametest() throws InterruptedException {
		//log.info("********starts Agent name test*********");
		fiftypage.agentname();
		//log.info("********ending Agent name test*********");
	}
	
	@Test(priority = 3,description = "Agent Mobil number")
	public void Varifyagentnotest() throws InterruptedException {
		//log.info("*******************starts Agent phone no test******************");
		fiftypage.agentmobileno();
		//log.info("********ending Agent name test*********");
	}
	
	@Test(priority = 4,description = "validate agent name")
	public void Validateagentnametest() throws InterruptedException {
		//log.info("*************starts Agent name varification*****************");
		fiftypage.agentnamepage();
		//log.info("*************ending Agent name varification*****************");

	}
	@AfterTest
	public void teardown() {
		//log.info("********************Test case execution terminates*******************");
		//driver.close();
	}
}
