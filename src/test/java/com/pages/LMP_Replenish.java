package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commons.utilities;

public class LMP_Replenish extends StoreInstance{
	 WebDriver driver = null;
	  public static String ScheduleNumber_fld_xpath="html/body/div[1]/div/div[1]/form/div[3]/div[2]/div/div/div/span";
	   public static String ScheduleNumber_xpath="html/body/div[1]/div/div[1]/form/div[3]/div[2]/div/div/ul/li/div[3]/a/div";
	   public static String Next_btn_xpath="//button[@class='btn btn-success']";
	
	//Replenish packing
	    public static String RetailItems_Count_xpath="html/body/div[1]/div/div/form/div[3]/table/tbody/tr";
		public static String PickedItem_fld_firstxpath="html/body/div[1]/div/div/form/div[3]/table/tbody/tr";
		public static String PickedItem_fld_secondxpath="/td[1]/input";
		public static String PickedQuantity_fld_firstxpath="html/body/div[1]/div/div/form/div[3]/table/tbody/tr";
		public static String PickedQuantity_fld_secondxpath="/td[2]/input";
		 
	
	//Assign Replenish seals
		public static String OutBoundSeal_fld_xpath="//form/div[1]/seal-type/div/div[2]/div/div/div/div/input";
		public static String OutBoundSeal_link_xpath="//form/div[1]/seal-type/div/div[2]/div/div/div/ul/li/div[3]/a/small/span";
		public static String InBoundSeal_fld_xpath="//form/div[2]/seal-type/div/div[2]/div/div/div/div/input";
		public static String InBoundSeal_link_xpath="//form/div[2]/seal-type/div/div[2]/div/div/div/ul/li/div[3]/a/small/span";
	

		
		//Modal box
		public static String Modal_box_xpath="html/body/loading-modal/div/div/div/div/p";

		

		public static void Create_Store_Replenish(WebDriver driver){
			StoreInstanceDashBoard.Wait_Until_ModelBox_Disappears(driver);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    	driver.findElement(By.xpath(ScheduleNumber_fld_xpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath(ScheduleNumber_xpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
		
        public static void Replenish_Packing(WebDriver driver,String pickedQuantity){
        	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			int RetailItems = driver.findElements(By.xpath(RetailItems_Count_xpath)).size();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			if(RetailItems > 1){
				for(int i=1;i<=RetailItems;i++){
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					driver.findElement(By.xpath(PickedQuantity_fld_firstxpath+"["+i+"]"+PickedQuantity_fld_secondxpath)).clear();
					driver.findElement(By.xpath(PickedQuantity_fld_firstxpath+"["+i+"]"+PickedQuantity_fld_secondxpath)).sendKeys(pickedQuantity);
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				}
			}else{
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				driver.findElement(By.xpath(PickedQuantity_fld_firstxpath+PickedQuantity_fld_secondxpath)).clear();
				driver.findElement(By.xpath(PickedQuantity_fld_firstxpath+PickedQuantity_fld_secondxpath)).sendKeys(pickedQuantity);
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			}
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
		}
        

		
        public static void Assign_Replenish_Seals(WebDriver driver,String OutboundSeal,String InbountSeal){
        	WebDriverWait ww = new WebDriverWait(driver,30);
			ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OutBoundSeal_fld_xpath)));
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath(OutBoundSeal_fld_xpath)).sendKeys(OutboundSeal);
			 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			 driver.findElement(By.xpath(OutBoundSeal_link_xpath)).click();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath(InBoundSeal_fld_xpath)).sendKeys(InbountSeal);
			 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.findElement(By.xpath(InBoundSeal_link_xpath)).click();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
        
     
        public static void Replenish_Dispatch(WebDriver driver){
        	 StoreInstance.Dispatch(driver);
		}
        
    
}
