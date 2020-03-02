package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;
import com.training.generics.GenericMethods;


public class RegisterPOM {

private  WebDriver driver;

	public RegisterPOM(WebDriver driver) {
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
	
	@FindBy(id="input-address-1")
	private WebElement addr1;
	
	@FindBy(id="input-address-2")
	private WebElement addr2;
	
	@FindBy(id="input-city")
	private WebElement city;
	
	@FindBy(id="input-postcode")
	private WebElement postal;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPwd;
	
	@FindBy(xpath="//*[@type='checkbox']")
	private WebElement privacyPolicy; 
	
	@FindBy(xpath="//*[@type='submit']")
	private WebElement continueBtn; 
	
	@FindBy(xpath="//div[@class='pull-right']")
	private WebElement registerBtn;



//	private WebDriver driver; 
	
//	@FindBy(linkText="Edit your account information")
//	private WebElement editLink;
	
	
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
	
	public void sendAddr1(String addr1) {
		this.addr1.clear(); 
		this.addr1.sendKeys(); 
	}
	
	public void sendAddr2(String addr2 ) {
		this.addr2.clear(); 
		this.addr2.sendKeys(); 
	}
	
	public void sendCity(String city) {
		this.city.clear(); 
		this.city.sendKeys(); 
	}
	
	public void sendPostal(String postal) {
		this.postal.clear(); 
		this.postal.sendKeys(); 
	}
	
	
	public void selectCountry(String country){
		
		Select drpCountry = new Select(driver.findElement(By.name("country_id")));
		drpCountry.selectByVisibleText(country);
		
	}
	
	public void selectState(String state){
		
		Select drpCountry = new Select(driver.findElement(By.name("zone_id")));
		drpCountry.selectByVisibleText(state);
	}
	
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void sendConfirmPwd(String confirmPwd) {
		this.confirmPwd.clear();
		this.confirmPwd.sendKeys(confirmPwd);
	}
	
    public void selectNewsltr(){
     

        List<WebElement> list = driver.findElements(By.name("newsletter"));
      
        Boolean is_selected = list.get(0).isSelected();
      
        if (is_selected == true) {
           // If the No radio button is selected by default then do nothing
        	
           System.out.println("No is selected");
           
        } else {
            // If the No radio button is not selected then, click the No radio button.
           list.get(0).click();

        }
    }
	
	public void selectPolicy(){
		
		this.privacyPolicy.click();
		
	}
	
	public void clickLoginBtn(String continueBtn) {
//		objGeneric.clickElement(loginBtn);
		this.continueBtn.click();
	}
	
	GenericMethods objGeneric=new GenericMethods(driver);


	public void verifySuccess()	{
		
	 String expMessage = "Success: Your account has been successfully updated.";
	 String actMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
	 Assert.assertEquals(actMessage, expMessage);

    }
}