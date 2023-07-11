package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.nopCommerce.user.UserAddressesPageObject;
import pageObject.nopCommerce.user.UserCustomerInfoPageObject;
import pageObject.nopCommerce.user.UserDownloadableProductsPageObject;
import pageObject.nopCommerce.user.UserHomePageObject;
import pageObject.nopCommerce.user.UserLoginPageObject;
import pageObject.nopCommerce.user.UserOrdersPageObject;
import pageObject.nopCommerce.user.UserRegisterPageObject;
import pageObject.nopCommerce.user.UserRewardPointsPageObject;

public class level_14_Log_ReportNG extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;

	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInfoPageObject userCustomerInfoPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.vn";
		password = "123456";

	}

	@Test
	public void TC_01_Register() {
		log.info("Register - Step 01: Click to Register Link");
		userRegisterPage = userHomePage.clickToRegisterLink();

		log.info("Register - Step 02:Enter to FirstName textbox with value is '" + firstName +"'");
		userRegisterPage.inputToFirstNameTextbox(firstName);
		
		log.info("Register - Step 03:Enter to LastName textbox with value is '" + lastName +"'");
		userRegisterPage.inputToLastNameTextbox(lastName);

		log.info("Register - Step 04:Enter to emailAddress textbox with value is '" + emailAddress +"'");
		userRegisterPage.inputToEmailTextbox(emailAddress);

		log.info("Register - Step 05:Enter to password textbox with value is '" + password +"'");
		userRegisterPage.inputToPasswordTextbox(password);
		
		log.info("Register - Step 06:Enter to Confirm password textbox with value is '" + password +"'");
		userRegisterPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Register - Step 07: Click to Register Button");
		userRegisterPage.clickToRegisterButton();

		log.info("Register - Step 08: Verify Register Success Message");
		verifyEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
		//userHomePage = userRegisterPage.clickLogoutLink();
	}
		@Test
		public void TC_02_Login() {
		log.info("Login - Step 01: Click to Login Link");
		userLoginPage = userHomePage.clickToLoginLink();
		
		log.info("Login - Step 02:Enter to emailAddress textbox with value is '" + emailAddress +"'");
		userLoginPage.inputToEmailTextbox(emailAddress);
		
		log.info("Login - Step 03:Enter to password textbox with value is '" + password +"'");
		userLoginPage.inputToPasswordTextbox(password);
		
		log.info("Login - Step 04: Click Login Button");
		userHomePage = userLoginPage.clickToLoginButton();

		log.info("Login - Step 05: Verify True My Account isDisplayed");
		verifyTrue(userHomePage.isMyAccountDisplayed());
		
		log.info("Login - Step 06: Click To My Account Link");
		userCustomerInfoPage = userHomePage.clickToMyAccountLink();
		
		log.info("Login - Step 07: Verify True Customer Info isDisplayed");
		verifyTrue(userCustomerInfoPage.isCustomerInfoPageDisplayed());
	}

	@AfterClass
	public void AfterClass() {
		driver.quit();

	}

}
