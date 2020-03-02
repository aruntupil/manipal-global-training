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
//import com.training.pom.AccountInfoPOM;
//import com.training.pom.LoginPOM;
import com.training.pom.YourPasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TestCase6 {
	private WebDriver driver;
	private String baseUrl;
	private LoginRetailPOM loginRetailPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private YourPasswordPOM yourPasswordPOM;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginRetailPOM = new LoginRetailPOM(driver);
		yourPasswordPOM = new YourPasswordPOM(driver);
		baseUrl = properties.getProperty("baseURL5");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
//		validLoginTest();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
@Test
	public void updateAccountInfo() {
		loginRetailPOM.sendUserName("manzoorig3@gmail.com");
		loginRetailPOM.sendPassword("mehadi1");
		screenShot.captureScreenShot("Login");
		loginRetailPOM.clickLoginBtn(); 
     	screenShot.captureScreenShot("Account Page");
		loginRetailPOM.clickChangePassword();
		yourPasswordPOM.sendnewPassword("mehadi1");
		yourPasswordPOM.sendconfirmPassword("mehadi1");
		screenShot.captureScreenShot("Password Update");
		yourPasswordPOM.clickContinueBtn();
		yourPasswordPOM.verifySuccess();
}
}
