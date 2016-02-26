package com.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.commons.actions;

public class CloseFlight_Inventory1 {
	 public static String ExpandAll_btn_xpath = "//i[@data-bind='css: expandCollapse_CSS']";
	 public static String CollapseAll_btn_xpath = "//i[@data-bind='css: expandCollapse_CSS']";
	 public static String menu_Divs_xpath = "/html/body/div/div/div/div[1]/section/div";
	 public static String item_rows_firstxpath="/html/body/div/div/div/div[1]/section/div[";
	 public static String item_rows_secondxpath="]/div[2]/table/tbody/tr";
	 public static String item_name_firstxpath = "/html/body/div/div/div/div[1]/section/div[";
	 public static String item_name_secondxpath = "]/div[2]/table/tbody/tr[";
	 public static String item_name_thirdxpath = "]/td[1]";
	 public static String ActualItem_count_field_firstxpath = "/html/body/div/div/div/div[1]/section/div[";
	 public static String ActualItem_count_field_secondxpath = "]/div[2]/table/tbody/tr[";
	 public static String ActualItem_count_field_thirdxpath = "]/td[3]/input";
	 public static String ExpectedItem_count_field_firstxpath = "/html/body/div/div/div/div[1]/section/div[";
	 public static String ExpectedItem_count_field_secondxpath = "]/div[2]/table/tbody/tr[";
	 public static String ExpectedItem_count_field_thirdxpath = "]/td[2]/span";
	 public static String ActualItem_update_Keypad_firstxpath = "/html/body/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div/div[text()='";
	 public static String ActualItem_update_Keypad_secondxpath = "']";
	 public static String ActualItem_backspace_btn_xpath = "//div[@class='mbsc-np-del dwb-e mbsc-ic mbsc-ic-backspace3']";
	 public static String ActualItem_Set_btn_xpath = "//div[text()='Set']";
	 public static String DamagedItem_btn_firstxpath= "/html/body/div/div/div/div[1]/section/div[";
	 public static String DamagedItem_btn_secondxpath= "]/div[2]/table/tbody/tr[";
	 public static String DamagedItem_btn_thirdxpath= "]/td[4]/button";
	 public static String DamagedItemCount_fld_firstxpath= "/html/body/div[1]/div/div/div[1]/section/div[";
	 public static String DamagedItemCount_fld_secondxpath="]/div[2]/table/tbody/tr[";
	 public static String DamagedItemCount_fld_thirdxpath="]/td[4]/div/div/div/div[2]/table/tbody/tr/td[1]/input";
	 public static String DamagedItems_popup_Title_xpath=".//*[@id='myModalLabel']";
	 public static String DamagedReason_dpdn_firstxpath = "/html/body/div[1]/div/div/div[1]/section/div[";
	 public static String DamagedReason_dpdn_secondxpath ="]/div[2]/table/tbody/tr[";
	 public static String DamagedReason_dpdn_thirdxpath="]/td[4]/div/div/div/div[2]/table/tbody/tr/td[2]/select";
	 public static String NewLine_btn_firstxpath=".//*[@id='Item";
	 public static String NewLine_btn_secondxpath="']/div/div/div[3]/button[1]";
	 public static String DamagedItem_Delete_btn_firstxpath= ".//*[@id='Item";
	 public static String DamagedItem_Delete_btn_secondxpath="']/div/div/div[2]/table/tbody/tr/td[3]/button";
	 public static String DamagedItems_popup_Items_xpath="";
	 public static String DamagedItem_total_firstxpath="/html/body/div/div/div/div[1]/section/div[";
	 public static String DamagedItem_total_secondxpath="]/div[2]/table/tbody/tr[";
	 public static String DamagedItem_total_thirdxpath="]/td[4]/button/span";
	 public static String Done_btn_firstxpath=".//*[@id='Item";
	 public static String Done_btn_secondxpath="']/div/div/div[3]/button[2]";
	 public static String Inventory_Continue_btn_xpath = "//button[@data-bind='click: nextStep']";

	 
	 
	 
	  
