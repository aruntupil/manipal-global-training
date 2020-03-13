package com.training.pom;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartActionsPOM {
	
	private WebDriver driver; 
	
	public CartActionsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='button-payment-address']")
	private WebElement continueBillDtlBtn; 

	@FindBy(xpath="//*[@id='button-shipping-address']")
	private WebElement continueDelDtlBtn;
	
	@FindBy(xpath="//textarea[@name='comment']")
	private WebElement enterDelMthdComment;
	
	@FindBy(id="button-shipping-method")
	private WebElement continueDelMthdBtn;
	
	
	@FindBy(xpath="//div[@id='collapse-payment-method']/div/p/textarea']")
	private WebElement enterPmntMthdComment;
	
	@FindBy(xpath="//*[@type='checkbox']")
	private WebElement clickTnCPayment;
	
	
	@FindBy(id="button-payment-method")
	private WebElement continuePayMthdBtn;
	
	@FindBy(xpath="//*[@id='button-confirm']")
	private WebElement confirmBtn;



	public void clickBillDtlCtn()
	{
		try {
			
			this.continueBillDtlBtn.click();
		}
		catch (Exception e){
			System.out.println("Error on click continue in Billing details");
		}
	}
	
	public void clickDelDtlCtn()
	{
		try {
			
			this.continueDelDtlBtn.click();
		}
		catch (Exception e){
			System.out.println("Error on click continue in Delivery details");
		}
	}
	

	public void enterDelMethodComment(String dcomment)
	{
		try {
			this.enterDelMthdComment.clear();
			Thread.sleep(5000);
//			JavascriptExecutor js = (JavascriptExecutor)driver;
//			WebElement obj = driver.findElement(By.xpath("//textarea[@name='comment']"));
//			js.executeScript("argument[0].value = (dcomment)",obj);
			this.enterDelMthdComment.sendKeys(dcomment);
			driver.close();
			//*[@id="collapse-shipping-method"]/div/p[4]/textarea
		}
		catch (Exception e){
			System.out.println(e);
		}
		
	}
	
	public void clickDelMethodCtn()
	{
		try {
			
			this.continueDelMthdBtn.click();
		}
		catch (Exception e){
			System.out.println("Error on click continue in Delivery Methods");
		}
	}
			


	public void enterPaymentMethodComment(String pcomment)
	{
		try {
			this.enterPmntMthdComment.clear();
			this.enterPmntMthdComment.sendKeys(pcomment);
		}
		catch (Exception e){
			System.out.println("Error on entering Payment Method Comments");
		}
	}
	
	public void clickPaymentMethodContinue()
	{
		try {
			this.continuePayMthdBtn.click();
		}
		catch (Exception e){
			System.out.println("Error on clicking Payment Method Continue");
		}
	}	
	
	public void clickTnC()
	{
	try {
			
			this.clickTnCPayment.click();
		}
		catch (Exception e){System.out.println("Error on click product");
		}
	}
	
	public void clickConfirmOrder() {
try {
			
			this.confirmBtn.click();
		}
		catch (Exception e){
			System.out.println("Error on click confirm");
		}
	}
	
}
