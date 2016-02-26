package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.commons.common;

public class End_StoreInstance {
	
	 public static String EndInstance_link_firstxpath="html/body/div[1]/div/div[1]/table/tbody";
	 public static String EndInstance_link_secondxpath="/tr";
	 public static String EndInstance_link_thirdxpath="/td[12]/a[4]";
	 public static String OffLoad_ListCount_xpath="html/body/div[1]/div/div/form/div[4]/table/tbody/tr";
	 public static String OffLoad_InboundQuantity_fld_firstxpath = "html/body/div[1]/div/div/form/div[4]/table/tbody/tr";
	 public static String OffLoad_InboundQuantity_fld_secondxpath = "/td[2]/input";
	 public static String Ullage_Quantity_fld_firstxpath = "html/body/div[1]/div/div/form/div[4]/table/tbody/tr";
	 public static String Ullage_Quantity_fld_secondxpath = "/td[3]/input";
	 public static String UllageReason_fld_firstxpath = "html/body/div[1]/div/div/form/div[4]/table/tbody/tr";
	 public static String UllageReason_fld_secondxpath = "td[4]/div/div/span";
	 public static String UllageReason_firstxpath = "html/body/div[1]/div/div/form/div[4]/table/tbody/tr";
	 public static String UllageReason_secondxpath = "td[4]/div/ul/li/div";
	 public static String UllageReason_thirdxpath = "/a/div";
	 public static String EndInstance_btn_xpath="html/body/div[1]/div/div/form/footer/button[2]";
	 
	
     
     public static void EndStoreInstance(WebDriver driver){
    	StoreInstance.Next(driver); 
    	
     }
     public static void InboundSeals(WebDriver driver){
    	 StoreInstanceDashBoard.Wait_Until_ModelBox_Disappears(driver);  
    	 StoreInstance.Next(driver); 
     }
     
     public static void OffLoad(WebDriver driver,String Inboundquantity,String UllageQuantity){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
    	 int list = driver.findElements(By.xpath(OffLoad_ListCount_xpath)).size();
    	 if(list > 1){
    		 for(int i=1;i<=list;i++){
    			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				 driver.findElement(By.xpath(OffLoad_InboundQuantity_fld_firstxpath+"["+i+"]"+OffLoad_InboundQuantity_fld_secondxpath)).clear();
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
				 driver.findElement(By.xpath(OffLoad_InboundQuantity_fld_firstxpath+"["+i+"]"+OffLoad_InboundQuantity_fld_secondxpath)).sendKeys(Inboundquantity);
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				 driver.findElement(By.xpath(Ullage_Quantity_fld_firstxpath+"["+i+"]"+Ullage_Quantity_fld_secondxpath)).clear();
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
				 driver.findElement(By.xpath(Ullage_Quantity_fld_firstxpath+"["+i+"]"+Ullage_Quantity_fld_secondxpath)).sendKeys(UllageQuantity);
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				 driver.findElement(By.xpath(UllageReason_fld_firstxpath+"["+i+"]"+UllageReason_fld_secondxpath)).click();
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				 driver.findElement(By.xpath(UllageReason_firstxpath+"["+i+"]"+UllageReason_secondxpath+"["+1+"]"+UllageReason_thirdxpath)).click(); 
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    		 }
    	 }else{
    		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 driver.findElement(By.xpath(OffLoad_InboundQuantity_fld_firstxpath+OffLoad_InboundQuantity_fld_secondxpath)).clear();
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
			 driver.findElement(By.xpath(OffLoad_InboundQuantity_fld_firstxpath+OffLoad_InboundQuantity_fld_secondxpath)).sendKeys(Inboundquantity);
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 driver.findElement(By.xpath(Ullage_Quantity_fld_firstxpath+Ullage_Quantity_fld_secondxpath)).clear();
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
			 driver.findElement(By.xpath(Ullage_Quantity_fld_firstxpath+Ullage_Quantity_fld_secondxpath)).sendKeys(UllageQuantity);
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 driver.findElement(By.xpath(UllageReason_fld_firstxpath+UllageReason_fld_secondxpath)).click();
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 driver.findElement(By.xpath(UllageReason_firstxpath+UllageReason_secondxpath+"["+1+"]"+UllageReason_thirdxpath)).click(); 
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	 }
    	 StoreInstance.Next(driver); 
     }
     
     public static void ReviewAndEndDispatch(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
    	 driver.findElement(By.xpath(EndInstance_btn_xpath)).click(); 
    	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     }
     
     
}
