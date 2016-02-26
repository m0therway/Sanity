package com.pages;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commons.actions;
import com.commons.common;
import com.commons.utilities;


public class ShoppingCart extends utilities{
	 WebDriver driver=null;
	 public static String Neworder_btn_xpath = "//button[@data-bind='click: newOrder']";
	 public static String Cabinclasses_dpdn_list_xpath = ".//*[@id='myWizard']/div[2]/div[1]/div/div/div[1]/div/span/div/a";
	 public static String Cabinclasses_dpdn_list_item_firstxpath = ".//*[@id='myWizard']/div[2]/div[1]/div/div/div[1]/div/span/div/a[";
	 public static String Cabinclasses_dpdn_list_item_secondxpath = "]";
	 public static String items_list_xpath = ".//*[@id='myWizard']/div[2]/div[1]/div/div[1]/div[4]/section/div";
	// public static String itemprice_firstxpath = ".//*[@id='myWizard']/div[2]/div[1]/div/div[1]/div[5]/section/div[";
	// public static String itemprice_firstxpath = ".//*[@id='myWizard']/div[3]/div[1]/div/div[1]/div[5]/section/div[";
	// public static String itemprice_firstxpath = ".//*[@id='myWizard']/div[3]/div[1]/div/div[3]/div[5]/div/section/div[";
	 public static String itemprice_firstxpath = "html/body/small/div[1]/div/div/div[2]/div[1]/div/div[3]/div[5]/div/section/div";
     public static String itemprice_secondxpath = "/div[2]/div[1]/div[2]/span";
	 public static String item_Category_xpath = ".//*[@id='myWizard']/div[2]/div[1]/div/div/div[1]/div/a";
	 public static String item_Categoryname_firstxpath = ".//*[@id='myWizard']/div[2]/div[1]/div/div/div[1]/div/a[";
	 public static String item_Categoryname_secondxpath = "]";
	 public static String itemCount_ByCategory_firstxpath =".//*[@id='myWizard']/div[2]/div[1]/div/div/div[1]/div/a[";
     public static String itemCount_ByCategory_secondxpath ="]/span";
	// public static String TotalAmount_xpath = "/html/body/header/div/div[2]/h2/a";
	 public static String TotalAmount_xpath = "html/body/header/div/small/div/h2/a";
	// public static String CheckOut_btn_xapth="/html/body/header/div/div[2]/h2/button";
	 public static String CheckOut_btn_xapth="html/body/header/div/small/div/h2/button";
	// public static String CheckOut_btn_itemcount_xpath = "/html/body/header/div/div[2]/h2/button/span[2]";
	 public static String CheckOut_btn_itemcount_xpath = "html/body/header/div/small/div/h2/button/span[2]";
	 public static String Progressbar_firstxpath =".//*[@id='myWizard']/div[2]/div[1]/div/div[1]/div[4]/section/div[";
	 public static String Progressbar_secondxpath ="]/div[2]/div[2]/div/div/div";
	 public static String links_List_xpath = ".//*[@id='bs-example-navbar-collapse-1']/ul/li";
	 public static String links_text_firstxpath = ".//*[@id='bs-example-navbar-collapse-1']/ul/li[";
	 public static String links_text_secondxpath = "]/a";
	 public static String ExitCart_btn_xpath = ".//*[@id='btnExit']";
	 public static String OrderType_dpdn_list_xpath = "/html/body/div[3]/div[2]/div/div[2]/div[1]/div/nav/div/div[2]/ul/li[1]/div/a";
	 public static String OrderType_dpdn_item_firstxpath = "/html/body/div[3]/div[2]/div/div[2]/div[1]/div/nav/div/div[2]/ul/li[1]/div/a[";
	 public static String OrderType_dpdn_item_secondxpath = "]";
	 public static String Items_tiles_view_xpath = ".//*[@id='myWizard']/div[2]/div[1]/div/div/div[4]/div/div";
	 public static String AllItems_list_xpath="html/body/small/div[1]/div/div/div[2]/div[1]/div/div[2]/nav/div/div[2]/ul/li[3]/a";
	 public static String BalanceDue_xpath = ".//*[@id='pnlShoppingCart']/div[3]/h4/span";
	// public static String PaymentScreen_Total_xpath = "//*[@id='pnlShoppingCart']/div[2]/section[3]/h2";
	 public static String PaymentScreen_TotalAmount_xpath = "//*[@id='pnlShoppingCart']/div[2]/section[4]/h2";
	 public static String PaymentScreen_TotalItemsCount_xpath = ".//*[@id='pnlShoppingCart']/div[1]/span";
	 public static String Item_FullDesc_btn_firstxpath=".//*[@id='myWizard']/div[3]/div[1]/div/div[1]/div[5]/section/div[";
	 public static String Item_FullDesc_btn_secondxpath="]/div[2]/div[3]/div/button[1]";
	// public static String Item_Remove_btn_firstxpath=".//*[@id='myWizard']/div[3]/div[1]/div/div[1]/div[5]/section/div[";
	// public static String Item_Remove_btn_firstxpath=".//*[@id='myWizard']/div[3]/div[1]/div/div[3]/div[5]/div/section/div[";
	 public static String Item_Remove_btn_firstxpath=".//*[@id='myWizard']/div[2]/div[1]/div/div[3]/div[5]/div/section/div[";
	 public static String Item_Remove_btn_secondxpath="]/div[2]/div[3]/div/button[2]";
	// public static String Item_Stockout_btn_firstxpath=".//*[@id='myWizard']/div[3]/div[1]/div/div[1]/div[5]/section/div[";
	// public static String Item_Stockout_btn_firstxpath=".//*[@id='myWizard']/div[3]/div[1]/div/div[3]/div[5]/div/section/div[";
	 public static String Item_Stockout_btn_firstxpath=".//*[@id='myWizard']/div[2]/div[1]/div/div[3]/div[5]/div/section/div[";
	 public static String Item_Stockout_btn_secondxpath="]/div[2]/div[3]/div/button[3]";
	// public static String ShoppingCart_Currency_xpath="/html/body/header/div/div[2]/h2/a/small";
	 public static String ShoppingCart_Currency_xpath="html/body/header/div/small/div/h2/a/small";
	// public static String ItemsCount_ByItem_firstxpath=".//*[@id='myWizard']/div[3]/div[1]/div/div[1]/div[5]/section/div[";
	// public static String ItemsCount_ByItem_firstxpath=".//*[@id='myWizard']/div[3]/div[1]/div/div[3]/div[5]/div/section/div[";
	 public static String ItemsCount_ByItem_firstxpath=".//*[@id='myWizard']/div[2]/div[1]/div/div[3]/div[5]/div/section/div[";
	 public static String ItemsCount_ByItem_secondxpath="]/div[1]/span";
	 
