package com.payroll.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.payroll.BaseClass.BaseClass;

public class Workers extends BaseClass
{
	WebDriver driver;
	public Workers(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); 	//using page factory
	}
	
	@FindBy(xpath="//div[@class='col-sm-6 page-title']//child::h1")
	WebElement worklogo;
	
	@FindBy(xpath="//a[@href='/payrollapp/worker/create']")
	WebElement createworker;
	
	@FindBy(xpath = "//button[text()='Search']")
	WebElement search;
	
	@FindBy(xpath="//button[text()='Reset']")
	WebElement reset;
	
	@FindBy(xpath="//span[@class='glyphicon glyphicon-eye-open']//parent::a[@href='/payrollapp/worker/view?id=2']")
	WebElement view;
	
	@FindBy(xpath="//a[@href='/payrollapp/worker/update?id=3']")
	WebElement edit;
	
	@FindBy(xpath="//a[@href='/payrollapp/worker/delete?id=1127']")
	WebElement delete;
	
	@FindBy(xpath="")
	WebElement delalert;
	
	@FindBy(linkText="Home")
	WebElement Whome;
	
	@FindBy(xpath="//a[@href='/payrollapp/worker/index?page=3']")
	WebElement pagination;
	
	@FindBy(name="WorkerSearch[first_name]")
	WebElement Fname;
	
	@FindBy(id="workersearch-last_name")
	WebElement Lname;
	
	@FindBy(name="WorkerSearch[postcode]")
	WebElement Pcode;
	
	@FindBy(xpath="//a[@data-sort='employment_type']")
	WebElement emptypesort;
	
	@FindBy(xpath="(//td[text()='Aby']) [1]")
	WebElement worksearchvalue;
	
	public WebElement Wlogo()
	{
		return worklogo;
	}
	public WebElement createworker()
	{
		return createworker;
	}
	public WebElement Wsearch()
	{
		return search;
	}
	public WebElement Wreset()
	{
		return reset;
	}
	public WebElement Wview()
	{
		return view;
	}
	public WebElement Wedit()
	{
		return edit;
	}
	public WebElement Wdelete()
	{
		return delete;
	}
	public WebElement Delalert()
	{
		return delalert;
	}
	public WebElement Wfname()
	{
		return Fname;
	}
	public WebElement Wlname()
	{
		return Lname;
	}
	public WebElement Wheadsort()
	{
		return emptypesort;
	}
	public WebElement Whome()
	{
		return Whome;
	}
	public WebElement pagination()
	{
		return pagination;
	}
	
	public String ViewFunctionTitle()
	{
		String titletext=worklogo.getText();
		return titletext;
	}
	
	public WebElement workerSearchValue()
	{
		return worksearchvalue;
	} 
	
	public String searchValueText()
	{
		String value = worksearchvalue.getText();
		return value;
	}
	
	
}
