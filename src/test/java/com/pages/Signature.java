package com.pages;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.commons.common;
import com.commons.utilities;

public class Signature extends utilities {
	
	//public static String Signature_Canvas_xpath=".//*[@id='Signature']/canvas";
//	public static String Agreed_Chkbx_xpath=".//*[@id='agreed']";
	
	//public static String Clear_Btn_xpath="//button[text()='Clear']";
	public static String CloseSector_element_disabled="button[disabled]";
	public static String CloseSector_element_enabled="button:not([disabled])";
//	public static String CloseSector_Btn_xpath="//button[text()='Close Sector']";
	//public static String Cancel_btn_xpath=".//*[@id='Body']/header/h1/button";
	public static String Confirmation_Cancel_Alert_XPATH=".//*[@id='Body']/div[2]/div";
	public static String Confirmation_Cancel_Alert_title_xpath=".//*[@id='Body']/div[2]/div/div/div[1]/h4/h3";
	public static String Confirmation_Cancel_Alert_Yes_button_xpath=".//*[@id='Body']/div[2]/div/div/div[3]/button[text()='Yes']" ;
	public static String Confirmation_Cancel_Alert_No_button_xpath=".//*[@id='Body']/div[2]/div/div/div[3]/button[text()='No']" ;
	public static String Cancel_ConfimationMessage_xpath=".//*[@id='Body']/div[2]/div/div/div[2]/div";
	public static String Signed_Crew_Name_xpath="//section/h2/small";
	//public static String ConfirmationSign_popup_xpath=".//*[@id='Modal1']/div";
	public static String Signaturebox_xpath=".//*[@id='Signature']";
	public static String Agreed_Chkbx_xpath=".//*[@id='agreed']";
	public static String Signature_Canvas_xpath=".//*[@id='Signature']/canvas";
	public static String CloseSector_Btn_xpath=".//*[@id='btnConfirmed']";
	public static String Cancel_btn_xpath=".//*[@id='ModalBodySignature']/div/div[3]/button[2]";
	public static String Clear_Btn_xpath=".//*[@id='ModalBodySignature']/div/div[1]/h2/button";
	public static String Signature_Accept_btn_xpath=".//*[@id='signatureAccept']";
	
	
	
