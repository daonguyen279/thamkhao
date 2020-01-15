package com.logigear.trainning.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.logigear.trainning.common.Common;

public class ChangePasswordPage  extends Common{
	
	public ChangePasswordPage(WebDriver driver) {		
		this.driver = driver;
	}
	JavascriptExecutor js;
	WebDriver driver;
	WebElement txtCurrentPass ;
	WebElement txtNewPass ;
	WebElement txtConfirmPass ;
	WebElement btnChange ;
	WebElement msgInvalidCfPassword;
	public void inputToCurrentPassWordTextbox(String value) {		
		txtCurrentPass = driver.findElement(By.xpath("//input[@id='currentPassword']"));
		waitForElementVisible(driver, txtCurrentPass);
		sendKeyToElement(driver, txtCurrentPass, value);
	}

	public void inputToNewPasswordTextbox(String value) {		
		txtNewPass = driver.findElement(By.xpath("//input[@id='newPassword']"));
		waitForElementVisible(driver, txtNewPass);
		sendKeyToElement(driver, txtNewPass, value);
	}
	public void inputToConfirmPasswordTextbox(String value) {		
		txtConfirmPass = driver.findElement(By.xpath("//input[@id='confirmPassword']"));
		waitForElementVisible(driver, txtConfirmPass);
		sendKeyToElement(driver, txtConfirmPass, value);
	}
	public void scrollToChange() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		btnChange = driver.findElement(By.xpath("//input[@type='submit']"));
		js.executeScript("arguments[0].scrollIntoView();",btnChange );
	}
	public void clickChangeButton() {
		btnChange = driver.findElement(By.xpath("//input[@type='submit']"));
		waitForElementVisible(driver, btnChange);
		clickToElement(driver, btnChange);
	}
	public String getTextFromInvalidConfirmPasswordMessage() {
		msgInvalidCfPassword = driver.findElement(By.xpath("//label[(@for='confirmPassword')and(@class='validation-error')]"));
		waitForElementVisible(driver, msgInvalidCfPassword);
		return getTextFromElement(driver, msgInvalidCfPassword);
	}
}
