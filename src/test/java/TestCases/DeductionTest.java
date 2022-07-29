package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.payroll.BaseClass.BaseClass;
import com.payroll.Utilities.Excel;
import com.payroll.Utilities.Log;

public class DeductionTest extends BaseClass
{
	
	@Test(priority=10,groups= {"Smoke"})
	public void viewDeductionDetails() throws IOException
	{	
		Log.startTestCase("Launched PayRoll Login Page");
		lp.login(username, password);
		Log.info("Logged into PayRoll App");
		act.click(getDriver(), deduct.deductionTab());
		act.click(getDriver(), deduct.viewDeductionDetails());
		Log.info("Deduction details are shown");		
		String expected = Excel.readStringData(6, 0, "Deduction");;
		String actual = w.ViewFunctionTitle();
		sa.assertTrue(actual.contains(expected));
		Log.info("Deduction Details viewed and assertion done"); 
		Log.endTestCase("Logged out of PayRoll App");
 
	}
	
	@Test(priority=11) 
	
	public void editDeductionDetails() throws IOException 
	{
	  Log.startTestCase("Launched PayRoll Login Page"); 
	  lp.login(username, password); 
	  Log.info("Logged into PayRoll App"); 
	  act.click(getDriver(),deduct.deductionTab()); 
	  act.click(getDriver(),deduct.editDeductionDetails());
	  act.click(getDriver(), ad.addDeductionAmt());
	  String deductionamt = Excel.readStringData(1, 2, "AddDeduction");
	  act.type(ad.addDeductionAmt(), deductionamt);
	  String workerName = Excel.readStringData(1, 0, "AddDeduction");
	  Log.info("Deduction details are shown");
	  String expected = workerName; 
	  String actual = w.ViewFunctionTitle();
	  sa.assertTrue(actual.contains(expected));
	  Log.info("Deduction Details updated and assertion done"); 
	  Log.endTestCase("Logged out of PayRoll App");
	}
	 
}
