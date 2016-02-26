package com.pages;

import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commons.utilities;

public class DuesAndCollectibles extends utilities {
	//public static String DuesandColletibles_tab_xpath="/html/body/div[2]/div/div/ul/li[3]";
	//public static String DuesandColletibles_tab_xpath=".//*[@id='Main']/div[2]/div/ul/li[3]/a";
	public static String DuesandColletibles_tab_xpath=".//*[@id='Main']/div[2]/div/ul/li[4]/a";
	public static String DuesandColletibles_Trans_xpath=".//*[@id='DuesCollectibles']/tbody/tr";
	public static String DandC_PassengerSeat_firstxpath=".//*[@id='DuesCollectibles']/tbody/tr";
	public static String DandC_PassengerSeat_secondxpath="/td[2]";
	public static String DandC_PassengerName_firstxpath=".//*[@id='DuesCollectibles']/tbody/tr";
	public static String DandC_PassengerName_secondxpath="/td[3]";
	public static String DandC_Description_firstxpath=".//*[@id='DuesCollectibles']/tbody/tr";
	public static String DandC_Description_secondxpath="/td[4]";
	public static String DuesandColletibles_Count_xpath="/html/body/div[2]/div/div/ul/li[3]/a/span";
	public static String Transaction_Description_xpath="";
	public static String ChangeDue_Amount_firstxpath=".//*[@id='DuesCollectibles']/tbody/tr";
	public static String ChangeDue_Amount_secondxpath="/td[5]/span[1]";
	public static String Collectibles_count ="";
	public static String Completed_ChkBx_firstxpath=".//*[@id='DuesCollectibles']/tbody/tr";
	public static String Completed_ChkBx_secondxpath="/td[6]/input";
    public static String DuesAndCollectibleTrans_xpath=".//*[@id='DuesCollectibles']/tbody";
    public static String ChangeDue_Currency_button_xpath=".//*[@id='DuesCollectibles']/tbody/tr/td[5]/panel/button";
    public static String ChangeDue_Currencies_list_firstxpath=".//*[@id='DuesCollectibles']/tbody/tr";
    public static String ChangeDue_Currencies_list_secondxpath="/td[5]/panel/ul/li";
    public static String ChangeDue_Currencies_firstxpath=".//*[@id='DuesCollectibles']/tbody/tr";
    public static String ChangeDue_Currencies_secondxpath="/td[5]/panel/ul/li[";
    public static String ChangeDue_Currencies_thirdxpath="]/a";
    public static String ChangeDue_Trans_Currency_firstxpath=".//*[@id='DuesCollectibles']/tbody/tr";
    public static String ChangeDue_Trans_Currency_secondxpath="/td[5]/panel/button/span";
    public static String Orders_Link_xpath=".//*[@id='menustrip']/li[2]/a";
    public static String DuesandColletibles_xpath=".//*[@id='DuesCollectibles']/tbody/tr";
    
