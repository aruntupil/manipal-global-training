package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductPagePOM {
	

	private WebDriver driver; 
	
	public ProductPagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
/*	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	

    GenericMethods objGeneric=new GenericMethods(driver);			
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
*/	
	
	@FindBy(xpath="//*[@id='button-confirm']")
	private WebElement confirmBtn; 

	@FindBy(xpath="//*[@id='button-cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//a[@href='http://retailm1.upskills.in/checkout/cart']")
	private WebElement clickOnCartBtn;
	
	
	
	
	public void clickConfirmBtn()
		{

		this.confirmBtn.click();
	}

	
	public void clickMenu()
	
	{
		try 
		{
			
		Actions menuAction = new Actions(driver);
		WebElement loginMenu = driver.findElement(By.xpath("//*[@id='Menu_Wmt3OMY3']//following::i[2]"));
		menuAction.moveToElement(loginMenu).build().perform();
		menuAction.moveToElement(driver.findElement(By.xpath("//*[@id='Menu_Wmt3OMY3']//following::li[2]"))).click().build().perform();
	
		}

        catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void clickProduct(String product)
	{
		try {
			
			driver.findElement(By.linkText(product)).click();
		}
		catch (Exception e){System.out.println("Error on click product");
		}
	}

	
	public void clickAddtoCart ()
	{
		
		try {
			
			this.addToCartBtn.click();
		}
		catch (Exception e){System.out.println("Error on clickin Add to cart");
		}
		
	}
	
	public void acceptPopUp ()
	{
		try {
			
			driver.switchTo().alert().dismiss();
		}
		catch (Exception e){
			System.out.println("Error on accepting alert");
		}
	}
	
	public void clickOnCart ()
	{
		try {
			
//			this.clickOnCartBtn.click();
			Actions menuAction = new Actions(driver);
			WebElement cartMenu = driver.findElement(By.xpath("//*[@class='heading']/a"));
			menuAction.moveToElement(cartMenu).build().perform();
			menuAction.moveToElement(driver.findElement(By.linkText("View Cart"))).click().build().perform();
		}
		catch (Exception e){
			System.out.println("Error on clicking on cart");
		}
	}
	
	
	public void verifyCartQty ()
	{
		try {
			
			Actions menuAction = new Actions(driver);
			WebElement cartMenu = driver.findElement(By.xpath("//*[@class='heading']/a"));
			menuAction.moveToElement(cartMenu).build().perform();
			String expMessage = "Your shopping cart is empty!";
			String actMessage = driver.findElement(By.xpath("//div[@class='empty']")).getText();
			Assert.assertEquals(actMessage, expMessage);
//			menuAction.moveToElement(driver.findElement(By.linkText("View Cart"))).click().build().perform();
		}
		catch (Exception e){
			System.out.println("Error on clicking on cart");
		}
	}

}
