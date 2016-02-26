package com.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commons.actions;
import com.commons.common;
import com.commons.utilities;

public class OpenFlight extends utilities {
 WebDriver driver=null;
 public static String Store_Num_fld_xpath="//input[@name='IRN']";
 public static String FlightNum_fld_xpath="//input[@name='ScheduleNumber']";
 public static String FlightNumtext_fld_xpath="//strong";
 public static String FlightDate_fld_xpath = "//input[@id='ScheduleDate']";
 public static String Calender_popup="html/body/div[2]/div/div[2]";
 public static String CalMonth_btn_xpath = "//span[@class ='dw-cal-month']";
 //public static String CalMonth_firstpath="//div[@aria-label='";
// public static String CalMonth_secondpath="']";
 public static String CalMonth_firstpath="//div[text()='";
 public static String CalMonth_secondpath="']";
 public static String CalYear_btn_xpath = "//span[@class ='dw-cal-year']";
 public static String CalYear_firstpath="//div[@data-val='";
 public static String CalYear_secondpath="']";
 public static String Caldaytext_xpath ="//table/tbody/tr/th";
 public static String CalYeartext_xpath =".//*[@id='ScheduleDate_dw_pnl_0']/div/div/div/div[1]/div/div[2]/span";
 public static String CalDay_firstxpath ="/html/body/div[4]/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[2]/div['"; 
 public static String CalDay_secondxpath ="']";
 public static String RouteChange_btn_xpath="//div/label[@data-bind='click: toggleShopOverride, css: {shopOverride: allowShopOverride} ']";
 public static String Departure_Station_fld_xpath="//input[@data-bind='enable: false, value: departureStation']";
 public static String ArrivalStation_dpdn_xpath="html/body/section[2]/div[2]/div/div[2]/div[1]/div/div/form/div[4]/div/div[3]/select";
 public static String Route_fld_xpath = ".//*[@id='ScheduleId_FormGroup']/select/option";
 public static String TailNumber_fld_xpath=".//*[@id='myWizard']/div/div[1]/div/div/form/div[4]/input";
 public static String PAX_fld_xpath="//input[@id='PAX']";
 public static String PAX_count_firstxpath ="/html/body/div[5]/div/div[2]/div[2]/div[3]/div[2]/div/div/div[text()='";
 public static String PAX_count_secondxpath ="']";
 public static String PAX_Set_btn_xpath = "html/body/div[5]/div/div[2]/div[2]/div[4]/div[1]/div";
 public static String Continue_btn_xpath= "//button[@id='btnOpenShop']";
 public static String FlightConfirm_popup_xpath="html/body/div[5]/div[@class='modal-dialog']";
 public static String OpenFlightpageHeader_xpath = "/html/body/header/h1";
// public static String popuptitle_xpath = "/html/body/div[5]/div/div/div[1]/h4";
 public static String popuptitle_xpath = "html/body/div[2]/div/div/div[1]/h4";
 //public static String FlightConfpopup_message_xpath = "/html/body/div[5]/div/div/div[2]/div/div";
 public static String FlightConfpopup_message_xpath = "html/body/div[2]/div/div/div[2]/div/div";
 //public static String FlightConfpopup_Flightnum_xpath="/html/body/div[5]/div/div/div[2]/div/dl/dd[1]";
 public static String FlightConfpopup_Flightnum_xpath="html/body/div[2]/div/div/div[2]/div/dl/dd[1]";
 //public static String FlightConfpopup_Tailnum_xpath="/html/body/div[5]/div/div/div[2]/div/dl/dd[2]";
// public static String FlightConfpopup_Tailnum_xpath="html/body/div[2]/div/div/div[2]/div/dl/dd[2]";
 //public static String FlightConfpopup_Route_xpath="/html/body/div[5]/div/div/div[2]/div/dl/dd[3]";
 public static String FlightConfpopup_Route_xpath="html/body/div[2]/div/div/div[2]/div/dl/dd[2]";
 //public static String FlightConfpopup_FlightDate_xpath="/html/body/div[5]/div/div/div[2]/div/dl/dd[4]";
 public static String FlightConfpopup_FlightDate_xpath="html/body/div[2]/div/div/div[2]/div/dl/dd[3]";
 public static String FlightConf_window_Nobtn_xpath = "//button[@data-bb-handler='danger']";
 public static String FlightConf_window_yesbtn_xpath = "html/body/div[2]/div/div/div[3]/button[2]";
		 //"//button[@data-bb-handler='success']";
 public static Logger log=Logger.getLogger(OpenFlight.class);
 public static String OpenFlight_btn_xpath = ".//*[@id='Main']/div[2]/div[2]/a[@href='openshop.html']";
 public static String Invalid_FlightNum_Message_xpath = ".//*[@id='myWizard']/div/div[1]/div/div/form/div[1]/span[2]";
 public static String Invalid_PAX_Message_xpath=".//*[@id='myWizard']/div/div[1]/div/div/form/div[4]/span[2]" ;