    public static void Dues_Collectibles(WebDriver driver){
    	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		   WebDriverWait wt=new WebDriverWait(driver,100);
		   wt.until(ExpectedConditions.presenceOfElementLocated(By.xpath(DuesandColletibles_tab_xpath)));
		   driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		   driver.findElement(By.xpath(DuesandColletibles_tab_xpath)).click();
		   driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				 }
    
   
	/*public static void Verify_ChangeDue_PassengerDetails(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        String PassengerDetails =  Payments.PassengerDetails(driver);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        String[] String=PassengerDetails.split(" ");
        String PassengerName=String[1]+" "+String[2];
        String PassengerSeat=String[4]+String[5];
        DuesAndCollectibles.Dues_Collectibles(driver);
        int DuesAndCollectibles= driver.findElements(By.xpath(DuesandColletibles_Trans_xpath)).size();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        for(int i=1;i<=DuesAndCollectibles;i++){
        String Description =  driver.findElement(By.xpath(DandC_Description_firstxpath+i+DandC_Description_secondxpath)).getText();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 if(Description.equals("Change Due")){
        String ChangeDue_PassengerName=driver.findElement(By.xpath(DandC_PassengerName_xpath)).getText();
        String ChangeDue_PassengerSeat=driver.findElement(By.xpath(DandC_PassengerSeat_xpath)).getText();	
        if(PassengerName.equalsIgnoreCase(ChangeDue_PassengerName)||PassengerSeat.equalsIgnoreCase(ChangeDue_PassengerSeat)){
        	System.out.println("Changedue transaction PassengerDetails are as expected");
        }else{
        	Assert.fail("Changedue transaction PassengerDetails are not matching");
        }
		 
		 } 
        }
	 }*/
	 public static String Collectibles_PassengerName(WebDriver driver) throws IOException{
		   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 String RentalItem=getValue("Collectible"); 
		        DuesAndCollectibles.Dues_Collectibles(driver);
		        int DuesAndCollectibles= driver.findElements(By.xpath(DuesandColletibles_Trans_xpath)).size();
		        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		        String PassengerName = null;
		        if(DuesAndCollectibles > 1){
		        	for(int i=1;i<=DuesAndCollectibles;i++){
				        String Description =  driver.findElement(By.xpath(DandC_Description_firstxpath+"["+i+"]"+DandC_Description_secondxpath)).getText();
		       
				 if(Description.equals(RentalItem)){
		          PassengerName=driver.findElement(By.xpath(DandC_PassengerName_firstxpath+"["+i+"]"+DandC_PassengerName_secondxpath)).getText();
				 }
		        }
		        }else{
		        	String Description =  driver.findElement(By.xpath(DandC_Description_firstxpath+DandC_Description_secondxpath)).getText();
		        	if(Description.equals(RentalItem)){
		        		PassengerName=driver.findElement(By.xpath(DandC_PassengerName_firstxpath+DandC_PassengerName_secondxpath)).getText();	
		           }	
		        }
				return PassengerName; 
		 } 
	 
	 public static String Collectibles_PassengerSeat(WebDriver driver) throws IOException{
		   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 String RentalItem=getValue("Collectible"); 
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		        DuesAndCollectibles.Dues_Collectibles(driver);
		        int DuesAndCollectibles= driver.findElements(By.xpath(DuesandColletibles_Trans_xpath)).size();
		        String PassengerSeat = null;
		        if(DuesAndCollectibles > 1){
		        for(int i=1;i<=DuesAndCollectibles;i++){
		        String Description =  driver.findElement(By.xpath(DandC_Description_firstxpath+"["+i+"]"+DandC_Description_secondxpath)).getText();
				 if(Description.equals(RentalItem)){
		        PassengerSeat=driver.findElement(By.xpath(DandC_PassengerSeat_firstxpath+"["+i+"]"+DandC_PassengerSeat_secondxpath)).getText();	
				 }
			 }
		        }else{
		        	String Description =  driver.findElement(By.xpath(DandC_Description_firstxpath+DandC_Description_secondxpath)).getText();
		        	if(Description.equals(RentalItem)){
				        PassengerSeat=driver.findElement(By.xpath(DandC_PassengerSeat_firstxpath+DandC_PassengerSeat_secondxpath)).getText();	
		           }
		        }
				return PassengerSeat; 
		 } 
	
	 public static String ChangeDue_PassengerName(WebDriver driver,String seatrow,String seat) throws IOException{
		   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		        DuesAndCollectibles.Dues_Collectibles(driver);
		        int DuesAndCollectibles= driver.findElements(By.xpath(DuesandColletibles_Trans_xpath)).size();
		        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		        String PassengerName=null;
		        String Passengerseat = null;
		        if(DuesAndCollectibles > 1){
		        	for(int i=1;i<=DuesAndCollectibles;i++){
				        String Description =  driver.findElement(By.xpath(DandC_Description_firstxpath+"["+i+"]"+DandC_Description_secondxpath)).getText();
				        Passengerseat=  driver.findElement(By.xpath(DandC_PassengerSeat_firstxpath+"["+i+"]"+DandC_PassengerSeat_secondxpath)).getText();	
				 if(Description.equals("Change Due")){
					 PassengerName=driver.findElement(By.xpath(DandC_PassengerName_firstxpath+"["+i+"]"+DandC_PassengerName_secondxpath)).getText();  
					 System.out.println(PassengerName);
				 }
				
		        }
		        	
		        }else{
		        	String Description =  driver.findElement(By.xpath(DandC_Description_firstxpath+DandC_Description_secondxpath)).getText();
		        	 Passengerseat=  driver.findElement(By.xpath(DandC_PassengerSeat_firstxpath+DandC_PassengerSeat_secondxpath)).getText();	
		        	 if(Description.equals("Change Due")){
						 PassengerName=driver.findElement(By.xpath(DandC_PassengerName_firstxpath+DandC_PassengerName_secondxpath)).getText(); 
						 System.out.println(PassengerName);
					 }
		        	 
		        }
				return PassengerName; 
		 } 
	 
