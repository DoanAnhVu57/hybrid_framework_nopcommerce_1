package com.nopcommerce.user;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_16_Register_Cookie;
import com.nopcommerce.common.Common_16_Register_End_User;

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

public class level_16_Share_Data_C extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;

	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;

	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		emailAddress = Common_16_Register_End_User.emailAddress;
		password = Common_16_Register_End_User.password;
		
		log.info("Pre-Condition - Step 01: Navigate to Login Page");
		userLoginPage = userHomePage.clickToLoginLink();
		
		log.info("Pre-Condition - Step 02:Set Cookie and reload page");
		userLoginPage.setCookie(driver, Common_16_Register_Cookie.loggedCookies);
		for (Cookie cookie: Common_16_Register_Cookie.loggedCookies) {
		}
		userLoginPage.refreshCurrentPage(driver);
		
		log.info("Pre-Condition - Step 05: Verify True My Account isDisplayed");
		verifyTrue(userHomePage.isMyAccountDisplayed());
	}
	@Test
	public void Search_01_Empty_Data() {
		
	}
	@Test
	public void Search_02_Relative_Product_Name() {
		
	}
	@Test
	public void Search_03_Absolute_Product_Name() {
		
	}
	@Test
	public void Search_04_Parent_Category() {
		
	}
	@Test
	public void Search_05_Incorrect_Manufactuner() {
		
	}
	@Test
		public void Search_06_Correct_Manufactuner() {

	}

	@AfterTest
	public void AfterClass() {
		driver.quit();

	}

}
