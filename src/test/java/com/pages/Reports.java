package com.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commons.utilities;

public class Reports extends utilities {
	
	WebDriver driver=null;
	
	public static String links_xpath=".//*[@id='Main']/div[2]/div[1]/div/a" ;
	public static String Link_firstxpath=".//*[@id='Main']/div[2]/div[1]/div/a[";
	public static String Link_secondxpath="]";
	public static String Reports_LINK_XPATH=".//*[@id='menustrip']/li[4]/a";
	public static String StockOut_Items_Count =".//*[@id='ReportInfo']/table/tbody/tr";
	public static String Report_StockOut_ItemName_firstxpath=".//*[@id='ReportInfo']/table/tbody/tr";
	public static String Report_StockOut_ItemName_secondxpath="/td[1]";
	public static String Report_StockOut_ItemStartStock_firstxpath=".//*[@id='ReportInfo']/table/tbody/tr";
	public static String Report_StockOut_ItemStartStock_secondxpath="/td[2]";
	public static String Select_Sector_Dropdown=".//*[@id='Main']/header/h1/div/div[2]/select";
	public static String Inventory_Items=".//*[@id='ReportInfo']/table/tbody/tr";
	public static String Inventory_ItemName_firstxpath=".//*[@id='ReportInfo']/table/tbody/tr";
	public static String Inventory_ItemName_secondxpath="/td[1]";
	public static String Inventory_Item_OpenCount_firstxpath=".//*[@id='ReportInfo']/table/tbody/tr";
	public static String Inventory_Item_OpenCount_secondxpath="/td[2]";		
	public static String Inventory_Item_CloseCount_firstxpath=".//*[@id='ReportInfo']/table/tbody/tr";
	public static String Inventory_Item_CloseCount_secondxpath="/td[3]";				
	public static String Inventory_Uplift_ItemName_firstxpath=".//*[@id='ReportInfo']/table/tbody/tr";		
	public static String Inventory_Uplift_ItemName_secondxpath="/td[2]";	
	public static String Inventory_Replenished_Quantity_firstxpath=".//*[@id='ReportInfo']/table/tbody/tr";		
	public static String Inventory_Replenished_Quantity_secondxpath="/td[3]";
	public static String PaymentReport_Tables=".//*[@id='ReportInfo']/table";
	public static String PaymentReport_Expected_CashTotal_xpath=".//*[@id='ReportInfo']/table[2]/tfoot/tr/td[3]";
	public static String PaymentReport_Expected_Creditotal_xpath=".//*[@id='ReportInfo']/table[3]/tfoot/tr[1]/td[3]";
	public static String PaymentReport_Expected_total_xpath=".//*[@id='ReportInfo']/table[3]/tfoot/tr[2]/td[3]";
	public static String ChangeDue_xpath=".//*[@id='ReportInfo']/table/tbody/tr";
	public static String ChangeDue_Amount_firstxpath=".//*[@id='ReportInfo']/table/tbody/tr";
	public static String ChangeDue_Amount_secondxpath="/td[3]";
	public static String ChangeDue_PassengerSeat_firstxpath=".//*[@id='ReportInfo']/table/tbody/tr";
	public static String ChangeDue_PassengerSeat_secondxpath="/td[1]";
	public static String ChangeDue_PassengerName_firstxpath=".//*[@id='ReportInfo']/table/tbody/tr";
	public static String ChangeDue_PassengerName_secondxpath="/td[2]";
	public static String Report_CrewCount=".//*[@id='ReportInfo']/table/tbody/tr";
	public static String Report_CrewName_firstxpath=".//*[@id='ReportInfo']/table/tbody/tr";
	public static String Report_CrewName_secondxpath="/td[2]";
	public static String Report_CrewID_firstxpath=".//*[@id='ReportInfo']/table/tbody/tr";
	public static String Report_CrewID_secondxpath="/td[1]";
	public static String Report_CrewTrans_firstxpath=".//*[@id='ReportInfo']/table/tbody/tr";
	public static String Report_CrewTrans_secondxpath="/td[4]";
	public static String Report_CrewTotal_firstxpath=".//*[@id='ReportInfo']/table/tbody/tr";
	public static String Report_CrewTotal_secondxpath="/td[3]";
	public static String Report_SaleCategories=".//*[@id='ReportInfo']/table/tbody/tr";
	public static String Report_SaleCat_firstxpath=".//*[@id='ReportInfo']/table/tbody/tr";
	public static String Report_SaleCat_secondxpath="/td[1]";
	public static String Report_Promotions_Count=".//*[@id='ReportInfo']/table/tbody/tr";
	public static String Report_PromotionName_firstxpath=".//*[@id='ReportInfo']/table/tbody/tr";
	public static String Report_PromotionName_secondxpath="/td[2]";
	
	
	
