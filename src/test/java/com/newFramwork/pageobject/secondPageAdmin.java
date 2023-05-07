package com.newFramwork.pageobject;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class secondPageAdmin 
{

   
	public static WebDriver ldriver;
	
	
	public secondPageAdmin (WebDriver rDriver)
	{
		ldriver=rDriver;
		PageFactory.initElements(rDriver,this);
	}
	
	@FindBy(xpath = "//span[text()=\"Admin\"]")
	WebElement Admin;
	
	@FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[2]")
	WebElement username;
	
	@FindBy(xpath = "(//div[@class=\"oxd-select-text oxd-select-text--active\"])[1]")
	WebElement userRoll;

	@FindBy(xpath = "//span[contains(text(),'Admin')]")
	WebElement userRollfor;
	
	@FindBy(xpath="//input[@placeholder=\"Type for hints...\"]")
	WebElement employeeNameSearchBox;
	
	@FindBy(xpath = "//div[@role='listbox']")
	WebElement employeeName;
	
	@FindBy(xpath = "(//div[@class=\"oxd-select-text oxd-select-text--active\"])[2]")
	WebElement status;
	
	@FindBy(xpath = "//span[contains(text(),'Enabled')]")
	WebElement selectStatus;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement searchbtn;
	
	
	public void admin()
	{
		Admin.click();
	}
	
	public void enterUsername(String name)
	{
		username.sendKeys(name);
	}
	
	public void userRoll()
	{
		userRoll.click();
		
	}
	public void selctuserRoll()
	{
		userRollfor.click();
	}
	public void empnname(String value)
	{
		employeeNameSearchBox.sendKeys(value);
	   	WebElement abc = employeeName.findElement(By.xpath("//*[text()='"+value+"']"));
	   	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
	   	wait.until(ExpectedConditions.visibilityOf(abc));
	   Actions act=new Actions(ldriver);
	   act.moveToElement(abc).click().build().perform();
	   	
	}
	
	public void status() 
	{
		status.click();
	}
	public void selectStatus()
	{
		selectStatus.click();
	}
	
	public void searchbtn()
	{
		
		searchbtn.click();
	}
}