	 public static String Items_Count_xpath = "html/body/small/div[1]/div/div/div[2]/div[1]/div/div[3]/div[5]/div/section/div";
	 
	 public static String Update_cart_count_btn_xpath = "//span [@class='caret']";
	 public static String plus_btn_xpath = ".//*[@id='pnlShoppingCart']/div/div/div[2]/table/tbody/tr/td[2]/i[1]";
	 public static String minus_btn_xpath = ".//*[@id='pnlShoppingCart']/div/div/div[2]/table/tbody/tr/td[2]/i[2]";
	 //Allitemsview Items Number of each items added to the cart
	 public static String ItemCountAddedtotheCar_firstxpath=".//*[@id='myWizard']/div[2]/div[1]/div/div[1]/div[5]/section/div[";
	 public static String ItemCountAddedtotheCar_secondxpath="]/div[1]/span";
	 public static String popup_checkout_btn_xpath = ".//*[@id='pnlShoppingCart']/div/div/div[3]/div/button[2]";
	 public static String popup_Close_btn_xpath = ".//*[@id='pnlShoppingCart']/div/div/div[3]/button[2]";
	 public static String Itemscount_intheCart_xpath =".//*[@id='pnlShoppingCart']/div/div/div[1]/span"	;	
	 public static String ShoppingCart_link_xpath="//a[@data-bind='visible: checkoutButton_Visible(), click: pageShoppingCart.shoppingCart_Show']";
	 public static String ShoppingCart_Item_Remove_btn_xpath="//button[@data-bind='click: $root.shoppingCart_RemoveAll']";
	// public static String ShoppingCart_Close_btn_xpath="//button[@data-bind='click:cancelCart']";
	 public static String ShoppingCart_Close_btn_xpath="//button[@class='btn btn-danger btn-lg pull-left hidden-xs btn-modal']";
	 public static String ShoppingCart_CheckOut_btn_xpath="//button[@data-bind='click: nextStepPayment, visible: shoppingCart.totalItems']";
	// public static String ItemsCount_xpath=".//*[@id='myWizard']/div[3]/div[1]/div/div[1]/div[5]/section/div";
	// public static String Available_ItemsCount_firstxpath=".//*[@id='myWizard']/div[3]/div[1]/div/div[1]/div[5]/section/div[";
	// public static String Available_ItemsCount_firstxpath=".//*[@id='myWizard']/div[3]/div[1]/div/div[3]/div[5]/div/section/div["; 
	 public static String Available_ItemsCount_firstxpath=".//*[@id='myWizard']/div[2]/div[1]/div/div[3]/div[5]/div/section/div["; 
	 public static String Available_ItemsCount_secondxpath="]/div[2]/div[2]/div/div/div";
	// public static String ItemName_firstxpath=".//*[@id='myWizard']/div[3]/div[1]/div/div[1]/div[5]/section/div[";
	// public static String ItemName_firstxpath=".//*[@id='myWizard']/div[3]/div[1]/div/div[3]/div[5]/div/section/div["; 
	 public static String ItemName_firstxpath=".//*[@id='myWizard']/div[2]/div[1]/div/div[3]/div[5]/div/section/div["; 
	 public static String ItemName_secondxpath="]/div[2]/div[1]/div[1]/h4";
	 public static String Item_Inventory_firstxpath=".//*[@id='myWizard']/div[3]/div[1]/div/div[1]/div[5]/section/div[";
	 public static String Item_Inventory_secondxpath="]/div[2]/div[2]/div/div";
	 public static String Selected_ItemsCount_firstxpath="html/body/small/div[1]/div/div/div[2]/div[1]/div/div[3]/div[5]/div/section/div";
	 public static String Selected_ItemsCount_secondxpath="/div[1]/span";
	 public static String Promotion_Alert_xpath=".//*[@id='toaster']/descendant::div[@class='alert alert-success alert-dismissible']";
	 public static String OrderType_dpdn_link_xpath="html/body/small/div[1]/div/div/div[2]/div[1]/div/div[2]/nav/div/div[2]/ul/li[1]/a";
	 public static String OrderTypes_count_xpath="html/body/small/div[1]/div/div/div[2]/div[1]/div/div[2]/nav/div/div[2]/ul/li[1]/div/a";
	 public static String CurrencyChange_link_xpath="//div/h2/a/span[@class='caret']";
	 public static String CurrencyChange_popup_xpath="html/body/div[3]/div";
	 public static String Currency_dpdn_xpath="html/body/div[3]/div/div/div[2]/div/div/div/select";
	 public static String CurrencyChange_popup_close_btn_xpath="html/body/div[3]/div/div/div[3]/button[3]";
	 public static String Defult_Currency_xpath="html/body/header/div/small/div/h2/a/small";
	 public static String Default_CurrencySymbol_xpath="html/body/header/div/small/div/h2/a";
	 public static String itemRetailprice_firstxpath = "html/body/small/div[1]/div/div/div[2]/div[1]/div/div[3]/div[5]/div/section/div";
     public static String itemRetailprice_secondxpath = "/div[2]/div[1]/div[2]/small";
	 
