package com.training.pom;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import com.training.generics.GenericMethods;


public class HomePagePOM {

	private WebDriver driver; 
	
	public HomePagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
/*	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn; 
	
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
		
*/
	
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


}
		
	

