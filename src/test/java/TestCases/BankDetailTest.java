package TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;
import com.payroll.BaseClass.BaseClass;
import com.payroll.Utilities.Excel;
import com.payroll.Utilities.Log;

public class BankDetailTest extends BaseClass
{
	//Verify whether user is able to enter all bank details field and submit
	
	@Test(priority=7)
	public void bankAllFields() throws IOException
	{	
		Log.startTestCase("Launched PayRoll Login Page");
		lp.login(username, password);
		Log.info("Logged into PayRoll App");
		act.click(getDriver(), hp.Hworker());
		act.click(getDriver(), w.createworker());
		Log.info("Going to enter details of worker");		
		String fname =	Excel.readStringData(10, 1, "CreateWorker");
		act.click(getDriver(), cw.Cfname());
		act.type(cw.Cfname(), fname);

		String lname = Excel.readStringData(10, 2, "CreateWorker");
		act.click(getDriver(), cw.Clname());
		act.type(cw.Clname(), lname);

		String known = Excel.readStringData(10, 3, "CreateWorker");
		act.click(getDriver(), cw.Cknown());
		act.type(cw.Cknown(), known);

		String phone=Excel.readStringData(10,4,"CreateWorker");
		act.click(getDriver(), cw.Cphone());
		act.type(cw.Cphone(), phone);

		String mobile = Excel.readStringData(10, 5, "CreateWorker");
		act.click(getDriver(), cw.Cmobile());
		act.type(cw.Cmobile(), mobile);

		act.scrollByValue(getDriver()); 
		
		String email = 	Excel.readStringData(10, 6, "CreateWorker");
		act.click(getDriver(), cw.Cemail());
		act.type(cw.Cemail(), email);

		String gvalue=Excel.readStringData(10, 7, "CreateWorker"); 
		cw.Cgender().click();
		act.selectByValue(cw.Cgender(), gvalue);

		String mname = Excel.readStringData(10, 8, "CreateWorker");
		act.click(getDriver(), cw.Cmname());
		act.type(cw.Cmname(), mname);

		String dob = Excel.readStringData(10, 9, "CreateWorker");
		act.click(getDriver(), cw.Cdob());
		act.type(cw.Cdob(), dob);

		String add1 = Excel.readStringData(10, 10, "CreateWorker");
		act.click(getDriver(), cw.Caddress1());
		act.type(cw.Caddress1(), add1);

		String add2 = Excel.readStringData(10, 11, "CreateWorker");
		act.click(getDriver(), cw.Caddress2());
		act.type(cw.Caddress2(), add2);

		String add3 = Excel.readStringData(10, 12, "CreateWorker");
		act.click(getDriver(), cw.Cfname());
		act.type(cw.Caddress3(), add3);

		String pcode = Excel.readStringData(10, 13, "CreateWorker");
		act.click(getDriver(), cw.Cpcode());
		act.type(cw.Cpcode(), pcode);

		String brtext = Excel.readStringData(10, 14, "CreateWorker");
		act.click(getDriver(), cw.Cbranchid());
		act.selectByVisibleText(brtext, cw.Cbranchid());

		String division = Excel.readStringData(10, 15, "CreateWorker");
		act.click(getDriver(), cw.Cdivisionid());
		act.selectByVisibleText(division, cw.Cdivisionid());

		String emptype = Excel.readStringData(10, 16, "CreateWorker");
		act.click(getDriver(), cw.Cemptype());
		act.selectByValue(cw.Cemptype(), emptype);

		String slip = Excel.readStringData(10, 17, "CreateWorker");
		act.click(getDriver(), cw.Cpayslip());
		act.selectByValue(cw.Cpayslip(), slip);

		String status = Excel.readStringData(10, 18, "CreateWorker");
		act.click(getDriver(), cw.Cengstatus());
		act.selectByValue(cw.Cengstatus(), status);

		String ninmbr = Excel.readStringData(10, 19, "CreateWorker");
		act.click(getDriver(), cw.Cninmber());
		act.type(cw.Cninmber(), ninmbr);

		act.scrollByVisibilityOfElement(getDriver(), cw.Cnext());
		
		Log.info("Entered Worker Details and going to submit");
		act.click(getDriver(), cw.Cnext());
		act.explicitWait(getDriver(), bd.Blogo(), 10);
				
		String expected = "WORKER BANK DETAILS";
		String actual = w.ViewFunctionTitle();
		sa.assertTrue(actual.contains(expected));
				
		Log.info("Worker details saved and redirected to bank details page, assertion completed");
		Log.info("Enter Bank Details");
		
		String acctname = Excel.readStringData(1,2, "BankDetails");
		act.click(getDriver(), bd.Baccname());
		act.type(bd.Baccname(), acctname);

		String acctnmbr = Excel.readStringData(1,3, "BankDetails");
		act.click(getDriver(), bd.Bacctnmbr());
		act.type(bd.Bacctnmbr(), acctnmbr);

		String sortcode = Excel.readStringData(1,4, "BankDetails");
		act.click(getDriver(), bd.sortcode());
		act.type(bd.sortcode(), sortcode);

		String rollno = Excel.readStringData(1,6, "BankDetails");
		act.click(getDriver(), bd.Brollnmber());
		act.type(bd.Brollnmber(), rollno);

		String bankname = Excel.readStringData(1,7, "BankDetails");
		act.click(getDriver(), bd.Bankname());
		act.type(bd.Bankname(), bankname);

		String bankadd = Excel.readStringData(1,8, "BankDetails");
		act.click(getDriver(), bd.Bankadd());
		act.type(bd.Bankadd(), bankadd);

		act.click(getDriver(), bd.Bsave());

		String expected1= Excel.readStringData(10, 3, "CreateWorker");
		String actual1 = w.ViewFunctionTitle();
		sa.assertTrue(actual1.contains(expected1));
		Log.info("Bank Details completed and assertion done");
		//act.logOut();
		Log.endTestCase("Logged out of PayRoll App");
	}
	
