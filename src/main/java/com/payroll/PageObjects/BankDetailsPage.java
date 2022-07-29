package com.payroll.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankDetailsPage 
{
	WebDriver driver;
	public BankDetailsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); 	//using page factory
	}
	
	@FindBy(id="worker-exclude_wtr")
	WebElement Bcheckbx;
	
	@FindBy(xpath="//div[@class='col-sm-6 page-title']//child::h1")
	WebElement Blogo;
	
	@FindBy(id="worker-payment_method")
	WebElement paymethod;
	
	@FindBy(name="Worker[ac_type]")
	WebElement acctype;
	
	@FindBy(id="worker-ac_name")
	WebElement accname;
	
	@FindBy(id="worker-ac_no")
	WebElement accnmber;
	
	@FindBy(name="Worker[sort_code]")
	WebElement sortcode;
	
	@FindBy(id="worker-start_date")
	WebElement Bstrtdate;
	
	@FindBy(id="worker-roll_no")
	WebElement rollnmber;
	
	@FindBy(name="Worker[bank_name]")
	WebElement bankname;
	
	@FindBy(id="worker-bank_address")
	WebElement bankadd;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement savebtn;
	
	@FindBy(xpath="//div[text()='Account Number cannot be blank.']")
	WebElement accnmbralert;
	
	public WebElement Bcheckbx()
	{
		return Bcheckbx;
	}
	public WebElement Blogo()
	{
		return Blogo;
	}
	public WebElement Bpaymethod()
	{
		return paymethod;
	}
	public WebElement Bacctype()
	{
		return acctype;
	}
	public WebElement Baccname()
	{
		return accname;
	}
	public WebElement Bacctnmbr()
	{
		return accnmber;
	}
	public WebElement sortcode()
	{
		return sortcode;
	}
	public WebElement Bdate()
	{
		return Bstrtdate;
	}
	public WebElement Brollnmber()
	{
		return rollnmber;
	}

	public WebElement Bankname()
	{
		return bankname;
	}
	
	public WebElement Bankadd()
	{
		return bankadd;
	}
	
	public WebElement Bsave()
	{
		return savebtn;
	}
	
	public String accNumAlertMsg()
	{
		String alert = accnmbralert.getText();
		return alert;
	}

}
