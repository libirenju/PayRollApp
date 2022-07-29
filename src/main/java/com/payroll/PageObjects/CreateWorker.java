package com.payroll.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateWorker
{
	WebDriver driver;
	public CreateWorker(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); 	//using page factory
	}
	
	@FindBy(xpath="//div[@class='col-sm-6 page-title']//child::h1']")
	WebElement Clogo;
	
	@FindBy(id="worker-title")
	WebElement Ctitle;
	
	@FindBy(id="worker-first_name")
	WebElement Cfname;
	
	@FindBy(name="Worker[last_name]")
	WebElement Clname;
	
	@FindBy(id="worker-known")
	WebElement Cknown;
	
	@FindBy(name="Worker[phone]")
	WebElement Cphone;
	
	@FindBy(id="worker-mobile")
	WebElement Cmobile;
		
	@FindBy(id="worker-email")
	WebElement Cemail;
	
	@FindBy(id="worker-gender")
	WebElement Cgender;
	
	@FindBy(name="Worker[middle_name]")
	WebElement Cmname;
	
	@FindBy(id="worker-dob")
	WebElement Cdob;
	
	@FindBy(name="Worker[address1]")
	WebElement Caddress1;
	
	@FindBy(id="worker-address2")
	WebElement Caddress2;
	
	@FindBy(name="Worker[address3]")
	WebElement Caddress3;
	
	@FindBy(id="worker-postcode")
	WebElement Cpcode;
	
	@FindBy(name="Worker[branch_id]")
	WebElement Cbranchid;
	
	@FindBy(id="worker-division_id")
	WebElement Cdivisionid;
	
	@FindBy(name="Worker[employment_type]")
	WebElement Cemptype;
	
	@FindBy(id="worker-payslip_method")
	WebElement Cpayslip;
	
	@FindBy(name="Worker[engage_status]")
	WebElement Cengstatus;
	
	@FindBy(id="worker-ni_number")
	WebElement Cninmber;
	
	@FindBy(name="Worker[country]")
	WebElement Ccountry;
	
	@FindBy(xpath="//button[text()='Next']")
	WebElement nextbtn;
	
	@FindBy(xpath="//td[text()='5']")
	WebElement date;
	
	@FindBy(xpath="//div[text()='Last Name cannot be blank.']")
	WebElement lnamealert;
	
			
		public WebElement Clogo()
		{
			return Clogo;
		}
		public WebElement Ctitle()
		{
			return Ctitle;
		}
		
		public WebElement Cfname()
		{
			return Cfname;
		}
		public WebElement Clname()
		{
			return Clname;
		}
		
		public WebElement Cknown()
		{
			return Cknown;
		}
		public WebElement Cphone()
		{
			return Cphone;
		}
		
		public WebElement Cmobile()
		{
			return Cmobile;
		}
		public WebElement Cemail()
		{
			return Cemail;
		}
		
		public WebElement Cgender()
		{
			return Cgender;
		}
		public WebElement Cmname()
		{
			return Cmname;
		}
		
		public WebElement Cdob()
		{
			return Cdob;
		}
		public WebElement Caddress1()
		{
			return Caddress1;
		}
		
		public WebElement Caddress2()
		{
			return Caddress2;
		}
		public WebElement Caddress3()
		{
			return Caddress3;
		}
		
		public WebElement Cpcode()
		{
			return Cpcode;
		}
		public WebElement Cbranchid()
		{
			return Cbranchid;
		}
		
		public WebElement Cdivisionid()
		{
			return Cdivisionid;
		}
		public WebElement Cemptype()
		{
			return Cemptype;
		}
		
		public WebElement Cpayslip()
		{
			return Cpayslip;
		}
		public WebElement Cengstatus()
		{
			return Cengstatus;
		}
		
		public WebElement Cninmber()
		{
			return Cninmber;
		}
		public WebElement Ccountry()
		{
			return Ccountry;
		}
		public WebElement Cnext()
		{
			return nextbtn;
		}
		public WebElement Cdate()
		{
			return date;
		}
	
		public WebElement Clnamealert()
		{
			return lnamealert;
		}
		
		public String lnameAlertMsg()
		{
			String alert = lnamealert.getText();
			return alert;
		}
		
}
