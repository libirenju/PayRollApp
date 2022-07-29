package com.payroll.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeductionPage 
{
	WebDriver driver;
	public DeductionPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); 	//using page factory
	}
	
	
	@FindBy(linkText = "Deduction")
	WebElement deductionTab;
	
	@FindBy(xpath="//a[@href='/payrollapp/deduction/create']")
	WebElement addDeductionBtn;
	
	@FindBy(xpath="//a[@href='/payrollapp/deduction/view?id=5686']")
	WebElement viewdeductiondetails;
	
	@FindBy(xpath="//a[@href='/payrollapp/deduction/update?id=5689']")
	WebElement updateDeductionDetails;
	
	public WebElement deductionTab()
	{
		return deductionTab;
	}
	public WebElement addDeductionBtn()
	{
		return addDeductionBtn;
	}
	public WebElement viewDeductionDetails()
	{
		return viewdeductiondetails;
	}
	public WebElement editDeductionDetails()
	{
		return updateDeductionDetails;
	}

}
