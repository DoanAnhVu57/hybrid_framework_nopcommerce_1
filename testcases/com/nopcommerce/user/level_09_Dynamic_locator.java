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

public class level_09_Dynamic_locator extends BaseTest {
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
	public void TC_01_Register_Login() {
		userRegisterPage = userHomePage.clickToRegisterLink();

		userRegisterPage.inputToFirstNameTextbox(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(emailAddress);
		userRegisterPage.inputToPasswordTextbox(password);
		userRegisterPage.inputToConfirmPasswordTextbox(password);
		
		userRegisterPage.clickToRegisterButton();

		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
		//userHomePage = userRegisterPage.clickLogoutLink();
		userLoginPage = userHomePage.clickToLoginLink();
		
		userLoginPage.inputToEmailTextbox(emailAddress);
		userLoginPage.inputToPasswordTextbox(password);
		userHomePage = userLoginPage.clickToLoginButton();

		Assert.assertTrue(userHomePage.isMyAccountDisplayed());
		
		userCustomerInfoPage = userHomePage.clickToMyAccountLink();
		Assert.assertTrue(userCustomerInfoPage.isCustomerInfoPageDisplayed());
	}

	@Test
	public void TC_02_Switch_Page() {
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
	@Test
	public void TC_03_Dynamic_Page_I() {
		
		//Addresses -> Orders
		userOrdersPage = (UserOrdersPageObject) userAddressesPage.openPageAtMyAccountByName(driver,"Orders");
		
		//Order-> Dow
		userDownloadableProductsPage = (UserDownloadableProductsPageObject) userOrdersPage.openPageAtMyAccountByName(driver, "Downloadable products");
		//Downloadable Product -> Addresses
		userAddressesPage = (UserAddressesPageObject) userDownloadableProductsPage.openPageAtMyAccountByName(driver,"Addresses");
		
	}
	@Test
	public void TC_03_Dynamic_Page_II() {
		userAddressesPage.openPageAtMyAccount(driver, "Downloadable products");
		userDownloadableProductsPage = PageGeneratorManager.getUserDownloadableProductsPage(driver);
		
		userDownloadableProductsPage.openPageAtMyAccount(driver, "Addresses");
		userAddressesPage = PageGeneratorManager.getUserAddressesPage(driver);
		
		//Addresses -> Orders
		userAddressesPage.openPageAtMyAccount(driver, "Orders");
		userOrdersPage = PageGeneratorManager.getUserOrdersPagePage(driver);
		//Order-> Dow
		userOrdersPage.openPageAtMyAccount(driver, "Downloadable products");
		userDownloadableProductsPage = PageGeneratorManager.getUserDownloadableProductsPage(driver);

		//Downloadable Product -> Addresses
		userDownloadableProductsPage.openPageAtMyAccount(driver, "Addresses");
		userAddressesPage = PageGeneratorManager.getUserAddressesPage(driver);
	}
	@AfterClass
	public void AfterClass() {
		driver.quit();

	}

}
