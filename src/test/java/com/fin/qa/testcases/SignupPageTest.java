package com.fin.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fin.qa.util.TestUtil;
import com.fin.qa.base.TestBase;
import com.fin.qa.pages.SignUpPage;

public class SignupPageTest extends TestBase{
	SignUpPage signupPage;
	TestUtil testUtil;

	String sheetName = "details";

	public SignupPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		signupPage = new SignUpPage();	
	}

	@DataProvider
	public Object[][] getFINTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority=1, dataProvider="getFINTestData")
	public void signupTest(String fname, String lname, String email, String pword) throws InterruptedException{
		signupPage.signup(fname,lname,email,pword);

	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}