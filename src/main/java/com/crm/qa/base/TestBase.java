package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException {
	    prop = new Properties();
		FileInputStream configFile = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/crm/qa/config/config.properties");
		prop.load(configFile);
	}
	
  public static void initialization(){
	  
	  if(prop.getProperty("browser").equals("firefox")) {
		    System.setProperty("webdriver.gecko.driver","/Users/Sateesh/Downloads/geckodriver");
			driver = new FirefoxDriver();
		}else if(prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","/Users/Sateesh/Downloads/chromedriver");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	 
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
  }

}
