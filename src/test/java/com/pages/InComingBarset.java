package com.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.commons.common;

public class InComingBarset {
	 WebDriver driver = null;
		public static String LMPStation_dpdn_xpath="//div/select[@name='CateringStation']";
		public static String ScheduleDate_fld_xpath="//input[@name='scheduleDate']";
		public static String ScheduleNumber_fld_xpath="html/body/div[1]/div/div[1]/form/div[3]/div[2]/div/div/div/span";
		public static String ScheduleNumber_xpath="html/body/div[1]/div/div[1]/form/div[3]/div[2]/div/div/ul/li/div[3]/a/div";
		public static String StoreNumber_dpdn_xpath="//div/select[@name='StoreNumber']";
		public static String SelectMenus_fld_xpath="html/body/div[1]/div/div[1]/form/div[5]/div[2]/div/div/div/input";
		public static String SelectMenus_xpath="html/body/div[1]/div/div[1]/form/div[5]/div[2]/div/div/ul/li/div[4]/a/div";
		public static String AirCraftTail_Num_dpdn_xpath="//div/select[@name='carrierNumber']";
		public static String Menus_fld_xpath="html/body/div[1]/div/div[1]/form/div[5]/div[2]/div/div/div/span/span/span/span[2]/span";
		public static String Next_btn_xpath="//button[@class='btn btn-success']";
	//inboundseals
		public static String InBoundSeal_fld_xpath="//form/div[4]/seal-type/div/div[2]/div/div/div/div/input";
		public static String InBoundSeal_link_xpath="//form/div[4]/seal-type/div/div[2]/div/div/div/ul/li/div[3]/a/small/span";
		public static String HighSecuritySeal_fld_xpath="//form/div[5]/seal-type/div/div[2]/div/div/div/div/input";
		public static String HighSecuritySeal_link_xpath="//form/div[5]/seal-type/div/div[2]/div/div/div/ul/li/div[3]/a/small/span";
	//packing
		public static String RetailItemsCount_xpath="html/body/div[1]/div/div/form/div[3]/table/tbody/tr";
		public static String InboundQuantity_firstxpath="html/body/div[1]/div/div/form/div[3]/table/tbody/tr";
		public static String InboundQuantity_secondxpath="/td[1]/input";
		public static String UllageQuantity_firstxpath="html/body/div[1]/div/div/form/div[3]/table/tbody/tr";
		public static String UllageQuantity_secondxpath="/td[3]/input";
		public static String UllageReason_fld_firstxpath="html/body/div[1]/div/div/form/div[3]/table/tbody/tr";
		public static String UllageReason_fld_secondxpath="/td[4]/div/div/span/span[1]";
		public static String UllageReason_firstxpath="html/body/div[1]/div/div/form/div[3]/table/tbody/tr";
		public static String UllageReason_secondxpath="/td[4]/div/ul/li/div[3]/a]";
		public static String TemplateQuantity_firstxpath="html/body/div[1]/div/div/form/div[3]/table/tbody/tr";
		public static String TemplateQuantity_secondxpath="/td[5]/input";
		public static String DispatchedQuantity_firstxpath="html/body/div[1]/div/div/form/div[3]/table/tbody/tr";
		public static String DispatchedQuantity_secondxpath="/td[6]/input";
		public static String PickedQuantity_firstxpath="html/body/div[1]/div/div/form/div[3]/table/tbody/tr";
		public static String PickedQuantity_secondxpath="/td[7]/input";
		public static String VarienceWaring_xpath="html/body/div[1]/div/div/form/div[3]/table/tbody/tr";
		public static String Varience_ThreshHold_popup = "html/body/div[1]/div/div/form/div[1]/div/div/div[1]";
		public static String Varience_ThreshHold_popup_Yes_btn="html/body/div[1]/div/div/form/div[1]/div/div/div[3]/button[1]";
		public static String Varience_ThreshHold_popup_No_btn="html/body/div[1]/div/div/form/div[1]/div/div/div[3]/button[2]";
		
		public static void Create_Redispatch_Instance(WebDriver driver,String LMPStation,String scheduleDate, String ScheduleNum,String StoreNumber,String Menu) throws IOException{
		StoreInstance.CreateStore_Instance(driver, LMPStation, ScheduleNum, StoreNumber,Menu);
		StoreInstance.Next(driver);
	     }
      
	
	    public static void InboundSeals(WebDriver driver){
	    	StoreInstance.Next(driver);
	    }
	
