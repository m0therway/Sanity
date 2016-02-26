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

public class Barset{
	WebDriver driver=null;
	public static String Barset_NumFld_xpath="//input[@name='IRN']" ;
	
	public static String Cabin_Count_xpath = ".//*[@id='myWizard']/div[2]/div[2]/div[2]/div[2]/section/div";
	
	public static String Menu_Count_xpath = ".//*[@id='myWizard']/div[2]/div[2]/div[2]/div[2]/section/div/a";
	public static String MenuName_firstxpath = ".//*[@id='myWizard']/div[2]/div[2]/div[2]/div[2]/section/div/a[";
	public static String MenuName_secondxpath = "]/span";
	public static String MenuChkBx_firstxpath = ".//*[@id='myWizard']/div[2]/div[2]/div[2]/div[2]/section/div/a[";
	public static String MenuChkBx_secondxpath = "]";
	
	public static String Barset_Continue_xpath= ".//*[@id='btnIRN1']";
	public static String Invalid_Barset_Message_xpath=".//*[@id='myWizard']/div/div[2]/div[1]/div/div/span[2]";
	public static String Menu_Select_Warning_xpath=".//*[@id='myWizard']/div/div[2]/div[2]/div[3]/div";
	public static String BarsetNum_xpath = ".//*[@id='myWizard']/div/div[2]/div[1]/div/h2/small";
	public static String StoreInstance_Modalbox_xpath="html/body/div[2]/div";
	public static String StoreInsatance_popup_Title_xpath="html/body/div[2]/div/div/div[1]/h4";
	//public static String StoreInsatance_popup_Yes_btn_xpath="//button[@data-bb-handler='success']";
	public static String StoreInsatance_popup_Yes_btn_xpath="//div/button[@class='btn btn-success btn-lg btn-modal']";
	public static String StoreInsatance_popup_No_btn_xpath="//button[@data-bb-handler='danger']";
	
	//public static String Barset_Continue_xpath="/html/body/div[3]/div/div/div[2]/button";
	
	public static void switchControlToLatestWindow(WebDriver driver) {
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	
	 }
	 
	public static void Enter_BarsetNum(WebDriver driver, String BarsetNum) throws InterruptedException{
		  JavascriptExecutor js= (JavascriptExecutor) driver;
	        js.executeScript("return document.readyState").equals("complete");
		WebDriverWait ww = new WebDriverWait(driver,30);
		ww.until(ExpectedConditions.elementToBeClickable(By.xpath(Barset_NumFld_xpath)));
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath(Barset_NumFld_xpath)).sendKeys(BarsetNum);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
	}
	
	
	
	 public static void Barset_Continue(WebDriver driver) throws IOException{
		    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	        JavascriptExecutor js= (JavascriptExecutor) driver;
	        js.executeScript("return document.readyState").equals("complete");
	        WebElement continuebutton= driver.findElement(By.xpath(Barset_Continue_xpath));
		    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		    js.executeScript("arguments[0].click();", continuebutton);
	        js.executeScript("return document.readyState").equals("complete");
	        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	}
	public static void  Validate_BarsetNum_fld(WebDriver driver) throws IOException{
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath(Barset_NumFld_xpath)).sendKeys("");	
		 Barset.Barset_Continue(driver);
		 String Error = driver.findElement(By.xpath(Invalid_Barset_Message_xpath)).getText();
		if(Error.equalsIgnoreCase("Invalid barsetNumber.")){
			System.out.println("Error message"+" "+Error+ " "+"displayed, result as expected");
		 }else{
			 Assert.fail("Error message not displayed");
		 }
		 
	}
	 
	public static void  Validate_Braset_MenuSelections(WebDriver driver,String barsetnum) throws IOException{
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath(Barset_NumFld_xpath)).sendKeys("barsetnum");	
		 Barset.Barset_Continue(driver);
		 String Warning = driver.findElement(By.xpath(Menu_Select_Warning_xpath)).getText();
		if(Warning.equalsIgnoreCase("Please select at least one menu per cabin class.")){
			System.out.println("Warning message"+" "+Warning+ " "+"displayed, result as expected");
		 }else{
			 Assert.fail("Warning message not displayed");
		 }
		 
	}
	public static void Initiate_StoreInstace1(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS); 
		//Barset.switchControlToLatestWindow(driver);
		 if(driver.findElements(By.xpath(StoreInstance_Modalbox_xpath)).size() !=0){
		 driver.findElement(By.xpath(StoreInsatance_popup_Yes_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS); 
		 }
	}
	public static void Initiate_StoreInstace(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS); 
		 JavascriptExecutor js= (JavascriptExecutor) driver;
	        js.executeScript("return document.readyState").equals("complete");
	       
		    js.executeScript("arguments[0].click();", driver.findElement(By.xpath(StoreInsatance_popup_Yes_btn_xpath)));
		
		 driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS); 
	}
	public static void Add_Barset(WebDriver driver, String BarsetNum,int menu) throws IOException, InterruptedException{
		 driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		 Barset.Enter_BarsetNum(driver, BarsetNum); 
		 Barset.Barset_Continue(driver);
		 // Barset.Initiate_StoreInstace(driver);
		 Barset.Initiate_StoreInstace1(driver);
		// Barset.Select_Menu(driver,menu);
		 Barset.Barset_Continue(driver);
	 }
	
	 public static int OpenFlight_BarsetNum(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); 
    	// switchControlToLatestWindow(driver); 
    	 String Num= driver.findElement(By.xpath(BarsetNum_xpath)).getText();
    	 int BarsetNum = Integer.parseInt(Num);
    	 //System.out.println(BarsetNum);
    	 return BarsetNum;
     }
	public static void VerifyStroeInstance_popup(){
		
	}
}
