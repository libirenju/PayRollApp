package TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.payroll.BaseClass.BaseClass;
import com.payroll.Utilities.Excel;
import com.payroll.Utilities.Log;

public class CreateWorkerTest extends BaseClass
{
	//Verify whether user is able to create new user with entering all details
	
	@Test(priority=4,groups= {"Regression"})
	public void createWorkerAllFields() throws IOException, InterruptedException
	{	
		Log.startTestCase("Launched PayRoll Login Page");
		lp.login(username, password);
		Log.info("Logged into PayRoll App");
		act.click(getDriver(), hp.Hworker());
		act.click(getDriver(), w.createworker());
		Log.info("Going to enter details of worker");	
		String value = Excel.readStringData(1, 0, "CreateWorker");
		act.click(getDriver(), cw.Ctitle());
		act.selectByValue(cw.Ctitle(), value); 
		String fname =	Excel.readStringData(1, 1, "CreateWorker");
		act.click(getDriver(), cw.Cfname());
		act.type(cw.Cfname(), fname);

		String lname = Excel.readStringData(1, 2, "CreateWorker");
		act.click(getDriver(), cw.Clname());
		act.type(cw.Clname(), lname);

		String known = Excel.readStringData(1, 3, "CreateWorker");
		act.click(getDriver(), cw.Cknown());
		act.type(cw.Cknown(), known);

		String phone=Excel.readStringData(1, 4, "CreateWorker");
		act.click(getDriver(), cw.Cphone());
		act.type(cw.Cphone(), phone);

		String mobile = Excel.readStringData(1, 5, "CreateWorker");
		act.click(getDriver(), cw.Cmobile());
		act.type(cw.Cmobile(), mobile);

		act.scrollByValue(getDriver()); 
		
		String email = 	Excel.readStringData(1, 6, "CreateWorker");
		act.click(getDriver(), cw.Cemail());
		act.type(cw.Cemail(), email);

		String gender=Excel.readStringData(1, 7, "CreateWorker"); 
		cw.Cgender().click();
		act.selectByValue(cw.Cgender(), gender);

		String mname = Excel.readStringData(1, 8, "CreateWorker");
		act.click(getDriver(), cw.Cmname());
		act.type(cw.Cmname(), mname);

		String dob = Excel.readStringData(1, 9, "CreateWorker");
		act.click(getDriver(), cw.Cdob());
		act.type(cw.Cdob(), dob);

		String add1 = Excel.readStringData(1, 10, "CreateWorker");
		act.click(getDriver(), cw.Caddress1());
		act.type(cw.Caddress1(), add1);

		String add2 = Excel.readStringData(1, 11, "CreateWorker");
		act.click(getDriver(), cw.Caddress2());
		act.type(cw.Caddress2(), add2);

		String add3 = Excel.readStringData(1, 12, "CreateWorker");
		act.click(getDriver(), cw.Cfname());
		act.type(cw.Caddress3(), add3);

		String pcode = Excel.readStringData(1, 13, "CreateWorker");
		act.click(getDriver(), cw.Cpcode());
		act.type(cw.Cpcode(), pcode);

		String branchid = Excel.readStringData(1, 14, "CreateWorker");
		act.click(getDriver(), cw.Cbranchid());
		act.selectByVisibleText(branchid, cw.Cbranchid());

		String division = Excel.readStringData(1, 15, "CreateWorker");
		act.click(getDriver(), cw.Cdivisionid());
		act.selectByVisibleText(division, cw.Cdivisionid());

		String emptype = Excel.readStringData(1, 16, "CreateWorker");
		act.click(getDriver(), cw.Cemptype());
		act.selectByValue(cw.Cemptype(), emptype);

		String slip = Excel.readStringData(1, 17, "CreateWorker");
		act.click(getDriver(), cw.Cpayslip());
		act.selectByValue(cw.Cpayslip(), slip);

		String status = Excel.readStringData(1, 18, "CreateWorker");
		act.click(getDriver(), cw.Cengstatus());
		act.selectByValue(cw.Cengstatus(), status);

		String ninmbr = Excel.readStringData(1, 19, "CreateWorker");
		act.click(getDriver(), cw.Cninmber());
		act.type(cw.Cninmber(), ninmbr);

		String country = Excel.readStringData(1, 20, "CreateWorker");
		act.click(getDriver(), cw.Ccountry());
		act.type(cw.Ccountry(), country);

		act.scrollByVisibilityOfElement(getDriver(), cw.Cnext());
		
		Log.info("Entered Worker Details and going to submit");
		act.click(getDriver(), cw.Cnext());
		String expected = "WORKER BANK DETAILS";
		String actual = bd.Blogo().getText();
		sa.assertTrue(actual.contains(expected));
				
		Log.info("Worker details saved and redirected to bank details page, assertion completed");
		Log.info("Enter Bank Details");
		
		String paymethod = Excel.readStringData(7, 0, "BankDetails");
		act.click(getDriver(), bd.Bpaymethod());
		act.selectByValue(bd.Bpaymethod(), paymethod);
		
		act.click(getDriver(), bd.Bsave());

		String expected1= Excel.readStringData(1, 3, "CreateWorker");
		String actual1 = w.ViewFunctionTitle();
		assertTrue(actual1.contains(expected1)); hp.logout();
		Log.endTestCase("Bank Details completed and assertion done");

	}
	
