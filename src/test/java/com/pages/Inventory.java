package com.pages;


import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commons.actions;


public class Inventory {
	WebDriver driver=null;
	
	 public static String ExpandAll_btn_xpath = "//i[@data-bind='css: expandCollapse_CSS']";
	 public static String CollapseAll_btn_xpath = "//i[@data-bind='css: expandCollapse_CSS']";
	 public static String menu_title_text_firstxpath="/html/body/div[3]/div/div/div[5]/section/div[";
	 public static String menu_title_text_secondxpath = "]/div[1]/h3";
	 public static String menus_xpath = "/html/body/div[3]/div/div/div[5]/section/div";
	 public static String item_table_rows_firstxpath="/html/body/div[3]/div/div/div[5]/section/div[";
	 public static String item_table_rows_secondxpath="]/div[2]/table/tbody/tr";
	 public static String DamagedItemCount_fld_firstxpath= "html/body/section[2]/div[2]/div/div[2]/div[4]/section/div/div[2]/table/tbody/tr";
	 public static String DamagedItemCount_fld_secondxpath="/td[4]/div/div/div/div[2]/table/tbody/tr/td[1]/div/input";
	 
	 public static String NewLine_btn_firstxpath="html/body/section[2]/div[2]/div/div[2]/div[4]/section/div/div[2]/table/tbody/tr";
	 public static String NewLine_btn_secondxpath="/td[4]/div/div/div/div[3]/button[1]";
	 public static String DamagedItem_Delete_btn_firstxpath= "html/body/section[2]/div[2]/div/div[2]/div[4]/section/div/div[2]/table/tbody/tr";
	 public static String DamagedItem_Delete_btn_secondxpath="/td[3]/button";
	 public static String Done_btn_firstxpath="html/body/section[2]/div[2]/div/div[2]/div[4]/section/div/div[2]/table/tbody/tr";
	 public static String Done_btn_secondxpath="/td[4]/div/div/div/div[3]/button[2]";
	 public static String Inventory_Continue_btn_xpath = "//button[@id='btnInventory']";
	 public static String ActualItems_Count_xpath = "/html/body/div[5]/div/div[2]/div[2]/div[2]/div[1]/div[2]/span[4]"+"/html/body/div[5]/div/div[2]/div[2]/div[2]/div[1]/div[2]/span[5]";
	//new xpaths
	 public static String Items_Count=".//*[@id='headingOne']/h3/span";
	 public static String NoOfItemRows = ".//*[@id='collapseOne0']/table/tbody/tr";
	 public static String Expected_ItemsCount_field_firstxpath=".//*[@id='collapseOne0']/table/tbody/tr";
	 public static String Expected_ItemsCount_field_secondxpath="/td[2]/span";
	// public static String ActualAvailableItems_field_firstxpath="/html/body/section[2]/div[2]/div/div[2]/div[5]/section/div/div[2]/table/tbody/tr";
	 public static String ActualAvailableItems_field_firstxpath="html/body/section[2]/div[2]/div/div[2]/div[4]/section/div/div[2]/table/tbody/tr";
	 public static String ActualAvailableItems_field_secondxpath="/td[3]/input[2]";
	 public static String ItemsName_field_firstxpath=".//*[@id='collapseOne0']/table/tbody/tr";
	 public static String ItemsName_field_secondxpath="/td[1]";
	 //public static String DamagedItembtn_firstxpath="/html/body/section[2]/div[2]/div/div[2]/div[5]/section/div/div[2]/table/tbody/tr";
	 public static String DamagedItembtn_firstxpath="html/body/section[2]/div[2]/div/div[2]/div[4]/section/div/div[2]/table/tbody/tr";
	 public static String DamagedItembtn_secondxpath="/td[4]/button[2]";
	 public static String DamagedItems_Count_firstxpath=".//*[@id='collapseOne0']/table/tbody/tr";
	 public static String DamagedItems_Count_secondxpath="/td[4]/button[2]/span";
	 public static String Numpadpopup_firstpath ="//div[@class='mbsc-np-row']/div[text()='";
	 public static String Numpadpopup_secondpath ="']";
	 public static String Numpadpopup_Set_btn_xpath = "//div[text()='Set']";
	 public static String Numpadpopup_delete_btn_xpath = "//div[@aria-label='Delete']";
	 public static String Numpadpopup_Clear_btn_xpath = "html/body/div[2]/div/div[2]/div[2]/div[3]/div[2]/div";
	