     public static int ExpectedItemsCount(WebDriver driver,String item){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 int Menucount = driver.findElements(By.xpath(menu_Divs_xpath)).size();
    	 int ExpectedItemCount=0;
    	 if(Menucount > 1){
    		 for(int j=1;j<=Menucount;j++){
    			 driver.findElement(By.xpath(ExpandAll_btn_xpath)).click();
    			 int itemscount = driver.findElements(By.xpath(item_rows_firstxpath+j+item_rows_secondxpath)).size();
    			 for(int i=1;i<=itemscount;i++){ 
    		 String Itemtext =driver.findElement(By.xpath(item_name_firstxpath+j+item_name_secondxpath)).getText();
    		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	 
    		 if(Itemtext.equalsIgnoreCase(item)){ 
					String Count = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/section/div["+j+"]/div[2]/table/tbody/tr["+i+"]/td[2]/span")).getText();
					String[] string1 = Count.split("\\/");
					String ExpectedCount = string1[0];
					ExpectedItemCount = Integer.parseInt(ExpectedCount);
					System.out.println(ExpectedItemCount);
    		  }
    			 }
    		 }
    	 }else{
    	 driver.findElement(By.xpath(ExpandAll_btn_xpath)).click();
    		 int itemcount = driver.findElements(By.xpath(".//*[@id='collapseOne0']/table/tbody/tr")).size(); 
    		 System.out.println(itemcount);
    		 for(int i=1;i<=itemcount;i++){
    		 String Itemtext =driver.findElement(By.xpath(".//*[@id='collapseOne0']/table/tbody/tr["+i+"]/td[1]")).getText();
    		 System.out.println(Itemtext);
    		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	 
    		 if(Itemtext.equalsIgnoreCase(item)){ 
					String Count = driver.findElement(By.xpath(".//*[@id='collapseOne0']/table/tbody/tr["+i+"]/td[2]/span")).getText();
					 System.out.println("Expected"+" "+ Count);
					 String[] string1 = Count.split("\\/");
						String ExpectedCount = string1[0];
					 ExpectedItemCount = Integer.parseInt(ExpectedCount);
					System.out.println(ExpectedItemCount);
    		  }
    			 }
    		
    	 }
    
		return ExpectedItemCount;
    	 
     }
     
     public static void switchControlToLatestWindow(WebDriver driver) {
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	
	 }
    
     
     public static void Verify_Damaged_Items_Update_popup(){
    	 
    	 
    	 
     }
    
     public static void CloseShop_Inventory_Continue(WebDriver driver){
		  driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		  WebElement continuebutton= driver.findElement(By.xpath(Inventory_Continue_btn_xpath));
			 JavascriptExecutor js = (JavascriptExecutor)driver;
			 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			 // js.executeScript("arguments[0].click();", continuebutton);
			 continuebutton.click();
			 driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	 
      }
     
