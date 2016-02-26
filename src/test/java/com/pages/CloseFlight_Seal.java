package com.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.commons.utilities;

public class CloseFlight_Seal  extends utilities{
	public static String CloseFlight_SealEntry_fld_xpath="//input[@data-bind='value: sealId, enable: sealKeyEntry']";
	public static String CloseFlight_HighSecurity_Chkbx_xpath=".//*[@id='sealId_HighSecurity']";
	public static String CloseFlight_Seal_AddBtn_xpath="//button[@data-bind='css: sealId_ButtonCSS, click: sealId_Add, visible: sealKeyEntry']";
	public static String CloseFlight_Seal_Continue_btn_xpath="//button[@data-bind='visible: sealId_IsValid, click: nextStep']";
	public static String Seal_count_xpath=".//*[@id='Seals']/li";
	public static String Seal_firstxpath=".//*[@id='Seals']/li[";
	public static String Seal_secondxpath="]/h4";
	public static String CloseFlight_Seal_Delete_btn_xpath="//button[@data-bind='click: pageCloseShop.seal_Remove']";
	public static String Seal_xpath=".//*[@id='Seals']/li/h4";
	
	public static String ExpectedOutboundSeal(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 int Sealcount = driver.findElements(By.xpath(Seal_count_xpath)).size();
    	 String Seal=null;
    	 if(Sealcount > 1){
    		 for(int j=1;j<=Sealcount;j++){
    			 String	 OutBoundSeal = driver.findElement(By.xpath(Seal_firstxpath+j+Seal_secondxpath)).getText();
    			 String[] String = OutBoundSeal.split("Delete");
    		      	Seal=String[0].trim();
    			// System.out.println(Seal);
    		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	 
    		 }
    	 }else{
    		 String	 OutBoundSeal  =driver.findElement(By.xpath(Seal_xpath)).getText();
    		String[] String = OutBoundSeal.split("Delete");
	      	Seal=String[0].trim();
	      //	System.out.println(Seal);
    		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	 
    		 
    			 }
		return Seal;
    	 
     }
	 public static void CloseShop_SealEntry(WebDriver driver,String Seal) throws IOException{
		 WebDriverWait ww = new WebDriverWait(driver,50);
		 ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CloseFlight_SealEntry_fld_xpath)));
	     driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		//   driver.findElement(By.xpath(CloseFlight_SealEntry_fld_xpath)).click();
		   driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(CloseFlight_SealEntry_fld_xpath)).sendKeys(Seal);
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(CloseFlight_Seal_AddBtn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
 } 
	 
	 public static void Verify_CloseShopSealEntry_Field(){
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  WebElement SealEntry_Fld=driver.findElement(By.xpath(CloseFlight_SealEntry_fld_xpath));
		  if(SealEntry_Fld.isDisplayed()|| SealEntry_Fld.isEnabled()){
			System.out.println("SealEntry_Fld is displayed and enabled");
		  }else{
			  Assert.fail("SealEntry fld is not displyed on the screen");
		  }
	 }
	 
	 public static void Verify_Add_Button(){
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  WebElement Add=driver.findElement(By.xpath(CloseFlight_Seal_AddBtn_xpath));
		  if(Add.isDisplayed()|| Add.isEnabled()){
			System.out.println("Add button is displayed and enabled");
		  }else{
			  Assert.fail("Add button is not displyed on the screen");
		  }
		 
	 }
     public static void Verify_HighSecuritySeal_ChkBx(){
    	 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  WebElement ChkBx=driver.findElement(By.xpath(CloseFlight_HighSecurity_Chkbx_xpath));
		  if(ChkBx.isDisplayed()|| ChkBx.isEnabled()){
			System.out.println("HighSecuritySeal_ChkBx is displayed and enabled");
		  }else{
			  Assert.fail("HighSecuritySeal_ChkBx is not displyed on the screen");
		  }
     }
		 
	  public static void Verify_Delete_btn(){
		  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  WebElement Add=driver.findElement(By.xpath(CloseFlight_Seal_AddBtn_xpath));
		  if(Add.isDisplayed()|| Add.isEnabled()){
			System.out.println("Add button is displayed and enabled");
		  }else{
			  Assert.fail("Add button is not displyed on the screen");
		  } 
	  }
	  
	  public static void Verify_Continue_btn(){
		  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  WebElement Continue=driver.findElement(By.xpath(CloseFlight_Seal_Continue_btn_xpath));
		  if(Continue.isDisplayed()|| Continue.isEnabled()){
			System.out.println("Continue button is displayed and enabled");
		  }else{
			  Assert.fail("Continue button is not displyed on the screen");
		  }
	  }
	  
	  public static void Verify_OutBound_Seal_Added(WebDriver driver) throws IOException{ 
		  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	      driver.findElement(By.xpath(CloseFlight_SealEntry_fld_xpath)).click();
	      driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	      driver.findElement(By.xpath(CloseFlight_SealEntry_fld_xpath)).sendKeys(getValue("CloseShop_Seal"));
	      driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	       driver.findElement(By.xpath(CloseFlight_Seal_AddBtn_xpath)).click();
	        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			 List<WebElement> seals = driver.findElements(By.xpath(Seal_count_xpath)); 
			 int listsize= seals.size();
			 if(listsize > 0){
				 System.out.println("able to add OutBoundSeal successfully and seal is saved");
			 }else{
				 Assert.fail("Unable to add OutBoundSeal");
			 }
		  
	  }
	  
    public static void Verify_OutBound_Seal_Deleted(){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(CloseFlight_Seal_Delete_btn_xpath)).click();
		 List<WebElement> seals = driver.findElements(By.xpath(Seal_count_xpath)); 
		 int listsize = seals.size();
		 if(listsize == 0){
			 System.out.println("able to delete Seal successfully");
		   }else{
			   Assert.fail("Unable to delete Seal");
		   }
		 }
		  
	public static void CloseShop_Seal_Continue(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 WebElement continuebutton= driver.findElement(By.xpath(CloseFlight_Seal_Continue_btn_xpath));
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 js.executeScript("arguments[0].click();", continuebutton);
		  //driver.findElement(By.xpath(CashBag_Continue_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}

}
