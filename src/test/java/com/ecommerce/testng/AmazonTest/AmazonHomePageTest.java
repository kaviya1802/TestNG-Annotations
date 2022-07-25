package com.ecommerce.testng.AmazonTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class AmazonHomePageTest {
	
	WebDriver driver;
	final String siteUrl = "https://www.amazon.in/";
	final String driverPath = "C:\\Users\\Selvaprakash\\eclipse-workspace\\AmazonTest\\Driver\\chromedriver.exe";
	
  @BeforeTest
  public void setupDriver() {
	  //Set selenium properties
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  
	  //Instantiating driver
	  driver = new ChromeDriver();
	  driver.get(siteUrl);
	 
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

  @Test
  public void amazonHomePageTitle() {
	  String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	  String actual = driver.getTitle();
	  assertEquals(expected, actual);
  }
  
  @Test
  public void verifyAmazonUrl() {
	  String actualUrl = driver.getCurrentUrl();
	  assertEquals(siteUrl, actualUrl);
  }
  
  
  
}
