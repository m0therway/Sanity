package com.pages;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.commons.actions;
import com.commons.utilities;

public class Discounts extends utilities{
	 public static String DiscountTab_xpath =".//*[@id='Payment']/div[3]/div[2]/div/div[1]/ul/li[2]/a[text()='Discount']";
	 public static String FrequentFlyerTab_xpath =".//*[@id='DiscountDetails']/ul/li[1]/a[text()='Frequent Flyer']";
	 public static String CouponTab_xpath =".//*[@id='DiscountDetails']/ul/li[2]/a[text()='Coupon']";
	 public static String DiscountTab_list_xpath = ".//*[@id='DiscountDetails']/ul/li";
	 public static String DiscountTab_listName_firstxpath = ".//*[@id='DiscountDetails']/ul/li[";
	 public static String DiscountTab_listName_secondxpath ="]/a";
	 public static String FrequentFlyer_dpdn_xpath=".//*[@id='FreqFlDetails']/div[1]/div[1]/div/select[2]";
	 public static String FrequentFlyer_dpdn_options_xpath=".//*[@id='FreqFlDetails']/div[1]/div[1]/div/select[2]/option";
	 //public static String FrequentFlyerNumber_fld_xpath=".//*[@id='FreqFlDetails']/div[1]/div[2]/div/input";
	 public static String FrequentFlyerNumber_fld_xpath=".//*[@id='ffNumber']";
	 public static String FrequentFlyerApply_btn_xpath=".//*[@id='FreqFlDetails']/div[2]/div/button";
	 public static String Coupon_dpdn_xpath = ".//*[@id='CouponDetails']/div[1]/div/div/select[2]";
	 public static String CouponApply_btn_xpath = ".//*[@id='CouponDetails']/div[2]/div/button";
	 public static String AppliedDiscounts_list_xpath=".//*[@id='pnlShoppingCart']/div[3]/div/div";
	 public static String AppliedCupon_list_xpath=".//*[@id='pnlShoppingCart']/div[3]/div/div";
	 public static String AppliedDiscounts_text_firstxpath=".//*[@id='pnlShoppingCart']/div[3]/div/div[";
	 public static String AppliedDiscounts_text_second_xpath ="]";
	 public static String AppliedDiscounts_Amount_xpath=".//*[@id='pnlShoppingCart']/div[3]/div/div/span";
	 public static String AppliedCoupon_Amount_xpath=".//*[@id='pnlShoppingCart']/div[3]/div/div/span";
	 public static String Sub_Total_xpath=".//*[@id='pnlShoppingCart']/div[2]/section[1]/h4/span";
	 public static String AfterDiscounts_Total_xpath = ".//*[@id='pnlShoppingCart']/div[3]/h4/span";
	 public static String Discount_Transactions_xpath=".//*[@id='pnlShoppingCart']/div[3]/div/div";
	 public static String Discount_Removal_Button_firstxpath = ".//*[@id='pnlShoppingCart']/div[3]/div/div[";
	 public static String Discount_Removal_Button_secondxpath = "]/button";
	 
