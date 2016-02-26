package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	WebDriver driver=null;
	 public static String username_fld_xpath = "//input[@name='username']";
	 public static String password_fld_xpath = "//input[@name='password']";
	 public static String  login_btn_xpath = "//button[@type='submit']";
	 
	 public static void Portal_login(WebDriver driver,String username,String password){
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript(String.format("window.localStorage.clear();"));
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 driver.manage().deleteAllCookies();
			 Actions act = new Actions(driver);
			  act.sendKeys(Keys.CONTROL.F5).perform();
			  WebDriverWait ww = new WebDriverWait(driver,30);
				ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(username_fld_xpath)));
			driver.findElement(By.xpath(username_fld_xpath)).sendKeys(username);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath(password_fld_xpath)).sendKeys(password);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath(login_btn_xpath)).click();
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS); 
		/*	 Actions act = new Actions(driver);
			  act.sendKeys(Keys.F5).perform();*/
			
	 }
}
