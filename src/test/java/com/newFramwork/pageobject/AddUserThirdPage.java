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

public class AddUserThirdPage 
{
	 WebDriver localdriver;
		
		public AddUserThirdPage (WebDriver rdriver)
		{
			localdriver=rdriver;
			
			PageFactory.initElements(rdriver,this);
		}
		
		@FindBy(xpath = "(//button[@type=\"button\"])[4]")
		WebElement Adduser;
		
		@FindBy(xpath = "(//div[@class=\"oxd-select-text oxd-select-text--active\"])[1]")
		WebElement userjRoll1;
		
		@FindBy(xpath = "//span[contains(text(),'Admin')]")
		WebElement adminOpEnter;
		
		@FindBy(xpath="(//div[@class=\"oxd-select-text-input\"])[2]")
		WebElement SelectStatus3page;
		
		@FindBy(xpath = "//span[contains(text(),'Enabled')]")
		WebElement stausselected;
		
		@FindBy(xpath = "//input[@placeholder=\"Type for hints...\"]")
		WebElement empNameFor3pag;
		
		@FindBy(xpath = "//div[@role='listbox']")
		WebElement EmpList;
		
		@FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[2]")
		WebElement usernameOf3Page;
		
		@FindBy(xpath = "(//input[@type=\"password\"])[1]")
		WebElement password;
		
		@FindBy(xpath = "(//input[@type=\"password\"])[2]")
		WebElement password2;
		
		@FindBy(xpath = "//button[@type=\"submit\"]")
		WebElement savebtn;
		
		
		public void Adduserdetails()
		{
			Adduser.click();
		}
		
		public void AddRoll1st()
		{
			userjRoll1.click();
				
		}
		public void OptionEnterUser()
		{
			adminOpEnter.click();
		}
		
		public void SelectStaus3page()
		{
			SelectStatus3page.click();
		}
		public void stausselectfor3page()
		{
			stausselected.click();
		}
		
		public void EmpNameThirdPage(String Value)
		{
			empNameFor3pag.sendKeys(Value);
			WebElement emp = EmpList.findElement(By.xpath("//*[text()='"+Value+"']")); 
			
			WebDriverWait Wait = new WebDriverWait(localdriver,Duration.ofSeconds(10)); 
			Wait.until(ExpectedConditions.visibilityOf(emp)); 
			 Actions act=new Actions(localdriver);  
			   act.moveToElement(emp).click().build().perform();  
			
		}
		
		public void Uname3page(String value)

		{
			usernameOf3Page.sendKeys(value);
		}
		
		public void password(String value)
		{
			password.sendKeys(value);
		}
		
		public void pwd2(String value)
		{
			password2.sendKeys(value);
		}
		
		public void savebutton()
		{
			savebtn.click();
		}
}
