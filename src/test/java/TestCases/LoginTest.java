package TestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.payroll.Actions.Action;
import com.payroll.BaseClass.BaseClass;
import com.payroll.PageObjects.HomePage;
import com.payroll.PageObjects.LoginPage;
import com.payroll.PageObjects.PasswordReset;
import com.payroll.Utilities.Excel;
import com.payroll.Utilities.Log;

public class LoginTest extends BaseClass
{
	LoginPage lp;
	Action act;
	HomePage hp;
	Excel ex; PasswordReset pr;
	
	@BeforeMethod
	public void start()
	{
		launchApp();
		
		act = new Action();
		hp = new  HomePage(driver);
		lp = new LoginPage(driver);
		ex = new Excel();
		pr = new PasswordReset(driver);
	}
	
	  @Test(priority=1) 
	  public void validLogin() throws Exception 
	  { 	
		  Log.startTestCase("Login To PayRoll App");
		  String username=ex.readStringData(1,0,"Login");	//username from excelfile
		  String password=ex.readStringData(1,1,"Login");	//password from excelfile
		  Log.info("Going to Enter user credentials");
		  lp.login(username,password);
		  //act.explicitWait(driver, hp.Hlogo(), 10); 
		  String expected ="PAYROLL APPLICATION"; 
		  String actual = hp.homeLogo();
		  assertEquals(actual, expected);
		  Log.info("Logged in to PayRoll App and assertion done");
		  hp.logout();
		  Log.endTestCase("Logged out of PayRoll App");
		  
	  }
	  
		@Test(priority = 2)
		public void accessPassLink() 
		{
			Log.startTestCase("Access Password Reset Link");
			act.click(driver, lp.resetit());
			act.explicitWait(driver, pr.Passlogo(), 10);
			String expected = "Password Reset";
			String actual = pr.passLogo();
			assertEquals(actual, expected);
			Log.endTestCase("Password Reset Page got loaded and assertion done");
		}

		@Test(priority = 3)
		public void accessEmailField() 
		{
			Log.startTestCase("Check is email field accessible");
			act.click(driver, lp.resetit());
			act.type(pr.Passemail(), "renju");
			Log.info("Clicked and Entered email");
			act.explicitWait(driver, pr.Passlogo(), 10);
			String expected = "Password Reset";
			String actual = pr.passLogo();
			assertEquals(actual, expected);
			Log.endTestCase("Able to enter value in email textfield and assertion done");
		}

		@Test(priority = 4)
		public void invalidEmail()
		{
			act.click(driver, lp.resetit());
			act.type(pr.Passemail(), "renju");
			act.click(driver, pr.Psend());
			act.explicitWait(driver, pr.Psend(), 10);
			String expected = "Email is not a valid email address.";
			String actual = pr.invalidmail().getText();
			assertEquals(actual, expected);
		}

		@Test(priority = 5)
		public void blankEmail()
		{
			act.click(driver, lp.resetit());
			act.type(pr.Passemail(), "  ");
			act.click(driver, pr.Psend());
			act.explicitWait(driver, pr.Passlogo(), 10);
			String expected = "Email cannot be blank.";
			String actual = pr.invalidmail().getText();
			System.out.println(actual);
			assertEquals(actual, expected);
		}

		@Test(priority = 6)
		public void invalidEmail1() 
		{
			act.click(driver, lp.resetit());
			pr.Passemail().click();
			pr.Passemail().sendKeys("renju@gmail.com");
			pr.Psend().click();
			act.explicitWait(driver, pr.Passlogo(), 10);
			String expected = "There is no user with this email address.";
			String actual = pr.invalidmail().getText();
			assertEquals(actual, expected);
		}

		@Test(priority = 7)
		public void cancelButton() 
		{
			Log.startTestCase("Check whether cancel button working in reset page");
			act.click(driver, lp.resetit());
			act.click(driver, pr.Pcancel());
			act.explicitWait(driver, lp.loginlogo(), 10);
			String expected = "Login";
			String actual = lp.loginLogo();
			assertEquals(actual, expected);
			Log.endTestCase("Able to click cancel button and assertion done");
		}

		@Test(priority = 8)
		public void rememberme() 
		{
			Log.startTestCase("Check whether remember me checkbox is enable");
			act.explicitWait(driver, lp.loginlogo(), 10);
			boolean expected = true;
			boolean actual = lp.checkbox();
			assertEquals(actual, expected);
			Log.endTestCase("Remember me checkbox is enable and assertion done");
		}

		
		@AfterMethod
		public void close() 
		{
			driver.close();
		}
		 
}
