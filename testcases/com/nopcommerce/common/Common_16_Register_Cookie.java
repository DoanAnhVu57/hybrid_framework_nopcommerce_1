package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.nopCommerce.user.UserHomePageObject;
import pageObject.nopCommerce.user.UserLoginPageObject;
import pageObject.nopCommerce.user.UserRegisterPageObject;

public class Common_16_Register_Cookie extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName,emailAddress, password; 
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserRegisterPageObject userRegisterPage;
	public static Set<Cookie> loggedCookies;
	
	
	@Parameters("browser")
	@BeforeTest(description = "Create new common User for all Classes Test")
	public void Register(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.vn";
		password = "123456";

		log.info("Register - Step 01: Click to Register Link");
		userRegisterPage = userHomePage.clickToRegisterLink();

		log.info("Register - Step 02:Enter to FirstName textbox with value is '" + firstName + "'");
		userRegisterPage.inputToFirstNameTextbox(firstName);

		log.info("Register - Step 03:Enter to LastName textbox with value is '" + lastName + "'");
		userRegisterPage.inputToLastNameTextbox(lastName);

		log.info("Register - Step 04:Enter to emailAddress textbox with value is '" + emailAddress + "'");
		userRegisterPage.inputToEmailTextbox(emailAddress);

		log.info("Register - Step 05:Enter to password textbox with value is '" + password + "'");
		userRegisterPage.inputToPasswordTextbox(password);

		log.info("Register - Step 06:Enter to Confirm password textbox with value is '" + password + "'");
		userRegisterPage.inputToConfirmPasswordTextbox(password);

		log.info("Register - Step 07: Click to Register Button");
		userRegisterPage.clickToRegisterButton();

		log.info("Register - Step 08: Verify Register Success Message");
		verifyEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
		//userHomePage = userRegisterPage.clickLogoutLink();

		log.info("Login - Step 01: Click to Login Link");
		userLoginPage = userHomePage.clickToLoginLink();
		
		log.info("Login - Step 02:Enter to emailAddress textbox with value is '" + emailAddress +"'");
		userLoginPage.inputToEmailTextbox(emailAddress);
		
		log.info("Login - Step 03:Enter to password textbox with value is '" + password +"'");
		userLoginPage.inputToPasswordTextbox(password);
		
		log.info("Login - Step 04: Click Login Button");
		userHomePage = userLoginPage.clickToLoginButton();
		
		loggedCookies = userHomePage.getAllCookie(driver);
		for (Cookie cookie : loggedCookies) {
			
		}
	}
	@AfterTest
	public void afterClass() {
		driver.quit();

	}

}