	 public static void VerifyDiscountScreen(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		int tabs=driver.findElements(By.xpath(DiscountTab_list_xpath)).size();
		if(tabs==2){
		System.out.println("two tabs are dispalyed under discounts");
		for(int i=1;i<=tabs;i++){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			  String tabName=driver.findElement(By.xpath(DiscountTab_listName_firstxpath+i+DiscountTab_listName_secondxpath)).getText();
	    	  System.out.println("Tab name is: "+" "+tabName);
			}
		}else{
			Assert.fail("Tabs are not displayed");
		}
	 }
	 public static void Discount(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 driver.findElement(By.xpath(DiscountTab_xpath)).click(); 
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	 }
	 public static void Coupon(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 driver.findElement(By.xpath(CouponTab_xpath)).click(); 
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	 }
	public static void Verify_BalanceDue_AfterCupon(){
		
	}
     public static void VerifyFreqentFlyerDropDown(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 WebElement FreqentFdpdn=driver.findElement(By.xpath(FrequentFlyer_dpdn_xpath));
 		Select FreqentFlyerdpdn = new Select(driver.findElement(By.xpath(FrequentFlyer_dpdn_xpath)));
		List<WebElement> allOptions = FreqentFlyerdpdn.getOptions();
		String[] Option ={"Bronze Frequent Flyer Card","Gold Frequent Flyer Card","Silver Frequent Flyer Card"};
		if(FreqentFdpdn.isDisplayed()){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
 			System.out.println("Freqent Flyer dropdown displayed");
		for(int i=0;i<Option.length;i++){
			for(int j=0;j<allOptions.size();j++){
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String optionvalue = allOptions.get(j).getText();
			 if(optionvalue.equalsIgnoreCase(Option[i])){
					System.out.print(optionvalue+" "+ "Option matched;"+" ");
				}
			 }
		   }
		}else{
			Assert.fail("Freqent Flyer dropdown not displayed");
		}
	 }
     
     public static void VerifyCuponDropDown(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 WebElement Cupondpdn=driver.findElement(By.xpath(Coupon_dpdn_xpath));
 		Select Cupondroppdn = new Select(driver.findElement(By.xpath(FrequentFlyer_dpdn_xpath)));
		List<WebElement> allOptions = Cupondroppdn.getOptions();
		String[] Option ={"10% off"};
		if(Cupondpdn.isDisplayed()){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
 			System.out.println("Cupon dropdown displayed");
		for(int i=0;i<Option.length;i++){
			for(int j=0;j<allOptions.size();j++){
				 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			String optionvalue = allOptions.get(j).getText();
			 if(optionvalue.equalsIgnoreCase(Option[i])){
					System.out.print(optionvalue+" "+ "Option matched;"+" ");
				}
			 }
		   }
		}else{
			Assert.fail("Cupon dropdown not displayed");
		} 
	 }
    public static void VerifyFrequentFlyerNumberField(WebDriver driver){
	   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  	   WebElement FreqentFNumFld=driver.findElement(By.xpath(FrequentFlyerNumber_fld_xpath));
  	 if(FreqentFNumFld.isDisplayed()){
  		FreqentFNumFld.sendKeys("1323131311");
  		System.out.println("FreqentFNumFld is displayed and enabled");
  	      }else{
  		     Assert.fail("FreqentFNumFld is not displayed");
  	    }
	 }
   