	 public static String ChangeDue_PassengerSeat(WebDriver driver,String seatrow,String seat) throws IOException{
		   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		        DuesAndCollectibles.Dues_Collectibles(driver);
		        int DuesAndCollectibles= driver.findElements(By.xpath(DuesandColletibles_Trans_xpath)).size();
		        String PassengerSeat = null;
		        if(DuesAndCollectibles > 1){
		        for(int i=1;i<=DuesAndCollectibles;i++){
		        String Description =  driver.findElement(By.xpath(DandC_Description_firstxpath+"["+i+"]"+DandC_Description_secondxpath)).getText();
				 if(Description.equals("Change Due")){
		        PassengerSeat=driver.findElement(By.xpath(DandC_PassengerSeat_firstxpath+"["+i+"]"+DandC_PassengerSeat_secondxpath)).getText();	
		        System.out.println(PassengerSeat);
				  }
		     			 }
		       
		        }else{
		        	String Description =  driver.findElement(By.xpath(DandC_Description_firstxpath+DandC_Description_secondxpath)).getText();
		        	 if(Description.equals("Change Due")){
		 		        PassengerSeat=driver.findElement(By.xpath(DandC_PassengerSeat_firstxpath+DandC_PassengerSeat_secondxpath)).getText();	
		 		        System.out.println(PassengerSeat);
		 				 }
		        }
				return PassengerSeat; 
		 } 
	
   public static int DuesAndCollectiblesTransCount(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 String count =driver.findElement(By.xpath(DuesandColletibles_Trans_xpath)).getText();
	    	int DuesAndCollectiblesTransCount = Integer.parseInt(count);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			return DuesAndCollectiblesTransCount;
		 }

   public static String DuesAndCollectiblesTrans(WebDriver driver){
	   String DuesAndCollectiblesTrans=driver.findElement(By.xpath(DuesAndCollectibleTrans_xpath)).getText();
	   System.out.println(DuesAndCollectiblesTrans);
	return DuesAndCollectiblesTrans;
	   
   }
   
