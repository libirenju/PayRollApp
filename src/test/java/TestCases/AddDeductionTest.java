package TestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import com.payroll.BaseClass.BaseClass;
import com.payroll.Utilities.Excel;
import com.payroll.Utilities.Log;

public class AddDeductionTest extends BaseClass
{
	@Test(priority=12,groups= {"Regression"})
	public void enterDeductionAllFields() throws IOException
	{	
		Log.startTestCase("Launched PayRoll Login Page");
		lp.login(username, password);
		Log.info("Logged into PayRoll App");
		act.click(getDriver(), deduct.deductionTab());
		act.click(getDriver(), deduct.addDeductionBtn());
		Log.info("Going to enter deduction details");		
		act.click(getDriver(), ad.selectworkerDrpdwn());
		act.click(getDriver(), ad.workerDrpdwnText());
		String workerName = Excel.readStringData(1, 0, "AddDeduction");
		act.type(ad.workerDrpdwnText(), workerName);
		act.click(getDriver(), ad.addDeductionType());
		String workertype = Excel.readStringData(1, 1, "AddDeduction");
		act.selectByValue(ad.addDeductionType(), workertype);
		act.click(getDriver(), ad.addDeductionAmt());
		String deductionamt = Excel.readStringData(1, 2, "AddDeduction");
		act.type(ad.addDeductionAmt(), deductionamt);
		act.click(getDriver(), ad.addDeductionStartDate());
		String deductionstartdate = Excel.readStringData(1, 3, "AddDeduction");
		act.type(ad.addDeductionStartDate(), deductionstartdate);
		Log.info("Entered Deduction Details and going to submit");
		act.click(getDriver(), ad.saveDeductionBtn());
		String expected1 = workerName;
		String actual1 = w.ViewFunctionTitle();
		sa.assertTrue(actual1.contains(expected1));
		Log.info("Deduction Details completed and assertion done");
		Log.endTestCase("Logged out of PayRoll App");
 
	}
	
	@Test(priority=13,groups= {"Smoke"})
	public void checkMandatoryFieldAlert() throws IOException
	{	
		Log.startTestCase("Launched PayRoll Login Page");
		lp.login(username, password);
		Log.info("Logged into PayRoll App");
		act.click(getDriver(), deduct.deductionTab());
		act.click(getDriver(), deduct.addDeductionBtn());
		Log.info("Going to enter deduction details");		
		act.click(getDriver(), ad.selectworkerDrpdwn());
		act.click(getDriver(), ad.workerDrpdwnText());
		String workerName = Excel.readStringData(1, 0, "AddDeduction");
		act.type(ad.workerDrpdwnText(), workerName);
		act.click(getDriver(), ad.addDeductionType());
		String workertype = Excel.readStringData(1, 1, "AddDeduction");
		act.selectByValue(ad.addDeductionType(), workertype);
		act.click(getDriver(), ad.addDeductionStartDate());
		String deductionstartdate = Excel.readStringData(3, 3, "AddDeduction");
		act.type(ad.addDeductionStartDate(), deductionstartdate);		
		Log.info("Entered Deduction Details and going to submit");
		act.click(getDriver(), ad.saveDeductionBtn());
		String expected = "Amount cannot be blank.";
		String actual = ad.alertForDeductionAmt();
		System.out.println(expected +"   "+actual);
		assertEquals(actual, expected);
		Log.info("Mandatory alert is shown and assertion done");
		Log.endTestCase("Logged out of PayRoll App");
 
	}
	
	
}
