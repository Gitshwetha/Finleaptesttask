package com.fin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fin.qa.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(id="username")
	WebElement username;

	@FindBy(id="password")
	WebElement password;

	@FindBy(id="kc-submit")
	WebElement submit;

	@FindBy(className="notification-text")
	WebElement errormsg;

	@FindBy(xpath="//div/div/div/div[1]/div/div/div/div[1]/p/span")
	WebElement welcomemsg;

	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	public  void login(String uname, String pword){

		username.sendKeys(uname);
		password.sendKeys(pword);
		submit.click();

	}
	public String validateErrormsg(){
		return errormsg.getText();
	}
	public String validateWelcomemsg(){
		return welcomemsg.getText();

	}
}