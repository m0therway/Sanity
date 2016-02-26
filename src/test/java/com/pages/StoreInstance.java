package com.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commons.Soft_Assert;
import com.commons.actions;
import com.commons.common;
import com.commons.utilities;

public class StoreInstance extends utilities{
	
	 WebDriver driver = null;
		public static String LMPStation_dpdn_xpath="//div/select[@name='CateringStation']";
		public static String ScheduleDate_fld_xpath="//input[@name='scheduleDate']";
		public static String ScheduleNumber_fld_xpath="html/body/div[1]/div/div[1]/form/div[3]/div[2]/div/div/div/span";
		public static String ScheduleNumberInput_fld_xpath="/html/body/div[1]/div/div[1]/form/div[3]/div[2]/div/div/input[1]";
		public static String ScheduleNumber_link_xpath=".//*[@id='ui-select-choices-row-0-0']/a/div";
		
		public static String ScheduleNumber_firstxpath="/html/body/div[1]/div/div[1]/form/div[3]/div[2]/div/div/ul/li/div";
		public static String ScheduleNumber_secondxpath="/a/div";
		public static String StoreNumber_dpdn_xpath="//div/select[@name='StoreNumber']";
		public static String SelectMenus_fld_xpath="html/body/div[1]/div/div[1]/form/div[5]/div[2]/div/div/div/input";
		public static String SelectMenus_firstxpath="/html/body/div[1]/div/div[1]/form/div[5]/div[2]/div/div/ul/li/div";
		public static String SelectMenus_secondxpath="/a/div";
		public static String AirCraftTail_Num_dpdn_xpath="//div/select[@name='carrierNumber']";
		public static String Menus_fld_xpath="html/body/div[1]/div/div[1]/form/div[5]/div[2]/div/div/div/span/span/span/span[2]/span";
		public static String Next_btn_xpath="html/body/div[1]/div/div[1]/form/footer/button";
		public static String Modal_popup="html/body/loading-modal/div/div/div/div/p";
		//Packing
		public static String LMP_Station="//form/store-instance-header/div/div[2]/table/tbody/tr/td[1]/input";
		public static String StoreNum="//form/store-instance-header/div/div[2]/table/tbody/tr/td[2]/input";
		public static String ScheduleDate="//form/store-instance-header/div/div[2]/table/tbody/tr/td[3]/input";
		public static String ScheduleNum="//form/store-instance-header/div/div[2]/table/tbody/tr/td[4]/input";
		public static String TailNum="//form/store-instance-header/div/div[2]/table/tbody/tr/td[5]/input";
		public static String StoreInstanceNum="//form/store-instance-header/div/div[2]/table/tbody/tr/td[6]/input";
		public static String RetailItems_Count_xpath="html/body/div[1]/div/div/form/div[3]/table/tbody/tr";
		public static String PickedItem_fld_firstxpath="html/body/div[1]/div/div/form/div[3]/table/tbody/tr";
		public static String PickedItem_fld_secondxpath="/td[1]/input";
		public static String TemplateQuantity_fld_firstxpath="html/body/div[1]/div/div/form/div[3]/table/tbody/tr";
		public static String TemplateQuantity_fld_secondxpath="/td[2]/input";
		public static String PickedQuantity_fld_firstxpath="html/body/div[1]/div/div/form/div[3]/table/tbody/tr";
		public static String PickedQuantity_fld_secondxpath="/td[3]/input";
		public static String packing_Next_btn_xpath="html/body/div[1]/div/div/form/footer/button[2]";
		
		
		//Assign Seals
		public static String OutBoundSeal_fld_xpath="//form/div[1]/seal-type/div/div[2]/div/div/div/div/input";
		public static String OutBoundSeal_link_xpath="//form/div[1]/seal-type/div/div[2]/div/div/div/ul/li/div[3]/a/small/span";
		public static String HandOverSeal_fld_xpath="//form/div[2]/seal-type/div/div[2]/div/div/div/div/input";
		public static String HandOverSeal_link_xpath="//form/div[2]/seal-type/div/div[2]/div/div/div/ul/li/div[3]/a/small/span";
		public static String InBoundSeal_fld_xpath="//form/div[3]/seal-type/div/div[2]/div/div/div/div/input";
		public static String InBoundSeal_link_xpath="//form/div[3]/seal-type/div/div[2]/div/div/div/ul/li/div[3]/a/small/span";
		public static String HighSecuritySeal_fld_xpath="//form/div[4]/seal-type/div/div[2]/div/div/div/div/input";
		public static String HighSecuritySeal_link_xpath="//form/div[4]/seal-type/div/div[2]/div/div/div/ul/li/div[3]/a/small/span";
		public static String AssignSealNext_btn_xpath="//button[@type='submit']";
		public static String OutBoundSeal="//form/div[1]/seal-type/div/div[2]/div/div/div/div/span/span/span/span[2]/span";
		public static String HandOverSeal="//form/div[2]/seal-type/div/div[2]/div/div/div/div/span/span/span/span[2]/span";
		public static String InBoundSeal="//form/div[3]/seal-type/div/div[2]/div/div/div/div/span/span/span/span[2]/span";
		public static String HighSecuritySeal="//form/div[4]/seal-type/div/div[2]/div/div/div/div/span/span/span/span[2]/span";
		public static String AddnewSeal_link_xpath="html/body/div[1]/div/div/form/div[1]/seal-type/div/div[2]/div/div/div/ul/li/div[3]/a";
		
