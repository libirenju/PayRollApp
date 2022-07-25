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

public class WorkerTest extends BaseClass
{
	LoginPage lp;	Action act; 	HomePage hp; 	BankDetailsPage bd;
	Excel ex; Workers w; CreateWorker cw; String password; String username;
	
	@BeforeMethod
	public void start() throws IOException
	{
		launchApp();
		
		act = new Action(); 	hp = new  HomePage(driver); 	lp = new LoginPage(driver);
		ex = new Excel();		w = new Workers(driver);  		cw = new CreateWorker(driver);
		bd = new BankDetailsPage(driver);
		
		username=ex.readStringData(1,0,"Login");
		password=ex.readStringData(1,1,"Login");
			
	}

	
	@Test(priority=1)
	public void Home1()
	{
		
		lp.login(username,password);
		act.explicitWait(driver, hp.Hlogo(), 10);
		String expected = "Workers";
		String actual =	hp.Hworker().getText();
		assertEquals(actual, expected);
		
	}
	
	@Test(priority=2)
	public void Home2()
	{
		lp.login(username,password);
		act.click(driver, hp.Hworker());
		act.explicitWait(driver, w.Wlogo(), 10);
		String expected = "WORKERS";
		String actual =	w.Wlogo().getText();
		assertEquals(actual, expected);
	}
	
	@Test(priority=3)
	public void Worker() throws IOException, InterruptedException
	{
		lp.login(username,password);
		act.click(driver, hp.Hworker());
		act.click(driver, w.createworker());
		act.explicitWait(driver, w.Wlogo(), 10);
		String expected = "CREATE WORKER";
		String actual =	w.Wlogo().getText();
		assertEquals(actual, expected);
	
	}
	
	@Test(priority=4)
	public void Worker1() throws IOException, InterruptedException
	{		
		lp.login(username, password);
		act.click(driver, hp.Hworker());
		act.click(driver, w.createworker());
				
		String value = "Mr";
		act.click(driver, cw.Ctitle());
		act.selectByValue(cw.Ctitle(), value); 
		// Thread.sleep(1000); 
		
		String fname =	ex.readStringData(1, 0, "CreateWorker");
		act.click(driver, cw.Cfname());
		act.type(cw.Cfname(), fname);

		String lname = ex.readStringData(1, 1, "CreateWorker");
		act.click(driver, cw.Clname());
		act.type(cw.Clname(), lname);

		String known = ex.readStringData(1, 2, "CreateWorker");
		act.click(driver, cw.Cknown());
		act.type(cw.Cknown(), known);

		// Thread.sleep(3000); 
		String phone=ex.readStringData(1,3,"CreateWorker");
		act.click(driver, cw.Cphone());
		act.type(cw.Cphone(), phone);

		String mobile = ex.readStringData(1, 4, "CreateWorker");
		act.click(driver, cw.Cmobile());
		act.type(cw.Cmobile(), mobile);

		// Thread.sleep(3000); 
		act.scrollByValue(driver); 
		String email = 	ex.readStringData(1, 5, "CreateWorker");
		act.click(driver, cw.Cemail());
		act.type(cw.Cemail(), email);

		Thread.sleep(1000);

		// String gvalue="Male"; 
		//cw.Cgender().click();
		//act.selectByValue(cw.Cgender(), gvalue);

		String mname = ex.readStringData(1, 6, "CreateWorker");
		act.click(driver, cw.Cmname());
		act.type(cw.Cmname(), mname);

		cw.Cdob().click();
		cw.Cdate().click();

		String add1 = ex.readStringData(1, 7, "CreateWorker");
		act.click(driver, cw.Caddress1());
		act.type(cw.Caddress1(), add1);

		String add2 = ex.readStringData(1, 8, "CreateWorker");
		act.click(driver, cw.Caddress2());
		act.type(cw.Caddress2(), add2);

		String add3 = ex.readStringData(1, 9, "CreateWorker");
		act.click(driver, cw.Cfname());
		act.type(cw.Caddress3(), add3);

		String pcode = ex.readStringData(1, 10, "CreateWorker");
		act.click(driver, cw.Cpcode());
		act.type(cw.Cpcode(), pcode);

		String brtext = "Alpha_new";
		act.click(driver, cw.Cbranchid());
		act.selectByVisibleText(brtext, cw.Cbranchid());

		String division = "NewAlpha";
		act.click(driver, cw.Cdivisionid());
		act.selectByVisibleText(division, cw.Cdivisionid());

		String emptype = "paye";
		act.click(driver, cw.Cemptype());
		act.selectByValue(cw.Cemptype(), emptype);

		String slip = "electronic";
		act.click(driver, cw.Cpayslip());
		act.selectByValue(cw.Cpayslip(), slip);

		String status = "partnership";
		act.click(driver, cw.Cengstatus());
		act.selectByValue(cw.Cengstatus(), status);

		String ninmbr = ex.readStringData(1, 11, "CreateWorker");
		act.click(driver, cw.Cninmber());
		act.type(cw.Cninmber(), ninmbr);

		String country = ex.readStringData(1, 12, "CreateWorker");
		act.click(driver, cw.Ccountry());
		act.type(cw.Ccountry(), country);

		Thread.sleep(1000);

		act.scrollByVisibilityOfElement(driver, cw.Cnext());
		Thread.sleep(2000);
		
		act.click(driver, cw.Cnext());
		act.explicitWait(driver, bd.Blogo(), 10);
		Thread.sleep(2000);
		
		String expected = "WORKER BANK DETAILS";
		String actual = bd.Blogo().getText();
		assertTrue(actual.contains(expected));

		String acctname = ex.readStringData(1,0, "BankDetails");
		act.click(driver, bd.Baccname());
		act.type(bd.Baccname(), acctname);

		String acctnmbr = ex.readStringData(1,1, "BankDetails");
		act.click(driver, bd.Bacctnmbr());
		act.type(bd.Bacctnmbr(), acctnmbr);

		String sortcode = ex.readStringData(1,3, "BankDetails");
		act.click(driver, bd.sortcode());
		act.type(bd.sortcode(), sortcode);

		String rollno = ex.readStringData(1,4, "BankDetails");
		act.click(driver, bd.Brollnmber());
		act.type(bd.Brollnmber(), rollno);

		String bankname = ex.readStringData(1,5, "BankDetails");
		act.click(driver, bd.Bankname());
		act.type(bd.Bankname(), bankname);

		String bankadd = ex.readStringData(1,6, "BankDetails");
		act.click(driver, bd.Bankadd());
		act.type(bd.Bankadd(), bankadd);

		act.click(driver, bd.Bsave());

		String actual1 = bd.Blogo().getText();
		assertTrue(actual1.contains(fname));
		 

	}
	
