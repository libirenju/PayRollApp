package com.payroll.PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.payroll.Actions.Action;
import com.payroll.BaseClass.BaseClass;
import com.payroll.Utilities.Excel;

public class LoginPage extends BaseClass
{
	WebDriver driver;
	Action act=new Action();
	static Excel ex = new Excel();
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); 	//using page factory
	}
	
	@FindBy(id="loginform-username")
	WebElement usernme;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement passwrd;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement loginbutton;
	
	@FindBy(linkText="reset it")
	WebElement resetit;
	
	@FindBy(id="loginform-rememberme")
	WebElement rememberme;
	
	@FindBy(xpath="//div[@class='col-sm-4 form-area inner']//child::h1")
	WebElement loginlogo;
	
	@FindBy(xpath="//input[@placeholder='Password']//following-sibling::p")
	WebElement invalidalert;
	
	@FindBy(xpath="//input[@placeholder='Username']//following-sibling::p")
	WebElement useralert;
	
	@FindBy(xpath="//input[@placeholder='Password']//following-sibling::p")
	WebElement passalert;
	
	public WebElement username()
	{
		return usernme;
	}
	public WebElement password()
	{
		return passwrd;
	}
	public WebElement loginbutton()
	{
		return loginbutton;
	}
	public WebElement resetit()
	{
		return resetit;
	}
	public WebElement rememberme()
	{
		return rememberme;
	}
	public WebElement loginlogo()
	{
		return loginlogo;
	}
	
	public WebElement alertmsg()
	{
		return invalidalert;
	}
	
	public WebElement ualert()
	{
		return useralert;
	}
	public WebElement palert()
	{
		return passalert;
	}
	
	public void login(String username, String password)
	{
		act.type(usernme,username);
		act.type(passwrd,password);
		act.click(driver, loginbutton);
	}
	
	public String loginLogo()
	{
		String logo = loginlogo().getText();
		return logo;
	}
	
	public boolean checkbox()
	{
		boolean value = act.isEnabled(driver,rememberme());
		return value;
	}
	
	public String alertMsg()
	{
		String alert = alertmsg().getText();
		return alert;
	}
	
	public String userAlertMsg()
	{
		String alert = ualert().getText();
		return alert;
	}
	
	public String passAlertMsg()
	{
		String alert = palert().getText();
		return alert;
	}
}