		//Review & Dispatch
		public static String ReviewScreen_LMP="//div/form/store-instance-header/div/div[2]/table/tbody/tr/td[1]/input";
		public static String ReviewScreen_StoreNum="//div/form/store-instance-header/div/div[2]/table/tbody/tr/td[2]/input";
		public static String ReviewScreen_ScheduleDate="//div/form/store-instance-header/div/div[2]/table/tbody/tr/td[3]/input";
		public static String ReviewScreen_ScheduleNum="//div/form/store-instance-header/div/div[2]/table/tbody/tr/td[4]/input";
		public static String ReviewScreen_TailNum="//div/form/store-instance-header/div/div[2]/table/tbody/tr/td[5]/input";
		public static String ReviewScreen_StoreInstanceNum="//div/form/store-instance-header/div/div[2]/table/tbody/tr/td[6]/input";
		public static String ReviewScreen_OutBoundSeal="//accordion[2]/div/div/div[2]/div/table/tbody/tr[1]/td[2]/span";
		public static String ReviewScreen_InBoundSeal="//accordion[2]/div/div/div[2]/div/table/tbody/tr[2]/td[2]/span";
		public static String ReviewScreen_HandOverSeal="//accordion[2]/div/div/div[2]/div/table/tbody/tr[3]/td[2]/span";
		public static String ReviewScreen_HighSecuritySeal="//accordion[2]/div/div/div[2]/div/table/tbody/tr[4]/td[2]/span";
		public static String ReviewScreen_RetailItems_Count_xpath="//accordion[1]/div/div/div[2]/div/table/tbody/tr";
		public static String ReviewScreen_PickedItem_fld_firstxpath="//accordion[1]/div/div/div[2]/div/table/tbody/tr";
		public static String ReviewScreen_PickedItem_fld_secondxpath="/td[1]/input";
		public static String ReviewScreen_PickedQuantity_fld_firstxpath="//accordion[1]/div/div/div[2]/div/table/tbody/tr";
		public static String ReviewScreen_PickedQuantity_fld_secondxpath="/td[3]/input";
		public static String Pick_List_link="//accordion[1]/div/div/div[1]/h4/a";
		public static String SealNumber_Assignment_link="//accordion[2]/div/div/div[1]/h4/a";
		public static String Dispatch_btn_xpath="html/body/div[1]/div/div/form/footer/button[2]";
		public static String ReviewScreen_Menu_xpath="//div/form/store-instance-header/div/div[1]/div/div[2]/span";
		public static String EndInstance_btn_xpath="html/body/div[1]/div/div/form/footer/button[2]";
		//Save and Exit
		public static String SaveAndExit_btn_xpath="//button[@ng-click='wizardSave()']";
		//Message
		public static String Message_xpath="html/body/div[2]/ul/li/div/span/span";
	    
		
		 public static void switchControlToLatestWindow(WebDriver driver) {
			 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	
		 }
		 
	
		 public static String Packing_RetailItem(WebDriver driver){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				int RetailItems = driver.findElements(By.xpath(RetailItems_Count_xpath)).size();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String	Item = null;
				if(RetailItems > 1){
					for(int i=1;i<=RetailItems;i++){
						Item =  driver.findElement(By.xpath(PickedItem_fld_firstxpath+"["+i+"]"+PickedItem_fld_secondxpath)).getAttribute("value");
						//System.out.println(Item);
					}
				}else{
					Item =  driver.findElement(By.xpath(PickedItem_fld_firstxpath+PickedItem_fld_secondxpath)).getAttribute("value");
					//System.out.println(Item);
				}
				return Item;
		 }
		 public static String Packing_PickedQuantity(WebDriver driver){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				int RetailItems = driver.findElements(By.xpath(RetailItems_Count_xpath)).size();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String	Quantity = null;
				if(RetailItems > 1){
					for(int i=1;i<=RetailItems;i++){
						Quantity =  driver.findElement(By.xpath(PickedQuantity_fld_firstxpath+"["+i+"]"+PickedQuantity_fld_secondxpath)).getAttribute("value");
						//System.out.println(Quantity);
					}
				}else{
					Quantity =  driver.findElement(By.xpath(PickedQuantity_fld_firstxpath+PickedQuantity_fld_secondxpath)).getAttribute("value");
					//System.out.println(Quantity);
				}
				return Quantity;
		 }
		
		
		
		 
		 
