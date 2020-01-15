package com.logigear.trainning.test.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.trainning.common.Constant;
import com.logigear.trainning.page.BasePage;
import com.logigear.trainning.page.LoginPage;
import com.logigear.trainning.page.ParentPage;

public class Logout extends BasePage{	
	
	public ParentPage parentpage;
	public LoginPage loginpage;

	@Test
	public void TC_001_Logout_Successfully() {
		parentpage = new ParentPage(driver);
		parentpage.clickLoginItem();
		loginpage = new LoginPage(driver);
		loginpage.inputToUsernameTextbox(Constant.USERNAME);
		loginpage.inputToPasswordTextbox(Constant.PASSWORD);
		loginpage.scrollToLogin();
		loginpage.clickLoginButton();
		parentpage = new ParentPage(driver);
		parentpage.clickContactItem();
		parentpage.clickLogoutItem();

		// check point
		Assert.assertFalse(parentpage.checkLogoutItemExist());
	}	
}
