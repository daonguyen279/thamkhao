package com.logigear.trainning.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.logigear.trainning.common.Common;

public class RegisterPage extends Common {

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	JavascriptExecutor js;
	WebDriver driver;
	WebElement txtEmail;
	WebElement txtPassword;
	WebElement txtCfPassword;
	WebElement txtPid;
	WebElement msgEmail;
	WebElement msgPassword;
	WebElement msgSuccess;
	WebElement btnRegister;
	WebElement msgExistEmail;
	WebElement msgInvalidId;
	WebElement linkForgotPass;

	public void inputToEmailTextbox(String value) {

		txtEmail = driver.findElement(By.xpath("//input[@id='email']"));
		waitForElementVisible(driver, txtEmail);
		sendKeyToElement(driver, txtEmail, value);
	}

	public void inputToPasswordTextbox(String value) {

		txtPassword = driver.findElement(By.xpath("//input[@id='password']"));
		waitForElementVisible(driver, txtPassword);
		sendKeyToElement(driver, txtPassword, value);
	}

	public void inputToConfirmPasswordTextbox(String value) {

		txtPassword = driver.findElement(By.xpath("//input[@id='confirmPassword']"));
		waitForElementVisible(driver, txtPassword);
		sendKeyToElement(driver, txtPassword, value);
	}

	public void inputPidTextbox(String value) {

		txtPid = driver.findElement(By.xpath("//input[@id='pid']"));
		waitForElementVisible(driver, txtPid);
		sendKeyToElement(driver, txtPid, value);
	}

	public void clickRegisterButton() {

		btnRegister = driver.findElement(By.xpath("//input[@type='submit']"));
		waitForElementVisible(driver, btnRegister);
		clickToElement(driver, btnRegister);
	}
	public void clickForgotPwLink() {

		linkForgotPass = driver.findElement(By.xpath("//a[contains(text(),'Forgot Password page')]"));
		waitForElementVisible(driver, linkForgotPass);
		clickToElement(driver, linkForgotPass);
	}

	public void scrollToRegister() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		btnRegister = driver.findElement(By.xpath("//input[@type='submit']"));
		js.executeScript("arguments[0].scrollIntoView();", btnRegister);
	}

	public String getTextFromSuccessMessage() {

		msgSuccess = driver.findElement(By.xpath("//div[@id='content']/h1"));
		waitForElementVisible(driver, msgSuccess);
		return getTextFromElement(driver, msgSuccess);
	}

	public String getTextFromInvalidPasswordMessage() {

		msgPassword = driver.findElement(By.xpath("//label[(@for='password')and(@class='validation-error')]"));
		waitForElementVisible(driver, msgPassword);
		return getTextFromElement(driver, msgPassword);
	}

	public String getTextFromInvalidEmailMessage() {

		msgEmail = driver.findElement(By.xpath("//label[(@for='email')and(@class='validation-error')]"));
		waitForElementVisible(driver, msgEmail);
		return getTextFromElement(driver, msgEmail);
	}

	public String getTextFromExistEmailMessage() {

		msgExistEmail = driver.findElement(By.xpath("//p[@class='message error']"));
		waitForElementVisible(driver, msgExistEmail);
		return getTextFromElement(driver, msgExistEmail);
	}
	public String getTextFromInvalidPIDMessage() {

		msgInvalidId = driver.findElement(By.xpath("//label[(@for='pid')and(@class='validation-error')]"));
		waitForElementVisible(driver, msgInvalidId);
		return getTextFromElement(driver, msgInvalidId);
	}
	

}
