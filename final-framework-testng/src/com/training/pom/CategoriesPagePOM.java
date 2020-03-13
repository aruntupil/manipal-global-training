package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import com.training.generics.GenericMethods;
import org.testng.Assert;


public class CategoriesPagePOM {
	  private WebDriver driver; 
		
		public CategoriesPagePOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//*[@class='container-fluid']//div/a")
		private WebElement addCategory; 
		
		@FindBy(id="input-name1")
		private WebElement categoryName;
		
		@FindBy(xpath="//*[@class='note-editing-area']")
		private WebElement categoryDescription; 
		
		@FindBy(id="input-meta-title1")
		private WebElement metaTagTitle;
		
		@FindBy(id="input-meta-description1")
		private WebElement metaTagDescription;
		
		
		@FindBy(xpath="//div[@class='pull-right']/button")
		private WebElement clickSave;
		
		
		@FindBy(xpath="//*[@class='alert alert-success']")
		private WebElement saveSuccess;
		
		
		
		public void clickAddCategory()
		
		{
			try 
			{
				
				this.addCategory.click();

/*			Actions menuAction = new Actions(driver);
			WebElement loginMenu = driver.findElement(By.xpath("//*[@id='Menu_Wmt3OMY3']//following::i[2]"));
			menuAction.moveToElement(loginMenu).build().perform();
			menuAction.moveToElement(driver.findElement(By.xpath("//*[@id='Menu_Wmt3OMY3']//following::li[2]"))).click().build().perform();
			*/		
			}

	        catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		public void enterCategoryName(String categoryName)
		{
			try {
				
				this.categoryName.clear();
				this.categoryName.sendKeys(categoryName);				
			}
			catch (Exception e){System.out.println("Error on enter Category Name");
			}
		}
		
		public void enterCategoryDescription(String categoryDescription)
		{
			try {
				
				this.categoryDescription.clear();
				this.categoryDescription.sendKeys(categoryDescription);				
			}
			catch (Exception e){System.out.println("Error on entering Category Description");
			}
		}
		
		public void enterMetaTagTitle(String metaTagTitle)
		{
			try {
				
				this.metaTagTitle.clear();
				this.metaTagTitle.sendKeys(metaTagTitle);				
			}
			catch (Exception e){System.out.println("Error on entering Meta Tag Title");
			}
		}
		
		public void enterMetaTagDescription(String metaTagDescription)
		{
			try {
				
				this.metaTagDescription.clear();
				this.metaTagDescription.sendKeys(metaTagDescription);				
			}
			catch (Exception e){System.out.println("Error on entering Meta Tag Description");
			}
		}
		
		public void clickSave()
		{
			try {
				
				this.clickSave.click();		
			}
			catch (Exception e){System.out.println("Error on clicking Save");
			}
		}
		
		public void verifySuccess()
		{
			try {
				
				 String expMessage = " Success: You have modified categories!      ";
				 String actMessage = this.saveSuccess.getText();
				 Assert.assertEquals(actMessage, expMessage);	
			}
			catch (Exception e){System.out.println("Error on Save");
			}
		}
}
