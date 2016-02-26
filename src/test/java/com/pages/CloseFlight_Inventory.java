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

import com.commons.actions;


public class CloseFlight_Inventory {
	 public static String ExpandAll_btn_xpath = "//i[@data-bind='css: expandCollapse_CSS']";
	 public static String CollapseAll_btn_xpath = "//i[@data-bind='css: expandCollapse_CSS']";
	 public static String Inventory_Continue_btn_xpath = "//button[@data-bind='click: nextStep']";
	 public static String item_rows_xpath=".//*[@id='collapseOne0']/table/tbody/tr";
	 public static String item_name_firstxpath = ".//*[@id='collapseOne0']/table/tbody/tr";
	 public static String item_name_secondxpath = "/td[1]";
	 public static String ExpectedItem_count_field_firstxpath = ".//*[@id='collapseOne0']/table/tbody/tr";
	 public static String ExpectedItem_count_field_secondxpath = "/td[2]/span";
	 public static String ActualItem_count_field_firstxpath = ".//*[@id='collapseOne0']/table/tbody/tr";
	 public static String ActualItem_count_field_secondxpath = "/td[3]/input";
     public static String Select_Sector_Dropdown=".//*[@id='Main']/header/h1/div/div[2]/select";
	
     public static String Numpadpopup_firstpath ="//div[@class='mbsc-np-row']/div[text()='";
	 public static String Numpadpopup_secondpath ="']";
	 public static String Numpadpopup_Set_btn_xpath = "//div[text()='Set']";
	 public static String Numpadpopup_delete_btn_xpath = "//div[@aria-label='Delete']";
	 public static String Numpadpopup_Clear_btn_xpath = "html/body/div[2]/div/div[2]/div[2]/div[3]/div[2]/div";
	 
	 public static int ItemsCount(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 int Items=driver.findElements(By.xpath(item_rows_xpath)).size();
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	// System.out.println(Items);
		return Items;
     }
	public static void ExpandAll(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath(ExpandAll_btn_xpath)).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	public static void Collapse(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath(CollapseAll_btn_xpath)).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
     public static String Invetory_ItemName(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 int Items=CloseFlight_Inventory.ItemsCount(driver);
    	 String Invetory_ItemName=null;
    	 if(Items > 1){
    		 for(int i=1;i<=Items ;i++){
    			 Invetory_ItemName = driver.findElement(By.xpath(item_name_firstxpath+"["+i+"]"+item_name_secondxpath)).getText();
    			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    			// System.out.println(Invetory_ItemName);
    		 }
    	 }else{
    		 Invetory_ItemName = driver.findElement(By.xpath(item_name_firstxpath+item_name_secondxpath)).getText();
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 //System.out.println(Invetory_ItemName);
    	 }
		return Invetory_ItemName;
     }
     public static void switchControlToLatestWindow(WebDriver driver) {
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	
	 } 
    public static int InventoryItem_ExpectedCount(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 int Items=CloseFlight_Inventory.ItemsCount(driver);
    	 int InventoryItem_ExpectedCount=0;
    	 if(Items > 1){
    		 for(int i=1;i<=Items ;i++){
    			String EpextedCount= driver.findElement(By.xpath(ExpectedItem_count_field_firstxpath+"["+i+"]"+ExpectedItem_count_field_secondxpath)).getText();
    			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    			 String[] string1 = EpextedCount.split("\\/");
					String ExpectedCount = string1[0].trim();
					InventoryItem_ExpectedCount = Integer.parseInt(ExpectedCount);
    			// System.out.println(InventoryItem_ExpectedCount);
    		 }
    	 }else{
    		 String EpextedCount = driver.findElement(By.xpath(ExpectedItem_count_field_secondxpath+ExpectedItem_count_field_secondxpath)).getText();
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 String[] string1 = EpextedCount.split("\\/");
				String ExpectedCount = string1[0].trim();
				InventoryItem_ExpectedCount = Integer.parseInt(ExpectedCount);
			// System.out.println(InventoryItem_ExpectedCount);
    	 }
		return InventoryItem_ExpectedCount;
    }
     
    public static int InventoryItem_DamagedCount(WebDriver driver){
   	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
   	 int Items=CloseFlight_Inventory.ItemsCount(driver);
   	 int InventoryItem_DamagedCount=0;
   	 if(Items > 1){
   		 for(int i=1;i<=Items ;i++){
   			String DamagedCount= driver.findElement(By.xpath(ExpectedItem_count_field_firstxpath+"["+i+"]"+ExpectedItem_count_field_secondxpath)).getText();
   			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
   			 String[] string1 = DamagedCount.split("\\/");
					String Count = string1[1].trim();
					InventoryItem_DamagedCount = Integer.parseInt(Count);
   			// System.out.println(InventoryItem_DamagedCount);
   		 }
   	 }else{
   		 String DamagedCount = driver.findElement(By.xpath(ExpectedItem_count_field_secondxpath+ExpectedItem_count_field_secondxpath)).getText();
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 String[] string1 = DamagedCount.split("\\/");
				String Count = string1[1].trim();
				InventoryItem_DamagedCount = Integer.parseInt(Count);
			// System.out.println(InventoryItem_DamagedCount);
   	 }
		return InventoryItem_DamagedCount;
   }
    
    
    public static int InventoryItem_ActualCount(WebDriver driver){
      	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
      	 int Items=CloseFlight_Inventory.ItemsCount(driver);
      	 int InventoryItem_ActualCount=0;
      	 if(Items > 1){
      		 for(int i=1;i<=Items ;i++){
      			String ActualCount= driver.findElement(By.xpath(ActualItem_count_field_firstxpath+"["+i+"]"+ActualItem_count_field_secondxpath)).getAttribute("value");
      			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
   					InventoryItem_ActualCount = Integer.parseInt(ActualCount);
      			// System.out.println(InventoryItem_ActualCount);
      		 }
      	 }else{
      		 String ActualCount = driver.findElement(By.xpath(ActualItem_count_field_firstxpath+ActualItem_count_field_secondxpath)).getAttribute("value");
   			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
   				InventoryItem_ActualCount = Integer.parseInt(ActualCount);
   			// System.out.println(InventoryItem_ActualCount);
      	 }
   		return InventoryItem_ActualCount;
      }
       
