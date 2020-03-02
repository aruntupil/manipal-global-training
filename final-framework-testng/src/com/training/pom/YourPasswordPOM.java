package com.training.pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//import com.training.generics.GenericMethods;


public class YourPasswordPOM {

	private WebDriver driver; 
	
	public YourPasswordPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-password")
	private WebElement newPassword; 
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//*[@value='Continue']")
	private WebElement continueBtn;

	
	
	public void sendnewPassword(String newPassword) {
	
		this.newPassword.clear(); 
		this.newPassword.sendKeys(newPassword); 
	
	}
	
	public void sendconfirmPassword(String confirmPassword) {
		this.confirmPassword.clear(); 
		this.confirmPassword.sendKeys(confirmPassword); 
	}
	
	public Boolean clickContinueBtn() {
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
    	
 //   	GenericMethods objGeneric=new GenericMethods(driver);
    	
    	public void verifySuccess()	{
    		
    		try {
    		 String expMessage = "Success: Your password has been successfully updated.";
    		 String actMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
    		 Assert.assertEquals(actMessage, expMessage);
    		}
  		
    		catch (Exception ex){
    			System.out.println("Element not found");
    		}
    	    }   	
    	
}

