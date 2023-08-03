package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcpmmerce.data.UserData2;
import com.nopcpmmerce.data.UserDataMapper3;

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
import utilities.DataHelper;

public class level_20_Faker_Data_3_Driven_Testing extends BaseTest {

	private WebDriver driver;
	private String emailAddress;

	UserDataMapper3 userData;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInfoPageObject userCustomerInfoPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		userData = UserDataMapper3.getUserData();
		emailAddress = userData.getEmailAddress() + generateFakeNumber() + "@fakemail.vn";
	}

	@Test
	public void TC_01_Register() {
		log.info("Register - Step 01: Click to Register Link");
		userRegisterPage = userHomePage.clickToRegisterLink();

		log.info("Register - Step 02: Click to Radio Button Male");
		userRegisterPage.clickToRadioButtonByLabel(driver, "Male");

		log.info("Register - Step 03:Enter to FirstName textbox with value is '" + userData.getFirstName() + "'");
		userRegisterPage.inputToTextboxByID(driver, "FirstName", userData.getFirstName());

		log.info("Register - Step 04:Enter to LastName textbox with value is '" + userData.getLastName() + "'");
		userRegisterPage.inputToTextboxByID(driver, "LastName", userData.getLastName());

		log.info("Regiater - Step 05: Select Dropdow Day");
		userRegisterPage.selectToDropdowByName(driver, "DateOfBirthDay", userData.getDate());

		log.info("Regiater - Step 06: Select Dropdow Month");
		userRegisterPage.selectToDropdowByName(driver, "DateOfBirthMonth", userData.getMonth());

		log.info("Regiater - Step 07: Select Dropdow Year");
		userRegisterPage.selectToDropdowByName(driver, "DateOfBirthYear", userData.getYear());

		log.info("Register - Step 08:Enter to emailAddress textbox with value is '" + emailAddress + "'");
		userRegisterPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Register - Step 09: Click to Checkbox button");
		userRegisterPage.clickToCheckboxButtonByLabel(driver, "Newsletter");

		log.info("Register - Step 10:Enter to password textbox with value is '" + userData.getPassword() + "'");
		userRegisterPage.inputToTextboxByID(driver, "Password", userData.getPassword());

		log.info("Register - Step 11:Enter to Confirm password textbox with value is '" + userData.getPassword() + "'");
		userRegisterPage.inputToTextboxByID(driver, "ConfirmPassword", userData.getPassword());

		log.info("Register - Step 12: Click to Register Button");
		userRegisterPage.clickToButtonText(driver, "Register");

		log.info("Register - Step 13: Verify Register Success Message");
		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");

		// log.info("Register - Step 09: Click to Logout Link");
		// userHomePage = userRegisterPage.clickLogoutLink();
	}

	@Test
	public void TC_02_Login() {
		log.info("Login - Step 01: Click to Login Link");
		userLoginPage = userHomePage.clickToLoginLink();

		log.info("Login - Step 02:Enter to emailAddress textbox with value is '" + emailAddress + "'");
		userLoginPage.inputToTextboxByID(driver, "Email", emailAddress);

		log.info("Login - Step 03:Enter to password textbox with value is '" + userData.getPassword() + "'");
		userLoginPage.inputToTextboxByID(driver, "Password", userData.getPassword());

		log.info("Login - Step 04: Click Login Button");
		userLoginPage.clickToButtonText(driver, "Log in");
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Login - Step 05: Verify True My Account isDisplayed");
		Assert.assertTrue(userHomePage.isMyAccountDisplayed());

	}

	@Test
 	public void TC_03_My_Account() {
		log.info("My Account - Step 01: Navigate to My Account page");
		userCustomerInfoPage = userHomePage.clickToMyAccountLink();

		log.info("My Account - Step 02: Verify True Customer Info isDisplayed");
		Assert.assertTrue(userCustomerInfoPage.isCustomerInfoPageDisplayed());

		log.info("My Account - Step 03: Verify First Name value");
		Assert.assertEquals(userCustomerInfoPage.getTextboxValue(driver, "FirstName"), userData.getFirstName());

		log.info("My Account - Step 03: Verify Last Name value");
		Assert.assertEquals(userCustomerInfoPage.getTextboxValue(driver, "LastName"), userData.getLastName());

		log.info("My Account - Step 03: Verify Email value");
		Assert.assertEquals(userCustomerInfoPage.getTextboxValue(driver, "Email"), emailAddress);
	}

	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		closeBrowserDriver();

	}

}