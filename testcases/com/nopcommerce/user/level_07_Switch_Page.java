package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.nopCommerce.user.UserAddressesPageObject;
import pageObject.nopCommerce.user.UserCustomerInfoPageObject;
import pageObject.nopCommerce.user.UserDownloadableProductsPageObject;
import pageObject.nopCommerce.user.UserHomePageObject;
import pageObject.nopCommerce.user.UserLoginPageObject;
import pageObject.nopCommerce.user.UserOrdersPageObject;
import pageObject.nopCommerce.user.UserRegisterPageObject;
import pageObject.nopCommerce.user.UserRewardPointsPageObject;

public class level_07_Switch_Page extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;

	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInfoPageObject userCustomerInfoPage;
	private UserDownloadableProductsPageObject userDownloadableProductsPage;
	private UserOrdersPageObject userOrdersPage;
	private UserRewardPointsPageObject userRewardPointsPage;
	private UserAddressesPageObject userAddressesPage;

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
	public void TC_01_Register() {
		userRegisterPage = userHomePage.clickToRegisterLink();

		userRegisterPage.inputToFirstNameTextbox(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(emailAddress);
		userRegisterPage.inputToPasswordTextbox(password);
		userRegisterPage.inputToConfirmPasswordTextbox(password);
		
		userRegisterPage.clickToRegisterButton();

		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
		userHomePage = commons.PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void TC_02_Login() {
		userLoginPage = userHomePage.clickToLoginLink();
		
		userLoginPage.inputToEmailTextbox(emailAddress);
		userLoginPage.inputToPasswordTextbox(password);
		userHomePage = userLoginPage.clickToLoginButton();

		Assert.assertTrue(userHomePage.isMyAccountDisplayed());

	}

	@Test
	public void TC_03_Customer_Info() {
		userCustomerInfoPage = userHomePage.clickToMyAccountLink();
		Assert.assertTrue(userCustomerInfoPage.isCustomerInfoPageDisplayed());
	}

	@Test
	public void TC_04_Switch_Page() {
		//Customer Info -> Addresses
		userAddressesPage = userCustomerInfoPage.openAddressesPage(driver);
		
		//Addresses -> Orders
		userOrdersPage = userAddressesPage.openOrdersPage(driver);
		
		//Orders -> Downloadable Product
		userDownloadableProductsPage = userOrdersPage.openDownloadableProductsPage(driver);
		
		//Downloadable Product -> Addresses
		userAddressesPage = userDownloadableProductsPage.openAddressesPage(driver);
		
		//Addresses -> Reward Points
		userRewardPointsPage = userAddressesPage.openRewardPointsPage(driver);
		
		//Reward Points -> Downloadable Product
		userDownloadableProductsPage = userRewardPointsPage.openDownloadableProductsPage(driver);
		
		userAddressesPage = userDownloadableProductsPage.openAddressesPage(driver);
	}

	
	@AfterClass
	public void AfterClass() {
		driver.quit();

	}

}