	 public static void switchControlToLatestWindow(WebDriver driver) {
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	
	 }
	 
	 public static char Operational_CurrencySymbol(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		String Currency= driver.findElement(By.xpath(Default_CurrencySymbol_xpath)).getText();
	    char Symbol = Currency.charAt(0);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		System.out.println(Symbol);
		return Symbol;
	 }
	public static void VerifyTotal_With_CalculatedTotal(WebDriver driver) throws IOException{
		
		common.Wait_Until_ElementInVisible(driver, Promotion_Alert_xpath);
			String total = driver.findElement(By.xpath(TotalAmount_xpath)).getText(); 
			//System.out.println(total);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String[] String = total.split(" ");
			String[] amount= String[0].split("\\"+ShoppingCart.Operational_CurrencySymbol(driver));
			float ActualTotal = Float.valueOf(amount[1].trim()).floatValue();
			System.out.println(ActualTotal +"total amount");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			float CalculatedTotal = ShoppingCart.CalculatedTotalAmount(driver, ShoppingCart.Operational_CurrencySymbol(driver));
			if(ActualTotal < CalculatedTotal){
				System.out.println("Promotions applied and Total Amount is accurate");
			      }else{
				Assert.fail("Total Amount is not accurate with promotions");
			   }
			
	 }
	
	
	
	
    
  

