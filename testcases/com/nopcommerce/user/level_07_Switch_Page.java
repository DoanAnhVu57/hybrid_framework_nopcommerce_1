package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.nopCommerce.AddressesPageObject;
import pageObject.nopCommerce.CustomerInfoPageObject;
import pageObject.nopCommerce.DownloadableProductsPageObject;
import pageObject.nopCommerce.HomePageObject;
import pageObject.nopCommerce.LoginPageObject;
import pageObject.nopCommerce.OrdersPageObject;
import pageObject.nopCommerce.PageGeneratorManager;
import pageObject.nopCommerce.RegisterPageObject;
import pageObject.nopCommerce.RewardPointsPageObject;

public class level_07_Switch_Page extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerInfoPageObject customerInfoPage;
	private DownloadableProductsPageObject downloadableProductsPage;
	private OrdersPageObject ordersPage;
	private RewardPointsPageObject rewardPointsPage;
	private AddressesPageObject addressesPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.vn";
		password = "123456";

	}

	@Test
	public void TC_01_Register() {
		registerPage = homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_02_Login() {
		loginPage = homePage.clickToLoginLink();
		
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountDisplayed());

	}

	@Test
	public void TC_03_Customer_Info() {
		customerInfoPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
	}

	@Test
	public void TC_04_Switch_Page() {
		//Customer Info -> Addresses
		addressesPage = customerInfoPage.openAddressesPage(driver);
		
		//Addresses -> Orders
		ordersPage = addressesPage.openOrdersPage(driver);
		
		//Orders -> Downloadable Product
		downloadableProductsPage = ordersPage.openDownloadableProductsPage(driver);
		
		//Downloadable Product -> Addresses
		addressesPage = downloadableProductsPage.openAddressesPage(driver);
		
		//Addresses -> Reward Points
		rewardPointsPage = addressesPage.openRewardPointsPage(driver);
		
		//Reward Points -> Downloadable Product
		downloadableProductsPage = rewardPointsPage.openDownloadableProductsPage(driver);
		
		addressesPage = downloadableProductsPage.openAddressesPage(driver);
	}

	
	@AfterClass
	public void AfterClass() {
		driver.quit();

	}

}
