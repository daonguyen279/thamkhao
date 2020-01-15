package com.logigear.trainning.test.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.trainning.common.Constant;
import com.logigear.trainning.common.EmailUtils;
import com.logigear.trainning.page.BasePage;
import com.logigear.trainning.page.ForgotPasswordPage;
import com.logigear.trainning.page.LoginPage;
import com.logigear.trainning.page.ParentPage;

public class ForgotPassword extends BasePage {
	public LoginPage loginpage;
	public ParentPage parentpage;
	public ForgotPasswordPage forgotpasspage;

	@Test(priority = 0)
	public void TC_001_Reset_Password_with_Blank_Token() {
		parentpage = new ParentPage(driver);
		parentpage.clickLoginItem();
		loginpage = new LoginPage(driver);
		loginpage.scrollToLogin();
		loginpage.clickForgotPasswordLink();
		loginpage.inputToEmailTextbox(Constant.USERNAME);
		loginpage.scrollToLogin();
		loginpage.clickSendInstructionsbutton();
		EmailUtils.connectMail();
		EmailUtils.goToLinkWithinMail(driver);
		forgotpasspage = new ForgotPasswordPage(driver);
		forgotpasspage.inputToNewPassWordTextbox(Constant.NEWPASSWORD);
		forgotpasspage.inputToCfPassWordTextbox(Constant.NEWPASSWORD);
		forgotpasspage.clearToken();
		forgotpasspage.clickChangeButton();

//		 check point
		Assert.assertEquals(forgotpasspage.getTextFromUnableToChangePassMessage(), Constant.UNABLE_TO_CHANGE_PASS_MSG);

	}
	@Test(priority = 1)
	public void TC_002_Reset_Password_with_Password_Does_Not_Match() {
		parentpage = new ParentPage(driver);
		parentpage.clickLoginItem();
		loginpage = new LoginPage(driver);
		loginpage.scrollToLogin();
		loginpage.clickForgotPasswordLink();
		loginpage.inputToEmailTextbox(Constant.USERNAME);
		loginpage.scrollToLogin();
		loginpage.clickSendInstructionsbutton();
		EmailUtils.connectMail();
		EmailUtils.goToLinkWithinMail(driver);
		forgotpasspage = new ForgotPasswordPage(driver);
		forgotpasspage.inputToNewPassWordTextbox(Constant.NEWPASSWORD);
		forgotpasspage.inputToCfPassWordTextbox(Constant.PASSWORD);		
		forgotpasspage.clickChangeButton();

//		 check point
		Assert.assertEquals(forgotpasspage.getTextFromUnableToChangePassMessage(), Constant.UNABLE_TO_CHANGE_PASS_MSG);

	}

}