   public static void Verify_DuesAndCollectiblesTrans(WebDriver driver){
	   String DuesAndCollectiblesTrans=driver.findElement(By.xpath(DuesAndCollectibleTrans_xpath)).getText();
	   if(DuesAndCollectiblesTrans!=null){
		   System.out.println(DuesAndCollectiblesTrans + ""+ "DuesAndCollectibles Transactions displayed on the screen");
	   }else{
		   Assert.fail("DuesAndCollectibles Transactions not displayed on the screen");
	   }
	  
   }
	 public static int DuesAndCollectiblesCount(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 String count =driver.findElement(By.xpath(DuesandColletibles_Count_xpath)).getText();
	    	int DuesAndCollectiblesCount = Integer.parseInt(count);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			return DuesAndCollectiblesCount;
		 }
	 public static float ChangeDueAmount(WebDriver driver,String CurrencySymbol) throws IOException{
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		 float  DueAmount = 0;
		 int DuesAndCollectibles= driver.findElements(By.xpath(DuesandColletibles_Trans_xpath)).size();
		 if(DuesAndCollectibles > 1){
	        for(int i=1;i<=DuesAndCollectibles;i++){
	        	 String Description =  driver.findElement(By.xpath(DandC_Description_firstxpath+"["+i+"]"+DandC_Description_secondxpath)).getText();
		 if(Description.equals("Change Due")){
			 String amount =driver.findElement(By.xpath(ChangeDue_Amount_firstxpath+"["+i+"]"+ChangeDue_Amount_secondxpath)).getText();  
			 String[] string1=amount.split("\\"+CurrencySymbol);
			// String[] string2 = string1[1].split(getValue("Currency"));
			 DueAmount = Float.valueOf(string1[1].trim()).floatValue();
			 
			 System.out.println(DueAmount);
		 }
	        }
	       
		 }else{
			 String Description =  driver.findElement(By.xpath(DandC_Description_firstxpath+DandC_Description_secondxpath)).getText();
			 if(Description.equals("Change Due")){
			 String amount =driver.findElement(By.xpath(ChangeDue_Amount_firstxpath+ChangeDue_Amount_secondxpath)).getText();  
			 String[] string1=amount.split("\\"+CurrencySymbol);
			// String[] string2 = string1[1].split(getValue("Currency"));
			 DueAmount = Float.valueOf(string1[1].trim()).floatValue();
			 System.out.println(DueAmount);
			 }
		 }
	 		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			return DueAmount;
		 }
	
	 
		 public static int ChangeDuesCount(WebDriver driver){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 int DuesAndCollectibles= driver.findElements(By.xpath(DuesandColletibles_Trans_xpath)).size();
			 int ChangeDuesTrans=0;
			 if(DuesAndCollectibles > 1){
				 for(int i=1;i<=DuesAndCollectibles;i++){
					String Description =  driver.findElement(By.xpath(DandC_Description_firstxpath+"["+i+"]"+DandC_Description_secondxpath)).getText();
					if(Description.equals("Change Due")){
				   ChangeDuesTrans= driver.findElements(By.xpath(DandC_Description_firstxpath+"/td[text()='Change Due']")).size();
					}
				 }
				 System.out.println("ChangeDuesTrans"+ChangeDuesTrans);
			 }else{
				 String Description =  driver.findElement(By.xpath(DandC_Description_firstxpath+DandC_Description_secondxpath)).getText();
					if(Description.equals("Change Due")){
				  ChangeDuesTrans= driver.findElements(By.xpath(DandC_Description_firstxpath+"/td[text()='Change Due']")).size();
				  System.out.println("ChangeDuesTrans"+ChangeDuesTrans);
					}
			 }
				return ChangeDuesTrans;
			 }
		 
		 
		 public static int CollectiblesCount(WebDriver driver) throws IOException{
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 String RentalItem=getValue("Collectible");
			 int DuesAndCollectibles= driver.findElements(By.xpath(DuesandColletibles_Trans_xpath)).size();
			 int collectbleTrans=0;
			 if(DuesAndCollectibles > 1){
				 for(int i=1;i<=DuesAndCollectibles;i++){
					String Description =  driver.findElement(By.xpath(DandC_Description_firstxpath+"["+i+"]"+DandC_Description_secondxpath)).getText();
					if(Description.equals(getValue("Collectible"))){
						collectbleTrans= driver.findElements(By.xpath(DandC_Description_firstxpath+"/td[text()='"+RentalItem+"']")).size();
				   System.out.println("ChangeDuesTrans"+collectbleTrans);
					}
				 }
			 }else{
				 String Description =  driver.findElement(By.xpath(DandC_Description_firstxpath+DandC_Description_secondxpath)).getText();
					if(Description.equals(getValue("Collectible"))){
						collectbleTrans= driver.findElements(By.xpath(DandC_Description_firstxpath+"/td[text()='"+RentalItem+"']")).size();
				   System.out.println("ChangeDuesTrans"+collectbleTrans);
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					}
			 }
				return collectbleTrans;
			 }
		 
		 public static void Verify_CompletedChkBX(WebDriver driver){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 int DuesAndCollectibles= driver.findElements(By.xpath(DuesandColletibles_Trans_xpath)).size();
		        for(int i=1;i<=DuesAndCollectibles;i++){
		        	WebElement checkbox = driver.findElement(By.xpath(Completed_ChkBx_firstxpath+i+Completed_ChkBx_secondxpath));
		        	if(checkbox.isDisplayed()){
		        		System.out.println("All transactions are displaying check box");
		        	}else{
		        		Assert.fail("Checkbox is not displayed next to transaction");
		        	}
		        	
		        }
		
		 } 
		 
