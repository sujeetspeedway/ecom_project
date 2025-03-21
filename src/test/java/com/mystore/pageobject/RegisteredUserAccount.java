package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserAccount {
	WebDriver ldriver;
	public RegisteredUserAccount(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//for validating username
	@FindBy(xpath="//a[@title='View my customer account']")
	WebElement userName;
	
	//for sign out
	@FindBy(linkText= "Sign out")
	WebElement signOut;
	
	public String verifyAcc()
	{
		 String text=userName.getText();
		 return text;
	}
	//for sign out
	public void clickOnSignout()
	{
		 signOut.click();
	}
	
}