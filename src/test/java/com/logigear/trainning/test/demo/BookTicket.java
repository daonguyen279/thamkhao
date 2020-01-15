package com.logigear.trainning.test.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.trainning.common.Constant;
import com.logigear.trainning.page.BasePage;
import com.logigear.trainning.page.BookTicketPage;
import com.logigear.trainning.page.LoginPage;
import com.logigear.trainning.page.ParentPage;

public class BookTicket extends BasePage {
	public LoginPage loginpage;
	public ParentPage parentpage;
	public BookTicketPage bookticketpage;

	@Test(priority = 0)
	public void TC_001_Redirected_To_Book_Ticket_Page() {
		parentpage = new ParentPage(driver);
		parentpage.clickBookTicketItem();
		loginpage = new LoginPage(driver);
		loginpage.inputToUsernameTextbox(Constant.USERNAME);
		loginpage.scrollToLogin();
		loginpage.inputToPasswordTextbox(Constant.PASSWORD);
		loginpage.scrollToLogin();
		loginpage.clickLoginButton();

		// check point
		bookticketpage = new BookTicketPage(driver);
		Assert.assertEquals(bookticketpage.getTextFromBookticketMsg(), Constant.BOOKTICKET_MSG);
	}

	@Test(priority = 1)
	public void TC_002_Book_Many_Tickets_Successful() {
		parentpage = new ParentPage(driver);
		parentpage.clickBookTicketItem();
		loginpage = new LoginPage(driver);
		loginpage.inputToUsernameTextbox(Constant.USERNAME);
		loginpage.scrollToLogin();
		loginpage.inputToPasswordTextbox(Constant.PASSWORD);
		loginpage.scrollToLogin();
		loginpage.clickLoginButton();
		bookticketpage = new BookTicketPage(driver);
		bookticketpage.scrollToBook();
		bookticketpage.selectDepartmentDate(bookticketpage.getDepartmentDay());
		bookticketpage.selectDepartmentFrom(Constant.DEPARTMENT_FROM);
		bookticketpage.selectArriveAt(Constant.ARRIVE_AT);
		bookticketpage.selectSeatType(Constant.SEAT_TYPE);
		bookticketpage.selectAmount(Constant.TICKET_AMOUNT);
		bookticketpage.clickBookButton();

		Assert.assertEquals(bookticketpage.getTextFromBookticketMsg(), Constant.BOOKTICKET_SUCCESSFULLY_MSG);
		Assert.assertEquals(bookticketpage.getTextFromDepartmentFrom(), Constant.DEPARTMENT_FROM);
		Assert.assertEquals(bookticketpage.getTextFromArriveAt(), Constant.ARRIVE_AT);
		Assert.assertEquals(bookticketpage.getTextFromDepartmentDay(), bookticketpage.getDepartmentDay());
		Assert.assertEquals(bookticketpage.getTextFromAmount(), Constant.TICKET_AMOUNT);
		Assert.assertEquals(bookticketpage.getTextFromSeatType(), Constant.SEAT_TYPE);
	}
	@Test(priority = 1)
	public void TC_003_Cancel_Tiket_Successfully(){
		parentpage = new ParentPage(driver);
		parentpage.clickBookTicketItem();
		loginpage = new LoginPage(driver);
		loginpage.inputToUsernameTextbox(Constant.USERNAME);
		loginpage.scrollToLogin();
		loginpage.inputToPasswordTextbox(Constant.PASSWORD);
		loginpage.scrollToLogin();
		loginpage.clickLoginButton();
		bookticketpage = new BookTicketPage(driver);
		bookticketpage.scrollToBook();
		bookticketpage.selectDepartmentDate(bookticketpage.getDepartmentDay());
		bookticketpage.selectDepartmentFrom(Constant.DEPARTMENT_FROM);
		bookticketpage.selectArriveAt(Constant.ARRIVE_AT);
		bookticketpage.selectSeatType(Constant.SEAT_TYPE);
		bookticketpage.selectAmount(Constant.TICKET_AMOUNT);
		bookticketpage.clickBookButton();
		parentpage.clickMyTicketItem();
		bookticketpage.scrollToCancel();
		bookticketpage.clickCancelTicket();
		driver.switchTo().alert().accept();
		
		Assert.assertNotEquals(bookticketpage.getTextFromBookticketMsg(), Constant.BOOKTICKET_SUCCESSFULLY_MSG);
		Assert.assertNotEquals(bookticketpage.getTextFromDepartmentFrom(), Constant.DEPARTMENT_FROM);
		Assert.assertNotEquals(bookticketpage.getTextFromArriveAt(), Constant.ARRIVE_AT);
		Assert.assertNotEquals(bookticketpage.getTextFromDepartmentDay(), bookticketpage.getDepartmentDay());
		Assert.assertNotEquals(bookticketpage.getTextFromAmount(), Constant.TICKET_AMOUNT);
		Assert.assertNotEquals(bookticketpage.getTextFromSeatType(), Constant.SEAT_TYPE);
	}
	
	
}