		 public static void Verify_ChangeDue_Currency_List(WebDriver driver){
			 DuesAndCollectibles.Dues_Collectibles(driver);
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    	 driver.findElement(By.xpath(ChangeDue_Currency_button_xpath)).click();
	    	 int trans=driver.findElements(By.xpath(DuesandColletibles_Trans_xpath)).size();
			   String[] Currencies = {"GBP","EUR","USD","DKK"};
			   if(trans >1){
				   for(int i=1;i<=trans;i++){
					 int list = driver.findElements(By.xpath(ChangeDue_Currencies_list_firstxpath+"["+i+"]"+ChangeDue_Currencies_list_secondxpath)).size();
				   for(int j=0;j<Currencies.length;j++){
					   for(int k=1;k<=list;k++) {
					   String Currency = driver.findElement(By.xpath(ChangeDue_Currencies_firstxpath+"["+i+"]"+ChangeDue_Currencies_secondxpath+k+ChangeDue_Currencies_thirdxpath)).getText();
				   if(Currency.equals(Currencies[j])){
					   System.out.println(Currency+ ",");
				    }
					   }
				   }
				  
				   }
				  
			   }else{
				   int list = driver.findElements(By.xpath(ChangeDue_Currencies_list_firstxpath+ChangeDue_Currencies_list_secondxpath)).size();
					   for(int j=0;j<Currencies.length;j++){
						   for(int k=1;k<=list;k++) {
						   String Currency = driver.findElement(By.xpath(ChangeDue_Currencies_firstxpath+ChangeDue_Currencies_secondxpath+k+ChangeDue_Currencies_thirdxpath)).getText();
					   if(Currency.equals(Currencies[j])){
						   System.out.println(Currency+ ",");
					    }
						   }
					  
					   }
			   }
		
			   System.out.println("Currencies displayed in the dropdown");
		 }
		 
		 
        public static String ChangeDue_Currency(WebDriver driver){
        	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        	int trans=driver.findElements(By.xpath(DuesandColletibles_Trans_xpath)).size();
        	String ChangeDue_Currency =null;
        	if(trans > 1){
        		for(int i=1;i<=trans;i++){
        		String Description =  driver.findElement(By.xpath(DandC_Description_firstxpath+"["+i+"]"+DandC_Description_secondxpath)).getText();	
        		if(Description.equals("Change Due")){
	           ChangeDue_Currency=driver.findElement(By.xpath(ChangeDue_Trans_Currency_firstxpath+"["+i+"]"+ChangeDue_Trans_Currency_secondxpath)).getText();
	           System.out.println(ChangeDue_Currency);
        		}
        	}
        	}else{
        		String Description =  driver.findElement(By.xpath(DandC_Description_firstxpath+DandC_Description_secondxpath)).getText();	
        		if(Description.equals("Change Due")){
	           ChangeDue_Currency=driver.findElement(By.xpath(ChangeDue_Trans_Currency_firstxpath+ChangeDue_Trans_Currency_secondxpath)).getText();
	           System.out.println(ChangeDue_Currency);
        	   }
        	}
	    	 return ChangeDue_Currency; 
		 }
		 
