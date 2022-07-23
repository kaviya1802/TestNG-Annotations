package com.ecommerce.testng.external.elements;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class radioCheck {
	
	  WebDriver driver;
	  String siteUrl = "file:///C:/Users/Selvaprakash/eclipse-workspace/AmazonTest/static/radio-check.html";
	  String driverPath = "C:\\Users\\Selvaprakash\\eclipse-workspace\\AmazonTest\\Driver\\chromedriver.exe";
	  
  @BeforeMethod
  public void setupDriver() {
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  driver = new ChromeDriver();
	  driver.get(siteUrl);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }
  
  @Test
  public void radioButtonExistTest() {
	  
	  WebElement radio1 = driver.findElement(By.id("male"));
	  assertEquals(true, radio1.isEnabled());
	  assertEquals(true, radio1.isDisplayed());
	  assertEquals(false, radio1.isSelected());
  }
  
  @Test
  public void radioButtonClickTest() {
	  WebElement radio = driver.findElement(By.id("male"));
	  radio.click();
	  assertEquals(true, radio.isSelected());
  }
  
  @Test
  public void radioButtonFemaleClickTest() {
	  WebElement radio = driver.findElement(By.id("female"));
	  radio.click();
	  assertEquals(true, radio.isSelected());
  }
  
  @Test
  public void checkBoxTest() {
	  WebElement check1 = driver.findElement(By.id("vehicle1"));
	  assertEquals(true, check1.isDisplayed());
	  assertEquals(true, check1.isEnabled());
	  assertEquals(false, check1.isSelected());
	  }
  
  @Test
  public void defaultcheckBoxTest() {
	  WebElement check1 = driver.findElement(By.id("vehicle2"));
	  assertEquals(true, check1.isDisplayed());
	  assertEquals(true, check1.isEnabled());
	  assertEquals(true, check1.isSelected());
	  }
  
  @Test
  public void verifySelection() {
	  driver.findElement(By.id("vehicle1")).click();
	  driver.findElement(By.id("vehicle2")).click();
	  driver.findElement(By.id("vehicle3")).click();
  }
  
  @Test
  
  public void testSelect() {
	  WebElement select = driver.findElement(By.id("vehicle"));
	  Select vehicle = new Select(select);
	  vehicle.selectByVisibleText("Bike");
	  WebElement selectedElm = vehicle.getFirstSelectedOption();
	  assertEquals("Bike", selectedElm.getText());
  }
}
