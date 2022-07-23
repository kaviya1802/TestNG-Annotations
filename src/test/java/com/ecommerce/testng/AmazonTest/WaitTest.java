package com.ecommerce.testng.AmazonTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

//Implicit wait test

public class WaitTest {

  WebDriver driver;
	final String siteUrl = "https://www.amazon.in/";
	final String driverPath = "C:\\Users\\Selvaprakash\\eclipse-workspace\\AmazonTest\\Driver\\chromedriver.exe";
	
@BeforeMethod
public void setupDriver() {
	  //Set selenium properties
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  
	  //Instantiating driver
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get(siteUrl);
	 
}

@AfterMethod
public void afterTest() {
	  driver.close();
}

@Test
public void  testTitle() {
	String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	String actual = driver.getTitle();
	assertEquals(expected, actual);
}

@Test
public void testMobilelink() {
	WebElement mobileLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)"));
	mobileLink.click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	String expected = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
	String actual = driver.getTitle();
	assertEquals(expected, actual);
}
}