	public static int PromotionsCount(WebDriver driver){
   	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
   	 int Promotions=driver.findElements(By.xpath(Report_Promotions_Count)).size();
   	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
      System.out.println(Promotions);
		return Promotions;
    }
	public static String PromotionName(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int PromotionsCount = Reports.PromotionsCount(driver);
		String PromotionName=null;
		if(PromotionsCount > 1){
			for(int i=1;i<=PromotionsCount;i++){
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				PromotionName = driver.findElement(By.xpath(Report_PromotionName_firstxpath+"["+i+"]"+Report_PromotionName_secondxpath)).getText();
				System.out.println(PromotionName);
			}
		}else{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			PromotionName = driver.findElement(By.xpath(Report_PromotionName_firstxpath+Report_PromotionName_secondxpath)).getText();
			System.out.println(PromotionName);
		}
		return PromotionName;	
	}
	
	
	public static String Report_SaleCategory(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int Categories = driver.findElements(By.xpath(Report_SaleCategories)).size();
		String Report_SaleCategory=null;
		if(Categories > 1){
			for(int i=1;i<=Categories;i++){
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Report_SaleCategory = driver.findElement(By.xpath(Report_SaleCat_firstxpath+"["+i+"]"+Report_SaleCat_secondxpath)).getText();
				System.out.println(Report_SaleCategory);
			}
		}else{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Report_SaleCategory = driver.findElement(By.xpath(Report_SaleCat_firstxpath+Report_SaleCat_secondxpath)).getText();
			System.out.println(Report_SaleCategory);
		}
		return Report_SaleCategory;	
	}
	public static String CrewName(WebDriver driver,int crew){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int Crew = driver.findElements(By.xpath(Report_CrewCount)).size();
		String CrewName=null;
		if(Crew > 1){
			
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				CrewName = driver.findElement(By.xpath(Report_CrewName_firstxpath+"["+crew+"]"+Report_CrewName_secondxpath)).getText();
				System.out.println(CrewName);
			
		}else{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			CrewName = driver.findElement(By.xpath(Report_CrewName_firstxpath+Report_CrewName_secondxpath)).getText();
			System.out.println(CrewName);
		}
		return CrewName;
		
	}
	
	public static String CrewID(WebDriver driver,int crew){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int Crew = driver.findElements(By.xpath(Report_CrewCount)).size();
		String CrewID=null;
		if(Crew > 1){
			
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				CrewID = driver.findElement(By.xpath(Report_CrewID_firstxpath+"["+crew+"]"+Report_CrewID_secondxpath)).getText();
				System.out.println(CrewID);
			
		}else{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			CrewID = driver.findElement(By.xpath(Report_CrewID_firstxpath+Report_CrewID_secondxpath)).getText();
			System.out.println(CrewID);
		}
		return CrewID;
		
	}
	public static int CrewTransactions(WebDriver driver,int crew){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int Crew = driver.findElements(By.xpath(Report_CrewCount)).size();
		int CrewTransactions=0;
		if(Crew > 1){
			
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				String Transactions = driver.findElement(By.xpath(Report_CrewTrans_firstxpath+"["+crew+"]"+Report_CrewTrans_secondxpath)).getText();
				CrewTransactions =Integer.parseInt(Transactions);
				System.out.println(CrewTransactions);
		
		}else{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String Transactions = driver.findElement(By.xpath(Report_CrewTrans_firstxpath+Report_CrewTrans_secondxpath)).getText();
			CrewTransactions =Integer.parseInt(Transactions);
			System.out.println(CrewTransactions);
		}
		return CrewTransactions;
		
	}
	