     public static void Update_ActualItemCount(WebDriver driver,String item,int Itemscount) throws InterruptedException{
    	 driver.findElement(By.xpath(ExpandAll_btn_xpath)).click();
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 int Menucount = driver.findElements(By.xpath(menu_Divs_xpath)).size();
    	 if(Menucount > 1){
    		 for(int j=1;j<=Menucount;j++){
    	    	 int itemcount = driver.findElements(By.xpath(item_rows_firstxpath+j+item_rows_secondxpath)).size();
    	    	 if(itemcount > 1){
    	    		 for(int i=1;i<=itemcount;i++){
    	    			 String Itemtext =driver.findElement(By.xpath(item_name_firstxpath+j+item_name_secondxpath+i+item_name_thirdxpath)).getText();
    	    			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	 
    	    			 if(Itemtext.equalsIgnoreCase(item)){
    	    	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	    	    	 Thread.sleep(300);
    	    	    	 driver.findElement(By.xpath(ActualItem_count_field_firstxpath+j+ActualItem_count_field_secondxpath+i+ActualItem_count_field_thirdxpath)).click();
    	    	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	    	    	/* switchControlToLatestWindow(driver);
    	    	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	    	    	 driver.findElement(By.xpath(ActualItem_backspace_btn_xpath)).click();
    	    	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	    	    	 driver.findElement(By.xpath(ActualItem_backspace_btn_xpath)).click();
    	    	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	    	    	 driver.findElement(By.xpath(ActualItem_backspace_btn_xpath)).click();
    	    	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	    	    	 driver.findElement(By.xpath(ActualItem_update_Keypad_firstxpath+value1+ActualItem_update_Keypad_secondxpath)).click();
    	    	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	    	         driver.findElement(By.xpath(ActualItem_update_Keypad_firstxpath+value2+ActualItem_update_Keypad_secondxpath)).click();
    	    	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	    	    	 driver.findElement(By.xpath(ActualItem_Set_btn_xpath)).click();*/
    	    	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	    	    	//driver.findElement(By.xpath(ActualItem_count_field_firstxpath+j+ActualItem_count_field_secondxpath+i+ActualItem_count_field_thirdxpath)).clear();
    	    	    	 Actions act = new Actions(driver);
   	    			     act.sendKeys(Keys.DELETE).perform();
    	    	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	    	    	 driver.findElement(By.xpath(ActualItem_count_field_firstxpath+j+ActualItem_count_field_secondxpath+i+ActualItem_count_field_thirdxpath)).sendKeys(""+Itemscount);
    	    	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	    	    	 String ActualItems =driver.findElement(By.xpath(ActualItem_count_field_firstxpath+j+ActualItem_count_field_secondxpath+i+ActualItem_count_field_thirdxpath)).getAttribute("value");
    	    			 System.out.println(ActualItems);
    	    			 int items=Integer.parseInt(ActualItems);
    	    			 System.out.println(Itemscount);
    	    	    	 if(items==Itemscount){
    	    				 System.out.println("successfully updated count");
    	    						 }else{
    	    							 Assert.fail("unable to update count");   
    	    						 }
    	    		     }
    	    	      }
    		       }
    			 
    		 }
    	 }else{
    		 int itemcount = driver.findElements(By.xpath(".//*[@id='collapseOne0']/table/tbody/tr")).size(); 
    		 for(int i=1;i<=itemcount;i++){
        		 String Itemtext =driver.findElement(By.xpath(".//*[@id='collapseOne0']/table/tbody/tr["+i+"]/td[1]")).getText();
        		// System.out.println(Itemtext);
        		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	 
        		 if(Itemtext.equalsIgnoreCase(item)){ 
        	    	 Thread.sleep(300);
        	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	
	    	    	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/section/div/div[2]/table/tbody/tr["+i+"]/td[3]/input")).click();
	    	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    	      /*    switchControlToLatestWindow(driver);
	    	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    	    	 driver.findElement(By.xpath(ActualItem_backspace_btn_xpath)).click();
	    	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    	    	 driver.findElement(By.xpath(ActualItem_backspace_btn_xpath)).click();
	    	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    	    	 driver.findElement(By.xpath(ActualItem_backspace_btn_xpath)).click();
	    	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    	    	 driver.findElement(By.xpath(ActualItem_update_Keypad_firstxpath+value1+ActualItem_update_Keypad_secondxpath)).click();
	    	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    	          driver.findElement(By.xpath(ActualItem_update_Keypad_firstxpath+value2+ActualItem_update_Keypad_secondxpath)).click();
	    	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    	    	 driver.findElement(By.xpath(ActualItem_Set_btn_xpath)).click();*/
	    	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    	    	// driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/section/div/div[2]/table/tbody/tr["+i+"]/td[3]/input")).clear();
	    	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    	    	 Actions act = new Actions(driver);
	    			  act.sendKeys(Keys.DELETE).perform();
	    	    	 driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/section/div/div[2]/table/tbody/tr["+i+"]/td[3]/input")).sendKeys(""+Itemscount);
	    	    	 String ActualItems =driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/section/div/div[2]/table/tbody/tr["+i+"]/td[3]/input")).getAttribute("value");
	    	    	 System.out.println(ActualItems);
	    			 int items=Integer.parseInt(ActualItems);
	    			 System.out.println(Itemscount);
	    	    	 if(items==Itemscount){
	    				 System.out.println(Itemtext+" "+"Count is successfully updated count and count is:"+ " "+items);
	    						 }else{
	    							 Assert.fail("unable to update count");   
	    						 }
	    		         }
	    	         }
        		 }
     }
     
