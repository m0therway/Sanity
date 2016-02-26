package com.pages;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.commons.utilities;

public class SalesAndOrders extends utilities {
	WebDriver driver=null;
	public static String SalesPanel_Name_xpath="html/body/div[2]/div/div/div[1]/div[1]/div/div/div/div[3]";
	public static String SalesPanel_Colour_xpath="html/body/div[2]/div/div/div[1]/div[1]/div";
	public static String SalesPanel_Total_xpath="html/body/div[2]/div/div/div[1]/div[1]/div/div/div/div[2]";
	public static String CompsPanel_Name_xpath="html/body/div[2]/div/div/div[1]/div[3]/div/div/div/div[3]";
	public static String CompsPanel_Colour_xpath="html/body/div[2]/div/div/div[1]/div[3]/div";
	public static String CompsPanel_Total_xpath="html/body/div[2]/div/div/div[1]/div[3]/div/div/div/div[2]";
	public static String OrdersPanel_Name_xpath="html/body/div[2]/div/div/div[1]/div[4]/div/div/div/div[3]";
	public static String OrdersPanel_Colour_xpath="html/body/div[2]/div/div/div[1]/div[4]/div";
	public static String OrdersPanel_Count_xpath="html/body/div[2]/div/div/div[1]/div[4]/div/div/div/div[2]";
	public static String SalesAndOrdersCount_xpath = "html/body/div[2]/div/div/div[1]/div[4]/div/div/div/div[2]";	
	//public static String AbandonedCount_xpath="html/body/div[2]/div/div/ul/li[2]/a/span";	
	public static String AbandonedCount_xpath=".//*[@id='Main']/div[2]/div/ul/li[2]/a/span";
	//public static String CompletedCount_xpath="html/body/div[2]/div/div/ul/li[1]/a/span";
	public static String CompletedCount_xpath=".//*[@id='Main']/div[2]/div/ul/li[1]/a/span";
	//public static String TotalSaleAmount_xpath="html/body/div[2]/div/div/div[1]/div[1]/div/div/div/div[2]";
	public static String TotalSaleAmount_xpath="/html/body/section[2]/div[1]/div/div/div[1]/div/div/div[1]";
	public static String Sale_Transaction_Amount_firstxpath=".//*[@id='CompletedSales']/tbody/tr";
	public static String Sale_Transaction_Amount_secondxpath="/td[7]";
	public static String AbandonedTransactionsCount_xpath=".//*[@id='AbandonedCarts']/tbody/tr";	
	public static String CompletedTransactionsCount_xpath=".//*[@id='CompletedSales']/tbody/tr";
	//public static String Tabs_xpath="html/body/div[2]/div/div/ul/li";
	public static String Tabs_xpath=".//*[@id='Main']/div[2]/div/ul/li";
	//public static String Tab_Name_firstpath="html/body/div[2]/div/div/ul/li[";
	//public static String Tab_Name_secondpath="]/a";
	public static String Tab_Name_firstpath=".//*[@id='Main']/div[2]/div/ul/li[";
	public static String Tab_Name_secondpath="]/a";
	public static String Abandoned_link_xpath="//a[@href='#tabAbandonedCarts']";
	public static String Completed_link_xpath="//a[@href='#tabCompletedCarts']";
	public static String DuesAndCollectibles_link_xpath="//a[@href='#tabChangeAndRentalsDueCarts']";
	public static String SalesAnd_Orders_link="//a[@href='sales.html']";
	public static String Trans_Type_firstxpath=".//*[@id='CompletedSales']/tbody/tr";
	public static String Trans_Type_secondxpath="/td[6]";
	
