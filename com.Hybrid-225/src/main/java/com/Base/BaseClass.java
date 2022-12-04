package com.Base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Utils.PropertyUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class BaseClass {
	public static WebDriver driver=null;
	
	public static ExtentReports report=null;
	
	public static ExtentSparkReporter spark=null;
	
	public static ExtentTest test=null;
	
	public static Logger log=Logger.getLogger(BaseClass.class);
	
	public static void initialization() throws Exception {
		
		System.out.println("reading property file for the browser name");
		
		log.info("reading property file for the browser name");
		
		String browserName=PropertyUtils.readproperty("browser");
		
		if(browserName.equals("chrome")) {
			
			log.info("initialization of chrome browser");
			
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
			
			driver=new ChromeDriver();
			
		}
		if(browserName.equals("firefox")) {
			log.info("initialization of firefox browser");
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(PropertyUtils.readproperty("url"));

}
	public void reportInit() {
		
		report=new ExtentReports();
		
		String path=System.getProperty("user.dir")+"/target/ExtentReport.html";
		
		spark=new ExtentSparkReporter(path);
		
		report.attachReporter(spark);
	}
}