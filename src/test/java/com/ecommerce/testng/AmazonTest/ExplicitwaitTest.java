package com.ecommerce.testng.AmazonTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class ExplicitwaitTest {

	  WebDriver driver; 
	  WebDriverWait wait;
		final String siteUrl = "https://www.amazon.in/";
		final String driverPath = "C:\\Users\\Selvaprakash\\eclipse-workspace\\AmazonTest\\Driver\\chromedriver.exe";
		
	@BeforeMethod
	public void setupDriver() {
		  //Set selenium properties
		  System.setProperty("webdriver.chrome.driver", driverPath);
		  
		  //Instantiating driver
		  driver = new ChromeDriver();
		  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  driver.get(siteUrl);
		 
	}

	@AfterMethod
	public void afterTest() {
		  driver.close();
	}
	
	@Test
	public void mobileLinkTest() {
		WebElement mobileLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-xshop\"]/a[2]")));
		mobileLink.click();
		String expected = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}
	

}