		 public static String Packing_InstanceNum(WebDriver driver) throws IOException{
			 JavascriptExecutor js1= (JavascriptExecutor) driver;
			    js1.executeScript("return document.readyState").equals("complete");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				String Num= driver.findElement(By.xpath(StoreInstanceNum)).getAttribute("value");
				//System.out.println(Num);
				return Num;
			}
		 public static String OutboundSeal(WebDriver driver){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				String Num= driver.findElement(By.xpath(OutBoundSeal)).getText();
				//System.out.println(Num);
				return Num; 
		 }
         public static String InboundSeal(WebDriver driver){
        	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				String Num= driver.findElement(By.xpath(InBoundSeal)).getText();
				//System.out.println(Num);
				return Num;  
		 }
         
         public static String HandOverSeal(WebDriver driver){
        	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				String Num= driver.findElement(By.xpath(HandOverSeal)).getText();
				//System.out.println(Num);
				return Num;  
		 }
         public static String HighSecuritySeal(WebDriver driver){
        	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				String Num= driver.findElement(By.xpath(HighSecuritySeal)).getText();
				//System.out.println(Num);
				return Num;   
 		 }
         public static String LMP(WebDriver driver) throws IOException{
			 JavascriptExecutor js1= (JavascriptExecutor) driver;
			    js1.executeScript("return document.readyState").equals("complete");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				Select select = new 
						Select(driver.findElement(By.xpath(LMPStation_dpdn_xpath)));
						String option = select.getFirstSelectedOption().getText();
				//System.out.println(option);
				return option;
			}
		
         
         public static String StoreNum(WebDriver driver) throws IOException{
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				Select select = new 
						Select(driver.findElement(By.xpath(StoreNumber_dpdn_xpath)));
				String num= select.getFirstSelectedOption().getText();
				//System.out.println(num);
				return num;
				
			}
         public static String Menu(WebDriver driver) throws IOException{
 			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
 			String menu= driver.findElement(By.xpath(Menus_fld_xpath)).getText();
 			//System.out.println(menu);
 			return menu;
 			
 		}
		 public static String ScheduleDate(WebDriver driver) throws IOException{
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String date= driver.findElement(By.xpath(ScheduleDate_fld_xpath)).getAttribute("value");
			//System.out.println(date);
			return date;
			
		}
		 public static String ScheduleNum(WebDriver driver) throws IOException{
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				String Num= driver.findElement(By.xpath(ScheduleNumber_fld_xpath)).getText();
				//System.out.println(Num);
				return Num;
				
			}
		 
