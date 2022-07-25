package com.payroll.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.payroll.BaseClass.BaseClass;

public class PasswordReset extends BaseClass
{
	WebDriver driver;
	public PasswordReset(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); 	//using page factory
	}
	
	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement email;
	
	@FindBy(xpath="//button[text()='Send']")
	WebElement sendbtn;
	
	@FindBy(xpath="//a[text()='Cancel']")
	WebElement cancelbtm;
	
	@FindBy(xpath="//div[@class='col-sm-4 form-area inner']//child::h1")
	WebElement passlogo;
	
	@FindBy(xpath="//input[@placeholder='Email']//following-sibling::p")
	WebElement invalidemail;
	
	public WebElement Passemail()
	{
		return email;
	}
	public WebElement Psend()
	{
		return sendbtn;
	}
	public WebElement Pcancel()
	{
		return cancelbtm;
	}
	public WebElement Passlogo()
	{
		return passlogo;
	}
	
	public WebElement invalidmail()
	{
		return invalidemail;
	}
	
	public String passLogo()
	{
		String pwdlogo=Passlogo().getText();
		return pwdlogo;
	}
	
}
