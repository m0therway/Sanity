package com.commons;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter{
	private int Count = 0;
	int iteration_number = 1;

	 public static WebDriver driver=null;
	 public static Hashtable<String,String> resultTable;
	 public static String resultFolderName;
	 public static String resultFolder;
	   @Override
	    public void onStart(ITestContext tr) {
		   Reporter.log("Start Of Execution(TEST)->"+tr.getName());
		  
		   if (resultFolder == null ){
			   Date d1 = new Date();
		    	 resultFolder = d1.toString().replace(":", "_");
				File f1 = new File("C:\\Users\\labbaraju\\workspace\\com.TS5EndToEnd\\Reports\\"+resultFolder);
				   f1.mkdir();
		   }
         }
		 
	    @Override
	    public void onTestFailure(ITestResult tr) {
	    	Reporter.log("Test Case:-"+tr.getName()+ "=>Failed\n", true );
	       ScreenShot();
	    }
		 
	    @Override
	    public void onTestSkipped(ITestResult tr) {
	    	Reporter.log("Test Case:-"+tr.getName()+ "=>Skipped\n", true );
	    }
		 
	    @Override
	    public void onTestSuccess(ITestResult tr) {
	    	Reporter.log("Test Case:-"+tr.getName()+ "=>Passed\n" , true );
	    }
	    
	    @Override
	    public void onFinish(ITestContext tr) {
	    	Reporter.log("END Of Execution(TEST)->"+tr.getName());
			   File src1 = new File("C:\\Users\\labbaraju\\workspace\\com.TS5EndToEnd\\testng_output\\index.html");
			   File src2 = new File("C:\\Users\\labbaraju\\workspace\\com.TS5EndToEnd\\testng_output\\emailable-report.html");
			   File src3 = new File("C:\\Users\\labbaraju\\workspace\\com.TS5EndToEnd\\testng_output\\reporter-output.html");
			   File src4 = new File("C:\\Users\\labbaraju\\workspace\\com.TS5EndToEnd\\target\\surefire-reports\\testng-failed.xml");
			   File dest1 = new File("C:\\Users\\labbaraju\\workspace\\com.TS5EndToEnd\\Reports\\"+resultFolder+"\\index.html");
			   File dest2 = new File("C:\\Users\\labbaraju\\workspace\\com.TS5EndToEnd\\Reports\\"+resultFolder+"\\emailable-report.html");
			   File dest3 = new File("C:\\Users\\labbaraju\\workspace\\com.TS5EndToEnd\\Reports\\"+resultFolder+"\\reporter-output.html");
			   File dest4 = new File("C:\\Users\\labbaraju\\workspace\\com.TS5EndToEnd\\Reports\\"+resultFolder+"\\testng-failed.xml");
			   try {
				FileUtils.copyFile(src1, dest1);
				FileUtils.copyFile(src2, dest2);
				FileUtils.copyFile(src3, dest3);
				FileUtils.copyFile(src4, dest4);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
	    }
	
	    private void ScreenShot() {

	    	try {

	    	String NewFileNamePath;
	    	//Get the dir path

	    //	File directory = new File (".");

	    	//get current date time with Date() to create unique file name

	    	DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ssaa");

	    	//get current date time with Date()

	    	Date date = new Date();
	    	//To identify the system
	    	InetAddress ownIP=InetAddress.getLocalHost();
	    	NewFileNamePath =  "C:\\Users\\labbaraju\\workspace\\com.TS5EndToEnd\\ScreenShots\\"+ dateFormat.format(date)+"_"+ownIP.getHostAddress()+ ".png";

	    	//Capture the screen shot of the area of the screen defined by the rectangle

	    	Robot robot = new Robot();

	    	BufferedImage bi=robot.createScreenCapture(new Rectangle(1280,1024));

	    	ImageIO.write(bi, "png", new File(NewFileNamePath));

	    	
			Count++;//Assign each screen shot a number
	    	//Logs error screen link in Index.html report under Reporter output(click on it)

	    	Reporter.log("<a href="+NewFileNamePath+">Error ScreenShot</a>");

	    	}

	    	catch (AWTException e) {

	    	e.printStackTrace();

	    	}

	    	catch (IOException e) {

	    	e.printStackTrace();

	    	}

	    	}
	    
	    public void report(String name,int number,String result){
	    	//test iteration 1
	    	//test iteration 2
	    	int iteration_number = 1;
	    	while(resultTable.contains(name+" Iteration" +iteration_number )){
	    		iteration_number++;
	    	}
	    	resultTable.put(name+ "Iteration"+ iteration_number , result);
	    }


}
