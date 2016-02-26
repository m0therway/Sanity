package com.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commons.actions;
import com.commons.utilities;



public class NewOrder extends utilities{
	WebDriver driver=null;
	public static String NewOrder_btn_xpath ="//button[@data-bind='click: newOrder']";
	// public static String item_firstxpath = ".//*[@id='myWizard']/div[3]/div[1]/div/div[1]/div[5]/section/div[";
	//public static String item_firstxpath = ".//*[@id='myWizard']/div[3]/div[1]/div/div[3]/div[5]/div/section/div[";
	public static String item_firstxpath = ".//*[@id='myWizard']/div[2]/div[1]/div/div[3]/div[5]/div/section/div[";
	public static String item_secondxpath = "]/div[1]";
	// public static String CheckOut_btn_xapth="/html/body/header/div/div[2]/h2/button";
	 public static String CheckOut_btn_xapth="html/body/header/div/small/div/h2/button";
	 //public static String TotalAmount_xpath = "/html/body/header/div/div[2]/h2/a";
	 public static String TotalAmount_xpath = "html/body/header/div/small/div/h2/a";
	// public static String CheckOut_btn_itemcount_xpath = "/html/body/header/div/div[2]/h2/button/span[2]";
	 public static String CheckOut_btn_itemcount_xpath = "html/body/header/div/small/div/h2/button/span[2]";
	//public static String itemName_firstxpath = ".//*[@id='myWizard']/div[3]/div[1]/div/div[1]/div[5]/section/div[";
	//public static String itemName_firstxpath = ".//*[@id='myWizard']/div[3]/div[1]/div/div[3]/div[5]/div/section/div[";
	public static String itemName_firstxpath = ".//*[@id='myWizard']/div[2]/div[1]/div/div[3]/div[5]/div/section/div[";
	 public static String itemName_secondxpath = "]/div[2]/div[1]/div[1]/h4";
	// public static String itemprice_firstxpath = ".//*[@id='myWizard']/div[3]/div[1]/div/div[1]/div[5]/section/div[";
	 public static String itemprice_firstxpath = ".//*[@id='myWizard']/div[2]/div[1]/div/div[3]/div[5]/div/section/div[";
	 public static String itemprice_secondxpath = "]/div[2]/div[1]/div[2]/span";
	 public static String ShoppingCart_Promotion_label_xpath = ".//*[@id='pnlShoppingCart']/div[2]/section[2]/h4/label";
	 public static String ShoppingCart_Promotion_amount_xpath = ".//*[@id='pnlShoppingCart']/div[2]/section[2]/h4/span";
	 public static String BalanceDue_xpath = ".//*[@id='pnlShoppingCart']/div[3]/h4/span";
	 public static String item_Categoryname_firstxpath = ".//*[@id='myWizard']/div[2]/div[1]/div/div[3]/div[1]/div/a[text()='";
	 public static String item_Categoryname_secondxpath = "']";
	 public static String ExitCart_link_xpath = "//a[@id='btnExit']";
	 public static String ItemsCount_ByItem_firstxpath="/html/body/div[3]/div[2]/div/div[2]/div[1]/div/div[1]/div[5]/section/div[";
	 public static String ItemsCount_ByItem_secondxpath="]/div[1]/span";
	public static String Items_Count_xpath = "html/body/small/div[1]/div/div/div[2]/div[1]/div/div[3]/div[5]/div/section/div";
	 public static String AllItems_link_xpath="//a[@data-bind='click: items_ShowAll']";
	
	 public static String AllItems_count_xpath=".//*[@id='myWizard']/div[2]/div[1]/div/div[3]/div[5]/div/section/div";
	
