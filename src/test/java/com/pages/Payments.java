package com.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.commons.actions;
import com.commons.common;
import com.commons.utilities;

public class Payments extends utilities{
	WebDriver driver=null;
	 public static String CheckOut_btn_xapth="/html/body/header/div/div[2]/h2/button";
	 //public static String SeatRow_dpdn_xpath =".//*[@id='Payment']/div[1]/div/div/div/select[1]";
	// public static String SeatRow_dpdn_xpath =".//*[@id='Payment']/div[2]/div/div/div/select[1]";
	 public static String SeatRow_dpdn_xpath =".//*[@id='CashDetails']/div[5]/div/div/div[2]/div[1]/div/div/select[1]";
	// public static String SeatRowSeat_dpdn_xpath =".//*[@id='Payment']/div[1]/div/div/div/select[2]";
	// public static String SeatRowSeat_dpdn_xpath =".//*[@id='Payment']/div[2]/div/div/div/select[2]";
	 public static String SeatRowSeat_dpdn_xpath =".//*[@id='CashDetails']/div[5]/div/div/div[2]/div[1]/div/div/select[2]";
	 public static String ShoppingCart_ItemName_xpath =".//*[@id='pnlShoppingCart']/table/tbody/tr/td[1]";
	 public static String ShoppingCart_ItemCount_xpath =".//*[@id='pnlShoppingCart']/div[1]/span";
	 public static String ShoppingCart_ItemRemove_btn_xpath =".//*[@id='pnlShoppingCart']/table/tbody/tr/td[4]/button";
	 public static String Tab_list_xpath = ".//*[@id='Payment']/div[3]/div[2]/div/div[1]/ul/li";
	 public static String Tab_Name_firstxpath =".//*[@id='Payment']/div[3]/div[2]/div/div[1]/ul/li[";
	 public static String Tab_Name_secondxpath="]/a";
	 public static String PaymentModes_count_xpath = ".//*[@id='PaymentDetails']/ul/li";
	 public static String PaymentMode_firstxpath =  ".//*[@id='PaymentDetails']/ul/li[";
	 public static String PaymentMode_secondxpath =  "]/a";
	// public static String SeatnumReq_Message_xpath = ".//*[@id='Payment']/div[1]/div/div/div/label[3]";
	// public static String SeatnumReq_Message_xpath = ".//*[@id='Payment']/div[2]/div/div/div/label[3]";
	// public static String SeatnumReq_Message_xpath = ".//*[@id='CreditDetails']/label[2]";
	 public static String SeatnumReq_Message_xpath = "//span[@data-bind='text: selectedSeat_HelpText']";
	 public static String EasyCash_btn_count_xpath = ".//*[@id='CashDetails']/div[2]/div/div/button";
	 public static String EasyCash_btn_value_firstxpath = ".//*[@id='CashDetails']/div[2]/div/div/button[";
	 public static String EasyCash_btn_value_secondxpath = "]";
	 public static String Exact_btn_xpath = ".//*[@id='CashDetails']/div[2]/div/button";
	 public static String CashAmount_fld_xpath = ".//*[@id='cashamount']";
	 public static String ChangeDue_xpath= ".//*[@id='CashTable']/tbody/tr[4]/td[2]/span";
	 public static String PayNow_btn_xpath="//button[@data-bind='click: cash_Save, text: payNowBtnText']";
	 public static String ChargeAmount_fld_xpath=".//*[@id='creditamount']";
	 public static String CreditCardnum_fld_xpath =".//*[@id='ccNumber']";
	 public static String Numpadpopup_firstpath ="//div[@class='mbsc-np-row']/div[text()='";
	 public static String Numpadpopup_secondpath ="']";
	 public static String Numpadpopup_Set_btn_xpath = "//div[text()='Set']";
	 public static String ExpirationDate_fld_xpath = ".//*[@id='Payment_ExpDate']";
	 public static String ProcessCard_btn_xpath=".//*[@id='CreditDetails']/button";
	 public static String CCPayNow_btn_xpath=".//*[@id='CreditDetails']/div[2]/div/button";
	 public static String PaymentMessage_xpath = ".//*[@id='CashTable']/tbody/tr[3]/td/span";
	 public static String CreditcardMessage_xpath =".//*[@id='CreditTable']/tbody/tr[4]/td[2]/div/span";
	// public static String BalanceDue_xpath = ".//*[@id='pnlShoppingCart']/div[3]/h4/span";
	 public static String Passenger_info_xpath=".//*[@id='PassengerInfo']";
	 public static String ChangeTendered_chkbx_xpath=".//*[@id='changeTendered']";
	// public static String PassengerName_xpath=".//*[@id='Payment']/div[2]/div/div/div/strong";
	 public static String PassengerName_xpath=".//*[@id='CashDetails']/div[5]/div/div/div[2]/div[2]";
	// public static String Passenger_SeatRow_xpath=".//*[@id='Payment']/div[2]/div/div/div/select[1]";
	 public static String Passenger_SeatRow_xpath=".//*[@id='CashDetails']/div[5]/div/div/div[2]/div[1]/div/div/select[1]";
	// public static String Passenger_Seat_xpath=".//*[@id='Payment']/div[2]/div/div/div/select[1]";
	 public static String Passenger_Seat_xpath=".//*[@id='CashDetails']/div[5]/div/div/div[2]/div[1]/div/div/select[2]";
	 public static String Done_btn_xpath = ".//*[@id='Receipt']/section[2]/div/button";
	// public static String ChangeDue_Amount_xpath = ".//*[@id='CashDetails']/div[2]/div[3]/div/p";
	 public static String ChangeDue_Amount_xpath = ".//*[@id='CashDetails']/div[4]/div[3]/div/label";
	 public static String ShoppingCart_PaymentScreen_sectionOne_xpath=".//*[@id='Payment']/div[3]/div[1]";
	 public static String ShoppingCart_PaymentScreen_sectionTwo_xpath=".//*[@id='Payment']/div[3]/div[2]";
	 public static String ShoppingCart_Item_Remove_btn_xpath=".//*[@id='pnlShoppingCart']/table/tbody/tr/td[4]/button[text()='Remove']";
	 public static String Payments_xpath=".//*[@id='pnlShoppingCart']/div[3]/div/div";
	 public static String Payment_Removal_Button_firstxpath = ".//*[@id='pnlShoppingCart']/div[3]/div/div[";
	 public static String Payment_Removal_Button_secondxpath = "]/button";
	 public static String Muiti_Tender_Payment_xpath=".//*[@id='Receipt']/section[1]/div/div[2]/h3";
	 public static String Receipt_Change_Due_xpath = ".//*[@id='Receipt']/section[1]/div/div[2]/h3[2]";
	 public static String BalanaceDue_Amount=".//*[@id='pnlShoppingCart']/div[3]/h4";
	 public static String CC_Payment_SignatureCanvas_xpath=".//*[@id='Signature']/canvas";
	 public static String Signature_Accept_btn_xpath=".//*[@id='creditCardSignatureAccept']";
	 public static String CCMinimumCharge_Message_xpath = ".//*[@id='CreditDetails']/div[1]/div[7]/div[2]/div/span[2]";
	 public static String CCMaximumCharge_Message_xpath = ".//*[@id='CreditDetails']/div[1]/div[7]/div[2]/div/span[2]";
	 public static String Cash_Amount_fld_xpath=".//*[@id='lblcashamount']";
	 public static String CreditCard_Amount_fld_xpath=".//*[@id='creditamount']";
	 public static String Payment_Currency_button=".//*[@id='CashDetails']/div[4]/div[2]/div/div/div/button";
	// public static String Accepted_Currency_xpath = "html/body/header/div/div[2]/h2/span/small";
	 public static String Accepted_Currency_xpath = "html/body/header/div/small/div/h2/span/small";
	 public static String Pyment_Currencies_List_xpath = ".//*[@id='CashDetails']/div[4]/div[2]/div/div/div/ul/li";
	 public static String Pyment_Currencies_firstxpath=".//*[@id='CashDetails']/div[4]/div[2]/div/div/div/ul/li[";
	 public static String Pyment_Currencies_secondxpath="]/a";
	 public static String Default_Payment_Currency=".//*[@id='CashDetails']/div[4]/div[2]/div/div/div/button/span";
	 public static String ChangeDue_Currency_button=".//*[@id='CashDetails']/div[4]/div[3]/div/panel/button";
	 public static String ChangeDue_Currencies_List_xpath = ".//*[@id='DuesCollectibles']/tbody/tr/td[5]/panel/ul/li";
	 public static String ChangeDue_Currencies_firstxpath=".//*[@id='CashDetails']/div[4]/div[3]/div/panel/ul/li[";
	 public static String ChangeDue_Currencies_secondxpath="]/a";
	 public static String Default_ChangeDue_Currency=".//*[@id='CashDetails']/div[4]/div[3]/div/panel/button/span";
	 public static String Passport_fld_xpath=".//*[@id='passport']" ;
	 public static String Country_Select_box=".//*[@id='CreditDetails']/div[1]/div[6]/div/select";
	 public static String Id_Required_Message=".//*[@id='CreditDetails']/div[1]/div[7]/div[2]/div/span[2]";
	 public static String CrewId_fld_xpath="//div[@data-bind='css: crewSaleCrewID_CSS']/input";
	 public static String CrewId_message_xpath="//div[@data-bind='css: crewSaleCrewID_CSS']/label[2]";
	 public static String Payment_CurrencySymbol_xpath="//div/span[@databind='text: acceptedCurrency().CurrencySymbol']";
	 public static String ChangeDue_CurrencySymbol_xpath="html/body/small/div[1]/div/div/div[2]/div[2]/section/div/div[2]/div/div[2]/div[1]/div/div[1]/div[4]/div[3]/div/label";
	 
