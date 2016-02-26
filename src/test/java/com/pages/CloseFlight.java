package com.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.commons.common;
import com.commons.utilities;

public class CloseFlight extends utilities {
	
	public static String CloseFlight_link_xpath=".//*[@id='menustrip']/li[6]/a/span/span";
	public static String CloseFlight_Sector_Continue_btn_xpath=".//*[@id='myWizard']/div/div[1]/button";
	public static String Completed_ChkBx_firstxpath=".//*[@id='DuesCollectibles']/tbody/tr";
	public static String Completed_ChkBx_secondxpath="/td[6]/input";
	public static String DuesAndCollectibleTrans_xpath=".//*[@id='DuesCollectibles']/tbody";
	public static String DuesAndCollectibleTrans_Count_xpath=".//*[@id='DuesCollectibles']/tbody/tr";
	public static String DuesAndCollectible_Continue_btn_xpath=".//*[@id='myWizard']/div/div[1]/button";
	public static String Close_Barset_popup_Header_xpath = ".//*[@id='Body']/div[3]/div/div/div[1]/h4/h3";
	public static String Close_Barset_popup_Message_xpath =".//*[@id='Body']/div[3]/div/div/div[2]/div";
	//public static String Close_Barset_popup_Yes_button_xpath="html/body/div[3]/div/div/div[3]/button[1]";
	public static String Close_Barset_popup_Yes_button_xpath="//button[@data-bb-handler='success']";
	//public static String Close_Barset_popup_No_button_xpath="html/body/div[3]/div/div/div[3]/body/button[2]";
	public static String Close_Barset_popup_No_button_xpath="//button[@data-bb-handler='danger']";
	public static String Close_Barset_popup_BarsetNum_xpath="html/body/div[2]/div/div/div[2]/div/strong";
	public static String Sync_Devices_btn=".//*[@id='btnSyncDevices']";
	public static String Cancel_btn_xpath="//button[@data-bind='click: cancel, disable: synchronizing']";
	public static String Continue_btn="//button[@data-bind='click: nextStep, visible: syncProgress() === 100']";
	public static String DuesandCollectiblestab=".//*[@id='myWizard']/div[1]/ul/li[text()='Dues & Collectibles']";
	public static String CloseFlight_popup_ok_btn="html/body/div[2]/div/div/div[2]/button[2]";
	public static String SalesAndOrders_link="//a[@href='sales.html']";
	public static String DuesandCollectibles_tab="//a[@href='#tabChangeAndRentalsDueCarts']";
	public static String DuesandCollectibles_Continue_btn="//button[@data-bind='click: nextStep, visible: duesCollectiblesArray().length === 0']";
	public static String CloseShop_Cancel_Popup_Yes_btn="//button[@data-bb-handler='success']";
	public static String CloseShop_Cancel_Popup_No_btn="//button[@data-bb-handler='danger']";
	public static String CloseShop_popup_xpath="html/body/div[2]/div";
	
	public static void switchControlToLatestWindow(WebDriver driver) {
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	
	 }
	 
	 public static void Close_Flight(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath(CloseFlight_link_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS); 
		 try{   
			   driver.switchTo().alert().dismiss();  
			  }catch(Exception e){ 
			   System.out.println("unexpected alert not present");   
			  }
	 }
	 
	 public static String Close_Shop_DuesAndCollectiblesTrans(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
		   String DuesAndCollectiblesTrans=driver.findElement(By.xpath(DuesAndCollectibleTrans_xpath)).getText();
		   System.out.println(DuesAndCollectiblesTrans);
		return DuesAndCollectiblesTrans;
		   
	   }
	 
	 public static void Complete_DuesAndCollectibles1(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 
		 WebElement tab=driver.findElement(By.xpath("html/body/div/div/div[1]/ul/li[1]"));
		 String text = tab.getText();
		 System.out.println(text);
		 if(text.equalsIgnoreCase("1Dues & Collectibles")){
			 int Trans = driver.findElements(By.xpath(DuesAndCollectibleTrans_Count_xpath)).size();
			 System.out.println(Trans);
			 if(Trans > 1){
			 for(int i=1;i<=Trans;i++){
				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
				 driver.findElement(By.xpath(Completed_ChkBx_firstxpath+"["+i+"]"+Completed_ChkBx_secondxpath)).click();
				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
				CloseFlight.Continue(driver);
			 }
	    }else if(driver.findElements(By.xpath(DuesAndCollectibleTrans_Count_xpath)).size()==1){
	    	 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
			 driver.findElement(By.xpath(Completed_ChkBx_firstxpath+Completed_ChkBx_secondxpath)).click();
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			 CloseFlight.Continue(driver);
	      }
		 }else{
			 System.out.println("No dues");
		 }
      } 
	 
