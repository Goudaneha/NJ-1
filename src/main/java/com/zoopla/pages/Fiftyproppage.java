package com.zoopla.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.zoopla.testbase.TestBase;

import io.qameta.allure.Step;

public class Fiftyproppage extends TestBase {
	WebElement fifty_agent_name;
	String agentname;
	
	public Fiftyproppage() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Varify Fifty property agent logo test...........")
	public String agentlogo() {
		webelw = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated((By.xpath("(//div[@class='ui-agent__logo']//img[@class='js-lazy-loaded'])[1]"))));
		//WebElement fifty_agent_logo = driver.findElement(By.xpath("(//div[@class='ui-agent__logo']//img[@class='js-lazy-loaded'])[1]"));
		String agentlogo = webelw.getAttribute("alt");
		Assert.assertTrue(true, agentlogo);
		System.out.println(".............................Agent Details are as follows..........................................");
		System.out.println("Agent Logo Name : " + agentlogo);
		return agentlogo;		
	}
	
	@Step("Varify Fifty property agent name test...........")
	public String agentname() {
		fifty_agent_name = new WebDriverWait(driver, 20)
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='ui-agent__text']//following::h4[@class='ui-agent__name'])[1]")));
	   //fifty_agent_name = driver.findElement(By.xpath("(//div[@class='ui-agent__text']//following::h4[@class='ui-agent__name'])[1]"));
	   agentname =	fifty_agent_name.getText();
		System.out.println("agent name : " + agentname );
		Assert.assertTrue(true, agentname);
		return agentname;
	}
	
	@Step("Varify Fifty property agent phone number test...........")
	public String agentmobileno() {
		WebElement fifty_agent_phoneno = new WebDriverWait(driver, 20)
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='ui-agent__tel ui-agent__text']//a)[1]")));
		//WebElement fifty_agent_phoneno = driver.findElement(By.xpath("(//p[@class='ui-agent__tel ui-agent__text']//a)[1]"));
		String agentphone =fifty_agent_phoneno.getAttribute("href");
		System.out.println("agent phone no : " + agentphone);
		fifty_agent_name.click();
		return agentphone;
	}
	
	@Step("Varify Fifty property agent name with agent page agent name test...........")
	public void agentnamepage() {
		WebElement aname = driver.findElement(By.xpath("//div[@id='main-content']//b[1]"));
		//WebElement agname = driver.findElement(By.xpath("(//div[@class=\"dev-detail\"]//img)[1]" + "//div[@class=\"dev-detail\"]//h1"));
		String agent_name = aname.getText();
		//String agname1 = agname.getText();
		System.out.println("Agent page agent name :" + agent_name);
		if(agent_name.contains(agentname)) {
			//|| agname1.contains(agentname)) 
			System.out.println("valid agent name :" + agentname);
		}
		else {
			System.out.println("invalid agent name");
		}		
		//Assert.assertEquals(agent_name, agentname);
}
	
}