	 public static void VerifyCuponApplybutton(WebDriver driver){
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	   	   WebElement CouponApply=driver.findElement(By.xpath(CouponApply_btn_xpath));
	   	 if(CouponApply.isDisplayed()){
	   		CouponApply.click();
	   		System.out.println("Coupon Pay/Apply button is displayed and enabled");
	   	      }else{
	   		     Assert.fail("Coupon Pay/Apply button is not displayed");
	   	    } 
	 }
	 public static void VerifyFrequentFlyerApplybutton(WebDriver driver){
	 	   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	   	   WebElement FrequentFlyerApplybutton=driver.findElement(By.xpath(FrequentFlyerApply_btn_xpath));
	   	 if(FrequentFlyerApplybutton.isDisplayed()){
	   		FrequentFlyerApplybutton.click();
	   		System.out.println("FrequentFlyer Pay/Apply button is displayed and enabled");
	   	      }else{
	   		     Assert.fail("Discount Pay/Apply button is not displayed");
	   	    }
	 	 }
    public static void ApplyFlyerDiscount(WebDriver driver, String FlyerDiscount){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 driver.findElement(By.xpath(DiscountTab_xpath)).click(); 
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 actions.selectByVisibleText(driver, "xpath", FrequentFlyer_dpdn_xpath , FlyerDiscount);
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 driver.findElement(By.xpath(FrequentFlyerNumber_fld_xpath)).sendKeys("121313231");
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 driver.findElement(By.xpath(FrequentFlyerApply_btn_xpath)).click();
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }
    public static void ApplyCupon(WebDriver driver,int index){
   	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
   	 driver.findElement(By.xpath(DiscountTab_xpath)).click(); 
   	 Discounts.Coupon(driver);
   	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
   	 actions.selectByindex(driver, "xpath", Coupon_dpdn_xpath , index);
   	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
   	 driver.findElement(By.xpath(CouponApply_btn_xpath)).click();
   	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
   }
    public static String SelectedFlyerDiscount(WebDriver driver,int option){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 Select FreqentFlyerdpdn = new Select(driver.findElement(By.xpath(FrequentFlyer_dpdn_xpath)));
 		List<WebElement> allOptions = FreqentFlyerdpdn.getOptions();
    	  actions.selectByindex(driver, "xpath", FrequentFlyer_dpdn_xpath, option);
          String SelectedDiscount=allOptions.get(option).getText();
    	// System.out.println(SelectedDiscount);
		return SelectedDiscount;
    }
    public static String SelectedCupon(WebDriver driver,int option){
   	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
   	 Select FreqentFlyerdpdn = new Select(driver.findElement(By.xpath(Coupon_dpdn_xpath)));
		List<WebElement> allOptions = FreqentFlyerdpdn.getOptions();
   	    actions.selectByindex(driver, "xpath", Coupon_dpdn_xpath, option);
         String SelectedCupon=allOptions.get(option).getText();
   	 //   System.out.println(SelectedCupon);
		return SelectedCupon;
   }
    public static String AppliedFlyerDiscount(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 String Discount=driver.findElement(By.xpath(AppliedDiscounts_list_xpath)).getText();
    	 String[] string1=Discount.split(" ");
    	 String AppliedDiscount= string1[0]+" "+string1[1]+" "+string1[2]+" "+string1[3];
    	// System.out.println(AppliedDiscount);
		return AppliedDiscount;
    }
    public static String AppliedCoupon(WebDriver driver){
   	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
   	 String cupon=driver.findElement(By.xpath(AppliedCupon_list_xpath)).getText();
   	 String[] string1=cupon.split(" ");
   	 String AppliedCupon= string1[0]+" "+string1[1] ;
   	// System.out.println(AppliedCupon);
		return AppliedCupon;
   }
    
   public static float SubTotal(WebDriver driver) throws IOException{
	   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	   String total=driver.findElement(By.xpath(Sub_Total_xpath)).getText();
	   	 String[] string1=total.split("\\"+getValue("CurrencySymbol1"));
	   	float  SubTotal= Float.valueOf(string1[1].trim()).floatValue();
	//	System.out.println("Subtotal is" + SubTotal);
		return SubTotal; 
	}
   
   public static float AfterDiscounts_BalanceDue(WebDriver driver) throws IOException{
	   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	   String total=driver.findElement(By.xpath(AfterDiscounts_Total_xpath)).getText();
	   	 String[] string1=total.split("\\"+getValue("CurrencySymbol1"));
	   	float  AfterDiscounts_Total= Float.valueOf(string1[1].trim()).floatValue();
	   //	System.out.println(AfterDiscounts_Total);
		return AfterDiscounts_Total; 
	}
   public static float Calculated_BalanceDue_AfterCoupon_Discounts(WebDriver driver) throws IOException{
	   	float  AfterDiscounts_Total= Discounts.SubTotal(driver) - Discounts.Calculated_CuponAmount(driver);
	  // 	System.out.println("AfterDiscounts_Total is"+ ""+ AfterDiscounts_Total);
		return AfterDiscounts_Total; 
	}
	public static float ActualCuponAmount(WebDriver driver) throws IOException{
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		   String Amount=driver.findElement(By.xpath(AppliedCoupon_Amount_xpath)).getText();
		   	 String[] string1=Amount.split("\\"+getValue("CurrencySymbol1"));
		   	float  CuponAmount= Float.valueOf(string1[1].trim()).floatValue();
			//System.out.println(CuponAmount);
			return CuponAmount; 
	}
	public static float Calculated_CuponAmount(WebDriver driver) throws IOException{
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	String coupon=	 Discounts.AppliedCoupon(driver);
	String[] String1=coupon.split(" ");
	String[] String2=String1[0].split("\\%");
	String String3 = String2[0];
	int num=Integer.parseInt(String3);
	float CalculatedCuponAmount = (Discounts.SubTotal(driver)/100)*num;
	//System.out.println("CalculatedCuponAmount"+CalculatedCuponAmount);
			return CalculatedCuponAmount; 
	}
	