	@Test(priority=5)
	public void Worker2() throws InterruptedException
	{
		lp.login(username,password);
		act.scrollByVisibilityOfElement(driver, cw.Cnext());
		Thread.sleep(2000);
		act.click(driver, cw.Cnext());
		act.explicitWait(driver, bd.Blogo(), 10);
		Thread.sleep(2000);
		String expected = "WORKER BANK DETAILS";
		String actual =	bd.Blogo().getText();
		 
	}
	
	@Test(priority=6)
	public void Worker3() throws InterruptedException, IOException
	{
		String acctname=ex.readStringData(1,11,"BankDetails");
		act.click(driver, bd.Baccname());
		act.type(bd.Baccname(), acctname);
		
		String acctnmbr=ex.readStringData(1,11,"BankDetails");
		act.click(driver, bd.Bacctnmbr());
		act.type(bd.Bacctnmbr(), acctnmbr );
		
		String sortcode=ex.readStringData(1,11,"BankDetails");
		act.click(driver, bd.sortcode());
		act.type(bd.sortcode(), sortcode);
		
		String rollno=ex.readStringData(1,11,"BankDetails");
		act.click(driver, bd.Brollnmber());
		act.type(bd.Brollnmber(), rollno);
		
		String bankname=ex.readStringData(1,11,"BankDetails");
		act.click(driver, bd.Bankname());
		act.type(bd.Bankname(), bankname);
		
		String bankadd=ex.readStringData(1,11,"BankDetails");
		act.click(driver, bd.Bankadd());
		act.type(bd.Bankadd(), bankadd);
		
		act.click(driver, bd.Bsave());
		
		
	}
	
	
	
		
	@AfterMethod
	public void close()
	{
		hp.logout();
		driver.quit();
	}
	
}
