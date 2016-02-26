package com.commons;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class common extends utilities{
	static WebElement element=null;
	public static String Cal_rows = "html/body/div[3]/div[1]/table/tbody/tr";
	public static String Cal_colms = "html/body/div[3]/div[1]/table/tbody/tr/td";
	 public static String calprevMonthbtn_xpath = "html/body/div[3]/div[1]/table/thead/tr/th[@class='prev']";
	 public static String calnextMonthbtn_xpath = "/html/body/div[3]/div[1]/table/thead/tr/th[@class='next']";
	
	 public static String Numpadpopup_firstpath ="//div[@class='mbsc-np-row']/div[text()='";
	 public static String Numpadpopup_secondpath ="']";
	 public static String Numpadpopup_Set_btn_xpath = "//div[text()='Set']";
	 public static String Numpadpopup_Clear_btn_xpath = "//div[text()='Clear']";
	
	public static void pickmonth(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath(calnextMonthbtn_xpath)).click();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	} 
	public static void pickyear(WebDriver driver){
	
		
	}
	//portal calendar
	public static void pickdate(WebDriver driver,String date) throws IOException{
		List<WebElement> list = driver.findElements(By.xpath("html/body/div[3]/div[1]/table/tbody/tr/td"));
		for (WebElement element: list){  
			   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		
		   String Date= element.getText();
		// System.out.println(Date);
		   if(Date.equals(date)){
			   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			   element.click();
			   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			   break;
		       }
	
		   }  
	}
	
	public static void pickdate1(WebDriver driver) throws IOException{
		List<WebElement> list = driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div/div"));
		for (WebElement element: list){  
			   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		   String Date= element.getAttribute("class");
		 //  System.out.println(Date);
		  
		   if(Date.equals("dw-cal-day  dw-cal-day-v dwb-e dwb-nhl")){
			   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			   element.click();
			   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			   break;
		       }
		   }  
	}
	public static void pickdate2(WebDriver driver,String date) throws IOException{
		List<WebElement> list = driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div/div/div/div[1]"));
		for (WebElement element: list){  
			   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		// String value= element.getAttribute("class");
		 //  System.out.println(value);
		   String Date= element.getText();
		  
		 System.out.println(Date);
		   if(Date.equals(date)){
			   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			   element.click();
			   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			   break;
		       }
		   }  
	}
	
	
	public static void pickdate3(WebDriver driver) throws IOException{
		List<WebElement> list = driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[3]/div[2]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div/div/div/div[1]"));
		for (WebElement element: list){  
			   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
			   String DATE_FORMAT = "MM/dd/yyyy";
			    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
			    long base=System.currentTimeMillis(); 
			     int M=1;
			    Date sdate=new Date(base+M*24*60*60*1000);  
		        String DATE = sdf.format(sdate);
		        String[] from = DATE.split("/");
		        String scheduleDate = from[1];
		   String Date= element.getText();
		  
		// System.out.println(Date);
		   if(Date.equals(scheduleDate)){
			   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			   element.click();
			   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			   break;
		       }
		
		   }  
	}
	public static void JavaScriptExecutor_ElementClick(WebDriver driver,WebElement element){
		 JavascriptExecutor js1= (JavascriptExecutor) driver;
		    js1.executeScript("arguments[0].click();", element);
	}
	public static void Wait_Until_ElementVisible(WebDriver driver,String elementxpath){
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		WebDriverWait  ww = new WebDriverWait(driver,500);
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementxpath)));
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
	}
	public static void Wait_Until_ElementClickable(WebDriver driver,String elementxpath){
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		WebDriverWait  ww = new WebDriverWait(driver,500);
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		ww.until(ExpectedConditions.elementToBeClickable(By.xpath(elementxpath)));
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
	}
	public static void Wait_Until_ElementInVisible(WebDriver driver,String elementxpath){
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		WebDriverWait  ww = new WebDriverWait(driver,500);
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		ww.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementxpath)));
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
	}
	 public static void switchControlToLatestWindow(WebDriver driver) {
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	
	 }

	public static void NumpadValue(WebDriver driver,String value){
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Numpadpopup_firstpath + value + Numpadpopup_secondpath)).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	public static void Numpad_Clear_Click(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Numpadpopup_Clear_btn_xpath)).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	public static void Numpad_Set_Click(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Numpadpopup_Set_btn_xpath)).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	public static void Redirectsystemout(WebDriver driver) throws IOException{
	    File file = new File("C:\\Users\\labbaraju\\workspace\\ResultsOutput\\ResultsOutput.txt");
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		 System.setOut(ps);

	   }
	public static void Navigate_To_URL(WebDriver driver,String URL){
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		driver.navigate().to(URL);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
}
