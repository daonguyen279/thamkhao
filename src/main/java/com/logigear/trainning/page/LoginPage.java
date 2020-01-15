package com.logigear.trainning.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.logigear.trainning.common.Common;

public class LoginPage extends Common {

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	JavascriptExecutor js;
	WebDriver driver;
	WebElement txtUsername ;
	WebElement msgWelcome ;
	WebElement msgPassword ;
	WebElement msgUsername ;
	WebElement msgInfo ;
	WebElement txtPassword ;
	WebElement txtEmail ;
	WebElement btnLogin ;
	WebElement btnSendInsstruction ;
	WebElement linkForgotPassword ;
	
	

	public void inputToUsernameTextbox(String value) {		
		txtUsername = driver.findElement(By.xpath("//input[@id='username']"));
		waitForElementVisible(driver, txtUsername);
		sendKeyToElement(driver, txtUsername, value);
	}

	public void inputToPasswordTextbox(String value) {
		txtPassword = driver.findElement(By.xpath("//input[@id='password']"));
		waitForElementVisible(driver, txtPassword);
		sendKeyToElement(driver, txtPassword, value);
	}

	public void clickLoginButton() {
		btnLogin = driver.findElement(By.xpath("//input[@type='submit']"));
		waitForElementVisible(driver, btnLogin);
		clickToElement(driver, btnLogin);
	}
	
	public void scrollToLogin() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		btnLogin = driver.findElement(By.xpath("//input[@type='submit']"));
		js.executeScript("arguments[0].scrollIntoView();",btnLogin );
	}

	public String getTextFromWelcomeMessage() {
		msgWelcome = driver.findElement(By.xpath("//div[@id='content']/h1"));
		waitForElementVisible(driver, msgWelcome);
		return getTextFromElement(driver, msgWelcome);
	}

	public String getTextFromInvalidPasswordMessage() {
		msgPassword = driver.findElement(By.xpath("//label[(@for='password')and(@class='validation-error')]"));
		waitForElementVisible(driver, msgPassword);
		return getTextFromElement(driver, msgPassword);
	}

	public String getTextFromInvalidUsernameMessage() {
		msgUsername = driver.findElement(By.xpath("//label[(@for='username')and(@class='validation-error')]"));
		waitForElementVisible(driver, msgUsername);
		return getTextFromElement(driver, msgUsername);
	}
	public String getTextFromInvalidInfoMessage() {
		msgInfo = driver.findElement(By.xpath("//p[@class='message error LoginForm']"));
		waitForElementVisible(driver, msgInfo);
		return getTextFromElement(driver, msgInfo);
	}
	public void clickForgotPasswordLink() {
		linkForgotPassword = driver.findElement(By.xpath("//a[.='Forgot Password page']"));
		waitForElementVisible(driver, linkForgotPassword);
		clickToElement(driver, linkForgotPassword);
	}
	public void inputToEmailTextbox(String value) {
		txtEmail = driver.findElement(By.xpath("//input[@id='email']"));
		waitForElementVisible(driver, txtEmail);
		sendKeyToElement(driver, txtEmail, value);
	}
	public void clickSendInstructionsbutton() {
		btnSendInsstruction = driver.findElement(By.xpath("//input[@value='Send Instructions']"));
		waitForElementVisible(driver, btnSendInsstruction);
		clickToElement(driver, btnSendInsstruction);
	}

}