	//Verify whether user is able to enter only mandatory bank details field and submit
	
	@Test(priority=8,groups= {"Regression"})
	public void bankMandatoryFields() throws IOException, InterruptedException
	{	
		Log.startTestCase("Launched PayRoll Login Page");
		lp.login(username, password);
		Log.info("Logged into PayRoll App");
		act.click(getDriver(), hp.Hworker());
		act.click(getDriver(), w.createworker());
		
		Log.info("Going to enter details of worker");		
						
		String fname =	Excel.readStringData(10, 1, "CreateWorker");
		act.click(getDriver(), cw.Cfname());
		act.type(cw.Cfname(), fname);

		String lname = Excel.readStringData(10, 2, "CreateWorker");
		act.click(getDriver(), cw.Clname());
		act.type(cw.Clname(), lname);

		String known = Excel.readStringData(10, 3, "CreateWorker");
		act.click(getDriver(), cw.Cknown());
		act.type(cw.Cknown(), known);

		String phone=Excel.readStringData(10,4,"CreateWorker");
		act.click(getDriver(), cw.Cphone());
		act.type(cw.Cphone(), phone);

		String mobile = Excel.readStringData(10, 5, "CreateWorker");
		act.click(getDriver(), cw.Cmobile());
		act.type(cw.Cmobile(), mobile);

		act.scrollByValue(getDriver()); 
		
		String email = 	Excel.readStringData(10, 6, "CreateWorker");
		act.click(getDriver(), cw.Cemail());
		act.type(cw.Cemail(), email);

		String gvalue=Excel.readStringData(10, 7, "CreateWorker"); 
		cw.Cgender().click();
		act.selectByValue(cw.Cgender(), gvalue);

		String mname = Excel.readStringData(10, 8, "CreateWorker");
		act.click(getDriver(), cw.Cmname());
		act.type(cw.Cmname(), mname);

		String dob = Excel.readStringData(10, 9, "CreateWorker");
		act.click(getDriver(), cw.Cdob());
		act.type(cw.Cdob(), dob);

		String add1 = Excel.readStringData(10, 10, "CreateWorker");
		act.click(getDriver(), cw.Caddress1());
		act.type(cw.Caddress1(), add1);

		String add2 = Excel.readStringData(10, 11, "CreateWorker");
		act.click(getDriver(), cw.Caddress2());
		act.type(cw.Caddress2(), add2);

		String add3 = Excel.readStringData(10, 12, "CreateWorker");
		act.click(getDriver(), cw.Cfname());
		act.type(cw.Caddress3(), add3);

		String pcode = Excel.readStringData(10, 13, "CreateWorker");
		act.click(getDriver(), cw.Cpcode());
		act.type(cw.Cpcode(), pcode);

		String brtext = Excel.readStringData(10, 14, "CreateWorker");
		act.click(getDriver(), cw.Cbranchid());
		act.selectByVisibleText(brtext, cw.Cbranchid());

		String division = Excel.readStringData(10, 15, "CreateWorker");
		act.click(getDriver(), cw.Cdivisionid());
		act.selectByVisibleText(division, cw.Cdivisionid());

		String emptype = Excel.readStringData(10, 16, "CreateWorker");
		act.click(getDriver(), cw.Cemptype());
		act.selectByValue(cw.Cemptype(), emptype);

		String slip = Excel.readStringData(10, 17, "CreateWorker");
		act.click(getDriver(), cw.Cpayslip());
		act.selectByValue(cw.Cpayslip(), slip);

		String status = Excel.readStringData(10, 18, "CreateWorker");
		act.click(getDriver(), cw.Cengstatus());
		act.selectByValue(cw.Cengstatus(), status);

		String ninmbr = Excel.readStringData(10, 19, "CreateWorker");
		act.click(getDriver(), cw.Cninmber());
		act.type(cw.Cninmber(), ninmbr);

		act.scrollByVisibilityOfElement(getDriver(), cw.Cnext());
		
		Log.info("Entered Worker Details and going to submit");
		act.click(getDriver(), cw.Cnext());
		act.explicitWait(getDriver(), bd.Blogo(), 10);
				
		String expected = "WORKER BANK DETAILS";
		String actual =w.ViewFunctionTitle();
		sa.assertTrue(actual.contains(expected));
				
		Log.info("Worker details saved and redirected to bank details page, assertion completed");
		Log.info("Enter Bank Details");
		
		String acctname = Excel.readStringData(3,2, "BankDetails");
		act.click(getDriver(), bd.Baccname());
		act.type(bd.Baccname(), acctname);

		String acctnmbr = Excel.readStringData(3,3, "BankDetails");
		act.click(getDriver(), bd.Bacctnmbr());
		act.type(bd.Bacctnmbr(), acctnmbr);

		String sortcode = Excel.readStringData(3,4, "BankDetails");
		act.click(getDriver(), bd.sortcode());
		act.type(bd.sortcode(), sortcode);

		act.click(getDriver(), bd.Bsave());

		String expected1= Excel.readStringData(10, 3, "CreateWorker");
		String actual1 = w.ViewFunctionTitle();
		sa.assertTrue(actual1.contains(expected1));
		Log.info("Bank Details completed and assertion done");
		//act.logOut();
		Log.endTestCase("Logged out of PayRoll App");

	}