		 public static String TailNum(WebDriver driver) throws IOException{
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				Select select = new 
						Select(driver.findElement(By.xpath(AirCraftTail_Num_dpdn_xpath)));
				String Num= select.getFirstSelectedOption().getText();
				//System.out.println(Num);
				return Num;
			}
		 public static String Review_Menu(WebDriver driver) throws IOException{
			 JavascriptExecutor js1= (JavascriptExecutor) driver;
			    js1.executeScript("return document.readyState").equals("complete");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				String menu= driver.findElement(By.xpath(ReviewScreen_Menu_xpath)).getText();
				//System.out.println(menu);
				return menu;
			}
         public static String Review_LMP(WebDriver driver) throws IOException{
			 JavascriptExecutor js1= (JavascriptExecutor) driver;
			    js1.executeScript("return document.readyState").equals("complete");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				String lmp= driver.findElement(By.xpath(ReviewScreen_LMP)).getAttribute("value");
				//System.out.println(lmp);
				return lmp;
			}
		 public static String Review_RetailItem(WebDriver driver){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 driver.findElement(By.xpath(Pick_List_link)).click(); 
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				int RetailItems = driver.findElements(By.xpath(ReviewScreen_RetailItems_Count_xpath)).size();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String	Item = null;
				if(RetailItems > 1){
					for(int i=1;i<=RetailItems;i++){
						Item =  driver.findElement(By.xpath(ReviewScreen_PickedItem_fld_firstxpath+"["+i+"]"+ReviewScreen_PickedItem_fld_secondxpath)).getAttribute("value");
						//System.out.println(Item);
					}
				}else{
					Item =  driver.findElement(By.xpath(ReviewScreen_PickedItem_fld_firstxpath+ReviewScreen_PickedItem_fld_secondxpath)).getAttribute("value");
					//System.out.println(Item);
				}
				return Item;
		 }
		 public static String Review_PickedQuantity(WebDriver driver){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				int RetailItems = driver.findElements(By.xpath(ReviewScreen_RetailItems_Count_xpath)).size();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String	Quantity = null;
				if(RetailItems > 1){
					for(int i=1;i<=RetailItems;i++){
						Quantity =  driver.findElement(By.xpath(ReviewScreen_PickedQuantity_fld_firstxpath+"["+i+"]"+ReviewScreen_PickedQuantity_fld_secondxpath)).getAttribute("value");
						//System.out.println(Quantity);
					}
				}else{
					Quantity =  driver.findElement(By.xpath(ReviewScreen_PickedQuantity_fld_firstxpath+ReviewScreen_PickedQuantity_fld_secondxpath)).getAttribute("value");
					//System.out.println(Quantity);
				}
				return Quantity;
		 }
		 public static String Review_StoreNum(WebDriver driver) throws IOException{
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				String num= driver.findElement(By.xpath(ReviewScreen_StoreNum)).getAttribute("value");
				//System.out.println(num);
				return num;
				
			}
		 public static String Review_ScheduleDate(WebDriver driver) throws IOException{
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String date= driver.findElement(By.xpath(ReviewScreen_ScheduleDate)).getAttribute("value");
			//System.out.println(date);
			return date;
			
		}
		 public static String Review_ScheduleNum(WebDriver driver) throws IOException{
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				String Num= driver.findElement(By.xpath(ReviewScreen_ScheduleNum)).getAttribute("value");
				//System.out.println(Num);
				return Num;
				
			}
		 
