package com.newFramwork.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class FirtstPagelogin
{
	//1 .create object of webdriver
     WebDriver localdriver;
	
	public FirtstPagelogin(WebDriver rdriver)
	{
		localdriver=rdriver;
		
		PageFactory.initElements(rdriver,this);
	}
	
	//identify webelements
	
	@FindBy(xpath = "//input[@name=\"username\"]")
	WebElement usrnamelogin;
	
	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement password;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement submitbtn;
	
	
	
	public void usrnameLogin(String value)
	{
		usrnamelogin.sendKeys(value);
	}
	
	public void password(String num)
	{
		password.sendKeys(num);
	}
	public void login()
	{
		submitbtn.click();
	}
	
	
}
