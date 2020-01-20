package com.fin.qa.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fin.qa.base.TestBase;

public class SignUpPage extends TestBase{

	//Page Factory - OR:
	@FindBy(id="signup")
	WebElement signup;

	@FindBy(id="firstName")
	WebElement firstname;

	@FindBy(id="lastName")
	WebElement lastname;


	@FindBy(id="email")
	WebElement email;

	@FindBy(id="password")
	WebElement password;

	@FindBy(id="formTermsConsent")
	WebElement consent;

	@FindBy(id="kc-submit")
	WebElement submit;


	//Initializing the Page Objects:
	public SignUpPage(){
		PageFactory.initElements(driver, this);
	}

	public  void signup(String fname, String lname, String mail, String pwd){

		signup.click();
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		email.sendKeys(mail);
		password.sendKeys(pwd);
		consent.click();
		submit.click();
	}
	public boolean signupwithoutVal() {
		signup.click();
		Assert.assertFalse(submit.isEnabled());
		return true;

	}
}