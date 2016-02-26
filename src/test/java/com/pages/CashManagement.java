package com.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commons.common;

public class CashManagement {
	
	
	 WebDriver driver = null;
	    public static String CashierEntryDate_fld_xpath="//input[@name='Cashier's entry date']";
	    //CurrencyCount starts with 3
	    public static String Currencies_Count_xpath="html/body/div[1]/div/div/form/div[2]/div[2]/div";
		public static String Currency_firstxpath="html/body/div[1]/div/div/form/div[2]/div[2]/div";
		public static String Currency_secondxpath="/div[1]";
		public static String Currency_PaperExchangeRate_fld_firstxpath="html/body/div[1]/div/div/form/div[2]/div[2]/div";
		public static String Currency_PaperExchangeRate_fld_secondxpath="/div[2]/div/input";
		public static String Currency_CoinExchangeRate_fld_firstxpath="html/body/div[1]/div/div/form/div[2]/div[2]/div";
		public static String Currency_CoinExchangeRate_fld_secondxpath="/div[3]/div/input";
		public static String ExChangeRateSubmit_btn_xpath="html/body/div[1]/div/div/form/div[2]/div[3]/button[2]";
		public static String ExChangeRate_Varience_popup="html/body/div[1]/div/div/form/div[1]/div";
		public static String ExChangeRate_Varience_popup_Continue_btn="html/body/div[1]/div/div/form/div[1]/div/div/div[3]/button[1]";
		public static String ExChangeRate_Varience_popup_Ccncel_btn="html/body/div[1]/div/div/form/div[1]/div/div/div[3]/button[2]";
		public static String Message_xpath="html/body/div[2]/ul/li/div/span/span";
		public static String DailyExcRate_Submit_btn="html/body/div[1]/div/div/form/div[2]/div[3]/button[2]";
		
		//ManageCash Bag
		public static String AddCashbag_btn_xpath="//button[@ng-click='showCreatePopup()']";
		public static String ScheduleDate_fld_xpath="//input[@name='Schedule Date']";
		public static String ScheduleNum_fld_xpath="html/body/div[1]/div/div/div[2]/div/div/div[2]/div/form/div[2]/div/div/span/span[1]";
		public static String ScheduleNum_firstxpath="html/body/div[1]/div/div/div[2]/div/div/div[2]/div/form/div[2]/div/ul/li/div";
		public static String ScheduleNum_secondxpath="/a/div";
		public static String StoreNum_fld_xpath=".//*[@id='cashBag-storeNumber']";
		public static String StoreNum_firstxpath="html/body/div[1]/div/div/div[2]/div/div/div[2]/div/form/div[3]/div/ul/li/div";
		public static String StoreNum_secondxpath="/a/div";
		public static String Search_btn_xpath="//button[@ng-click='findStoreInstance()']";
		public static String SubmitCreateStoreInstance_btn_xpath="//button[@ng-click='submitCreate(storeInstance)']";
		
		//Edit cash bag screen
		public static String CashBagEdit_btn_xpath="html/body/div[1]/div/div/table/tbody/tr/td[9]/button[2]";
		public static String CashBagNum_fld_xpath="//input[@id='cashBagNumber']";
		public static String TotalNumOf_CahBags_fld_xpath=".//*[@id='totalCashBags']";
		public static String BankRefNum_fld_xpath="//input[@id='bankReferenceNumber']";
		public static String CashBag_Currency_Count_xpath="html/body/div[1]/div/div/div[2]/form/div[2]/div[2]/table/tbody/tr";
		public static String CashBagCurrency_firstxpath="html/body/div[1]/div/div/div[2]/form/div[2]/div[2]/table/tbody/tr";
		public static String CashBagCurrency_secondxpath="/td[1]";
		public static String FlightAmount_fld_firstxpath="html/body/div[1]/div/div/div[2]/form/div[2]/div[2]/table/tbody/tr";
		public static String FlightAmount_fld_secondxpath="/td[2]";
		public static String PaperAmount_fld_firstxpath="html/body/div[1]/div/div/div[2]/form/div[2]/div[2]/table/tbody/tr";
		public static String PaperAmount_fld_secondxpath="/td[3]/input";
		public static String CoinAmount_fld_firstxpath="html/body/div[1]/div/div/div[2]/form/div[2]/div[2]/table/tbody/tr";
		public static String CoinAmount_fld_secondxpath="/td[4]/input";
		public static String Create_btn_xpath="//button[@ng-click='formSave(cashBag)']";
		public static String CashBag_Save_btn="html/body/div[1]/div/div/div[2]/form/div[3]/button[2]";
		
