package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generics.GenericMethods;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@id='button-account']")
	private WebElement continueBtn;

	
	@FindBy(xpath="//*[@value='guest']")
	private WebElement clickGuestCheckoutRadio;

	
    GenericMethods objGeneric=new GenericMethods(driver);
			
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		objGeneric.clickElement(loginBtn);
//   	this.clickLoginBtn();
				
	}
	
	public void clickContinueBtn() {
//		objGeneric.clickElement(loginBtn);
		this.continueBtn.click();
				
	}
	
	public void clickGuestCheckoutRadio() {

		this.clickGuestCheckoutRadio.click();
				
	}
	
}
