package com.newFramwork.testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.newFramwork.pageobject.AddUserThirdPage;
import com.newFramwork.pageobject.FirtstPagelogin;
import com.newFramwork.pageobject.secondPageAdmin;
import com.newFramwork.utilities.RaedExcelFile;


public class TC_myAccountPageTestDataDrivenTest extends Baseclass  
{
	
	@Test (dataProvider = "loginDataProvider",priority = 1)
	public void verifyRegistrationAndLogin(String Username,String Password) throws InterruptedException 
	{
		
		logger.info("verify login test excecution started");
		FirtstPagelogin Login = new FirtstPagelogin(driver);
	    Login.usrnameLogin(Username);
		logger.info("username");
		Login.password(Password);
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
		admin.empnname("hgdq jhd hd");
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
		Assert.assertEquals("Damini@123","Damini@1235");
		AddDetail.savebutton();
	
	
	 }

	@DataProvider(name="loginDataProvider")
	public String[][]loginDataProvider()
	{
		String filename= System.getProperty("user.dir")+"\\testData\\NewFramwork_test_data.xlsx";
		
		int ttlRows = RaedExcelFile.getRowCount(filename,"Sheet1");
		
		int ttlColumn = RaedExcelFile.getColunmCount(filename,"Sheet1");
		
		String data[][]= new String[ttlRows-1][ttlColumn];
		for(int i=1;i<ttlRows;i++)
		{
			for(int j=0;j<ttlColumn;j++)
			{
				data[i-1][j]=RaedExcelFile.getCellValue(filename,"Sheet1", i, j);
			}
				
		}
		return data;
		
		
	}
}