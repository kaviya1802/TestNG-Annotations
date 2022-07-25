package com.ecommerce.external.browser.screenshot;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BrowserScreenshotTest {
	
	WebDriver driver;
	String sitrUrl = "https://www.amazon.in/";
	String driverPath = "C:\\Users\\Selvaprakash\\eclipse-workspace\\AmazonTest\\Driver\\chromedriver.exe";

  @BeforeMethod
  public void setupDriver() {
	  
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  driver = new ChromeDriver();
	  driver.get(sitrUrl);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void closeDriver() {
	  driver.close();
  }

  @Test
  public void screenShotTest() throws URISyntaxException, IOException {
	  TakesScreenshot ts = (TakesScreenshot) driver;
	  File src = ts.getScreenshotAs(OutputType.FILE);
	  URI uri = new URI(sitrUrl);
	  org.openqa.selenium.io.FileHandler.copy(src, new File("C:\\Users\\Selvaprakash\\eclipse-workspace\\AmazonTest\\screenshot"+uri.getHost()+".png"));
  }
}
