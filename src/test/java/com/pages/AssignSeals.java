package com.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


//import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssignSeals {
	 WebDriver driver=null;
	 public static String SealEntry_fld_xpath=".//*[@id='sealId']";
	 public static String SealAdd_btn_xpath=".//*[@id='btnAddSeal1']";
	 public static String HighSecuritySeal_chkbx_xpath="//input[@id='sealId_HighSecurity']";
	 public static String TamperedSeal_chkbx_xpath="//input[@id='sealId_Tampered']";
	 public static String SealDelete_btn_xpath=".//*[@id='Seals']/li/h4/button";
	 public static String SealContinue_btn_xpath=".//*[@id='btnAssignSeals']";
	 public static String Seals_list_xpath = ".//*[@id='Seals']/li";
	 public static String SealType_HighSecurity_xpath=".//*[@id='Seals']/li/p";
	 public static String SealType_TamperedSeal_xpath=".//*[@id='Seals']/li/h4/span";
	 
	// static Logger log=Logger.getLogger(AssignSeals.class);
	 
	 public static void VerifySealEntryfld(WebDriver driver,String sealnum){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 WebElement SealEntryfld =  driver.findElement(By.xpath(SealEntry_fld_xpath));
		 if(SealEntryfld.isDisplayed()||SealEntryfld.isEnabled()){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath(SealEntry_fld_xpath)).sendKeys(sealnum);
		 System.out.println("SealEntryfld is Displayed and Enabled");
		 }else{
			 Assert.fail("SealEntry field is not dispalyed");
		 }
	 }
	 public static void VerifyAddBtn(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 WebElement AddBtn =  driver.findElement(By.xpath(SealAdd_btn_xpath));
		 if(AddBtn.isDisplayed()||AddBtn.isEnabled()){
			 driver.findElement(By.xpath(SealAdd_btn_xpath)).click();
			 System.out.println("AddBtn is Displayed and Enabled");
		 }else{
			 Assert.fail("Add button not displayed");
		 }
	 }
	 public static void VerifyHighSecuritySealChkBox(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 WebElement HighSecuritySealChkBox =  driver.findElement(By.xpath(HighSecuritySeal_chkbx_xpath));
		 if(HighSecuritySealChkBox.isDisplayed()||HighSecuritySealChkBox.isEnabled()){
			 driver.findElement(By.xpath(HighSecuritySeal_chkbx_xpath)).click();
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			 System.out.println("HighSecuritySealChkBox is Displayed and Enabled");
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			 driver.findElement(By.xpath(HighSecuritySeal_chkbx_xpath)).click();
		 }else{
			 Assert.fail("HighSecuritySealChkBox is not Displayed");
		 }
	 }
	 public static void VerifyTamperedSealChkBox(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 WebElement TamperedSealChkBox =  driver.findElement(By.xpath(TamperedSeal_chkbx_xpath));
		 if(TamperedSealChkBox.isDisplayed()||TamperedSealChkBox.isEnabled()){
			 driver.findElement(By.xpath(TamperedSeal_chkbx_xpath)).click();
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			 System.out.println("TamperedSealChkBox is Displayed and Enabled");
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 }else{
			 Assert.fail("TamperedSealChkBox is not Displayed");
		 }
	 }
	 public static void VerifyDeleteBtn(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 WebElement DeleteBtn = driver.findElement(By.xpath(SealDelete_btn_xpath));
		 if(DeleteBtn.isDisplayed()||DeleteBtn.isEnabled()){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			 driver.findElement(By.xpath(SealDelete_btn_xpath)).click();
			 System.out.println("Delete button is Displayed and Enabled");
		 }else{
			 Assert.fail("Delete button is not Displayed");
		 }

	 }
	 
	 public static void VerifyContinueBtn(WebDriver driver,String sealnum){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
	     driver.findElement(By.xpath(SealEntry_fld_xpath)).sendKeys(sealnum);
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    driver.findElement(By.xpath(SealAdd_btn_xpath)).click();
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 WebElement ContinueBtn = driver.findElement(By.xpath(SealContinue_btn_xpath));
		 if(ContinueBtn.isDisplayed()||ContinueBtn.isEnabled()){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);   
			 driver.findElement(By.xpath(SealContinue_btn_xpath)).click();
			 System.out.println("Continue button is Displayed and Enabled");
		 }else{
			 Assert.fail("Continue button is not displayed");
		 }
			 
	 }
	 public static void Assign_Seal(WebDriver driver,String sealnum){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath(SealEntry_fld_xpath)).sendKeys(sealnum);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(SealAdd_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);  
		 driver.findElement(By.xpath(SealContinue_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	 }
	 
	 public static void SealAdd_process(WebDriver driver,String sealnum){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath(SealEntry_fld_xpath)).sendKeys(sealnum);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(SealAdd_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 List<WebElement> seals = driver.findElements(By.xpath(Seals_list_xpath)); 
		 int listsize1 = seals.size();
		 if(listsize1 > 0){
			 System.out.println("able to add seal successfully and seal is saved");
		   }else{
			   Assert.fail("unable to add seal");
		   }
	}
	 public static void Verify_HighSecuritySealAdd(WebDriver driver,String sealnum){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath(SealEntry_fld_xpath)).sendKeys(sealnum);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);  
		 driver.findElement(By.xpath(HighSecuritySeal_chkbx_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath(SealAdd_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 List<WebElement> seals = driver.findElements(By.xpath(Seals_list_xpath)); 
		 String SealType =  driver.findElement(By.xpath(SealType_HighSecurity_xpath)).getAttribute("data-bind");
		 int listsize2 = seals.size();
		 if(listsize2 > 0||SealType.equalsIgnoreCase("visible: HighSecurity")){
			 System.out.println("able to add HighSecuritySeal successfully and seal is saved");
		 }else{
			 Assert.fail("Unable to add HighSecuritySeal");
		 }
	 }
	 public static void Verify_TamperedSealAdd(WebDriver driver,String sealnum){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath(SealEntry_fld_xpath)).sendKeys(sealnum);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);  
		 driver.findElement(By.xpath(TamperedSeal_chkbx_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath(SealAdd_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 List<WebElement> seals = driver.findElements(By.xpath(Seals_list_xpath)); 
		 int listsize3 = seals.size();
		 String SealType =  driver.findElement(By.xpath(SealType_TamperedSeal_xpath)).getAttribute("data-bind");
		 if(listsize3 > 0||SealType.equalsIgnoreCase("visible: Tampered")){
			 System.out.println("able to add TamperedSeal successfully and seal is saved");
		 }else{
			 Assert.fail("Unable to add TamperedSeal");
		 }
	 }
	 public static void Verify_TamperedHighSecuritySealAdd(WebDriver driver,String sealnum){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath(SealEntry_fld_xpath)).sendKeys(sealnum);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);  
		 driver.findElement(By.xpath(HighSecuritySeal_chkbx_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(TamperedSeal_chkbx_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath(SealAdd_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 List<WebElement> seals = driver.findElements(By.xpath(Seals_list_xpath)); 
		 int listsize = seals.size();
		 String Type1=driver.findElement(By.xpath(SealType_HighSecurity_xpath)).getAttribute("data-bind");
		 String Type2=driver.findElement(By.xpath(SealType_TamperedSeal_xpath)).getAttribute("data-bind");
		 if(listsize > 0||Type1.equalsIgnoreCase("visible: HighSecurity")||Type2.equalsIgnoreCase("visible: Tampered")){
			 System.out.println("able to add TamperedHighSecuritySeal successfully and seal is saved");
		 }else{
			 Assert.fail("Unable to add TamperedHighSecuritySeal");
		 }
	 }
	 public static void DeleteSeal(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(SealDelete_btn_xpath)).click();
		 List<WebElement> seals = driver.findElements(By.xpath(Seals_list_xpath)); 
		 int listsize = seals.size();
		 if(listsize == 0){
			 System.out.println("able to delete Seal successfully");
		   }else{
			   Assert.fail("Unable to delete Seal");
		   }
		 }
	 
	 public static void Verify_Seals_Being_Pulled_From_Portal(WebDriver driver){
		 List<WebElement> seals = driver.findElements(By.xpath(Seals_list_xpath)); 
		 int listsize1 = seals.size();
		 if(listsize1 > 0){
			 System.out.println("seals are pulled from portal");
		   }else{
			   Assert.fail("Seals not pulled from portal");
		   }
	 }
	 
	 public static void Continue(WebDriver driver) throws IOException{
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 WebElement continuebutton= driver.findElement(By.xpath(SealContinue_btn_xpath));
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 js.executeScript("arguments[0].click();", continuebutton);
		 //driver.findElement(By.xpath(CashBag_Continue_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}
}
