package com.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commons.common;
import com.commons.utilities;

public class StoreNumber extends utilities{
   WebDriver driver = null;
	public static String StoreNum_fld_xpath="//input[@name='storeNumber']";
	public static String EffectiveFrom_fld_xpath="//input[@name='startDate']";
	public static String EffectiveTo_fld_xpath="//input[@name='endDate']";
	public static String Create_btn_xpath="//button[@type='submit']";
	public static String SavedStores_Count_xpath="/html/body/div[2]/div/table/tbody/tr";
	public static String SavedStoreNumber_firstxpath="/html/body/div[2]/div/table/tbody/tr";
	public static String SavedStoreNumber_secondxpath="/td[1]";
	public static String StoreEffectiveFrom_firstxpath="/html/body/div[2]/div/table/tbody/tr";
	public static String StoreEffectiveFrom_secondxpath="/td[2]";
	public static String StoreEffectiveTo_firstxpath="/html/body/div[2]/div/table/tbody/tr";
	public static String StoreEffectiveTo_secondxpath="/td[3]";
	public static String StoreSaved_Message_xpath="html/body/div[2]/ul/li/div/span/span";
	public static String Duplicate_StoreNumber_Message1="html/body/div[1]/div/form/error-dialog/div/ul/li/span[2]";
	public static String Duplicate_StoreNumber_Message2="html/body/div[1]/div/form/error-dialog/div/ul/li/span[2]/span";
	public static String Modal_popup="html/body/loading-modal/div/div/div/div/p";
	
	public  String StoreNum(WebDriver driver){
		final java.util.Random generator = new java.util.Random();
		final int MIN = 20;
		final int MAX = 999;
		int randomNumber = generator.nextInt(MAX - MIN) + MIN;
		String Num = randomNumber+"Str";
		
		return Num;
		
	}
	
/*	public static String StoreNum(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String StoreNum=driver.findElement(By.xpath(StoreNum_fld_xpath)).getAttribute("value");
		System.out.println(StoreNum);
		return StoreNum;
	}*/
	
	public static void Create_StoreNumber(WebDriver driver,String StoreNum) throws InterruptedException{
		
		WebDriverWait ww = new WebDriverWait(driver,70);
		ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(StoreNum_fld_xpath)));
		String DATE_FORMAT = "MM/dd/yyyy";
	    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
	    long base=System.currentTimeMillis(); 
	     int N=20; 
	     int M=1;
	    Date sdate=new Date(base+M*24*60*60*1000);  
        String EffectFrom = sdf.format(sdate);
      // System.out.println(EffectFrom);
        Date date = new Date(base+N*24*60*60*1000);
	 	 String EffectTo = sdf.format(date);
	 	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(StoreNum_fld_xpath)).sendKeys(StoreNum);
		driver.findElement(By.xpath(EffectiveFrom_fld_xpath)).clear();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(EffectiveFrom_fld_xpath)).sendKeys(EffectFrom);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(EffectiveTo_fld_xpath)).clear();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(EffectiveTo_fld_xpath)).sendKeys(EffectTo);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Create_btn_xpath)).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		common.Wait_Until_ElementInVisible(driver, Modal_popup);
	}
	
	public static void ReCreate_StoreNum(WebDriver driver,String StoreNum) throws InterruptedException, FileNotFoundException, IOException{
		String Exmessage1="Bad Request - Please update and try again.";
		String Acmessage= StoreNumber.Duplicate_StoreNum_Message(driver);
		if(Acmessage.equalsIgnoreCase(Exmessage1)){
			common.Navigate_To_URL(driver, getValue("DashBoard"));
			Dashboard.Navigating_to_Menu(driver,"Manage Store Number", "Store Number Create");
			StoreNumber.Create_StoreNumber(driver, StoreNum);
		}
	}
	
	public static int Saved_Stores_Count(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int Stores=driver.findElements(By.xpath(SavedStores_Count_xpath)).size();
		return Stores;
	}
	
	public static String Store_Number(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int rows = StoreNumber.Saved_Stores_Count(driver);
		String Store_Number=null;
		if(rows > 1){
			for(int i=1;i<=rows;i++){
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Store_Number=driver.findElement(By.xpath(SavedStoreNumber_firstxpath+"["+i+"]"+SavedStoreNumber_secondxpath)).getText();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				System.out.println(Store_Number);
			}
		}else{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Store_Number=driver.findElement(By.xpath(SavedStoreNumber_firstxpath+SavedStoreNumber_secondxpath)).getText();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println(Store_Number);
		}
		
		return Store_Number;
		
	}
	
	
	public static String Duplicate_StoreNum_Message(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String Message=driver.findElement(By.xpath(Duplicate_StoreNumber_Message1)).getText();
		System.out.println(Message);
		return Message;
	}
	
	public static void Verify_DuplicateStoreNumberMessage(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String Actual_Message = "The companyId-storeNumber Duplicate values are not allowed.";
		String Expected_Message=StoreNumber.Duplicate_StoreNum_Message(driver);
		if(Expected_Message.equalsIgnoreCase(Actual_Message)){
			System.out.println("Message displayed as expected");
		}else{
			Assert.fail("Incorrect Message displayed Or Message not displayed");
		}
		
	}
	
	public static void Verify_SavedStoreNumber(WebDriver driver) throws IOException, InterruptedException{
		WebDriverWait ww = new WebDriverWait(driver,90);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(StoreSaved_Message_xpath)));
		String message=driver.findElement(By.xpath(StoreSaved_Message_xpath)).getText();
		if(message.equalsIgnoreCase("Store Number: saved!")){
			System.out.println("New Store created saved successfully");
		}else{
			Assert.fail("Store not created");
		}
		
	}
	
}
