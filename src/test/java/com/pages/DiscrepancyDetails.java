package com.pages;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DiscrepancyDetails {
	//LMP Station Stock
	public static String GrossValue_Of_LMPStock_xpath  = "html/body/div[1]/div/div/div[3]/div/accordion/div/div/div[2]/div/div[1]/div[1]/table/tbody/tr[2]/td[2]";
	public static String VirtualItems_xpath = "html/body/div[1]/div/div/div[3]/div/accordion/div/div/div[2]/div/div[1]/div[1]/table/tbody/tr[3]/td[2]";
	public static String VoucherItems_xpath = "html/body/div[1]/div/div/div[3]/div/accordion/div/div/div[2]/div/div[1]/div[1]/table/tbody/tr[4]/td[2]";
	public static String PromotionDiscounts_xpath="html/body/div[1]/div/div/div[3]/div/accordion/div/div/div[2]/div/div[1]/div[1]/table/tbody/tr[5]/td[2]";
	public static String NetValueofLMPStock_xpath="html/body/div[1]/div/div/div[3]/div/accordion/div/div/div[2]/div/div[1]/div[1]/table/tbody/tr[6]/td[2]";
   //EPOS Sales
	public static String GrossValue_Of_EPOSSales_xpath  = "html/body/div[1]/div/div/div[3]/div/accordion/div/div/div[2]/div/div[1]/div[2]/table/tbody/tr[2]/td[2]";
	public static String EPOS_VirtualItems_xpath = "html/body/div[1]/div/div/div[3]/div/accordion/div/div/div[2]/div/div[1]/div[2]/table/tbody/tr[3]/td[2]";
	public static String EPOS_VoucherItems_xpath = "html/body/div[1]/div/div/div[3]/div/accordion/div/div/div[2]/div/div[1]/div[2]/table/tbody/tr[4]/td[2]";
	public static String EPOS_PromotionDiscounts_xpath="html/body/div[1]/div/div/div[3]/div/accordion/div/div/div[2]/div/div[1]/div[2]/table/tbody/tr[5]/td[2]";
	public static String NetValueofEPOSSales_xpath="html/body/div[1]/div/div/div[3]/div/accordion/div/div/div[2]/div/div[1]/div[2]/table/tbody/tr[6]/td[2]";
	//Total Revenue
	public static String CashHandlerExchnageRate_xpath  = "html/body/div[1]/div/div/div[3]/div/accordion/div/div/div[2]/div/div[1]/div[3]/table/tbody/tr[2]/td[2]";
	public static String EPOSExchnageRate_xpath = "html/body/div[1]/div/div/div[3]/div/accordion/div/div/div[2]/div/div[1]/div[3]/table/tbody/tr[3]/td[2]";

	//Discrepancy Value and Percentage
	public static String NetLMPvsNetEPOS_vlaue_xpath="html/body/div[1]/div/div/div[3]/div/accordion/div/div/div[2]/div/div[2]/table/tbody/tr[2]/td[2]";
	public static String NetLMPvsNetEPOS_percent_xpath="html/body/div[1]/div/div/div[3]/div/accordion/div/div/div[2]/div/div[2]/table/tbody/tr[2]/td[3]";
	public static String TotalRevenueCashHandlerExchangeRatevsNetePOS_Value_xpath = "html/body/div[1]/div/div/div[3]/div/accordion/div/div/div[2]/div/div[2]/table/tbody/tr[3]/td[2]";
	public static String TotalRevenueCashHandlerExchangeRatevsNetePOS_percent_xpath ="html/body/div[1]/div/div/div[3]/div/accordion/div/div/div[2]/div/div[2]/table/tbody/tr[3]/td[3]";
	public static String ForeignExchange_Value_xpath ="html/body/div[1]/div/div/div[3]/div/accordion/div/div/div[2]/div/div[2]/table/tbody/tr[4]/td[2]";
	public static String ForeignExchange_percent_xpath ="html/body/div[1]/div/div/div[3]/div/accordion/div/div/div[2]/div/div[2]/table/tbody/tr[4]/td[3]";
	public static String TotalDiscrepancyValue_xpath="html/body/div[1]/div/div/div[3]/div/accordion/div/div/div[2]/div/div[2]/table/tbody/tr[5]/th[2]";
	public static String TotalDiscrepancypercent_xpath="html/body/div[1]/div/div/div[3]/div/accordion/div/div/div[2]/div/div[2]/table/tbody/tr[5]/th[3]";
	
	//Stock Discrepancy lmp
	public static String StockDiscrepancylink_xpath="html/body/div[1]/div/div/div[3]/div/form/div/accordion[1]/div/div/div[1]/h4/a/span/i";
	public static String Retail_Items_xpath="//div/accordion[1]/div/div/div[2]/div/table/tbody/tr";
	public static String RetailItem_DispatchedCount_firstxpath="//div/accordion[1]/div/div/div[2]/div/table/tbody/tr";
	public static String RetailItem_DispatchedCount_secondxpath="/td[2]/span";
	public static String RetailItem_ReplenishCount_firstxpath="//div/accordion[1]/div/div/div[2]/div/table/tbody/tr";
	public static String RetailItem_ReplenishCount_secondxpath="/td[3]/span";
	public static String RetailItem_InboudedCount_firstxpath="//div/accordion[1]/div/div/div[2]/div/table/tbody/tr";
	public static String RetailItem_InboudedCount_secondxpath="/td[4]/span";
	public static String RetailItem_price_firstxpath="//div/accordion[1]/div/div/div[2]/div/table/tbody/tr";
	public static String RetailItem_price_secondxpath="/td[7]/span";
	
	//Stock DiscrepancyEPOS Sales
	public static String EposSales_Item_Count_firstxpath="//div/accordion[1]/div/div/div[2]/div/table/tbody/tr";
	public static String EposSales_Item_Count_secondxpath="/td[5]/span";
	
	
	
	//cash discrepancy
	public static String CashDiscrepancylink_xpath="html/body/div[1]/div/div/div[3]/div/form/div/accordion[2]/div/div/div[1]/h4/a/span/i";
	
	
	
	public static float GrossValueofLMPStationStock(WebDriver driver){
		String value = driver.findElement(By.xpath(GrossValue_Of_LMPStock_xpath)).getText().trim();
	   float actual = Float.valueOf(value.trim()).floatValue();
	   System.out.println(actual);
	   return actual;
	}
	
	public static float Expected_GrossValueofLMPStationStock(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath(StockDiscrepancylink_xpath)).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	int items = driver.findElements(By.xpath(Retail_Items_xpath)).size();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	float sum=0;
		for(int i= 2;i<=items;i++){
		String RetailItem_DispCont=driver.findElement(By.xpath(RetailItem_DispatchedCount_firstxpath+"["+i+"]"+RetailItem_DispatchedCount_secondxpath)).getText();	
	    int Dispatched = Integer.parseInt(RetailItem_DispCont);
	    String RetailItem_ReplCont=driver.findElement(By.xpath(RetailItem_ReplenishCount_firstxpath+"["+i+"]"+RetailItem_ReplenishCount_secondxpath)).getText();	
	    int Replenished = Integer.parseInt(RetailItem_ReplCont);
	    String RetailItem_InboCont=driver.findElement(By.xpath(RetailItem_InboudedCount_firstxpath+"["+i+"]"+RetailItem_InboudedCount_secondxpath)).getText();	
	    int Inbouded = Integer.parseInt(RetailItem_InboCont);
	    String RetailItem_price=driver.findElement(By.xpath(RetailItem_price_firstxpath+"["+i+"]"+RetailItem_price_secondxpath)).getText();	
	    float price = Float.valueOf(RetailItem_price.trim()).floatValue();
		float ItemVarianceValue =((Dispatched + Replenished) - Inbouded)* price;
		    sum += ItemVarianceValue;
		
		}
		return sum;
		
	}
	public static float NetValueOfLMPStock(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String NLMPStock= driver.findElement(By.xpath(NetValueofLMPStock_xpath)).getText(); 
		float NetValueOfLMPStock =Float.valueOf(NLMPStock.trim()).floatValue();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return NetValueOfLMPStock;
	}
	
	public static float Expected_NetValueOfLMPStock(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String Virtuals = driver.findElement(By.xpath(VirtualItems_xpath)).getText(); 
		float Vir_Items = Float.valueOf(Virtuals.trim()).floatValue();
		String Vouchers = driver.findElement(By.xpath(VoucherItems_xpath)).getText(); 
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		float Vou_Items = Float.valueOf(Vouchers.trim()).floatValue();
		String Promotions = driver.findElement(By.xpath(VoucherItems_xpath)).getText(); 
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		float Prom_Items = Float.valueOf(Promotions.trim()).floatValue();
		float NetValueOfLMPStock = DiscrepancyDetails.GrossValueofLMPStationStock(driver) + Vir_Items + Vou_Items + Prom_Items;
		return NetValueOfLMPStock;
	}
	
	
	public static float GrossValueofEPOSSales(WebDriver driver){
	String value = driver.findElement(By.xpath(GrossValue_Of_EPOSSales_xpath)).getText().trim();
	   float actual = Float.valueOf(value.trim()).floatValue();
	   System.out.println(actual);
	   return actual;
	}
	
	public static float Expected_GrossValueofEPOSSales(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath(StockDiscrepancylink_xpath)).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	int items = driver.findElements(By.xpath(Retail_Items_xpath)).size();
	float sum=0;
		for(int i= 2;i<=items;i++){
		String EposSales_ItemCount=driver.findElement(By.xpath(EposSales_Item_Count_firstxpath+"["+i+"]"+EposSales_Item_Count_secondxpath)).getText();	
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		int ItemCount = Integer.parseInt(EposSales_ItemCount);
		 String RetailItem_price=driver.findElement(By.xpath(RetailItem_price_firstxpath+"["+i+"]"+RetailItem_price_secondxpath)).getText();	
		    float price = Float.valueOf(RetailItem_price.trim()).floatValue();
		float GValueOfePossales =ItemCount* price;
		    sum += GValueOfePossales;
		
		}
		return sum;
		
	}
	public static float NetValueOfEPOSSales(WebDriver driver){
		String NEPOSsales= driver.findElement(By.xpath(NetValueofEPOSSales_xpath)).getText(); 
		float NetValueOfePOSSales =Float.valueOf(NEPOSsales.trim()).floatValue();
		return NetValueOfePOSSales;
	}
	
	public static float Expected_NetValueOfEPOSSales(WebDriver driver){
		String Virtuals = driver.findElement(By.xpath(EPOS_VirtualItems_xpath)).getText(); 
		float Vir_Items = Float.valueOf(Virtuals.trim()).floatValue();
		String Vouchers = driver.findElement(By.xpath(EPOS_VoucherItems_xpath)).getText(); 
		float Vou_Items = Float.valueOf(Vouchers.trim()).floatValue();
		String Promotions = driver.findElement(By.xpath(EPOS_PromotionDiscounts_xpath)).getText(); 
		float Prom_Items = Float.valueOf(Promotions.trim()).floatValue();
		float NetValueOfEPOSSales = DiscrepancyDetails.GrossValueofEPOSSales(driver)+ Vir_Items + Vou_Items + Prom_Items;
		return NetValueOfEPOSSales;
	}
	
	//public static float TotalRevenue_CashHandlerExchangeRate(WebDriver driver){
		
	//}
 //  public static float TotalRevenue_EPOSExchangeRate(WebDriver driver){
		
	//}
}