 public static String Spend_Per_Head_xpath="//div/input[@id='SpendPerHead']";
 public static String Target_To_Spend_xpath="//div/input[@id='TargetSpend']";
 public static String Numpadpopup_firstpath ="//div[@class='mbsc-np-row']/div[text()='";
 public static String Numpadpopup_secondpath ="']";
 public static String Numpadpopup_Set_btn_xpath = "//div[text()='Set']";
 public static String Synchonize_OpenShop_popup="html/body/div[2]/div";
 public static String Sync_OpenShop_No_Btn="html/body/div[2]/div/div/div[3]/button[1]";
 public static String Sync_OpenShop_Yes_Btn="html/body/div[2]/div/div/div[3]/button[2]";
// public static String Inventory_RefNum=".//*[@id='Main']/header/h1/small";
 public static String StoreInstance_popup="html/body/div[2]/div/div";
 public static String Inventory_RefNum="//h3/span[@id='hdrInventoryReferenceNumber']";
 public static String StoreInstance_Yes_Btn="//button[@data-bb-handler='success']";
 public static String StoreInstance_No_Btn="//button[@data-bb-handler='danger']";
 public static String Numpad="html/body/div[2]/div/div[2]";
 //public static String Menu_Select="html/body/section[2]/div[2]/div/div[2]/div[1]/div/div/form/div[8]/div[2]/section/div/a";
 public static String Menu_Select=".//*[@id='otherMenus']/section/div/a";
 public static String PleaseWait_Text_xpath="html/body/div[4]/h1";
 public static void switchControlToLatestWindow(WebDriver driver) {
	 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	
 }
 
 public static void OpenShop(WebDriver driver) throws InterruptedException{
	 driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
	 Thread.sleep(500);
	 JavascriptExecutor js1= (JavascriptExecutor) driver;
	    js1.executeScript("return document.readyState").equals("complete");
	    js1.executeScript("arguments[0].click();", driver.findElement(By.xpath(OpenFlight_btn_xpath)));
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		Thread.sleep(500);
 }
 
