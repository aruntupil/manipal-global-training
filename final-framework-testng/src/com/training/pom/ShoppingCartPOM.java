package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPOM {
	

	private WebDriver driver; 
	
	public ShoppingCartPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='button-confirm']")
	private WebElement confirmBtn; 
	

	public void verifyProductName()
	{
		try {
			
			driver.findElement(By.xpath("//*[@class='dropdown]/a")).click();
		}
		catch (Exception e){
			System.out.println("Error on product verification in cart");
		}
	}
	
	public void clickCheckout()
	{
	try {
			
			driver.findElement(By.linkText("Checkout")).click();
		}
		catch (Exception e){System.out.println("Error on click product");
		}
	}
}
