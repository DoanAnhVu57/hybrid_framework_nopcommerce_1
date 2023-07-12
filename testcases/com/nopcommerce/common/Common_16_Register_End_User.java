package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
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

public class Common_16_Register_End_User extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName;

	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	public static String emailAddress, password; 

	@Parameters("browser")
	@BeforeTest(description = "Create new common User for all Classes Test")
	public void Register(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.vn";
		password = "123456";

		log.info("Pre-Condition - Step 01: Click to Register Link");
		userRegisterPage = userHomePage.clickToRegisterLink();

		log.info("Pre-Condition - Step 02:Enter to FirstName textbox with value is '" + firstName + "'");
		userRegisterPage.inputToFirstNameTextbox(firstName);

		log.info("Pre-Condition - Step 03:Enter to LastName textbox with value is '" + lastName + "'");
		userRegisterPage.inputToLastNameTextbox(lastName);

		log.info("Pre-Condition - Step 04:Enter to emailAddress textbox with value is '" + emailAddress + "'");
		userRegisterPage.inputToEmailTextbox(emailAddress);

		log.info("Pre-Condition - Step 05:Enter to password textbox with value is '" + password + "'");
		userRegisterPage.inputToPasswordTextbox(password);

		log.info("Pre-Condition - Step 06:Enter to Confirm password textbox with value is '" + password + "'");
		userRegisterPage.inputToConfirmPasswordTextbox(password);

		log.info("Pre-Condition - Step 07: Click to Register Button");
		userRegisterPage.clickToRegisterButton();

		log.info("Pre-Condition - Step 08: Verify Register Success Message");
		verifyEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
		// userHomePage = userRegisterPage.clickLogoutLink();
	}

	@AfterTest
	public void AfterTest() {
		driver.quit();

	}

}
