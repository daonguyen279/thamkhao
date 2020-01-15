package com.logigear.trainning.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {
	WebElement element;
	WebDriverWait waitExplicit;
	Select select;

	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}
	
	public void clearElement(WebDriver driver, WebElement element) {
		element.clear();
	}

	public void sendKeyToElement(WebDriver driver, WebElement element, String value) {
		element.sendKeys(value);
	}

	public boolean checkElementDisplay(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}

	public void selectElement(WebDriver driver, WebElement element, String value) {

		select = new Select(element);
		select.selectByVisibleText(value);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void waitForElementVisible(WebDriver driver, WebElement element) {
		waitExplicit = new WebDriverWait(driver, Constant.SHORTTIME);
		waitExplicit.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementVisible(WebDriver driver,String locator,String ...values) {
		locator = String.format(locator, (Object[])values);
		element = driver.findElement(By.xpath(locator));
		waitExplicit = new WebDriverWait(driver, Constant.SHORTTIME);
		waitExplicit.until(ExpectedConditions.visibilityOf(element));
	}
	
	public boolean isElementDisplay(WebDriver driver,String locator,String ...values) {
		locator = String.format(locator, (Object[])values);
		element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}
	
	
	public String getTextFromElement(WebDriver driver, WebElement element) {
		return element.getText();
	}

	public String getCurrentDay() {
		DateFormat dateFormat = new SimpleDateFormat("M/dd/yyyy");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		return dateFormat.format(date);
	}

	public String getPlusDay(int day) {
		DateFormat dateFormat = new SimpleDateFormat("M/dd/yyyy");
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date());
	    cal.add(Calendar.DATE, day);
	    String newDate = dateFormat.format(cal.getTime());
	    return newDate;
	}

}
