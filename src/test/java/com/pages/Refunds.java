package com.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.commons.actions;
import com.commons.common;
import com.commons.utilities;

public class Refunds extends utilities{
	WebDriver driver=null;
	public static String RefundsPanel_Name_xpath="html/body/div[2]/div/div/div[1]/div[2]/div/div/div/div[3]";
	public static String RefundsPanel_Colour_xpath="html/body/div[2]/div/div/div[1]/div[2]/div";
	public static String RefundsPanel_Total_xpath="html/body/div[2]/div/div/div[1]/div[2]/div/div/div/div[2]";
	public static String Completed_Transactions_xpath="//*[@id='CompletedSales']/tbody/tr";
	public static String Completed_Transaction_firstxpath = "//*[@id='CompletedSales']/tbody/tr";
	public static String Completed_Transaction_secondxpath = "[";
	public static String Completed_Transaction_thirdxpath = "]";
	public static String Completed_TransTender_firstxpath = "//*[@id='CompletedSales']/tbody/tr";
	public static String Completed_TransTender_secondxpath = "[";
	public static String Completed_TransTender_thirdxpath = "/td[5]";
	//public static String Refund_btn_xpath = ".//*[@id='myWizard']/div[2]/div[1]/a[1]";
	//public static String Refund_btn_xpath = ".//*[@id='myWizard']/div[3]/div[1]/a[1]";
	public static String Refund_btn_xpath = ".//*[@id='tabOrder']/a[1]";
	public static String RefundPassword_popup_Header_xpath ="html/body/div[4]/div/div/div[1]/h4/h2";
	public static String AuthorizedCrewId_fld_xpath=".//*[@id='crew_id']";
	public static String Canecl_btn_xpath ="//button[@data-bb-handler='danger']";
	public static String Ok_btn_xpath ="//button[@data-bb-handler='main']";
	public static String Refund_popup_Title_xpath = ".//*[@id='myModalLabel']";
	public static String incrementRefundQty_btn_xpath ="//button[@data-bind='click: $root.incrementRefundQty']";
	public static String decrementRefundQty_btn_xpath ="//button[@data-bind='click: $root.decrementRefundQty']";
	public static String incrementRestockQty_btn_xpath ="//button[@data-bind='click: $root.incrementRefundQty']";
	public static String decrementRestockQty_btn_xpath ="//button[@data-bind='click: $root.decrementRefundQty']";
	public static String Refund_Reason_dpdn_firstxpath=".//*[@id='ModalBodyRefund']/section[1]/table/tbody/tr";
	public static String Refund_Reason_dpdn_secondxpath="/td[6]/div/select";
	public static String Refund_Cancel_btn_xpath=".//*[@id='ModalBodyRefund']/button[1]";
	public static String Refund_Refund_btn_xpath=".//*[@id='ModalBodyRefund']/div/button[1]";
	public static String Refund_Passengerinfo_xpath ="//div[@id='PassengerInfo']";
	public static String Refund_Transactions_xpath=".//*[@id='Refunds']/tbody/tr";
	//public static String Total_Refund_Amount_xpath="/html/body/div[2]/div/div/div[1]/div[2]/div/div/div/div[2]";
	public static String Total_Refund_Amount_xpath=".//*[@id='Main']/div[1]/div/div/div[2]/div/div/div[1]";
	//public static String RefundAmount_ByTransaction_firstxpath=".//*[@id='Refunds']/tbody/tr";
	public static String RefundAmount_ByTransaction_firstxpath="//table[@id='Refunds']/tbody/tr";
	public static String RefundAmount_ByTransaction_secondxpath="/td[7]";
	//public static String Refunds_tab_xpath=".//*[@id='Main']/div[2]/div/ul/li[4]/a";
	public static String Refunds_tab_xpath=".//*[@id='Main']/div[2]/div/ul/li[5]/a";
	public static String Sales_link=".//*[@id='menustrip']/li[2]/a[@href='sales.html']";
	public static String Refund_Auth_popup_xpath=".//*[@id='Modal1']/div/div";
	public static String Refund_Auth_popup_Refund_btn=".//*[@id='ModalBodyRefundAuthorization']/div[3]/button[1]";
	public static String Refun_popup_xpath=".//*[@id='ModalRefund']/div";
	
