package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

import com.mystore.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	static Action act=new Action();
	public static Properties prop;
	public static WebDriver driver;

	//public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<RemoteWebDriver>();

	//public static WebDriver getDriver() {
	//return driver.get();
	//}



	@BeforeTest
	public void loadConfig() {
	try {
	prop=new Properties();
	System.out.println("super constructor invoked");
	FileInputStream ip=new FileInputStream(
	System.getProperty("user.dir") + "\\Configuration\\config.properties");
	prop.load(ip);
	System.out.println("driver: " + driver);



	} catch (FileNotFoundException e) {
	e.printStackTrace();
	} catch (IOException e) {
	e.printStackTrace();
	}
	}
	public static void launchApp() {

	String browserName=prop.getProperty("browser");
	if(browserName.equalsIgnoreCase("Chrome")) {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	//driver.get(new ChromeDriver());
	}else if (browserName.equalsIgnoreCase("FireFox")) {
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	//driver.get(new FirefoxDriver());
	}else if (browserName.contains("IE")) {
	WebDriverManager.edgedriver().setup();
	driver=new InternetExplorerDriver();
	//driver.get(new InternetExplorerDriver());
	}
	driver.manage().window().maximize();
	act.implicitWait(driver,10);
	act.pageLoadTimeOut(driver, 30);
	//Launching the URL
	driver.get(prop.getProperty("url"));
	}
}



