package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generics.GenericMethods;


public class AccountInfoPOM {
	
	public AccountInfoPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstname; 
	
	@FindBy(id="input-lastname")
	private WebElement lastname;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-telephone")
	private WebElement telephone;	
	
	@FindBy(xpath="//*[@value='Continue']")
	private WebElement continueBtn;

	private WebDriver driver; 
	
//	@FindBy(linkText="Edit your account information")
//	private WebElement editLink;
	
	
	public void sendFirstName(String firstname) {
		this.firstname.clear();
		this.firstname.sendKeys(firstname);
	}
	
	public void sendLastname(String lastname) {
		this.lastname.clear(); 
		this.lastname.sendKeys(lastname); 
	}
	
	public void sendEmail(String email) {
		this.email.clear(); 
		this.email.sendKeys(email); 
	}
	
	public void sendTelephone(String telephone) {
		this.telephone.clear(); 
		this.telephone.sendKeys(telephone); 
	}
	
	public void clickContinueBtn() {
//		objGeneric.clickElement(loginBtn);
    	this.continueBtn.click();	
	}
	
	GenericMethods objGeneric=new GenericMethods(driver);
	
/*	public boolean verifySuccess()	
	{
		boolean result;
		result = objGeneric.isElementFound(""//*[@id="System_nyHsmShk"]/div","xpath");
		return result;
	}
*/
}
