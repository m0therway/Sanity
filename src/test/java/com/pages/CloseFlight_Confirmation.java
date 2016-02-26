package com.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CloseFlight_Confirmation {
	public static String BarsetNum_xpath=".//*[@id='Confirmation']/div[1]/div/div[2]/ul/li[1]";
	public static String Flight_Number_xpath=".//*[@id='Confirmation']/div[1]/div/div[2]/ul/li[2]";
	public static String FlightRoute_xpath=".//*[@id='Confirmation']/div[1]/div/div[2]/ul/li[3]";
	public static String TailNumber_xpath=".//*[@id='Confirmation']/div[1]/div/div[2]/ul/li[6]";
	public static String FlightDate_xpath=".//*[@id='Confirmation']/div[1]/div/div[2]/ul/li[4]";
	public static String PAX_Number_xpath=".//*[@id='Confirmation']/div[1]/div/div[2]/ul/li[5]";
	public static String CreCount_xpath=".//*[@id='Confirmation']/div[2]/div/div[2]/ol/li";
	public static String Crew_Name_firstxpath=".//*[@id='Confirmation']/div[2]/div/div[2]/ol/li";
	public static String Crew_Name_secondxpath="[";
	public static String Crew_Name_thirdxpath="]";
	public static String OutBound_Seal_size=".//*[@id='Confirmation']/div[3]/div/div[2]/ol/li";
	public static String OutBound_Seal=".//*[@id='Confirmation']/div[3]/div/div[2]/ol/li";
	public static String OutBound_Seal_firstxpath = ".//*[@id='Confirmation']/div[3]/div/div[2]/ol/li";
	public static String OutBound_Seal_secondxpath = "[";
	public static String OutBound_Seal_thirdxpath = "]";
	public static String Currency_Type_firstpath=".//*[@id='ConfimationCashCounts']/div[2]/ul/li[";
	public static String Currency_Type_secondpath="]/label";
	public static String Currency_Total_firstpath=".//*[@id='ConfimationCashCounts']/div[2]/ul/li[";
	public static String Currency_Total_secondpath="]/span";
	public static String Continue_btn_xpath=".//*[@id='myWizard']/div[2]/div[6]/button";
	public static String Currencies_list_xpath=".//*[@id='ConfimationCashCounts']/div[2]/ul/li";
	public static String sections_xpath=".//*[@id='Confirmation']/div";
	public static String sections_firstxpath =".//*[@id='Confirmation']/div[";
	public static String sections_secondxpath ="]/div/div[1]/h2";
	
	public static int CloseShop_Flightnum(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		String Num= driver.findElement(By.xpath(Flight_Number_xpath)).getText();
		String[] String1=Num.split("\\=");
		String Num1=String1[1].trim();
		int FlightNum=Integer.parseInt(Num1);
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		// System.out.println(FlightNum);
		return FlightNum;
	}
	public static int CloseShop_BarsetNum(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		String Num= driver.findElement(By.xpath(BarsetNum_xpath)).getText();
		String[] String1=Num.split("\\=");
		String Num1=String1[1].trim();
		int BarsetNum=Integer.parseInt(Num1);
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		// System.out.println(BarsetNum);
		return BarsetNum;
	}
	
	public static String CloseShop_FlightDate(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 String Date= driver.findElement(By.xpath(FlightDate_xpath)).getText();
		 String[] String = Date.split("\\=");
		 String FlightDate = String[1].trim();
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		System.out.println(FlightDate);
		 return FlightDate;
	}
	public static String CloseShop_FlightRoute(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 String Route= driver.findElement(By.xpath(FlightRoute_xpath)).getText();
		 String[] String1=Route.split("\\=");
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 String FlightRoute=String1[1].trim();
		// System.out.println(FlightRoute);
		 return FlightRoute;
	}
	public static String CloseShop_TailNum(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 String TailNum= driver.findElement(By.xpath(TailNumber_xpath)).getText();
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 System.out.println(TailNum);
		 return TailNum;
	}
	public static String CloseShop_Crew(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 int CrewCount = driver.findElements(By.xpath(CreCount_xpath)).size();
		 String Crew=null;
		 if(CrewCount > 1){
		 for(int i=CrewCount;i>0;i--){
		 Crew= driver.findElement(By.xpath(Crew_Name_firstxpath+Crew_Name_secondxpath+i+Crew_Name_thirdxpath)).getText();
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 System.out.println(Crew);
		 }
		 }else{
			 Crew= driver.findElement(By.xpath(Crew_Name_firstxpath)).getText();
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			 System.out.println(Crew); 
		 }
		 return Crew;
	}
	public static String Currency(WebDriver driver,String Currencytype) throws IOException{
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 int Currencies=  driver.findElements(By.xpath(Currencies_list_xpath)).size();
		 String Currency=null;
		 for(int i=1;i<=Currencies;i++){
		 Currency= driver.findElement(By.xpath(Currency_Type_firstpath+i+Currency_Type_secondpath)).getText();
		 if(Currency.equals(Currencytype)){
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 System.out.println(Currency);
		   }
		 }
		 return Currency;
	}
	public static float ClosingCount(WebDriver driver,String Currencytype,String CurrencySymbol) throws IOException{
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 int Currencies=  driver.findElements(By.xpath(Currencies_list_xpath)).size();
		// System.out.println(Currencies);
		 float  ClosingCount=0;
		 for(int i=1;i<=Currencies;i++){
			 String Currency=driver.findElement(By.xpath(Currency_Type_firstpath+i+Currency_Type_secondpath)).getText();
	       //  System.out.println(Currency);
			 if(Currency.equals(Currencytype)){
	         String total= driver.findElement(By.xpath(Currency_Total_firstpath+i+Currency_Total_secondpath)).getText();
	        // System.out.println(total);
		  String[] string1=total.split("\\"+CurrencySymbol);
		  ClosingCount= Float.valueOf(string1[1].trim()).floatValue();
		  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		System.out.println("ClosingCount is"+ClosingCount);
		  break;
		   }
		 }
		 return ClosingCount;
	}
	
	public static void Verify_Sections_on_the_page(WebDriver driver) throws IOException{
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		int sections= driver.findElements(By.xpath(sections_xpath)).size();
		String[] Sections = {"Flight Info.","Crew","Outbound Seals","Closing Cash Counts"};
		for(int i=1;i<=sections;i++){
			for(int j=0;j<Sections.length;j++){
				String sectionHeading = driver.findElement(By.xpath(sections_firstxpath+i+sections_secondxpath)).getText();
				if(sectionHeading.equalsIgnoreCase(Sections[j])){
					System.out.println(sectionHeading+" "+"displayed and details are displayed under this scetion");
				}else{
					Assert.fail(sectionHeading+ "not displayed");
				}
			}
		}
		
	}
	
	public static String OutBoundSeal(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 int Sealcount = driver.findElements(By.xpath(OutBound_Seal_size)).size();
    	 String Seal=null;
    	 if(Sealcount > 1){
    		 for(int j=1;j<=Sealcount;j++){
    			 Seal = driver.findElement(By.xpath(OutBound_Seal_firstxpath+OutBound_Seal_secondxpath+"["+j+"]"+OutBound_Seal_thirdxpath)).getText();
    			// System.out.println(Seal);
    		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    		 
    		 }
    	 }else{
    		  Seal =driver.findElement(By.xpath(OutBound_Seal_firstxpath)).getText();
    		// System.out.println(Seal);
    		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	 
    		 
    			 }
		return Seal;
		
	}
	
	public static void Verify_Continue(WebDriver driver) throws IOException{
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 WebElement continuebutton= driver.findElement(By.xpath(Continue_btn_xpath));
		if(continuebutton.isDisplayed()||continuebutton.isEnabled()){
			System.out.println("Continue button is displayed");
		}else{
			Assert.fail("Continue buttonnot displayed");
		}
	}
	public static void Continue(WebDriver driver) throws IOException{
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 WebElement continuebutton= driver.findElement(By.xpath(Continue_btn_xpath));
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 js.executeScript("arguments[0].click();", continuebutton);
		 driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
	}
	
	
	
	public static void Verify_ConfirmationPage_Details(WebDriver driver,String ExpectedCrewName,String ExpectedSeal,int ExpectedBarsetNum,int ExpectedFlightNum,String ExpectedFlightDate,String ExpectedFlightRoute) throws IOException, InterruptedException{
		String ActualCrewName=CloseFlight_Confirmation.CloseShop_Crew(driver);
		String ActualSeal=CloseFlight_Confirmation.OutBoundSeal(driver).trim();
      	int ActualFlightNumber = CloseFlight_Confirmation.CloseShop_Flightnum(driver);
      	String ActualFlightDate = CloseFlight_Confirmation.CloseShop_FlightDate(driver);
      	String ActualFlightRoute=CloseFlight_Confirmation.CloseShop_FlightRoute(driver);
  		int ActualBarsetNum=CloseFlight_Confirmation.CloseShop_BarsetNum(driver);
  		if(ActualBarsetNum == ExpectedBarsetNum){
  			  System.out.println("Flight Confirmation page Barset Number is:"+" "+ActualBarsetNum+" "+"as expected");
  		   if(ActualFlightNumber == ExpectedFlightNum && ActualFlightDate.trim().equals(ExpectedFlightDate.trim()) && ActualFlightRoute.equals(ExpectedFlightRoute)){
  			     System.out.println("Flight Confirmation page Flight Details are :"+" "+ActualFlightNumber+" "+" "+ActualFlightDate+" "+ ActualFlightRoute +" "+"as expected");
  			  if(ActualCrewName.equals(ExpectedCrewName)){
  				  System.out.println("Crew details are as expected");
  				  if(ActualSeal.equals(ExpectedSeal)){
  					 System.out.println("seals are expected");
  				  }else{
  					 Assert.fail("seals are different");
  				  }
  				  
  			  }else{
  				 Assert.fail("Crew Details are different");
  			  }
  			
  		    }else{
  			   Assert.fail("Flight Details are different");
  		    }
  		 }else{
  			Assert.fail("Barset Number is different");
  		}
	}
	
	
	
	
	
	
	
	
	public static void Verify_Closing_Count(WebDriver driver,float ExpectedTotal1,float ExpectedTotal2, float ActaulTotal1 ,float ActaulTotal2) throws IOException{
	
		if(ExpectedTotal1 == ActaulTotal1 || ExpectedTotal2 == ActaulTotal2){
			System.out.println("Closing CashCount are as expected");
		}else{
			Assert.fail("Closing CashCount are incorrect");
		}
		
	}
	
	
}
