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

import com.commons.actions;
import com.commons.common;

public class EPOS_DashBoard {

	WebDriver driver=null;
	public static String DashBoard_link="//a[@href='dashboard.html']";
	public static String NewOrder_btn_xpath ="//button[@name='btnNewOrder']";
	public static String Panel_name_firstxpath ="html/body/section[2]/div[1]/div[" ;
	public static String Panel_name_secondxpath ="]/div/div/div[2]";
	public static String Panels_count_xpath = "/html/body/div[2]/div/div/div[1]/div";
	public static String Panel_total_firstxpath ="html/body/section[2]/div[1]/div[" ;
	public static String Panel_total_secondxpath ="]/div/div/div[1]";
	public static String Panel_viewdetailslink_firstxpath = "/html/body/div[2]/div/div/div[1]/div[";
	public static String Panel_viewdetailslink_secondxpath = "]/div/div[2]/a/span[text()='View Details']";
	public static String Panel_colour_firstxpath="/html/body/div[2]/div/div/div[1]/div[";
	public static String Panel_colour_secondxpath="]/div";
	public static String Sales_charts_sections_xpath="//tspan";
	public static String Footer_links_list_xpath = ".//*[@id='menustrip']/li";
	public static String Footer_links_firstxpath = ".//*[@id='menustrip']/li[";
	public static String Footer_links_secondxpath ="]/a/span/span";
	public static String page_header_xpath ="//h1";
	public static String popupmessages_count_xpath = "/html/body/div[1]/div/div/div/div[2]/div";
	public static String popupmessages_text_firstxpath = ".//*[@id='ModalBodyMessages']/div[2]/div[";
	public static String popupmessages_text_secondxpath = "]";
	public static String popup_close_btn_xpath = "//button[text()='Close']" ;
	public static String popupPromotions_count_xpath = ".//*[@id='ModalBodyPromotions']/section[1]/div/a";
	public static String popupPromotions_text_firstxpath = ".//*[@id='ModalBodyPromotions']/section[1]/div/a[";
	public static String popupPromotions_text_secondxpath = "]/p";
	public static String SalesandRefund_orderrows_xpath = ".//*[@id='CompletedSales']/tbody/tr";
	public static String SalesandRefund_Refundrows_xpath = ".//*[@id='Refunds']/tbody/tr";
	public static String transactions_message_xpath ="//blockquote";
	public static String FlightNum_FlightRoute_xpath = "//h1/small";
	public static String Flight_Details_xpath=".//*[@id='PageHeader']/header/h1/small";
	public static String SelectedCrew_ForSales_xpath="html/body/section[1]/nav/div[2]/ul/li[3]/a/span[1]";
	public static String CrewMenu_xpath=".//*[@id='navMain']/div[2]/ul/li[3]/a";
	public static String Manage_Crew_xpath="//a[@href='./_falogin.html']";
	public static String FALogin_popup_xpath="html/body/div[1]/div";
	public static String Crew_xpath=".//*[@id='mnuProfile']/li[1]/a";
	public static String CrewID_fld_xpath="//input[@data-bind='value: crewId']";
	public static String CrewID_Add_btn_xpath="//button[@data-bind='css: crewId_ButtonCSS, click: crewId_Add']";
	public static String Close_btn_xpath="//button[@class='close']";
	public static String CrewCount_xpath=".//*[@id='tblSalesPerCrew']/tbody/tr";
	public static String CrewName_firstxpath=".//*[@id='tblSalesPerCrew']/tbody/tr";
	public static String CrewName_secondxpath="/td[1]";
	public static String CrewID_firstxpath=".//*[@id='tblSalesPerCrew']/tbody/tr";
	public static String CrewID_secondxpath="/td[2]";
	public static String CrewTrans_firstxpath=".//*[@id='tblSalesPerCrew']/tbody/tr";
	public static String CrewTrans_secondxpath="/td[3]";	
	public static String CrewTotal_firstxpath=".//*[@id='tblSalesPerCrew']/tbody/tr";
	public static String CrewTotal_secondxpath="/td[4]";	
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
	public static String Promotions_Count="html/body/div[1]/div/div/div[2]/section[1]/div/a";
	public static String PromotionName_firstpath="html/body/div[1]/div/div/div[2]/section[1]/div/a[";
	public static String PromotionName_secondpath="]/h4";
	 public static String DashBoard_Inventory_link_xpath = ".//*[@id='menustrip']/li[3]/a";
	 public static String InventoryManagement_link_xpath = ".//*[@id='Main']/div/div[1]/a";
	
