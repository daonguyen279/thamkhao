package com.logigear.trainning.test.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.trainning.common.Constant;
import com.logigear.trainning.page.BasePage;
import com.logigear.trainning.page.LoginPage;
import com.logigear.trainning.page.ParentPage;

public class Login extends BasePage{

	public LoginPage loginpage;
	public ParentPage parentpage;
	
	
	@Test(priority = 0)
	public void TC_001_Login_Successfully() {
		parentpage = new ParentPage(driver);
		parentpage.clickLoginItem();
		loginpage = new LoginPage(driver);
		loginpage.inputToUsernameTextbox(Constant.USERNAME);
		loginpage.inputToPasswordTextbox(Constant.PASSWORD);
		loginpage.scrollToLogin();
		loginpage.clickLoginButton();

		// check point
		Assert.assertEquals(loginpage.getTextFromWelcomeMessage(), Constant.WELCOME_MSG);
		parentpage = new ParentPage(driver);
		parentpage.clickLogoutItem();
	}

	@Test(priority = 1)
	public void TC_002_Login_With_Blank_Username() {

		parentpage = new ParentPage(driver);
		parentpage.clickLoginItem();
		loginpage = new LoginPage(driver);
		loginpage.inputToUsernameTextbox("");
		loginpage.inputToPasswordTextbox(Constant.PASSWORD);
		loginpage.scrollToLogin();
		loginpage.clickLoginButton();

		// check point
		Assert.assertEquals(loginpage.getTextFromInvalidUsernameMessage(), Constant.INVALID_USERNAME_MSG);
		
	}

	@Test(priority = 2)
	public void TC_003_Login_With_Blank_Account() {

		parentpage = new ParentPage(driver);
		parentpage.clickLoginItem();
		loginpage = new LoginPage(driver);
		loginpage.inputToUsernameTextbox(Constant.USERNAME);
		loginpage.inputToPasswordTextbox("");
		loginpage.scrollToLogin();
		loginpage.clickLoginButton();

		// check point
		Assert.assertEquals(loginpage.getTextFromInvalidPasswordMessage(), Constant.INVALID_PASSWORD_MSG);
	}
	@Test(priority = 3)
	public void TC_004_Login_With_Unactive_Email() {

		parentpage = new ParentPage(driver);
		parentpage.clickLoginItem();
		loginpage = new LoginPage(driver);
		loginpage.inputToUsernameTextbox(Constant.EMAIL);
		loginpage.inputToPasswordTextbox(Constant.PASSWORD);
		loginpage.scrollToLogin();
		loginpage.clickLoginButton();

		// check point
		Assert.assertEquals(loginpage.getTextFromInvalidInfoMessage(), Constant.INVALID_LOGIN_INFO_MSG);
		
	}

	

}