    public static void Update_Item_ActualCount(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 int Items=CloseFlight_Inventory.ItemsCount(driver);
    	 int value = CloseFlight_Inventory.InventoryItem_ExpectedCount(driver) - (CloseFlight_Inventory.InventoryItem_ExpectedCount(driver) - 1);
    	 if(Items > 1){
      		 for(int i=1;i<=Items ;i++){
      			//driver.findElement(By.xpath(ActualItem_count_field_firstxpath+"["+i+"]"+ActualItem_count_field_secondxpath)).sendKeys(""+value);
      			driver.findElement(By.xpath(ActualItem_count_field_firstxpath+"["+i+"]"+ActualItem_count_field_secondxpath)).click();
      			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
      			driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS); 
    			Inventory.switchControlToLatestWindow(driver);
        		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS); 
        		driver.findElement(By.xpath(Numpadpopup_delete_btn_xpath)).click();
        		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS); 
    			driver.findElement(By.xpath(Numpadpopup_delete_btn_xpath)).click();
    			driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS); 
    			driver.findElement(By.xpath(Numpadpopup_delete_btn_xpath)).click();
    			driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS); 
    			driver.findElement(By.xpath(Numpadpopup_delete_btn_xpath)).click();
     			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
     			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    			driver.findElement(By.xpath(Numpadpopup_firstpath + 0 + Numpadpopup_secondpath)).click();
    			driver.findElement(By.xpath(Numpadpopup_firstpath +value + Numpadpopup_secondpath)).click();
    			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
    			driver.findElement(By.xpath(Numpadpopup_Set_btn_xpath)).click();
      		 }
      	 }else{
      		 driver.findElement(By.xpath(ActualItem_count_field_firstxpath+ActualItem_count_field_secondxpath)).sendKeys(""+value);
   			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
   				
      	 }
    	 
    }
    
     public static void CloseShop_Inventory_Continue(WebDriver driver){
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  WebElement continuebutton= driver.findElement(By.xpath(Inventory_Continue_btn_xpath));
			// JavascriptExecutor js = (JavascriptExecutor)driver;
			 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			// js.executeScript("arguments[0].click();", continuebutton);
			 continuebutton.click();
			 driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	 
      }
     
    public static void Verify_CloseFlight_Inventory_With_ReportInventory(WebDriver driver,String seal,String cashbag,String CurrencyType,String Amount) throws IOException{
   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
     	CloseFlight_Inventory.ExpandAll(driver);
		String ExpectedItems = CloseFlight_Inventory.Invetory_ItemName(driver);
		int ExpectedOpenCount = CloseFlight_Inventory.InventoryItem_ExpectedCount(driver);
		CloseFlight_Inventory.Update_Item_ActualCount(driver);
		int ExpectedCloseCount= CloseFlight_Inventory.InventoryItem_ActualCount(driver);
		CloseFlight_Inventory.CloseShop_Inventory_Continue(driver);
		CloseFlight_Seal.CloseShop_SealEntry(driver,seal);
        CloseFlight_Seal.CloseShop_Seal_Continue(driver); 
        CloseFlight_CashCount.Cashbag(driver, cashbag);
       	CloseFlight_CashCount.CashBag_CurrencyEntry(driver, CurrencyType, Amount);
        CloseFlight_CashCount.Continue(driver);
        CloseFlight_CashCount.Accept_CashCountPopUp(driver);
        String a=CloseFlight_Confirmation.CloseShop_FlightRoute(driver);
   	    String String1=a.substring(0, 3);
   	    String String2=a.substring(3,6);
        String val = CloseFlight_Confirmation.CloseShop_Flightnum(driver)+" "+String1+" "+"-"+" "+String2+" "+CloseFlight_Confirmation.CloseShop_FlightDate(driver);
        CloseFlight_Confirmation.Continue(driver);
        Signature.Sign(driver); 
        Signature.InformationReview(driver);
        Signature.Accept_Signature(driver);
        Homepage.Reports(driver);
        JavascriptExecutor js= (JavascriptExecutor) driver;
	    js.executeScript("return document.readyState").equals("complete");
	    WebDriverWait ww= new WebDriverWait(driver,30);
	    ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Select_Sector_Dropdown)));
    	actions.selectByVisibleText(driver, "xpath", Select_Sector_Dropdown, val);
    	Homepage.Navigate_to_Report(driver, "Inventory / C209");
    	String ActualItems = Reports.Invetory_ItemName(driver);
    	int ActualOpenCount = Reports.InventoryItem_OpenCount(driver);
    	int ActualCloseCount=Reports.InventoryItem_CloseCount(driver);
    if(ActualItems.equalsIgnoreCase(ExpectedItems)){
    		System.out.println("All items displayed");
    		if(ActualOpenCount == ExpectedOpenCount){
    			System.out.println("OpenCount is as expected");
    			if(ActualCloseCount == ExpectedCloseCount){
        			System.out.println("CloseCount is updated and as expected");
        		}else{
        			Assert.fail("CloseCount is different");
        		}
    		}else{
    			Assert.fail("OpenCount is different");
    		}
    		
    	}else{
    		Assert.fail("Items not displayed");
    	}
    	
    }
}