	 public static String AllItems_firstxpath=".//*[@id='myWizard']/div[2]/div[1]/div/div[3]/div[5]/div/section/div[";
	 public static String AllItems_secondxpath="]/div[2]/div[1]/div[1]";
	 public static String ShoppingCart_ItemName_first_xpath=".//*[@id='myWizard']/div[3]/div[1]/div/div[1]/div[5]/section/div[";
	 public static String ShoppingCart_ItemName_second_xpath="]/div[2]/div[1]/div[1]/h4";
	
	 
	 
	 
	//Items in specific category
	 public static void placeNewOrder(WebDriver driver, String Category,int item,char CurrencySymbol) throws IOException{
			driver.findElement(By.xpath(item_Categoryname_firstxpath+Category+item_Categoryname_secondxpath)).click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			String itemcost = driver.findElement(By.xpath(itemprice_firstxpath+item+itemprice_secondxpath)).getText(); 
			String[] price = itemcost.split("\\"+CurrencySymbol);
			float Itemprice = Float.valueOf(price[1].trim()).floatValue();
			int tries = 0;
			 if(Itemprice < 1 ){
			   while ( tries < 5){
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				 driver.findElement(By.xpath(item_firstxpath+ item +item_secondxpath)).click();
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				 tries++;
			}
			 }else{
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				 driver.findElement(By.xpath(item_firstxpath+ item +item_secondxpath)).click();
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 }
			
	   }
	 
