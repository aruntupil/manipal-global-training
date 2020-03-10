package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.training.generics.GenericMethods;


public class AccountInfoPOM {
	

private  WebDriver driver;

	public AccountInfoPOM(WebDriver driver) {
		this.driver=driver;
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

//	private WebDriver driver; 

	@FindBy(xpath="//*[@id='menu_url_F5fG9']")
	private WebElement homeBtn;
	
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
	
	public boolean clickContinueBtn() {
//		objGeneric.clickElement(loginBtn);
		
		try
		{
			this.continueBtn.click();
			return true;
		}
		
		catch(Exception ex){
			return false;
		}
    		
	}
	
	public boolean clickHomeBtn() {
//		objGeneric.clickElement(loginBtn);
		
		try
		{
			this.homeBtn.click();
			return true;
		}
		
		catch(Exception ex){
			return false;
		}
    		
	}
	
	GenericMethods objGeneric=new GenericMethods(driver);


	public void verifySuccess()	{
		
	 String expMessage = "Success: Your account has been successfully updated.";
	 String actMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
	 Assert.assertEquals(actMessage, expMessage);

    }

}
