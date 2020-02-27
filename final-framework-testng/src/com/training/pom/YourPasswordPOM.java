package com.training.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.training.generics.GenericMethods;


public class YourPasswordPOM {
	
	public YourPasswordPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-password")
	private WebElement newPassword; 
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//*[@value='Continue']")
	private WebElement continueBtn;

	private WebDriver driver; 
	
	public void sendnewPassword(String newPassword) {
		this.newPassword.clear(); 
		this.newPassword.sendKeys(newPassword); 
	}
	
	public void sendconfirmPassword(String confirmPassword) {
		this.confirmPassword.clear(); 
		this.confirmPassword.sendKeys(confirmPassword); 
	}
	
	public void clickContinueBtn() {
//		objGeneric.clickElement(loginBtn);
    	this.continueBtn.click();
	}
    	
    	GenericMethods objGeneric=new GenericMethods(driver);


}