	 //InventoryManagement
	 public static String InventoryManagement_Item_firstxpath="html/body/section[2]/section/div/div[2]/table/tbody/tr";
	 public static String InventoryManagement_Item_secondxpath="/td[1]";
	 public static String InventoryManagement_ActualCount_firstxpath="html/body/section[2]/section/div/div[2]/table/tbody/tr";
	 public static String InventoryManagement_ActualCount_secondxpath="/td[3]/input[2]";
	 public static String InventoryManagement_DamagedCount_firstxpath="html/body/section[2]/section/div/div[2]/table/tbody/tr";
	 public static String InventoryManagement_DamagedCount_secondxpath="/td[4]/button[2]/span";
	 
	 public static void VerifyExpandAllBtn(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	
		 WebElement ExpandAllBtn = driver.findElement(By.xpath(ExpandAll_btn_xpath));
		 if(ExpandAllBtn.isDisplayed()||ExpandAllBtn.isEnabled()){
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	 
			 driver.findElement(By.xpath(ExpandAll_btn_xpath)).click();
			 System.out.println("ExpandAllBtn is Displayed and Enabled");
		      }else{
		    	Assert.fail("ExpandAllBtn is not Displayed");  
		      }
	 }
	 public static void VerifyMenu(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
		 WebElement menu = driver.findElement(By.xpath(menu_title_text_firstxpath+1+menu_title_text_secondxpath));
		 if(menu.isDisplayed()){
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
			 System.out.println("Menu is displayed");
		 }else{
			 Assert.fail("Menu is not Displayed"); 
		 }
	 }
	 public static void Verifyitems(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 WebElement menuitem = driver.findElement(By.xpath(item_table_rows_firstxpath+1+item_table_rows_secondxpath));
		 if(menuitem.isDisplayed()){
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
			 System.out.println("Menu items are displayed");
		 }else{
			 Assert.fail("Menu items are not Displayed");  
		 }
	 }
	 
