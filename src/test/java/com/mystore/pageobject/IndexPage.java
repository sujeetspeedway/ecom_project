package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	
	//create object of webdriver
	WebDriver ldriver;
	public IndexPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
    //identify webelement...in page object model with page factory we use @FindBy anno..
	@FindBy(linkText= "Sign in")
	WebElement signIn;
	

	//perform action
	public void clickOnSignIn()
	{
		signIn.click();
	}
			
}