package com.logigear.trainning.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.logigear.trainning.common.Constant;

public class BasePage {
	public WebDriver driver;

	@BeforeClass
	public void Pre_Condition() {
		System.setProperty("webdriver.chrome.driver", Constant.DRIVERLOCATION);
		driver = new ChromeDriver();
		driver.get(Constant.LINK);
		driver.manage().timeouts().implicitlyWait(Constant.SHORTTIME, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void clear_environment() {
		driver.quit();
	}
}
