package com.logigear.trainning.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.logigear.trainning.common.Common;

public class ForgotPasswordPage extends Common {

	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
	}

	JavascriptExecutor js;
	WebDriver driver;
	WebElement txtNewPassword;
	WebElement txtCfPassword;
	WebElement txtPasswordToken;
	WebElement btnResetPassword;
	WebElement msgUnableChangePass;

	public void inputToNewPassWordTextbox(String value) {
		txtNewPassword = driver.findElement(By.xpath("//input[@id='newPassword']"));
		waitForElementVisible(driver, txtNewPassword);
		sendKeyToElement(driver, txtNewPassword, value);
	}
	public void inputToCfPassWordTextbox(String value) {
		txtCfPassword = driver.findElement(By.xpath("//input[@id='confirmPassword']"));
		waitForElementVisible(driver, txtCfPassword);
		sendKeyToElement(driver, txtCfPassword, value);
	}
	public void inputToTokenPassWordTextbox(String value) {
		txtPasswordToken = driver.findElement(By.xpath("//input[@id='resetToken']"));
		waitForElementVisible(driver, txtPasswordToken);
		sendKeyToElement(driver, txtPasswordToken, value);
	}
	public void clickChangeButton() {
		btnResetPassword = driver.findElement(By.xpath("//input[@type='submit']"));
		waitForElementVisible(driver, btnResetPassword);
		clickToElement(driver, btnResetPassword);
	}
	public void scrollToResetPassword() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		btnResetPassword = driver.findElement(By.xpath("//input[@type='submit']"));
		js.executeScript("arguments[0].scrollIntoView();",btnResetPassword );
	}
	public void clearToken() {
		txtPasswordToken = driver.findElement(By.xpath("//input[@id='resetToken']"));
		waitForElementVisible(driver, txtPasswordToken);
		clearElement(driver, txtPasswordToken);
	}
	public String getTextFromUnableToChangePassMessage() {
		msgUnableChangePass = driver.findElement(By.xpath("//p[@class='message error']"));
		waitForElementVisible(driver, msgUnableChangePass);
		return getTextFromElement(driver, msgUnableChangePass);
	}
	
}
