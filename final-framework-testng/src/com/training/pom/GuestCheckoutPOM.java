package com.training.pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class GuestCheckoutPOM {
	

	private WebDriver driver; 
	
	public GuestCheckoutPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@id='input-payment-firstname']")
	private WebElement guestFirstname ; 
	
	@FindBy(xpath="//*[@id='input-payment-lastname']")
	private WebElement guestLastname ; 
	
	@FindBy(xpath="//*[@id='input-payment-email']")
	private WebElement guestEmail ; 
	
	@FindBy(xpath="//*[@id='input-payment-telephone']")
	private WebElement guestPhone ; 
	
	@FindBy(xpath="//*[@id='input-payment-address-1']")
	private WebElement guestAddrLine1 ; 
	
	@FindBy(xpath="//*[@id='input-payment-address-2']")
	private WebElement guestAddrLine2 ; 
	
	@FindBy(xpath="//*[@id='input-payment-city']")
	private WebElement guestCity ; 
	
	@FindBy(xpath="//*[@id='input-payment-country']")
	private WebElement guestCountry ; 
	
	@FindBy(xpath="//*[@id='input-payment-zone']")
	private WebElement guestState ; 
	
	@FindBy(xpath="//*[@id='input-payment-postcode']")
	private WebElement guestPostal ; 
	
	@FindBy(xpath="//input[@name='shipping_address']")
	private WebElement guestCheckSameDelAndShip ;
		
	@FindBy(xpath="//input[@id='button-guest']")
	private WebElement guestContBillDtlBtn; 

	@FindBy(xpath="//*[@id='collapse-shipping-method']/div/p[4]/textarea")
	private WebElement enterDelMthdComment;
	
	@FindBy(xpath="//*[@id='button-shipping-method']")
	private WebElement guestContDelMthdBtn;
	
	@FindBy(xpath="//*[@name='//*[@id='collapse-payment-method']/div/p[3]/textarea']")
	private WebElement enterPmntMthdComment;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement guestClickTnCPayment;
		
	@FindBy(xpath="//*[@id='button-payment-method']")
	private WebElement continuePayMthdBtn;
	
	@FindBy(xpath="//*[@id='button-confirm']")
	private WebElement guestConfirmBtn;


	
	public void guestEnterFirstname(String firstname)
	{
		try {
			this.guestFirstname.clear();
			this.guestFirstname.sendKeys(firstname);
		}
		catch (Exception e){
			System.out.println("Error on entering First name");
		}
		
	}
	
	public void guestEnterLastname(String lastname)
	{
		try {
			this.guestLastname.clear();
			this.guestLastname.sendKeys(lastname);
		}
		catch (Exception e){
			System.out.println("Error on entering Last name");
		}
		
	}
	
	public void guestEnterEmail(String email)
	{
		try {
			this.guestEmail.clear();
			this.guestEmail.sendKeys(email);
		}
		catch (Exception e){
			System.out.println("Error on entering Email");
		}
		
	}
	
	public void guestEnterPhone(String phone)
	{
		try {
			this.guestPhone.clear();
			this.guestPhone.sendKeys(phone);
		}
		catch (Exception e){
			System.out.println("Error on entering Phone");
		}
		
	}
	
	
	public void guestAddr1(String addr1)
	{
		try {
			this.guestAddrLine1.clear();
			this.guestAddrLine1.sendKeys(addr1);
		}
		catch (Exception e){
			System.out.println("Error on entering Addr Line1");
		}
		
	}
	
	
	public void guestAddr2(String addr2)
	{
		try {
			this.guestAddrLine2.clear();
			this.guestAddrLine2.sendKeys(addr2);
		}
		catch (Exception e){
			System.out.println("Error on entering Addr Line2");
		}
		
	}
	
	public void guestCity(String city)
	{
		try {
			this.guestCity.clear();
			this.guestCity.sendKeys(city);
		}
		catch (Exception e){
			System.out.println("Error on entering Addr Line2");
		}
		
	}
	
	public void guestPostal(String postal)
	{
		try {
			this.guestPostal.clear();
			this.guestPostal.sendKeys(postal);
		}
		catch (Exception e){
			System.out.println("Error on entering Postal");
		}
		
	}
	
	public void guestCountry(String country)
	{
		try {
			Select drpCountry = new Select(driver.findElement(By.name("country_id")));
			drpCountry.selectByVisibleText(country);
		}
		catch (Exception e){
			System.out.println("Error on entering country");
		}
		
	}
	
	public void guestState(String state)
	{
		try {
			Select drpCountry = new Select(driver.findElement(By.name("zone_id")));
			drpCountry.selectByVisibleText(state);
		}
		catch (Exception e){
			System.out.println("Error on entering State");
		}
		
	}

	
	public void verifySameDelandBillAddr()
	{
		boolean delnShipaddress = this.guestCheckSameDelAndShip.isSelected();
		
		if (delnShipaddress == true)
		{
			System.out.println("Already selected");
		}
			else {
				this.guestCheckSameDelAndShip.click();
			}
			}
	
	public void clickBillDtlCtn()
	{
		try {
			
			this.guestContBillDtlBtn.click();
		}
		catch (Exception e){
			System.out.println("Error on click continue in Billing details");
		}
	}
		
	public void enterDelMethodComment(String comment)
	{
		try {
			this.enterDelMthdComment.clear();
			this.enterDelMthdComment.sendKeys(comment);
		}
		catch (Exception e){
			System.out.println("Error on entering Delivery Method Comments");
		}
		
	}
	

	public void clickDelMethodCtn()
	{
		try {
			
			this.guestContDelMthdBtn.click();
		}
		catch (Exception e){
			System.out.println("Error on click continue in Delivery Methods");
		}
	}
			


	public void enterPaymentMethodComment(String comment)
	{
		try {
			this.enterPmntMthdComment.clear();
			this.enterPmntMthdComment.sendKeys(comment);
		}
		catch (Exception e){
			System.out.println("Error on entering Payment Method Comments");
		}
	}
	
	public void clickTnC()
	{
	try {
			
			this.guestClickTnCPayment.click();
		}
		catch (Exception e){System.out.println("Error on click product");
		}
	}
	
	public void clickPaymentMethodCtn()
	{
		try {
			
			this.continuePayMthdBtn.click();
		}
		catch (Exception e){
			System.out.println("Error on click continue in Delivery Methods");
		}
	}

	public void clickConfirmOrder() {
try {
			
			this.guestConfirmBtn.click();
		}
		catch (Exception e){
			System.out.println("Error on click confirm");
		}
	}
	
	public void verifyOrderConfirmSuccess()	{
		
		 String expMessage = "Your order has been successfully processed!";
		 String actMessage = driver.findElement(By.xpath("//div[@class='tb_text_wrap tb_sep']//p[1]")).getText();
		 Assert.assertEquals(actMessage, expMessage);

	    }

}
