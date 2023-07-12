package com.nopcommerce.user;


import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.nopCommerce.user.UserAddressesPageObject;
import pageObject.nopCommerce.user.UserCustomerInfoPageObject;
import pageObject.nopCommerce.user.UserDownloadableProductsPageObject;
import pageObject.nopCommerce.user.UserHomePageObject;
import pageObject.nopCommerce.user.UserLoginPageObject;
import pageObject.nopCommerce.user.UserOrdersPageObject;
import pageObject.nopCommerce.user.UserRegisterPageObject;
import pageObject.nopCommerce.user.UserRewardPointsPageObject;
import reportConfig.ExtentTestManager;

public class level_15_Allure extends BaseTest {
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

	@Description("Register to system")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_01_Register() {
		userRegisterPage = userHomePage.clickToRegisterLink();

		userRegisterPage.inputToFirstNameTextbox(firstName);

		userRegisterPage.inputToLastNameTextbox(lastName);

		userRegisterPage.inputToEmailTextbox(emailAddress);

		userRegisterPage.inputToPasswordTextbox(password);

		userRegisterPage.inputToConfirmPasswordTextbox(password);

		userRegisterPage.clickToRegisterButton();

		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
		}

	    @Description("Login to system")
	    @Severity(SeverityLevel.NORMAL)
		@Test
		public void User_02_Login() {
		userLoginPage = userHomePage.clickToLoginLink();

		userLoginPage.inputToEmailTextbox(emailAddress);

		userLoginPage.inputToPasswordTextbox(password);

		userHomePage = userLoginPage.clickToLoginButton();

		Assert.assertFalse(userHomePage.isMyAccountDisplayed());

		userCustomerInfoPage = userHomePage.clickToMyAccountLink();

		Assert.assertFalse(userCustomerInfoPage.isCustomerInfoPageDisplayed());
		}


	@AfterClass
	public void AfterClass() {
		driver.quit();

	}

}
