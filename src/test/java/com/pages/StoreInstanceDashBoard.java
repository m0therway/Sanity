package com.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.commons.actions;
import com.commons.common;
import com.commons.utilities;

public class StoreInstanceDashBoard extends utilities {
	 WebDriver driver = null;
	// public static String Filter_btn_xpath="html/body/div[1]/div/div[1]/div[1]/div/div/div[2]/button[2]/span[2]";
	 public static String Filter_btn_xpath="html/body/div[1]/div/div[1]/div[1]/div/div/div[2]/button";
	 public static String StoreNum_fld_xpath="//input[@name='storeNumber']";
	 public static String Dispatch_LMP_dpdn_xpath="//div/select[@name='dispatchLMPStation']";
	 public static String Inbound_LMP_dpdn_xpath="//div/select[@name='inboundLMPStation']";
	 public static String ScheduleDateFrom_fld_xpath="//input[@name='Schedule Date From']";
	 public static String ScheduleDateTo_fld_xpath="//input[@name='Schedule Date To']";
	 public static String StoreInstance_fld_xpath="//input[@name='storeInstance']";
	 public static String Search_btn_xpath="//button[@ng-click='searchStoreInstanceDashboardData()']";
	 public static String StoreInstanceList_xpath="html/body/div[1]/div/div[1]/table/tbody/tr";
	 public static String lmp_firstxpath="html/body/div[1]/div/div[1]/table/tbody";
	 public static String lmp_secondxpath="/tr";
	 public static String lmp_thirdxpath="/td[3]";
	 public static String StoreInstance_firstxpath="html/body/div[1]/div/div[1]/table/tbody";
	 public static String StoreInstance_secondxpath="/tr";
	 public static String StoreInstance_thirdxpath="/td[5]";
	 public static String ScheduleDate_firstxpath="html/body/div[1]/div/div[1]/table/tbody";
	 public static String ScheduleDate_secondxpath="/tr";
	 public static String ScheduleDate_thirdxpath="/td[6]/span/span[3]/strong";	 
	 public static String StoreNum_firstxpath="html/body/div[1]/div/div[1]/table/tbody";
	 public static String StoreNum_secondxpath="/tr";
	 public static String StoreNum_thirdxpath="/td[8]";
	 public static String Replenish_link_firstxpath="html/body/div[1]/div/div[1]/table/tbody";
	 public static String Replenish_link_secondxpath="/tr";
	 public static String Replenish_link_thirdxpath="/td[12]/a[8]";	 
	 public static String GenerateDoc_link_firstxpath="html/body/div[1]/div/div[1]/table/tbody";
	 public static String GenerateDoc_link_secondxpath="/tr";
	 public static String GenerateDoc_link_thirdxpath="/td[12]/a[7]";
	 public static String Receive_link_firstxpath="html/body/div[1]/div/div[1]/table/tbody";
	 public static String Receive_link_secondxpath="/tr";
	 public static String Receive_link_thirdxpath="/td[12]/a[9]";
	 public static String ReceiveConfirm_popup_Yes_btn_xpath="/html/body/div[1]/div/div[2]/div/div/div[3]/button[1]";
	 public static String ReDispatch_link_firstxpath="html/body/div[1]/div/div[1]/table/tbody";
	 public static String ReDispatch_link_secondxpath="/tr";
	 public static String ReDispatch_link_thirdxpath="/td[12]/a[6]";
	 public static String StoreInstance_Status_firstxpath="html/body/div[1]/div/div[1]/table/tbody";
	 public static String StoreInstance_Status_secondxpath="/tr";
	 public static String StoreInstance_Status_thirdxpath="/td[9]";
	 public static String StartPacking_link_firstxpath="html/body/div[1]/div/div[1]/table/tbody";
	 public static String StartPacking_link_secondxpath="/tr";
	 public static String StartPacking_link_thirdxpath="/td[12]/a[1]";
	 public static String StartSeals_link_firstxpath="html/body/div[1]/div/div[1]/table/tbody";
	 public static String StartSeals_link_secondxpath="/tr";
	 public static String StartSeals_link_thirdxpath="/td[12]/a[2]";
	 public static String Dispatch_link_firstxpath="html/body/div[1]/div/div[1]/table/tbody";
	 public static String Dispatch_link_secondxpath="/tr";
	 public static String Dispatch_link_thirdxpath="/td[12]/a[3]";
	 public static String UnDispatch_link_firstxpath="html/body/div[1]/div/div[1]/table/tbody";
	 public static String UnDispatch_link_secondxpath="/tr";
	 public static String UnDispatch_link_thirdxpath="/td[12]/a[5]";
	 public static String EndInstance_link_firstxpath="html/body/div[1]/div/div[1]/table/tbody";
	 public static String EndInstance_link_secondxpath="/tr";
	 public static String EndInstance_link_thirdxpath="/td[12]/a[4]";
	 public static String StoreInstanceDashBoarTable_xpath="html/body/div[1]/div/div[1]/table";
	 public static String Receive_Confirmpopup_xpath=".//*[@id='receive-confirm']";
	 