     @SuppressWarnings("unused")
 	public static void UpdateDamageditemsCount(WebDriver driver,String item,int DamagedItemcount) throws InterruptedException{
     	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
     	 driver.findElement(By.xpath(ExpandAll_btn_xpath)).click();
     	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
     	 int Menucount = driver.findElements(By.xpath(menu_Divs_xpath)).size();
     	 if(Menucount > 1){
     		 for(int j=1;j<=Menucount;j++){
     			 int itemscount = driver.findElements(By.xpath(item_rows_firstxpath+j+item_rows_secondxpath)).size();
     			 for(int i=1;i<=itemscount;i++){ 
     		 String ItemName =driver.findElement(By.xpath(item_name_firstxpath+j+item_name_secondxpath+i+item_name_thirdxpath)).getText();
     		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	 
     		 if(ItemName.equalsIgnoreCase(item)){ 
     			 driver.findElement(By.xpath(DamagedItem_btn_firstxpath+j+DamagedItem_btn_secondxpath+i+DamagedItem_btn_thirdxpath)).click();
     			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
     			 switchControlToLatestWindow(driver);
     			 driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
     			 WebElement NewLine_btn =  driver.findElement(By.xpath(NewLine_btn_firstxpath+i+NewLine_btn_secondxpath));
     			 if(NewLine_btn.isDisplayed()){
     				 System.out.println("NewLine_btn is displayed");
     			    NewLine_btn.click();
     			    }
     			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
     			 WebElement DamagedItemsfield = driver.findElement(By.xpath(DamagedItemCount_fld_firstxpath+j+DamagedItemCount_fld_secondxpath+i+DamagedItemCount_fld_thirdxpath));
     			 if(DamagedItemsfield.isDisplayed()){
     				 System.out.println("DamagedItemsfield is displayed");
     			
     			 driver.findElement(By.xpath(DamagedItemCount_fld_firstxpath+j+DamagedItemCount_fld_secondxpath+i+DamagedItemCount_fld_thirdxpath)).sendKeys("" +DamagedItemcount);
     			 }
     			 
     			 WebElement drop_down =  driver.findElement(By.xpath(DamagedReason_dpdn_firstxpath+j+DamagedReason_dpdn_secondxpath+i+DamagedReason_dpdn_thirdxpath));
     			 if(drop_down.isDisplayed()){
     			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
     			System.out.println("Damagedreasons dropdown is displayed");
     			 actions.selectByVisibleText(driver, "xpath", DamagedReason_dpdn_firstxpath+j+DamagedReason_dpdn_secondxpath+i+DamagedReason_dpdn_thirdxpath, "Damaged");
     			 }
     			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
     			 WebElement Done_btn = driver.findElement(By.xpath(Done_btn_firstxpath+i+Done_btn_secondxpath));
     			 if(Done_btn.isDisplayed()){
     				 System.out.println("Done_btn is displayed");
     			 driver.findElement(By.xpath(Done_btn_firstxpath+i+Done_btn_secondxpath)).click(); 
     			 }
     			 String DamagedItems = driver.findElement(By.xpath(DamagedItem_total_firstxpath+j+DamagedItem_total_secondxpath+i+DamagedItem_total_thirdxpath)).getText();
     			 int DamagedItemsTotal = Integer.parseInt(DamagedItems);
     			 System.out.println("DamagedItems"+DamagedItemsTotal );
     			 if(DamagedItemsTotal==DamagedItemcount){
     				 System.out.println("Damaged items are updated successfully and count is:"+""+DamagedItemsTotal);
     			         }else{
     			        	  Assert.fail("Unable to update Damaged items");
     			          }
     			        }
     		         }
     			 break;
     			 }
     		 }else{
     			 int itemcount = driver.findElements(By.xpath(".//*[@id='collapseOne0']/table/tbody/tr")).size(); 
         		 System.out.println(itemcount);
         		 for(int i=1;i<=itemcount;i++){
         		 String ItemName =driver.findElement(By.xpath(".//*[@id='collapseOne0']/table/tbody/tr["+i+"]/td[1]")).getText();
         		 System.out.println(ItemName);
         		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	 
         		 if(ItemName.equalsIgnoreCase(item)){  
         			 driver.findElement(By.xpath(".//*[@id='collapseOne0']/table/tbody/tr["+i+"]/td[4]/button")).click();
         			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
         			 switchControlToLatestWindow(driver);
         			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
         			 WebElement NewLine_btn =  driver.findElement(By.xpath(NewLine_btn_firstxpath+i+NewLine_btn_secondxpath));
         			if(NewLine_btn.isDisplayed()){
         				System.out.println("NewLine_btn is displayed");
         			    NewLine_btn.click();
         			}
         			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
         			 WebElement DamagedItemsfield = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/section/div/div[2]/table/tbody/tr["+i+"]/td[4]/div/div/div/div[2]/table/tbody/tr/td[1]/input"));
         			 if(DamagedItemsfield.isDisplayed()){
         				 System.out.println("DamagedItemsfield is displayed");
         			
         			 driver.findElement(By.xpath("/html/body/div/div/div/div[1]/section/div/div[2]/table/tbody/tr["+i+"]/td[4]/div/div/div/div[2]/table/tbody/tr/td[1]/input")).sendKeys("" +DamagedItemcount);
         			 }
         			 WebElement drop_down = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/section/div/div[2]/table/tbody/tr["+i+"]/td[4]/div/div/div/div[2]/table/tbody/tr/td[2]/select"));
         			
         			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
         			if(drop_down.isDisplayed()){
         				 System.out.println("DamagedReasons dropdown is displayed");
         			 actions.selectByVisibleText(driver, "xpath", "/html/body/div/div/div/div[1]/section/div/div[2]/table/tbody/tr["+i+"]/td[4]/div/div/div/div[2]/table/tbody/tr/td[2]/select", "Damaged");
         			}
         			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
         			 WebElement Done_btn = driver.findElement(By.xpath(Done_btn_firstxpath+i+Done_btn_secondxpath));
         			 if(Done_btn.isDisplayed()){
         				 System.out.println("Done_btn is displayed");
         			 driver.findElement(By.xpath(Done_btn_firstxpath+i+Done_btn_secondxpath)).click(); 
         			 }
         			 String DamagedItems = driver.findElement(By.xpath(".//*[@id='collapseOne0']/table/tbody/tr["+i+"]/td[4]/button/span")).getText();
         			 int DamagedItemsTotal = Integer.parseInt(DamagedItems);
         			 if(DamagedItemsTotal==DamagedItemcount){
         				 System.out.println("Damaged items are updated successfully and count is:"+""+DamagedItemsTotal);
         				 break;
         			          }else{
         			        	  Assert.fail("Unable to update Damaged items");
         			          }
         		      }
         		   }
         		 
     		 }
     		 
 		 } 
     
     
}
