package TestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.payroll.BaseClass.BaseClass;
import com.payroll.PageObjects.HomePage;
import com.payroll.PageObjects.LoginPage;
import com.payroll.PageObjects.PasswordReset;
import com.payroll.Utilities.Excel;
import com.payroll.Utilities.Log;

public class LoginTest extends BaseClass
{
	  @Test(groups= {"Regression"},priority=1) 
	  public void isValidCredentialsWorking() throws Exception 
	  { 	
		  Log.startTestCase("Login To PayRoll App");
		  String username=Excel.readStringData(1,0,"Login");	
		  String password=Excel.readStringData(1,1,"Login");
		  Log.info("Going to Enter user credentials");
		  lp.login(username,password);
		  String expected ="PAYROLL APPLICATION"; 
		  String actual = hp.homeLogo();
		  assertEquals(actual, expected);
		  Log.info("Logged in to PayRoll App and assertion done");
		  hp.logout();
		  Log.endTestCase("Logged out of PayRoll App");
		  
	  }
	  
		@Test(priority = 2)
		public void iaPasswordRestLinkAccessible() 
		{
			Log.startTestCase("Access Password Reset Link");
			act.click(getDriver(), lp.resetit());
			String expected = "Password Reset";
			String actual = pr.passwordPageLogo();
			assertEquals(actual, expected);
			Log.endTestCase("Password Reset Page got loaded and assertion done");
		}

		@Test(priority = 3)
		public void isEmailFieldAccessible() 
		{
			Log.startTestCase("Check is email field accessible");
			act.click(getDriver(), lp.resetit());
			act.type(pr.Passemail(), "renju");
			Log.info("Clicked and Entered email");
			String expected = "Password Reset";
			String actual = pr.passwordPageLogo();
			assertEquals(actual, expected);
			Log.endTestCase("Able to enter value in email textfield and assertion done");
		}

		@Test(priority = 4)
		public void isAlertShownForNotAEmail() throws IOException
		{
			Log.startTestCase("Check alert is shown for not a valid email");
			act.click(getDriver(), lp.resetit());
			String email = Excel.readStringData(1,0,"PassReset");
			act.type(pr.Passemail(),email);
			Log.info("Clicked and Entered an invalid email");
			act.click(getDriver(), pr.Psend());
			String expected = "Email is not a valid email address.";
			String actual = pr.isNotAValidEmailAlert();
			assertEquals(actual, expected);
			Log.endTestCase("Alert is shown and assertion done");
		}

		@Test(priority = 5)
		public void isAlertShownForBlankEmail()
		{
			Log.startTestCase("Check alert is shown when email field is blank");
			act.click(getDriver(), lp.resetit());
			act.type(pr.Passemail(), "  ");
			Log.info("Entered as blank email");
			act.click(getDriver(), pr.Psend());
			String expected = "Email cannot be blank.";
			String actual = pr.isNotAValidEmailAlert();
			assertEquals(actual, expected);
			Log.endTestCase("Alert is shown and assertion done");
		}

		@Test(priority = 6)
		public void isAlertShownForEmail() throws IOException 
		{
			Log.startTestCase("Check alert is shown when email field is blank");
			act.click(getDriver(), lp.resetit());
			act.click(getDriver(), pr.Passemail());
			String email = Excel.readStringData(2,0,"PassReset");
			act.type(pr.Passemail(), email);
			Log.info("Entered as email not available in database");
			act.click(getDriver(), pr.Psend());
			String expected = "There is no user with this email address.";
			String actual = pr.isNotAValidEmailAlert();
			assertEquals(actual, expected);
			Log.endTestCase("Alert is shown and assertion done");
		}

		@Test(groups= {"Regression"},priority = 7)
		public void isCancelButtonWorking() 
		{
			Log.startTestCase("Check whether cancel button working in reset page");
			act.click(getDriver(), lp.resetit());
			act.click(getDriver(), pr.Pcancel());
			String expected = "Login";
			String actual = lp.loginLogo();
			assertEquals(actual, expected);
			Log.endTestCase("Able to click cancel button and assertion done");
		}

		@Test(priority = 8)
		public void isRemembermeCheckboxEnabled() 
		{
			Log.startTestCase("Check whether remember me checkbox is enable");
			boolean expected = true;
			boolean actual = lp.checkbox();
			assertEquals(actual, expected);
			Log.endTestCase("Remember me checkbox is enable and assertion done");
		}

		@Test(priority = 9)
		public void isRemembermeCheckboxDisabled() 
		{
			Log.startTestCase("Check whether remember me checkbox can be disabled");
			act.click(getDriver(), lp.rememberme());
			boolean expected = false;
			boolean actual = lp.checkbox();
			assertEquals(actual, expected);
			Log.endTestCase("Remember me checkbox getting disabled and assertion done");
		}

				 
}
