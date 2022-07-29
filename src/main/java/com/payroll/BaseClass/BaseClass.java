package com.payroll.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.payroll.Actions.Action;
import com.payroll.PageObjects.AddDeductionPage;
import com.payroll.PageObjects.BankDetailsPage;
import com.payroll.PageObjects.CreateWorker;
import com.payroll.PageObjects.DeductionPage;
import com.payroll.PageObjects.HomePage;
import com.payroll.PageObjects.LoginPage;
import com.payroll.PageObjects.PasswordReset;
import com.payroll.PageObjects.Workers;
import com.payroll.Utilities.Excel;
import com.payroll.Utilities.ExtentReport;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static Properties prop;
	public static Action act = new Action();	public PasswordReset pr;	public SoftAssert sa;
	public static LoginPage lp ; public HomePage hp; 	public BankDetailsPage bd;
	public Workers w; public CreateWorker cw; public String password; public String username;
	public DeductionPage deduct; public AddDeductionPage ad; 
	
	//public static WebDriver driver;
	//loadConfig method is to load the configuration
	
	//For achieving parallel execution
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	
	 
	@BeforeSuite (groups= {"Regression"})
	public void loadConfig() 
	{
		DOMConfigurator.configure("log4j.xml");
		ExtentReport.setExtent();

		try {
			 prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configurations\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver getDriver()
	{
		return driver.get();
	}
	
	
	public void launchApp(String browserName) {
		
	  // String browserName = prop.getProperty("Browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}
		//Maximize the screen
		getDriver().manage().window().maximize();
		//Implicit TimeOuts
		act.implicitWait(getDriver(), 20);
		//PageLoad TimeOuts
		act.pageLoadTimeOut(getDriver(), 30);   
		 getDriver().get(prop.getProperty("url"));
		 
	}
	
	@BeforeMethod(groups= {"Regression"})
	@Parameters ({"browser"})
	public void first(String browser) throws IOException
	{
		launchApp(browser);
		lp = new LoginPage(getDriver());	cw = new CreateWorker(getDriver());
		hp = new  HomePage(getDriver()); 	pr = new PasswordReset(getDriver());
		w = new Workers(getDriver());  		sa = new SoftAssert();
		bd = new BankDetailsPage(getDriver());	deduct = new DeductionPage(getDriver());
		ad = new AddDeductionPage(getDriver());
		username=Excel.readStringData(1,0,"Login");
		password=Excel.readStringData(1,1,"Login");
	}
	
	@AfterMethod(groups= {"Regression"}) 
	public void close() 
	{
		getDriver().close();
	}
		 
	
	@AfterSuite(groups= {"Regression"})
	public void End()
	{
		ExtentReport.endReport();
	}
}
