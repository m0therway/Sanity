package com.pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CashCount {
	
	 WebDriver driver=null;
	 public static String Currency_rows_xpath ="/html/body/div[3]/div/div/div[6]/div/div/table/tbody/tr";
	 public static String Currency_name_firstxpath = "/html/body/div[3]/div/div/div[6]/div/div/table/tbody/tr[";
	 public static String Currency_name_secondxpath = "]/td[1]";
	 public static String Currency_input_fld_firstxpath = "/html/body/div[3]/div/div/div[6]/div/div/table/tbody/tr[";
	 public static String Currency_input_fld_secondxpath ="]/td[3]/div/input";
	 public static String CurrencyValue_firstpath ="//div[text()='";
	 public static String CurrencyValue_secondpath ="']";
	 public static String Currency_Set_btn_xpath = "//div[text()='Set']";
	 public static String CashCount_Continue_btn_xpath="//button[@id='btnCashCount']";
	 
	 public static void VerifyCurrency(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
		 WebElement Currency = driver.findElement(By.xpath(Currency_rows_xpath));
		 if(Currency.isDisplayed()){
			 System.out.println("Currency is Displayed");
		 }else{
			 Assert.fail("Currency is not Displayed");
		 }
	
	 }
     public static void VerifyActualCurrencyEntryFld(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
		 WebElement ActualCurrencyEntryFld = driver.findElement(By.xpath(Currency_input_fld_firstxpath+1+Currency_input_fld_secondxpath));
		 if(ActualCurrencyEntryFld.isDisplayed()||ActualCurrencyEntryFld.isEnabled()){
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	
			 driver.findElement(By.xpath(Currency_input_fld_firstxpath+1+Currency_input_fld_secondxpath)).click();
			 System.out.println("ActualCurrencyEntryFld is Displayed and Enabled");
		 }else{
			 Assert.fail("ActualCurrencyEntryFld is not Displayed");
		 }
	 }
     public static void VerifyContinueBtn(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
		 WebElement ContinueBtn = driver.findElement(By.xpath(CashCount_Continue_btn_xpath));
		 if(ContinueBtn.isDisplayed()||ContinueBtn.isEnabled()){
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	
			 driver.findElement(By.xpath(CashCount_Continue_btn_xpath)).click();
			 System.out.println("ContinueBtn is Displayed and Enabled");
		 }else{
			 Assert.fail("ContinueBtn is not Displayed");
		 }
	 }
	 public static void switchControlToLatestWindow(WebDriver driver) {
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	
	 }
	
	 public static void EnterCurrencyValue(WebDriver driver,String currency,int i,int j,int k){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 int rowcount = driver.findElements(By.xpath(Currency_rows_xpath)).size();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 for(int row=1;row<=rowcount;row++){
			 String Currencyname = driver.findElement(By.xpath(Currency_name_firstxpath+row+Currency_name_secondxpath)).getText();
		    if(Currencyname.equalsIgnoreCase(currency)){
		 driver.findElement(By.xpath(Currency_input_fld_firstxpath+row+Currency_input_fld_secondxpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 switchControlToLatestWindow(driver);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(CurrencyValue_firstpath+i+CurrencyValue_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(CurrencyValue_firstpath+j+CurrencyValue_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(CurrencyValue_firstpath+k+CurrencyValue_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Currency_Set_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 String Currency =  driver.findElement(By.xpath(Currency_input_fld_firstxpath+row+Currency_input_fld_secondxpath)).getText();
		 if(Currency != null){
			 System.out.println("Able to enter currency on the field"); 
		 }else{
			 Assert.fail("Unable to enter currency");
		 }
		     }
		 }
		
	 }
	  public static void Continue(WebDriver driver){
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  WebElement continuebutton= driver.findElement(By.xpath(CashCount_Continue_btn_xpath));
			 JavascriptExecutor js = (JavascriptExecutor)driver;
			 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			 js.executeScript("arguments[0].click();", continuebutton);
			 driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	     }
}
