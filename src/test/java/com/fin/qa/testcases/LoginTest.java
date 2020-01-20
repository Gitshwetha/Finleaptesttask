package com.fin.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fin.qa.util.TestUtil;
import com.fin.qa.base.TestBase;
import com.fin.qa.pages.LoginPage;

public class LoginTest extends TestBase{
	LoginPage loginPage;
	TestUtil testUtil;

	String sheetName = "vadetails";
	String insheetName = "indetails";

	public LoginTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
		testUtil = new TestUtil();
	}
	@DataProvider
	public Object[][] getFINTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority=1,dataProvider="getFINTestData")
	public void validloginTest(String uname, String pword) throws InterruptedException{
		loginPage.login(uname, pword);
		Assert.assertEquals(loginPage.validateWelcomemsg(), prop.getProperty("success"));

	}
	@DataProvider
	public Object[][] getFINinTestData(){
		Object data[][] = TestUtil.getTestData(insheetName);
		return data;
	}
	@Test(priority=2,dataProvider="getFINinTestData")
	public void invalidloginTest(String inuname, String inpword){
		loginPage.login(inuname, inpword);
		Assert.assertEquals(loginPage.validateErrormsg(), prop.getProperty("emsg"));

	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}