	//Verify whether user is able to create new user with entering only mandatory details
	
	@Test(priority=5,groups= {"Smoke"})
	public void createWorkerMandatoryFields() throws IOException, InterruptedException
	{	
		Log.startTestCase("Launched PayRoll Login Page");
		lp.login(username, password);
		Log.info("Logged into PayRoll App");
		act.click(getDriver(), hp.Hworker());
		act.click(getDriver(), w.createworker());
		
		Log.info("Going to enter only mandatory details of worker");		
						
		String fname =	Excel.readStringData(3, 1, "CreateWorker");
		act.click(getDriver(), cw.Cfname());
		act.type(cw.Cfname(), fname);

		String lname = Excel.readStringData(3, 2, "CreateWorker");
		act.click(getDriver(), cw.Clname());
		act.type(cw.Clname(), lname);

		String phone=Excel.readStringData(3,4,"CreateWorker");
		act.click(getDriver(), cw.Cphone());
		act.type(cw.Cphone(), phone);

		act.scrollByValue(getDriver()); 
		
		String email = 	Excel.readStringData(3, 6, "CreateWorker");
		act.click(getDriver(), cw.Cemail());
		act.type(cw.Cemail(), email);

		String gender=Excel.readStringData(3, 7, "CreateWorker"); 
		cw.Cgender().click();
		act.selectByValue(cw.Cgender(), gender);

		String dob = Excel.readStringData(3, 9, "CreateWorker");
		act.click(getDriver(), cw.Cdob());
		act.type(cw.Cdob(), dob);
		
		String add1 = Excel.readStringData(3, 10, "CreateWorker");
		act.click(getDriver(), cw.Caddress1());
		act.type(cw.Caddress1(), add1);

		String pcode = Excel.readStringData(3, 13, "CreateWorker");
		act.click(getDriver(), cw.Cpcode());
		act.type(cw.Cpcode(), pcode);

		String branchid = Excel.readStringData(3, 14, "CreateWorker");
		act.click(getDriver(), cw.Cbranchid());
		act.selectByVisibleText(branchid, cw.Cbranchid());

		String division = Excel.readStringData(3, 15, "CreateWorker");
		act.click(getDriver(), cw.Cdivisionid());
		act.selectByVisibleText(division, cw.Cdivisionid());

		String emptype = Excel.readStringData(3, 16, "CreateWorker");
		act.click(getDriver(), cw.Cemptype());
		act.selectByValue(cw.Cemptype(), emptype);

		String payslip = Excel.readStringData(3, 17, "CreateWorker");
		act.click(getDriver(), cw.Cpayslip());
		act.selectByValue(cw.Cpayslip(), payslip);
		
		String ninmbr = Excel.readStringData(3, 19, "CreateWorker");
		act.click(getDriver(), cw.Cninmber());
		act.type(cw.Cninmber(), ninmbr);

		act.scrollByVisibilityOfElement(getDriver(), cw.Cnext());
		
		Log.info("Entered Mandatory Worker Details and going to submit");
		act.click(getDriver(), cw.Cnext());
						
		String expected = "WORKER";
		String actual = w.ViewFunctionTitle();
		sa.assertTrue(actual.contains(expected));
				
		Log.info("Worker details saved and redirected to bank details page, assertion completed");
		Log.info("Enter Bank Details");
		
		String paymethod = Excel.readStringData(7, 0, "BankDetails");
		act.click(getDriver(), bd.Bpaymethod());
		act.selectByValue(bd.Bpaymethod(), paymethod);
		
		act.click(getDriver(), bd.Bsave());

		String expected1= Excel.readStringData(3, 3, "CreateWorker");
		String actual1 = w.ViewFunctionTitle();
		assertTrue(actual1.contains(expected1)); hp.logout();
		Log.endTestCase("Bank Details completed and assertion done");
	}