		 public static void Verify_DuesAndCollectible_ChangeDue_CurrecncyType(WebDriver driver,String seatrow,String seat) throws IOException{
			 String ExpectedCurrency=Payments.ChangeDue_Currency(driver);
			 System.out.println(ExpectedCurrency);
			 Payments.PayNow(driver);
			 String Expected_passengerName = Payments.PassengerName(driver);
			 System.out.println(Expected_passengerName);
			 String Expected_PassengerSeat = Payments.PassengerSeatRow(driver)+Payments.PassengerSeat(driver);
			 System.out.println(Expected_PassengerSeat);
			 Payments.Payment_Done(driver);
			 String ActualCurrency =null;
			 DuesAndCollectibles.Dues_Collectibles(driver);
			 int DuesAndCollectibles= driver.findElements(By.xpath(DuesandColletibles_Trans_xpath)).size();
		        String PassengerSeat = null;
		        if(DuesAndCollectibles > 1){
		        for(int i=1;i<=DuesAndCollectibles;i++){
			 String Description =  driver.findElement(By.xpath(DandC_Description_firstxpath+"["+i+"]"+DandC_Description_secondxpath)).getText();	
			 String Actual_passengerName = driver.findElement(By.xpath(DandC_PassengerName_firstxpath+"["+i+"]"+DandC_PassengerName_secondxpath)).getText();	
			 String Actual_PassengerSeat = driver.findElement(By.xpath(DandC_PassengerSeat_firstxpath+"["+i+"]"+DandC_PassengerSeat_secondxpath)).getText();
			 ActualCurrency = driver.findElement(By.xpath(ChangeDue_Trans_Currency_firstxpath+"["+i+"]"+ChangeDue_Trans_Currency_secondxpath)).getText();
			 if(Expected_passengerName.equals(Actual_passengerName)
					 ||Expected_PassengerSeat.equals(Actual_PassengerSeat)||Description.equals("Change Due")||ExpectedCurrency.equals(ActualCurrency)){
				
			   }else{
				 Assert.fail("DuesAndCollectibles screen ChangeDue CurrencyType is different than Payment screen ChangeDue CurrencyType");  
			   }
			
			 }
		        System.out.println("DuesAndCollectibles screen ChangeDue CurrencyType is same as Payment screen ChangeDue CurrencyType"); 
		        }else{
		        	 String Description =  driver.findElement(By.xpath(DandC_Description_firstxpath+DandC_Description_secondxpath)).getText();	
					 String Actual_passengerName = driver.findElement(By.xpath(DandC_PassengerName_firstxpath+DandC_PassengerName_secondxpath)).getText();	
					 String Actual_PassengerSeat = driver.findElement(By.xpath(DandC_PassengerSeat_firstxpath+DandC_PassengerSeat_secondxpath)).getText();	
					 ActualCurrency = driver.findElement(By.xpath(ChangeDue_Trans_Currency_firstxpath+ChangeDue_Trans_Currency_secondxpath)).getText();
					 if(Expected_passengerName.equals(Actual_passengerName)
							 ||Expected_PassengerSeat.equals(Actual_PassengerSeat)||Description.equals("Change Due")||ExpectedCurrency.equals(ActualCurrency)){
						 System.out.println(ActualCurrency);
						System.out.println("DuesAndCollectibles screen ChangeDue CurrencyType is same as Payment screen ChangeDue CurrencyType");
					   }else{
						 Assert.fail("DuesAndCollectibles screen ChangeDue CurrencyType is different than Payment screen ChangeDue CurrencyType");  
					   }
		      
		     }
		 }
		 
		 public static void Complete_DuesAndCollectibles(WebDriver driver){
			 driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS); 
			 driver.findElement(By.xpath(Orders_Link_xpath)).click();
			 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
			 DuesAndCollectibles.Dues_Collectibles(driver);
			 driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS); 
			 int Trans = driver.findElements(By.xpath(DuesandColletibles_Trans_xpath)).size();
			 if(Trans > 1){
			 for(int i=1;i<=Trans;i++){
				
				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
				 driver.findElement(By.xpath(Completed_ChkBx_firstxpath+"["+i+"]"+Completed_ChkBx_secondxpath)).click();
				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
				
			 }
			 }else if(Trans == 1){
				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
				 driver.findElement(By.xpath(Completed_ChkBx_firstxpath+Completed_ChkBx_secondxpath)).click();
				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
				
			 }else{
				 if(driver.findElement(By.xpath(".//*[@id='tabChangeAndRentalsDueCarts']/blockquote")).isDisplayed()){
					 System.out.println("no dues");
			 }
				
				
			 }
			 } 
		
		 
		 public static void VerifyDuesAndCollectible_Completed(WebDriver driver){
			 driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS); 
			 int Trans = driver.findElements(By.xpath(DuesandColletibles_Trans_xpath)).size();
			 if(Trans > 1){
			 for(int i=1;i<=Trans;i++){
				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			if( driver.findElement(By.xpath(Completed_ChkBx_firstxpath+"["+i+"]"+Completed_ChkBx_secondxpath)).isSelected()){
				System.out.println("DuesAndCollectible are completed");
			}else{
				Assert.fail("DuesAndCollectible are not completed");
			}
			 }	 
			
			 }else if(Trans == 1){
				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
					if( driver.findElement(By.xpath(Completed_ChkBx_firstxpath+Completed_ChkBx_secondxpath)).isSelected()){
						System.out.println("DuesAndCollectible are completed");
					}else{
						Assert.fail("DuesAndCollectible are not completed");
					}
			 }else{
				 System.out.println("No dues to complete");
			 }
		 }
		 
}
