package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class InventoryUplift {
	
	public static String InventoryUplift_link_xpath = ".//*[@id='Main']/div/div[2]/a";
	public static String MenuItems_xpath=".//*[@id='myWizard']/div[2]/div[1]/section/div/table/tbody/tr";
	public static String MenuItemName_firstxpath=".//*[@id='myWizard']/div[2]/div[1]/section/div/table/tbody/tr";
	public static String MenuItemName_secondxpath="/td[1]";
	public static String MenuItemInitial_Quantity_firstxpath=".//*[@id='myWizard']/div[2]/div[1]/section/div/table/tbody/tr";
	public static String MenuItemInitial_Quantity_secondxpath="/td[2]/span";
	public static String MenuItemAdditional_Quantity_firstxpath=".//*[@id='myWizard']/div[2]/div[1]/section/div/table/tbody/tr";
	public static String MenuItemAdditional_Quantity_secondxpath="//td[3]/input[2]";
	public static String Items_Quantity_Add_Keypad_firstxpath = "//div[@class='mbsc-np-row']/div[text()='";
	public static String Items_Quantity_Add_Keypad_secondxpath = "']";
	public static String Set_btn_xpath = "//div[text()='Set']";
	public static String Continue_btn_xpath =".//*[@id='myWizard']/div/div[1]/div/button[text()='Continue']";
	public static String Signature_Canvas_xpath = ".//*[@id='Signature']/canvas";
	public static String Signature_Clear_btn_xpath="//button[@onclick='pageInventoryUplift.clear_Signature()']";
	public static String Agreed_chkbx_xpath=".//*[@id='agreed']";
	public static String CloseUplift_btn_xpath="//button[@data-bind='disable: !allowSave(), click: nextStep']";
	public static String Agreed_Chkbx_xpath=".//*[@id='agreed']";
	

	public static void switchControlToLatestWindow(WebDriver driver) {
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	
	 }
	
	public static void Inventory_Uplift(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(InventoryUplift_link_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	public static int MenuItems(WebDriver driver) throws InterruptedException{
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 WebDriverWait ww= new WebDriverWait(driver,30);
		ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MenuItems_xpath)));
	//	Thread.sleep(500);
		 int Items=driver.findElements(By.xpath(MenuItems_xpath)).size();
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	
		return Items;
	}
	
	
	public static int Item_InitialQuantity(WebDriver driver) throws InterruptedException{
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 int Items=InventoryUplift.MenuItems(driver);
		 int Item_InitialQuantity=0;
		 if(Items > 1){
			 for(int i=1;i<=5;i++){
				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
				 String Quantity=driver.findElement(By.xpath(MenuItemInitial_Quantity_firstxpath+"["+i+"]"+MenuItemInitial_Quantity_secondxpath)).getText();
				 Item_InitialQuantity = Integer.parseInt(Quantity); 
				 System.out.println(Item_InitialQuantity);
			 }
		 }else{
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			 String Quantity=driver.findElement(By.xpath(MenuItemInitial_Quantity_firstxpath+MenuItemInitial_Quantity_secondxpath)).getText();
			 Item_InitialQuantity = Integer.parseInt(Quantity); 
			 System.out.println(Item_InitialQuantity); 
		 }
		return Item_InitialQuantity;
	}
	
	public static int Item_UpliftQuantity(WebDriver driver) throws InterruptedException{
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 int Items=InventoryUplift.MenuItems(driver);
		 int Item_UpliftQuantity=0;
		 if(Items > 1){
			 for(int i=1;i<=5;i++){
				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
				 String Quantity=driver.findElement(By.xpath(MenuItemAdditional_Quantity_firstxpath+"["+i+"]"+MenuItemAdditional_Quantity_secondxpath)).getAttribute("value");
				 Item_UpliftQuantity = Integer.parseInt(Quantity); 
				 System.out.println(Item_UpliftQuantity);
			 }
		 }else{
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			 String Quantity=driver.findElement(By.xpath(MenuItemAdditional_Quantity_firstxpath+MenuItemAdditional_Quantity_secondxpath)).getAttribute("value");
			 Item_UpliftQuantity = Integer.parseInt(Quantity); 
			 System.out.println(Item_UpliftQuantity); 
		 }
		return Item_UpliftQuantity;
	}
	
	public static void Add_Item_UpliftQuantity(WebDriver driver) throws InterruptedException{
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 int Items=InventoryUplift.MenuItems(driver);
		 if(Items > 1){
			 for(int i=1;i<=5;i++){
				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
				 WebDriverWait ww= new WebDriverWait(driver,80);
					ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MenuItemAdditional_Quantity_firstxpath+"["+i+"]"+MenuItemAdditional_Quantity_secondxpath)));
				 driver.findElement(By.xpath(MenuItemAdditional_Quantity_firstxpath+"["+i+"]"+MenuItemAdditional_Quantity_secondxpath)).click();
				 InventoryUplift.switchControlToLatestWindow(driver);
				 driver.findElement(By.xpath(Items_Quantity_Add_Keypad_firstxpath+ 0 +Items_Quantity_Add_Keypad_secondxpath)).click();
				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
				 driver.findElement(By.xpath(Items_Quantity_Add_Keypad_firstxpath+ 0 +Items_Quantity_Add_Keypad_secondxpath)).click();
				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
				 driver.findElement(By.xpath(Items_Quantity_Add_Keypad_firstxpath+ 5 +Items_Quantity_Add_Keypad_secondxpath)).click();
				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
				 driver.findElement(By.xpath(Set_btn_xpath)).click();
				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			 }	 
		 }else{
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			 driver.findElement(By.xpath(MenuItemAdditional_Quantity_firstxpath+MenuItemAdditional_Quantity_secondxpath)).click();
			 InventoryUplift.switchControlToLatestWindow(driver);
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			 driver.findElement(By.xpath(Items_Quantity_Add_Keypad_firstxpath+ 0 +Items_Quantity_Add_Keypad_secondxpath)).click();
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			 driver.findElement(By.xpath(Items_Quantity_Add_Keypad_firstxpath+0+Items_Quantity_Add_Keypad_secondxpath)).click();
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			 driver.findElement(By.xpath(Items_Quantity_Add_Keypad_firstxpath+ 5 +Items_Quantity_Add_Keypad_secondxpath)).click();
			
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			 driver.findElement(By.xpath(Set_btn_xpath)).click();
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 }
	}
	
	 public static String Uplifted_ItemName(WebDriver driver) throws InterruptedException{
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 int Items=InventoryUplift.MenuItems(driver);
		 String Uplifted_ItemName=null;
		 if(Items > 1){
			 for(int i=1;i<=5;i++){
				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
				 Uplifted_ItemName=	driver.findElement(By.xpath(MenuItemName_firstxpath+"["+i+"]"+MenuItemName_secondxpath)).getText();
				 System.out.println(Uplifted_ItemName);
			 }	 
		 }else{
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			 Uplifted_ItemName=	driver.findElement(By.xpath(MenuItemName_firstxpath+MenuItemName_secondxpath)).getText();
			 System.out.println(Uplifted_ItemName);
		 }
		return Uplifted_ItemName;	 
	}
	
	   public static void Continue(WebDriver driver){
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  WebElement continuebutton= driver.findElement(By.xpath(Continue_btn_xpath));
			 JavascriptExecutor js = (JavascriptExecutor)driver;
			 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			 js.executeScript("arguments[0].click();", continuebutton);
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	     }
	 
	    public static void Sign(WebDriver driver){
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath(Signature_Canvas_xpath)).click();
			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		}
	    public static void InformationReview(WebDriver driver){
	    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    	driver.findElement(By.xpath(Agreed_Chkbx_xpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
	    public static void Close_Uplift(WebDriver driver){
	    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    	driver.findElement(By.xpath(CloseUplift_btn_xpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	   	}
	    public static void Clear_Signature(WebDriver driver){
	    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    	driver.findElement(By.xpath(CloseUplift_btn_xpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	   	}
	    public static void Verify_InventoryUplift(WebDriver driver) throws InterruptedException{
	    	int InitialCount = InventoryUplift.Item_InitialQuantity(driver);
	    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    	String ExpectedItemName=InventoryUplift.Uplifted_ItemName(driver);
	    	int ExpectedUpliftCount = InventoryUplift.Item_UpliftQuantity(driver);
	    	InventoryUplift.Continue(driver);
	    	InventoryUplift.Sign(driver);
			InventoryUplift.InformationReview(driver);
			InventoryUplift.Close_Uplift(driver);
			InventoryUplift.Inventory_Uplift(driver);
			int expectedtotalItems =  InitialCount + ExpectedUpliftCount ;
	    	int actualtotalItems=InventoryUplift.Item_InitialQuantity(driver);
	    	if(actualtotalItems ==expectedtotalItems){
	    		System.out.println("Items count updated with upliftedItems");
	    	}else{
	    		Assert.fail("Items count not updated with upliftedItems");
	    	}
	    	Reports.Navigate_to_Reportspage(driver);
	    	Reports.Navigate_To_Report(driver, "Replenish");
	    	String ActualItemName=Reports.Inventory_Uplift_ItemName(driver);
	    	int ActualUpliftCount=Reports.Inventory_Replenished_Quantity(driver);
	    	if(ActualItemName.equalsIgnoreCase(ExpectedItemName)){
	    		System.out.println("UpliftedItems are as expected");
	    		if(ActualUpliftCount ==ExpectedUpliftCount){
	    			System.out.println("Uplifted count of item is as expected");
	    		}else{
	    			Assert.fail("upliftedIte count is not matching");
	    		}
	    	}else{
	    		Assert.fail("UpliftedItemnot displayed on the report");
	    	}
	    }
	    
	    
}