		 public static void Wait_Until_Modaldialog_Invisible(WebDriver driver){
			common.Wait_Until_ElementInVisible(driver, Modal_popup); 
		 }
		 
		 public static void Navigate_to_URL(WebDriver driver,String page){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 driver.navigate().to("https://ts5-qa.egatesoln.com/#/"+page);
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 }
		 public static String Review_TailNum(WebDriver driver) throws IOException{
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				String Num= driver.findElement(By.xpath(ReviewScreen_TailNum)).getAttribute("value");
				//System.out.println(Num);
				return Num;
			}
		 
		 public static String Review_InstanceNum(WebDriver driver) throws IOException{
			 JavascriptExecutor js1= (JavascriptExecutor) driver;
			    js1.executeScript("return document.readyState").equals("complete");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				String Num= driver.findElement(By.xpath(ReviewScreen_StoreInstanceNum)).getAttribute("value");
				//System.out.println(Num);
				return Num;
			}
		 public static String Review_OutboundSeal(WebDriver driver){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 driver.findElement(By.xpath(SealNumber_Assignment_link)).click();
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				String Num= driver.findElement(By.xpath(ReviewScreen_OutBoundSeal)).getText();
				//System.out.println(Num);
				return Num; 
		 }
         public static String Review_InboundSeal(WebDriver driver){
        	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				String Num= driver.findElement(By.xpath(ReviewScreen_InBoundSeal)).getText();
				//System.out.println(Num);
				return Num;  
		 }
         
         public static String Review_HandOverSeal(WebDriver driver){
        	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				String Num= driver.findElement(By.xpath(ReviewScreen_HandOverSeal)).getText();
				//System.out.println(Num);
				return Num;  
		 }
         public static String Review_HighSecuritySeal(WebDriver driver){
        	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				String Num= driver.findElement(By.xpath(ReviewScreen_HighSecuritySeal)).getText();
				//System.out.println(Num);
				return Num;   
 		 }
         
