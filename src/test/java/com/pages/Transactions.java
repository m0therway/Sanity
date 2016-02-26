package com.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Transactions {
	WebDriver driver=null;
	public static String Completed_Transaction_xpath = "//*[@id='CompletedSales']/tbody/tr";
	public static String CompTransaction_date_firstxpath = "//*[@id='CompletedSales']/tbody/tr";
	public static String CompTransaction_date_secondxpath = "/td[2]/small";
	public static String CompTransaction_Passengername_firstxpath = "//*[@id='CompletedSales']/tbody/tr";
	public static String CompTransaction_Passengername_secondxpath = "/td[4]";
	public static String CompTransaction_PassengerSeat_firstxpath = "//*[@id='CompletedSales']/tbody/tr";
	public static String CompTransaction_PassengerSeat_secondxpath = "/td[3]";
	public static String ComTransPaymentType_firstxpath ="//*[@id='CompletedSales']/tbody/tr";
	public static String CompTransPaymentType_secondxpath ="/td[6]";
	public static String Refund_Transaction_xpath = ".//*[@id='Refunds']/tbody/tr";
	public static String RefTransaction_Passengername_firstxpath =".//*[@id='Refunds']/tbody/tr";
	public static String RefTransaction_Passengername_secondxpath =	"/td[3]";
	public static String RefTransaction_PassengerSeat_firstxpath = ".//*[@id='Refunds']/tbody/tr";
	public static String RefTransaction_PassengerSeat_secondxpath ="/td[2]";
	public static String RefTransPaymentType_firstxpath =".//*[@id='Refunds']/tbody/tr";
	public static String RefTransPaymentType_secondxpath ="/td[5]";
	public static String Refunds_tab_xpath ="//a[@href='#tabRefunds']";
	
    public static void CashTransaction(WebDriver driver,String seatrow,String seat){
		String PassengerName = Payments.PassengerName(driver);
		String Passengerseat = Payments.PassengerSeatRow(driver)+Payments.PassengerSeat(driver);
		Payments.CashPayment(driver);
		int completedSalesCount = driver.findElements(By.xpath(Completed_Transaction_xpath)).size();
		Date date= new Date();
		 String DATE_FORMAT = "MMMM d, yyyy hh:mm a";
		    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		   // SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
	      String date1=sdf.format(date);
		if(completedSalesCount > 1){
		for(int i=1;i<=completedSalesCount;i++){
			String Transaction_PassengerSeat = driver.findElement(By.xpath(CompTransaction_PassengerSeat_firstxpath+"["+i+"]"+CompTransaction_PassengerSeat_secondxpath)).getText();
			String Transaction_Passengername = driver.findElement(By.xpath(CompTransaction_Passengername_firstxpath+"["+i+"]"+CompTransaction_Passengername_secondxpath)).getText();
			String PaymentType =  driver.findElement(By.xpath(ComTransPaymentType_firstxpath+"["+i+"]"+CompTransPaymentType_secondxpath)).getText();
			String CompleTransDate= driver.findElement(By.xpath(CompTransaction_date_firstxpath+"["+i+"]"+CompTransaction_date_secondxpath)).getText();
			if(CompleTransDate.contains(date1)||Passengerseat.contains(Transaction_PassengerSeat)||PassengerName.contains(Transaction_Passengername)||PaymentType.equalsIgnoreCase("Cash")){
				System.out.println("Cash Transaction completed");
			}else{
				Assert.fail("Cash Transaction did not complete");
			}
		}
		}else{
			String Transaction_PassengerSeat = driver.findElement(By.xpath(CompTransaction_PassengerSeat_firstxpath+CompTransaction_PassengerSeat_secondxpath)).getText();
			String Transaction_Passengername = driver.findElement(By.xpath(CompTransaction_Passengername_firstxpath+CompTransaction_Passengername_secondxpath)).getText();
			String PaymentType =  driver.findElement(By.xpath(ComTransPaymentType_firstxpath+CompTransPaymentType_secondxpath)).getText();
			String CompleTransDate= driver.findElement(By.xpath(CompTransaction_date_firstxpath+CompTransaction_date_secondxpath)).getText();
			if(CompleTransDate.contains(date1)||Passengerseat.contains(Transaction_PassengerSeat)||PassengerName.contains(Transaction_Passengername)||PaymentType.equalsIgnoreCase("Cash")){
				System.out.println("Cash Transaction completed");
			}else{
				Assert.fail("Cash Transaction did not complete");
			}
		}
	}
	
	
	
public static void CCTransaction1(WebDriver driver,String cardNum,String threshholdAmount,String seatrow,String seat) throws InterruptedException, IOException{
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		Payments.Select_SeatNum(driver,seatrow,seat);
		Payments.CreditCardPaymentProcess(driver,cardNum);
		String PassengerName = Payments.PassengerName(driver);
		//System.out.println(PassengerName);
		String PassengerSeat = Payments.PassengerSeatRow(driver)+Payments.PassengerSeat(driver);
		//System.out.println(PassengerSeat);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		Payments.Payment_Done(driver);
		Date date= new Date();
		 String DATE_FORMAT = "MMMM d, yyyy hh:mm a";
		    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		//    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
	   String date1=sdf.format(date);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		int completedSalesCount = driver.findElements(By.xpath(Completed_Transaction_xpath)).size();
		if(completedSalesCount > 1){
		for(int i=1;i<=completedSalesCount;i++){
			String Transaction_PassengerSeat = driver.findElement(By.xpath(CompTransaction_PassengerSeat_firstxpath+"["+i+"]"+CompTransaction_PassengerSeat_secondxpath)).getText();
			String CompleTransDate= driver.findElement(By.xpath(CompTransaction_date_firstxpath+"["+i+"]"+CompTransaction_date_secondxpath)).getText();
			String Transaction_Passengername = driver.findElement(By.xpath(CompTransaction_Passengername_firstxpath+"["+i+"]"+CompTransaction_Passengername_secondxpath)).getText();
			
			String PaymentType =  driver.findElement(By.xpath(ComTransPaymentType_firstxpath+"["+i+"]"+CompTransPaymentType_secondxpath)).getText();
			if(CompleTransDate.contains(date1)||PassengerSeat.equals(Transaction_PassengerSeat)||PassengerName.equals(Transaction_Passengername)||PaymentType.equalsIgnoreCase("Credit Card")){
				System.out.println("CC Transaction completed");
			}else{
				Assert.assertFalse(false);
			}
		  }
		
		}else{
        String Transaction_PassengerSeat = driver.findElement(By.xpath(CompTransaction_PassengerSeat_firstxpath+CompTransaction_PassengerSeat_secondxpath)).getText();
			
			String Transaction_Passengername = driver.findElement(By.xpath(CompTransaction_Passengername_firstxpath+CompTransaction_Passengername_secondxpath)).getText();
			String CompleTransDate= driver.findElement(By.xpath(CompTransaction_date_firstxpath+CompTransaction_date_secondxpath)).getText();
			String PaymentType =  driver.findElement(By.xpath(ComTransPaymentType_firstxpath+CompTransPaymentType_secondxpath)).getText();
			if(CompleTransDate.contains(date1)||PassengerSeat.equals(Transaction_PassengerSeat)||PassengerName.equals(Transaction_Passengername)||PaymentType.equalsIgnoreCase("Credit Card")){
				System.out.println(Transaction_Passengername);
				System.out.println(Transaction_PassengerSeat);
				System.out.println("CC Transaction completed");
			}else{
				Assert.assertFalse(false);
			}
			
		}
		
	}
	public static void Multi_TenderTransaction(WebDriver driver,String cardNum,String threshholdAmount,String seatrow,String seat) throws InterruptedException, IOException{
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	
		Payments.Multi_Tender_Payment_Process(driver,cardNum,threshholdAmount,seatrow,seat);
		String PassengerName = Payments.PassengerName(driver);
		//System.out.println(PassengerName);
		String PassengerSeat = Payments.PassengerSeatRow(driver)+Payments.PassengerSeat(driver);
		//System.out.println(PassengerSeat);
		Payments.Payment_Done(driver);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		Date date= new Date();
		 String DATE_FORMAT = "MMMM d, yyyy hh:mm a";
		    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
	//	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
	     String date1=sdf.format(date);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		int completedSalesCount = driver.findElements(By.xpath(Completed_Transaction_xpath)).size();
		if(completedSalesCount >1){
		for(int i=1;i<=completedSalesCount;i++){
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			String Transaction_PassengerSeat = driver.findElement(By.xpath(CompTransaction_PassengerSeat_firstxpath+"["+i+"]"+CompTransaction_PassengerSeat_secondxpath)).getText();
			String Transaction_Passengername = driver.findElement(By.xpath(CompTransaction_Passengername_firstxpath+"["+i+"]"+CompTransaction_Passengername_secondxpath)).getText();
			String CompleTransDate= driver.findElement(By.xpath(CompTransaction_date_firstxpath+"["+i+"]"+CompTransaction_date_secondxpath)).getText();
			String PaymentType =  driver.findElement(By.xpath(ComTransPaymentType_firstxpath+"["+i+"]"+CompTransPaymentType_secondxpath)).getText();
			if(CompleTransDate.contains(date1)||PassengerSeat.contains(Transaction_PassengerSeat)||PassengerName.contains(Transaction_Passengername)||PaymentType.equalsIgnoreCase("CASH, CREDIT")){
				System.out.println("CASH, CREDIT Transaction completed");
				
			}else{
				Assert.assertFalse(false);
			}
		}
		}else{
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			String Transaction_PassengerSeat = driver.findElement(By.xpath(CompTransaction_PassengerSeat_firstxpath+CompTransaction_PassengerSeat_secondxpath)).getText();
			String Transaction_Passengername = driver.findElement(By.xpath(CompTransaction_Passengername_firstxpath+CompTransaction_Passengername_secondxpath)).getText();
			String CompleTransDate= driver.findElement(By.xpath(CompTransaction_date_firstxpath+CompTransaction_date_secondxpath)).getText();
			String PaymentType =  driver.findElement(By.xpath(ComTransPaymentType_firstxpath+CompTransPaymentType_secondxpath)).getText();
			if(CompleTransDate.contains(date1)||PassengerSeat.contains(Transaction_PassengerSeat)||PassengerName.contains(Transaction_Passengername)||PaymentType.equalsIgnoreCase("CASH, CREDIT")){
				System.out.println("CASH, CREDIT Transaction completed");
				
			}else{
				Assert.assertFalse(false);
			}
		}
		
	}
  
   
   public static void RefundTransaction1(WebDriver driver,String paymentType,String RefundCrewId) throws InterruptedException, IOException{
	    String PassengerName = Payments.PassengerName(driver);
		String Passengerseat = Payments.PassengerSeatRow(driver)+Payments.PassengerSeat(driver);
		Payments.CashPayment(driver);
		Payments.Payment_Done(driver);
	    Refunds.SelectTransaction_To_Refund1(driver, paymentType);
		Refunds.RefundProcess(driver,RefundCrewId);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.navigate().to("http://egate-solutions.azurewebsites.net/sales.html");
		driver.findElement(By.xpath(Refunds_tab_xpath)).click();
		WebDriverWait ww=new WebDriverWait(driver,50);
		ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Refund_Transaction_xpath)));
		int Refunds=driver.findElements(By.xpath(Refund_Transaction_xpath)).size();
		if(Refunds > 1){
			for(int i=1;i<=Refunds;i++){
		String Transaction_PassengerSeat = driver.findElement(By.xpath(RefTransaction_PassengerSeat_firstxpath+"["+i+"]"+RefTransaction_PassengerSeat_secondxpath)).getText();
		String Transaction_Passengername = driver.findElement(By.xpath(RefTransaction_Passengername_firstxpath+"["+i+"]"+RefTransaction_Passengername_secondxpath)).getText();
		String PaymentType =  driver.findElement(By.xpath(RefTransPaymentType_firstxpath+"["+i+"]"+RefTransPaymentType_secondxpath)).getText();
		if(Passengerseat.contains(Transaction_PassengerSeat)||PassengerName.contains(Transaction_Passengername)||PaymentType.equalsIgnoreCase(paymentType)){
			System.out.println(paymentType + " "+ "Transaction Refunded");
		}else{
			Assert.assertFalse(false,"no refunds displayed");
		 }
		}
   }else{
	   driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	   String Transaction_PassengerSeat = driver.findElement(By.xpath(RefTransaction_PassengerSeat_firstxpath+RefTransaction_PassengerSeat_secondxpath)).getText();
		String Transaction_Passengername = driver.findElement(By.xpath(RefTransaction_Passengername_firstxpath+RefTransaction_Passengername_secondxpath)).getText();
		String PaymentType =  driver.findElement(By.xpath(RefTransPaymentType_firstxpath+RefTransPaymentType_secondxpath)).getText();
		if(Passengerseat.contains(Transaction_PassengerSeat)||PassengerName.contains(Transaction_Passengername)||PaymentType.equalsIgnoreCase(paymentType)){
			System.out.println(paymentType + " "+ "Transaction Refunded");
		}else{
			Assert.assertFalse(false,"no refunds displayed");
		}
   }
	}
}