	 public static void switchControlToLatestWindow(WebDriver driver) {
		 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);	
	 }
	 
	 public static void VerifySeatrowDropDown(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Select SeatrowDropDown = new Select(driver.findElement(By.xpath(SeatRow_dpdn_xpath)));
			List<WebElement> allOptions = SeatrowDropDown.getOptions();
			int[] row ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
			int i;
			int option=0;
			for(i=0;i<row.length;i++){
				for(int j=1;j<allOptions.size();j++){
				String optionvalue = allOptions.get(j).getAttribute("value");
				 option = Integer.parseInt(optionvalue);
				 if(option == row[i]){
						System.out.print(option+", ");
					}
				}
			}
			System.out.println("are displayed in the dropdown");
		}
	
	 public static void VerifySeatDropDown(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			actions.selectByVisibleText(driver, "xpath", SeatRow_dpdn_xpath, "1");
			Select SeatrowDropDown = new Select(driver.findElement(By.xpath(SeatRowSeat_dpdn_xpath)));
				List<WebElement> allOptions = SeatrowDropDown.getOptions();
				String[] rowSeat = {"A","B","C","D","E","F"};
				String optionvalue=null;
				for(int i=0;i<rowSeat.length;i++){
					for(int j=1;j<allOptions.size();j++){
					 optionvalue = allOptions.get(j).getAttribute("value");
					 if(optionvalue.equals(rowSeat[i])){
							System.out.print(optionvalue+",");
						}else{
							Assert.fail(optionvalue+"not displayed");
						}
					}
				}
				System.out.println("are displayed in the dropdown");
	 }
	 
	 public static float BalanceDueAmount(WebDriver driver){
		 String Balance = driver.findElement(By.xpath(BalanaceDue_Amount)).getText();
		 System.out.println(Balance);
		 String[] amount = Balance.split("�");
		 String due =amount[1];
		 System.out.println(due);
		 float  BalanceDue= Float.valueOf(due.trim()).floatValue();
		return BalanceDue;
	 }
	 
	 public static void VerifyShoppingCartItemCount(WebDriver driver) throws InterruptedException, IOException{
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 int ExpectedItemsCount = NewOrder.CheckOutItemsCount(driver);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 String Items = driver.findElement(By.xpath(ShoppingCart_ItemCount_xpath)).getText();
         int ActualItemsCount = Integer.parseInt(Items);
         if(ActualItemsCount == ExpectedItemsCount){
        	 System.out.println("Shopping cart Items count is as expected");
         }else{
        	 Assert.fail("Shopping cart Items count is incorrect");
         }
         
	 }
	 public static void Verify_Item_Removal_AfterCheckout(WebDriver driver,char CurrencySymbol) throws InterruptedException, IOException{
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 NewOrder.placeNewOrder(driver, "Gadgets", 1,CurrencySymbol); 
		 driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		 NewOrder.CheckOut(driver);
		 String CartItems =  driver.findElement(By.xpath(ShoppingCart_ItemCount_xpath)).getText();
		 System.out.println(CartItems);
		 int ItemsCountBeforeRemoval = Integer.parseInt(CartItems);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(ShoppingCart_Item_Remove_btn_xpath)).click();
		 int ItemsCountAfterRemoval = NewOrder.CheckOutItemsCount(driver);
		 if(ItemsCountAfterRemoval < ItemsCountBeforeRemoval){
			 System.out.println("Able to remove item");
		 }else{
			 Assert.fail("Unable to remove item");
		 }
	 }

	 public static String ShoppingCartItemName(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    String ActualItemName = driver.findElement(By.xpath(ShoppingCart_ItemName_xpath)).getText();
	    System.out.println(ActualItemName);
		return ActualItemName;
	 }
	 public static void Verify_ShoppingCart_ItemName(WebDriver driver) throws InterruptedException{
		 String ExpectedItemName = NewOrder.NewOrderItemname(driver, 1);
		 NewOrder.CheckOut(driver);
		 String ActualItemName = Payments.ShoppingCartItemName(driver);
		 if(ExpectedItemName.equalsIgnoreCase(ActualItemName)){
			 System.out.println("Shopping Cart Item Name is as expected");
		 }else{
			 Assert.fail("incorrect Item added to the cart");
		 }
	 }
	public static String ShoppingCart_PaymentScreen_sectionOne_Details(WebDriver driver){
		String Details = driver.findElement(By.xpath(ShoppingCart_PaymentScreen_sectionOne_xpath)).getText();
		System.out.println(Details); 
		return Details;
	}
	public static String ShoppingCart_PaymentScreen_sectionTwo_Details(WebDriver driver){
		String Details = driver.findElement(By.xpath(ShoppingCart_PaymentScreen_sectionTwo_xpath)).getText();
		System.out.println(Details); 
		return Details;
	}
	
	public static void Verify_PaymentScreen_ShoppingCart_Section_Details(WebDriver driver){
		String Expected= "Shopping Cart, Item Qty Total, Subtotal, Total, Balance Due";
		String Actual = Payments.ShoppingCart_PaymentScreen_sectionOne_Details(driver);
		if(Actual.contains(Expected)){
			System.out.println("Shopping Cart Section displayed Item Qty Total, Subtotal, Total, Balance Due");
		}else{
			Assert.fail("Shopping Cart Section not displaying Item Qty Total, Subtotal, Total, Balance Due");
		}
	}
	public static void Verify_PaymentScreen_Payments_Section_Details(WebDriver driver){
		String Expected= "Payment, Discount, Payment Modes, Balance, Amount, Change Due,  Pay Now button";
		String Actual = Payments.ShoppingCart_PaymentScreen_sectionTwo_Details(driver);
		if(Actual.contains(Expected)){
			System.out.println("Payment Section displayed Payment, Discount, Payment Modes, Balance, Amount, Change Due,  Pay Now button");
		}else{
			Assert.fail("Payment Section not displaying Payment, Discount, Payment Modes, Balance, Amount, Change Due,  Pay Now button");
		}
	}
	 public static void VerifyPaymentModes(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		int Actualpaymentmode = driver.findElements(By.xpath(PaymentModes_count_xpath)).size();
		int ExpectedModes = 3;
		if(Actualpaymentmode ==  ExpectedModes){
			String ExpectedPaymentModeOne = "Cash";
			String ActualPaymentModeOne = driver.findElement(By.xpath(PaymentMode_firstxpath+1+PaymentMode_secondxpath)).getText();
			String ExpectedPaymentModeTwo = "Credit";
			String ActualPaymentModeTwo = driver.findElement(By.xpath(PaymentMode_firstxpath+2+PaymentMode_secondxpath)).getText();
			String ExpectedPaymentModeThree = "Voucher";
			String ActualPaymentModeThree = driver.findElement(By.xpath(PaymentMode_firstxpath+3+PaymentMode_secondxpath)).getText();
			if(ActualPaymentModeOne.equals(ExpectedPaymentModeOne)||ActualPaymentModeTwo.equals(ExpectedPaymentModeTwo)||ActualPaymentModeThree.equals(ExpectedPaymentModeThree)){
				System.out.println("Cash, CreditCard, and Voucher payment modes are available");
			}else{
				System.out.println("Payment modes are not available");
			}
			
		}
		 
	 }

		
	
	 public static void VerifyCashPaymentScreen(WebDriver driver) throws IOException{
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 int ActualEasyCashbuttonsCount =  driver.findElements(By.xpath(EasyCash_btn_count_xpath)).size();
		 int ExpectedEasyCashbuttonsCount = 4;
		 WebElement CashAmountField = driver.findElement(By.xpath(CashAmount_fld_xpath));
		 WebElement PayNowbutton = driver.findElement(By.xpath(PayNow_btn_xpath));
		 WebElement ExactButton = driver.findElement(By.xpath(Exact_btn_xpath));
		 if(ActualEasyCashbuttonsCount == ExpectedEasyCashbuttonsCount){
			 String ExpectedbuttonOne = getValue("EasyCashButton1");
			 String ExpectedbuttonTwo = getValue("EasyCashButton2");
			 String ExpectedbuttonThree = getValue("EasyCashButton3");
			 String ExpectedbuttonFour = getValue("EasyCashButton4");
			 String ActualbuttonOne = driver.findElement(By.xpath(EasyCash_btn_value_firstxpath+1+EasyCash_btn_value_secondxpath)).getText(); 
			 String ActualbuttonTwo = driver.findElement(By.xpath(EasyCash_btn_value_firstxpath+2+EasyCash_btn_value_secondxpath)).getText(); 
			 String ActualbuttonThree = driver.findElement(By.xpath(EasyCash_btn_value_firstxpath+3+EasyCash_btn_value_secondxpath)).getText(); 
			 String ActualbuttonFour= driver.findElement(By.xpath(EasyCash_btn_value_firstxpath+4+EasyCash_btn_value_secondxpath)).getText();
			if(ActualbuttonOne.equals(ExpectedbuttonOne)||ActualbuttonTwo.equals(ExpectedbuttonTwo)||ActualbuttonThree.equals(ExpectedbuttonThree)||ActualbuttonFour.equals(ExpectedbuttonFour)
					||ExactButton.isDisplayed()||CashAmountField.isDisplayed()||PayNowbutton.isDisplayed()){
				System.out.println("EasyPay Buttons, Exact Button, CashAmountField and PayNow button are displayed on the screen");
			}else{
				Assert.fail("buttons and fields are not displayed");
			}
			 
		 }
		
	 }
