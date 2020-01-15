package com.logigear.trainning.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.logigear.trainning.common.Common;
import com.logigear.trainning.common.Constant;

public class BookTicketPage extends Common {

	public BookTicketPage(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;
	JavascriptExecutor js;
	WebElement txtUsername;
	WebElement cmbDepartmentFrom;
	WebElement cmbDepartmentDate;
	WebElement cmbArriveAt;
	WebElement cmbSeatType;
	WebElement cmbTicketAmount;
	WebElement msgBookTicket;
	WebElement btnBook;
	WebElement btnCancel;
	WebElement departmentFrom;
	WebElement arriveAt;
	WebElement seatType;
	WebElement departmentDay;
	WebElement amount;

	public void scrollToBook() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		btnCancel = this.driver.findElement(By.xpath("//tr[1]//input[@value='Cancel']"));
		js.executeScript("arguments[0].scrollIntoView();", btnCancel);
	}
	public void scrollToCancel() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		btnBook = this.driver.findElement(By.xpath("//input[@type='submit']"));
		js.executeScript("arguments[0].scrollIntoView();", btnBook);
	}

	public String getTextFromBookticketMsg() {
		msgBookTicket = driver.findElement(By.xpath("//div[@id='content']/h1"));
		waitForElementVisible(driver, msgBookTicket);
		return getTextFromElement(driver, msgBookTicket);
	}

	public String getDepartmentDay() {
		return getPlusDay(Constant.PLUSDAY);
	}

	public void selectDepartmentDate(String date) {
		cmbDepartmentDate = driver.findElement(By.xpath("//select[@name='Date']"));
		waitForElementVisible(driver, cmbDepartmentDate);
		selectElement(driver, cmbDepartmentDate, date);
	}

	public void selectDepartmentFrom(String value) {
		cmbDepartmentFrom = driver.findElement(By.xpath("//select[@name='DepartStation']"));
		waitForElementVisible(driver, cmbDepartmentFrom);
		selectElement(driver, cmbDepartmentFrom, value);
	}

	public void selectArriveAt(String value) {
		cmbArriveAt = driver.findElement(By.xpath("//select[@name='ArriveStation']"));
		waitForElementVisible(driver, cmbArriveAt);
		selectElement(driver, cmbArriveAt, value);
	}

	public void selectSeatType(String value) {
		cmbSeatType = driver.findElement(By.xpath("//select[@name='SeatType']"));
		waitForElementVisible(driver, cmbSeatType);
		selectElement(driver, cmbSeatType, value);
	}

	public void selectAmount(String value) {
		cmbTicketAmount = driver.findElement(By.xpath("//select[@name='TicketAmount']"));
		waitForElementVisible(driver, cmbTicketAmount);
		selectElement(driver, cmbTicketAmount, value);
	}

	public void clickBookButton() {
		btnBook = driver.findElement(By.xpath("//input[@type='submit']"));
		waitForElementVisible(driver, btnBook);
		clickToElement(driver, btnBook);
	}

//	public boolean isDepartmentFromValueDisplay(String value) {
//		String departmentFrom = "//tr[@class='OddRow'][1]/td[count(//th[text()='Department Station']/preceding-sibling::th)+1]";
//		waitForElementVisible(driver, departmentFrom, value);
//		return isElementDisplay(driver, departmentFrom, value);
//	}
//	public boolean isArriveAtFromValueDisplay(String value) {
//		String departmentFrom = "//th[contains(text(),'Arrive Station')]/parent::tr/following-sibling::tr/td[text()='%s']";
//		waitForElementVisible(driver, departmentFrom, value);
//		return isElementDisplay(driver, departmentFrom, value);
//	}
	public String getTextFromDepartmentFrom() {
		departmentFrom = driver.findElement(By.xpath(
				"//tr[@class='OddRow'][1]/td[count(//th[text()='Department Station']/preceding-sibling::th)+1]"));
		waitForElementVisible(driver, departmentFrom);
		return getTextFromElement(driver, departmentFrom);
	}

	public String getTextFromArriveAt() {
		arriveAt = driver.findElement(
				By.xpath("//tr[@class='OddRow'][1]/td[count(//th[text()='Arrive Station']/preceding-sibling::th)+1]"));
		waitForElementVisible(driver, arriveAt);
		return getTextFromElement(driver, arriveAt);
	}

	public String getTextFromDepartmentDay() {
		departmentDay = driver.findElement(
				By.xpath("//tr[@class='OddRow'][1]/td[count(//th[text()='Depart Date']/preceding-sibling::th)+1]"));
		waitForElementVisible(driver, departmentDay);
		return getTextFromElement(driver, departmentDay);
	}

	public String getTextFromSeatType() {
		seatType = driver.findElement(
				By.xpath("//tr[@class='OddRow'][1]/td[count(//th[text()='Seat Type']/preceding-sibling::th)+1]"));
		waitForElementVisible(driver, seatType);
		return getTextFromElement(driver, seatType);
	}

	public String getTextFromAmount() {
		amount = driver.findElement(
				By.xpath("//tr[@class='OddRow'][1]/td[count(//th[text()='Amount']/preceding-sibling::th)+1]"));
		waitForElementVisible(driver, amount);
		return getTextFromElement(driver, amount);
	}	
	public void clickCancelTicket() {
		btnCancel = driver.findElement(By.xpath("//tr[1]//input[@value='Cancel']"));
		waitForElementVisible(driver, btnCancel);
		clickToElement(driver, btnCancel);
	}
}

////th[contains(text(),'Depart Station')]/parent::tr/following-sibling::tr/td[text()='%s']
//tr/td[count(//th[text()='Book Date']/preceding-sibling::th)+1]
//tr[@class='OddRow'][1]/td[count(//th[text()='Book Date']/preceding-sibling::th)+1]
