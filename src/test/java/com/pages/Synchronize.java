package com.pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.commons.common;

public class Synchronize {
	
	 public static String Synchonize_btn_xpath = ".//*[@id='Main']/form/div/div/div[3]/button";
	 public static String Synchonize_link_xpath = "//i[@class='glyphicons transfer fa-2x']";
	 public static String OpenFlight_btn_xpath=".//*[@id='Main']/form/div/div/div[4]/button";
	 
	 public static void Sync(WebDriver driver){
		 common.Wait_Until_ElementVisible(driver, Synchonize_link_xpath);
	    	common.Wait_Until_ElementClickable(driver, Synchonize_link_xpath);
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath(Synchonize_link_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Synchonize_btn_xpath)).click();
		String elementxpath = ".//*[@id='Main']/form/div/div/span[@style='color: rgb(65, 150, 65);']";
		 common.Wait_Until_ElementVisible(driver, elementxpath);
		 
	 }
	 
	 public static void Verify_Sync_Process(WebDriver driver) throws InterruptedException{
	Thread.sleep(500);
		 String colour= driver.findElement(By.xpath(".//*[@id='Main']/form/div/div/span")).getAttribute("style");
		 if(colour.equals("color: black;")){
			 System.out.println("Not yet synched");
		 }else if(colour.equals("color: rgb(65, 150, 65);")){
			 System.out.println("Sync was successful");
		 }else{
				Assert.fail("sync failed");
			 }
	 }
	 
	 public static void OpenFlight(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath(OpenFlight_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	 }

}
