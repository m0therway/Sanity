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

public class Homepage {

	 public static String PreSales_btn_xpath = "//i[@class='glyphicons money fa-2x']";
	 public static String OpenFlight_btn_xpath = "//a[@href='openshop.html']";
	 public static String Synchonize_link_xpath = "//i[@class='glyphicons transfer fa-2x']";
	 public static String Synchonize_btn_xpath = ".//*[@id='Main']/form/div/div/div[3]/button";
	 public static String OpenFlight_Menu_xpath=".//*[@id='mnuOpenShop']/a";
	 public static String Synchonize_Menu_xpath=".//*[@id='mnuSync']/a";
	 public static String Uplift_btn_xpath="//a[@href='uplift.closedshop.html']";
	 public static String Reports_btn_xpath="//a[@href='reports.closedshop.html']";
	 public static String report_links=".//*[@id='Main']/div/div[2]/div[1]/div/a";
	 public static String Link_firstxpath=".//*[@id='Main']/div/div[2]/div[1]/div/a[";
     public static String Link_secondxpath="]";
     public static String MenuSettings_xpath=".//*[@id='mnuSettings']/a";
 	public static String MenuSettings_list_xpath=".//*[@id='mnuSettings']/ul/li";
 	public static String MenuSetting_firstxpath=".//*[@id='mnuSettings']/ul/li[";
 	public static String MenuSetting_secondxpath="]/a";
 	public static String Prefence_xpath=".//*[@id='mnuSettings']/ul/li[2]/a";
 	public static String AfterOpenShop_dpdn_xpath=".//*[@id='tabPreferencesRedirect']/div/div/form/div[1]/div/select";
 	public static String AfterSaleComplete_dpdn_xpath=".//*[@id='tabPreferencesRedirect']/div/div/form/div[2]/div/select";
 	public static String ExitCart_dpdn_xpath=".//*[@id='tabPreferencesRedirect']/div/div/form/div[3]/div/select";
 	public static String ExitCloseShop_dpdn_xpath=".//*[@id='tabPreferencesRedirect']/div/div/form/div[4]/div/select";
 	public static String MenuSettings_popup_Close_btn_xpath=".//*[@id='btnCloseModal']";
	 
 	
 	  public static void switchControlToLatestWindow(WebDriver driver) {
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	
	  }
 	
 	 public static void SetFlowPrefernce(WebDriver driver, String dropdown, String Value){
 		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
 		driver.findElement(By.xpath(MenuSettings_xpath)).click();
 		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 		driver.findElement(By.xpath(Prefence_xpath)).click();
 		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
 		EPOS_DashBoard.switchControlToLatestWindow(driver);
 		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
 	    actions.selectByVisibleText(driver, "xpath", dropdown, Value);
 	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 	    driver.findElement(By.xpath(MenuSettings_popup_Close_btn_xpath)).click();
 	}
 	
	 public static void VerifyButtons(WebDriver driver) throws InterruptedException{
		 Thread.sleep(1000);
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 WebElement PreSales  =driver.findElement(By.xpath(PreSales_btn_xpath));
		 WebElement OpenFlight = driver.findElement(By.xpath(OpenFlight_btn_xpath));
		 WebElement Synchonize =driver.findElement(By.xpath(Synchonize_btn_xpath));
		 WebElement Uplift =driver.findElement(By.xpath(Uplift_btn_xpath));
		 WebElement Reports =driver.findElement(By.xpath(Reports_btn_xpath));

		 if(PreSales.isDisplayed()||PreSales.isEnabled()){
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 System.out.println("Pre-Sales button is displyed and Enabled on the page");
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			   if(OpenFlight.isDisplayed()||OpenFlight.isEnabled()){
				 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				 System.out.println("OpenFlight button is displyed and Enabled on the page");
				 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				   if(Synchonize.isDisplayed()||Synchonize.isEnabled()){
					 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					 System.out.println("Synchonize button is displyed and Enabled on the page");
					 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					 if(Uplift.isDisplayed()||Synchonize.isEnabled()){
						 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						 System.out.println("Uplift button is displyed and Enabled on the page");
						 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						 if(Reports.isDisplayed()||Synchonize.isEnabled()){
							 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
							 System.out.println("Reports button is displyed and Enabled on the page");
							 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						      }else{
							 Assert.fail("Reports button not displyed ");
						     }
					      }else{
						 Assert.fail("Uplift button not displyed ");
					     }
				      }else{
					 Assert.fail("Synchonize button not displyed ");
				     }
			       }else{
				 Assert.fail("OpenFlight button not displyed ");
			         }
		         }else{
			   Assert.fail("Pre-Sales button not displyed ");
		        }
		
		 
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	 }
	 
	 
	 
	 
	 public static void Open_shop(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		 JavascriptExecutor js= (JavascriptExecutor) driver;
		    js.executeScript("return document.readyState").equals("complete");
		    //Thread.sleep(1000);
		    WebDriverWait ww= new WebDriverWait(driver,30);
		    ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OpenFlight_btn_xpath)));
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath(OpenFlight_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
	 }
	 public static void Reports(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		 JavascriptExecutor js= (JavascriptExecutor) driver;
		    js.executeScript("return document.readyState").equals("complete");
		    WebDriverWait ww= new WebDriverWait(driver,30);
		    ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Reports_btn_xpath)));
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath(Reports_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
	 }
	 
	 public static void Navigate_to_Report(WebDriver driver,String Report){
		 driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			int links = driver.findElements(By.xpath(report_links)).size();
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
	 public static void Uplift(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		 JavascriptExecutor js= (JavascriptExecutor) driver;
		    js.executeScript("return document.readyState").equals("complete");
		    WebDriverWait ww= new WebDriverWait(driver,30);
		    ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Uplift_btn_xpath)));
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath(Uplift_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
	 }
	 public static void Sync(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		 JavascriptExecutor js= (JavascriptExecutor) driver;
		    js.executeScript("return document.readyState").equals("complete");
		    WebDriverWait ww= new WebDriverWait(driver,30);
		    ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Synchonize_btn_xpath)));
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath(Synchonize_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
	 }
	 public static void Verify_Menus(WebDriver driver){
		 String[] Menus={"Open Flight","Synchronize"};
		 String ActualMenu1 =  driver.findElement(By.xpath(OpenFlight_Menu_xpath)).getText();
		 String ActualMenu2 =  driver.findElement(By.xpath(Synchonize_Menu_xpath)).getText();
		 if(ActualMenu1.equalsIgnoreCase(Menus[0])){
			 System.out.println("MenuOne is as expected");
			 if(ActualMenu2.equalsIgnoreCase(Menus[1])){
				 System.out.println("MenuTwo is as expected"); 
			 }else{
				Assert.fail("MenuTwo is different"); 
			 }
		 }else{
			 Assert.fail("MenuOne is different"); 
		 }
		 
	 }
	 
}
