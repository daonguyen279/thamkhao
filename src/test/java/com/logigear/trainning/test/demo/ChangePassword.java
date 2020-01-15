package com.logigear.trainning.test.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.trainning.common.Constant;
import com.logigear.trainning.page.BasePage;
import com.logigear.trainning.page.ChangePasswordPage;
import com.logigear.trainning.page.LoginPage;
import com.logigear.trainning.page.ParentPage;

public class ChangePassword extends BasePage {
	public ChangePasswordPage changepasspage;
	public ParentPage parentpage;
	public LoginPage loginpage;

	@Test
	public void TC_001_Change_Password_Unsuccessfully() {
		parentpage = new ParentPage(driver);
		parentpage.clickLoginItem();
		loginpage = new LoginPage(driver);
		loginpage.inputToUsernameTextbox(Constant.USERNAME);
		loginpage.inputToPasswordTextbox(Constant.PASSWORD);
		loginpage.scrollToLogin();
		loginpage.clickLoginButton();
		parentpage = new ParentPage(driver);
		parentpage.clickChangePasswordItem();
		changepasspage = new ChangePasswordPage(driver);
		changepasspage.inputToCurrentPassWordTextbox(Constant.PASSWORD);
		changepasspage.scrollToChange();
		changepasspage.inputToNewPasswordTextbox(Constant.NEWPASSWORD);
		changepasspage.inputToConfirmPasswordTextbox(Constant.PASSWORD);
		changepasspage.scrollToChange();
		changepasspage.clickChangeButton();

		// check point
		Assert.assertEquals(changepasspage.getTextFromInvalidConfirmPasswordMessage(), Constant.INVALID_CF_PASSWORD_MSG);
	}
}
