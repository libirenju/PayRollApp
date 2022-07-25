package TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.payroll.Actions.Action;
import com.payroll.BaseClass.BaseClass;
import com.payroll.PageObjects.LoginPage;
import com.payroll.Utilities.Excel;
import com.payroll.Utilities.Log;

public class InvalidLoginTest extends BaseClass
{
	LoginPage lp; 	Action act; 	Excel ex;
		
	@BeforeMethod
	public void start()
	{
		launchApp();
		
		act = new Action();
		lp = new LoginPage(driver);
		ex = new Excel();
	}

	
	  @Test(dataProvider="getData", priority=1)
	  public void invalidCredentials(String Username, String Password) 
	  { 
		  Log.startTestCase("InValid Login Credentials");
		  lp.login(Username,Password);
		  Log.info("Entered Credentials");
		  act.explicitWait(driver, lp.alertmsg(), 10);
		  String expected ="Incorrect username or password.";
		  String actual = lp.alertMsg();
		  assertEquals(actual, expected);
		  Log.endTestCase("Not able to login and assertion done");
	  }
	  
	  @DataProvider
		public Object[][] getData()
		{
			
			Object[][] data=new Object[1][2];
			data[0][0]="admin";
			data[0][1]="123456";
			return data;
		}
	 
	  @Parameters ({"uname","pwd"})
	  @Test (priority=2)
		public void blankUsername(String uname,String pwd)
	  {
		  Log.startTestCase("Invalid Login and username blank");
		  lp.login(uname,pwd);
		    act.explicitWait(driver, lp.ualert(), 10);
		  String expected = "Username cannot be blank.";
		  String actual =	lp.userAlertMsg();
		  assertEquals(actual, expected);
		  Log.endTestCase("Username alert is fired and assertion done");
	  }
	
	  @Parameters ({"uname1","pwd1"})
	  @Test(priority=3) 
	  public void blankPassword(String user1,String pwd1)
	  { 
		  Log.startTestCase("Invalid Login and password blank");
		  lp.login(user1,pwd1);
		  act.explicitWait(driver, lp.palert(), 10);
		  String expected = "Password cannot be blank.";
		  String actual = lp.passAlertMsg();
		  assertEquals(actual, expected);
		  Log.endTestCase("Password alert is fired and assertion done");
	  }
	 
	 
	@AfterMethod
	public void close()
	{
		driver.close();
	}
	
}
