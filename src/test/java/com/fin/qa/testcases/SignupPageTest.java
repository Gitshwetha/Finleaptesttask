package com.fin.qa.testcases;

import org.junit.Assert;
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
	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser 
	//@test -- execute test case to Sign up into Finleap application
	//after each test case -- close the browser
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
	public void signupTest(String fname, String lname, String email, String pword) {
		signupPage.signup(fname,lname,email,pword);

	}
	@Test(priority=2, dataProvider="getFINTestData")
	public void emailAlreadypresent(String fname, String lname, String email, String pword) {
		signupPage.signup(fname,lname,email,pword);
		Assert.assertEquals(signupPage.duplicateEmail(), prop.getProperty("emaildup"));

	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}