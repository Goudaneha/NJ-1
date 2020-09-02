package com.zoopla.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.testbase.TestBase;

import io.qameta.allure.Step;

public class Propertypage extends TestBase {
	@FindBy(xpath = "//div[@class=\"css-1mjljx5 eson0er0\"]//a[@aria-label=\"Zoopla\"]")
	WebElement proppagelogo;
	
	@FindBy(xpath = "//div[@id='content']//following::h1")
	WebElement proppageheader;
	
	@FindBy(xpath = "//*[@class='listing-results-right clearfix']")
	public List<WebElement> price_list;	
	int i,j;
	ArrayList<String> alist = new ArrayList<String>();
//	@FindBy(xpath = "//*[@class='listing-results-right clearfix']//following::a[@class='listing-results-price text-price']")
//	public WebElement prop_values;
	
	public Propertypage() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Varify Property page title test...........")
	public String ZooplapropTitle() {
		return driver.getTitle();
	}
	
	@Step("Varify Property page logo test...........")
	public boolean Zooplalogo() {
		return proppagelogo.isDisplayed();
	}
	
	@Step("Varify list of property values test...........")
	public void Zooplalistofpropvalues() {
		System.out.println(".........List of property values in descending order................");
        int listofprop = price_list.size();
		for(i=1; i<=listofprop; i++)
		{
		String val =driver.findElement(By.xpath("//*[@class='listing-results-right clearfix']"
				+ "//following::a[@class='listing-results-price text-price']["+i+"]")).getText();
		alist.add(val);
		Collections.sort(alist,Collections.reverseOrder());
		}
		for (String propval : alist) 
		{
		    System.out.println(propval);		    
		}		
		  System.out.println("........................................................");
		  System.out.println("5th elemet from descending order list: "+alist.get(i=5));	
	}
	
	@Step("Varify value of Fifty Property test...........")
	public Fiftyproppage ZooplaFifthPropValue() throws InterruptedException {
	 int listofprop = price_list.size();
	 for(j=1; j<=listofprop; j++) {
	  if(j==5) {
		WebElement Fifty_prop_val = driver.findElement(By.xpath("//*[@class='listing-results-right clearfix'] "
				+  "//following::a[@class='listing-results-price text-price']["+j+"]"));
		String fiftyval = Fifty_prop_val.getText();
		Fifty_prop_val.click();	
		 //	driver.switchTo().activeElement();
		 	System.out.println("5th property value is :" + fiftyval);
		 	System.out.println("Title of 5th property is : "+driver.getTitle());	
	  }
	 }
	 return new Fiftyproppage();
	}
}
