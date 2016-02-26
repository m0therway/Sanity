package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostFlight {
	 WebDriver driver = null;
		public static String ScheduleNum_dpdn_xpath="//div/select[@name='scheduleNumber']";
		public static String ScheduleDate_fld_xpath="//input[@name='Schedule Date *']";
		public static String DepartureStation_fld_xpath="//div/select[@name='departureStation']";
		public static String ArrivalStation_fld_xpath="//div/select[@name='arrivalStation']";
		public static String TailNum_fld_xpath="//div/select[@name='tailNumber']";
		public static String EmployeeIdS_fld_xpath="html/body/div[1]/div/div[1]/form/div/div[2]/div[3]/div[3]/div/div/div/input";
		public static String EmployeeID_count_xpath="html/body/div[1]/div/div[1]/form/div/div[2]/div[3]/div[3]/div/div/ul/li/div";
		public static String EmployeeID_firstxpath="html/body/div[1]/div/div[1]/form/div/div[2]/div[3]/div[3]/div/div/ul/li/div";
		public static String EmployeeID_secondxpath="/a";
		public static String Save_btn_xpath="//div/button[@ng-click='formSave()']";
		
		public static void Create_PostTrip_Schedule(WebDriver driver){
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath(EmployeeIdS_fld_xpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath(EmployeeID_firstxpath+"["+1+"]"+EmployeeID_secondxpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath(EmployeeIdS_fld_xpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath(EmployeeID_firstxpath+"["+2+"]"+EmployeeID_secondxpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
		}
		
		public static void Save(WebDriver driver){
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath(Save_btn_xpath)).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}
		
}
