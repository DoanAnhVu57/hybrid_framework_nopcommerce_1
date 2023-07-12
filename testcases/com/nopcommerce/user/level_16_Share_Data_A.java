package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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

public class level_16_Share_Data_A extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;

	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;

	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		emailAddress = Common_16_Register_End_User.emailAddress;
		password = Common_16_Register_End_User.password;
	
		log.info("Login - Step 01: Click to Login Link");
		userLoginPage = userHomePage.clickToLoginLink();
		
		log.info("Login - Step 02:Enter to emailAddress textbox with value is '" + emailAddress +"'");
		userLoginPage.inputToEmailTextbox(emailAddress);
		
		log.info("Login - Step 03:Enter to password textbox with value is '" + password +"'");
		userLoginPage.inputToPasswordTextbox(password);
		
		log.info("Login - Step 04: Click Login Button");
		userHomePage = userLoginPage.clickToLoginButton();
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
