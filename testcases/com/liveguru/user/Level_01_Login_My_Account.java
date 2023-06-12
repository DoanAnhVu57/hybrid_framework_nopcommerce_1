package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.liveGuru.HomePageObject;
import pageObject.liveGuru.LoginPageObject;
import pageObject.liveGuru.MyDashboardPageObject;
import pageObject.liveGuru.PageGeneratorManager;
import pageObject.liveGuru.RegisterPageObject;

public class Level_01_Login_My_Account extends BaseTest {
	private WebDriver driver;
	String firstName, lastName, emailAddress, password;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private MyDashboardPageObject myDashboardPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		firstName = "auto";
		lastName = "fc";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
		password = "666666";

		homePage = PageGeneratorManager.getHomePage(driver);
		//homePage = new HomePageObject(driver);
	}

	@Test
	public void TC_01_Register_To_System() {
		loginPage = homePage.clickToMyAccount();
		
		//loginPage = new LoginPageObject(driver);
		registerPage = loginPage.clickToCreateAnAccountButton();
		
		//registerPage = new RegisterPageObject(driver);
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		
		myDashboardPage = registerPage.clickToRegisterButton();
		
		//myDashboardPage = new MyDashboardPageObject(driver);
		Assert.assertEquals(myDashboardPage.getRegisterMessage(), "Thank you for registering with Main Website Store.");
		
		myDashboardPage.clickToAccountLink();
		myDashboardPage.clickToLogoutLink();
		
	}
		@Test
		public void TC_02_Login_To_System() {
			homePage = PageGeneratorManager.getHomePage(driver);
			//homePage = new HomePageObject(driver);
		
			loginPage = homePage.clickToMyAccount();
			
			//loginPage = new LoginPageObject(driver);
			loginPage.inputToEmailAddressTextbox(emailAddress);
			loginPage.inputToPasswordTextbox(password);
			
			myDashboardPage = loginPage.clickToLoginButton();
			
			//myDashboardPage = new MyDashboardPageObject(driver);
			Assert.assertEquals(myDashboardPage.getLoginSuccessMessage(), "Hello, auto fc!");
			
			myDashboardPage.clickToAccountLink();
			myDashboardPage.clickToLogoutLink();
			
			homePage = PageGeneratorManager.getHomePage(driver);
			//homePage = new HomePageObject(driver);
		}
		

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
