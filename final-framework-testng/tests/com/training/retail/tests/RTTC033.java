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
import com.training.pom.ProductPagePOM;
import com.training.pom.ShoppingCartPOM;
import com.training.pom.AccountInfoPOM;
import com.training.pom.HomePagePOM;
import com.training.pom.LoginRetailPOM;
import com.training.pom.CartActionsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC033 {
	
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private ProductPagePOM productPagePOM;
	private LoginRetailPOM loginRetailPOM;
	private HomePagePOM homePagePOM;
	private AccountInfoPOM accountInfoPOM;
	private ShoppingCartPOM shoppingCartPOM;
	private CartActionsPOM cartActionsPOM;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		homePagePOM = new HomePagePOM(driver);
		accountInfoPOM = new AccountInfoPOM(driver);
    	loginRetailPOM = new LoginRetailPOM(driver);
		productPagePOM = new ProductPagePOM(driver);
		shoppingCartPOM = new ShoppingCartPOM(driver);
		cartActionsPOM = new CartActionsPOM(driver);
		baseUrl = properties.getProperty("baseURL4");
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
	public void addProductToCart() throws Exception {

		homePagePOM.clickMenu();
		Thread.sleep(5000);
		loginRetailPOM.sendUserName("vverma1@gmail.com");
		loginRetailPOM.sendPassword("atuserpwd");
		loginRetailPOM.clickLoginBtn();
        screenShot.captureScreenShot("RTTC033 Login Success");
        accountInfoPOM.clickHomeBtn();
        homePagePOM.clickProduct("Integer vitae iaculis massa");
        Thread.sleep(3000);
        productPagePOM.clickAddtoCart();
        Thread.sleep(15000);
        productPagePOM.clickOnCart();
        shoppingCartPOM.clickCheckout();
        cartActionsPOM.clickBillDtlCtn();
        cartActionsPOM.clickDelDtlCtn();
        screenShot.captureScreenShot("RTTC033 In the Cart actions page");
        Thread.sleep(2000);
        cartActionsPOM.enterDelMethodComment("This Product is Nice");
        screenShot.captureScreenShot("RTTC033 Entered Del Comments");
        cartActionsPOM.clickDelMethodCtn();
        Thread.sleep(2000);
        cartActionsPOM.enterPaymentMethodComment("RTCC033 Payment Method Comment");
        cartActionsPOM.clickConfirmOrder();
        System.out.println("Test ended");
}

}
