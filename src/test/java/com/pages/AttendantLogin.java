package com.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commons.utilities;

public class AttendantLogin extends utilities{
	WebDriver driver=null;
	public static String CrewId_fld_xpath=".//*[@id='crewId']";
	public static String Add_btn_xpath=".//*[@id='btnAddCrew1']";
	 public static String CrewId_Delete_btn_xpath=".//*[@id='Crew']/li/h4/button";
	 public static String CrewId_Continue_btn_xpath=".//*[@id='btnFALogin']";
	 public static String CrewId_list_xpath=".//*[@id='Crew']/li"; 
	 public static String CrewName_xpath=".//*[@id='Crew']/li/h4";
     public static String CrewId_xpath=".//*[@id='Crew']/li/p";
	 public static String Invalid_CrewId_Message_xpath=".//*[@id='myWizard']/div/div[3]/div[1]/div/form[1]/div/span[2]";
	 
	 
	 public static void VerifyCrewIdfld(WebDriver driver,String CrewId){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);  
		 WebElement CrewIdfld = driver.findElement(By.xpath(CrewId_fld_xpath));
		 if(CrewIdfld.isDisplayed()||CrewIdfld.isEnabled()){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			 driver.findElement(By.xpath(CrewId_fld_xpath)).clear();
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 driver.findElement(By.xpath(CrewId_fld_xpath)).sendKeys(CrewId);
			 System.out.println("CrewIdfld is Displayed and Enabled");
		 }else{
			 Assert.fail("CrewIdfld not Displayed");
		 }
	 }
	 public static void VerifyAddBtn(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);  
		 WebElement AddBtn = driver.findElement(By.xpath(Add_btn_xpath));
		 if(AddBtn.isDisplayed()||AddBtn.isEnabled()){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 driver.findElement(By.xpath(Add_btn_xpath)).click();
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			 System.out.println("AddBtn is Displayed and Enabled");
		 }else{
			 Assert.fail("AddBtn not Displayed");
		 }
	 }
	 public static void VerifyDeleteBtn(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 WebElement DeleteBtn = driver.findElement(By.xpath(CrewId_Delete_btn_xpath));
		 if(DeleteBtn.isDisplayed()||DeleteBtn.isEnabled()){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			 driver.findElement(By.xpath(CrewId_Delete_btn_xpath)).click();
			 System.out.println("Delete button displayed and Enabled next to crewId");
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 }else{
			 Assert.fail("Delete button not Displayed");
		 }
	 }
	 public static void VerifyContinueBtn(WebDriver driver,String CrewId){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(CrewId_fld_xpath)).sendKeys(CrewId);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Add_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 WebElement ContinueBtn = driver.findElement(By.xpath(CrewId_Continue_btn_xpath));
		 if(ContinueBtn.isDisplayed()||ContinueBtn.isEnabled()){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);   
			 driver.findElement(By.xpath(CrewId_Continue_btn_xpath)).click();
			 System.out.println("Continue button is Displayed and Enabled");
		 }else if(!ContinueBtn.isDisplayed()){
			 System.out.println("Continue button displays after adding crewId");
		 }else{
			 Assert.fail("Continue button not Displayed");
		 }
	 }
	 
	 public static void AttendentLogin(WebDriver driver,String CrewId) throws InterruptedException{
		WebDriverWait ww = new WebDriverWait(driver,100);
		ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CrewId_fld_xpath)));
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath(CrewId_fld_xpath)).sendKeys(CrewId);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);  
		 driver.findElement(By.xpath(Add_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath(CrewId_Continue_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	 }
	 
	 public static void VerifyCrewIdAdd_Process(WebDriver driver,String CrewId){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath(CrewId_fld_xpath)).sendKeys(CrewId);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);  
		 driver.findElement(By.xpath(Add_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 String ActualCrewId= driver.findElement(By.xpath(CrewId_fld_xpath)).getText();
		 List<WebElement> crewIdlist1 = driver.findElements(By.xpath(CrewId_list_xpath)); 
		 int listsize1 = crewIdlist1.size();
		 if(ActualCrewId.equals(CrewId)||listsize1 > 0){
			 System.out.println("able to add Crew successfully and CrewId is saved");
		  }else{
			  Assert.fail("Unable to add CrewId");
		  }
		 
	   }
		 public static void VerifyCrewIdDelete_Process(WebDriver driver,String CrewId){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			 driver.findElement(By.xpath(CrewId_fld_xpath)).sendKeys(CrewId);
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);  
			 driver.findElement(By.xpath(Add_btn_xpath)).click();
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
				 driver.findElement(By.xpath(CrewId_Delete_btn_xpath)).click();
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
				 List<WebElement> crewIdlist2 = driver.findElements(By.xpath(CrewId_list_xpath)); 
				 int listsize2 = crewIdlist2.size();
				 System.out.println(listsize2);
				 if(listsize2 == 0){
					 System.out.println("able to delete crewId");
				 }else{
					  Assert.fail("Unable to delete CrewId");
				  }
				 
	      }
	 
		 public static void  Validate_CrewId_fld(WebDriver driver,String InvalidCrewid) throws IOException{
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			 driver.findElement(By.xpath(CrewId_fld_xpath)).sendKeys(InvalidCrewid);
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);  
			 driver.findElement(By.xpath(Add_btn_xpath)).click();
			 String Error = driver.findElement(By.xpath(Invalid_CrewId_Message_xpath)).getText();
			if(Error.equalsIgnoreCase("Crew member not found.")){
				System.out.println("Error message"+" "+Error+ " "+"displayed, result as expected");
			 }else{
				 Assert.fail("Error message not displayed");
			 }
			 
		}
	 
	 public static String CrewName(WebDriver driver) throws IOException{
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath(CrewId_fld_xpath)).sendKeys(getValue1("CrewId"));
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);  
		 driver.findElement(By.xpath(Add_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 String name =  driver.findElement(By.xpath(CrewName_xpath)).getText();
		 String[] string=name.split(" ");
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 String CrewName = string[0]+" "+string[1];
		// System.out.println(CrewName);
		return CrewName;
		 
	 }
	 
	 public static void Continue(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 driver.findElement(By.xpath(CrewId_Continue_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	 }
}