	 public static void SingleItemInAnyCat_Order(WebDriver driver, String Category,int item) throws IOException{
			driver.findElement(By.xpath(item_Categoryname_firstxpath+Category+item_Categoryname_secondxpath)).click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				 driver.findElement(By.xpath(item_firstxpath+ item +item_secondxpath)).click();
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	   }
	 public static void placeNewOrder_with_ItemName(WebDriver driver,String RentalItemName){
		 int Itemscount = driver.findElements(By.xpath(AllItems_count_xpath)).size();
		 for(int i=1;i<=Itemscount;i++){
			 String name = driver.findElement(By.xpath(ShoppingCart_ItemName_first_xpath+i+ShoppingCart_ItemName_second_xpath)).getText();
			 if(name.equalsIgnoreCase(RentalItemName)){
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				 driver.findElement(By.xpath(item_firstxpath+ i +item_secondxpath)).click();
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			 }
		 }
	 }
	//Items in all categories
	 public static void placeNewOrder(WebDriver driver, int item,char CurrencySymbol) throws IOException{
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			String itemcost = driver.findElement(By.xpath(itemprice_firstxpath+item+itemprice_secondxpath)).getText(); 
			String[] price = itemcost.split("\\"+CurrencySymbol);
			float Itemprice = Float.valueOf(price[1].trim()).floatValue();
			int tries = 0;
			 if(Itemprice < 5 ){
			   while ( tries < 10){
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				 driver.findElement(By.xpath(item_firstxpath+ item +item_secondxpath)).click();
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				 tries++;
			}
			 }else{
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				 driver.findElement(By.xpath(item_firstxpath+ item +item_secondxpath)).click();
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 }
			
	   }
	 public static void Multiple_Item_SelectionSameCat(WebDriver driver, String Category){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(item_Categoryname_firstxpath+Category+item_Categoryname_secondxpath)).click();
		 int items=driver.findElements(By.xpath(Items_Count_xpath)).size();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			for(int i=1;i<=items;i++){
				driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
				 driver.findElement(By.xpath(item_firstxpath+ i+item_secondxpath)).click();
				 driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
			}
	 }
	 //multiple items from different categories
	 public static void Multiple_Item_Select(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		 JavascriptExecutor js= (JavascriptExecutor) driver;
		 js.executeScript("return document.readyState").equals("complete"); 
		 int items=driver.findElements(By.xpath(AllItems_count_xpath)).size();
		// System.out.println(items);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			for(int i=1;i<=5;i++){
				WebDriverWait  ww = new WebDriverWait(driver,25);
				ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AllItems_firstxpath+ i+AllItems_secondxpath)));
				 driver.findElement(By.xpath(AllItems_firstxpath+ i+AllItems_secondxpath)).click();
				 driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
			}
	 }
	 
	 
	 public static int Initial_CheckOutItemsCount(WebDriver driver) throws InterruptedException, IOException{
		    JavascriptExecutor js= (JavascriptExecutor) driver;
		    js.executeScript("return document.readyState").equals("complete");
		    Thread.sleep(2000);
			String count = driver.findElement(By.xpath(CheckOut_btn_itemcount_xpath)).getText(); 
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 if (count.length()==0) {
				 System.out.println(new Integer(0));
				 return new Integer(0);
			    } else {
			    	System.out.println(Integer.parseInt(count));
			    	return Integer.parseInt(count);
			    }
	 }
	
	 
	 public static int CheckOutItemsCount(WebDriver driver) throws InterruptedException, IOException{
		 /*   JavascriptExecutor js= (JavascriptExecutor) driver;
		    js.executeScript("return document.readyState").equals("complete");*/
		    Thread.sleep(2000);
			String count = driver.findElement(By.xpath(CheckOut_btn_itemcount_xpath)).getText();
			System.out.println(count);
			 if (count.length()==0) {
				 System.out.println(new Integer(0));
				 return new Integer(0);
			    } else {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String[] checkoutcount = count.split("\\(");
			String[] countOFItems = checkoutcount[1].split("\\)");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			int itemcount = Integer.parseInt(countOFItems[0]);
			System.out.println("CheckOutItemsCount:"+itemcount);
		 		return itemcount;
			    }
	 }
	
	 
	
	 public static String NewOrderItemname(WebDriver driver, int item){
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
			String itemname = driver.findElement(By.xpath(itemName_firstxpath+item+itemName_secondxpath)).getText(); 
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 System.out.println(itemname);
		 		return itemname;
	 }
	 
	public static float ItemPrice(WebDriver driver, int item,char CurrencySymbol) throws IOException{
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		String itemcost = driver.findElement(By.xpath(itemprice_firstxpath+item+itemprice_secondxpath)).getText(); 
		String[] price = itemcost.split("\\"+CurrencySymbol);
		float Itemprice = Float.valueOf(price[1].trim()).floatValue();
		return Itemprice;
	}
	
	public static float ShoppingCart_TotalAmount(WebDriver driver,char CurrencySymbol){
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		String amount=driver.findElement(By.xpath(TotalAmount_xpath)).getText();
		//System.out.println(amount);
		String[] String1 = amount.split("\\"+CurrencySymbol);
		String[] String2=String1[1].split(" ");
		float total = Float.valueOf(String2[0].trim()).floatValue();
		//System.out.println(total);
		return total;
	}
	
	 public static void placeNewOrderBy_ItemPrice(WebDriver driver,String Category, String itemprice,char CurrencySymbol) throws IOException{
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			 driver.findElement(By.xpath(item_Categoryname_firstxpath+Category+item_Categoryname_secondxpath)).click();
			float price=Float.valueOf(itemprice.trim()).floatValue();
			//System.out.println(price);
			int items=driver.findElements(By.xpath(AllItems_count_xpath)).size();
			//System.out.println("items"+items);
				for(int i=1;i<=items;i++){
			String cost = driver.findElement(By.xpath(itemprice_firstxpath+i+itemprice_secondxpath)).getText(); 
			String[] price1 = cost.split("\\"+CurrencySymbol);
			float ItemCost = Float.valueOf(price1[1].trim()).floatValue();
		//	System.out.println(ItemCost);
			float	 total =0;
			if(ItemCost == price || ItemCost > price){
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				driver.findElement(By.xpath(item_firstxpath+i+item_secondxpath)).click();
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				break;
			} else {
						driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						 driver.findElement(By.xpath(item_firstxpath+ i +item_secondxpath)).click();
						 total = NewOrder.ShoppingCart_TotalAmount(driver, CurrencySymbol);
						 if(total >= price){
						 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
						 break;
					} 
			    }
			    	
			    }
			
			
			
	   }
	
	public static void CheckOut(WebDriver driver) throws InterruptedException{
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 JavascriptExecutor js= (JavascriptExecutor) driver;
		    js.executeScript("return document.readyState").equals("complete");
	driver.findElement(By.xpath(CheckOut_btn_xapth)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
   public static void Order(WebDriver driver) throws InterruptedException{
	   WebDriverWait ww=new WebDriverWait(driver,30);
	   ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NewOrder_btn_xpath)));
	 driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
	 driver.findElement(By.xpath(NewOrder_btn_xpath)).click();
	 driver.manage().timeouts().implicitlyWait(700, TimeUnit.SECONDS);
	 Thread.sleep(500);
	}
	
	public static void ExitCart(WebDriver driver){
		 JavascriptExecutor js= (JavascriptExecutor) driver;
		 js.executeScript("return document.readyState").equals("complete");  
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(ExitCart_link_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(700, TimeUnit.SECONDS);
	}
	
	
	 public static void Select_Category(WebDriver driver,String cat){
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(item_Categoryname_firstxpath+cat+item_Categoryname_secondxpath)).click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				
	 }
	
}