	public static float FlyerDiscountAmount(WebDriver driver) throws IOException{
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		   String Amount=driver.findElement(By.xpath(AppliedDiscounts_Amount_xpath)).getText();
		   	 String[] string1=Amount.split("\\"+getValue("CurrencySymbol1"));
		   	float  DiscountAmount= Float.valueOf(string1[1].trim()).floatValue();
		  System.out.println(DiscountAmount);
			return DiscountAmount; 
	}
	
	public static float Calculated_Gold_FlyerDiscountAmount(WebDriver driver) throws IOException{
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String GoldFlyerDisc=getValue("GoldFlyerDiscount");
		String[] Discount=GoldFlyerDisc.split("\\%");
		String String3 = Discount[0];
		int num=Integer.parseInt(String3);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		float Calculated_Gold_FlyerDiscountAmount =(Discounts.SubTotal(driver)/100)*num;
		String formattedString = String.format("%.3f", Calculated_Gold_FlyerDiscountAmount);
		float Gold_FlyerDiscountAmount=Float.valueOf(formattedString.trim()).floatValue();
		System.out.println(Gold_FlyerDiscountAmount);
				return Gold_FlyerDiscountAmount; 
	}
	public static float Calculated_Silver_FlyerDiscountAmount(WebDriver driver) throws IOException{
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String SilverFlyerDisc=getValue("SilverFlyerDiscount");
		String[] Discount=SilverFlyerDisc.split("\\%");
		String String3 = Discount[0];
		int num=Integer.parseInt(String3);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		float Calculated_Silver_FlyerDiscountAmount =(Discounts.SubTotal(driver)/100)*num;
		String formattedString = String.format("%.02f", Calculated_Silver_FlyerDiscountAmount);
		float Silver_FlyerDiscountAmount=Float.valueOf(formattedString.trim()).floatValue();
		System.out.println(Silver_FlyerDiscountAmount);
				return Silver_FlyerDiscountAmount; 
	}
	public static float Calculated_Bronze_FlyerDiscountAmount(WebDriver driver) throws IOException{
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String BronzeFlyerDisc=getValue("BronzeFlyerDiscount");
		String[] Discount=BronzeFlyerDisc.split("\\%");
		String String3 = Discount[0];
		int num=Integer.parseInt(String3);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		float Calculated_Bronze_FlyerDiscountAmount =(Discounts.SubTotal(driver)/100)*num;
		String formattedString = String.format("%.02f", Calculated_Bronze_FlyerDiscountAmount);
		float Bronze_FlyerDiscountAmount=Float.valueOf(formattedString.trim()).floatValue();
		System.out.println(Bronze_FlyerDiscountAmount);
				return Bronze_FlyerDiscountAmount;  
	}
	
