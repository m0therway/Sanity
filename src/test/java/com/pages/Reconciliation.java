package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.commons.common;

public class Reconciliation {
	
	public static String ReconciliationDashBoard_tableRows = "html/body/div[1]/div/div[1]/div/table/tbody/tr";
	public static String StoreInstanceSelectbox_firstxpath = "html/body/div[1]/div/div[1]/div/table/tbody/tr";
	public static String StoreInstanceSelectbox_secondxpath = "/td[1]/input";
	public static String StoreNumber_firstxpath = "html/body/div[1]/div/div[1]/div/table/tbody/tr";
	public static String StoreNumber_secondxpath = "/td[3]";
	public static String Status_firstxpath = "html/body/div[1]/div/div[1]/div/table/tbody/tr";
	public static String Status_secondxpath = "/td[11]";
	public static String viewReviewInstance_btn_firstxpath = "html/body/div[1]/div/div[1]/div/table/tbody/tr";
	public static String viewReviewInstance_btn__secondxpath = "/td[14]/button[7]";
	public static String Validate_btn_xpath = "html/body/div[1]/div/div[1]/div/div[1]/div/div[2]/button[1]";
	public static String PayCommission_btn_xpath = "html/body/div[1]/div/div[1]/div/div[1]/div/div[2]/button[2]";
	public static String Modalbox_xpath = "html/body/div[1]/div/div[2]/div";
	public static String Continue_btn_xpath = "html/body/div[1]/div/div[2]/div/div/div[3]/button[1]";
	
    public static int rows(WebDriver driver){
    	int rows = driver.findElements(By.xpath(ReconciliationDashBoard_tableRows)).size();
       return rows;
    }
	
	public static void View_ReviewInstance(WebDriver driver,String StoreNumber,String InstanceStatus){
	 int rows = Reconciliation.rows(driver)	;
	if(rows >1){
		for(int i=1;i<=rows;i++){
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String StoreNum = driver.findElement(By.xpath(StoreNumber_firstxpath+"["+i+"]"+StoreNumber_secondxpath)).getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String Status = driver.findElement(By.xpath(Status_firstxpath+"["+i+"]"+Status_secondxpath)).getText();
		if(StoreNum.equals(StoreNumber) && Status.equals(InstanceStatus)){
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath(viewReviewInstance_btn_firstxpath+"["+i+"]"+viewReviewInstance_btn__secondxpath)).click();
		}
		}
	}else{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String StoreNum = driver.findElement(By.xpath(StoreNumber_firstxpath+StoreNumber_secondxpath)).getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String Status = driver.findElement(By.xpath(Status_firstxpath+Status_secondxpath)).getText();
		if(StoreNum.equals(StoreNumber) && Status.equals(InstanceStatus)){
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath(viewReviewInstance_btn_firstxpath+viewReviewInstance_btn__secondxpath)).click();
		}
	}
    }


    public static void Validate_Instance(WebDriver driver,String StoreNumber,String InstanceStatus){
    	int rows = Reconciliation.rows(driver)	;
    	if(rows >1){
    		for(int i=1;i<=rows;i++){
    			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    		String StoreNum = driver.findElement(By.xpath(StoreNumber_firstxpath+"["+i+"]"+StoreNumber_secondxpath)).getText();
    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    		String Status = driver.findElement(By.xpath(Status_firstxpath+"["+i+"]"+Status_secondxpath)).getText();
    		if(StoreNum.equals(StoreNumber) && Status.equals(InstanceStatus)){
    			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    			driver.findElement(By.xpath(StoreInstanceSelectbox_firstxpath+"["+i+"]"+StoreInstanceSelectbox_secondxpath)).click();
    			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    			driver.findElement(By.xpath(Validate_btn_xpath)).click();
    			common.Wait_Until_ElementVisible(driver, Modalbox_xpath);
    			common.switchControlToLatestWindow(driver);
    			driver.findElement(By.xpath(Continue_btn_xpath)).click();
    		 }
    		}
    	}else{
    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    		String StoreNum = driver.findElement(By.xpath(StoreNumber_firstxpath+StoreNumber_secondxpath)).getText();
    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    		String Status = driver.findElement(By.xpath(Status_firstxpath+Status_secondxpath)).getText();
    		if(StoreNum.equals(StoreNumber) && Status.equals(InstanceStatus)){
    			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    			driver.findElement(By.xpath(StoreInstanceSelectbox_firstxpath+StoreInstanceSelectbox_secondxpath)).click();
    			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    			driver.findElement(By.xpath(Validate_btn_xpath)).click();
    			common.Wait_Until_ElementVisible(driver, Modalbox_xpath);
    			common.switchControlToLatestWindow(driver);
    			driver.findElement(By.xpath(Continue_btn_xpath)).click();
    		}
    	}
    }


   public static void PayCommission(WebDriver driver,String StoreNumber,String InstanceStatus){
	   int rows = Reconciliation.rows(driver);
   	if(rows >1){
   		for(int i=1;i<=rows;i++){
   			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   		String StoreNum = driver.findElement(By.xpath(StoreNumber_firstxpath+"["+i+"]"+StoreNumber_secondxpath)).getText();
   		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   		String Status = driver.findElement(By.xpath(Status_firstxpath+"["+i+"]"+Status_secondxpath)).getText();
   		if(StoreNum.equals(StoreNumber) && Status.equals(InstanceStatus)){
   			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   			driver.findElement(By.xpath(StoreInstanceSelectbox_firstxpath+"["+i+"]"+StoreInstanceSelectbox_secondxpath)).click();
   			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   			driver.findElement(By.xpath(PayCommission_btn_xpath)).click();
   			common.Wait_Until_ElementVisible(driver, Modalbox_xpath);
   			common.switchControlToLatestWindow(driver);
   			driver.findElement(By.xpath(Continue_btn_xpath)).click();
   		 }
   		}
   	}else{
   		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   		String StoreNum = driver.findElement(By.xpath(StoreNumber_firstxpath+StoreNumber_secondxpath)).getText();
   		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   		String Status = driver.findElement(By.xpath(Status_firstxpath+Status_secondxpath)).getText();
   		if(StoreNum.equals(StoreNumber) && Status.equals(InstanceStatus)){
   			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   			driver.findElement(By.xpath(StoreInstanceSelectbox_firstxpath+StoreInstanceSelectbox_secondxpath)).click();
   			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   			driver.findElement(By.xpath(PayCommission_btn_xpath)).click();
   			common.Wait_Until_ElementVisible(driver, Modalbox_xpath);
   			common.switchControlToLatestWindow(driver);
   			driver.findElement(By.xpath(Continue_btn_xpath)).click();
   		}
   	}
   } 



}
