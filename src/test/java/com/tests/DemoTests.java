package com.tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.commons.common;
import com.commons.utilities;
import com.pages.AssignSeals;
import com.pages.AttendantLogin;
import com.pages.CashCount;
import com.pages.CashManagement;
import com.pages.CloseFlight;
import com.pages.CloseFlight_CashCount;
import com.pages.CloseFlight_Confirmation;
import com.pages.CloseFlight_Inventory1;
import com.pages.CloseFlight_Seal;
import com.pages.CompanyLoginpage;
import com.pages.Dashboard;
import com.pages.EPOS_DashBoard;
import com.pages.Inventory;
import com.pages.Login;
import com.pages.NewOrder;
import com.pages.OpenFlight;
import com.pages.Payments;
import com.pages.Receipt;
import com.pages.ShoppingCart;
import com.pages.Signature;
import com.pages.StoreInstance;
import com.pages.StoreInstanceDashBoard;
import com.pages.StoreNumber;
import com.pages.Synchronize;

public class DemoTests extends utilities{
	StoreNumber SN = new StoreNumber();
	public String Store = SN.StoreNum(driver);
	CashManagement CM = new CashManagement();
	public String CashBagNum = CM.CashBagNum(driver);
	CashManagement BRN = new CashManagement();
	public String BankRefNum=BRN.BankRefNum(driver);
	
	@Test(priority=1)
	public void DispatchInstance() throws IOException, Exception{
		initialize("chrome",getValue("url"));
		Login.Portal_login(driver,"user","password");
		Dashboard.Navigating_to_Menu(driver,"Manage Store Number", "Store Number Create");
		StoreNumber.Create_StoreNumber(driver,Store);
		//StoreNumber.ReCreate_StoreNum(driver, Store);
	    common.Navigate_To_URL(driver, getValue("DashBoard"));
	    Dashboard.Navigating_to_Menu(driver,"Station Operations", "Store Dispatch");
		StoreInstance.CreateStore_Instance(driver, getValue("LMPStation"),  getValue("ScheduleNum"),Store, getValue("Menu"));
		 StoreInstance.Packing(driver);
		    StoreInstance.AssignSeals(driver,getValue("OutBound"), getValue("HandOver"), getValue("InBound"), getValue("HighSecurity"));
			;
			 StoreInstance.Dispatch(driver);
			   common.Navigate_To_URL(driver, getValue("StoreInstanceDashBoard"));
				  String instancenum=StoreInstanceDashBoard.Searched_Instance(driver, Store);
				  StoreInstanceDashBoard.Verify_InstanceStatus(driver, "Dispatched");
				  System.out.println("Instance dispatched");
				  driver.close();
	}
	
