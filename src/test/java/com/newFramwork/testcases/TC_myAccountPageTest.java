package com.newFramwork.testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.newFramwork.pageobject.AddUserThirdPage;
import com.newFramwork.pageobject.FirtstPagelogin;
import com.newFramwork.pageobject.secondPageAdmin;


public class TC_myAccountPageTest extends Baseclass  
{
	@Test (priority = 1)
	public void verifyRegistrationAndLogin() throws InterruptedException 
	{
		
		logger.info("verify login test excecution started");
		FirtstPagelogin Login = new FirtstPagelogin(driver);
	    Login.usrnameLogin("Admin");
		logger.info("username");
		Login.password("admin123");
		logger.info("passwordfirstpag");
		Login.login();
		logger.info("click on login");
		
		
	}
	
	@Test (priority = 4)
	public void TC001_CHECK() throws InterruptedException 
	{
		
		logger.info("verify login test excecution started");
		FirtstPagelogin Login = new FirtstPagelogin(driver);
	    Login.usrnameLogin("Admin");
		logger.info("username");
		Login.password("admin123");
		logger.info("passwordfirstpag");
		Login.login();
		logger.info("click on login");
		
		
	}


	
	
	@Test(priority = 2)
	public void SecondPage()
	{
		
		secondPageAdmin admin = new secondPageAdmin(driver);
		admin.admin();
		logger.info("click on admin module");
		admin.enterUsername("Admin");
		logger.info("enter username");
		admin.userRoll();
		logger.info("enter user Roll");
		admin.selctuserRoll();
		logger.info("select roll");
		admin.empnname("Vikrant Nitin kadam");
		logger.info("enter EMP name");
		admin.status();
	    logger.info("status");
		admin.selectStatus();
		logger.info("select status");
		admin.searchbtn();
		logger.info("click on search btn");
		
		
	}
	
	@Test(priority = 3)
	public void verifyAddDetails() throws IOException
	{
		//FirtstPagelogin Login = new FirtstPagelogin(driver);    
	    //Login.usrnameLogin("Admin");
	    //Login.password("admin123");
	    //Login.login();
	    
	    //secondPageAdmin admin = new secondPageAdmin(driver);
		//admin.admin();
		
		AddUserThirdPage AddDetail = new AddUserThirdPage(driver);
		logger.info("verifyAddDetails");
		AddDetail.Adduserdetails();
		logger.info("add user name");
		AddDetail.AddRoll1st();
		logger.info("add roll");
		AddDetail.OptionEnterUser();
		logger.info("enter option");
		AddDetail.SelectStaus3page();
		logger.info("select staus");
		AddDetail.stausselectfor3page();
		logger.info("status");
		AddDetail.EmpNameThirdPage("Paul  Collings");
		logger.info("enetr empname3");
		AddDetail.Uname3page("Damini Meshram");
		logger.info("enter uname damini");
		AddDetail.password("Damini@123");
		logger.info("enter psw");
		AddDetail.pwd2("Damini@1235");
		logger.info("enter confirm pass");
		captureScreenshot(driver,"verifyAddDetails");
		Assert.assertEquals("Damini@123","Damini@123");
		AddDetail.savebutton();
	
	
	
  }
}