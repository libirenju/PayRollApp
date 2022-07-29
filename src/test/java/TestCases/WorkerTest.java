package TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.payroll.Actions.Action;
import com.payroll.BaseClass.BaseClass;
import com.payroll.PageObjects.BankDetailsPage;
import com.payroll.PageObjects.CreateWorker;
import com.payroll.PageObjects.HomePage;
import com.payroll.PageObjects.LoginPage;
import com.payroll.PageObjects.Workers;
import com.payroll.Utilities.Excel;
import com.payroll.Utilities.Log;

public class WorkerTest extends BaseClass
{
			
	@Test(priority=1,groups= {"Regression"})
	public void isSearchFilterWorking() throws IOException, InterruptedException
	{
		Log.startTestCase("Login To PayRoll App");
		lp.login(username,password);
		act.click(getDriver(), hp.Hworker());
		act.click(getDriver(), w.Wfname());
		String fname = Excel.readStringData(2, 0, "workerpage");
		act.type(w.Wfname(), fname);
		act.click(getDriver(), w.Wsearch());
		String expected = Excel.readStringData(2, 1, "workerpage");;
		String actual = w.searchValueText();
		assertEquals(actual, expected);
		Log.info("Applied filter and assertion done");
		hp.logout();
		Log.endTestCase("Logged out of PayRoll App");
		
	}
		

	@Test(priority=2)
	public void isViewFunctionWorking() throws IOException, InterruptedException
	{
		Log.startTestCase("Login To PayRoll App");
		lp.login(username,password);
		act.click(getDriver(), hp.Hworker());
		act.click(getDriver(), w.Wview());
		String expected =  Excel.readStringData(5, 0, "workerpage");
		String actual = w.ViewFunctionTitle();
		assertEquals(actual, expected);
		Log.info("Applied filter and assertion done");
		hp.logout();
		Log.endTestCase("Logged out of PayRoll App");
	}
	
	@Test(priority=3)
	public void isEditFunctionWorking() throws IOException, InterruptedException
	{
		Log.startTestCase("Login To PayRoll App");
		lp.login(username,password);
		act.click(getDriver(), hp.Hworker());
		act.click(getDriver(), w.Wedit());
		act.click(getDriver(), cw.Cknown());
		String editknownvalue = Excel.readStringData(3, 3, "Edit");
		act.type(cw.Cknown(), editknownvalue);
		act.scrollByVisibilityOfElement(getDriver(), cw.Cnext()); 
		act.click(getDriver(), cw.Cnext());
		String paymethod = Excel.readStringData(7, 0, "BankDetails");
		act.click(getDriver(), bd.Bpaymethod());
		act.selectByValue(bd.Bpaymethod(), paymethod);
		act.click(getDriver(), bd.Bsave());
		String expected = editknownvalue;
		String actual = w.ViewFunctionTitle();
		assertTrue(actual.contains(expected));
		Log.info("Applied filter and assertion done");
		Log.endTestCase("Logged out of PayRoll App");
		 
	}
	
}
