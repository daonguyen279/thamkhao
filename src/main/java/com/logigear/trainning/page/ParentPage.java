package com.logigear.trainning.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.logigear.trainning.common.Common;

public class ParentPage extends Common {

	WebDriver driver;
	WebElement itemLogout;
	WebElement itemLogin;
	WebElement itemHome;
	WebElement itemChangePassword;
	WebElement itemRegister;
	WebElement itemBookTicket;
	WebElement itemContact;
	WebElement itemMyTicket;

	public ParentPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickLoginItem() {
		itemLogin = driver.findElement(By.xpath("//span[contains(text(),'Login')]"));
		waitForElementVisible(driver, itemLogin);
		clickToElement(driver, itemLogin);
	}

	public void clickLogoutItem() {
		itemLogout = driver.findElement(By.xpath("//span[contains(text(),'Log out')]"));
		waitForElementVisible(driver, itemLogout);
		clickToElement(driver, itemLogout);
	}

	public void clickHomeItem() {
		itemHome = driver.findElement(By.xpath("//span[contains(text(),'Home')]"));
		waitForElementVisible(driver, itemHome);
		clickToElement(driver, itemHome);
	}

	public void clickChangePasswordItem() {
		itemChangePassword = driver.findElement(By.xpath("//span[contains(text(),'Change password')]"));
		waitForElementVisible(driver, itemChangePassword);
		clickToElement(driver, itemChangePassword);
	}

	public void clickRegisterItem() {
		itemRegister = driver.findElement(By.xpath("//span[contains(text(),'Register')]"));
		waitForElementVisible(driver, itemRegister);
		clickToElement(driver, itemRegister);
	}

	public void clickBookTicketItem() {
		itemBookTicket = driver.findElement(By.xpath("//span[contains(text(),'Book ticket')]"));
		waitForElementVisible(driver, itemBookTicket);
		clickToElement(driver, itemBookTicket);
	}

	public void clickContactItem() {
		itemContact = driver.findElement(By.xpath("//span[contains(text(),'Contact')]"));
		waitForElementVisible(driver, itemContact);
		clickToElement(driver, itemContact);

	}

	public void clickMyTicketItem() {
		itemMyTicket = driver.findElement(By.xpath("//span[contains(text(),'My ticket')]"));
		waitForElementVisible(driver, itemMyTicket);
		clickToElement(driver, itemMyTicket);

	}

	public Boolean checkLogoutItemExist() {
		List<WebElement> logoutitem = driver.findElements(By.xpath("//span[contains(text(),'Log out')]"));
		if (logoutitem.size() != 0) {
			return true;
		} else
			return false;
	}
}