	public static void Verify_CloseSector_btnStatusBeforeAgreementReview(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement button=driver.findElement(By.xpath(CloseSector_Btn_xpath));
		Assert.assertFalse(button.isEnabled());
			System.out.println("Before agreement review CloseSector_Btn is displayed and disabled");
		
	}
	public static void Verify_CloseSector_btnStatusAfterAgreementReview(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Signature.InformationReview(driver);
		WebElement button=driver.findElement(By.xpath(CloseSector_Btn_xpath));
		if(button.isDisplayed()||button.isEnabled()){
			System.out.println("After agreement review CloseSector_Btn is displayed and enabled");
		}else{
			Assert.fail("After agreement review CloseSector_Btn should be enabled");
		}
	}
	public static void Sign(WebDriver driver){
		common.Wait_Until_ElementVisible(driver, Signaturebox_xpath);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//common.switchControlToLatestWindow(driver);
		driver.findElement(By.xpath(Signature_Canvas_xpath)).click();
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}
    public static void InformationReview(WebDriver driver){
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	driver.findElement(By.xpath(Agreed_Chkbx_xpath)).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
    
    public static void Clear_Signature(WebDriver driver){
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	driver.findElement(By.xpath(Clear_Btn_xpath)).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
   	}
    
    public static void Verify_Signature_cleared(WebDriver driver){
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement button=driver.findElement(By.xpath(CloseSector_Btn_xpath));
		
		if(button.isEnabled()){
			Assert.fail("Signature not cleared");
		}else{
			System.out.println("Signature cleared");
		}
    }
    
    public static void Verify_Crew_signature(WebDriver driver) throws Exception{
    	Thread.sleep(500);
		WebElement button=driver.findElement(By.xpath(CloseSector_Btn_xpath));
		Assert.assertTrue(button.isEnabled());
		System.out.println("Crew is able to sign");
    }
    public static void Accept_Signature(WebDriver driver){
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	driver.findElement(By.xpath(Signature_Accept_btn_xpath)).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
   	}
    public static void Verify_Clear_button(WebDriver driver){
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement Clearbutton=driver.findElement(By.xpath(Clear_Btn_xpath));
		//WebElement disabled= driver.findElement(By.cssSelector(CloseSector_element_disabled));
		//WebElement enabled = driver.findElement(By.cssSelector(CloseSector_element_enabled));
		if(Clearbutton.isDisplayed()||Clearbutton.isEnabled()){
			System.out.println("Clearbutton is displayed and enabled");
		}else{
			Assert.fail("Clearbutton is  not displayed");
		}
    }
    
    public static void Verify_Agreed_Chkbx(WebDriver driver){
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement Agreed_Chkbx=driver.findElement(By.xpath(Agreed_Chkbx_xpath));
		//WebElement disabled= driver.findElement(By.cssSelector(CloseSector_element_disabled));
		//WebElement enabled = driver.findElement(By.cssSelector(CloseSector_element_enabled));
		if(Agreed_Chkbx.isDisplayed()||Agreed_Chkbx.isEnabled()){
			System.out.println("Agreed_Chkbx is displayed and enabled");
		}else{
			Assert.fail("Agreed_Chkbx is  not displayed");
		}
    }
    public static void Verify_Cancel_button(WebDriver driver){
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement Cancelbutton=driver.findElement(By.xpath(Cancel_btn_xpath));
		//WebElement disabled= driver.findElement(By.cssSelector(CloseSector_element_disabled));
		//WebElement enabled = driver.findElement(By.cssSelector(CloseSector_element_enabled));
		if(Cancelbutton.isDisplayed()||Cancelbutton.isEnabled()){
			System.out.println("Cancelbutton is displayed and enabled");
		}else{
			Assert.fail("CloseSector_Btn is  not displayed");
		}
    }
    
    public static String Required__signatureCrewName(WebDriver driver){
    	String name = driver.findElement(By.xpath(Signed_Crew_Name_xpath)).getText();
    	String[] String = name.split("\\(");
    	String[] String1=String[1].split("\\)");
    	String CrewName = String1[0];
    //	System.out.println(CrewName);
    	return CrewName;
    }
    
    public static void Verify_Signed_CrewName(WebDriver driver,String seal,String cashbag,String CurrencyType,String Amount) throws InterruptedException, IOException{
      String ExpectedCrewName = EPOS_DashBoard.Selected_Crew(driver);
     	CloseFlight.Close_Flight(driver);
     	CloseFlight.Accept_CloseBarset_popup(driver);
       	CloseFlight.CloseShop_Device_Sync(driver);
     	CloseFlight_Inventory1.CloseShop_Inventory_Continue(driver);
     	CloseFlight_Seal.CloseShop_SealEntry(driver,seal);
     	CloseFlight_Seal.CloseShop_Seal_Continue(driver);
     	CloseFlight_CashCount.Cashbag(driver, cashbag);
     	Thread.sleep(1000);
    	CloseFlight_CashCount.CashBag_CurrencyEntry(driver,CurrencyType, Amount);
    	CloseFlight_CashCount.Continue(driver);
     	CloseFlight_CashCount.Accept_CashCountPopUp(driver);
     	CloseFlight_Confirmation.Continue(driver);
     	String ActualCrewName = Signature.Required__signatureCrewName(driver);
     	if(ExpectedCrewName.contains(ActualCrewName)){
     		System.out.println("Required Signature of Crew name is:"+" "+ ActualCrewName);
     	}else{
     		Assert.fail("Required Signature Crew name is different");
     	}
    }
    public static void Verify_Signature_Canvas(WebDriver driver){
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement Signature_Canvas=driver.findElement(By.xpath(Signature_Canvas_xpath));
		//WebElement disabled= driver.findElement(By.cssSelector(CloseSector_element_disabled));
		//WebElement enabled = driver.findElement(By.cssSelector(CloseSector_element_enabled));
		if(Signature_Canvas.isDisplayed()||Signature_Canvas.isEnabled()){
			System.out.println("Signature_Canvas is displayed and enabled");
		}else{
			Assert.fail("Signature_Canvas not displayed");
		}
    }
    public static void Verify_Confirmation_Cancel_Alert(WebDriver driver){
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	driver.findElement(By.xpath(Cancel_btn_xpath)).click();
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement Alert=driver.findElement(By.xpath(Confirmation_Cancel_Alert_XPATH));
		//WebElement disabled= driver.findElement(By.cssSelector(CloseSector_element_disabled));
		//WebElement enabled = driver.findElement(By.cssSelector(CloseSector_element_enabled));
		if(Alert.isDisplayed()){
			String ExpectedMessage="Please confirm cancellation of close process for Flight";
			String message = driver.findElement(By.xpath(Cancel_ConfimationMessage_xpath)).getText();
			WebElement Yes=driver.findElement(By.xpath(Confirmation_Cancel_Alert_Yes_button_xpath));
			WebElement No=driver.findElement(By.xpath(Confirmation_Cancel_Alert_No_button_xpath));
			if(message.equalsIgnoreCase(ExpectedMessage)||Yes.isDisplayed()||No.isDisplayed()){
				System.out.println("Message and Yes, No options ar displayed in the alert");
			}
		}else{
			Assert.fail("Alert not displayed");
		}
    }
    
   
}