	 public static void switchControlToLatestWindow(WebDriver driver) {
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	
	 }
	 
	 public static void  Wait_Until_ModelBox_Disappears(WebDriver driver){
		 WebDriverWait ww = new WebDriverWait(driver,70);
			ww.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("html/body/loading-modal/div/div/div/div/p")));
	 }
	 public static int StoreInstanceListCount(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		int count=driver.findElements(By.xpath(StoreInstanceList_xpath)).size();
		//System.out.println(count);
		return count;
	 }
	 
	 public static String StoreInstance(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		 int count = StoreInstanceDashBoard.StoreInstanceListCount(driver);
		// System.out.println(count);
		 String StoreInstance=null;
		 if(count > 1){
			 for(int i=1;i<=count;i++){
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				 StoreInstance = driver.findElement(By.xpath(StoreInstance_firstxpath+"["+i+"]"+StoreInstance_secondxpath+"["+i+"]"+StoreInstance_thirdxpath)).getText();
				// System.out.println(StoreInstance);
			 }
		 }else{
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 StoreInstance = driver.findElement(By.xpath(StoreInstance_firstxpath+StoreInstance_secondxpath+StoreInstance_thirdxpath)).getText();
			// System.out.println(StoreInstance); 
		 }
		return StoreInstance;
		 
	 }
	 public static String ScheduleDate(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		 int count = StoreInstanceDashBoard.StoreInstanceListCount(driver);
		 String Date=null;
		 if(count > 1){
			 for(int i=1;i<=count;i++){
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			String	 Date1 = driver.findElement(By.xpath(ScheduleDate_firstxpath+"["+i+"]"+ScheduleDate_secondxpath+"["+i+"]"+ScheduleDate_thirdxpath)).getText();
				 String[] string1=Date1.split(":");
				 Date=string1[1].trim();
				// System.out.println(Date);
			 }
		 }else{
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 String	 Date1 = driver.findElement(By.xpath(ScheduleDate_firstxpath+ScheduleDate_secondxpath+ScheduleDate_thirdxpath)).getText();
			 String[] string1=Date1.split(":");
			 Date=string1[1].trim();
			// System.out.println(Date); 
		 }
		return Date;
		 
	 }
	 public static String LMP(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		 int count = StoreInstanceDashBoard.StoreInstanceListCount(driver);
		 String LMP=null;
		 if(count > 1){
			 for(int i=1;i<=count;i++){
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				 LMP = driver.findElement(By.xpath(lmp_firstxpath+"["+i+"]"+lmp_secondxpath+"["+i+"]"+lmp_thirdxpath)).getText();
				// System.out.println(LMP);
			 }
		 }else{
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 LMP = driver.findElement(By.xpath(lmp_firstxpath+lmp_secondxpath+lmp_thirdxpath)).getText();
			// System.out.println(LMP); 
		 }
		return LMP;
		 
	 }
	 public static String StoreNum(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		 int count = StoreInstanceDashBoard.StoreInstanceListCount(driver);
		 String StoreNum=null;
		 if(count > 1){
			 for(int i=1;i<=count;i++){
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				 StoreNum = driver.findElement(By.xpath(StoreNum_firstxpath+"["+i+"]"+StoreNum_secondxpath+"["+i+"]"+StoreNum_thirdxpath)).getText();
			//	 System.out.println(StoreNum);
			 }
		 }else{
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 StoreNum = driver.findElement(By.xpath(StoreNum_firstxpath+StoreNum_secondxpath+StoreNum_thirdxpath)).getText();
			// System.out.println(StoreNum); 
		 }
		return StoreNum;
		 
	 }
	 
	 
	 public static String StoreInstance_Status(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		 int count = StoreInstanceDashBoard.StoreInstanceListCount(driver);
		 String Status=null;
		 if(count > 1){
			 for(int i=1;i<=count;i++){
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				 Status = driver.findElement(By.xpath(StoreInstance_Status_firstxpath+"["+i+"]"+StoreInstance_Status_secondxpath+"["+i+"]"+StoreInstance_Status_thirdxpath)).getText();
				// System.out.println(Status);
				
			 }
		 }else{
			
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 Status = driver.findElement(By.xpath(StoreInstance_Status_firstxpath+StoreInstance_Status_secondxpath+StoreInstance_Status_thirdxpath)).getText();
			// System.out.println(Status); 
			
		 }
		return Status;
		 
	 }
	 public static  void Replenish(WebDriver driver,String StoreInstance){
		 StoreInstanceDashBoard.Wait_Until_ModelBox_Disappears(driver);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		 int count = StoreInstanceDashBoard.StoreInstanceListCount(driver);
		 String Instance=StoreInstanceDashBoard.StoreInstance(driver);
		 if(count > 1){
			 for(int i=1;i<=count;i++){
				 if(StoreInstance.equals(Instance)){
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				 driver.findElement(By.xpath(Replenish_link_firstxpath+"["+i+"]"+Replenish_link_secondxpath+"["+i+"]"+Replenish_link_thirdxpath)).click();
				 }else{
					 System.out.println("StoreInstance not found or replenish link does not exists");
				 }
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 }
		 }else{
			 if(StoreInstance.equals(Instance)){
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 driver.findElement(By.xpath(Replenish_link_firstxpath+Replenish_link_secondxpath+Replenish_link_thirdxpath)).click();
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 }else{
				 System.out.println("StoreInstance not found or replenish link does not exists");
			 }
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		 }
		 
	 }
	 
	 
	 
	 public static  void GenerateDocS(WebDriver driver,String StoreInstance){
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		 int count = StoreInstanceDashBoard.StoreInstanceListCount(driver);
		 String Instance=StoreInstanceDashBoard.StoreInstance(driver);
		 if(count > 1){
			 for(int i=1;i<=count;i++){
				 if(StoreInstance.equals(Instance)){
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				 driver.findElement(By.xpath(GenerateDoc_link_firstxpath+"["+i+"]"+GenerateDoc_link_secondxpath+"["+i+"]"+GenerateDoc_link_thirdxpath)).click();
				 }else{
					 System.out.println("StoreInstance not found or GenerateDoc link does not exists");
				 }
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 }
		 }else{
			 if(StoreInstance.equals(Instance)){
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 driver.findElement(By.xpath(GenerateDoc_link_firstxpath+GenerateDoc_link_secondxpath+GenerateDoc_link_thirdxpath)).click();
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 }else{
				 System.out.println("StoreInstance not found or GenerateDoc link does not exists");
			 }
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		 }
		 
	 }
	 
	 public static void ConfirmReceive(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 common.Wait_Until_ElementVisible(driver, Receive_Confirmpopup_xpath);
		 common.Wait_Until_ElementVisible(driver, ReceiveConfirm_popup_Yes_btn_xpath);
		 common.Wait_Until_ElementClickable(driver, ReceiveConfirm_popup_Yes_btn_xpath);
		// StoreInstanceDashBoard.switchControlToLatestWindow(driver);
		 driver.findElement(By.xpath(ReceiveConfirm_popup_Yes_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		 
	 }
	 public static void Receive(WebDriver driver,String StoreInstance){
		 StoreInstanceDashBoard.Wait_Until_ModelBox_Disappears(driver);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		 int count = StoreInstanceDashBoard.StoreInstanceListCount(driver);
		 String Instance=StoreInstanceDashBoard.StoreInstance(driver);
		 if(count > 1){
			 for(int i=1;i<=count;i++){
				 if(StoreInstance.equals(Instance)){
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				 driver.findElement(By.xpath(Receive_link_firstxpath+"["+i+"]"+Receive_link_secondxpath+"["+i+"]"+Receive_link_thirdxpath)).click();
				 }else{
					 System.out.println("StoreInstance not found or Receive link does not exists");
				 }
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 }
		 }else{
			 if(StoreInstance.equals(Instance)){
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 driver.findElement(By.xpath(Receive_link_firstxpath+Receive_link_secondxpath+Receive_link_thirdxpath)).click();
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 }else{
				 System.out.println("StoreInstance not found or Receive link does not exists");
			 }
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		 }
		 
		 StoreInstanceDashBoard.ConfirmReceive(driver);
		 
		 
	 }
	 
	  public static void StartPacking(WebDriver driver,String StoreInstance){
		  StoreInstanceDashBoard.Wait_Until_ModelBox_Disappears(driver);
	    	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 int count = StoreInstanceDashBoard.StoreInstanceListCount(driver);
			 String Instance=StoreInstanceDashBoard.StoreInstance(driver);
			 if(count > 1){
				 for(int i=1;i<=count;i++){
					 if(StoreInstance.equals(Instance)){
					 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
					 driver.findElement(By.xpath(StartPacking_link_firstxpath+"["+i+"]"+StartPacking_link_secondxpath+"["+i+"]"+StartPacking_link_thirdxpath)).click();
					 }else{
						 System.out.println("StoreInstance not found or StartPacking link does not exists");
					 }
					 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				 }
			 }else{
				 if(StoreInstance.equals(Instance)){
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				 driver.findElement(By.xpath(StartPacking_link_firstxpath+StartPacking_link_secondxpath+StartPacking_link_thirdxpath)).click();
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				 }else{
					 System.out.println("StoreInstance not found or StartPacking link does not exists");
				 }
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 } 
		 }
	  
	  public static void StartSeals(WebDriver driver,String StoreInstance){
		  StoreInstanceDashBoard.Wait_Until_ModelBox_Disappears(driver);
	    	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 int count = StoreInstanceDashBoard.StoreInstanceListCount(driver);
			 String Instance=StoreInstanceDashBoard.StoreInstance(driver);
			 if(count > 1){
				 for(int i=1;i<=count;i++){
					 if(StoreInstance.equals(Instance)){
					 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
					 driver.findElement(By.xpath(StartSeals_link_firstxpath+"["+i+"]"+StartSeals_link_secondxpath+"["+i+"]"+StartSeals_link_thirdxpath)).click();
					 }else{
						 System.out.println("StoreInstance  not found or StartSeals link does not exists");
					 }
					 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				 }
			 }else{
				 if(StoreInstance.equals(Instance)){
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				 driver.findElement(By.xpath(StartSeals_link_firstxpath+StartSeals_link_secondxpath+StartSeals_link_thirdxpath)).click();
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				 }else{
					 System.out.println("StoreInstance not found or StartSeals link does not exists");
				 }
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 } 
		 }
	  public static void Dispatch(WebDriver driver,String StoreInstance){
		  StoreInstanceDashBoard.Wait_Until_ModelBox_Disappears(driver);
	    	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 int count = StoreInstanceDashBoard.StoreInstanceListCount(driver);
			 String Instance=StoreInstanceDashBoard.StoreInstance(driver);
			 if(count > 1){
				 for(int i=1;i<=count;i++){
					 if(StoreInstance.equals(Instance)){
					 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
					 common.Wait_Until_ElementClickable(driver, Dispatch_link_firstxpath+"["+i+"]"+Dispatch_link_secondxpath+"["+i+"]"+Dispatch_link_thirdxpath);
					 driver.findElement(By.xpath(Dispatch_link_firstxpath+"["+i+"]"+Dispatch_link_secondxpath+"["+i+"]"+Dispatch_link_thirdxpath)).click();
					 }else{
						 System.out.println("StoreInstance not found or Dispatch link does not exists");
					 }
					 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				 }
			 }else{
				 if(StoreInstance.equals(Instance)){
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				
				 driver.findElement(By.xpath(Dispatch_link_firstxpath+Dispatch_link_secondxpath+Dispatch_link_thirdxpath)).click();
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				 }else{
					 System.out.println("StoreInstance not found or Dispatch link does not exists");
				 }
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 } 
		 }
		 
     public static void ReDispatch(WebDriver driver,String StoreInstance){
    	 StoreInstanceDashBoard.Wait_Until_ModelBox_Disappears(driver);    
    	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		 int count = StoreInstanceDashBoard.StoreInstanceListCount(driver);
		 String Instance=StoreInstanceDashBoard.StoreInstance(driver);
		 if(count > 1){
			 for(int i=1;i<=count;i++){
				 if(StoreInstance.equals(Instance)){
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				 driver.findElement(By.xpath(ReDispatch_link_firstxpath+"["+i+"]"+ReDispatch_link_secondxpath+"["+i+"]"+ReDispatch_link_thirdxpath)).click();
				 }else{
					 System.out.println("StoreInstance not found or ReDispatch link does not exists");
				 }
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 }
		 }else{
			 if(StoreInstance.equals(Instance)){
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 driver.findElement(By.xpath(ReDispatch_link_firstxpath+ReDispatch_link_secondxpath+ReDispatch_link_thirdxpath)).click();
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 }else{
				 System.out.println("StoreInstance not found or ReDispatch link does not exists");
			 }
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		 } 
	 }
	 
     
     public static void EndInstance(WebDriver driver,String StoreInstance){
		StoreInstanceDashBoard.Wait_Until_ModelBox_Disappears(driver);
	    	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 int count = StoreInstanceDashBoard.StoreInstanceListCount(driver);
			 String Instance=StoreInstanceDashBoard.StoreInstance(driver);
			 if(count > 1){
				 for(int i=1;i<=count;i++){
					 if(StoreInstance.equals(Instance)){
					 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
					 driver.findElement(By.xpath(EndInstance_link_firstxpath+"["+i+"]"+EndInstance_link_secondxpath+"["+i+"]"+EndInstance_link_thirdxpath)).click();
					 }else{
						 System.out.println("StoreInstance not found or EndInstance link does not exists");
					 }
					 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				 }
			 }else{
				 if(StoreInstance.equals(Instance)){
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				 common.Wait_Until_ElementVisible(driver, EndInstance_link_firstxpath+EndInstance_link_secondxpath+EndInstance_link_thirdxpath);
				 common.Wait_Until_ElementClickable(driver, EndInstance_link_firstxpath+EndInstance_link_secondxpath+EndInstance_link_thirdxpath);
				 driver.findElement(By.xpath(EndInstance_link_firstxpath+EndInstance_link_secondxpath+EndInstance_link_thirdxpath)).click();
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				 }else{
					 System.out.println("StoreInstance not found or EndInstance link does not exists");
				 }
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 } 
		 }
    
     public static void Search_By_StoreNum(WebDriver driver, String StoreNum) throws InterruptedException{
     	StoreInstanceDashBoard.Wait_Until_ModelBox_Disappears(driver);
     	common.Wait_Until_ElementClickable(driver, Filter_btn_xpath);
 			 driver.findElement(By.xpath(Filter_btn_xpath)).click();
 			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
 			 driver.findElement(By.xpath(StoreNum_fld_xpath)).sendKeys(StoreNum);
 			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
 			common.Wait_Until_ElementClickable(driver, Search_btn_xpath);
 			 driver.findElement(By.xpath(Search_btn_xpath)).click();
 			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
 			 StoreInstanceDashBoard.Wait_Until_ModelBox_Disappears(driver);
     }
   
    public static void Search_By_StoreInstanceNum(WebDriver driver, String StoreInstance) throws InterruptedException{
    	StoreInstanceDashBoard.Wait_Until_ModelBox_Disappears(driver);
    	common.Wait_Until_ElementClickable(driver, Filter_btn_xpath);
			 driver.findElement(By.xpath(Filter_btn_xpath)).click();
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 driver.findElement(By.xpath(StoreInstance_fld_xpath)).sendKeys(StoreInstance);
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 common.Wait_Until_ElementClickable(driver, Search_btn_xpath);
			 driver.findElement(By.xpath(Search_btn_xpath)).click();
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 StoreInstanceDashBoard.Wait_Until_ModelBox_Disappears(driver);
    }
    
    public static void Verify_InstanceStatus(WebDriver driver,String status){
    	String InstanceStatus = StoreInstanceDashBoard.StoreInstance_Status(driver);
    	if(InstanceStatus.equalsIgnoreCase(status)){
    		System.out.println("Status is as expected and status is :" + " "+ InstanceStatus );
    	}else{
    		Assert.fail("Invalid status");
    	}
    	
    }
    public static String Searched_Instance(WebDriver driver,String Storenum) throws InterruptedException{
    	 StoreInstanceDashBoard.Wait_Until_ModelBox_Disappears(driver);
		common.Wait_Until_ElementInVisible(driver, "html/body/div[2]/ul/li/div/span/span");
    	 StoreInstanceDashBoard.Wait_Until_ModelBox_Disappears(driver);
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("return document.readyState").equals("complete");
    	WebDriverWait ww = new WebDriverWait(driver,500);
    	ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(StoreInstanceDashBoarTable_xpath)));
			 driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
			 common.Wait_Until_ElementClickable(driver, Filter_btn_xpath);
			 driver.findElement(By.xpath(Filter_btn_xpath)).click();
			 driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS); 
			 ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(StoreNum_fld_xpath)));
			//driver.findElement(By.xpath(StoreNum_fld_xpath)).clear();
			 driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
			 driver.findElement(By.xpath(StoreNum_fld_xpath)).sendKeys(Storenum);
			 driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
			 common.Wait_Until_ElementClickable(driver, Search_btn_xpath);
			 driver.findElement(By.xpath(Search_btn_xpath)).click();
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 String Instance = StoreInstanceDashBoard.StoreInstance(driver);
			 System.out.println(Instance);
		return Instance;
    }
    
    
    
    public static String[]  StoreInsatanceDashBoardDetails(WebDriver driver) throws IOException{
    	String[] Expected={StoreInstanceDashBoard.LMP(driver),StoreInstanceDashBoard.ScheduleDate(driver),StoreInstanceDashBoard.StoreInstance(driver),StoreInstanceDashBoard.StoreNum(driver)};
    	
		return Expected; 
    	
    }
    
    
    
    
}



