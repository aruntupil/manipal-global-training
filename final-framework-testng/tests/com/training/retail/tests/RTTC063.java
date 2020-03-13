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
import com.training.readexcel.ReadExcel;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.dataproviders.*;


public class RTTC063 {

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
		Thread.sleep(5000);
		driver.quit();
	}
	
@Test(dataProvider="excel-inputs", dataProviderClass=LoginDataProviders.class)
	public void registerInfo(String firstName, String lastName, String email,String phone, String addr1, String addr2, String city, String postal, String country, String state, String password, String confirmPassword) throws Exception {
		
		homePagePOM.clickMenu();
		Thread.sleep(5000);
		loginRetailPOM.clickRegisterBtn();
		Thread.sleep(5000);
		registerPOM.sendFirstName(firstName);
		registerPOM.sendLastname(lastName);
		registerPOM.sendEmail(email);
		registerPOM.sendTelephone(phone);
		registerPOM.sendAddr1(addr1);
		registerPOM.sendAddr2(addr2);
		registerPOM.sendCity(city);
		registerPOM.sendPostal(postal);
		registerPOM.selectCountry(country);
		registerPOM.selectState(state);
		registerPOM.sendPassword(password);
		registerPOM.sendConfirmPwd(confirmPassword);
		Thread.sleep(1000);
		registerPOM.selectNewsltr();
		Thread.sleep(2000);
		registerPOM.selectPolicy();
		screenShot.captureScreenShot("Registering Details");
        registerPOM.verifyRegSuccess();
        screenShot.captureScreenShot("Registration Success");
        System.out.println("Test was successful");
}
}