	//Verify whether user is getting alert message while missing any mandatory field during create worker
	
		@Test(priority=6)
		public void createWorkerMandatoryAlert() throws IOException, InterruptedException
		{	
			Log.startTestCase("Launched PayRoll Login Page");
			lp.login(username, password);
			Log.info("Logged into PayRoll App");
			act.click(getDriver(), hp.Hworker());
			act.click(getDriver(), w.createworker());
			Log.info("Going to enter only mandatory details of worker");		
			String fname =	Excel.readStringData(5, 1, "CreateWorker");
			act.click(getDriver(), cw.Cfname());
			act.type(cw.Cfname(), fname);

			String phone=Excel.readStringData(5,4,"CreateWorker");
			act.click(getDriver(), cw.Cphone());
			act.type(cw.Cphone(), phone);

			act.scrollByValue(getDriver()); 
			
			String email = 	Excel.readStringData(5, 6, "CreateWorker");
			act.click(getDriver(), cw.Cemail());
			act.type(cw.Cemail(), email);

			String gender=Excel.readStringData(5, 7, "CreateWorker"); 
			cw.Cgender().click();
			act.selectByValue(cw.Cgender(), gender);

			String dob = Excel.readStringData(5, 9, "CreateWorker");
			act.click(getDriver(), cw.Cdob());
			act.type(cw.Cdob(), dob);
			
			String add1 = Excel.readStringData(5, 10, "CreateWorker");
			act.click(getDriver(), cw.Caddress1());
			act.type(cw.Caddress1(), add1);

			String pcode = Excel.readStringData(5, 13, "CreateWorker");
			act.click(getDriver(), cw.Cpcode());
			act.type(cw.Cpcode(), pcode);

			String branchid = Excel.readStringData(5, 14, "CreateWorker");
			act.click(getDriver(), cw.Cbranchid());
			act.selectByVisibleText(branchid, cw.Cbranchid());

			String division = Excel.readStringData(5, 15, "CreateWorker");
			act.click(getDriver(), cw.Cdivisionid());
			act.selectByVisibleText(division, cw.Cdivisionid());

			String emptype = Excel.readStringData(5, 16, "CreateWorker");
			act.click(getDriver(), cw.Cemptype());
			act.selectByValue(cw.Cemptype(), emptype);

			String payslip = Excel.readStringData(5, 17, "CreateWorker");
			act.click(getDriver(), cw.Cpayslip());
			act.selectByValue(cw.Cpayslip(), payslip);
			
			String ninmbr = Excel.readStringData(5, 19, "CreateWorker");
			act.click(getDriver(), cw.Cninmber());
			act.type(cw.Cninmber(), ninmbr);

			act.scrollByVisibilityOfElement(getDriver(), cw.Cnext());
			
			Log.info("Entered Mandatory Worker Details and going to submit");
			act.click(getDriver(), cw.Cnext());
								
			String expected = "Last Name cannot be blank.";
			System.out.println(cw.lnameAlertMsg());
			String actual = cw.lnameAlertMsg();
			sa.assertEquals(actual, expected); hp.logout();
			Log.endTestCase("Not able to create user as mandatory field is empty and assertion done");
		}

}
