package com.payroll.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.payroll.BaseClass.BaseClass;

public class HomePage extends BaseClass
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); 	//using page factory
	}
	
	@FindBy(xpath="//div[@class='col-sm-6 page-title']//child::h1")
	WebElement homelogo;
	
	@FindBy(xpath="//a[@href='/payrollapp/worker/index']")
	WebElement workertab;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	WebElement profile;
	
	@FindBy(xpath="//a[@href='/payrollapp/site/logout']")
	WebElement logout;
	
	
	public WebElement Hlogo()
	{
		return homelogo;
	}
	public WebElement Hworker()
	{
		return workertab;
	}
	
	public WebElement Hprofile()
	{
		return profile;
	}
	public WebElement Hlogout()
	{
		return logout;
	}
	
	public String homeLogo()
	{
		String logo = Hlogo().getText();
		return logo;
	}
	
	public void logout()
	{
		Hprofile().click();
		Hlogout().click();
	}
	
	
}