 public static void FlightOpen(WebDriver driver,String Store,String FlightNum,String paxnum1,String paxnum2,String paxnum3,String Spendph,String Targetspend) throws InterruptedException, IOException{
	 WebDriverWait ww=new WebDriverWait(driver,30);
	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	//Thread.sleep(1000);
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf= new SimpleDateFormat("MMM");
    String Month=	sdf.format(cal.getTime());
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Store_Num_fld_xpath)));
	driver.findElement(By.xpath(Store_Num_fld_xpath)).sendKeys(Store);
    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//label[text()='Flight Number']")).click();
    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	//Barset.Initiate_StoreInstace1(driver);
	 driver.findElement(By.xpath("//label[text()='Flight Number']")).click();
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	driver.findElement(By.xpath(FlightNum_fld_xpath)).sendKeys(FlightNum);
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	driver.findElement(By.xpath(FlightDate_fld_xpath)).click();
	driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	 ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Calender_popup)));
	switchControlToLatestWindow(driver);
    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	driver.findElement(By.xpath(CalMonth_btn_xpath )).click();
	driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	JavascriptExecutor js1= (JavascriptExecutor) driver;
    js1.executeScript("return document.readyState").equals("complete");
	driver.findElement(By.xpath(CalMonth_firstpath + Month + CalMonth_secondpath)).click();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
	    js2.executeScript("return document.readyState").equals("complete");
	   // Thread.sleep(200);
	    common.pickdate3(driver);
	   // common.pickdate2(driver,"11");
	  // common.pickdate1(driver);
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    if(driver.findElements(By.xpath(Synchonize_OpenShop_popup)).size() !=0){
	    	switchControlToLatestWindow(driver);
	    	OpenFlight.Synchronize_OpenShop_NO(driver);
	    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    }
	   // Thread.sleep(200);
		 driver.findElement(By.xpath("//input[@id='PAX']")).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		// Thread.sleep(500);
		 ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Numpad)));
	    switchControlToLatestWindow(driver);
	
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.findElement(By.xpath(Numpadpopup_firstpath + paxnum1 + Numpadpopup_secondpath)).click();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
	driver.findElement(By.xpath(Numpadpopup_firstpath + paxnum2 + Numpadpopup_secondpath)).click();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
    driver.findElement(By.xpath(Numpadpopup_firstpath + paxnum3 + Numpadpopup_secondpath)).click();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
	driver.findElement(By.xpath(Numpadpopup_Set_btn_xpath)).click();
 
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Spend_Per_Head_xpath)).click();
		 ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Numpad)));
		    switchControlToLatestWindow(driver);

			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath(Numpadpopup_firstpath + Spendph + Numpadpopup_secondpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			driver.findElement(By.xpath(Numpadpopup_Set_btn_xpath)).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Target_To_Spend_xpath)).click();
		 ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Numpad)));
		    switchControlToLatestWindow(driver);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath(Numpadpopup_firstpath + Spendph + Numpadpopup_secondpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			driver.findElement(By.xpath(Numpadpopup_Set_btn_xpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
	    }

 public static void FlightOpen_With_DeviceSync(WebDriver driver,String Store,String FlightNum,String paxnum1,String paxnum2,String paxnum3,String Spendph,String Targetspend) throws InterruptedException, IOException{
	
	 WebDriverWait ww=new WebDriverWait(driver,30);
	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	//Thread.sleep(1000);
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf= new SimpleDateFormat("MMM");
    String Month=	sdf.format(cal.getTime());
	 ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OpenFlight_btn_xpath)));
	 JavascriptExecutor js= (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", driver.findElement(By.xpath(OpenFlight_btn_xpath)));
	//driver.findElement(By.xpath(OpenFlight_btn_xpath)).click();
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Store_Num_fld_xpath)));
	driver.findElement(By.xpath(Store_Num_fld_xpath)).sendKeys(Store);
    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//label[text()='Flight Number']")).click();
    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	//Barset.Initiate_StoreInstace1(driver);
	 driver.findElement(By.xpath("//label[text()='Flight Number']")).click();
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	driver.findElement(By.xpath(FlightNum_fld_xpath)).sendKeys(FlightNum);
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	driver.findElement(By.xpath(FlightDate_fld_xpath)).click();
	driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	 ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Calender_popup)));
	switchControlToLatestWindow(driver);
    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	driver.findElement(By.xpath(CalMonth_btn_xpath )).click();
	driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	JavascriptExecutor js1= (JavascriptExecutor) driver;
    js1.executeScript("return document.readyState").equals("complete");
	driver.findElement(By.xpath(CalMonth_firstpath + Month + CalMonth_secondpath)).click();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
	    js2.executeScript("return document.readyState").equals("complete");
	   common.pickdate1(driver);
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    if(driver.findElements(By.xpath(Synchonize_OpenShop_popup)).size() !=0){
	    	switchControlToLatestWindow(driver);
	    	OpenFlight.Synchronize_OpenShop_YES(driver);
	    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    }
	   common.Wait_Until_ElementInVisible(driver, PleaseWait_Text_xpath);
	    }	

 
 public static void ReOpen_Barset_For_SecondFlight(WebDriver driver,String FlightNum,String paxnum1,String paxnum2,String paxnum3,String Spendph,String Targetspend) throws InterruptedException, IOException{
	 Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf= new SimpleDateFormat("MMM");
	    String Month=	sdf.format(cal.getTime());	
	 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	driver.findElement(By.xpath(FlightNum_fld_xpath)).sendKeys(FlightNum);
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	driver.findElement(By.xpath(FlightDate_fld_xpath)).click();
	driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	common.Wait_Until_ElementVisible(driver, Calender_popup);
	switchControlToLatestWindow(driver);
    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	driver.findElement(By.xpath(CalMonth_btn_xpath )).click();
	driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	JavascriptExecutor js1= (JavascriptExecutor) driver;
    js1.executeScript("return document.readyState").equals("complete");
	driver.findElement(By.xpath(CalMonth_firstpath + Month + CalMonth_secondpath)).click();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
	    js2.executeScript("return document.readyState").equals("complete");
	   common.pickdate1(driver);
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
		 driver.findElement(By.xpath("//input[@id='PAX']")).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 common.Wait_Until_ElementVisible(driver, Numpad);
	    switchControlToLatestWindow(driver);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.findElement(By.xpath(Numpadpopup_firstpath + paxnum1 + Numpadpopup_secondpath)).click();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
	driver.findElement(By.xpath(Numpadpopup_firstpath + paxnum2 + Numpadpopup_secondpath)).click();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
    driver.findElement(By.xpath(Numpadpopup_firstpath + paxnum3 + Numpadpopup_secondpath)).click();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
	driver.findElement(By.xpath(Numpadpopup_Set_btn_xpath)).click();
 
	    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Spend_Per_Head_xpath)).click();
		 common.Wait_Until_ElementVisible(driver, Numpad);
		    switchControlToLatestWindow(driver);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath(Numpadpopup_firstpath + Spendph + Numpadpopup_secondpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			driver.findElement(By.xpath(Numpadpopup_Set_btn_xpath)).click();
	     	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	    	driver.findElement(By.xpath(Target_To_Spend_xpath)).click(); 
	    	common.Wait_Until_ElementVisible(driver, Numpad);
		    switchControlToLatestWindow(driver);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath(Numpadpopup_firstpath + Spendph + Numpadpopup_secondpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			driver.findElement(By.xpath(Numpadpopup_Set_btn_xpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    }
 public static void Accept_StoreInstance_popup(WebDriver driver){
	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	 switchControlToLatestWindow(driver);
	 driver.findElement(By.xpath(StoreInstance_Yes_Btn)).click();
	 driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS); 
 }
 
 public static void Knockout(WebDriver driver){
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript(String.format("var vm = ko.dataFor(document.body);"));
	 js.executeScript(String.format("vm.scheduleNumber()"));
 }
 
 public static void Accept_FlightConfirmation_Popup(WebDriver driver) throws InterruptedException{
	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	 JavascriptExecutor js2 = (JavascriptExecutor) driver;
	    js2.executeScript("return document.readyState").equals("complete");
	  
	  switchControlToLatestWindow(driver);
	  Thread.sleep(500);
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	//JavascriptExecutor js= (JavascriptExecutor) driver;
	 // js.executeScript("arguments[0].click();",driver.findElement(By.xpath(FlightConf_window_yesbtn_xpath)));

	driver.findElement(By.xpath(FlightConf_window_yesbtn_xpath)).click();
	 driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS); 

 }
 public static void verifyHeader(WebDriver driver) throws InterruptedException{
	Thread.sleep(1000);
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	  String Actualpageheader =driver.findElement(By.xpath(OpenFlightpageHeader_xpath)).getText();
	  String ExpectedpageHeader ="Open Flight Sector";
	  if(Actualpageheader.equalsIgnoreCase(ExpectedpageHeader)){
		  System.out.println( "Open Flight Sector page opened");
	  }else{
	    	 Assert.fail("Header is not matching"); 
	      }
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 }
 
 public static void VerifyRouteFld(WebDriver driver){
	 driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
	 driver.findElement(By.xpath(Route_fld_xpath)).click();
	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
	 String optionvalue = driver.findElement(By.xpath(Route_fld_xpath)).getText();
	    System.out.println(optionvalue);
	    if(optionvalue != null){
	    	System.out.println("Route auto populated based on flightnumber");
	    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
	    }else{
	    	Assert.fail("Route is not auto populated based on flightnumber");
	    }
	    
 }
 
 
 public static String Flight_Route(WebDriver driver){
	 driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
	 driver.findElement(By.xpath(Route_fld_xpath)).click();
	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
	 String optionvalue = driver.findElement(By.xpath(Route_fld_xpath)).getText();
	    System.out.println(optionvalue);
		return optionvalue;
 }
 

 public static void VerifyFlightNumFld(WebDriver driver,String FlightNum){
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		WebElement FlightNumfld =driver.findElement(By.xpath(FlightNum_fld_xpath));
		if(FlightNumfld.isDisplayed()||FlightNumfld.isEnabled()){
		driver.findElement(By.xpath(FlightNum_fld_xpath)).sendKeys(FlightNum);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		System.out.println("FlightNumfld is displayed and Enabled");
	      }else{
	    	 Assert.fail("Field is disabled"); 
		}
 }
 
 public static void VerifyFlightdateFld(WebDriver driver,String Month,String date) throws IOException, InterruptedException{
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		WebElement FlightDatefld = driver.findElement(By.xpath(FlightDate_fld_xpath));
		if(FlightDatefld.isDisplayed()||FlightDatefld.isEnabled()){
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath(FlightDate_fld_xpath)).click();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		switchControlToLatestWindow(driver);
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath(CalMonth_btn_xpath )).click();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.findElement(By.xpath(CalMonth_firstpath + Month + CalMonth_secondpath )).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    js1.executeScript("return document.readyState").equals("complete");
	    Thread.sleep(500);
	     common.pickdate2(driver, date);
		   driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	       String ActualFlightdate= driver.findElement(By.xpath(FlightDate_fld_xpath)).getAttribute("value");
	        System.out.println("FlightDatefld is displayed and Enabled,user is able to pick a date and date is:"  + "  "+ ActualFlightdate );
	    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		}else{
			Assert.fail("Date field is not displayed and disabled");
		}
 }
 
 public static String FlightDate(WebDriver driver) throws IOException, InterruptedException{
		   driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	       String date= driver.findElement(By.xpath(FlightDate_fld_xpath)).getAttribute("value");
	       String[] String1= date.split(" ");
	       String[] d=String1[1].split(",");
	       String ActualFlightdate = String1[0]+" "+d[0]+" "+String1[2]+","+" "+String1[2]+" "+String1[3];
	        System.out.println( ActualFlightdate );
	    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			return ActualFlightdate; 
     }
 
 
      public static void Select_Menu(WebDriver driver){
    	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	  String Status = driver.findElement(By.xpath(Menu_Select)).getAttribute("class");
    	  if(Status.equals("list-group-item")){
    		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    		  driver.findElement(By.xpath(Menu_Select)).click();
    		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	  }
      }
 
 public static void VerifypaxNumberfld(WebDriver driver,String paxnum1,String paxnum2,String paxnum3) throws InterruptedException{
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    WebElement PAXfld = driver.findElement(By.xpath(PAX_fld_xpath));
	    if(PAXfld.isDisplayed()||PAXfld.isEnabled()){
	    	System.out.println("PAXfld is displayed and Enabled");
	    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	    driver.findElement(By.xpath(PAX_fld_xpath)).click();
	    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	    switchControlToLatestWindow(driver);
	    Thread.sleep(300);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath(PAX_count_firstxpath + paxnum1 + PAX_count_secondxpath)).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		driver.findElement(By.xpath(PAX_count_firstxpath + paxnum2 + PAX_count_secondxpath)).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		driver.findElement(By.xpath(PAX_count_firstxpath + paxnum3 + PAX_count_secondxpath)).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		driver.findElement(By.xpath(PAX_Set_btn_xpath)).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	    String Actualpax= driver.findElement(By.xpath(PAX_fld_xpath)).getAttribute("value");
	    int size =Actualpax.length(); 
	    if(Actualpax.contains(paxnum1+paxnum2+paxnum3)){
	      if(size == 3){
	    	System.out.println("pax number is 3 digits");
	    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
	        }else{
	        	Assert.fail("pax number incorrect");
	        }
	      }
	    }
 }
  public static void VerifyFlightConfirmation_popup(WebDriver driver) throws InterruptedException {
	WebElement popup =  driver.findElement(By.xpath(FlightConfirm_popup_xpath));
	 Thread.sleep(500); 
    if(popup.isDisplayed()){
	 System.out.println("Flight Confirmation popup is displayed");
    }else{
	  Assert.fail("Flight Confirmation popup is not displayed ");
     }
   }
 public static void VerifyFlightConfirmation_popupDetails(WebDriver driver) throws InterruptedException, IOException{
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			 String ExpectedFlightDate = OpenFlight.FlightDate(driver);
			 String ExpectedRoute = driver.findElement(By.xpath(Route_fld_xpath)).getText();
			// System.out.println(ExpectedRoute);
			 switchControlToLatestWindow(driver);
			 Thread.sleep(500);
	        String Actualtitle= driver.findElement(By.xpath(popuptitle_xpath)).getText();
	        String expectedtitle = "Flight Confirmation";
	    if(Actualtitle.equalsIgnoreCase(expectedtitle)){
	    	System.out.println("Flight Confirmation popupTitle is as expected");
	    	String Actualpopupmessage= driver.findElement(By.xpath(FlightConfpopup_message_xpath)).getText();
	    	//System.out.println(Actualpopupmessage);
	    	String Expetedpopupmessage="Are you sure you want to board?";
	    	if(Actualpopupmessage.equalsIgnoreCase(Expetedpopupmessage)){
	    		System.out.println("popup message is as expected");
	    	}
	    	String Actualpopupflightnum= driver.findElement(By.xpath(FlightConfpopup_Flightnum_xpath)).getText();
	    	System.out.println(Actualpopupflightnum);
	    	if(Actualpopupflightnum.equals(getValue("FlightNum"))){
	    		System.out.println("Flight number is as expected");
	    	}
	    	String ActualpopupRoute= driver.findElement(By.xpath(FlightConfpopup_Route_xpath)).getText();
	    	System.out.println(ActualpopupRoute);
	    	if(ActualpopupRoute.equals(ExpectedRoute)){
	    		System.out.println("Route is as expected");
	    	}
	    	String ActualpopupFlightDate= driver.findElement(By.xpath(FlightConfpopup_FlightDate_xpath)).getText();
	    	System.out.println(ActualpopupFlightDate);
	    	if(ActualpopupFlightDate.equalsIgnoreCase(ExpectedFlightDate)){
	    		System.out.println("FlightDate is as expected");
	    	}
	    	WebElement element = driver.findElement(By.xpath(FlightConf_window_Nobtn_xpath));
	    	if(element.isDisplayed()){
	    		System.out.println("NO button is displayed");
	    		
	    	}
	    	WebElement element1 = driver.findElement(By.xpath(FlightConf_window_yesbtn_xpath));
	    	if(element1.isDisplayed()){
	    		System.out.println("YES button is displayed");
	    	}
	    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
	      }else{
	    	  Assert.fail("Flight confirmation details are not matching");
	      }
	    }
   public static void VerifyTailNumberFld(WebDriver driver){
		    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		    WebElement Tailnumfld = driver.findElement(By.xpath(TailNumber_fld_xpath));
		    if(Tailnumfld.isDisplayed()||Tailnumfld.isEnabled()){
		    	System.out.println("Tailnumfld is Displayed and Enabled");
		    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		    	driver.findElement(By.xpath(TailNumber_fld_xpath)).sendKeys("tailnum");
		    	String tailnumber = driver.findElement(By.xpath(TailNumber_fld_xpath)).getText();
		    	if(tailnumber!= null){
		    		System.out.println("Tailnumber auto populate");
		    	    }else{
		    	    	Assert.fail("Tailnumber is not autopopulated");
		    	    }
		        }
		     }
 
   public static void VerifyContinueBtn(WebDriver driver){
	   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);  
		 WebElement ContinueBtn = driver.findElement(By.xpath(Continue_btn_xpath));
		 if(ContinueBtn.isDisplayed()||ContinueBtn.isEnabled()){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);   
			 driver.findElement(By.xpath(Continue_btn_xpath)).click();
			 System.out.println("Continue button is Displayed and Enabled");
		 }else{
			 Assert.fail("Continue button is not Displayed");
		 }
  	 
   }
   public static void Validate_FlightNumberFld(WebDriver driver,String InValidFlightNum) throws IOException{
		  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  String flightnum=getValue("InValidFlightNum");
		  if(flightnum.equals(InValidFlightNum)){
		  driver.findElement(By.xpath(FlightNum_fld_xpath)).sendKeys(flightnum);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			  String Error =driver.findElement(By.xpath(Invalid_FlightNum_Message_xpath)).getText();
			 
			  if(Error.equalsIgnoreCase("Flight number not found.")){
				  System.out.println("Error message"+" "+Error+ " "+"displayed, result as expected" );
			  }else{
				  Assert.fail("Error message not displayed");
			  }
			  
			  }
	 }
   
   public static void Validate_PAXFld(WebDriver driver,String InValidPAXNum1,String InValidPAXNum2,String InValidPAXNum3) throws IOException, InterruptedException{
		  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  String paxnum=getValue("InValidPAXNum1")+getValue("InValidPAXNum2")+getValue("InValidPAXNum3");
		  if(paxnum.equals(InValidPAXNum1+InValidPAXNum2+InValidPAXNum3)){
		   driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			 driver.findElement(By.xpath("//input[@id='PAX']")).click();
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 Thread.sleep(500);
		    switchControlToLatestWindow(driver);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath(PAX_count_firstxpath + InValidPAXNum1 + PAX_count_secondxpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			driver.findElement(By.xpath(PAX_count_firstxpath + InValidPAXNum2 + PAX_count_secondxpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
	        driver.findElement(By.xpath(PAX_count_firstxpath + InValidPAXNum3 + PAX_count_secondxpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			driver.findElement(By.xpath(PAX_Set_btn_xpath)).click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			  String Error =driver.findElement(By.xpath(Invalid_PAX_Message_xpath)).getText();
			 
			  if(Error.equalsIgnoreCase("PAX must be between 1 and 0.")){
				  System.out.println("Error message"+" "+Error+ " "+"displayed, result as expected" );
			  }else{
				  Assert.fail("Error message not displayed");
			  }
			  
			  }
	 }
   public static void Continue(WebDriver driver) throws IOException{
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 WebElement continuebutton= driver.findElement(By.xpath(Continue_btn_xpath));
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 js.executeScript("arguments[0].click();", continuebutton);
		 //driver.findElement(By.xpath(CashBag_Continue_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}
   
  public static void Synchronize_OpenShop_NO(WebDriver driver){
	  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	  JavascriptExecutor js= (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].click();", driver.findElement(By.xpath(Sync_OpenShop_No_Btn)));
	  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
  }
  
  
  public static void Synchronize_OpenShop_YES(WebDriver driver){
	  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	  JavascriptExecutor js= (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].click();", driver.findElement(By.xpath(Sync_OpenShop_Yes_Btn)));
	  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
  }
  
  public static int InventoryRef_Num(WebDriver driver){
	  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	  String Num = driver.findElement(By.xpath(Inventory_RefNum)).getText();
	  String[] String1=Num.split(" ");
	  String Number= String1[1];
	  int InventoryRef_Num=Integer.parseInt(Number);
	  return InventoryRef_Num;
  }
  
  
  public static void Verify_InventoryRef_Num_When_BarsetNotClosed_DuringFlightClosing(WebDriver driver) throws InterruptedException{
	  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	 // CloseFlight.Accept_CloseFlight_popup(driver);
	  int Expected=  CloseFlight.CloseFlight_BarsetNum(driver);
	   CloseFlight.DoNot_CloseBarset(driver);
		CloseFlight.CloseShop_Device_Sync(driver);
		Signature.Sign(driver);
		Signature.InformationReview(driver);
		Signature.Accept_Signature(driver);
		 driver.navigate().to("http://egate-solutions.azurewebsites.net/openshop.html");
		int Actual=OpenFlight.InventoryRef_Num(driver);
		
		if(Actual == Expected){
			System.out.println("Existing InventoryRef_Num is used with FlightOpen");
		}else{
			Assert.fail("Existing InventoryRef_Num is not used with FlightOpen");
		}
	 }
  
  public static void Update_Arrival_Station(WebDriver driver){
	  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	  actions.selectByindex(driver, "xpath", ArrivalStation_dpdn_xpath, 10);
	  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
  }
  
  
  public static String Arrival_Station(WebDriver driver){
	  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	 String  ArrivalStation=driver.findElement(By.xpath(ArrivalStation_dpdn_xpath)).getAttribute("value");
	  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	  System.out.println(ArrivalStation);
	return ArrivalStation;
  }
  public static void Verify_ArrivalStation_Update(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  driver.findElement(By.xpath(RouteChange_btn_xpath)).click();
		String Expected_Arrivalstation=OpenFlight.Arrival_Station(driver);
		OpenFlight.Update_Arrival_Station(driver);
		String Actual_Arrivalstation=OpenFlight.Arrival_Station(driver);
		if(Actual_Arrivalstation.equals(Expected_Arrivalstation)){
			Assert.fail("unable to update Arrival station");
		}else{
			System.out.println("Able to Updated arrival station and station is:"+ " "+ Actual_Arrivalstation);
		}
		
  }
  
  
  
  public static void Verify_DepartureStation_Update(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  driver.findElement(By.xpath(RouteChange_btn_xpath)).click(); 
			WebElement DepartureStation=driver.findElement(By.xpath(Departure_Station_fld_xpath));
			Assert.assertFalse(DepartureStation.isEnabled());
				System.out.println("Departure Station field is displayed and disabled and unable to update Departure Station");
			
  }
}