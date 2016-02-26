package com.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.commons.utilities;

public class Promotions extends utilities {
	public static String Panel_name_firstxpath ="html/body/section[2]/div[1]/div[" ;
	public static String Panel_name_secondxpath ="]/div/div/div[2]";
	public static String Panels_count_xpath = "html/body/section[2]/div[1]/div";
	public static String Panel_total_firstxpath ="html/body/section[2]/div[1]/div[" ;
	public static String Panel_total_secondxpath ="]/div/div/div[1]";
	public static String popupPromotions_count_xpath = "html/body/div[1]/div/div/div[2]/section[1]/div/a";
	public static String popupPromotions_text_firstxpath = "html/body/div[1]/div/div/div[2]/section[1]/div/a[";
	public static String popupPromotions_text_secondxpath = "]/h4";
	public static String popup_close_btn_xpath = "//button[text()='Close']" ;
	public static String Applied_Promotion_Count_xpath=".//*[@id='pnlShoppingCart']/div[2]/section[2]/h4";
	public static String Applied_Promotion_firstxpath=".//*[@id='pnlShoppingCart']/div[2]/section[2]/h4[";
	public static String Applied_Promotion_secondxpath="]/label";
	public static String Applied_Promotion_Amount_xpath=".//*[@id='pnlShoppingCart']/div[2]/section[2]/h4[1]/span";
	public static String BalanceDue_AfterPromotion_xpath=".//*[@id='pnlShoppingCart']/div[3]/h4/span";
	public static String SubTotal_xpath=".//*[@id='pnlShoppingCart']/div[2]/section[1]/h4/span";
	
	public static void switchControlToLatestWindow(WebDriver driver) {
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	
		 
	 }
	
	public static void VerifyPromotionspopup(WebDriver driver){
   	 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		 String total =  driver.findElement(By.xpath(Panel_total_firstxpath+4+Panel_total_secondxpath)).getText();
			int totalpromotions =Integer.parseInt(total); 
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			 driver.findElement(By.xpath(Panel_name_firstxpath+4+Panel_name_secondxpath)).click();
			 switchControlToLatestWindow(driver); 
			 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			int Promotionscount = driver.findElements(By.xpath(popupPromotions_count_xpath)).size();
			for(int i=1;i<=Promotionscount;i++){
			if(totalpromotions > 0 ||totalpromotions == Promotionscount ){
				 driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
				String promotions = driver.findElement(By.xpath(popupPromotions_text_firstxpath+i+popupPromotions_text_secondxpath)).getText();
				System.out.println("Promotions" + " " +promotions+" "+ "Displyed and count matched");
				 driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
				 
			}else{
				System.out.println("no promotions");
			 }
			}
			driver.findElement(By.xpath(popup_close_btn_xpath)).click();
	 }
    
	/* public static String applied_Promotion(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		 String applied_Promotion=driver.findElement(By.xpath(Applied_Promotion_xpath)).getText();
		return applied_Promotion;
	 }*/
	 
	 public static float applied_PromotionAmount(WebDriver driver) throws IOException{
		 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		 String Promotion=driver.findElement(By.xpath(Applied_Promotion_Amount_xpath)).getText();
		 String[] string = Promotion.split("\\-"+getValue("CurrencySymbol"));
				 float applied_Promotion=Float.valueOf(string[1].trim()).floatValue();
		return applied_Promotion;
	 }
	 
	 public static float Calculated_applied_PromotionAmount(WebDriver driver) throws IOException{
		
		return 0;
	 }
	 public static float BalanceDue_AfterPromotion(WebDriver driver) throws IOException{
		 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		   String total=driver.findElement(By.xpath(BalanceDue_AfterPromotion_xpath)).getText();
		   	 String[] string1=total.split("\\"+getValue("CurrencySymbol"));
		   	float  BalanceDue_AfterPromotion= Float.valueOf(string1[1].trim()).floatValue();
		   System.out.println(BalanceDue_AfterPromotion);
			return BalanceDue_AfterPromotion; 
	 }
	 public static float Calculated_BalanceDue_AfterPromotion(WebDriver driver) throws IOException{
			float  Calculated_BalanceDue_AfterPromotion= Promotions.SubTotal(driver) - Promotions.Calculated_applied_PromotionAmount(driver);
			System.out.println("AfterDiscounts_Total is"+ ""+ Calculated_BalanceDue_AfterPromotion);
				return Calculated_BalanceDue_AfterPromotion; 
		 }
	 
	 public static float SubTotal(WebDriver driver) throws IOException{
		   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		   String total=driver.findElement(By.xpath(SubTotal_xpath)).getText();
		   	 String[] string1=total.split("\\"+getValue("CurrencySymbol"));
		   	float  SubTotal= Float.valueOf(string1[1].trim()).floatValue();
	        System.out.println("Subtotal is" + SubTotal);
			return SubTotal; 
		}
	 public static String promotions(WebDriver driver){ 
    	 String promotions=null;
    	 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Panel_name_firstxpath+4+Panel_name_secondxpath)).click();
		 driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		 switchControlToLatestWindow(driver); 
		 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			int Promotionscount = driver.findElements(By.xpath(popupPromotions_count_xpath)).size();
			System.out.println(Promotionscount);
			for(int i=1;i<=Promotionscount;i++){
				 driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
				 driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
				 promotions = driver.findElement(By.xpath(popupPromotions_text_firstxpath+i+popupPromotions_text_secondxpath)).getText();
				 driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
				 System.out.println(promotions);
			}
		return promotions;
     }
	 
	 
	 public static int Panel_Promotions_Total(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		 String Promotions = driver.findElement(By.xpath(Panel_total_firstxpath+4+Panel_total_secondxpath)).getText();
		 int Total_Promotions = Integer.parseInt(Promotions);
		 System.out.println(Total_Promotions);
		return Total_Promotions;
	 }
	 
	 
	 
}
