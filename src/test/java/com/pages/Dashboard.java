package com.pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Dashboard {
	WebDriver driver = null;
	public static String Home_Navigation_xpath="html/body/top-navigation-bar/nav/div/div[1]";
	public static String DashBoard_Sections_count_xpath = "html/body/div[1]/div/div";
	public static String DashBoard_Section_Header_firstxpath = "html/body/div[1]/div/div";
	public static String DashBoard_Section_Header_secondxpath = "/div/h3";
	public static String Menucount_first_xpath ="html/body/div[1]/div/div[";
	public static String Menucount_second_xpath ="]/div/div";
	public static String Menu_Name_firstxpath = "html/body/div[1]/div/div";
	public static String Menu_Name_secondxpath = "/div/div";
	public static String Menu_Name_thirdxpath = "/a/div";
	public static String Menu_link_firstxpath = "html/body/div[1]/div/div";
	public static String Menu_link_secondxpath = "/div/div";
	public static String Menu_link_thirdxpath = "/a/i";
	public static String Left_NavigationMenu_Count="//div/left-navigation/div[1]/div/ul/li";
	public static String Left_NavigationMenu_firstxpath ="//div/left-navigation/div[1]/div/ul/li[";
	public static String Left_NavigationMenu_secondxpath ="]/descendant::div/i";
	
	
	public static int DashBoard_Sections(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		int Sections = driver.findElements(By.xpath(DashBoard_Sections_count_xpath)).size();
		return Sections;
		
	}
	public static int DashBoard_Section_Menus(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		int Sections = Dashboard.DashBoard_Sections(driver);
		int Menus =0;
		for(int i=1;i<=Sections;i++){
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		 Menus = driver.findElements(By.xpath(Menucount_first_xpath+i+Menucount_second_xpath)).size();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		}
		return Menus;
		
	}
	
	public static String DashBoard_Section_Name(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		int sections=Dashboard.DashBoard_Sections(driver);
		String Section_Name=null;
		if(sections > 1){
		for(int i=1;i<=sections;i++){
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		Section_Name=driver.findElement(By.xpath(DashBoard_Section_Header_firstxpath+"["+i+"]"+DashBoard_Section_Header_secondxpath)).getText();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		System.out.println(Section_Name);
		}
		}else{
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			Section_Name=driver.findElement(By.xpath(DashBoard_Section_Header_firstxpath+DashBoard_Section_Header_secondxpath)).getText();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			System.out.println(Section_Name);
		}
		return Section_Name;
	}
    public static String DashBoard_Section_Menu_Name(WebDriver driver){
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		int sections=Dashboard.DashBoard_Sections(driver);
		int menus=Dashboard.DashBoard_Section_Menus(driver);
		String Menu_Name=null;
		if(sections > 1 || menus > 1){
			for(int i=1;i<=sections;i++){
				for(int j=1;j<=menus;j++){
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
					Menu_Name= driver.findElement(By.xpath(Menu_Name_firstxpath+"["+i+"]"+Menu_Name_secondxpath+"["+j+"]"+Menu_Name_thirdxpath)).getText();
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
					System.out.println(Menu_Name);
				}
			}
			
		}else if(sections > 1 || menus == 1){
			for(int i=1;i<=sections;i++){
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
				Menu_Name= driver.findElement(By.xpath(Menu_Name_firstxpath+"["+i+"]"+Menu_Name_secondxpath+Menu_Name_thirdxpath)).getText();
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
				System.out.println(Menu_Name);	
			}
		}else{
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			Menu_Name= driver.findElement(By.xpath(Menu_Name_firstxpath+Menu_Name_secondxpath+Menu_Name_thirdxpath)).getText();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			System.out.println(Menu_Name);	
		}
		return Menu_Name;
		
	}
	
  public static void Navigate_to_Homepage(WebDriver driver) throws InterruptedException{
	  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
	  WebDriverWait ww = new WebDriverWait(driver,70);
	  ww.until(ExpectedConditions.elementSelectionStateToBe(By.xpath(Home_Navigation_xpath), true));
	  driver.findElement(By.xpath(Home_Navigation_xpath)).click(); 
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
  }
	
	public static void Navigating_to_Menu(WebDriver driver,String section,String menu) throws InterruptedException{
		 WebDriverWait ww = new WebDriverWait(driver,70);
			ww.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("html/body/loading-modal/div/div/div/div/p")));

		  ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DashBoard_Sections_count_xpath)));
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		int sections = driver.findElements(By.xpath(DashBoard_Sections_count_xpath)).size();
		int i =1;
		String Header =null;
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		do{
			Header = driver.findElement(By.xpath(DashBoard_Section_Header_firstxpath+"["+i+"]"+DashBoard_Section_Header_secondxpath)).getText();
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			if(Header.equalsIgnoreCase(section)){
				int menus = driver.findElements(By.xpath(Menucount_first_xpath+i+Menucount_second_xpath)).size();
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
				for(int j=1;j<=menus;j++){
					String Actualmenu = driver.findElement(By.xpath(Menu_Name_firstxpath+"["+i+"]"+Menu_Name_secondxpath+"["+j+"]"+Menu_Name_thirdxpath)).getText();
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
					if(Actualmenu.equalsIgnoreCase(menu)){
						 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);        
						driver.findElement(By.xpath(Menu_link_firstxpath+"["+i+"]"+Menu_link_secondxpath+"["+j+"]"+Menu_link_thirdxpath)).click();
						break;
					    }
				      }
				break;
				    }
			i++;
		}while(i<=sections);
		 driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);  
		
		}
	
	
}