	 public static void DashBoard_Inventory(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(DashBoard_Inventory_link_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
   
   public static void Inventory_Management(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(InventoryManagement_link_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	public static void switchControlToLatestWindow(WebDriver driver) {
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	
	 }
	public static void Navigate_To_DashBoard(WebDriver driver){
		common.Wait_Until_ElementVisible(driver, DashBoard_link);
		common.Wait_Until_ElementClickable(driver, DashBoard_link);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(DashBoard_link)).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void SetFlowPrefernce(WebDriver driver, String dropdown, String Value){
	    common.Wait_Until_ElementVisible(driver, MenuSettings_xpath);
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
	
	public static String Crew_Name(WebDriver driver,int crew){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int Crew = driver.findElements(By.xpath(CrewCount_xpath)).size();
		String Crew_Name=null;
		if(Crew > 1){
		
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Crew_Name = driver.findElement(By.xpath(CrewName_firstxpath+"["+crew+"]"+CrewName_secondxpath)).getText();
				System.out.println(Crew_Name);
		
		}else{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Crew_Name = driver.findElement(By.xpath(CrewName_firstxpath+CrewName_secondxpath)).getText();
			System.out.println(Crew_Name);
		}
		return Crew_Name;
		
	}
		
	
	public static String CrewID(WebDriver driver,int crew){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int Crew = driver.findElements(By.xpath(CrewCount_xpath)).size();
		String CrewID=null;
		if(Crew > 1){
		
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				CrewID = driver.findElement(By.xpath(CrewID_firstxpath+"["+crew+"]"+CrewID_secondxpath)).getText();
				System.out.println(CrewID);
		
		}else{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			CrewID = driver.findElement(By.xpath(CrewID_firstxpath+CrewID_secondxpath)).getText();
			System.out.println(CrewID);
		}
		return CrewID;
		
	}
	public static int CrewTransactions(WebDriver driver,int crew){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int Crew = driver.findElements(By.xpath(CrewCount_xpath)).size();
		int CrewTransactions=0;
		if(Crew > 1){
			
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				String Transactions = driver.findElement(By.xpath(CrewTrans_firstxpath+"["+crew+"]"+CrewTrans_secondxpath)).getText();
				CrewTransactions =Integer.parseInt(Transactions);
				System.out.println(CrewTransactions);
			
		}else{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String Transactions = driver.findElement(By.xpath(CrewTrans_firstxpath+CrewTrans_secondxpath)).getText();
			CrewTransactions =Integer.parseInt(Transactions);
			System.out.println(CrewTransactions);
		}
		return CrewTransactions;
		
	}
	
	public static float CrewTotal(WebDriver driver,String CurrencySymbol,int crew){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int Crew = driver.findElements(By.xpath(CrewCount_xpath)).size();
		float CrewTotal=0;
		if(Crew > 1){
			
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				String Total = driver.findElement(By.xpath(CrewTotal_firstxpath+"["+crew+"]"+CrewTotal_secondxpath)).getText();
				String[] String1=Total.split("\\"+CurrencySymbol);
				CrewTotal =Float.valueOf(String1[1].trim()).floatValue();
				System.out.println(CrewTotal);
			
		}else{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String Total = driver.findElement(By.xpath(CrewTotal_firstxpath+CrewTotal_secondxpath)).getText();
			String[] String1=Total.split("\\"+CurrencySymbol);
			CrewTotal =Float.valueOf(String1[1].trim()).floatValue();
			System.out.println(CrewTotal);
		}
		return CrewTotal;
		
	}
	
	public static void Add_Crew(WebDriver driver,String AdditionalCrew){
		  common.Wait_Until_ElementVisible(driver, CrewMenu_xpath);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(CrewMenu_xpath)).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Manage_Crew_xpath)).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  common.Wait_Until_ElementVisible(driver,FALogin_popup_xpath );
		driver.findElement(By.xpath(CrewID_fld_xpath)).sendKeys(AdditionalCrew);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(CrewID_Add_btn_xpath)).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Close_btn_xpath)).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void Select_Crew_For_Sales(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(CrewMenu_xpath)).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Crew_xpath)).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static String Selected_CrewForeSale(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String Crew= driver.findElement(By.xpath(SelectedCrew_ForSales_xpath)).getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return Crew;
	}
	
	
	public static void Verifypanel(WebDriver driver,String panelname,String panelcolour){
		 driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
		JavascriptExecutor js= (JavascriptExecutor) driver;
	    js.executeScript("return document.readyState").equals("complete");
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		int panelcount = driver.findElements(By.xpath(Panels_count_xpath)).size();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		for(int i=1;i<=panelcount;i++){
			String pname = driver.findElement(By.xpath(Panel_name_firstxpath+i+Panel_name_secondxpath)).getText();
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			WebElement ptotal = driver.findElement(By.xpath(Panel_total_firstxpath+i+Panel_total_secondxpath));
			String total =  driver.findElement(By.xpath(Panel_total_firstxpath+i+Panel_total_secondxpath)).getText();
			String[] total1 = total.split("/");
			int total2 =Integer.parseInt(total1[0]);
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			String pcolour = driver.findElement(By.xpath(Panel_colour_firstxpath+i+Panel_colour_secondxpath)).getAttribute("class");
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			WebElement ViewDetailslink = driver.findElement(By.xpath(Panel_viewdetailslink_firstxpath+i+Panel_viewdetailslink_secondxpath));
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			if(pname.equalsIgnoreCase(panelname)){
				System.out.println(pname+" " +"displayed on the panel");
				driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
				if(ptotal.isDisplayed()){
					System.out.println(pname+" "+"total displayed on the panel"+" "+"total is: "+" "+total2);
					driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
					if(ViewDetailslink.isDisplayed()){
						System.out.println("View details link displayed on panel");
						driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
						if(pcolour.equals(panelcolour)){
							System.out.println(pname+" " + "panel colour is"+" "+ pcolour+" "+  " and is as expected");
							driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
						        }else{
						        	Assert.fail("Panel colour is different");
						        }
					 }else{
						 Assert.fail("View details link not displayed");
					 }
					
				 }else{
					 Assert.fail("Panel total not displyed");
				 }
			   }else{
				 Assert.fail("Panel name not displayed");
			  }
			 }	
	   }
	 
	  public static void VerifyLinks(WebDriver driver) throws InterruptedException{
		  JavascriptExecutor js= (JavascriptExecutor) driver;
		    js.executeScript("return document.readyState").equals("complete");
		  driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
		  int nooflinks = driver.findElements(By.xpath(Footer_links_list_xpath)).size();
		  String linktext=null;
		  WebElement link;
		  for(int i=1; i<=nooflinks;i++){
			  driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS); 
			 link=driver.findElement(By.xpath(Footer_links_firstxpath+i+Footer_links_secondxpath));
			 if(link.isDisplayed()){
				 driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
				linktext=driver.findElement(By.xpath(Footer_links_firstxpath+i+Footer_links_secondxpath)).getText();
				System.out.print( linktext+ ","+" ");
				  driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
			 }else{
				 Assert.fail("Link"+" "+ linktext + " "+"is"+" " + " "+ " not displayed on the screen");
			 }
		  }
		  System.out.println(" are displayed on the screen");
		  driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	   }
	
	  public static void VerifyLinkPages_Header(WebDriver driver,String link,String Header) throws InterruptedException, IOException{
		    driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
		    JavascriptExecutor js= (JavascriptExecutor) driver;
		    js.executeScript("return document.readyState").equals("complete");
		    driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
			int nooflinks = driver.findElements(By.xpath(Footer_links_list_xpath)).size();
			//System.out.println(nooflinks);
			for(int i=1; i<=nooflinks;i++){
			driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
			String linktext=driver.findElement(By.xpath(Footer_links_firstxpath+i+Footer_links_secondxpath)).getText();
			//System.out.println(linktext);
			if(linktext.equals(link)){ 
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS); 
			WebDriverWait ww = new WebDriverWait(driver,1000);
			 js.executeScript("return document.readyState").equals("complete");
			ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Footer_links_firstxpath+i+Footer_links_secondxpath)));
			js.executeScript("arguments[0].click();",driver.findElement(By.xpath(Footer_links_firstxpath+i+Footer_links_secondxpath)));
		//	driver.findElement(By.xpath(Footer_links_firstxpath+i+Footer_links_secondxpath)).click();
			driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);
		   js.executeScript("return document.readyState").equals("complete");
		   Thread.sleep(1000);
			 driver.manage().timeouts().implicitlyWait(30000,TimeUnit.SECONDS);
			  ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(page_header_xpath)));
			  String pageheader = driver.findElement(By.xpath(page_header_xpath)).getText(); 
			 System.out.println("pageheader is:"+pageheader);
			if(pageheader.contains(Header)){
				 System.out.println(link+" "+"Header Matched");
				 driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
				 }else{
					 Assert.fail("Header not displayed on the screen");
				 }
			  }
			}
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			  
	  }
	  public static void VerifyLinkPages_FlightNumberAndFlightRoute(WebDriver driver,String link) throws InterruptedException, IOException{
		  JavascriptExecutor js= (JavascriptExecutor) driver;
		    js.executeScript("return document.readyState").equals("complete");
		  driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
			int nooflinks = driver.findElements(By.xpath(Footer_links_list_xpath)).size();
			for(int i=1; i<=nooflinks;i++){
			driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS); 
			String linktext=driver.findElement(By.xpath(Footer_links_firstxpath+i+Footer_links_secondxpath)).getText();
			if(linktext.equals(link)){  
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS); 
			WebDriverWait ww = new WebDriverWait(driver,1000);
			 js.executeScript("return document.readyState").equals("complete");
			ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Footer_links_firstxpath+i+Footer_links_secondxpath)));
			js.executeScript("arguments[0].click();",driver.findElement(By.xpath(Footer_links_firstxpath+i+Footer_links_secondxpath)));
		//	driver.findElement(By.xpath(Footer_links_firstxpath+i+Footer_links_secondxpath)).click();
			driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);
		   js.executeScript("return document.readyState").equals("complete");
		   Thread.sleep(1000);
			 String pageheader = driver.findElement(By.xpath(page_header_xpath)).getText();
			  driver.manage().timeouts().implicitlyWait(30000,TimeUnit.SECONDS);
			  ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FlightNum_FlightRoute_xpath)));
			  String FilghtNumAndRoute= driver.findElement(By.xpath(FlightNum_FlightRoute_xpath)).getText();
			// System.out.println("pageheader is:"+pageheader);
			if(pageheader.contains(FilghtNumAndRoute)){
				 driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
					 System.out.println(link + "Page FlightNumber and Route displayed on page header");
					 driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
				 }else{
					 Assert.fail("FlightNumber and Route not displayed on page header");
				 }
			  }
			}
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			  
	  }
	  
	  public static void VerifyLinkPages_NewOrderButton(WebDriver driver,String link) throws InterruptedException{
		  JavascriptExecutor js= (JavascriptExecutor) driver;
		    js.executeScript("return document.readyState").equals("complete");
		   driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
			int nooflinks = driver.findElements(By.xpath(Footer_links_list_xpath)).size();
			for(int i=1; i<nooflinks;i++){
			driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS); 
			 WebDriverWait ww = new WebDriverWait(driver,100);
			 ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Footer_links_firstxpath+i+Footer_links_secondxpath)));
			String linktext=driver.findElement(By.xpath(Footer_links_firstxpath+i+Footer_links_secondxpath)).getText();
			if(linktext.equals(link)){  
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS); 
			js.executeScript("return document.readyState").equals("complete");
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS); 
			js.executeScript("arguments[0].click();",driver.findElement(By.xpath(Footer_links_firstxpath+i+Footer_links_secondxpath)));
			Thread.sleep(500);
			//driver.findElement(By.xpath(Footer_links_firstxpath+i+Footer_links_secondxpath)).click();
			driver.manage().timeouts().implicitlyWait(30000,TimeUnit.SECONDS);
		 //js.executeScript("return document.readyState").equals("complete");
			ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NewOrder_btn_xpath)));
		    WebElement button = driver.findElement(By.xpath(NewOrder_btn_xpath));
			  driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
			  driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
			  if(button.isDisplayed()){
					 System.out.println(link+ " "+"page, NewOrder button displayed on the screen");
				 }else{
					 Assert.fail(link+ " "+"page,NewOrder button not displayed on the screen");
				 }
			  driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
			   }
			}
	  }
	  
	 
	 public static void VerifyNewOrderbutton(WebDriver driver){
		 JavascriptExecutor js= (JavascriptExecutor) driver;
		    js.executeScript("return document.readyState").equals("complete");
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		WebElement neworderbutton = driver.findElement(By.xpath(NewOrder_btn_xpath));
		if(neworderbutton.isDisplayed()){
		System.out.println("New Order button displayed on the screen");
		   }else{
			   Assert.fail("New Order button not displayed on the screen"); 
		   }
	 }
	
	 public static void VerifyMessagespopup(WebDriver driver){
		 JavascriptExecutor js= (JavascriptExecutor) driver;
		    js.executeScript("return document.readyState").equals("complete");
		 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		 String total =  driver.findElement(By.xpath(Panel_total_firstxpath+3+Panel_total_secondxpath)).getText();
			int totalMessages =Integer.parseInt(total); 
			 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			 driver.findElement(By.xpath(Panel_name_firstxpath+3+Panel_name_secondxpath)).click();
			 switchControlToLatestWindow(driver); 
			 driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
			int Messagescount = driver.findElements(By.xpath(popupmessages_count_xpath)).size();
			if(totalMessages> 0|| totalMessages== Messagescount ){
				String messagetext = driver.findElement(By.xpath(popupmessages_count_xpath)).getText();
				System.out.println("Message:"+ " "+messagetext +" "+ "is Displyed and count matched");
				 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			   }else{
				   Assert.fail("no messages");
			   }
			driver.findElement(By.xpath(popup_close_btn_xpath)).click();
	  }
    
     public static void VerifyOrders(WebDriver driver){
    	 JavascriptExecutor js= (JavascriptExecutor) driver;
		    js.executeScript("return document.readyState").equals("complete");
    	 String totalorder =  driver.findElement(By.xpath(Panel_total_firstxpath+1+Panel_total_secondxpath)).getText();
			String[] total1 = totalorder.split("/");
			int orderstotal =Integer.parseInt(total1[0]);
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			  driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
				 driver.findElement(By.xpath(Panel_name_firstxpath+1+Panel_name_secondxpath)).click();
				int salestotal = driver.findElements(By.xpath(SalesandRefund_orderrows_xpath)).size();
				String transactionmessage = driver.findElement(By.xpath(transactions_message_xpath)).getText();
				if(transactionmessage.equals("No Transactions")){
					System.out.println("No transactions");
				}else if(orderstotal > 0 || orderstotal==salestotal){
					System.out.println("New orders displayed and count matched");
				} else{
					Assert.fail("New Orders not displayed and count did not match"); 
				}
				
		 }
     public static void VerifyRefunds(WebDriver driver){
    	 JavascriptExecutor js= (JavascriptExecutor) driver;
		    js.executeScript("return document.readyState").equals("complete");
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			 String refundtotal =  driver.findElement(By.xpath(Panel_total_firstxpath+2+Panel_total_secondxpath)).getText();
			  int refundstotal =Integer.parseInt(refundtotal);
			  driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
				 driver.findElement(By.xpath(Panel_name_firstxpath+1+Panel_name_secondxpath)).click();
				int totalRefunds = driver.findElements(By.xpath(SalesandRefund_Refundrows_xpath)).size();
				String transactionmessage = driver.findElement(By.xpath(transactions_message_xpath)).getText();
				if(transactionmessage.equals("No Transactions")){
					System.out.println("No transactions");
				}else if(refundstotal > 0||refundstotal==totalRefunds){
					System.out.println("Refunds displayed and count matched");
				} else{
					Assert.fail("Refunds not displayed and count did not match"); 
				}
		 }
  
     public static String CrewName(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
    	int CrewCount = driver.findElements(By.xpath(CrewCount_xpath)).size();
    	String CrewName=null;
    	if(CrewCount > 1){
    		for(int i=1;i<=CrewCount;i++){
    			CrewName = driver.findElement(By.xpath(CrewName_firstxpath+"["+i+"]"+CrewName_secondxpath)).getText();
    			 System.out.println(CrewName);
    		}
    	}else{
    		CrewName = driver.findElement(By.xpath(CrewName_firstxpath+CrewName_secondxpath)).getText();
    		System.out.println(CrewName);
    	}
    	 
    	return CrewName;
     }
     public static String Selected_Crew(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
    	String CrewName = driver.findElement(By.xpath("html/body/section[1]/nav/div[2]/ul/li[3]/a/span[1]")).getText();
    	 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
       System.out.println(CrewName);
    	return CrewName;
     }
   
     public static String FlightDate(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
    	 String FlightDetails = driver.findElement(By.xpath(Flight_Details_xpath)).getText();
    	 String[] String1 = FlightDetails.split(" ");
    	 String[] String2 = String1[1].split("\\)");
    	 String FlightDate = String2[1]+" "+String1[2]+" "+ String1[3]+" "+String1[4];
    	System.out.println(FlightDate);
    	return FlightDate;
     }
     
     public static int DashBoard_FlightNum(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
    	 String FlightDetails = driver.findElement(By.xpath(Flight_Details_xpath)).getText();
    	 String[] String1 = FlightDetails.split(" ");
    	 String Num =String1[0];
    	 int FlightNum=Integer.parseInt(Num);
    	// System.out.println(FlightNum);
    	 return FlightNum;
     }
     
     public static String DashBoard_Flight_Route(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
    	 String FlightDetails = driver.findElement(By.xpath(Flight_Details_xpath)).getText();
    	 String[] String1 = FlightDetails.split(" ");
    	 String[] String2 = String1[1].split("\\(");
    	 String[] String3=String2[1].split("\\)");
    	 String Route =String3[0];
    	// System.out.println(Route);
    	 return Route;
     }
     
     public static void Verify_Flow_Preferennce(WebDriver driver,String Optionvalue){
    	 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
    	 String Value1 = "Flights Dashboard";
    	 String Value2 = "Orders Dashboard";
    	 String Value3 = "Shopping Cart";
    	 if(Optionvalue.equalsIgnoreCase(Value1)){
    		 String Url = "http://egate-solutions.azurewebsites.net/dashboard.html";
    		String ActualURL= driver.getCurrentUrl();
    		if(ActualURL.equalsIgnoreCase(Url)){
    			System.out.println("Flow is as expected and current page is Flights Dashboard page");
    		}else{
    			Assert.fail("Flow is not as defined");
    		}
    	 }else if(Optionvalue.equalsIgnoreCase(Value2)){
    		 String Url = "http://egate-solutions.azurewebsites.net/sales.html";
     		String ActualURL= driver.getCurrentUrl();
     		if(ActualURL.equalsIgnoreCase(Url)){
     			System.out.println("Flow is as expected and Current page is OrdersDashBoard page");
     		}else{
     			Assert.fail("Flow is not as defined");
     		}
    	 }else if(Optionvalue.equalsIgnoreCase(Value3)){
    		 String Url = "http://egate-solutions.azurewebsites.net/shoppingcart.html";
     		String ActualURL= driver.getCurrentUrl();
     		if(ActualURL.equalsIgnoreCase(Url)){
     			System.out.println("Flow is as expected and current page is shoppingcart page");
     		}else{
     			Assert.fail("Flow is not as defined");
     		}
    	 
    	 }
    	 }
    
}
