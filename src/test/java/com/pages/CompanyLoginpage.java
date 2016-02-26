package com.pages;

import org.testng.AssertJUnit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commons.common;
import com.commons.utilities;

public class CompanyLoginpage extends utilities{
  WebDriver driver= null;
  public static String URL = "http://egate-solutions.azurewebsites.net/setup.html";
  public static String AccessKey_fld_xpath = "//input[@class='form-control input-lg']";
  public static String Download_btn_xpath = "//button[@id='btnDownload']";
  public static String buttons_xpath = "//a";
  public static String PreSales_btn_xpath = "//i[@class='glyphicons money fa-2x']";
  public static String OpenFlight_btn_xpath = "//a[@href='openshop.html']";
  public static String Synchonize_btn_xpath = "//i[@class='glyphicons transfer fa-2x']";
  public static String Error_Messagepart1_xpath=".//*[@id='Body']/div[1]/div/form/section/div/strong";
  public static String Error_Messagepart2_xpath=".//*[@id='Body']/div[1]/div/form/section/div/span";
  public static String HomePage_NavBar="html/body/section[1]/nav";
  //public static String LicenseAgreement_popup="/html/body/div[1]/div/div";
  public static String LicenseAgreement_popup="//div[@id='ModalContent']";
  
  static Logger log=Logger.getLogger(AssignSeals.class);
 
  public static void CompanyLogin(WebDriver driver,String Companynumber) throws InterruptedException{
	  String url= driver.getCurrentUrl(); 
	  if(URL.equalsIgnoreCase(url)){
		   driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
		   common.Wait_Until_ElementVisible(driver, LicenseAgreement_popup);
		  driver.findElement(By.xpath("//button[@id='btnEULAAgree']")).click();
			//Thread.sleep(1000);
		    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
	  }else{
		  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript(String.format("window.localStorage.clear();"));
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 driver.manage().deleteAllCookies();
			 Actions act = new Actions(driver);
			  act.sendKeys(Keys.CONTROL.F5).perform();
			  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
			  driver.findElement(By.xpath("//button[@id='btnEULAAgree']")).click();
				//Thread.sleep(1000);
			    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
			  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			  
	  }
	
	  JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("return document.readyState").equals("complete");
		    //Thread.sleep(1000);
		    WebDriverWait ww= new WebDriverWait(driver,30);
		    ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AccessKey_fld_xpath)));
		  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  driver.findElement(By.xpath(AccessKey_fld_xpath)).sendKeys(Companynumber);
		  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  driver.findElement(By.xpath(Download_btn_xpath)).click();
		  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		 // Thread.sleep(500);
		  ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HomePage_NavBar)));
	  }
	  
  
 public static void VerifyAccessKeyfld(WebDriver driver,String Companynumber) throws InterruptedException{
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.manage().deleteAllCookies();
	  Thread.sleep(1000);
	  JavascriptExecutor js= (JavascriptExecutor) driver;
	    js.executeScript("return document.readyState").equals("complete");
	  WebElement AccessKeyfld =  driver.findElement(By.xpath(AccessKey_fld_xpath));
	  if(AccessKeyfld.isDisplayed()||AccessKeyfld.isEnabled()){
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.findElement(By.xpath(AccessKey_fld_xpath)).sendKeys(Companynumber);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.findElement(By.xpath(AccessKey_fld_xpath)).clear();
		  System.out.println("AccessKey field is displayed and enabled");
	  }else{
		  AssertJUnit.fail("AccessKeyfld is not Displayed");
	  }
 }
  
 public static void VerifyDownLoadBtn(WebDriver driver){
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  WebElement DownLoadBtn =  driver.findElement(By.xpath(Download_btn_xpath));
		  if(DownLoadBtn.isDisplayed()||DownLoadBtn.isEnabled()){
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.findElement(By.xpath(Download_btn_xpath)).click();
		  System.out.println("DownLoadBtn is Displayed and Enabled,User is able to Login by clicking the Download button.");
	   }else{
		   AssertJUnit.fail("DownLoadBtn is not Displayed");
	   }
   }
 
 public static void Validate_CompanyLogin(WebDriver driver,String InValidCompanyNum) throws IOException{
	  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		  JavascriptExecutor js= (JavascriptExecutor) driver;
		    js.executeScript("return document.readyState").equals("complete");
		    //Thread.sleep(1000);
		    WebDriverWait ww= new WebDriverWait(driver,30);
		    ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AccessKey_fld_xpath)));
		  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		  String CompanyNum = getValue("InValidCompanyNum");
		  if(CompanyNum.equals(InValidCompanyNum)){
		  driver.findElement(By.xpath(AccessKey_fld_xpath)).sendKeys(CompanyNum);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.findElement(By.xpath(Download_btn_xpath)).click();
		  String Error1 =driver.findElement(By.xpath(Error_Messagepart1_xpath)).getText();
		  String Error2 =driver.findElement(By.xpath(Error_Messagepart2_xpath)).getText();
		  String Error = Error1+" "+Error2;
		  if(Error.equalsIgnoreCase("ERROR! Invalid company.")){
			  System.out.println("Error message"+" "+Error+ " "+"displayed, result as expected" );
		  }else{
			  AssertJUnit.fail("Error message not displayed");
		  }
		  
		  }
 }
}