	public static void VerifyRefundspanel(WebDriver driver,String panelname,String panelcolour,String CurrencySymbol) throws IOException{
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			String pname = driver.findElement(By.xpath(RefundsPanel_Name_xpath)).getText();
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			WebElement total =  driver.findElement(By.xpath(RefundsPanel_Total_xpath));
			String ptotal = driver.findElement(By.xpath(RefundsPanel_Total_xpath)).getText();
			String[] String = ptotal.split("\\"+CurrencySymbol);
	    	float TotalSaleAmount = Float.valueOf(String[1].trim()).floatValue();
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			String pcolour = driver.findElement(By.xpath(RefundsPanel_Colour_xpath)).getAttribute("class");
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			if(pname.equalsIgnoreCase(panelname)){
				System.out.println(pname+" " +"displayed on the panel");
				driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
				if(total.isDisplayed()){
					System.out.println(pname+" "+"total displayed on the panel"+" "+"total is: "+" "+TotalSaleAmount);
					driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
				if(pcolour.equals(panelcolour)){
							System.out.println(pname+" " + "panel colour is"+" "+ pcolour+" "+  " and is as expected");
							driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
						        }else{
						        	Assert.fail("Panel colour is different");
						        }
					 }else{
						 Assert.fail("Total not displayed");
					 }
				   }else{
					   Assert.fail("Panel Name not displayed");  
				   }
	 }
	 
	
	 public static void switchControlToLatestWindow(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	
	 }
	public static void VerifyRefundscreen(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		int Transactions = driver.findElements(By.xpath(Completed_Transactions_xpath)).size();
		WebElement RefundBtn=driver.findElement(By.xpath(Refund_btn_xpath));
		if(Transactions > 0){
			if(RefundBtn.isDisplayed()){
				System.out.println("RefundBtn displayed under transaction");
			}
		}else{
			System.out.println("No transaction to Refund");
		}
		
	}
    public static void VerifyRefundPasswordPopup(WebDriver driver){
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	driver.findElement(By.xpath(Refund_btn_xpath)).click();	
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	switchControlToLatestWindow(driver);
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	String ActualHeader= driver.findElement(By.xpath(RefundPassword_popup_Header_xpath)).getText();
    	String ExpectedHeader ="Refund Password";
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	WebElement Passwordfld=driver.findElement(By.xpath(AuthorizedCrewId_fld_xpath));
    	WebElement CancelBtn= driver.findElement(By.xpath(Canecl_btn_xpath));
    	WebElement OKBtn= driver.findElement(By.xpath(Ok_btn_xpath));
    	if(ActualHeader.equals(ExpectedHeader)){
    		if(Passwordfld.isDisplayed()||CancelBtn.isDisplayed()||OKBtn.isDisplayed()){
    			System.out.println("Refund Password Popup displayed all fields");
    		}else{
    			System.out.println("Refund Password Popup did not display fields");
    		}
    	}
    	
	}
   
   
    public static void SelectTransaction_To_Refund1(WebDriver driver,String Tender){
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	//driver.findElement(By.xpath(Sales_link)).click();
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	int transactions=driver.findElements(By.xpath(Completed_Transactions_xpath)).size();
    	
    	System.out.println();
    	if(transactions >1){
    		for(int i=1;i<=transactions;i++){
    			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    		
    		String Status = driver.findElement(By.xpath(Completed_Transactions_xpath+"["+i+"]")).getAttribute("class");
    		System.out.println(Status);
    		if(Status.contains("strike-through")){
    			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);	
        		}else {
        			String TransTender = driver.findElement(By.xpath(Completed_TransTender_firstxpath+Completed_TransTender_secondxpath+i+"]"+Completed_TransTender_thirdxpath)).getText();
            		System.out.println(TransTender);
            		if(TransTender.equals(Tender)){
        			driver.findElement(By.xpath(Completed_Transaction_firstxpath+Completed_Transaction_secondxpath+i+Completed_Transaction_thirdxpath)).click();
            		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            	 break;	
            		}
        			}
        		
    		}
    	}else{
    		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    		
    		String Status =driver.findElement(By.xpath(Completed_Transactions_xpath)).getAttribute("class");
    		if(Status.contains("strike-through")){
    			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);	
        		}else {
        			String TransTender = driver.findElement(By.xpath(Completed_TransTender_firstxpath+Completed_TransTender_thirdxpath)).getText();
            		System.out.println(TransTender);
            		if(TransTender.equals(Tender)){
        			driver.findElement(By.xpath(Completed_Transaction_firstxpath)).click();
            		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            		
            		}
        	
        		}
    	}
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }
 
    public static void SelectTransaction_To_Refund(WebDriver driver,String Tender){
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	driver.findElement(By.xpath(Sales_link)).click();
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	int transactions=driver.findElements(By.xpath(Completed_Transactions_xpath)).size();
    	
    	System.out.println();
    	if(transactions >1){
    		for(int i=1;i<=transactions;i++){
    			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    		String TransTender = driver.findElement(By.xpath(Completed_TransTender_firstxpath+Completed_TransTender_secondxpath+i+"]"+Completed_TransTender_thirdxpath)).getText();
    		System.out.println(TransTender);
    		String Status = driver.findElement(By.xpath(Completed_TransTender_firstxpath+Completed_TransTender_secondxpath+i+"]"+Completed_TransTender_thirdxpath)).getAttribute("class");
    		if(TransTender.equals(Tender)){
        			driver.findElement(By.xpath(Completed_Transaction_firstxpath+Completed_Transaction_secondxpath+i+Completed_Transaction_thirdxpath)).click();
            		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            		break;
        		}
    	
    		}
    	}else{
    		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    		String TransTender = driver.findElement(By.xpath(Completed_TransTender_firstxpath+Completed_TransTender_thirdxpath)).getText();
    		if(TransTender.equals(Tender)){
    			
    			driver.findElement(By.xpath(Completed_Transaction_firstxpath)).click();
        		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    		}
    	
    	}
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }
    public static String RefundPassengerDetails1(WebDriver driver){
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	String PassengerDetails = driver.findElement(By.xpath(Refund_Passengerinfo_xpath)).getText();
    	System.out.println(PassengerDetails);
		return PassengerDetails;
    }
    
    public static String Refund_PassengerName(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  String PassengerDetails =  Refunds.RefundPassengerDetails1(driver);
	        String[] String=PassengerDetails.split(" ");
	        String PassengerName=String[1]+" "+String[2];
	        System.out.println(PassengerName);
			return PassengerName;
	 }
	 public static String Refund_PassengerSeat(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  String PassengerDetails =  Refunds.RefundPassengerDetails1(driver);
	        String[] String=PassengerDetails.split(" ");
	        String PassengerSeat=String[4]+String[5];
	        System.out.println(PassengerSeat);
			return PassengerSeat;
	 }
    public static void RefundProcess(WebDriver driver,String RefundCrewId) throws InterruptedException, IOException{
    /*	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	driver.findElement(By.xpath(Completed_Transaction_xpath+"[1]")).click();
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);*/
    	 JavascriptExecutor js= (JavascriptExecutor) driver;
   	  js.executeScript("arguments[0].click();", driver.findElement(By.xpath(Refund_btn_xpath)));
    	//driver.findElement(By.xpath(Refund_btn_xpath)).click();
    	driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
    	common.Wait_Until_ElementVisible(driver, Refund_Auth_popup_xpath);
    	switchControlToLatestWindow(driver);
    	driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
    	driver.findElement(By.xpath(AuthorizedCrewId_fld_xpath)).sendKeys(RefundCrewId);
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	driver.findElement(By.xpath(Refund_Auth_popup_Refund_btn)).click();
    	common.Wait_Until_ElementVisible(driver, Refun_popup_xpath);
    	switchControlToLatestWindow(driver);
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	int items = driver.findElements(By.xpath(Refund_Reason_dpdn_firstxpath)).size();
    	if(items > 1){
    	 for(int i=1;i<=items;i++){
    	actions.selectByindex(driver, "xpath", Refund_Reason_dpdn_firstxpath+"["+i+"]"+Refund_Reason_dpdn_secondxpath, 1);
    	 }
    	}else{
    		actions.selectByindex(driver, "xpath",Refund_Reason_dpdn_firstxpath+Refund_Reason_dpdn_secondxpath, 1);
    	}
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	driver.findElement(By.xpath(Refund_Refund_btn_xpath)).click();
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
    public static float TotalRefundAmount(WebDriver driver,String CurrencySymbol) throws IOException{
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	String amount =driver.findElement(By.xpath(Total_Refund_Amount_xpath)).getText();
    	String[] String = amount.split("\\"+CurrencySymbol);
    	float TotalRefundAmount = Float.valueOf(String[1].trim()).floatValue();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return TotalRefundAmount;
    }
   
   public static float RefundAmountByTransaction(WebDriver driver,String CurrencySymbol) throws IOException{
	   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
   	driver.findElement(By.xpath(Sales_link)).click();
   	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	   driver.findElement(By.xpath(Refunds_tab_xpath)).click();
	   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  int resfundtrans= driver.findElements(By.xpath(Refund_Transactions_xpath)).size();
	  float  TransRefundAmount = 0;
	  if(resfundtrans > 1){
		  for(int i=1;i<=resfundtrans;i++){
			   	String amount =driver.findElement(By.xpath(RefundAmount_ByTransaction_firstxpath+"["+i+"]"+RefundAmount_ByTransaction_secondxpath)).getText();
			   	System.out.println(amount);
			   	String[] String = amount.split("\\"+CurrencySymbol);
			   	String[] String1=String[1].split(getValue("transactionCurrency"));
			   	float RefundAmount = Float.valueOf(String1[0].trim()).floatValue();
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					TransRefundAmount += RefundAmount; 
					}
	  } else{
		  String amount =driver.findElement(By.xpath(RefundAmount_ByTransaction_firstxpath+RefundAmount_ByTransaction_secondxpath)).getText(); 
		  System.out.println(amount);
			String[] String = amount.split("\\"+CurrencySymbol);
		 String[] String1=String[1].split(getValue("transactionCurrency"));
		   	TransRefundAmount = Float.valueOf(String1[0].trim()).floatValue();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  }
	
	
	return TransRefundAmount;
	   }
   
   public static void Verify_Total_RefundAmount(WebDriver driver,String CurrencySymbol) throws IOException{
	   float ActualRefundAmount = Refunds.RefundAmountByTransaction(driver,CurrencySymbol);
	   float ExpectedRefundTotal = Refunds.TotalRefundAmount(driver,CurrencySymbol);
	  
	   if(ActualRefundAmount == ExpectedRefundTotal){
		   System.out.println("Refund total amount is as expected, Actual amount is" + " "+ActualRefundAmount +" "+ "Expected is"+" "+ ExpectedRefundTotal);
   	}else{
   		Assert.fail("Displayed total Refund amount on the panel is calculated incorrectly");
   	}
   }
}