		//cash bag submission screen
		
		public static String RefNum_fld_xpath="//input[@id='bankReferenceNumber']";
		public static String CashBags_firstxpath="/html/body/div[1]/div/div/table/tbody/tr";
		public static String CashBags_secondxpath="/td[2]";
		public static String CashBagSearch_btn_xpath=".//*[@id='searchCollapse']/form/div[2]/button[2]";
		public static String CashBagSelect_chkbx_firstxpath="/html/body/div[1]/div/div/table/tbody/tr";
		public static String CashBagSelect_chkbx_secondxpath="/td[1]/input";
		public static String CashBag_SubmitButton="html/body/div[1]/div/div/div[2]/div/div[2]/button[2]";
		public static String Submit_confirm_popup="html/body/div[1]/div/div/div[1]";
		public static String Confirm_popup_Submit="html/body/div[1]/div/div/div[1]/div/div/div[3]/button[1]";
		
		public static void Dialy_ExchangeRate(WebDriver driver,String CurrencyType, String PaperAmount, String CoinAmount){
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date getSystemDate = new Date();
			//System.out.println(getSystemDate);
			String SystemDate = df.format(getSystemDate);
			driver.findElement(By.xpath(CashierEntryDate_fld_xpath)).clear();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.findElement(By.xpath(CashierEntryDate_fld_xpath)).sendKeys(SystemDate);
			String Currency=null;
			int Currencies=driver.findElements(By.xpath(CashBag_Currency_Count_xpath)).size();
			if(Currencies > 1){
				for (int i=3;i<=Currencies;i++){
					Currency=driver.findElement(By.xpath(CashBagCurrency_firstxpath+"["+i+"]"+Currency_secondxpath)).getText();
					if(Currency.equals(CurrencyType)){
						driver.findElement(By.xpath(Currency_PaperExchangeRate_fld_firstxpath+"["+i+"]"+Currency_PaperExchangeRate_fld_secondxpath)).sendKeys(PaperAmount);
						driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
						driver.findElement(By.xpath(Currency_CoinExchangeRate_fld_firstxpath+"["+i+"]"+Currency_CoinExchangeRate_fld_secondxpath)).sendKeys(CoinAmount);
						driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					}
					
				}
			}else{
				Currency=driver.findElement(By.xpath(CashBagCurrency_firstxpath+Currency_secondxpath)).getText();
				if(Currency.equals(CurrencyType)){
					driver.findElement(By.xpath(Currency_PaperExchangeRate_fld_firstxpath+Currency_PaperExchangeRate_fld_secondxpath)).sendKeys(PaperAmount);
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					driver.findElement(By.xpath(Currency_CoinExchangeRate_fld_firstxpath+Currency_CoinExchangeRate_fld_secondxpath)).sendKeys(CoinAmount);
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				}
			}
			
		}
		
		public static void DailyExchangeRate_Submit(WebDriver driver){
			common.Wait_Until_ElementVisible(driver, DailyExcRate_Submit_btn);
			common.Wait_Until_ElementClickable(driver, DailyExcRate_Submit_btn);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.findElement(By.xpath(DailyExcRate_Submit_btn)).click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		}
		