	 public static void VerifyExpecteditemsFld(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 WebElement ExpecteditemsFld = driver.findElement(By.xpath(Expected_ItemsCount_field_firstxpath+1+Expected_ItemsCount_field_secondxpath));
		 if(ExpecteditemsFld.isDisplayed()||ExpecteditemsFld.isEnabled()){
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
			 driver.findElement(By.xpath(Expected_ItemsCount_field_firstxpath+1+Expected_ItemsCount_field_secondxpath)).click();
			 System.out.println("ExpecteditemsFld is displayed and Enabled");
		 }else{
			 Assert.fail("ExpecteditemsFld is not Displayed");  
		 }
	 }
     public static void VerifyActualAvailbleitemsFld(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 WebElement ActualAvailbleitemFld = driver.findElement(By.xpath(ActualAvailableItems_field_firstxpath+1+ActualAvailableItems_field_secondxpath));
		 if(ActualAvailbleitemFld.isDisplayed()||ActualAvailbleitemFld.isEnabled()){
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
			 driver.findElement(By.xpath(ActualAvailableItems_field_firstxpath+1+ActualAvailableItems_field_secondxpath)).click();
			 System.out.println("ActualAvailbleitemFld is displayed and Enabled");
		 }else{
			 Assert.fail("ActualAvailbleitemFld is not Displayed");  
		 }
	 }
     public static void VerifyDamagedBtn(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 WebElement DamagedBtn = driver.findElement(By.xpath(DamagedItembtn_firstxpath+1+DamagedItembtn_secondxpath));
		 if(DamagedBtn.isDisplayed()||DamagedBtn.isEnabled()){
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
			 driver.findElement(By.xpath(DamagedItembtn_firstxpath+1+DamagedItembtn_secondxpath)).click();
			 System.out.println("DamagedBtn is displayed and Enabled");
		 }else{
			 Assert.fail("DamagedBtn is not Displayed");  
		 }
	 }
     
    
     public static void VerifyCollapseAllBtn(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	
		 WebElement CollapseAllBtn = driver.findElement(By.xpath(CollapseAll_btn_xpath));
		 if(CollapseAllBtn.isDisplayed()||CollapseAllBtn.isEnabled()){
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	 
			 driver.findElement(By.xpath(CollapseAll_btn_xpath)).click();
			 System.out.println("CollapseAllBtn is Displayed and Enabled");
		      }else{
					 Assert.fail("CollapseAllBtn is not Displayed");  
				 }
	 }
     public static void VerifyContinueBtn(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 WebElement ContinueBtn = driver.findElement(By.xpath(Inventory_Continue_btn_xpath));
    	 if(ContinueBtn.isDisplayed()||ContinueBtn.isEnabled()){
    		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    			 driver.findElement(By.xpath(Inventory_Continue_btn_xpath)).click();
    			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    			 System.out.println("ContinueBtn is displayed and Enabled");
    	 }else{
			 Assert.fail("ContinueBtn is not Displayed");  
		 }
	 }
	 public static void switchControlToLatestWindow(WebDriver driver) {
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	
	 }
	 public static void SelectMenu(WebDriver driver, String menutitle){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 int menucount = driver.findElements(By.xpath(menus_xpath)).size();
		 System.out.println(menucount);
		 for(int i=1;i<=menucount;i++){
			 String panel = driver.findElement(By.xpath(menu_title_text_firstxpath+i+menu_title_text_secondxpath)).getText();
			 System.out.println(panel);
		 if(panel.contains(menutitle)){
			 driver.findElement(By.xpath(menu_title_text_firstxpath+i+menu_title_text_secondxpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  }
		 }
	 }
	 
	 
	 
	 public static void Verify_ActualItemCount_with_ExpectedItemCount(WebDriver driver,String item) throws InterruptedException{
		 driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
    	int ActualItemscount = Inventory.ActualItemsCount(driver);
    	 int ExpectedItemscount = Inventory.ExpectedItemsCount(driver);
    	 if(ActualItemscount==ExpectedItemscount){
    		 System.out.println("Actual count is equal to expected count");
    	 }else{
    		 Assert.fail("Count is not matching");
    	 }
	 }
	
     public static void Continue(WebDriver driver){
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  WebElement continuebutton= driver.findElement(By.xpath(Inventory_Continue_btn_xpath));
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 js.executeScript("arguments[0].click();", continuebutton);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
     }
     

     
     public static int ExpectedItemsCount(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 String ItemsCount = driver.findElement(By.xpath(Items_Count)).getText();
    	 int ExpectedItemsCount =Integer.parseInt(ItemsCount);
    	// System.out.println(ExpectedItemsCount);
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return ExpectedItemsCount;
     }
     
     public static int ActualItemsCount(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
    	 driver.findElement(By.xpath(ExpandAll_btn_xpath)).click();
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
    	 int rows=driver.findElements(By.xpath(NoOfItemRows)).size();
    	// System.out.println(rows);
		return rows;
     }
     
     
     public static int Item_Expected_Available_Count(WebDriver driver,int item){
    	 driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
    	 int items=driver.findElements(By.xpath(NoOfItemRows)).size();
    	 int ExpectedItems =0;
    	 if(items > 1){
    		String ExpectedCount = driver.findElement(By.xpath(Expected_ItemsCount_field_firstxpath+"["+item+"]"+Expected_ItemsCount_field_secondxpath)).getText();
    		ExpectedItems = Integer.parseInt(ExpectedCount);
    //System.out.println(ExpectedItems);
    	 }else{

     		String ExpectedCount = driver.findElement(By.xpath(Expected_ItemsCount_field_firstxpath+Expected_ItemsCount_field_secondxpath)).getText();
     		ExpectedItems = Integer.parseInt(ExpectedCount);
  // 		System.out.println(ExpectedItems); 
    	 }
    	return ExpectedItems;
     }
     public static int Item_Actual_Available_Count(WebDriver driver,int item){
    	 driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
    	 int items=driver.findElements(By.xpath(NoOfItemRows)).size();
    	 int Actual_Available =0;
    	 if(items > 1){
    		 String Count = driver.findElement(By.xpath(ActualAvailableItems_field_firstxpath+"["+item+"]"+ActualAvailableItems_field_secondxpath)).getAttribute("value");
    		 Actual_Available = Integer.parseInt(Count);
   //	System.out.println(Actual_Available);
    	 }else{
    		 String Count = driver.findElement(By.xpath(ActualAvailableItems_field_firstxpath+ActualAvailableItems_field_secondxpath)).getAttribute("value");
    		 Actual_Available= Integer.parseInt(Count);
    //	System.out.println(Actual_Available); 
    	 }
    	return Actual_Available;
     }
     public static void Inventory_ExpandAll(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
    	 driver.findElement(By.xpath(ExpandAll_btn_xpath)).click();
    	 driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
     }
     
     public static void Update_ActualItemsCount(WebDriver driver,int item){
    	 int ExpectedItems = Inventory.Item_Expected_Available_Count(driver,item);
    	 int items=driver.findElements(By.xpath(NoOfItemRows)).size();
    	 int updateItems = 5;
    	 if(items > 1){
    			driver.findElement(By.xpath(ActualAvailableItems_field_firstxpath+"["+item+"]"+ActualAvailableItems_field_secondxpath)).click();
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
    		    driver.findElement(By.xpath(Numpadpopup_firstpath +0+ Numpadpopup_secondpath)).click();
    			driver.findElement(By.xpath(Numpadpopup_firstpath + updateItems + Numpadpopup_secondpath)).click();
    			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
    			driver.findElement(By.xpath(Numpadpopup_Set_btn_xpath)).click();
    			
    		
    	
         }else{
     			driver.findElement(By.xpath(ActualAvailableItems_field_firstxpath+ActualAvailableItems_field_secondxpath)).click();
     		Inventory.switchControlToLatestWindow(driver);
     		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
     		driver.findElement(By.xpath(Numpadpopup_delete_btn_xpath)).click();
     		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
     		driver.findElement(By.xpath(Numpadpopup_delete_btn_xpath)).click();
 			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
     		driver.findElement(By.xpath(Numpadpopup_delete_btn_xpath)).click();
     		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
     		driver.findElement(By.xpath(Numpadpopup_delete_btn_xpath)).click();
 			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
 		    driver.findElement(By.xpath(Numpadpopup_firstpath + 0 + Numpadpopup_secondpath)).click();
 			driver.findElement(By.xpath(Numpadpopup_firstpath + updateItems + Numpadpopup_secondpath)).click();
 			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
 			driver.findElement(By.xpath(Numpadpopup_Set_btn_xpath)).click();
     		}
    	 }
    	 
  
    	 
//     }
     
     public static void Verify_UpdatedActualItemsCount(WebDriver driver,int item){
    	int Expected = 5;
         System.out.println(Expected);
    	int CountAfterUpdate= Inventory.Item_Actual_Available_Count(driver,item);
    	System.out.println(CountAfterUpdate);
    	         if(CountAfterUpdate == Expected){
    	        	 System.out.println("Items count updated successfully");
    	         }else{
    	        	 Assert.fail();
    	         } 
    	
     }
     
     public static void Update_DamagedItemsCount(WebDriver driver,int item){
    	 driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
    	 int items=driver.findElements(By.xpath(NoOfItemRows)).size();
    	 int DamagedItems = Inventory.Item_Actual_Available_Count(driver,item)-4;
    	 System.out.println(DamagedItems);
    	 if(items > 1){
    		 driver.findElement(By.xpath(DamagedItembtn_firstxpath+"["+item+"]"+DamagedItembtn_secondxpath)).click();
    		 WebDriverWait ww=new WebDriverWait(driver,30);
    		 ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/section[2]/div[2]/div/div[2]/div[4]/section/div/div[2]/table/tbody/tr"+"["+item+"]"+"/td[4]/div/div")));
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 switchControlToLatestWindow(driver);
			 driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
			driver.findElement(By.xpath(NewLine_btn_firstxpath+"["+item+"]"+NewLine_btn_secondxpath)).click();
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 driver.findElement(By.xpath(DamagedItemCount_fld_firstxpath+"["+item+"]"+DamagedItemCount_fld_secondxpath)).sendKeys("" +DamagedItems);
			 actions.selectByVisibleText(driver, "xpath", "/html/body/section[2]/div[2]/div/div[2]/div[4]/section/div/div[2]/table/tbody/tr["+item+"]/td[4]/div/div/div/div[2]/table/tbody/tr/td[2]/div/select", "Damaged");
			 driver.findElement(By.xpath(Done_btn_firstxpath+"["+item+"]"+Done_btn_secondxpath)).click(); 
			 }else{
				 driver.findElement(By.xpath(DamagedItembtn_firstxpath+DamagedItembtn_secondxpath)).click();
				 WebDriverWait ww=new WebDriverWait(driver,30);
	    		 ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/section[2]/div[2]/div/div[2]/div[4]/section/div/div[2]/table/tbody/tr/td[4]/div/div")));
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				 switchControlToLatestWindow(driver);
				 driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
				driver.findElement(By.xpath(NewLine_btn_firstxpath+NewLine_btn_secondxpath)).click();
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				 driver.findElement(By.xpath(DamagedItemCount_fld_firstxpath+DamagedItemCount_fld_secondxpath)).sendKeys("" +DamagedItems);
				 actions.selectByVisibleText(driver, "xpath", "/html/body/section[2]/div[2]/div/div[2]/div[4]/section/div/div[2]/table/tbody/tr/td[4]/div/div/div/div[2]/table/tbody/tr/td[2]/div/select", "Damaged");
				 driver.findElement(By.xpath(Done_btn_firstxpath+Done_btn_secondxpath)).click(); 
			 }

			
     }
     
   public static void Verify_Update_DamagedItems_Count(WebDriver driver,int item){
	   driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
	   int ExpectedCount = Inventory.Item_Actual_Available_Count(driver,item)-4;
	   System.out.println(ExpectedCount);
  	 driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
  	 int items=driver.findElements(By.xpath(NoOfItemRows)).size();
	 if(items > 1){
	  String Count = driver.findElement(By.xpath(DamagedItems_Count_firstxpath+"["+item+"]"+DamagedItems_Count_secondxpath)).getText();
	   int ActualCount = Integer.parseInt(Count);
	   System.out.println(ActualCount);
	   if(ActualCount == ExpectedCount){
		  System.out.println("Damaged Items updated successfully");
	   }else{
		   Assert.fail();
	   }
	 }else{
		 String Count = driver.findElement(By.xpath(DamagedItems_Count_firstxpath+DamagedItems_Count_secondxpath)).getText();
		   int ActualCount = Integer.parseInt(Count);
		   System.out.println(ActualCount);
		   if(ActualCount == ExpectedCount){
			  System.out.println("Damaged Items updated successfully");
		   }else{
			   Assert.fail();
		   } 
	 }
   }
   
  
   
   public static String ItemName(WebDriver driver){
	   driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
	  	 int items=driver.findElements(By.xpath(NoOfItemRows)).size(); 
	  	 String ItemName=null;
	  	if(items > 1){
	  		 for(int i=1;i<=5;i++){
	  			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
	  			ItemName=driver.findElement(By.xpath(ItemsName_field_firstxpath+"["+i+"]"+ItemsName_field_secondxpath)).getText();
	  		//System.out.println(ItemName);
	  			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
	  		 }
	  	 }else{
	  		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
  			ItemName=driver.findElement(By.xpath(ItemsName_field_firstxpath+ItemsName_field_secondxpath)).getText();
  		//	System.out.println(ItemName);
  			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);  
	  	 }
		return ItemName;
   }
   
   
   public static int ActualCount(WebDriver driver){
	   driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
	  	 int items=driver.findElements(By.xpath(NoOfItemRows)).size(); 
	  	 int ActualCount=0;
	  	if(items > 1){
	  		 for(int i=1;i<=5;i++){
	  			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
	  			String count=driver.findElement(By.xpath(ActualAvailableItems_field_firstxpath+"["+i+"]"+ActualAvailableItems_field_secondxpath)).getAttribute("value");
	  			ActualCount=Integer.parseInt(count);
	  	//	System.out.println(ActualCount);
	  			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
	  		 }
	  	 }else{
	  		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
  			String count=driver.findElement(By.xpath(ActualAvailableItems_field_firstxpath+ActualAvailableItems_field_secondxpath)).getAttribute("value");
  			ActualCount=Integer.parseInt(count);
  		//System.out.println(ActualCount);
  			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
	  	 }
		return ActualCount;
   }
   
   public static int DamagedCount(WebDriver driver){
	   driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
	  	 int items=driver.findElements(By.xpath(NoOfItemRows)).size(); 
	  	 int DamagedCount=0;
	  	if(items > 1){
	  		 for(int i=1;i<=5;i++){
	  			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
	  			String count=driver.findElement(By.xpath(DamagedItems_Count_firstxpath+"["+i+"]"+DamagedItems_Count_secondxpath)).getText();
	  			DamagedCount=Integer.parseInt(count);
	  		//System.out.println(DamagedCount);
	  			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
	  		 }
	  	 }else{
	  		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
  			String count=driver.findElement(By.xpath(DamagedItems_Count_firstxpath+DamagedItems_Count_secondxpath)).getText();
  			DamagedCount=Integer.parseInt(count);
  		//	System.out.println(DamagedCount);
  			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	  	 }
		return DamagedCount;
   }
   
   public static String InvenToryManagement_ItemName(WebDriver driver){
	   driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
	  	 int items=driver.findElements(By.xpath(NoOfItemRows)).size(); 
	  	 String ItemName=null;
	  	if(items > 1){
	  		 for(int i=1;i<=5;i++){
	  			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
	  			ItemName=driver.findElement(By.xpath(InventoryManagement_Item_firstxpath+"["+i+"]"+InventoryManagement_Item_secondxpath)).getText();
	  	//	System.out.println(ItemName);
	  			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
	  		 }
	  	 }else{
	  		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
  			ItemName=driver.findElement(By.xpath(InventoryManagement_Item_firstxpath+InventoryManagement_Item_secondxpath)).getText();
  			//System.out.println(ItemName);
  			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);  
	  	 }
		return ItemName;
   }
   
   
   public static int InvenToryManagement_ActualCount(WebDriver driver){
	   driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
	  	 int items=driver.findElements(By.xpath(NoOfItemRows)).size(); 
	  	 int ActualCount=0;
	  	if(items > 1){
	  		 for(int i=1;i<=5;i++){
	  			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
	  			String count=driver.findElement(By.xpath(InventoryManagement_ActualCount_firstxpath+"["+i+"]"+InventoryManagement_ActualCount_secondxpath)).getAttribute("value");
	  			ActualCount=Integer.parseInt(count);
	  		//System.out.println(ActualCount);
	  			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
	  		 }
	  	 }else{
	  		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
  			String count=driver.findElement(By.xpath(InventoryManagement_ActualCount_firstxpath+InventoryManagement_ActualCount_secondxpath)).getAttribute("value");
  			ActualCount=Integer.parseInt(count);
  		//System.out.println(ActualCount);
  			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
	  	 }
		return ActualCount;
   }
   
   public static int InvenToryManagement_DamagedCount(WebDriver driver){
	   driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
	  	 int items=driver.findElements(By.xpath(NoOfItemRows)).size(); 
	  	 int DamagedCount=0;
	  	if(items > 1){
	  		 for(int i=1;i<=5;i++){
	  			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
	  			String count=driver.findElement(By.xpath(InventoryManagement_DamagedCount_firstxpath+"["+i+"]"+InventoryManagement_DamagedCount_secondxpath)).getText();
	  			DamagedCount=Integer.parseInt(count);
	  		//System.out.println(DamagedCount);
	  			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
	  		 }
	  	 }else{
	  		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS); 
  			String count=driver.findElement(By.xpath(InventoryManagement_DamagedCount_firstxpath+InventoryManagement_DamagedCount_secondxpath)).getText();
  			DamagedCount=Integer.parseInt(count);
  		//System.out.println(DamagedCount);
  			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	  	 }
		return DamagedCount;
   }
    
   
  
  
   
}