	public static float CalculatedBalanceDue_AfterGoldFlyer_Discounts(WebDriver driver) throws IOException{
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	 	float  AfterDiscounts_Total= Discounts.SubTotal(driver) - Discounts.Calculated_Gold_FlyerDiscountAmount(driver);
		// System.out.println("AfterDiscounts_Total is"+ AfterDiscounts_Total);
			return AfterDiscounts_Total; 
		}
	public static float CalculatedBalanceDue_AfterSilverFlyer_Discounts(WebDriver driver) throws IOException{
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		float  AfterDiscounts_Total= Discounts.SubTotal(driver) - Discounts.Calculated_Silver_FlyerDiscountAmount(driver);
		//System.out.println("AfterDiscounts_Total is"+ AfterDiscounts_Total);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			return AfterDiscounts_Total; 
	}
	public static float CalculatedBalanceDue_AfterBronzeFlyer_Discounts(WebDriver driver) throws IOException{
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		float  AfterDiscounts_Total= Discounts.SubTotal(driver) - Discounts.Calculated_Bronze_FlyerDiscountAmount(driver);
		// System.out.println("AfterDiscounts_Total is"+ ""+ AfterDiscounts_Total);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			return AfterDiscounts_Total; 
	}
	
	public static void Verify_AppliedFlyer_DiscountAmount() throws IOException{
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 if(Discounts.AppliedFlyerDiscount(driver).equals("Gold Frequent Flyer Card")){
			Float expectedGold_Flyeramount=  Discounts.Calculated_Gold_FlyerDiscountAmount(driver);
			Float ActualGold_Flyeramount=Discounts.FlyerDiscountAmount(driver); 
			if(ActualGold_Flyeramount.equals(expectedGold_Flyeramount)){
			System.out.println("Gold Flyer Discount amount is correct, Amount is :" +" "+ expectedGold_Flyeramount );
			  }else{
					Assert.fail("Gold Flyer Discount amount is incorrect");
			  }
		 }else if(Discounts.AppliedFlyerDiscount(driver).equals("Silver Frequent Flyer Card")){
			 Float expectedSilver_Flyeramount=  Discounts.Calculated_Silver_FlyerDiscountAmount(driver);
				Float ActualSilver_Flyeramount=Discounts.FlyerDiscountAmount(driver); 
			 if(ActualSilver_Flyeramount.equals(expectedSilver_Flyeramount)){
					System.out.println("Silver Flyer Discount amount is correct, Amount is :" +" "+ expectedSilver_Flyeramount);
			 }else{
					Assert.fail("Silver Flyer Discount amount is incorrect");
			  }
		 }else if(Discounts.AppliedFlyerDiscount(driver).equals("Bronze Frequent Flyer Card")){
			 Float expectedBronze_Flyeramount=  Discounts.Calculated_Bronze_FlyerDiscountAmount(driver);
				Float ActualBronze_Flyeramount=Discounts.FlyerDiscountAmount(driver); 
				if(ActualBronze_Flyeramount.equals(expectedBronze_Flyeramount)){
					System.out.println("Bronze Flyer Discount amount is correct, Amount is :" +" "+ expectedBronze_Flyeramount);
				}else{
					Assert.fail("Bronze Flyer Discount amount is incorrect");
			  }
		 }else{
			 Assert.fail("Flyer Discount not available");
		 }
	}
	