    public static int Selected_Items_Count_ByItem(WebDriver driver){
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 int items=driver.findElements(By.xpath(Items_Count_xpath)).size();
		// System.out.println(items);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			int	sum=0;
			int Itemscount =0;
			if(items > 1){
			for(int i=1;i<=5;i++){
						String count= driver.findElement(By.xpath(Selected_ItemsCount_firstxpath+"["+i+"]"+Selected_ItemsCount_secondxpath)).getText();
						//System.out.println(count);
						 Itemscount = Integer.parseInt(count);
				//	System.out.println(Itemscount);
						 sum += Itemscount;
					   }
			}else{
				String count= driver.findElement(By.xpath(Selected_ItemsCount_firstxpath+Selected_ItemsCount_secondxpath)).getText();
				//System.out.println(count);
				 Itemscount = Integer.parseInt(count);
			  //  System.out.println(Itemscount);
				 sum += Itemscount;
			}
			System.out.println("count is"+ " "+ sum);
					
				return sum;
			    	
    }
    
    
    
  
    
    public static String StockOut_ItemName(WebDriver driver,int item){
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	String ItemName = driver.findElement(By.xpath(ItemName_firstxpath+item+ItemName_secondxpath)).getText();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	System.out.println(ItemName);
    	return ItemName;
    }
    public static void Exit_Cart(WebDriver driver){
    	common.Wait_Until_ElementVisible(driver, ExitCart_btn_xpath);
    	common.Wait_Until_ElementClickable(driver, ExitCart_btn_xpath);
    	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    	 JavascriptExecutor js= (JavascriptExecutor) driver;
   	  js.executeScript("arguments[0].click();", driver.findElement(By.xpath(ExitCart_btn_xpath)));
    	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }
  
    
    public static String Stock_Status(WebDriver driver,int item){
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	String Stock_Status = driver.findElement(By.xpath(Available_ItemsCount_firstxpath+item+Available_ItemsCount_secondxpath)).getText();
    	return Stock_Status;
    }
   
  public static float CalculatedTotalAmount(WebDriver driver,char CurrencySymbol){
	  int items = driver.findElements(By.xpath(Items_Count_xpath)).size();
	  float TotalAmount=0;
	  float Itemprice =0;
	  if(items >1){
		  for(int i=1;i<=5;i++){
	  String itemcost = driver.findElement(By.xpath(itemprice_firstxpath+"["+i+"]"+itemprice_secondxpath)).getText(); 
	//  System.out.println(itemcost);
		String[] rate = itemcost.split("\\"+CurrencySymbol);
		 Itemprice = Float.valueOf(rate[1].trim()).floatValue();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		TotalAmount += Itemprice;
		
	  }
	  }else{
		  String itemcost = driver.findElement(By.xpath(itemprice_firstxpath+itemprice_secondxpath)).getText(); 
			//  System.out.println(itemcost);
				String[] rate = itemcost.split("\\"+CurrencySymbol);
				 Itemprice = Float.valueOf(rate[1].trim()).floatValue();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
				TotalAmount += Itemprice;
				  
	  }
	 // System.out.println("price is"+ " "+ TotalAmount);
		
		return TotalAmount;
	  
  }

