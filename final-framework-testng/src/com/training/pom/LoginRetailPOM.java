package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generics.GenericMethods;

public class LoginRetailPOM {

	public WebDriver driver; 
	
	public LoginRetailPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement email; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@value='Login']")
	private WebElement loginBtn; 
	
	@FindBy(linkText="Edit your account information")
	private WebElement editLink;
	
	@FindBy(linkText="Change your password")
	private WebElement changePassword;
	
	@FindBy(xpath="//div[@class='pull-right']")
	private WebElement registerBtn;
	
    GenericMethods objGeneric=new GenericMethods(driver);

	public boolean clickRegisterBtn() {
//		objGeneric.clickElement(loginBtn);
		
		try
		{
			this.registerBtn.click();
			return true;
		}
		
		catch(Exception ex){
			return false;
		}
    		
	}
		
	public void sendUserName(String userName) {
		this.email.clear();
		this.email.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		objGeneric.clickElement(loginBtn);
//   	this.clickLoginBtn();	
	}
	
	public void clickEditAccount()
	{
			this.editLink.click();
	}

	public void updateAccountInfo()
	{
		
	}

	public void clickChangePassword() {
		this.changePassword.click();
		
	}
	
	}