		public static void ExchangeRate_popup(WebDriver driver){
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			if(driver.findElements(By.xpath(ExChangeRate_Varience_popup)).size()!=0){
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				common.switchControlToLatestWindow(driver);
				driver.findElement(By.xpath(ExChangeRate_Varience_popup_Continue_btn)).click();
				WebDriverWait ww = new WebDriverWait(driver,30);
	 			ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Message_xpath)));
			}
		}
		
		
		public static void Add_CashBag(WebDriver driver,String ScheduleDate, String ScheduleNum,String StoreNum){
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.findElement(By.xpath(AddCashbag_btn_xpath)).click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		    common.switchControlToLatestWindow(driver);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.findElement(By.xpath(ScheduleDate_fld_xpath)).sendKeys(ScheduleDate);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			WebDriverWait ww= new WebDriverWait(driver,30);
			ww.until(ExpectedConditions.elementToBeClickable(By.xpath(ScheduleNum_fld_xpath)));
			driver.findElement(By.xpath(ScheduleNum_fld_xpath)).click();
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			int Flights= driver.findElements(By.xpath(ScheduleNum_firstxpath)).size();
			String FlightNum = null;
			for(int i=3;i<=Flights;i++){
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				FlightNum = driver.findElement(By.xpath(ScheduleNum_firstxpath+"["+i+"]"+ScheduleNum_secondxpath)).getText();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			if(FlightNum.equals(StoreNum)){
				driver.findElement(By.xpath(ScheduleNum_firstxpath+"["+i+"]"+ScheduleNum_secondxpath)).click();
				break;
			 }
			}
			Actions ac= new Actions(driver);
			ac.sendKeys(Keys.TAB).perform();
			ww.until(ExpectedConditions.elementToBeClickable(By.xpath(StoreNum_fld_xpath)));
			driver.findElement(By.xpath(StoreNum_fld_xpath)).click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			int StoreNums= driver.findElements(By.xpath(StoreNum_firstxpath)).size();
			String Store = null;
			for(int i=3;i<=StoreNums;i++){
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				Store = driver.findElement(By.xpath(StoreNum_firstxpath+"["+i+"]"+StoreNum_secondxpath)).getText();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			if(Store.equals(StoreNum)){
				driver.findElement(By.xpath(StoreNum_firstxpath+"["+i+"]"+StoreNum_secondxpath)).click();
				break;
			 }
			}
			driver.findElement(By.xpath(Search_btn_xpath)).click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.findElement(By.xpath(SubmitCreateStoreInstance_btn_xpath)).click();
			}
			
		
		public static void Edit_CashBag(WebDriver driver,String CashbagsCount,String Refnum){
			//common.Wait_Until_ElementClickable(driver, CashBagEdit_btn_xpath);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			//driver.findElement(By.xpath(CashBagEdit_btn_xpath)).click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			common.Wait_Until_ElementVisible(driver, TotalNumOf_CahBags_fld_xpath);
			common.Wait_Until_ElementClickable(driver, TotalNumOf_CahBags_fld_xpath);
			driver.findElement(By.xpath(TotalNumOf_CahBags_fld_xpath)).sendKeys(CashbagsCount);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.findElement(By.xpath(BankRefNum_fld_xpath)).sendKeys(Refnum);
		}
		public static void Enter_paper_coin_Amount(WebDriver driver,String CurrencyType){
			common.Wait_Until_ElementVisible(driver, CashBag_Currency_Count_xpath);
			int Currencies=driver.findElements(By.xpath(CashBag_Currency_Count_xpath)).size();
			String Currency=null;
			for(int i=1;i<=Currencies;i++){
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				Currency = driver.findElement(By.xpath(CashBagCurrency_firstxpath+"["+i+"]"+CashBagCurrency_secondxpath)).getText();
				if(Currency.equals(CurrencyType)){
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					String Amount = driver.findElement(By.xpath(FlightAmount_fld_firstxpath+"["+i+"]"+FlightAmount_fld_secondxpath)).getText();
				 String[] v2=Amount.split("\\.");
				 String PaperAmount=v2[0]+".00";
			 	String coinAmount=v2[1]+".00";
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					driver.findElement(By.xpath(PaperAmount_fld_firstxpath+"["+i+"]"+PaperAmount_fld_secondxpath)).sendKeys(PaperAmount);
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					driver.findElement(By.xpath(CoinAmount_fld_firstxpath+"["+i+"]"+CoinAmount_fld_secondxpath)).sendKeys(coinAmount);
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					break;
				}
				
			}
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.findElement(By.xpath(CashBag_Save_btn)).click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			StoreInstanceDashBoard.Wait_Until_ModelBox_Disappears(driver);
			common.Wait_Until_ElementInVisible(driver, "html/body/div[2]/ul/li/div/span/span");
		}
		
		public static void SearchCashBag_With_BankRefNum(WebDriver driver,String Refnum){
			common.Wait_Until_ElementVisible(driver, RefNum_fld_xpath);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.findElement(By.xpath(RefNum_fld_xpath)).sendKeys(Refnum);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			common.Wait_Until_ElementClickable(driver, CashBagSearch_btn_xpath);
			driver.findElement(By.xpath(CashBagSearch_btn_xpath)).click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		}
		
		public static void Submit_CashBag(WebDriver driver,String cashbag){
			common.Wait_Until_ElementVisible(driver, CashBags_firstxpath);
			int cashbags=driver.findElements(By.xpath(CashBags_firstxpath)).size();
			String num=null;
			if(cashbags > 1){
			for(int i=1;i<=cashbags;i++){
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				num=driver.findElement(By.xpath(CashBags_firstxpath+CashBags_secondxpath)).getText();
				if(num.equals(cashbag)){
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					driver.findElement(By.xpath(CashBagSelect_chkbx_firstxpath+"["+i+"]"+CashBagSelect_chkbx_secondxpath)).click();
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					break;
				}
				
			}
			}else{
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				num=driver.findElement(By.xpath(CashBags_firstxpath+CashBags_secondxpath)).getText();
				if(num.equals(cashbag)){
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					driver.findElement(By.xpath(CashBagSelect_chkbx_firstxpath+CashBagSelect_chkbx_secondxpath)).click();
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				}
			}
			common.Wait_Until_ElementVisible(driver, CashBag_SubmitButton);
			common.Wait_Until_ElementClickable(driver, CashBag_SubmitButton);
			driver.findElement(By.xpath(CashBag_SubmitButton)).click();
			common.Wait_Until_ElementVisible(driver, Submit_confirm_popup);
			common.Wait_Until_ElementVisible(driver, Confirm_popup_Submit);
			common.Wait_Until_ElementClickable(driver, Confirm_popup_Submit);
			common.switchControlToLatestWindow(driver);
			driver.findElement(By.xpath(Confirm_popup_Submit)).click();
			StoreInstanceDashBoard.Wait_Until_ModelBox_Disappears(driver);
			common.Wait_Until_ElementInVisible(driver, "html/body/div[2]/ul/li/div/span/span");
		}
		
		public static void Search_CashBag(WebDriver driver,String cashbagno, String StoreNum){
			common.Wait_Until_ElementVisible(driver, CashBagNum_fld_xpath);
			driver.findElement(By.xpath(CashBagNum_fld_xpath)).sendKeys(cashbagno);
			common.Wait_Until_ElementVisible(driver, StoreNum_fld_xpath);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.findElement(By.xpath(StoreNum_fld_xpath)).sendKeys(StoreNum);
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.findElement(By.xpath(CashBagSearch_btn_xpath)).click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		}
		 public static String PaperAmount(WebDriver driver){
			 int Currencies=driver.findElements(By.xpath(CashBag_Currency_Count_xpath)).size();
				String PaperAmount=null;
				for(int i=1;i<=Currencies;i++){
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					String Amount = driver.findElement(By.xpath(FlightAmount_fld_firstxpath+"["+i+"]"+FlightAmount_fld_secondxpath)).getText();
					
					
				 String[] v2=Amount.split("\\.");
				 PaperAmount=v2[0]+".00";
				 System.out.println(PaperAmount);
				}
				return PaperAmount;
		  }
		 
		  public static String CoinAmount(WebDriver driver){ 
			  int Currencies=driver.findElements(By.xpath(CashBag_Currency_Count_xpath)).size();
		 
			String coinAmount=null;
			for(int i=1;i<=Currencies;i++){
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				String Amount = driver.findElement(By.xpath(FlightAmount_fld_firstxpath+"["+i+"]"+FlightAmount_fld_secondxpath)).getText();
				
				 String[] v2=Amount.split("\\.");
				 coinAmount="00."+v2[1];
				 System.out.println(coinAmount);
			}
				return coinAmount;
		  }
		  
		  public  String CashBagNum(WebDriver driver){
				final java.util.Random generator = new java.util.Random();
				final int MIN = 1;
				final int MAX = 999;
				int randomNumber = generator.nextInt(MAX - MIN) + MIN;
				String Num = randomNumber+"CB";
				System.out.println(Num);
				return Num;
				
			}
		  public  String BankRefNum(WebDriver driver){
				final java.util.Random generator = new java.util.Random();
				final int MIN = 1000;
				final int MAX = 5000;
				int randomNumber = generator.nextInt(MAX - MIN) + MIN;
				String Num = Integer.toString(randomNumber);
				System.out.println(Num);
				return Num;
				
			}
		  
		  public static String Entered_CashBagNum(WebDriver driver){
			  common.Wait_Until_ElementVisible(driver, CashBagNum_fld_xpath);
			  String cashBag = driver.findElement(By.xpath(CashBagNum_fld_xpath)).getAttribute("value");
			  System.out.println(cashBag);
			return cashBag;
		  }
		  public static String Entered_BankRefNum(WebDriver driver){
			  common.Wait_Until_ElementVisible(driver, BankRefNum_fld_xpath);
			  String BankRefNum = driver.findElement(By.xpath(BankRefNum_fld_xpath)).getAttribute("value");
			  System.out.println(BankRefNum);
			return BankRefNum;
		  }
		  
}