	@Test(priority=2)
	public void OpenFlight() throws FileNotFoundException, IOException, Exception{
		initialize("firefox",getValue("url1"));
		CompanyLoginpage.CompanyLogin(driver, getValue("companyNum"));	
		 Synchronize.Sync(driver);
			Synchronize.Verify_Sync_Process(driver);
			Synchronize.OpenFlight(driver);
	    	OpenFlight.FlightOpen(driver,Store,  getValue("ScheduleNum"),getValue("paxnum1"),  getValue("paxnum2"),  getValue("paxnum3"),getValue("spendperhead"),getValue("Targetspend"));
	    	OpenFlight.Continue(driver);
			//OpenFlight.VerifyFlightConfirmation_popupDetails(driver);
			OpenFlight.Accept_FlightConfirmation_Popup(driver);
			AttendantLogin.AttendentLogin(driver, getValue("CrewId"));
			AssignSeals.Continue(driver);
			Inventory.Continue(driver);
	    	CashCount.Continue(driver);
			EPOS_DashBoard.Navigate_To_DashBoard(driver);
			
	}
	@Test(priority=3)
	public void OnboardSales() throws InterruptedException, FileNotFoundException, IOException{
		NewOrder.Order(driver);
      	ShoppingCart.AllItems(driver);
      	NewOrder.Multiple_Item_Select(driver);
      	NewOrder.CheckOut(driver); 
	   	Payments.Select_SeatNum(driver,getValue("seatrow"),getValue("seat"));
		Payments.CashPayment(driver);
		Payments.Payment_Done(driver);	
		ShoppingCart.Exit_Cart(driver);
	}
	@Test(priority=4)
	public void CloseFlight() throws FileNotFoundException, IOException{
		 CloseFlight.Close_Flight(driver);
			CloseFlight.Accept_CloseBarset_popup(driver);
			CloseFlight.Complete_DuesAndCollectibles1(driver);
			CloseFlight.CloseShop_Device_Sync(driver);
			CloseFlight_Inventory1.CloseShop_Inventory_Continue(driver);
	     	CloseFlight_Seal.CloseShop_SealEntry(driver,getValue("CloseShop_Seal"));
	     	CloseFlight_Seal.CloseShop_Seal_Continue(driver);
	    	CloseFlight_CashCount.Cashbag(driver, CashBagNum);
	    	CloseFlight_CashCount.CashBag_CurrencyEntry1(driver, "GBP (British Pound)",CloseFlight_CashCount.CurrencyTotal(driver, "£"));
	    	CloseFlight_CashCount.CashBag_CurrencyEntry1(driver, "EUR (Euro)",CloseFlight_CashCount.CurrencyTotal(driver,"€"));
	    	CloseFlight_CashCount.CashBag_CurrencyEntry1(driver, "USD (U.S. Dollar)", CloseFlight_CashCount.CurrencyTotal(driver,"$"));
	    	CloseFlight_CashCount.CashBag_CurrencyEntry1(driver, "DKK (Danish Krone)",CloseFlight_CashCount.CurrencyTotal(driver,"ø"));
	    	 CloseFlight_CashCount.Continue(driver);
		       CloseFlight_Confirmation.Continue(driver);
		       Signature.Sign(driver);
		      	 Signature.InformationReview(driver);
		 	    Signature.Accept_Signature(driver);
		 	   Synchronize.Sync(driver);
	}
	@Test(priority=5)
	public void EndInstance() throws FileNotFoundException, IOException, Exception{
		initialize("chrome",getValue("url"));
		Login.Portal_login(driver,"user","password");
		 Dashboard.Navigating_to_Menu(driver,"Station Operations", "Store Instance Dashboard");
		 String instancenum=StoreInstanceDashBoard.Searched_Instance(driver,Store);
		 StoreInstanceDashBoard.Receive(driver, instancenum);
		 StoreInstanceDashBoard.Searched_Instance(driver,Store);
		 StoreInstanceDashBoard.EndInstance(driver, instancenum);
		 StoreInstance.process_EndInstance(driver);
		
	}
	@Test(priority=6)
	public void CashBagSubmit() throws FileNotFoundException, IOException, InterruptedException{
		common.Navigate_To_URL(driver, getValue("DashBoard"));
		// Dashboard.Navigating_to_Menu(driver,"Cash Management", "Daily Exchange Rate");
		// CashManagement.DailyExchangeRate_Submit(driver);
	    //  common.Navigate_To_URL(driver, getValue("DashBoard"));
		    Dashboard.Navigating_to_Menu(driver,"Cash Management", "Manage Cash Bag");
			CashManagement.Search_CashBag(driver, CashBagNum,Store);
			String CashBag=CashManagement.Entered_CashBagNum(driver);
			CashManagement.Edit_CashBag(driver, "1", BankRefNum);
			String RefNum=CashManagement.Entered_BankRefNum(driver);
			CashManagement.Enter_paper_coin_Amount(driver, "GBP");
			common.Navigate_To_URL(driver, getValue("DashBoard"));
			Dashboard.Navigating_to_Menu(driver,"Cash Management", "Cash Bag Submission");
			CashManagement.SearchCashBag_With_BankRefNum(driver, BankRefNum);
			CashManagement.Submit_CashBag(driver, CashBagNum);
	
		
	}
	
	public void postTrip(){
		
	}

}
