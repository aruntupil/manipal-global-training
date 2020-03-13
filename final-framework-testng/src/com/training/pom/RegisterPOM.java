package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
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
	
	@FindBy(xpath="//*[@class='checkbox']//input")
	private WebElement privacyPolicy; 
	
	@FindBy(xpath="//*[@type='submit']")
	private WebElement continueBtn; 
	
	@FindBy(xpath="//*[@class='buttons']//div/a[1]']")
	private WebElement registerBtn;



//	private WebDriver driver; 
	
//	@FindBy(linkText="Edit your account information")
//	private WebElement editLink;
	
	
	
	public void clickRegisterBtn() {
//		objGeneric.clickElement(loginBtn);
		
		this.registerBtn.click();
		    		
	}
	
	public void sendFirstName(String firstnamevalue) {
		this.firstname.clear();
		this.firstname.sendKeys(firstnamevalue);
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
		this.addr1.sendKeys(addr1); 
	}
	
	public void sendAddr2(String addr2 ) {
		this.addr2.clear(); 
		this.addr2.sendKeys(addr2); 
	}
	
	public void sendCity(String city) {
		this.city.clear(); 
		this.city.sendKeys(city); 
	}
	
	public void sendPostal(String postal) {
		this.postal.clear(); 
		this.postal.sendKeys(postal); 
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
     

        List<WebElement> list = driver.findElements(By.xpath("//*[@class='radio-inline']//input[@value='0']"));
      
        Boolean is_selected = list.get(0).isSelected();
      
        if (!is_selected == true) {
           // If the No radio button is selected by default then do nothing
        	
        	list.get(0).click();
           
        } else {
            // If the No radio button is not selected then, click the No radio button.
           System.out.println("Error");

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


	public void verifyRegSuccess()	{
		
	 String expMessage = "Congratulations! Your new account has been successfully created!";
	 String actMessage = driver.findElement(By.xpath("//div[@class='tb_text_wrap tb_sep']")).getText();
	 Assert.assertEquals(actMessage, expMessage);

    }
}
