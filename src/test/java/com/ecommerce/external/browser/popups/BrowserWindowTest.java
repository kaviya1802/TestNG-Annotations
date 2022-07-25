package com.ecommerce.external.browser.popups;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BrowserWindowTest {
	
	WebDriver driver;
	String siteUrl = "https://www.amazon.in/";
	String driverPath = "C:\\Users\\Selvaprakash\\eclipse-workspace\\AmazonTest\\Driver\\chromedriver.exe";

  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  
	  driver = new ChromeDriver();
	  driver.get(siteUrl);
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }
  
  @Test
  public void verifyLocationAmazonTest() throws InterruptedException {
	  
	  driver.findElement(By.cssSelector("#glow-ingress-line2")).click();
	  Thread.sleep(2000);
	  String mainwindow = driver.getWindowHandle();
	  
	  //get all new windows
	  
	  Set<String> windows = driver.getWindowHandles();
	  Iterator<String> itr = windows.iterator();
	  
	  while(itr.hasNext()) {
		  String childWindow = itr.next();
			  Thread.sleep(5000 );
//			  driver.switchTo().window(childWindow);
			  driver.findElement(By.cssSelector("#GLUXZipUpdateInput")).sendKeys("560036");
//			  Thread.sleep(5000 );
			  driver.findElement(By.cssSelector("#GLUXZipUpdate > span > input")).click(); 
	  }
	  driver.switchTo().window(mainwindow);
	  
  }

}