	public static float CrewTotal(WebDriver driver,String CurrencySymbol,int crew){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int Crew = driver.findElements(By.xpath(Report_CrewCount)).size();
		float CrewTotal=0;
		if(Crew > 1){
			
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				String Total = driver.findElement(By.xpath(Report_CrewTotal_firstxpath+"["+crew+"]"+Report_CrewTotal_secondxpath)).getText();
				CrewTotal =Float.valueOf(Total.trim()).floatValue();
				System.out.println(CrewTotal);
			
		}else{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String Total = driver.findElement(By.xpath(Report_CrewTotal_firstxpath+Report_CrewTotal_secondxpath)).getText();
			
			CrewTotal =Float.valueOf(Total.trim()).floatValue();
			System.out.println(CrewTotal);
		}
		return CrewTotal;
		
	}
	
	public static void Verify_links(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int links = driver.findElements(By.xpath(links_xpath)).size();
		String[] ExpectedLinks={"Change Due","Inventory / C209","Item Stock Out Summary","Payment","Rental","Sales By Category","Sales Per Crew","Uplift","Wastage"};
		String link=null;
		for(int i=1;i<=links;i++){
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			for(int j=0;j<ExpectedLinks.length;j++ ){
			link = driver.findElement(By.xpath(Link_firstxpath+i+Link_secondxpath)).getText();
			if(link.equalsIgnoreCase(ExpectedLinks[j])){
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				System.out.println(link + " ");
			 }else{
				System.out.println(link + " "+"Not displayed"); 
			 }
			
			}
			System.out.println("displayed on the reports screen");
		}
		
	}
	
