package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class BaseClass {

public	static WebDriver driver;
public	static Properties prop;
public static EventFiringWebDriver e_driver;
public static WebEventListener  eventListner;
	public BaseClass() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\shiva\\Desktop\\QA SELEMIUM TESTING AND JAVA\\QA SELENIUM BY MADHAVI\\NaveenProject-master\\NaveenProject-master\\NaveenPOMFreeCrm\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String Browser = prop.getProperty("browser");
		try {
			if (Browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (Browser.equalsIgnoreCase("gecko")) {
				driver = new FirefoxDriver();
			}else if(Browser.equalsIgnoreCase("IE")) {
				driver = new InternetExplorerDriver();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		e_driver=new EventFiringWebDriver(driver);
		//noe create event handler to register it with eventFiringWebDriver
		eventListner=new WebEventListener();
		e_driver.register(eventListner);
		driver=e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait_Timeout, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
