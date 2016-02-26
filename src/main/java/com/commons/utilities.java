package com.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;



public class utilities {
	 public static WebDriver driver = null;
	
	 static String browser;
	 	
	
	public static void initialize(String browser, String URL) throws Exception {
		
		System.setProperty("webdriver.ie.driver","C:\\Users\\labbaraju\\Selenium Drivers\\IEDriverServer_Win32_2.45.0\\IEDriverServer.exe");
		//System.setProperty("webdriver.ie.driver","C:\\Users\\labbaraju\\Selenium Drivers\\IEDriverServer_x64_2.43.0\\IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\labbaraju\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		if(browser.equals("firefox")){
			/*System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		    ProfilesIni firProfiles = new ProfilesIni();
			  //Get access of newly created profile WebDriver_Profile.
			  FirefoxProfile wbdriverprofile = firProfiles.getProfile("firefox-profile");
			  //Pass wbdrverprofile parameter to FirefoxDriver.
			  wbdriverprofile.setPreference("browser.helperapps.neverAsk.saveToDisk" , "application/zip"); 
			  wbdriverprofile.setPreference("browser.helperApps.alwaysAsk.force", false);
			  wbdriverprofile.setPreference("browser.download.manager.showWhenStarting",false);
			  wbdriverprofile.setPreference("browser.download.folderList", 2); 
			  wbdriverprofile.setPreference("browser.download.dir","C:\\Users\\labbaraju\\Downloads");*/
			 // driver = new FirefoxDriver(wbdriverprofile); 
			driver = new FirefoxDriver(); 
		}else if(browser.equals("ie")){
		   System.setProperty("webdriver.ie.driver","C:\\Users\\labbaraju\\Selenium Drivers\\IEDriverServer_Win32_2.45.0\\IEDriverServer.exe");
		    DesiredCapabilities capabilities = new DesiredCapabilities();
		    capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); 
		   capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		   capabilities.setJavascriptEnabled(true); 
		 	// WebDriver driver = new InternetExplorerDriver(capabilities);
		    driver = new InternetExplorerDriver(capabilities); 
		    
		}else if(browser.equals("chrome")){
		       System.setProperty("webdriver.chrome.driver","C:\\Users\\labbaraju\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		       DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		       ChromeOptions options = new ChromeOptions();
		       options.addArguments("test-type");
		      
		     capabilities.setCapability("chrome.binary","C:\\Users\\labbaraju\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		     capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		       driver = new ChromeDriver(capabilities);
		      
		      
			}
		   
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 	
			driver.manage().window().maximize();
			  driver.get(URL);
			//  driver.navigate().to("javascript:document.getElementById('overridelink').click()"); 
			if(browser.equals("ie")) {
				driver.get("javascript:document.getElementById('overridelink').click();");
			}
     driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	 }
	//portal propertyfile
	
	 public static String getValue(String Key) throws IOException, FileNotFoundException{
		 File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\com.resource\\env.properties");
		 FileInputStream fileInput = new FileInputStream(file);
		 Properties properties = new Properties();
		 properties.load(fileInput);
		 String value = properties.getProperty(Key);
		 fileInput.close();
		 return value;
	 }
	 //epos property file 
	 public static String getValue1(String Key) throws IOException{
		 File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\com\\resources\\epos.properties");
		 FileInputStream fileInput = new FileInputStream(file);
		 Properties properties = new Properties();
		 properties.load(fileInput);
		 String value = properties.getProperty(Key);
		 fileInput.close();
		 return value;
	 }
	 public static void isprocessrunning(){
		
	 }
	
	 public static void killProcess(String browser) throws Exception {
		 
		  if(browser.equals("firefox")){
			  String kill = "Taskkill /IM firefox.exe /F";
			  Runtime.getRuntime().exec(kill);
		  }else if(browser.equals("IE")){
			  String kill = "Taskkill /IM IEDriverServer.exe /F";
			  Runtime.getRuntime().exec(kill);
		  }else if (browser.equals("chrome")){
			  String kill = "Taskkill /IM chrome.exe /F";
			  Runtime.getRuntime().exec(kill);
		  }
		  
		 }
	 
}