	 public static void Navigate_to_Reportspage(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
    	 WebDriverWait ww = new WebDriverWait(driver,30);
    	 ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Reports_LINK_XPATH)));
    	 driver.findElement(By.xpath(Reports_LINK_XPATH)).click();
    	 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);	
     }
   
	 public static void Navigate_To_Report(WebDriver driver,String Report){
		 driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			int links = driver.findElements(By.xpath(links_xpath)).size();
			String link=null;
			for(int i=1;i<=links;i++){
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				link = driver.findElement(By.xpath(Link_firstxpath+i+Link_secondxpath)).getText();
				if(link.equalsIgnoreCase(Report)){
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			    	 JavascriptExecutor js= (JavascriptExecutor) driver;
			   	  js.executeScript("arguments[0].click();", driver.findElement(By.xpath(Link_firstxpath+i+Link_secondxpath)));
					driver.findElement(By.xpath(Link_firstxpath+i+Link_secondxpath)).click();
				 }
	    }
	 
	 }
	 public static int ItemsCount(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 int Items=driver.findElements(By.xpath(Inventory_Items)).size();
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	// System.out.println(Items);
		return Items;
     }
	 public static String Invetory_ItemName(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 int Items=Reports.ItemsCount(driver);
    	 String Invetory_ItemName=null;
    	 if(Items > 1){
    		 for(int i=1;i<=Items ;i++){
    			 Invetory_ItemName = driver.findElement(By.xpath(Inventory_ItemName_firstxpath+"["+i+"]"+Inventory_ItemName_secondxpath)).getText();
    			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    			// System.out.println(Invetory_ItemName);
    		 }
    	 }else{
    		 Invetory_ItemName = driver.findElement(By.xpath(Inventory_ItemName_firstxpath+Inventory_ItemName_secondxpath)).getText();
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			// System.out.println(Invetory_ItemName);
    	 }
		return Invetory_ItemName;
     }
     
    public static int InventoryItem_OpenCount(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 int Items=Reports.ItemsCount(driver);
    	 int InventoryItem_OpenCount=0;
    	 if(Items > 1){
    		 for(int i=1;i<=Items ;i++){
    			String OpenCount= driver.findElement(By.xpath(Inventory_Item_OpenCount_firstxpath+"["+i+"]"+Inventory_Item_OpenCount_secondxpath)).getText();
    			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					InventoryItem_OpenCount = Integer.parseInt(OpenCount);
    			// System.out.println(InventoryItem_OpenCount);
    		 }
    	 }else{
    		 String OpenCount = driver.findElement(By.xpath(Inventory_Item_OpenCount_firstxpath+Inventory_Item_OpenCount_secondxpath)).getText();
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 InventoryItem_OpenCount = Integer.parseInt(OpenCount);
			// System.out.println(InventoryItem_OpenCount);
    	 }
		return InventoryItem_OpenCount;
    }
    public static int InventoryItem_CloseCount(WebDriver driver){
     	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
     	 int Items=Reports.ItemsCount(driver);
     	 int InventoryItem_CloseCount=0;
     	 if(Items > 1){
     		 for(int i=1;i<=Items ;i++){
     			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
     			String CloseCount= driver.findElement(By.xpath(Inventory_Item_CloseCount_firstxpath+"["+i+"]"+Inventory_Item_CloseCount_secondxpath)).getText();
     			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
     			InventoryItem_CloseCount = Integer.parseInt(CloseCount);
     			// System.out.println(InventoryItem_CloseCount);
     		 }
     	 }else{
     		 String CloseCount = driver.findElement(By.xpath(Inventory_Item_CloseCount_firstxpath+Inventory_Item_CloseCount_secondxpath)).getText();
  			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  			InventoryItem_CloseCount = Integer.parseInt(CloseCount);
  			// System.out.println(InventoryItem_CloseCount);
     	 }
  		return InventoryItem_CloseCount;
     }
      
	 public static String StockOutItem_Name(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		int StockOut_items=driver.findElements(By.xpath(StockOut_Items_Count)).size() ;
		String StockOutItem_Name =null;
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		if(StockOut_items > 1){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			StockOutItem_Name = driver.findElement(By.xpath(Report_StockOut_ItemName_firstxpath+"["+StockOut_items+"]"+Report_StockOut_ItemName_secondxpath)).getText();
			System.out.println(StockOutItem_Name);
		}else{
			StockOutItem_Name = driver.findElement(By.xpath(Report_StockOut_ItemName_firstxpath+Report_StockOut_ItemName_secondxpath)).getText();
		}
		return StockOutItem_Name;
	 }
    public static int Start_Stock(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	int StockOut_items=driver.findElements(By.xpath(StockOut_Items_Count)).size() ;
		int Start_Stock =0;
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		if(StockOut_items > 1){
		 String	StockCount = driver.findElement(By.xpath(Report_StockOut_ItemStartStock_firstxpath+"["+StockOut_items+"]"+Report_StockOut_ItemStartStock_secondxpath)).getText();
		 Start_Stock = Integer.parseInt(StockCount);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			System.out.println(Start_Stock);
		}else{
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String	StockCount = driver.findElement(By.xpath(Report_StockOut_ItemStartStock_firstxpath+Report_StockOut_ItemStartStock_secondxpath)).getText();
			 Start_Stock = Integer.parseInt(StockCount);
				System.out.println(Start_Stock);
		}
		return Start_Stock; 
	}
    
     public static float ChangeDue_Amount(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 int trans = driver.findElements(By.xpath(ChangeDue_xpath)).size();
    	 float ChangeDue_Amount=0;
    	 if(trans > 1){
    		 for(int i=1;i<=trans;i++){
    			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    			String Amount = driver.findElement(By.xpath(ChangeDue_Amount_firstxpath+"["+i+"]"+ChangeDue_Amount_secondxpath)).getText(); 
    			String[] String1=Amount.split(" ");
    			 ChangeDue_Amount=Float.valueOf(String1[0].trim()).floatValue();
    			 System.out.println(ChangeDue_Amount);
    		 }
    	 }else{
    		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
 			String Amount = driver.findElement(By.xpath(ChangeDue_Amount_firstxpath+ChangeDue_Amount_secondxpath)).getText(); 
 			String[] String1=Amount.split(" ");
 			 ChangeDue_Amount=Float.valueOf(String1[0].trim()).floatValue();
 			System.out.println(ChangeDue_Amount);
    	 }
		return ChangeDue_Amount;
    }
    
    public static String ChangeDue_Currency(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 int trans = driver.findElements(By.xpath(ChangeDue_xpath)).size();
    	 String ChangeDue_Currency=null;
    	 if(trans > 1){
    		 for(int i=1;i<=trans;i++){
    			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    			String Currency = driver.findElement(By.xpath(ChangeDue_Amount_firstxpath+"["+i+"]"+ChangeDue_Amount_secondxpath)).getText(); 
    			String[] String1=Currency.split(" ");
    			ChangeDue_Currency=String1[1].trim();
    			System.out.println(ChangeDue_Currency);
    		 }
    	 }else{
    		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
 			String Currency = driver.findElement(By.xpath(ChangeDue_Amount_firstxpath+ChangeDue_Amount_secondxpath)).getText(); 
 			String[] String1=Currency.split(" ");
 			ChangeDue_Currency=String1[1].trim();
 			System.out.println(ChangeDue_Currency);
    	 }
		return ChangeDue_Currency;
    }
    
     public static String ChangeDuePassenger_Name(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 int trans = driver.findElements(By.xpath(ChangeDue_xpath)).size();
    	 String ChangeDuePassenger_Name=null;
    	 if(trans > 1){
    		 for(int i=1;i<=trans;i++){
    			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    			 ChangeDuePassenger_Name= driver.findElement(By.xpath(ChangeDue_PassengerName_firstxpath+"["+i+"]"+ChangeDue_PassengerName_secondxpath)).getText(); 
    			 System.out.println(ChangeDuePassenger_Name);
    		 }
    	 }else{
    		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
 			 ChangeDuePassenger_Name = driver.findElement(By.xpath(ChangeDue_PassengerName_firstxpath+ChangeDue_PassengerName_secondxpath)).getText(); 
 			 System.out.println(ChangeDuePassenger_Name);
    	 }
		return ChangeDuePassenger_Name;
    }
   public static String ChangeDuePassenger_SeatNum(WebDriver driver){
	   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  	 int trans = driver.findElements(By.xpath(ChangeDue_xpath)).size();
  	 String ChangeDuePassenger_SeatNum=null;
  	 if(trans > 1){
  		 for(int i=1;i<=trans;i++){
  			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  			String SeatNum= driver.findElement(By.xpath(ChangeDue_PassengerSeat_firstxpath+"["+i+"]"+ChangeDue_PassengerSeat_secondxpath)).getText(); 
  			String[] String1=SeatNum.split(" ");
  			ChangeDuePassenger_SeatNum = String1[0]+String1[1];
  			System.out.println(ChangeDuePassenger_SeatNum);
  		 }
  	 }else{
  		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  		String SeatNum= driver.findElement(By.xpath(ChangeDue_PassengerSeat_firstxpath+ChangeDue_PassengerSeat_secondxpath)).getText(); 
			String[] String1=SeatNum.split(" ");
			ChangeDuePassenger_SeatNum = String1[0]+String1[1];
  	 }
		return ChangeDuePassenger_SeatNum;
   }
    public static String Inventory_Uplift_ItemName(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 int Items=Reports.ItemsCount(driver);
    	 String Inventory_Uplift_ItemName=null;
    	 if(Items > 1){
    		 for(int i=1;i<=Items ;i++){
    			 Inventory_Uplift_ItemName = driver.findElement(By.xpath(Inventory_Uplift_ItemName_firstxpath+"["+i+"]"+Inventory_Uplift_ItemName_secondxpath)).getText();
    			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    			// System.out.println(Invetory_ItemName);
    		 }
    	 }else{
    		 Inventory_Uplift_ItemName = driver.findElement(By.xpath(Inventory_Uplift_ItemName_firstxpath+Inventory_Uplift_ItemName_secondxpath)).getText();
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			// System.out.println(Inventory_Uplift_ItemName);
    	 }
		return Inventory_Uplift_ItemName;
    }
    
     public static int Inventory_Replenished_Quantity(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 int Items=Reports.ItemsCount(driver);
    	 int InventoryItem_OpenCount=0;
    	 if(Items > 1){
    		 for(int i=1;i<=Items ;i++){
    			String OpenCount= driver.findElement(By.xpath(Inventory_Replenished_Quantity_firstxpath+"["+i+"]"+Inventory_Replenished_Quantity_secondxpath)).getText();
    			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					InventoryItem_OpenCount = Integer.parseInt(OpenCount);
    			// System.out.println(InventoryItem_OpenCount);
    		 }
    	 }else{
    		 String OpenCount = driver.findElement(By.xpath(Inventory_Replenished_Quantity_firstxpath+Inventory_Replenished_Quantity_secondxpath)).getText();
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 InventoryItem_OpenCount = Integer.parseInt(OpenCount);
			// System.out.println(InventoryItem_OpenCount);
    	 }
		return InventoryItem_OpenCount;
     }
     
    public static float CashPayment_total(WebDriver driver){
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	String total=driver.findElement(By.xpath(PaymentReport_Expected_CashTotal_xpath)).getText();
    	float CashPayment_total = Float.valueOf(total.trim()).floatValue();
    	System.out.println(CashPayment_total);
		return CashPayment_total;
    	
    }
    
    public static float CreditPayment_total(WebDriver driver){
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	String total=driver.findElement(By.xpath(PaymentReport_Expected_Creditotal_xpath)).getText();
    	float CreditPayment_total = Float.valueOf(total.trim()).floatValue();
    	System.out.println(CreditPayment_total);
		return CreditPayment_total;
    	
    }
    public static float Payment_total(WebDriver driver){
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	String total=driver.findElement(By.xpath(PaymentReport_Expected_total_xpath)).getText();
    	float Payment_total = Float.valueOf(total.trim()).floatValue();
    	System.out.println(Payment_total);
		return Payment_total;
    }
    
    public static void Verify_Report_CashTotal(WebDriver driver) throws IOException{
    	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
    	float expectedtotal=SalesAndOrders.Cash_Total(driver);
        Reports.Navigate_to_Reportspage(driver);
        Reports.Navigate_To_Report(driver, "Payment");
        float Actualtotal=Reports.CashPayment_total(driver);
        if(Actualtotal == expectedtotal){
        	System.out.println("Report cash total is as expected");
        }else{
        	Assert.fail("Cash total not matching");
        }
        
    }
    public static void Verify_Report_Credit_Total(WebDriver driver) throws IOException{
    	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
    	float expectedtotal=SalesAndOrders.Credit_Total(driver);
        Reports.Navigate_to_Reportspage(driver);
        Reports.Navigate_To_Report(driver, "Payment");
        float Actualtotal=Reports.CreditPayment_total(driver);
        if(Actualtotal == expectedtotal){
        	System.out.println("Report Credit total is as expected");
        }else{
        	Assert.fail("Credit total not matching");
        }
        
    }
    
    public static void Verify_Report_Sale_Total(WebDriver driver) throws IOException{
    	driver.navigate().to("http://egate-solutions.azurewebsites.net/sales.html");
    	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
    	float expectedtotal=SalesAndOrders.TotalSale_Amount_after_Refunds(driver);
        Reports.Navigate_to_Reportspage(driver);
        Reports.Navigate_To_Report(driver, "Payment");
        float Actualtotal=Reports.Payment_total(driver);
        if(Actualtotal == expectedtotal){
        	System.out.println("Report Credit total is as expected");
        }else{
        	Assert.fail("Credit total not matching");
        }
        
    }
    
    public static void Verify_Report_ChangeDues(WebDriver driver,String seatrow,String seat,String CurrencySymbol) throws IOException{
    	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
    	String ExpectedPass_Name=DuesAndCollectibles.ChangeDue_PassengerName(driver, seatrow, seat);
    	String ExpectedPass_Seat = DuesAndCollectibles.ChangeDue_PassengerSeat(driver, seatrow, seat);
    	float  Expected_Amount=DuesAndCollectibles.ChangeDueAmount(driver, CurrencySymbol);
    	String Expected_Currency=DuesAndCollectibles.ChangeDue_Currency(driver);
    	 Reports.Navigate_to_Reportspage(driver);
         Reports.Navigate_To_Report(driver, "Change Due");
         String ActualPass_Name=Reports.ChangeDuePassenger_Name(driver);
     	String ActualPass_Seat = Reports.ChangeDuePassenger_SeatNum(driver);
     	float  Actual_Amount=Reports.ChangeDue_Amount(driver);
     	String Actual_Currency=Reports.ChangeDue_Currency(driver);
         if(ActualPass_Name.equalsIgnoreCase(ExpectedPass_Name)){
        	 System.out.println("PassengerName as expected");
        	 if(ActualPass_Seat.equalsIgnoreCase(ExpectedPass_Seat)){
        		 System.out.println("PassengerSeat as expected"); 
        		 if(Actual_Amount == Expected_Amount){
        			 System.out.println("Amount is as expected");
        			 if(Actual_Currency.equalsIgnoreCase(Expected_Currency)){
        				 System.out.println("CurrencyType is as expected");
        			 }else{
        				Assert.fail("CurrencyType is different");
        			 }
        		 }else{
        			 Assert.fail("Amount is different");
        		 }
        	 }else{
        		 Assert.fail("PassengerSeat is different"); 
        	 }
         }else{
        	 Assert.fail("PassengerName is different"); 
         }
    }
    public static void Verify_Report_SalesPerCrew(WebDriver driver,String CurrencySymbol){
    	EPOS_DashBoard.Navigate_To_DashBoard(driver);
    	String ExpectedCrewName1 = EPOS_DashBoard.Crew_Name(driver,1);
    	String ExpectedCrewId1= EPOS_DashBoard.CrewID(driver,1);
    	float ExpectedCrewTotal1=EPOS_DashBoard.CrewTotal(driver, CurrencySymbol,1);
    	int ExpectedCrewTrans1 =EPOS_DashBoard.CrewTransactions(driver,1);
    	String ExpectedCrewName2 = EPOS_DashBoard.Crew_Name(driver,2);
    	String ExpectedCrewId2= EPOS_DashBoard.CrewID(driver,2);
    	float ExpectedCrewTotal2=EPOS_DashBoard.CrewTotal(driver, CurrencySymbol,2);
    	int ExpectedCrewTrans2 =EPOS_DashBoard.CrewTransactions(driver,2);
    	Reports.Navigate_to_Reportspage(driver);
    	Reports.Navigate_To_Report(driver, "Sales Per Crew");
    	String ActualCrewName1 = Reports.CrewName(driver,1);
    	String ActualCrewId1= Reports.CrewID(driver,1);
    	float ActualCrewTotal1=Reports.CrewTotal(driver, CurrencySymbol,1);
    	int ActualCrewTrans1 =Reports.CrewTransactions(driver,1);
    	String ActualCrewName2 = Reports.CrewName(driver,2);
    	String ActualCrewId2= Reports.CrewID(driver,2);
    	float ActualCrewTotal2=Reports.CrewTotal(driver, CurrencySymbol,2);
    	int ActualCrewTrans2 =Reports.CrewTransactions(driver,2);
    	 if(ActualCrewName1.equalsIgnoreCase(ExpectedCrewName1) && ActualCrewName2.equalsIgnoreCase(ExpectedCrewName2)){
        	 System.out.println("CrewName as expected");
        	 if(ActualCrewId1.equalsIgnoreCase(ExpectedCrewId1) && ActualCrewId2.equalsIgnoreCase(ExpectedCrewId2)){
        		 System.out.println("CrewId as expected"); 
        		 if(ActualCrewTotal1 == ExpectedCrewTotal1 && ActualCrewTotal2 == ExpectedCrewTotal2){
        			 System.out.println("Total is as expected");
        			 if(ActualCrewTrans1==ExpectedCrewTrans1 && ActualCrewTrans2==ExpectedCrewTrans2){
        				 System.out.println("Transactions count as expected");
        			 }else{
        				Assert.fail("Transactions count is different");
        			 }
        		 }else{
        			 Assert.fail("Total is different");
        		 }
        	 }else{
        		 Assert.fail("CrewId is different"); 
        	 }
         }else{
        	 Assert.fail("CrewName is different"); 
         }
      }
    public static void Verify_Report_SalesPerCat(WebDriver driver) throws IOException{
    	String ExpectedCat1 = getValue("ItemCat1");
    	String ExpectedCat2 = getValue("ItemCat2");
    	String ExpectedCat3 = getValue("RentalItemCat");
    	Reports.Navigate_to_Reportspage(driver);
    	Reports.Navigate_To_Report(driver, "Sales By Category");
    	String ActualCat = Reports.Report_SaleCategory(driver);
    	
    	 if(ActualCat.contains(ExpectedCat1) || ActualCat.contains(ExpectedCat2)||ActualCat.contains(ExpectedCat3) ){
        	 System.out.println("Sales per Category is as expected");
        	 
         }else{
        	 Assert.fail("Sales per Category is different"); 
         }
      }
    }

