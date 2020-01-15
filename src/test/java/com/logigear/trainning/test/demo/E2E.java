package com.logigear.trainning.test.demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class E2E {
	
	@Test
	  public void TC_001_Register_User() {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\my.le\\Desktop\\New folder\\sele1\\src\\test\\java\\resource\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.navigate().to("http://192.168.188.143/");		
			driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("myle8174@gmail.com");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("pakane1234");
			driver.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("pakane1234");
			driver.findElement(By.xpath("//input[@id='pid']")).sendKeys("pakane1234");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Thank you for registering your account')]")).getText(), "Thank you for registering your account");
			
	  }
	

}