         public static String Message(WebDriver driver){
        	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
 			WebDriverWait ww = new WebDriverWait(driver,30);
 			ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Message_xpath)));
 			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
 			String message=driver.findElement(By.xpath(Message_xpath)).getText();
 			//System.out.println(message);
			return message;
 		  }
         public static String Instance(WebDriver driver){
        	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
  			String message=StoreInstance.Message(driver);
  			String[] string1 = message.split(" ");
  			String Instance = string1[2];
  			//System.out.println(Instance);
 			return Instance;
  		  }
		 public static void CreateStore_Instance(WebDriver driver,String LMPStation,String ScheduleNum,String StoreNumber,String Menu) throws IOException{
			 String DATE_FORMAT = "MM/dd/yyyy";
			    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
			    long base=System.currentTimeMillis(); 
			     int M=1;
			    Date sdate=new Date(base+M*24*60*60*1000);  
		        String DATE = sdf.format(sdate);
		        String[] from = DATE.split("/");
		        String scheduleDate = from[1];
			 WebDriverWait ww = new WebDriverWait(driver,30);
			ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LMPStation_dpdn_xpath)));
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			actions.selectByVisibleText(driver, "xpath", LMPStation_dpdn_xpath, LMPStation);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath(ScheduleDate_fld_xpath)).click();
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
			StoreInstance.switchControlToLatestWindow(driver);
			common.pickdate(driver, scheduleDate);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			common.Wait_Until_ElementClickable(driver, ScheduleNumber_fld_xpath);
	    	driver.findElement(By.xpath(ScheduleNumber_fld_xpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath(ScheduleNumberInput_fld_xpath)).sendKeys(ScheduleNum);
			common.Wait_Until_ElementClickable(driver, ScheduleNumber_link_xpath);
			driver.findElement(By.xpath(ScheduleNumber_link_xpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		    actions.selectByVisibleText(driver, "xpath", StoreNumber_dpdn_xpath, StoreNumber);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath(SelectMenus_fld_xpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			int row1 = driver.findElements(By.xpath(SelectMenus_firstxpath)).size();
			for(int i=3;i<=row1;i++){
			String menu=driver.findElement(By.xpath(SelectMenus_firstxpath+"["+i+"]"+SelectMenus_secondxpath)).getText();
			//System.out.println(menu); 
			if(menu.equals(Menu)){
			WebElement element = driver.findElement(By.xpath(SelectMenus_firstxpath+"["+i+"]"+SelectMenus_secondxpath));
				common.JavaScriptExecutor_ElementClick(driver, element);
				break;
			 }
			}
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			actions.selectByindex(driver, "xpath", AirCraftTail_Num_dpdn_xpath, 1);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			StoreInstance.Next(driver);
		}
		
		 public static void Packing(WebDriver driver){
			 StoreInstance.Wait_Until_Modaldialog_Invisible(driver);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			int RetailItems = driver.findElements(By.xpath(RetailItems_Count_xpath)).size();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			if(RetailItems > 1){
				for(int i=1;i<=RetailItems;i++){
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					//String quantity = driver.findElement(By.xpath(PickedQuantity_fld_firstxpath+"["+i+"]"+PickedQuantity_fld_secondxpath)).getAttribute("value");
					//System.out.println(quantity);
					//int TempalteQuantity = Integer.parseInt(quantity);
					//int PickedQuantity = TempalteQuantity-5;
					int PickedQuantity =1;
					driver.findElement(By.xpath(PickedQuantity_fld_firstxpath+"["+i+"]"+PickedQuantity_fld_secondxpath)).clear();
					driver.findElement(By.xpath(PickedQuantity_fld_firstxpath+"["+i+"]"+PickedQuantity_fld_secondxpath)).sendKeys(""+PickedQuantity);
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				}
				
			}else{
				String quantity = driver.findElement(By.xpath(PickedQuantity_fld_firstxpath+PickedQuantity_fld_secondxpath)).getAttribute("value");
				int TempalteQuantity = Integer.parseInt(quantity);
				int PickedQuantity = TempalteQuantity-5;
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				driver.findElement(By.xpath(PickedQuantity_fld_firstxpath+PickedQuantity_fld_secondxpath)).clear();
				driver.findElement(By.xpath(PickedQuantity_fld_firstxpath+PickedQuantity_fld_secondxpath)).sendKeys(""+PickedQuantity);
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			}
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath(packing_Next_btn_xpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
		
		 
		 public static void Next(WebDriver driver){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 common.Wait_Until_ElementVisible(driver, Next_btn_xpath);
				driver.findElement(By.xpath(Next_btn_xpath)).click();
				driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			/*	JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("return document.readyState").equals("complete");
				driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
				WebDriverWait ww = new WebDriverWait(driver,70);
				ww.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("html/body/loading-modal/div/div/div/div/p")));*/
		 }
		 public static void SaveAndExit(WebDriver driver) throws InterruptedException{
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				driver.findElement(By.xpath(SaveAndExit_btn_xpath)).click();
				driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("return document.readyState").equals("complete");
				driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
				WebDriverWait ww = new WebDriverWait(driver,70);
				ww.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("html/body/loading-modal/div/div/div/div/p")));
		 }
		 public static void Dispatch(WebDriver driver){
			 StoreInstance.Wait_Until_Modaldialog_Invisible(driver);
			 common.Wait_Until_ElementInVisible(driver, "html/body/div[2]/ul/li/div/span/span");
			 common.Wait_Until_ElementVisible(driver, Dispatch_btn_xpath);
			 common.Wait_Until_ElementClickable(driver, Dispatch_btn_xpath);
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				driver.findElement(By.xpath(Dispatch_btn_xpath)).click();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				StoreInstance.Wait_Until_Modaldialog_Invisible(driver);
		 }
		public static void AssignSeals(WebDriver driver,String OutboundSeal,String HandOverSeal,String InbountSeal,String HighSecuritySeal){
			StoreInstance.Wait_Until_Modaldialog_Invisible(driver);
			common.Wait_Until_ElementVisible(driver, OutBoundSeal_fld_xpath);
			common.Wait_Until_ElementClickable(driver, OutBoundSeal_fld_xpath);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath(OutBoundSeal_fld_xpath)).sendKeys(OutboundSeal);
			 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			 driver.findElement(By.xpath(OutBoundSeal_link_xpath)).click();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath(HandOverSeal_fld_xpath)).sendKeys(HandOverSeal);
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath(HandOverSeal_link_xpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath(InBoundSeal_fld_xpath)).sendKeys(InbountSeal);
			 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.findElement(By.xpath(InBoundSeal_link_xpath)).click();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		    driver.findElement(By.xpath(HighSecuritySeal_fld_xpath)).sendKeys(HighSecuritySeal);
		    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		    driver.findElement(By.xpath(HighSecuritySeal_link_xpath)).click();
		    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath(packing_Next_btn_xpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
		
		public static void Verify_Message(WebDriver driver){
			
		}
		
		
		public static void StoreInstance_Review(WebDriver driver,String ExpectedLMP,String ExpectedStoreNum,String ExpectedScheduleDate,String ExpectedScheduleNum, String ExpectedTailNum,String ExpectedInstanceNum,
			String ExpectedItems,String ExpectedPickedQuantity,String ExpectedOutBound,String ExpectedInBound,String ExpectedHighSecuritySeal,String ExpectedHandOverSeal) throws IOException{
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String Actual_LMP=StoreInstance.Review_LMP(driver);
			String Actual_StoreNum=StoreInstance.Review_StoreNum(driver);
			String Actual_ScheduleDate=StoreInstance.Review_ScheduleDate(driver);
			String Actual_ScheduleNum=StoreInstance.Review_ScheduleNum(driver);
			String Actual_TailNum=StoreInstance.Review_TailNum(driver);
			String Actual_InstanceNum=StoreInstance.Review_InstanceNum(driver);
			String Actual_RetailItems=StoreInstance.Review_RetailItem(driver);
			String Actual_PickedQuantity=StoreInstance.Review_PickedQuantity(driver);
			String Actual_OutBoundSeal=StoreInstance.Review_OutboundSeal(driver);
			String Actual_InBoundSeal=StoreInstance.Review_InboundSeal(driver);
			String Actual_HandOverSeal=StoreInstance.Review_HandOverSeal(driver);
			String Actual_HighSecuritySeal=StoreInstance.Review_HighSecuritySeal(driver);
			
			if(ExpectedLMP.equalsIgnoreCase(Actual_LMP)){
				System.out.println("LMP is as expected");
				if(ExpectedStoreNum.equalsIgnoreCase(Actual_StoreNum)){
					System.out.println("StoreNum is as expected");
					if(ExpectedScheduleDate.equalsIgnoreCase(Actual_ScheduleDate)){
						System.out.println("ScheduleDate is as expected");
						if(ExpectedScheduleNum.equalsIgnoreCase(Actual_ScheduleNum)){
							System.out.println("ScheduleNum is as expected");
							if(ExpectedTailNum.equalsIgnoreCase(Actual_TailNum)){
								System.out.println("TailNum is as expected");
								if(ExpectedInstanceNum.equalsIgnoreCase(Actual_InstanceNum)){
									System.out.println("InstanceNum is as expected");
									if(ExpectedItems.equalsIgnoreCase(Actual_RetailItems)){
										System.out.println("Items are as expected");
										if(ExpectedPickedQuantity.equalsIgnoreCase(Actual_PickedQuantity)){
											System.out.println("PickedQuantity are as expected");
											if(ExpectedOutBound.equalsIgnoreCase(Actual_OutBoundSeal)){
												System.out.println("OutBoundSeal is as expected");
												if(ExpectedInBound.equalsIgnoreCase(Actual_InBoundSeal)){
													System.out.println("InBoundSeal is as expected");
													if(ExpectedHighSecuritySeal.equalsIgnoreCase(Actual_HighSecuritySeal)){
														System.out.println("HighSecuritySeal is as expected");
														if(ExpectedHandOverSeal.equalsIgnoreCase(Actual_HandOverSeal)){
															System.out.println("HandOverSeal is as expected");
														}else{
															Soft_Assert.fail("HandOverSeal is different");
														}
														
													}else{
														Soft_Assert.fail("HighSecuritySeal is different");
													}
													
												}else{
													Soft_Assert.fail("InBoundSeal is different");
												}
												
											}else{
												Soft_Assert.fail("OutBoundSeal is different");
											}
											
										}else{
											Soft_Assert.fail("PickedQuantity are different");
										}
										
									}else{
										Soft_Assert.fail("Items are different");
									}
									
								}else{
									Soft_Assert.fail("InstanceNum is different");
								}
								
							}else{
								Soft_Assert.fail("TailNum is different");
							}
							
						}else{
							Soft_Assert.fail("ScheduleNum is different");
						}
						
					}else{
						Soft_Assert.fail("ScheduleDate is different");
					}
				}else{
					Soft_Assert.fail("StoreNum is different");
				}
			}else{
				Soft_Assert.fail("LMP is different");
			}
			
			
		}
		
		 public static String[]  StoreInsatance_ReviewScreen_Details(WebDriver driver) throws IOException{
			 WebDriverWait ww = new WebDriverWait(driver,70);
		     ww.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("html/body/loading-modal/div/div/div/div/p")));
		    	String[] Actual={StoreInstance.Review_LMP(driver),StoreInstance.Review_ScheduleDate(driver),StoreInstance.Review_InstanceNum(driver),StoreInstance.Review_StoreNum(driver)};
		    					return Actual;
		    }
		 
		public static void process_EndInstance(WebDriver driver){
			StoreInstance.Next(driver);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			StoreInstance.Wait_Until_Modaldialog_Invisible(driver);
			common.Wait_Until_ElementInVisible(driver, "html/body/div[2]/ul/li/div/span/span");
			common.Wait_Until_ElementVisible(driver, packing_Next_btn_xpath);
			common.Wait_Until_ElementClickable(driver, packing_Next_btn_xpath);
			driver.findElement(By.xpath(packing_Next_btn_xpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			StoreInstance.Wait_Until_Modaldialog_Invisible(driver);
			common.Wait_Until_ElementInVisible(driver, "html/body/div[2]/ul/li/div/span/span");
			common.Wait_Until_ElementVisible(driver, packing_Next_btn_xpath);
			common.Wait_Until_ElementClickable(driver, packing_Next_btn_xpath);
			driver.findElement(By.xpath(packing_Next_btn_xpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			StoreInstance.Wait_Until_Modaldialog_Invisible(driver);
			common.Wait_Until_ElementInVisible(driver, "html/body/div[2]/ul/li/div/span/span");
			common.Wait_Until_ElementVisible(driver, EndInstance_btn_xpath);
			common.Wait_Until_ElementClickable(driver, EndInstance_btn_xpath);
			driver.findElement(By.xpath(EndInstance_btn_xpath)).click();
			StoreInstance.Wait_Until_Modaldialog_Invisible(driver);
			common.Wait_Until_ElementInVisible(driver, "html/body/div[2]/ul/li/div/span/span");
		}
}
