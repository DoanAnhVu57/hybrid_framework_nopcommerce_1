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

public class level_12_Verify_Assert extends BaseTest {
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
		userHomePage = commons.PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.vn";
		password = "123456";

	}

	@Test
	public void TC_01_Register_Login() {
		userRegisterPage = userHomePage.clickToRegisterLink();

		userRegisterPage.inputToFirstNameTextbox(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(emailAddress);
		userRegisterPage.inputToPasswordTextbox(password);
		userRegisterPage.inputToConfirmPasswordTextbox(password);
		
		userRegisterPage.clickToRegisterButton();

		verifyEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
		//userHomePage = userRegisterPage.clickLogoutLink();
		userLoginPage = userHomePage.clickToLoginLink();
		
		userLoginPage.inputToEmailTextbox(emailAddress);
		userLoginPage.inputToPasswordTextbox(password);
		userHomePage = userLoginPage.clickToLoginButton();

		verifyTrue(userHomePage.isMyAccountDisplayed());
		
		userCustomerInfoPage = userHomePage.clickToMyAccountLink();
		verifyTrue(userCustomerInfoPage.isCustomerInfoPageDisplayed());
	}

	@AfterClass
	public void AfterClass() {
		driver.quit();

	}

}
