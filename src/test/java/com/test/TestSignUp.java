package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestSignUp {
	
	WebDriver driver;
	
  @BeforeClass
  public void setUp() {
	  
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://justbooks.in/signup"); 

  }
  
  @Test
  public void testAll() throws InterruptedException {
	  
//	  By locator = By.xpath("//form[@siq_id='autopick_586']/div/input");
	  By locator = By.cssSelector("form > div > input");
	  
	  List<WebElement> inputs = driver.findElements(locator);
	  System.out.println(inputs.size());
	  
	  By locator2 = By.xpath("//div[.='Next']");
	  
	  WebElement next = driver.findElement(locator2);
	  
	  
	  // inputs 0 -> for first name
	  inputs.get(0).sendKeys("Manish");
	  
	  // inputs 1 -> sirname
	  inputs.get(1).sendKeys("Dada Ahir");
	  
	  // inputs 2 -> email
	  inputs.get(2).sendKeys("manishahir4520@gmail.com");
	  
	  // inputs 3 -> mobile no
	  inputs.get(3).sendKeys("8766488785");
	  
	  // inputs 4 -> pincode
	  inputs.get(4).sendKeys("400001");
	  
	  next.click();
	  
	  Thread.sleep(3000);
	  WebElement headerElement = driver.findElement(By.xpath("//input[@name='q']"));
		/*
		 * if (headerElement.isDisplayed()==true)
		 * System.out.println("Sign-up Successful");
		 * 
		 * else System.out.println("Sign-up Failed");
		 * 
		 * driver.close();
		 */
	 Assert.assertTrue(headerElement.isDisplayed()==true, "signup success");
	 
	 driver.close();
//	  assertEquals("Customise Your Plan", )
	  
	  
  }
  
//  @AfterClass
//  public void close() {
//	  try {
//		  Thread.sleep(10000);
//		  driver.close();  
//	  }catch(Exception e) {
//		  e.printStackTrace();
//	  }
//	  
//  }
}
