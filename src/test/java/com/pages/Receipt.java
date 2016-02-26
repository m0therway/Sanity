package com.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commons.actions;

public class Receipt {
	WebDriver driver=null;
	public static String Header_String_xpath = ".//*[@id='Receipt']/div/div[1]/h4";
	public static String Receipt_Options_count_xapth=".//*[@id='Receipt']/div/div[2]/a";
	public static String Receipt_Options_text_firstxapth=".//*[@id='Receipt']/div/div[2]/a[";
	public static String Receipt_Options_text_secondxapth="]";
	public static String PrintReceipt_popup_Label_xpath = ".//*[@id='myModalLabel']";
	public static String Print_btn_xpath = "//button[text()='Print']";
	public static String Close_btn_xpath = "//button[text()='Close']";
	public static String Done_btn_xpath = ".//*[@id='Receipt']/section[2]/div/button";
	public static String PayNow_btn_xpath="//button[text()='Pay Now']";
	//public static String Exact_btn_xpath = ".//*[@id='CashDetails']/div[1]/div/button[2]";
	public static String Exact_btn_xpath = ".//*[@id='CashDetails']/div[2]/div/button";
	public static String Email_popup="html/body/div[1]/div/div/div";
	public static String Email_popup_Email_fld_xpath="html/body/div[1]/div/div/div/div[2]/div/input";
	public static String Email_popup_ok_btn_xpath="html/body/div[1]/div/div/div/div[3]/div/button[2]";
	public static String Email_popup_cancel_btn_xpath="html/body/div[1]/div/div/div/div[3]/div/button[1]";
	
	public static void switchControlToLatestWindow(WebDriver driver) {
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	
	 }
	
	public static void VerifyReceiptPage(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String ActualpageHeader =  driver.findElement(By.xpath(Header_String_xpath)).getText();
		String ExpectedpageHeader = "How would you like your receipt?";
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 int ActualReceiptOptions = driver.findElements(By.xpath(Receipt_Options_count_xapth)).size();
		 int ExpectedReceiptOptions = 3;
		 String ActualOptionOne = driver.findElement(By.xpath(Receipt_Options_text_firstxapth+1+Receipt_Options_text_secondxapth)).getText();
		 String ActualOptionTwo = driver.findElement(By.xpath(Receipt_Options_text_firstxapth+2+Receipt_Options_text_secondxapth)).getText();
		 String ActualOptionThree = driver.findElement(By.xpath(Receipt_Options_text_firstxapth+3+Receipt_Options_text_secondxapth)).getText();
		 String ExpectedOptionOne = "Print Receipt";
		 String ExpectedOptionTwo = "Phone Number";
		 String ExpectedOptionThree = "Email";
		 WebElement Donebutton = driver.findElement(By.xpath(Done_btn_xpath));
		 if(ActualReceiptOptions == ExpectedReceiptOptions){
			 
			 if(ActualpageHeader.equals(ExpectedpageHeader)||ActualOptionOne.equals(ExpectedOptionOne)||ActualOptionTwo.equals(ExpectedOptionTwo)
					 ||ActualOptionThree.equals(ExpectedOptionThree)||Donebutton.isDisplayed() ){
					 
				 System.out.println("All Receipt options, and Done button are displayed ");
				 
			 }else{
				 
				 System.out.println("Receipt options are not displayed");
			 }
		 }
		 
		 
	}
	
	
	public static void Email_Receipt(WebDriver driver,String EmailAdd){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Receipt_Options_text_firstxapth+3+Receipt_Options_text_secondxapth)).click();
		WebDriverWait ww= new WebDriverWait(driver,30);
		ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Email_popup)));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Email_popup_Email_fld_xpath)).sendKeys(EmailAdd);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Email_popup_ok_btn_xpath)).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	}
    public static void VerifyPrintReceiptOption(WebDriver driver,String seatrow,String seat){
    	Payments.Select_SeatNum(driver,seatrow,seat);
		 driver.findElement(By.xpath(Exact_btn_xpath)).click(); 
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(PayNow_btn_xpath)).click(); 
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	driver.findElement(By.xpath(Receipt_Options_text_firstxapth+1+Receipt_Options_text_secondxapth)).click();
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	switchControlToLatestWindow(driver);
    	String ActualpopupLabel= driver.findElement(By.xpath(PrintReceipt_popup_Label_xpath)).getText();
    	String ExpectedpopupLabel= "Print Receipt";
    	WebElement Printbtn = driver.findElement(By.xpath(Print_btn_xpath));
    	WebElement Closebtn = driver.findElement(By.xpath(Close_btn_xpath));
    	if(ActualpopupLabel.equals(ExpectedpopupLabel)){
    		
    		if(Printbtn.isDisplayed()||Closebtn.isDisplayed()){
    			System.out.println("Print Receiptpopup displayed with Print and Close buttons");
    		}else{
    			System.out.println("No buttons displayed");
    		}
    	}
    	
		
	}
    
    
    public static void CompleteSales(WebDriver driver){
    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    driver.findElement(By.xpath(Done_btn_xpath)).click();
	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	 
    	
    }
	
}