	   public static void packing(WebDriver driver){
		   StoreInstance.Next(driver);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String Variance=null;
		   if(driver.findElements(By.xpath(Varience_ThreshHold_popup)).size() != 0){
					 common.switchControlToLatestWindow(driver);
					 driver.findElement(By.xpath(Varience_ThreshHold_popup_No_btn)).click();
					 int items= driver.findElements(By.xpath(RetailItemsCount_xpath)).size();
					 if(items > 1){
					  for(int i=1;i<=items;i++){
					   Variance=driver.findElement(By.xpath(VarienceWaring_xpath+"["+i+"]")).getAttribute("class");
					   if(Variance.contentEquals("ng-scope danger")){
						 String TempQuan = driver.findElement(By.xpath(TemplateQuantity_firstxpath+"["+i+"]"+TemplateQuantity_secondxpath)).getText();
						 int temp=Integer.parseInt(TempQuan);
						 driver.findElement(By.xpath(DispatchedQuantity_firstxpath+"["+i+"]"+DispatchedQuantity_secondxpath)).clear();
						 driver.findElement(By.xpath(DispatchedQuantity_firstxpath+"["+i+"]"+DispatchedQuantity_secondxpath)).sendKeys(""+temp);
						 driver.findElement(By.xpath(InboundQuantity_firstxpath+"["+i+"]"+InboundQuantity_secondxpath)).clear();
						 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						 int InboundQuantity = temp - (temp - 5);
						 driver.findElement(By.xpath(InboundQuantity_firstxpath+"["+i+"]"+InboundQuantity_secondxpath)).sendKeys(""+InboundQuantity);
						 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						 driver.findElement(By.xpath(UllageQuantity_firstxpath+"["+i+"]"+UllageQuantity_secondxpath)).clear();
						 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						 int UllageQuantity = InboundQuantity-(InboundQuantity-4);
						 driver.findElement(By.xpath(UllageQuantity_firstxpath+"["+i+"]"+UllageQuantity_secondxpath)).sendKeys(""+UllageQuantity);
						 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						 driver.findElement(By.xpath(UllageReason_fld_firstxpath+"["+i+"]"+UllageReason_fld_secondxpath)).click();
						 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						 driver.findElement(By.xpath(UllageReason_firstxpath+"["+i+"]"+UllageReason_secondxpath)).click();
						 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						 StoreInstance.Next(driver);
						 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						 common.switchControlToLatestWindow(driver);
						 driver.findElement(By.xpath(Varience_ThreshHold_popup_Yes_btn)).click();
						   StoreInstance.Next(driver);
					   }
							}
					 }else{
						 Variance=driver.findElement(By.xpath(VarienceWaring_xpath)).getAttribute("class");
						 String TempQuan = driver.findElement(By.xpath(TemplateQuantity_firstxpath+TemplateQuantity_secondxpath)).getText();
						 int temp=Integer.parseInt(TempQuan);
						 int InboundQuantity = temp - (temp - 5);
						 int UllageQuantity = InboundQuantity-(InboundQuantity-4);
						 if(Variance.contentEquals("ng-scope danger")){
							 driver.findElement(By.xpath(InboundQuantity_firstxpath+InboundQuantity_secondxpath)).clear();
							 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
							 driver.findElement(By.xpath(InboundQuantity_firstxpath+InboundQuantity_secondxpath)).sendKeys(""+InboundQuantity);
							 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
							 driver.findElement(By.xpath(UllageQuantity_firstxpath+UllageQuantity_secondxpath)).clear();
							 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
							 driver.findElement(By.xpath(UllageQuantity_firstxpath+UllageQuantity_secondxpath)).sendKeys("" +UllageQuantity);
							 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
							 driver.findElement(By.xpath(UllageReason_fld_firstxpath+UllageReason_fld_secondxpath)).click();
							 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
							 driver.findElement(By.xpath(UllageReason_firstxpath+UllageReason_secondxpath)).click();
							 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
							 StoreInstance.Next(driver);
							 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
							 common.switchControlToLatestWindow(driver);
							 driver.findElement(By.xpath(Varience_ThreshHold_popup_Yes_btn)).click();
							 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
							 StoreInstance.Next(driver);
						   }
					 }
		     }
		  
	    }
	
       public static void AssignSeals(WebDriver driver,String OutboundSeal, String HandOverSeal, String InbountSeal,String HighSecuritySeal){
		StoreInstance.AssignSeals(driver, OutboundSeal, HandOverSeal, InbountSeal, HighSecuritySeal);
	   }
    
    
        public static void Redispatch(WebDriver driver){
        	StoreInstance.Dispatch(driver);
        }
    
	    
}
