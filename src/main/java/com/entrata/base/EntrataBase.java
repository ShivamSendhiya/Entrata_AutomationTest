package com.entrata.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.entrata.util.TestUtil;

public class EntrataBase {

	
	public static WebDriver driver;
	public static Properties prop;

	
	//To read config file
	public EntrataBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\shiva\\Desktop\\Eclipse-New\\testEntrata\\src\\main\\java\\com\\entrata\\config\\config.properties");
					
					//System.getProperty("user.dir")+ "src/main/java/com/entrata/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Intialize web driver wrt browser
	public static void initialization(){	
	
	String browserName = prop.getProperty("browser");
	
	if(browserName.equals("chrome")){
		System.setProperty("webdriver.chrome.driver","C:/Users/shiva/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");	
		driver = new ChromeDriver(); 
	}
	
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
	
	}
}
