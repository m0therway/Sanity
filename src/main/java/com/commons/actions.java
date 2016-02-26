package com.commons;




import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class actions {

	static String first_xpath= "firstpath";
	static String second_xpath = "secondpath";
	static WebDriver driver = null;
	WebElement element = null;
	

	
	 public static void selectByVisibleText(WebDriver driver,String type,String dropdownname, String visibleText) {
		
		By def = null;
		switch (type) {
        case "id":  def = By.id(dropdownname);
                 break;
        case "classname" : def = By.className(dropdownname);
                 break;
        case "xpath" : def = By.xpath(dropdownname);
                 break;         
        default: System.out.println("Invalied type");;
                 break;
    }
		
		Select mydropdown = new Select(driver.findElement(def));
		mydropdown.selectByVisibleText(visibleText);
		
	}
	 public static void selectByindex(WebDriver driver,String type,String listboxname, int index) {
			
			By identification = null;
			switch (type) {
	        case "id":  identification = By.id(listboxname);
	                 break;
	        case "classname" : identification = By.className(listboxname);
	                 break;
	        case "xpath" : identification = By.xpath(listboxname);
	                 break; 
	        case "name" : identification = By.name(listboxname);
	               break;  
	        default: System.out.println("Invalied type");
	                 break;
	    }
			
			Select mydropdown = new Select(driver.findElement(identification));
			mydropdown.selectByIndex(index);
			
			
		}
	
	public static void draganddrop(WebDriver driver,String tablerowspath, String firstpath, String secondpath, String thirdpath, String drop_element, String coltext){
		 int row_count = driver.findElements(By.xpath(tablerowspath)).size();
  		 
  	     for(int row=1; row <=row_count;row++){
 	    	 String finalpath = firstpath + row + secondpath + 1 + thirdpath ;
 	    	 WebElement dragelement = driver.findElement(By.xpath(finalpath));
 	         WebElement dropelement =driver.findElement(By.xpath(drop_element));  
 	         
 	         if(dragelement.getText().equals(coltext)){
 			      Actions builder = new Actions(driver);
 				  Action dragAndDrop = builder.clickAndHold(dragelement)
 			           .moveToElement(dropelement)
 			          .release(dropelement)
 			            .build();
 			             dragAndDrop.perform();
 			             break;
 		          }
 		 	  }
  	 
  	  
	}
	
}