	 public static void Complete_DuesAndCollectibles(WebDriver driver){
		
		 driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS); 
		 if(driver.findElements(By.xpath(DuesandCollectiblestab)).size()!=0){
		 int Trans = driver.findElements(By.xpath(DuesAndCollectibleTrans_Count_xpath)).size();
		 if(Trans > 1){
		 for(int i=1;i<=Trans;i++){
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
			 driver.findElement(By.xpath(Completed_ChkBx_firstxpath+"["+i+"]"+Completed_ChkBx_secondxpath)).click();
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			 CloseFlight.DuesAndCollectibles_Continue(driver);
		 }
		 }else if(Trans == 1){
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
			 driver.findElement(By.xpath(Completed_ChkBx_firstxpath+Completed_ChkBx_secondxpath)).click();
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			 CloseFlight.DuesAndCollectibles_Continue(driver);
		 }else{
			System.out.println("No dues");
		 }
		 }
	 }
	 public static void DuesAndCollectibles_Continue(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		 JavascriptExecutor js= (JavascriptExecutor) driver;
		 js.executeScript("return document.readyState").equals("complete");
		  js.executeScript("arguments[0].click();", driver.findElement(By.xpath(DuesandCollectibles_Continue_btn)));
		  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
	 }
	 public static void Verify_CloseBarset_popup(WebDriver driver) throws IOException{
		 switchControlToLatestWindow(driver);
		 String Header =  driver.findElement(By.xpath(Close_Barset_popup_Header_xpath)).getText();
		 String Message =  driver.findElement(By.xpath(Close_Barset_popup_Header_xpath)).getText();
		 WebElement Yes_btn=driver.findElement(By.xpath(Close_Barset_popup_Header_xpath));
		 WebElement No_btn=driver.findElement(By.xpath(Close_Barset_popup_Header_xpath));
		 if(Header.equalsIgnoreCase("Close Barset")){
			 System.out.println("HeaderMatched");
			 if(Message.contains(("Is this the last sector for barset"+getValue("BarsetNum")))){
				 System.out.println("Message is as expected");
				 if(Yes_btn.isDisplayed()){
					 System.out.println("Yes button is displayed");
					 if(No_btn.isDisplayed()){
						 System.out.println("No button is displayed");
						 }else{
							 Assert.fail("No button not displayed");
						 }
					 }else{
						 Assert.fail("Yes button not displayed");
					 }
				 }else{
					 Assert.fail("Message displayed is not correcte");
				 }
			 }else{
				 Assert.fail("Header did not match");
			 }
		 }
	
	 public static void Accept_CloseShop_Cancel_popup(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
    	 driver.findElement(By.xpath(Cancel_btn_xpath)).click();
    	 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
    	 switchControlToLatestWindow(driver);
    	 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
    	 driver.findElement(By.xpath(CloseShop_Cancel_Popup_Yes_btn)).click();
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		 
	 }
     public static void CloseBarset_popup_No(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
    	 switchControlToLatestWindow(driver);
    	 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
    	 driver.findElement(By.xpath(Close_Barset_popup_No_button_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		 
	 }
     
     public static void Accept_CloseBarset_popup(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
    	 switchControlToLatestWindow(driver);
    	 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
    	 driver.findElement(By.xpath(Close_Barset_popup_Yes_button_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		 
	 }
     public static void DoNot_CloseBarset(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
    	 switchControlToLatestWindow(driver);
    	 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
    	 driver.findElement(By.xpath(Close_Barset_popup_No_button_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS); 
	 }
     public static void Cancel_CloseBarset_popup(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
    	 switchControlToLatestWindow(driver);
    	 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
    	 driver.findElement(By.xpath(Close_Barset_popup_No_button_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
	 }
     
     public static int CloseFlight_BarsetNum(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
    	// switchControlToLatestWindow(driver); 
    	 common.Wait_Until_ElementVisible(driver, CloseShop_popup_xpath);
    	 String Num= driver.findElement(By.xpath(Close_Barset_popup_BarsetNum_xpath)).getText();
    	 int BarsetNum = Integer.parseInt(Num);
    	System.out.println(BarsetNum);
    	 return BarsetNum;
     }
	
	 
	 public static void Cross_Device_Sync(WebDriver driver){
		 JavascriptExecutor js1= (JavascriptExecutor) driver;
		    js1.executeScript("return document.readyState").equals("complete");
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
		 driver.findElement(By.xpath(Sync_Devices_btn)).click();
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
	 }
	 public static void Continue(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		 JavascriptExecutor js= (JavascriptExecutor) driver;
		 js.executeScript("return document.readyState").equals("complete");
		  js.executeScript("arguments[0].click();", driver.findElement(By.xpath(Continue_btn)));
		  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
	 }
	 
	 public static void CloseShop_Device_Sync(WebDriver driver){
		 JavascriptExecutor js1= (JavascriptExecutor) driver;
		//    js1.executeScript("return document.readyState").equals("complete");
		 driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS); 
		 if(driver.findElement(By.xpath(Sync_Devices_btn)).isDisplayed()){
			 CloseFlight.Cross_Device_Sync(driver);
		 CloseFlight.Continue(driver);
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		 }else if(driver.findElement(By.xpath(Sync_Devices_btn)).getAttribute("style").contentEquals("display: none;")){
			 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
			 CloseFlight.Continue(driver); 
			 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		 }
			
		
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
	 }
	public static void Accept_CloseFlight_popup(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		 JavascriptExecutor js= (JavascriptExecutor) driver;
		 js.executeScript("return document.readyState").equals("complete");
		  js.executeScript("arguments[0].click();", driver.findElement(By.xpath(CloseFlight_popup_ok_btn)));
		  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
	}
}