	public static void Verify_Tabs(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		int tabs=driver.findElements(By.xpath(Tabs_xpath)).size();
		String[] Expectedtabs={"Completed","Abandoned","Dues & Collectibles"};
		for(int i=1;i<=tabs;i++){
			for(int j=0;j<Expectedtabs.length;j++){
		String Tabname = driver.findElement(By.xpath(Tab_Name_firstpath+i+Tab_Name_secondpath)).getText();
		if(Tabname.equalsIgnoreCase(Expectedtabs[j])){
			System.out.println(Tabname +" "+"is as expected");
		}else{
			Assert.fail("Tab is missing or name is not matching");
		}
			}
		}
		System.out.println(" "+", are as expected");
	}
	public static void VerifySalespanel(WebDriver driver,String panelname,String panelcolour) throws IOException{
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			String pname = driver.findElement(By.xpath(SalesPanel_Name_xpath)).getText();
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			WebElement total =  driver.findElement(By.xpath(SalesPanel_Total_xpath));
			String ptotal = driver.findElement(By.xpath(SalesPanel_Total_xpath)).getText();
			String[] String = ptotal.split("\\"+getValue("CurrencySymbol1"));
	    	float TotalSaleAmount = Float.valueOf(String[1].trim()).floatValue();
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			String pcolour = driver.findElement(By.xpath(SalesPanel_Colour_xpath)).getAttribute("class");
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
	public static void VerifyCompspanel(WebDriver driver,String panelname,String panelcolour) throws IOException{
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			String pname = driver.findElement(By.xpath(CompsPanel_Name_xpath)).getText();
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			WebElement total =  driver.findElement(By.xpath(CompsPanel_Total_xpath));
			String ptotal = driver.findElement(By.xpath(CompsPanel_Total_xpath)).getText();
			String[] String = ptotal.split("\\"+getValue("CurrencySymbol1"));
	    	float TotalSaleAmount = Float.valueOf(String[1].trim()).floatValue();
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			String pcolour = driver.findElement(By.xpath(CompsPanel_Colour_xpath)).getAttribute("class");
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
	public static void VerifyOrderspanel(WebDriver driver,String panelname,String panelcolour) throws IOException{
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			String pname = driver.findElement(By.xpath(OrdersPanel_Name_xpath)).getText();
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			WebElement OrdersRefundsCount =  driver.findElement(By.xpath(OrdersPanel_Count_xpath));
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			String pcolour = driver.findElement(By.xpath(OrdersPanel_Colour_xpath)).getAttribute("class");
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			if(pname.equalsIgnoreCase(panelname)){
				System.out.println(pname+" " +"displayed on the panel");
				driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
				if(OrdersRefundsCount.isDisplayed()){
					System.out.println(pname+" "+"Count displayed on the panel"+" "+"Count is: "+" "+OrdersRefundsCount);
					driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
				if(pcolour.equals(panelcolour)){
							System.out.println(pname+" " + "panel colour is"+" "+ pcolour+" "+  " and is as expected");
							driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
						        }else{
						        	Assert.fail("Panel colour is different");
						        }
					 }else{
						 Assert.fail("Count not displayed");
					 }
					
				   }else{
					   Assert.fail("Panel Name not displayed");  
				   }
	 } 
	public static float TotalSaleAmount(WebDriver driver) throws IOException{
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    	String amount =driver.findElement(By.xpath(TotalSaleAmount_xpath)).getText();
	    	String[] String = amount.split("\\"+getValue("CurrencySymbol1"));
	    	float TotalSaleAmount = Float.valueOf(String[1].trim()).floatValue();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			return TotalSaleAmount;
		 }
	
	 public static int SalesCount(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 String count =driver.findElement(By.xpath(SalesAndOrdersCount_xpath)).getText();
	    	String[] String = count.split("\\/");
	    	int SalesCount = Integer.parseInt(String[0]);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			return SalesCount;
		 }
	 public static float SaleAmountBytransaction(WebDriver driver) throws IOException{
		   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  int saletrans= driver.findElements(By.xpath(Sale_Transaction_Amount_firstxpath)).size();
			  float  saleTransAmount = 0;
			  if(saletrans==0){
					String amount =driver.findElement(By.xpath(Sale_Transaction_Amount_firstxpath+Sale_Transaction_Amount_secondxpath)).getText(); 
					String[] String = amount.split("\\"+getValue("CurrencySymbol1"));
				   	String[] String1=String[1].split(getValue("Currency"));
				   	saleTransAmount = Float.valueOf(String1[0].trim()).floatValue();
						driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  }else{
				  for(int i=1;i<=saletrans;i++){
		   	String amount =driver.findElement(By.xpath(Sale_Transaction_Amount_firstxpath+"["+i+"]"+Sale_Transaction_Amount_secondxpath)).getText();
				 
		   	String[] String = amount.split("\\"+getValue("CurrencySymbol1"));
		   	String[] String1=String[1].split(getValue("transactionCurrency"));
		   float TransAmount = Float.valueOf(String1[0].trim()).floatValue();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				saleTransAmount += TransAmount;
				  }
			  }
			return saleTransAmount;
		 }
	 
	 public static int AbandonedCount(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 String Count=driver.findElement(By.xpath(AbandonedCount_xpath)).getText();
		 int  AbandonedCount=Integer.parseInt(Count);
			return AbandonedCount;
		 }
	 
	 
	 public static int AbandonedTransactionsCount(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Abandoned_link_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 String Count=driver.findElement(By.xpath(AbandonedCount_xpath)).getText();
		 int  AbandonedCount=Integer.parseInt(Count);
			return AbandonedCount;
		 }
	 public static int CompletedCount(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 String Count=driver.findElement(By.xpath(CompletedCount_xpath)).getText();
		 int  CompletedTransCount=Integer.parseInt(Count);
		// System.out.println(CompletedTransCount);
			return CompletedTransCount;
		 }
	 public static int CompletedTransactionsCount(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 int Count=driver.findElements(By.xpath(CompletedTransactionsCount_xpath)).size();
		 //System.out.println(Count);
			return Count;
		 }
	 
	 public static void Verify_AbandonedTransaction(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 int AbandonedCount = SalesAndOrders.AbandonedCount(driver);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 int AbandonedTransCount=SalesAndOrders.AbandonedTransactionsCount(driver);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 if(AbandonedCount == AbandonedTransCount ){
			 System.out.println("Abandoned Transactions displayed on the screen");
		 }else{
			 Assert.fail("Abandoned transactions not displyed");
		 }
		 
	 }
	 
     public static void Verify_CompletedTransaction(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 int CompletedCount = SalesAndOrders.CompletedCount(driver);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 int CompletedTransCount=SalesAndOrders.CompletedTransactionsCount(driver);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 if(CompletedCount == CompletedTransCount){
			 System.out.println("Completed Transactions displayed on the screen");
		 }else{
			 Assert.fail("Completed transactions not displyed");
		 }
		 
	 }
     
     public static void Verify_TotalSales_Amount(WebDriver driver) throws IOException{
    	float ExpectedTotal =  SalesAndOrders.TotalSaleAmount(driver);
    	float ActualTotal= SalesAndOrders.SaleAmountBytransaction(driver);
    	if(ActualTotal == ExpectedTotal){
    		System.out.println("Sales total amount is as expected, Actual amount is" + " "+ActualTotal +" "+ "Expected is"+" "+ ExpectedTotal);
    	}else{
    		Assert.fail("Displayed total sales amount on the panel is calculated incorrectly");
    	}
     }
     
     
     public static float TotalSale_Amount_after_Refunds(WebDriver driver) throws IOException{
    	 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    	 driver.findElement(By.xpath(SalesAnd_Orders_link)).click();
    	 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  int saletrans= driver.findElements(By.xpath(Sale_Transaction_Amount_firstxpath)).size();
		  float  saleTransAmount = 0;
		 
		  if(saletrans==0){
			  String Trans_Status = driver.findElement(By.xpath(CompletedTransactionsCount_xpath)).getAttribute("class");
			if(Trans_Status.contains("strike-through")){
				System.out.println("Transactions refunded");
			}else{
		
				String amount =driver.findElement(By.xpath(Sale_Transaction_Amount_firstxpath+Sale_Transaction_Amount_secondxpath)).getText(); 
				String[] String = amount.split("\\"+getValue("CurrencySymbol1"));
			   	String[] String1=String[1].split(getValue("Currency"));
			   	saleTransAmount = Float.valueOf(String1[0]).floatValue();
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			}
		  }else{
			  for(int i=1;i<=saletrans;i++){
				  String Trans_Status = driver.findElement(By.xpath(CompletedTransactionsCount_xpath+"["+i+"]")).getAttribute("class");
				  if(Trans_Status.contains("strike-through")){
						System.out.println("Transactions refunded");
					}else{  
	   	String amount =driver.findElement(By.xpath(Sale_Transaction_Amount_firstxpath+"["+i+"]"+Sale_Transaction_Amount_secondxpath)).getText();
			 
	   	String[] String = amount.split("\\"+getValue("CurrencySymbol1"));
	   	String[] String1=String[1].split(getValue("transactionCurrency"));
	   float TransAmount = Float.valueOf(String1[0]).floatValue();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			saleTransAmount += TransAmount;
					}
			  }
		  }
		 // System.out.println(NumberFormat.getCurrencyInstance().format(saleTransAmount));
		System.out.println(saleTransAmount);
		return saleTransAmount;
		
    	 
     }
     
     public static float Cash_Total(WebDriver driver) throws IOException{
    	 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  int saletrans= driver.findElements(By.xpath(Sale_Transaction_Amount_firstxpath)).size();
		  float  saleTransAmount = 0;
		  if(saletrans==0){
			  String Trans_Status = driver.findElement(By.xpath(CompletedTransactionsCount_xpath)).getAttribute("class");
			  String Tran_Type=driver.findElement(By.xpath(Trans_Type_firstxpath)).getText();
			if(Trans_Status.contains("strike-through")){
				
				System.out.println("Transactions refunded");
			}else{
		    if(Tran_Type.equals("CASH")){
				String amount =driver.findElement(By.xpath(Sale_Transaction_Amount_firstxpath+Sale_Transaction_Amount_secondxpath)).getText(); 
				String[] String = amount.split("\\"+getValue("CurrencySymbol1"));
			   	String[] String1=String[1].split(getValue("Currency"));
			   	saleTransAmount = Float.valueOf(String1[0].trim()).floatValue();
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  }
			}
		  }else{
			  for(int i=1;i<=saletrans;i++){
				  String Trans_Status = driver.findElement(By.xpath(CompletedTransactionsCount_xpath+"["+i+"]")).getAttribute("class");
				  String Tran_Type=driver.findElement(By.xpath(Trans_Type_firstxpath+"["+i+"]"+Trans_Type_secondxpath)).getText();
				  if(Trans_Status.contains("strike-through")){
						System.out.println("Transactions refunded");
					}else{  
						if(Tran_Type.equals("CASH")){
	   	String amount =driver.findElement(By.xpath(Sale_Transaction_Amount_firstxpath+"["+i+"]"+Sale_Transaction_Amount_secondxpath)).getText();
	   	String[] String = amount.split("\\"+getValue("CurrencySymbol1"));
	   	String[] String1=String[1].split(getValue("transactionCurrency"));
	   float TransAmount = Float.valueOf(String1[0].trim()).floatValue();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			saleTransAmount += TransAmount;
						}
					}
			  }
		  }
		  System.out.println(saleTransAmount);
		return saleTransAmount;
		
      	 
       }
     
     public static float Credit_Total(WebDriver driver) throws IOException{
    	 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  int saletrans= driver.findElements(By.xpath(Sale_Transaction_Amount_firstxpath)).size();
		  float  saleTransAmount = 0;
		  if(saletrans==0){
			  String Trans_Status = driver.findElement(By.xpath(CompletedTransactionsCount_xpath)).getAttribute("class");
			  String Tran_Type=driver.findElement(By.xpath(Trans_Type_firstxpath)).getText();
			if(Trans_Status.contains("strike-through")){
				
				System.out.println("Transactions refunded");
			}else{
		  if(Tran_Type.equals("CREDIT")){
				String amount =driver.findElement(By.xpath(Sale_Transaction_Amount_firstxpath+Sale_Transaction_Amount_secondxpath)).getText(); 
				String[] String = amount.split("\\"+getValue("CurrencySymbol1"));
			   	String[] String1=String[1].split(getValue("Currency"));
			   	saleTransAmount = Float.valueOf(String1[0].trim()).floatValue();
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  }
			}
		  }else{
			  for(int i=1;i<=saletrans;i++){
				  String Trans_Status = driver.findElement(By.xpath(CompletedTransactionsCount_xpath+"["+i+"]")).getAttribute("class");
				  String Tran_Type=driver.findElement(By.xpath(Trans_Type_firstxpath+"["+i+"]"+Trans_Type_secondxpath)).getText();
				  if(Trans_Status.contains("strike-through")){
						System.out.println("Transactions refunded");
					}else{  
						if(Tran_Type.equals("CREDIT")){
	   	String amount =driver.findElement(By.xpath(Sale_Transaction_Amount_firstxpath+"["+i+"]"+Sale_Transaction_Amount_secondxpath)).getText();
			 
	   	String[] String = amount.split("\\"+getValue("CurrencySymbol1"));
	   	String[] String1=String[1].split(getValue("transactionCurrency"));
	   float TransAmount = Float.valueOf(String1[0].trim()).floatValue();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			saleTransAmount += TransAmount;
						}
					}
			  }
		  }
		  System.out.println(saleTransAmount);
		return saleTransAmount;
		
     	 
     	 
      }
}