public static void CCProcess(WebDriver driver){
	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	 driver.findElement(By.xpath(PaymentMode_firstxpath+2+PaymentMode_secondxpath)).click(); 
	 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	 driver.findElement(By.xpath(ProcessCard_btn_xpath)).click(); 
	 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	 
}
	 public static void Verify_SeatNumRequired_Message(WebDriver driver,String cardNum,String Amount) throws InterruptedException, IOException{
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 Payments.ChangeDue(driver);
		 Payments.PayNow(driver);
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 String ExpectedMessage = "Seat # required!";
		 String ActualMessage = driver.findElement(By.xpath(SeatnumReq_Message_xpath)).getText();
		 if(ActualMessage.equals(ExpectedMessage)){
			 System.out.println("SeatNumber required message dislayed");
		 }else{
			 Assert.fail("Message not displayed");
		 }
		 
	 }
	 public static void CashPayment(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Exact_btn_xpath)).click(); 
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(PayNow_btn_xpath)).click(); 
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	 }
	
	 
	 public static String PassengerName(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String PassengerName=driver.findElement(By.xpath(PassengerName_xpath)).getText(); 
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 System.out.println(PassengerName);
		return PassengerName;
		 
	 }
	 
	 public static String PassengerSeatRow(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String PassengerSeatRow=driver.findElement(By.xpath(Passenger_SeatRow_xpath)).getAttribute("value");
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 System.out.println(PassengerSeatRow);
		return PassengerSeatRow;
		 
	 }
	 public static String PassengerSeat(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String PassengerSeat=driver.findElement(By.xpath(Passenger_Seat_xpath)).getAttribute("value");
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 System.out.println(PassengerSeat);
		return PassengerSeat;
		 
	 }
	 //before completing PaymentProcess call this method
	/* public static String PassengerDetails(WebDriver driver,String seatrow,String seat){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 actions.selectByVisibleText(driver, "xpath", SeatRow_dpdn_xpath, seatrow);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 actions.selectByVisibleText(driver, "xpath", SeatRowSeat_dpdn_xpath, seat);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 String PassengerDetails =  driver.findElement(By.xpath(Passenger_info_xpath)).getText();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return PassengerDetails;
		 
	 }
	 
	 public static String ShoppingCart_PassengerName(WebDriver driver,String seatrow,String seat){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  String PassengerDetails =  Payments.PassengerDetails(driver,seatrow,seat);
	        String[] String=PassengerDetails.split(" ");
	        String PassengerName=String[1]+" "+String[2];
			return PassengerName;
	 }
	 public static String ShoppingCart_PassengerSeat(WebDriver driver,String seatrow,String seat){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  String PassengerDetails =  Payments.PassengerDetails(driver,seatrow,seat);
	        String[] String=PassengerDetails.split(" ");
	        String PassengerSeat=String[4]+String[5];
			return PassengerSeat;
	 }*/
	 //before completing PaymentProcess call this method
	 
	public static char ChangeDue_CurrencySymbol(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String amount= driver.findElement(By.xpath(ChangeDue_CurrencySymbol_xpath)).getText();
		 char symbol=amount.charAt(0);
		// System.out.println(symbol);
		return symbol;
		 
	}
     public static char Payment_CurrencySymbol(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 String s=driver.findElement(By.xpath(ChangeDue_CurrencySymbol_xpath)).getText();
    	 char symbol=s.charAt(0);
    	// System.out.println(symbol);
		return symbol;
	} 
	 
     public static void Change_PaymentCurrency(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
    	 driver.findElement(By.xpath(Payment_Currency_button)).click();
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
    	 driver.findElement(By.xpath(Pyment_Currencies_firstxpath+1+Pyment_Currencies_secondxpath )).click();
    	 
     }
     public static void Change_ChangeDueCurrency(WebDriver driver){
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 driver.findElement(By.xpath(ChangeDue_Currency_button)).click();
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
    	 driver.findElement(By.xpath(ChangeDue_Currencies_firstxpath+2+ChangeDue_Currencies_secondxpath)).click();
    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
     }
	 public static float ChangeDueAmount(WebDriver driver,char CurrencySymbol) throws IOException{
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 String amount =  driver.findElement(By.xpath(ChangeDue_Amount_xpath)).getText();
		 String[] String = amount.split("\\"+CurrencySymbol);
		 float ChangeDueAmount=Float.valueOf(String[1].trim()).floatValue();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 System.out.println(ChangeDueAmount);
		return ChangeDueAmount;
		 
	 }
	 
	 public static float ReceiptChangeDueAmount(WebDriver driver,char CurrencySymbol) throws IOException{
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 String amount =  driver.findElement(By.xpath(Receipt_Change_Due_xpath)).getText();
		 String[] String1 = amount.split(": ");
		 String[] String = String1[1].split("\\"+CurrencySymbol);
		 float ChangeDueAmount=Float.valueOf(String[1].trim()).floatValue();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 System.out.println(ChangeDueAmount);
		return ChangeDueAmount;
		 
	 }
	 public static void Verify_ChangeTenderTypChkBx(WebDriver driver){
		
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 WebElement ChangetenderChkBX = driver.findElement(By.xpath(ChangeTendered_chkbx_xpath));
		 if(ChangetenderChkBX.isDisplayed()){
			 System.out.println("ChangeTendered checkbox displayed");
		 }else{
			 Assert.fail("ChangeTendered checkbox not displayed");
		 }
	 }
	
	 public static void ChangeDue(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(CashAmount_fld_xpath)).click();
		 Payments.switchControlToLatestWindow(driver);
		 driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		 Payments.Enter_CahPaymentAmount(driver);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	 }
	 public static void PayNow(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(PayNow_btn_xpath)).click(); 
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
	 }
	 
	 public static void Payment_Done(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		// js.executeScript("arguments[0].click();", driver.findElement(By.xpath(Done_btn_xpath)));
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Done_btn_xpath)).click(); 
		 driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	 }
	 
	 
	 public static void Enter_CahPaymentAmount(WebDriver driver){
		common.NumpadValue(driver, "00");
		common.NumpadValue(driver, "1");
		common.NumpadValue(driver, "00");
		common.NumpadValue(driver, "00");
		common.Numpad_Set_Click(driver);
	 }
	 
	 public static void Verify_ChangeDue_Amount(WebDriver driver,char CurrencySymbol,String seatrow,String seat) throws IOException{
		 Payments.Select_SeatNum(driver,seatrow,seat);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(CashAmount_fld_xpath)).click();
		 Payments.switchControlToLatestWindow(driver);
		 driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		 Payments.Enter_CahPaymentAmount(driver);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 float expectedChangeDue= Payments.ChangeDueAmount(driver,CurrencySymbol);
		 driver.findElement(By.xpath(PayNow_btn_xpath)).click(); 
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 float ActualChangeDue = Payments.ReceiptChangeDueAmount(driver,CurrencySymbol);
		 if(expectedChangeDue == ActualChangeDue){
			 System.out.println("Displayed changedueAmount is correct");
		 }else{
			 Assert.fail("Displayed changedueAmount is incorrect");
		 }
	 }
	 public static void VerifyCreditCardPaymentScreen(WebDriver driver){
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(PaymentMode_firstxpath+2+PaymentMode_secondxpath)).click(); 
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 WebElement CreditAmountFld = driver.findElement(By.xpath(ChargeAmount_fld_xpath));
		 WebElement CardNumberFld =  driver.findElement(By.xpath(CreditCardnum_fld_xpath));
		 WebElement CCExpirationFld = driver.findElement(By.xpath(ExpirationDate_fld_xpath));
		 WebElement PayNowBtn = driver.findElement(By.xpath(PayNow_btn_xpath));
		 if(CreditAmountFld.isDisplayed()){
			 System.out.println("CreditAmountFld displayed");
			 if(CardNumberFld.isDisplayed()){
				 System.out.println("CardNumberFld displayed");
				 if(CCExpirationFld.isDisplayed()){
					 System.out.println("CCExpirationFld displayed");
					 if(PayNowBtn.isDisplayed()){
						 System.out.println("PayNowBtn displayed");
			 }
		 }
			 }
		 }else{
			Assert.fail("Missing fields"); 
		 }
	 }
	 public static void Select_SeatNum(WebDriver driver,String seatrow,String seat){
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 actions.selectByVisibleText(driver, "xpath", SeatRow_dpdn_xpath, seatrow);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 actions.selectByVisibleText(driver, "xpath", SeatRowSeat_dpdn_xpath, seat);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
	 }
	 
	 public static void CreditCardPaymentProcess(WebDriver driver,String cardNum) throws InterruptedException, IOException{
	 // float BalanceDue = Payments.BalanceDueAmount(driver);
		 driver.findElement(By.xpath(PaymentMode_firstxpath+2+PaymentMode_secondxpath)).click(); 
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(CreditCardnum_fld_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 switchControlToLatestWindow(driver);
		 Thread.sleep(300);
		 String CCNUM=cardNum;
			String[] values={CCNUM.substring(0, 1),CCNUM.substring(1, 2),CCNUM.substring(2, 3),CCNUM.substring(3, 4),CCNUM.substring(4, 5),CCNUM.substring(5, 6),
					CCNUM.substring(6, 7),CCNUM.substring(7, 8),CCNUM.substring(8, 9),CCNUM.substring(9, 10),CCNUM.substring(10, 11),CCNUM.substring(11, 12),
					CCNUM.substring(12, 13),CCNUM.substring(13, 14),CCNUM.substring(14, 15),CCNUM.substring(15, 16)};
			 String CCExp=getValue("EXP");
				String[] exp={CCExp.substring(0, 1),CCExp.substring(1, 2),CCExp.substring(2, 3),CCExp.substring(3, 4)};	
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[0]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[1]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[2]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[3]+Numpadpopup_secondpath)).click();
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[4]+Numpadpopup_secondpath)).click();
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[5]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[6]+Numpadpopup_secondpath)).click();
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[7]+Numpadpopup_secondpath)).click();
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[8]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[9]+Numpadpopup_secondpath)).click();
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[10]+Numpadpopup_secondpath)).click();
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[11]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[12]+Numpadpopup_secondpath)).click();
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[13]+Numpadpopup_secondpath)).click();
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[14]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[15]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_Set_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(ExpirationDate_fld_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 switchControlToLatestWindow(driver);
		 Thread.sleep(100);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+exp[0]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+exp[1]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+exp[2]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+exp[3]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_Set_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		 if(driver.findElement(By.xpath(Passport_fld_xpath)).isDisplayed()){
				driver.findElement(By.xpath(Passport_fld_xpath)).sendKeys("12345678");
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				actions.selectByindex(driver, "xpath", Country_Select_box, 10);
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				 }
	     driver.findElement(By.xpath(CCPayNow_btn_xpath)).click();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     if(driver.findElements(By.xpath(CC_Payment_SignatureCanvas_xpath)).size()!=0){
		driver.findElement(By.xpath(CC_Payment_SignatureCanvas_xpath)).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Signature_Accept_btn_xpath)).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 }
	    
	 }
	 
	 
	 public static void Verify_CC_Minimumcharge_Message(WebDriver driver,String cardNum,String Minimumcharge) throws InterruptedException, IOException{
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 float BalanceDue = Payments.BalanceDueAmount(driver);
		 driver.findElement(By.xpath(PaymentMode_firstxpath+2+PaymentMode_secondxpath)).click(); 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(CreditCardnum_fld_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 switchControlToLatestWindow(driver);
		 Thread.sleep(200);
		 String CCNUM=cardNum;
			String[] values={CCNUM.substring(0, 1),CCNUM.substring(1, 2),CCNUM.substring(2, 3),CCNUM.substring(3, 4),CCNUM.substring(4, 5),CCNUM.substring(5, 6),
					CCNUM.substring(6, 7),CCNUM.substring(7, 8),CCNUM.substring(8, 9),CCNUM.substring(9, 10),CCNUM.substring(10, 11),CCNUM.substring(11, 12),
					CCNUM.substring(12, 13),CCNUM.substring(13, 14),CCNUM.substring(14, 15),CCNUM.substring(15, 16)};
			 String CCExp=getValue("EXP");
				String[] exp={CCExp.substring(0, 1),CCExp.substring(1, 2),CCExp.substring(2, 3),CCExp.substring(3, 4)};	
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[0]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[1]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[2]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[3]+Numpadpopup_secondpath)).click();
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[4]+Numpadpopup_secondpath)).click();
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[5]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[6]+Numpadpopup_secondpath)).click();
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[7]+Numpadpopup_secondpath)).click();
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[8]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[9]+Numpadpopup_secondpath)).click();
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[10]+Numpadpopup_secondpath)).click();
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[11]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[12]+Numpadpopup_secondpath)).click();
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[13]+Numpadpopup_secondpath)).click();
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[14]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[15]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_Set_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(ExpirationDate_fld_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 switchControlToLatestWindow(driver);
		 Thread.sleep(300);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+exp[0]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+exp[1]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+exp[2]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+exp[3]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_Set_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     driver.findElement(By.xpath(CCPayNow_btn_xpath)).click();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     String CCMinimumCharge = Minimumcharge;
	     float  minimumcharge= Float.valueOf(CCMinimumCharge.trim()).floatValue();
	    
	     if(BalanceDue < minimumcharge){
	    	 String ExpetedMessage="Card requires minimum charge of 10.00";
	         String ActualMessage=driver.findElement(By.xpath(CCMinimumCharge_Message_xpath)).getText();
	         if(ActualMessage.equalsIgnoreCase(ExpetedMessage)){
	        	 System.out.println("Message displayed as expected, and Message is :"+" "+ActualMessage);
	         }else{
	        	Assert.fail("Message not displayed"); 
	         }
	     }else{
	    	 System.out.println("Balance due is more than minimum charge");
	     }
	 }
	 
	 public static void Verify_CC_Maximumcharge_Message(WebDriver driver,String cardNum,String Maximumcharge) throws InterruptedException, IOException{
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 float BalanceDue = Payments.BalanceDueAmount(driver);
		 driver.findElement(By.xpath(PaymentMode_firstxpath+2+PaymentMode_secondxpath)).click(); 
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(CreditCardnum_fld_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 switchControlToLatestWindow(driver);
		 Thread.sleep(300);
		 String CCNUM=cardNum;
			String[] values={CCNUM.substring(0, 1),CCNUM.substring(1, 2),CCNUM.substring(2, 3),CCNUM.substring(3, 4),CCNUM.substring(4, 5),CCNUM.substring(5, 6),
					CCNUM.substring(6, 7),CCNUM.substring(7, 8),CCNUM.substring(8, 9),CCNUM.substring(9, 10),CCNUM.substring(10, 11),CCNUM.substring(11, 12),
					CCNUM.substring(12, 13),CCNUM.substring(13, 14),CCNUM.substring(14, 15),CCNUM.substring(15, 16)};
			 String CCExp=getValue("EXP");
				String[] exp={CCExp.substring(0, 1),CCExp.substring(1, 2),CCExp.substring(2, 3),CCExp.substring(3, 4)};	
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[0]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[1]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[2]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[3]+Numpadpopup_secondpath)).click();
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[4]+Numpadpopup_secondpath)).click();
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[5]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[6]+Numpadpopup_secondpath)).click();
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[7]+Numpadpopup_secondpath)).click();
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[8]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[9]+Numpadpopup_secondpath)).click();
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[10]+Numpadpopup_secondpath)).click();
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[11]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[12]+Numpadpopup_secondpath)).click();
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[13]+Numpadpopup_secondpath)).click();
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[14]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+values[15]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_Set_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(ExpirationDate_fld_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 switchControlToLatestWindow(driver);
		 Thread.sleep(300);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+exp[0]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+exp[1]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+exp[2]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_firstpath+exp[3]+Numpadpopup_secondpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(Numpadpopup_Set_btn_xpath)).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	     driver.findElement(By.xpath(CCPayNow_btn_xpath)).click();
	     driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	     String CCMaximumCharge = Maximumcharge;
	     float  MaximumCharge= Float.valueOf(CCMaximumCharge.trim()).floatValue();
	    if(BalanceDue > MaximumCharge ){
	    	 String ExpetedMessage="Cannot charge more than 100.00 on this card.";
	    	 String ActualMessage=driver.findElement(By.xpath(CCMaximumCharge_Message_xpath)).getText();
	         if(ActualMessage.equalsIgnoreCase(ExpetedMessage)){
	        	 System.out.println("Message displayed as expected, and Message is :"+" "+ActualMessage);
	         }else{
	        	Assert.fail("Message not displayed"); 
	         }
	     }else{
	    	 System.out.println("Balance due is less than MaximumCharge");
	     }
	 }
	 public static void Multi_Tender_Payment_Process(WebDriver driver,String cardNum,String threshholdAmount,String seatrow,String seat) throws InterruptedException, IOException{
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 Payments.Select_SeatNum(driver,seatrow,seat);
		 driver.findElement(By.xpath(EasyCash_btn_value_firstxpath+1+EasyCash_btn_value_secondxpath)).click(); 
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(PayNow_btn_xpath)).click(); 
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 Payments.CreditCardPaymentProcess(driver,cardNum);
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	 }
	 public static void Remove_Applied_Payment(WebDriver driver){
		int Trans= driver.findElements(By.xpath(Payments_xpath)).size();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 for(int i=1;i<=Trans;i++){
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 driver.findElement(By.xpath(Payment_Removal_Button_firstxpath+i+Payment_Removal_Button_secondxpath)).click();
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 }
	}
	
	public static int Applied_Payments_Count(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		int Discounts = driver.findElements(By.xpath(Payments_xpath)).size();
		return Discounts;
	}
	
	public static void Verify_Applied_Payment_isRemoved(WebDriver driver,String seatrow,String seat){
		Payments.Select_SeatNum(driver,seatrow,seat);
		 driver.findElement(By.xpath(EasyCash_btn_value_firstxpath+1+EasyCash_btn_value_secondxpath)).click(); 
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(PayNow_btn_xpath)).click(); 
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		int Payments_Before_Delete = driver.findElements(By.xpath(Payments_xpath)).size();
		System.out.println(Payments_Before_Delete);
		Payments.Remove_Applied_Payment(driver);
		int Payments_after_Delete=driver.findElements(By.xpath(Payments_xpath)).size();
		System.out.println(Payments_after_Delete);
		if(Payments_after_Delete < Payments_Before_Delete){
			System.out.println("Applied payment  deleted successfully");
		}else{
			Assert.fail("Unable to delete applied payment");
		}
	}
	public static void CC_Signature(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 if(driver.findElement(By.xpath(CC_Payment_SignatureCanvas_xpath)).isDisplayed()){
		driver.findElement(By.xpath(CC_Payment_SignatureCanvas_xpath)).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Signature_Accept_btn_xpath)).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 }
	}
	
	 public static void Verify_MultiTender_Payment(WebDriver driver){
		 String MultiTenderPayment = driver.findElement(By.xpath(Muiti_Tender_Payment_xpath)).getText();
		 System.out.println(MultiTenderPayment);
	 }
	 
	   public static void Verify_Payment_CurrencyTypes(WebDriver driver){
		   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		   driver.findElement(By.xpath(Payment_Currency_button)).click();
		   String[] Currencies = {"GBP","EUR","USD","DKK"};
		   int list = driver.findElements(By.xpath(Pyment_Currencies_List_xpath)).size();
		   for(int i=1;i<=list;i++){
			   String Currency = driver.findElement(By.xpath(Pyment_Currencies_firstxpath+i+Pyment_Currencies_secondxpath)).getText();
			   for(int j=0;j<Currencies.length;j++){
			   if(Currency.equals(Currencies[j])){
				   System.out.println(Currency+ ",");
			    }
			   }
		   }
		   System.out.println("Payment Currencies displayed in the dropdown");
	    }
	    
	     public static void Verify_ChangeDue_CurrencyTypes(WebDriver driver){
	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    	 driver.findElement(By.xpath(ChangeDue_Currency_button)).click();
			   String[] Currencies = {"GBP","EUR","USD","DKK"};
			   int list = driver.findElements(By.xpath(ChangeDue_Currencies_List_xpath)).size();
			   for(int i=1;i<=list;i++){
				   String Currency = driver.findElement(By.xpath(ChangeDue_Currencies_firstxpath+i+ChangeDue_Currencies_secondxpath)).getText();
				   for(int j=0;j<Currencies.length;j++){
				   if(Currency.equals(Currencies[j])){
					   System.out.println(Currency+ ",");
				    }
				   }
			   }
			   System.out.println("ChangeDue Currencies displayed in the dropdown");
	      }
	  
	     public static String Accepted_Currency(WebDriver driver){
	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    	String Accepted_Currency=driver.findElement(By.xpath(Accepted_Currency_xpath)) .getText();
	    	 return Accepted_Currency;
	     }
	  
	  
	     public static String ChangeDue_Currency(WebDriver driver){
	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    	 String ChangeDue_Currency=driver.findElement(By.xpath(Default_ChangeDue_Currency)).getText();
	    	 return ChangeDue_Currency;
	    	 
	      }
	     public static String Payment_Currency(WebDriver driver){
	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
	    	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    	 String Payment_Currency=driver.findElement(By.xpath(Default_Payment_Currency)).getText();
	    	 return Payment_Currency;
		 }
	     
	     
	     public static void Verify_Payment_Default_Currency(WebDriver driver){
	    	 String ExpectedCurrency=Payments.Accepted_Currency(driver);
	    	 String ActualCurrency= Payments.Payment_Currency(driver);
	    	 
	    	 if(ActualCurrency.equals(ExpectedCurrency)){
	    		 System.out.println("Default payment currency is:"+" "+ ActualCurrency);
	    	 }else{
	    		 Assert.fail("Default payment type currency is not acceptable currency");
	    	 }
	    	 
	    	 
	     }
         public static void Verify_ChangeDue_Default_Currency(WebDriver driver){
        	 String ExpectedCurrency=Payments.Accepted_Currency(driver);
	    	 String ActualCurrency= Payments.ChangeDue_Currency(driver);
	    	 
	    	 if(ActualCurrency.equals(ExpectedCurrency)){
	    		 System.out.println("Default ChangeDue currency is:"+" "+ ActualCurrency);
	    	 }else{
	    		 Assert.fail("Default ChangeDue  currency is not acceptable currency");
	    	 }
	     }
	     
         public static void Verify_PassportId_Required_Message(WebDriver driver){
        	 String ExpectedMessage="Passport has not been entered.";
	    	 String ActualMessage= driver.findElement(By.xpath(Id_Required_Message)).getText();
	    	 if(ActualMessage.equalsIgnoreCase(ExpectedMessage)){
	    		 System.out.println("Message is as expected ");
	    	 }else{
	    		 Assert.fail("Message not displayed");
	    	 }
         }
         
         
         public static void EnterCrewId(WebDriver driver,String CrewID){
        	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        	driver.findElement(By.xpath(CrewId_fld_xpath)).sendKeys(CrewID);
        	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
         }
         
         public static void Verify_CrewId_Required_Message(WebDriver driver){
       	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
       	  String ExpectedMessage= "Crew ID # required!";
       	  String Message= driver.findElement(By.xpath(CrewId_message_xpath)).getText();
       	  if(Message.equals(ExpectedMessage)){
       		  System.out.println("Message displayed as expected");
       	  }else{
       		 Assert.fail("Crew ID # required! Message not displayed"); 
       	  }
       	  
         }
         
         public static void VerifyPayment_And_ChangeDue_AfterCurrencyChange(WebDriver driver){
        	 char Before_PaymentCurrencySymbol=Payments.Payment_CurrencySymbol(driver);
        	 System.out.println(Before_PaymentCurrencySymbol +"beforep");
        	 Payments.Change_PaymentCurrency(driver);
        	 char After_PaymentCurrencySymbol=Payments.Payment_CurrencySymbol(driver);
        	 System.out.println(After_PaymentCurrencySymbol +"afterp");
        	 Payments.ChangeDue(driver);
        	 char Before_ChangeDueCurrencySymbol=Payments.ChangeDue_CurrencySymbol(driver);
        	 System.out.println(Before_ChangeDueCurrencySymbol +"beforec");
        	 Payments.Change_ChangeDueCurrency(driver);
        	
        	 
        	 char After_ChangeDueCurrencySymbol=Payments.ChangeDue_CurrencySymbol(driver);
        	 System.out.println(After_ChangeDueCurrencySymbol +"afterc");
        	 if(Before_PaymentCurrencySymbol != After_PaymentCurrencySymbol && Before_ChangeDueCurrencySymbol != After_ChangeDueCurrencySymbol ){
        		 System.out.println("Payment currency and change due currency are updated and changedue amount is also changed based on the currency");
        	 }else{
        		 Assert.fail("Payment currency and change due currency are NOT updated and changedue amount not changed");
        	 }
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
        	 
         }
         
         
         
}

