package com.payroll.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDeductionPage 
{
	WebDriver driver;
	public AddDeductionPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); 
	}
	
	
	@FindBy(xpath = "//input[@class='select2-search__field']")
	WebElement workerdrpdwntext;
	
	@FindBy(id = "select2-deduction-worker_id-container")
	WebElement selectworkerdrpdwn;
	
	@FindBy(id = "select2-deduction-worker_id-result-753j-1145")
	WebElement selectworkerdrpdwnvalue;
		
	@FindBy(id="deduction-type")
	WebElement deductiontype;
	
	@FindBy(name="Deduction[amount]")
	WebElement deductamt;
	
	@FindBy(id="deduction-effective_from")
	WebElement deductdate;
	
	@FindBy(xpath="//input[@id='deduction-amount']//following::p[text()='Amount cannot be blank.']")
	WebElement deductamtalert;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButton;
	
	public WebElement workerDrpdwnText()
	{
		return workerdrpdwntext;
	}
	
	public WebElement selectworkerDrpdwn()
	{
		return selectworkerdrpdwn;
	}
	
	public WebElement selectWorkerDrpdwnValue()
	{
		return selectworkerdrpdwnvalue;
	}
	
	public WebElement addDeductionType()
	{
		return deductiontype;
	}
	public WebElement addDeductionAmt()
	{
		return deductamt;
	}
	public WebElement addDeductionStartDate()
	{
		return deductdate;
	}
	public WebElement alertDeductionAmt()
	{
		return deductamtalert;
	}
	public WebElement saveDeductionBtn()
	{
		return saveButton;
	}
	
	public String alertForDeductionAmt()
	{
		String dateAlert = deductamtalert.getText();
		return dateAlert;
	}
	
}
