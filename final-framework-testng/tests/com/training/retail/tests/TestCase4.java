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
import com.training.pom.LoginRetailPOM;
import com.training.pom.RegisterPOM;
//import com.training.pom.AccountInfoPOM;
import com.training.pom.HomePagePOM;
//import com.training.pom.YourPasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class TestCase4 {

	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private RegisterPOM registerPOM;
	private LoginRetailPOM loginRetailPOM;
	private HomePagePOM homePagePOM;
	
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
    	loginRetailPOM = new LoginRetailPOM(driver);
		registerPOM = new RegisterPOM(driver);
		baseUrl = properties.getProperty("baseURL4");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
@Test
	public void registerInfo() throws Exception {
		
		homePagePOM.clickMenu();
		Thread.sleep(5000);
		loginRetailPOM.clickRegisterBtn();
		Thread.sleep(5000);
		registerPOM.sendFirstName("Vimal");
		registerPOM.sendLastname("Verma");
		registerPOM.sendEmail("vverma@gmail.com");
		registerPOM.sendTelephone("9876543210");
		registerPOM.sendAddr1("123Test");
		registerPOM.sendAddr2("Adyar");
		registerPOM.sendCity("Chennai");
		registerPOM.sendPostal("600089");
		registerPOM.selectCountry("India");
		registerPOM.selectState("Tamil Nadu");
		registerPOM.sendPassword("atuserpwd");
		registerPOM.sendConfirmPwd("atuserpwd");
		registerPOM.selectNewsltr();
		registerPOM.selectPolicy();
		screenShot.captureScreenShot("Registering Details");
		
		
//        registerPOM.verifySuccess();
		System.out.println("Test was successful");
}
}
