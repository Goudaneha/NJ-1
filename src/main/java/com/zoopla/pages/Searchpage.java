package com.zoopla.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.testbase.TestBase;

public class Searchpage extends TestBase {

	@FindBy(xpath = "//div[@class='ui-cookie-consent-choose']//button[2]")
	WebElement acceptcookies;
	
	@FindBy(name = "q")
	WebElement textbox;
	
	@FindBy(id = "search-submit")
	WebElement search_btn;
	
	@FindBy(xpath = "//div[@class='search-home']//h1")
	WebElement searchpagelabel;
	
	public Searchpage() {
		PageFactory.initElements(driver, this);
	}
	
	//@Step("Varify Home Page Label Test Step......")
	
	public String pagelabel() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", acceptcookies);
    	Thread.sleep(2000);
		return searchpagelabel.getText();
	}
	
	//@Step("Search Home with City Name :{0}")
	
	public Propertypage proppertysearch(String name) throws InterruptedException {
		textbox.sendKeys(name);		
		Thread.sleep(2000);
		search_btn.click();		
		return new Propertypage();
	}
}