	public static void Verify_BalanceDue_AfterFlyerDiscount() throws IOException{
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 String appliedDiscount  = Discounts.AppliedFlyerDiscount(driver);
		 if(appliedDiscount.equalsIgnoreCase("Gold Frequent Flyer Card")){
			Float expectedamount= Discounts.CalculatedBalanceDue_AfterGoldFlyer_Discounts(driver);
			System.out.println(expectedamount);
			Float Actualamount=Discounts.AfterDiscounts_BalanceDue(driver); 
			System.out.println(Actualamount);
			if(Actualamount.equals(expectedamount)){
				System.out.println("Gold Flyer Discount applied correctly and Balance due is:"+" "+expectedamount+" "+ "as expected");
			}else{
				Assert.fail("Gold Flyer Discount not applied correctly and Balance due is incorrect");
		  }
		 }else if(appliedDiscount.equalsIgnoreCase("Silver Frequent Flyer Card")){
			 Float expectedamount=  Discounts.CalculatedBalanceDue_AfterSilverFlyer_Discounts(driver);
			 System.out.println(expectedamount);
				Float Actualamount=Discounts.AfterDiscounts_BalanceDue(driver);
				System.out.println(Actualamount);
				if(Actualamount.equals(expectedamount)){
					System.out.println("Silver Flyer Discount applied correctly and Balance due is:"+" "+expectedamount+" "+ "as expected");
				}else{
					Assert.fail("Silver Flyer Discount is not applied correctly and Balance due is incorrect");
				} 
		 }else if(appliedDiscount.equalsIgnoreCase("Bronze Frequent Flyer Card")){
			 Float expectedamount=  Discounts.CalculatedBalanceDue_AfterBronzeFlyer_Discounts(driver);
			 System.out.println(expectedamount);
				Float Actualamount=Discounts.AfterDiscounts_BalanceDue(driver);
				System.out.println(Actualamount);
				if(Actualamount.equals(expectedamount)){
					System.out.println("Bronze Flyer Discount applied correctly and Balance due is:"+" "+expectedamount+" "+ "as expected");
				}else{
					Assert.fail("Bronze Flyer Discount is not applied correctly and Balance due is incorrect");
	 			} 
	       }else{
	    	  Assert.fail("unknown discount applied");  
	       }
	}
	
	public static void Remove_Applied_Discount(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		int Discounts = driver.findElements(By.xpath(Discount_Transactions_xpath)).size();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 for(int i=1;i<=Discounts;i++){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 driver.findElement(By.xpath(Discount_Removal_Button_firstxpath+i+Discount_Removal_Button_secondxpath)).click();
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 }
	}
	
	public static int Applied_Discounts_Count(){
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		int Discounts = driver.findElements(By.xpath(Discount_Transactions_xpath)).size();
		return Discounts;
	}
	
	public static void Verify_AppliedDiscount_isRemoved(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		int Discounts_Before_Delete = driver.findElements(By.xpath(Discount_Transactions_xpath)).size();
		Discounts.Remove_Applied_Discount(driver);
		int Discounts_after_Delete=driver.findElements(By.xpath(Discount_Transactions_xpath)).size();
		if(Discounts_after_Delete < Discounts_Before_Delete){
			System.out.println("Applied discount is deleted successfully");
		}else{
			Assert.fail("Unable to delete applied discount");
		}
	}
	
	public static void Verify_Applied_CuponDiscountAmount(WebDriver driver, int counponindex) throws IOException{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Float expectedCouponamount=  Discounts.Calculated_CuponAmount(driver);
		Float ActualCouponamount=Discounts.ActualCuponAmount(driver); 
		 if(Discounts.AppliedCoupon(driver).equals(Discounts.SelectedCupon(driver, counponindex))){
			
			if(ActualCouponamount.equals(expectedCouponamount)){
			System.out.println("Coupon Discount amount is correct, Amount is :" +" "+ ActualCouponamount );
			  }else{
					Assert.fail("Coupon Discount amount is incorrect");
			  }
		 }else{
			 Assert.fail("Applied coupon discount is not a selected coupon discount");
		 }
		 
		
	}
	public static void Verify_BalanceDue_After_CouponDiscount(WebDriver driver, int counponindex) throws IOException{
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 String appliedCoupon = Discounts.AppliedCoupon(driver);
		 if(appliedCoupon.equals(Discounts.SelectedCupon(driver, counponindex))){
			Float expectedamount= Discounts.Calculated_BalanceDue_AfterCoupon_Discounts(driver);
			System.out.println(expectedamount);
			Float Actualamount=Discounts.AfterDiscounts_BalanceDue(driver);
			System.out.println(Actualamount);
			if(Actualamount.equals(expectedamount)){
				System.out.println("Coupon Discount applied correctly and Balance due is:"+" "+expectedamount+" "+ "as expected");
			}else{
				Assert.fail("Coupon Discount not applied correctly and Balance due is incorrect");
		  }
		
	       }else{
	    	  Assert.fail("unknown discount applied");  
	       }
	}
}