	//Verify whether alert is shown when user leave mandatory field blank in bank details field and submit
	
		@Test(priority=9)
		public void bankMandatoryAlert() throws IOException, InterruptedException
		{	
			Log.startTestCase("Launched PayRoll Login Page");
			lp.login(username, password);
			Log.info("Logged into PayRoll App");
			act.click(getDriver(), hp.Hworker());
			act.click(getDriver(), w.createworker());
			
			Log.info("Going to enter only mandatory details of worker");		
							
			String fname =	Excel.readStringData(10, 1, "CreateWorker");
			act.click(getDriver(), cw.Cfname());
			act.type(cw.Cfname(), fname);

			String lname = Excel.readStringData(10, 2, "CreateWorker");
			act.click(getDriver(), cw.Clname());
			act.type(cw.Clname(), lname);

			String known = Excel.readStringData(10, 3, "CreateWorker");
			act.click(getDriver(), cw.Cknown());
			act.type(cw.Cknown(), known);

			String phone=Excel.readStringData(10,4,"CreateWorker");
			act.click(getDriver(), cw.Cphone());
			act.type(cw.Cphone(), phone);

			String mobile = Excel.readStringData(10, 5, "CreateWorker");
			act.click(getDriver(), cw.Cmobile());
			act.type(cw.Cmobile(), mobile);

			act.scrollByValue(getDriver()); 
			
			String email = 	Excel.readStringData(10, 6, "CreateWorker");
			act.click(getDriver(), cw.Cemail());
			act.type(cw.Cemail(), email);

			String gvalue=Excel.readStringData(10, 7, "CreateWorker"); 
			cw.Cgender().click();
			act.selectByValue(cw.Cgender(), gvalue);

			String mname = Excel.readStringData(10, 8, "CreateWorker");
			act.click(getDriver(), cw.Cmname());
			act.type(cw.Cmname(), mname);

			String dob = Excel.readStringData(10, 9, "CreateWorker");
			act.click(getDriver(), cw.Cdob());
			act.type(cw.Cdob(), dob);

			String add1 = Excel.readStringData(10, 10, "CreateWorker");
			act.click(getDriver(), cw.Caddress1());
			act.type(cw.Caddress1(), add1);

			String add2 = Excel.readStringData(10, 11, "CreateWorker");
			act.click(getDriver(), cw.Caddress2());
			act.type(cw.Caddress2(), add2);

			String add3 = Excel.readStringData(10, 12, "CreateWorker");
			act.click(getDriver(), cw.Cfname());
			act.type(cw.Caddress3(), add3);

			String pcode = Excel.readStringData(10, 13, "CreateWorker");
			act.click(getDriver(), cw.Cpcode());
			act.type(cw.Cpcode(), pcode);

			String brtext = Excel.readStringData(10, 14, "CreateWorker");
			act.click(getDriver(), cw.Cbranchid());
			act.selectByVisibleText(brtext, cw.Cbranchid());

			String division = Excel.readStringData(10, 15, "CreateWorker");
			act.click(getDriver(), cw.Cdivisionid());
			act.selectByVisibleText(division, cw.Cdivisionid());

			String emptype = Excel.readStringData(10, 16, "CreateWorker");
			act.click(getDriver(), cw.Cemptype());
			act.selectByValue(cw.Cemptype(), emptype);

			String slip = Excel.readStringData(10, 17, "CreateWorker");
			act.click(getDriver(), cw.Cpayslip());
			act.selectByValue(cw.Cpayslip(), slip);

			String status = Excel.readStringData(10, 18, "CreateWorker");
			act.click(getDriver(), cw.Cengstatus());
			act.selectByValue(cw.Cengstatus(), status);

			String ninmbr = Excel.readStringData(10, 19, "CreateWorker");
			act.click(getDriver(), cw.Cninmber());
			act.type(cw.Cninmber(), ninmbr);

			act.scrollByVisibilityOfElement(getDriver(), cw.Cnext());
			
			Log.info("Entered Worker Details and going to submit");
			act.click(getDriver(), cw.Cnext());
			act.explicitWait(getDriver(), bd.Blogo(), 10);
					
			String expected = "WORKER BANK DETAILS";
			String actual = w.ViewFunctionTitle();
			sa.assertTrue(actual.contains(expected));
					
			Log.info("Worker details saved and redirected to bank details page, assertion completed");
			Log.info("Enter Bank Details");
			
			String acctname = Excel.readStringData(5,2, "BankDetails");
			act.click(getDriver(), bd.Baccname());
			act.type(bd.Baccname(), acctname);

			String sortcode = Excel.readStringData(5,4, "BankDetails");
			act.click(getDriver(), bd.sortcode());
			act.type(bd.sortcode(), sortcode);

			act.click(getDriver(), bd.Bsave());
			
			String expected1 = "Account Number cannot be blank.";
			System.out.println(bd.accNumAlertMsg());
			String actual1 = bd.accNumAlertMsg();
			sa.assertEquals(actual1, expected1);
			Log.info("Bank Details Not saved as mandatory field are not filled and assertion done");
			//act.logOut();
			Log.endTestCase("Logged out of PayRoll App");

					
		}

}