  public static char  ItemPrice_CurrencyType(WebDriver driver){
	  int items = driver.findElements(By.xpath(Items_Count_xpath)).size();
	
	 char Symbol = 0;
	  if(items >1){
		  for(int i=1;i<=items;i++){
	  String itemcost = driver.findElement(By.xpath(itemprice_firstxpath+"["+i+"]"+itemprice_secondxpath)).getText(); 
	//  System.out.println(itemcost);
	     Symbol = itemcost.charAt(0);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
	  }
	  }else{
		  String itemcost = driver.findElement(By.xpath(itemprice_firstxpath+itemprice_secondxpath)).getText(); 
			
		  Symbol = itemcost.charAt(0);
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
				  
	  }
		return Symbol;  
  }
  
  
  public static void Select_OrderType(WebDriver driver, String ordertype){
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
	  driver.findElement(By.xpath(OrderType_dpdn_link_xpath)).click();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  int ordertypes=driver.findElements(By.xpath(OrderTypes_count_xpath)).size();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  String type=null;
	  if(ordertypes > 1){
		  for(int i=1;i<=ordertypes;i++){
		 type= driver.findElement(By.xpath(OrderTypes_count_xpath+"["+i+"]")).getText();
		 if(type.equalsIgnoreCase(ordertype)){
			 driver.findElement(By.xpath(OrderTypes_count_xpath+"["+i+"]")).click();
		 }
		  }
	  }else{
		  type= driver.findElement(By.xpath(OrderTypes_count_xpath)).getText();
			 if(type.equalsIgnoreCase(ordertype)){
				 driver.findElement(By.xpath(OrderTypes_count_xpath)).click();
			 } 
	  }
	  
  }
  
  
  public static float Crew_Item_Price(WebDriver driver,char CurrencySymbol){
	  int items = driver.findElements(By.xpath(Items_Count_xpath)).size();
	
	  float Itemprice =0;
	  if(items >1){
		  for(int i=1;i<=5;i++){
	  String itemcost = driver.findElement(By.xpath(itemprice_firstxpath+"["+i+"]"+itemprice_secondxpath)).getText();  
	  
	//  System.out.println(itemcost);
		String[] rate = itemcost.split("\\"+CurrencySymbol);
		 Itemprice = Float.valueOf(rate[1].trim()).floatValue();
		 System.out.println(Itemprice);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		  }
	  } else{
			  String itemcost = driver.findElement(By.xpath(itemprice_firstxpath+itemprice_secondxpath)).getText(); 
				//  System.out.println(itemcost);
					String[] rate = itemcost.split("\\"+CurrencySymbol);
					 Itemprice = Float.valueOf(rate[1].trim()).floatValue();
					 System.out.println(Itemprice);
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);   
		  }
	return Itemprice;
  }
  
  public static float Crew_RetailItem_Price(WebDriver driver,char CurrencySymbol){
	  int items = driver.findElements(By.xpath(Items_Count_xpath)).size();
	  float retailprice=0;
	  if(items >1){
		  for(int i=1;i<=5;i++){
	  String price = driver.findElement(By.xpath(itemRetailprice_firstxpath+"["+i+"]"+itemRetailprice_secondxpath)).getText(); 
		 String[] retail = price.split("\\"+CurrencySymbol);
		 retailprice=Float.parseFloat(retail[1]);
		 System.out.println(retailprice);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		  }
	  } else{
		  String price = driver.findElement(By.xpath(itemRetailprice_firstxpath+itemRetailprice_secondxpath)).getText(); 
			 String[] retail = price.split("\\"+CurrencySymbol);
			 retailprice=Float.parseFloat(retail[1]);
			 System.out.println(retailprice);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);  
		  }
	return retailprice;
  }
  
 public static String Operational_Currency(WebDriver driver){
	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
	String Currency= driver.findElement(By.xpath(Defult_Currency_xpath)).getText();
	return Currency;
 }
 

 
  
  public static void AllItems(WebDriver driver){
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
	  driver.findElement(By.xpath(AllItems_list_xpath)).click();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
  }
  
  public static void Change_Currency(WebDriver driver){
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);  
	  driver.findElement(By.xpath(CurrencyChange_link_xpath)).click();
	  common.Wait_Until_ElementVisible(driver, CurrencyChange_popup_xpath);
	  common.switchControlToLatestWindow(driver);
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
	  actions.selectByindex(driver, "xpath", Currency_dpdn_xpath, 1);
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
	  driver.findElement(By.xpath(CurrencyChange_popup_close_btn_xpath)).click();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
  }
  
  public static void Verify_CurrencyAndItemPrice_After_ChangeCurrency(WebDriver driver){
	  char Before_OperationalCurrencysymbol=ShoppingCart.Operational_CurrencySymbol(driver);
	  char Before_ItemPriceCurrencySymbol = ShoppingCart.ItemPrice_CurrencyType(driver);
	  
	  ShoppingCart.Change_Currency(driver);
	  char After_OperationalCurrencysymbol=ShoppingCart.Operational_CurrencySymbol(driver);
	  char After_ItemPriceCurrencySymbol = ShoppingCart.ItemPrice_CurrencyType(driver);
	  
	  
	  if(Before_OperationalCurrencysymbol !=After_OperationalCurrencysymbol && Before_ItemPriceCurrencySymbol !=After_ItemPriceCurrencySymbol){
		  System.out.println("Operational currency changed and also Item prices are updated with changed currency");
	  }else{
		 Assert.fail("Operational currency did NOT change and also Item prices are NOT updated with changed currency");
	  }
	  
  }
  
  public static void Verify_CrewItemPrices(WebDriver driver,char CurrencySymbol ){
	  float Itemprice=ShoppingCart.Crew_Item_Price(driver, CurrencySymbol);
	  float RetailItemprice=ShoppingCart.Crew_RetailItem_Price(driver, CurrencySymbol);
	  
	  if(Itemprice < RetailItemprice){
		  System.out.println("Discounted prices displayed for crew");
	  }else{
		 Assert.fail("Discounted prices not displayed for crew"); 
	  }
	  
  }
  
}
