package com.logigear.trainning.test.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.trainning.common.Constant;
import com.logigear.trainning.common.Utility;
import com.logigear.trainning.page.BasePage;
import com.logigear.trainning.page.ParentPage;
import com.logigear.trainning.page.RegisterPage;

public class Register extends BasePage {

	public RegisterPage registerpage;
	public ParentPage parentpage;

	@Test(priority = 0)
	public void TC_001_Register_Successfully() {
		parentpage = new ParentPage(driver);
		parentpage.clickRegisterItem();
		registerpage = new RegisterPage(driver);
		registerpage.inputToEmailTextbox(Utility.getValidEmail());
		registerpage.scrollToRegister();
		registerpage.inputToPasswordTextbox(Constant.PASSWORD);
		registerpage.inputToConfirmPasswordTextbox(Constant.PASSWORD);
		registerpage.inputPidTextbox(Constant.PASSWORD);
		registerpage.scrollToRegister();
		registerpage.clickRegisterButton();

		// check point
		Assert.assertEquals(registerpage.getTextFromSuccessMessage(), Constant.REGISTERSUCCESS_MSG);
		parentpage = new ParentPage(driver);
	}

	@Test(priority = 1)
	public void TC_002_Register_UnSuccessfully_With_Exist_Email() {
		parentpage = new ParentPage(driver);
		parentpage.clickRegisterItem();
		registerpage = new RegisterPage(driver);
		registerpage.inputToEmailTextbox(Constant.USERNAME);
		registerpage.scrollToRegister();
		registerpage.inputToPasswordTextbox(Constant.PASSWORD);
		registerpage.inputToConfirmPasswordTextbox(Constant.PASSWORD);
		registerpage.inputPidTextbox(Constant.PASSWORD);
		registerpage.scrollToRegister();
		registerpage.clickRegisterButton();

		// check point
		Assert.assertEquals(registerpage.getTextFromExistEmailMessage(), Constant.EXISTEMAIL_MSG);
		parentpage = new ParentPage(driver);
	}

	@Test(priority = 2)
	public void TC_003_Register_UnSuccessfully_With_Blank_PID() {
		parentpage = new ParentPage(driver);
		parentpage.clickRegisterItem();
		registerpage = new RegisterPage(driver);
		registerpage.inputToEmailTextbox(Constant.USERNAME);
		registerpage.scrollToRegister();
		registerpage.inputToPasswordTextbox(Constant.PASSWORD);
		registerpage.inputToConfirmPasswordTextbox(Constant.PASSWORD);
		registerpage.inputPidTextbox("");
		registerpage.scrollToRegister();
		registerpage.clickRegisterButton();

		// check point
		Assert.assertEquals(registerpage.getTextFromInvalidPIDMessage(), Constant.INVALIDPID_MSG);
		parentpage = new ParentPage(driver);
	}

}
