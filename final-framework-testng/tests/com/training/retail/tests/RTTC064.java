package com.training.retail.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.AdminDashboardPOM;
//import com.training.pom.GuestCheckoutPOM;
//import com.training.pom.HomePagePOM;
import com.training.pom.LoginPOM;
import com.training.pom.CategoriesPagePOM;
//import com.training.pom.ShoppingCartPOM;
//import com.training.pom.CartActionsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC064 {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private CategoriesPagePOM categoriesPagePOM;
//	private LoginRetailPOM loginRetailPOM;
	private LoginPOM loginPOM;
	private AdminDashboardPOM adminDashboardPOM;

	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
    	loginPOM = new LoginPOM(driver);
		adminDashboardPOM = new AdminDashboardPOM(driver);
		categoriesPagePOM = new CategoriesPagePOM(driver);
//		guestCheckoutPOM = new GuestCheckoutPOM(driver);
		baseUrl = properties.getProperty("baseURLAdmin");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
@Test
	public void addMutipleCategories() throws Exception {

        loginPOM.sendUserName("admin");
        loginPOM.sendPassword("admin@123");
        loginPOM.clickLoginBtn();
        Thread.sleep(2000);
        screenShot.captureScreenShot("RTTC064 Login to Dashboard");
        adminDashboardPOM.clickCatalogCategory();
        Thread.sleep(2000);
        categoriesPagePOM.clickAddCategory();
        

}
}
