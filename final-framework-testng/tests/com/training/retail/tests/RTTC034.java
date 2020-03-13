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
//import com.training.pom.AccountInfoPOM;
import com.training.pom.HomePagePOM;
//import com.training.pom.LoginRetailPOM;
import com.training.pom.LoginPOM;
//import com.training.pom.CartActionsPOM;
import com.training.pom.GuestCheckoutPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC034 {

	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private ProductPagePOM productPagePOM;
//	private LoginRetailPOM loginRetailPOM;
	private LoginPOM loginPOM;
	private HomePagePOM homePagePOM;
	private ShoppingCartPOM shoppingCartPOM;
	private GuestCheckoutPOM guestCheckoutPOM;
	
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
//		loginRetailPOM = new LoginRetailPOM(driver);
    	loginPOM = new LoginPOM(driver);
		productPagePOM = new ProductPagePOM(driver);
		shoppingCartPOM = new ShoppingCartPOM(driver);
		guestCheckoutPOM = new GuestCheckoutPOM(driver);
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


        homePagePOM.clickProduct("Integer vitae iaculis massa");
        Thread.sleep(3000);
        productPagePOM.clickAddtoCart();
        Thread.sleep(15000);
        productPagePOM.clickOnCart();
        shoppingCartPOM.clickCheckout();
        loginPOM.clickGuestCheckoutRadio();
        loginPOM.clickContinueBtn();
        guestCheckoutPOM.guestEnterFirstname("Vijay");
        guestCheckoutPOM.guestEnterLastname("Deenanath");
        guestCheckoutPOM.guestEnterEmail("hain@gmail.com");
        guestCheckoutPOM.guestEnterPhone("09876542321");
        guestCheckoutPOM.guestAddr1("Addr1");
        guestCheckoutPOM.guestAddr2("addr2");
        guestCheckoutPOM.guestCity("Bangalore");
        guestCheckoutPOM.guestPostal("560071");
        guestCheckoutPOM.guestCountry("India");
        guestCheckoutPOM.guestState("Karnataka");
        guestCheckoutPOM.verifySameDelandBillAddr();
        guestCheckoutPOM.clickBillDtlCtn();
        guestCheckoutPOM.enterDelMethodComment("RTTC034 Delivery Method Comment");
        guestCheckoutPOM.clickDelMethodCtn();
        guestCheckoutPOM.enterPaymentMethodComment("RTTC034 Payment Method Comment");
        guestCheckoutPOM.clickTnC();
        guestCheckoutPOM.clickPaymentMethodCtn();
        guestCheckoutPOM.clickConfirmOrder();
        Thread.sleep(2000);
        screenShot.captureScreenShot("RTTC034 Order Confirmation");
        guestCheckoutPOM.verifyOrderConfirmSuccess();
        productPagePOM.verifyCartQty();
        System.out.println("Test ended");
}

}
