package com.ecommerce.testng.AmazonTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgAnnotation {
	
	@Test
	public void test1() {
		System.out.println("test1 executed!!!!");
	}
	
	@Test
	public void test2() {
		System.out.println("Test 2 executed!!!");
	}
	
	@BeforeTest
	public void setup() {
		System.out.println("Before test!!!");
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("After Test !!!");
	}
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Before method!!!!");
	}
	
	@AfterMethod
	public void teardown() {
		System.out.println("After method!!!");
	}
}
