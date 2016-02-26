package com.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CloseFlight_CashCount {
	
	public static String CashBag_Number_fld_xpath="//input[@data-bind='value: cashbagNumber, enable: cashbagKeyEntry']";
	public static String CashBag_Number_AddBtn_xpath="//button[@data-bind='css: cashbagNumber_ButtonCSS, click: cashbagNumber_Add, visible: cashbagKeyEntry']";
	public static String CashBags_Count=".//*[@id='CashBags']/div";
	public static String CashBags_Currencies_Count_firstxpath=".//*[@id='CashBags']/div";
	public static String CashBags_Currencies_Count_secondxpath="/div[2]/div/div/div";
	public static String Currency_Type_firstxpath=".//*[@id='CashBags']/div";
	public static String Currency_Type_secondxpath="/div[2]/div/div/div";
	public static String Currency_Type_thirdxpath="/div[1]/label";
	//public static String Currency_field_firstxpath="/html/body/div/div/div[2]/div[4]/section/div";
	//public static String Currency_field_secondxpath="/div[2]/div/div/div[";
	//public static String Currency_field_thirdxpath="]/div[2]/div/input[@class='form-control input-lg NumPadCashBag']";
	public static String Currency_field_firstxpath="/html/body/div[2]/div/div[2]/div[5]/section/div";
	public static String Currency_field_secondxpath="/div[2]/div/div/div";
	public static String Currency_field_thirdxpath="/div[2]/div/input[@class='form-control input-lg NumPadCashBag']";
	public static String CashBag_Continue_btn_xpath="//button[@data-bind='click: nextStep']";
	public static String Numpadpopup_firstpath ="//div[@class='mbsc-np-row']/div[text()='";
	
	public static String Numpadpopup_secondpath ="']";
	public static String Numpadpopup_Set_btn_xpath = "//div[text()='Set']";
	public static String Numpadpopup_delete_btn_xpath = "//div[@aria-label='Delete']";
	public static String CashBag_firstxpath=".//*[@id='CashBags']/div";
	public static String CashBag_secondxpath="/div[1]/h3";
	public static String CashCount_popup_xpath="html/body/div[2]/div/div";
	public static String CashCount_PopUp_Yes_btn="/html/body/div[2]/div/div/button[@data-bb-handler='success']";
	public static String CashCount_PopUp_No_btn="//button[@data-bb-handler='danger']";
	public static String Currencies_xpath=".//*[@id='myWizard']/div[2]/div[5]/div[1]/div[2]/label";
	public static String Currency_Total_firstxpath=".//*[@id='myWizard']/div[2]/div[5]/div[1]/div[2]/label";
	public static String Currency_Total_secondxpath="/span";
	
	 public static String CashBag(WebDriver driver){
		  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);  
		  int CashBags_count = CloseFlight_CashCount.CashBags_Count(driver);
		  String cashbag=null;
		  if(CashBags_count > 1){
			  for(int i=1;i<=CashBags_count;i++){
				  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
				  cashbag=driver.findElement(By.xpath(CashBag_firstxpath+"["+i+"]"+CashBag_secondxpath)).getText();
				  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
				 // System.out.println(cashbag);
			  }
		  }else{
			  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
			  cashbag=driver.findElement(By.xpath(CashBag_firstxpath+CashBag_secondxpath)).getText();
			  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
			 // System.out.println(cashbag); 
		  }
		return cashbag;
	 }
	
	
	public static float CashbagCurrencyTotal(WebDriver driver,String CurrencyType) throws IOException{
		   driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    	 int CashBags_count = CloseFlight_CashCount.CashBags_Count(driver);
	    	 int CashBags_Currencies_Count = CloseFlight_CashCount.CashBags_Currencies_Count(driver);
	    	 float CashbagCurrencyTotal=0;
	    	 if(CashBags_count > 1){
	    		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    		 for(int i=1;i<=CashBags_count;i++){
	    			 for(int j=1;j<=CashBags_Currencies_Count;j++){
	    				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    				 String CashBag_Currency_Type=driver.findElement(By.xpath(Currency_Type_firstxpath+"["+i+"]"+Currency_Type_secondxpath+j+Currency_Type_thirdxpath)).getText();
	    				 if(CashBag_Currency_Type.equals(CurrencyType)){
	 	    			String amount=	driver.findElement(By.xpath(Currency_field_firstxpath+"["+i+"]"+Currency_field_secondxpath+j+Currency_field_thirdxpath)).getAttribute("value");
	 	    			float CurrencyTotal= Float.valueOf(amount.trim()).floatValue();
						 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
						 CashbagCurrencyTotal += CurrencyTotal;
	    			  }
	    				
	    			 }
	    		 }
	    		 System.out.println(CashbagCurrencyTotal);
	    	 }else{
	    		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    		 for(int j=1;j<=CashBags_Currencies_Count;j++){
    				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    				 String CashBag_Currency_Type=driver.findElement(By.xpath(Currency_Type_firstxpath+Currency_Type_secondxpath+j+Currency_Type_thirdxpath)).getText();
    				 if(CashBag_Currency_Type.equals(CurrencyType)){
 	    			String amount=	driver.findElement(By.xpath(Currency_field_firstxpath+Currency_field_secondxpath+j+Currency_field_thirdxpath)).getAttribute("value");
 	    			float CurrencyTotal= Float.valueOf(amount.trim()).floatValue();
					 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
					 CashbagCurrencyTotal += CurrencyTotal; 
   			    
   			 
    			 }
    		  }
	    		 System.out.println(CashbagCurrencyTotal);
	    	 }
	    	
	    	
			return CashbagCurrencyTotal;
		   
	   }
	 public static String CurrencyTotal(WebDriver driver,String symbol){
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
		 int currencies=driver.findElements(By.xpath(Currencies_xpath)).size();
		 String CurrencyTotal=null;
		 for(int i=1;i<=currencies;i++){
			 String total=driver.findElement(By.xpath(Currency_Total_firstxpath+"["+i+"]"+Currency_Total_secondxpath)).getText();
		    // System.out.println(total);
			 if(total.contains(symbol)){
				String[] value= total.split("\\"+symbol);
				CurrencyTotal=value[1];
				//System.out.println(CurrencyTotal);
				break;
			 }
		 }
		return CurrencyTotal;
	 }
	
	 
	  public static void CashBag_CurrencyEntry(WebDriver driver,String CurrencyType, String Amount){
		  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		  int CashBags_count = CloseFlight_CashCount.CashBags_Count(driver);
	    	 int CashBags_Currencies_Count = CloseFlight_CashCount.CashBags_Currencies_Count(driver);
	    	 if(CashBags_count > 1){
	    		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    		 for(int i=1;i<=CashBags_count;i++){
	    			 for(int j=1;j<=CashBags_Currencies_Count;j++){
	    				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    				String Currency_Type=driver.findElement(By.xpath(Currency_Type_firstxpath+"["+i+"]"+Currency_Type_secondxpath+j+Currency_Type_thirdxpath)).getText();
	    				if(Currency_Type.equals(CurrencyType)){
	    				driver.findElement(By.xpath(Currency_field_firstxpath+"["+i+"]"+Currency_field_secondxpath+j+Currency_field_thirdxpath)).click();
	    				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    				 CloseFlight_CashCount.switchControlToLatestWindow(driver);
	    				 String value=Amount;
	    				 String[] cash=value.split(",");
	    				 driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	    				 driver.findElement(By.xpath(Numpadpopup_firstpath + cash[0]+ Numpadpopup_secondpath)).click();
	    				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    	     		 driver.findElement(By.xpath(Numpadpopup_firstpath + cash[1] + Numpadpopup_secondpath)).click();
	    	     		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    	     		driver.findElement(By.xpath(Numpadpopup_firstpath + cash[2] + Numpadpopup_secondpath)).click();
	    	     		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    	     		driver.findElement(By.xpath(Numpadpopup_firstpath + cash[3] + Numpadpopup_secondpath)).click();
	    	     		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    	     		driver.findElement(By.xpath(Numpadpopup_Set_btn_xpath)).click();
	    	     		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	    	     		break;
	    				}
	    			 }
	    				
	    		 }
	    	  }else{
	    		  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    		  for(int j=1;j<=CashBags_Currencies_Count;j++){
	    				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    				 String Currency_Type=driver.findElement(By.xpath(Currency_Type_firstxpath+Currency_Type_secondxpath+j+Currency_Type_thirdxpath)).getText();
		    				if(Currency_Type.equals(CurrencyType)){
	    				 driver.findElement(By.xpath(Currency_field_firstxpath+Currency_field_secondxpath+j+Currency_field_thirdxpath)).click();
	    				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    				 CloseFlight_CashCount.switchControlToLatestWindow(driver);
	    				 String value=Amount;
	    				 String[] cash=value.split(",");
	    				 driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	    				 driver.findElement(By.xpath(Numpadpopup_firstpath + cash[0]+ Numpadpopup_secondpath)).click();
	    				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    	     		 driver.findElement(By.xpath(Numpadpopup_firstpath + cash[1] + Numpadpopup_secondpath)).click();
	    	     		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    	     		driver.findElement(By.xpath(Numpadpopup_firstpath + cash[2] + Numpadpopup_secondpath)).click();
	    	     		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    	     		driver.findElement(By.xpath(Numpadpopup_firstpath + cash[3] + Numpadpopup_secondpath)).click();
	    	     		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    	     		driver.findElement(By.xpath(Numpadpopup_Set_btn_xpath)).click();
	    	     		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	    	     		break;
		    				}
	    			 }
	    	    }
	    	
	  }
	 
	 
		 public static int CashBags_Count(WebDriver driver){
			  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			  int count=driver.findElements(By.xpath(CashBags_Count)).size();
			  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			return count;  
		 }
		 
		 public static int CashBags_Currencies_Count(WebDriver driver){
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    	 int CashBags_count = CloseFlight_CashCount.CashBags_Count(driver);
	    	 int  Currencies_Count=0;
	    	 if(CashBags_count > 1){
	    		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    		 for(int i=1;i<=CashBags_count;i++){
	    			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    			 Currencies_Count=driver.findElements(By.xpath(CashBags_Currencies_Count_firstxpath+"["+i+"]"+CashBags_Currencies_Count_secondxpath)).size();
	    			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    			// System.out.println(Currencies_Count);
	    		 }
	    	 }else{
	    		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    			 Currencies_Count=driver.findElements(By.xpath(CashBags_Currencies_Count_firstxpath+CashBags_Currencies_Count_secondxpath)).size();
    			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    			// System.out.println(Currencies_Count);
	    	 }
			return Currencies_Count;
		 }
	     public static String CashBag_Currency_Types(WebDriver driver){
	    	 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    	 int CashBags_count = CloseFlight_CashCount.CashBags_Count(driver);
	    	// System.out.println(CashBags_count);
	    	 int CashBags_Currencies_Count = CloseFlight_CashCount.CashBags_Currencies_Count(driver);
	    	 String CashBag_Currency_Type=null;
	    	 
	    	 if(CashBags_count > 1){
	    		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    		 for(int i=1;i<=CashBags_count;i++){
	    			 for(int j=1;j<=CashBags_Currencies_Count;j++){
	    				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    				 CashBag_Currency_Type=driver.findElement(By.xpath(Currency_Type_firstxpath+"["+i+"]"+Currency_Type_secondxpath+j+Currency_Type_thirdxpath)).getText();
	    				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    			   //  System.out.println(CashBag_Currency_Type);
	    			 }
	    		 }
	    	 }else{
	    		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    		 for(int j=1;j<=CashBags_Currencies_Count;j++){
    				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    				 CashBag_Currency_Type=driver.findElement(By.xpath(Currency_Type_firstxpath+Currency_Type_secondxpath+j+Currency_Type_thirdxpath)).getText();
    				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    			    // System.out.println(CashBag_Currency_Type);
    			 }
	    	 }
			return CashBag_Currency_Type;
	    	 
	     }
	     
	     
		 
	   public static void Cashbag(WebDriver driver,String CashbagNum){
		   driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		   driver.findElement(By.xpath(CashBag_Number_fld_xpath)).sendKeys(CashbagNum);
		   driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
		   driver.findElement(By.xpath(CashBag_Number_AddBtn_xpath)).click();
		   driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS); 
	   }
		public static void Verify_CashbagEntry_Field(WebDriver driver){
			   driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
			   WebElement CashBagEntry_fld= driver.findElement(By.xpath(CashBag_Number_fld_xpath));
			   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			   if(CashBagEntry_fld.isDisplayed()||CashBagEntry_fld.isEnabled()){
				   System.out.println("CashBagEntry_fld is displayed and enabled");
			   }else{
				   Assert.fail("CashBagEntry_fld not displayed");
			   } 
		   }
		
		  public static void Verify_CashbagAdd_button(WebDriver driver){
			   driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
			   WebElement CashBagAdd_button= driver.findElement(By.xpath(CashBag_Number_AddBtn_xpath));
			   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			   if(CashBagAdd_button.isDisplayed()||CashBagAdd_button.isEnabled()){
				   System.out.println("CashBagAdd_button is displayed and enabled");
			   }else{
				   Assert.fail("CashBagAdd_button not displayed");
			   } 
		   }
		  public static void Verify_Continue_btn(WebDriver driver) throws IOException{
				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
				 WebElement continuebutton= driver.findElement(By.xpath(CashBag_Continue_btn_xpath));
				 if(continuebutton.isDisplayed()||continuebutton.isEnabled()){
					System.out.println("continue button is displayed on the screen"); 
				 }else{
					 Assert.fail("continue button not displayed on the screen");
				 }
				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			}
		  
		  public static void switchControlToLatestWindow(WebDriver driver) {
				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	
			 }
		  public static void Continue(WebDriver driver) throws IOException{
			 
			  
				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
				 WebElement continuebutton= driver.findElement(By.xpath(CashBag_Continue_btn_xpath));
				 JavascriptExecutor js = (JavascriptExecutor)driver;
				 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				 js.executeScript("arguments[0].click();", continuebutton);
				  //driver.findElement(By.xpath(CashBag_Continue_btn_xpath)).click();
				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			}
		  
		  public static void Accept_CashCountPopUp(WebDriver driver){
			  if(driver.findElements(By.xpath("html/body/div[2]/div/div/div[3]/button[2]")).size()!=0){
			  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			  JavascriptExecutor js = (JavascriptExecutor)driver;
				 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				js.executeScript("arguments[0].click();", driver.findElement(By.xpath("html/body/div[2]/div/div/div[3]/button[2]")));
				// driver.findElement(By.xpath("//button[@data-bb-handler='success']")).click();
				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			  }else{
				  System.out.println("Closing cashcounts are correct");
			  }
		  }
		  public static void Accept_CashCountDecline(WebDriver driver){
			  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			  JavascriptExecutor js = (JavascriptExecutor)driver;
				 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				 js.executeScript("arguments[0].click();", driver.findElement(By.xpath(CashCount_PopUp_No_btn)));
				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		  }
		  
		  public static void CashBag_CurrencyEntry1(WebDriver driver,String CurrencyType, String Amount){
			  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			  int CashBags_count = CloseFlight_CashCount.CashBags_Count(driver);
		    	 int CashBags_Currencies_Count = CloseFlight_CashCount.CashBags_Currencies_Count(driver);
		    	 if(CashBags_count > 1){
		    		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		    		 for(int i=1;i<=CashBags_count;i++){
		    			 for(int j=1;j<=CashBags_Currencies_Count;j++){
		    				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		    				String Currency_Type=driver.findElement(By.xpath(Currency_Type_firstxpath+"["+i+"]"+Currency_Type_secondxpath+"["+j+"]"+Currency_Type_thirdxpath)).getText();
		    				if(Currency_Type.equals(CurrencyType)){
		    				driver.findElement(By.xpath(Currency_field_firstxpath+"["+i+"]"+Currency_field_secondxpath+"["+j+"]"+Currency_field_thirdxpath)).click();
		    				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		    				 CloseFlight_CashCount.switchControlToLatestWindow(driver);
		    				 String value=Amount;
		    				 String[] v2=value.split("\\.");
		    					String v = v2[0]+v2[1];
		    			//System.out.println(v);
		    					String a = v.replaceAll("", " ").trim();
				    			String[] x= a.split("");
				    		//	System.out.println(x.length);
				    			//System.out.println(x[2]);
				    			 
				    			for(int k=1; k<x.length; k=k+2){
				    			String b=x[k];
				    		//	System.out.println(b);
		    				 driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		    				 driver.findElement(By.xpath(Numpadpopup_firstpath+b+Numpadpopup_secondpath)).click();
		    				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		    			     }
		    	     		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		    	     		driver.findElement(By.xpath(Numpadpopup_Set_btn_xpath)).click();
		    	     		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		    	     		break;
		    				}
		    			 }
		    				
		    		 }
		    	  }else{
		    		  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		    		  for(int j=1;j<=CashBags_Currencies_Count;j++){
		    				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		    				 String Currency_Type=driver.findElement(By.xpath(Currency_Type_firstxpath+Currency_Type_secondxpath+"["+j+"]"+Currency_Type_thirdxpath)).getText();
			    				if(Currency_Type.equals(CurrencyType)){
		    				 driver.findElement(By.xpath(Currency_field_firstxpath+Currency_field_secondxpath+"["+j+"]"+Currency_field_thirdxpath)).click();
		    				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		    				 CloseFlight_CashCount.switchControlToLatestWindow(driver);
		    				 String value=Amount;
		    				 String[] v2=value.split("\\.");
		    					String v = v2[0]+v2[1];
		    			//System.out.println("String v:"+ v);
		    			 
		    		String a = v.replaceAll("", " ").trim();
		    			String[] x= a.split("");
		    			//System.out.println(x.length);
		    			//System.out.println(x[2]);
		    			 
		    			for(int k=1; k<x.length; k=k+2){
		    			String b=x[k];
		    			//System.out.println(b);
		    			
		    			
		    				 driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		    				 driver.findElement(By.xpath(Numpadpopup_firstpath+b+Numpadpopup_secondpath)).click();
		    				 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		    			} 
		    	     		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		    	     		driver.findElement(By.xpath(Numpadpopup_Set_btn_xpath)).click();
		    	     		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		    	     		break;
			    				}
		    			 }
		    	    }
		    	
		  }
		  
		  public static String PaperAmount(WebDriver driver,String Amount){
			  String value=Amount;
				 String[] v2=value.split("\\.");
				 String PaperAmount=v2[0]+"00";
				 System.out.println(PaperAmount);
				return PaperAmount;
		  }
		 
		  public static String CoinAmount(WebDriver driver,String Amount){
			  String value=Amount;
				 String[] v2=value.split("\\.");
				 String coinAmount=v2[1]+"00";
				 System.out.println(coinAmount);
				return coinAmount;
		  }
}
