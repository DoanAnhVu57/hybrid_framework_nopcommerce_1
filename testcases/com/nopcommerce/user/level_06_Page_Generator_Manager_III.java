package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.nopCommerce.user.UserHomePageObject;
import pageObject.nopCommerce.user.UserLoginPageObject;
import pageObject.nopCommerce.user.UserRegisterPageObject;

public class level_06_Page_Generator_Manager_III extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, invalidEmail, emailAddress, notFoundEmail, password, invalidPassword;

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		firstName = "Automation";
		lastName = "FC";
		invalidEmail = "afc@.afc@.com";
		notFoundEmail = "afc" + generateFakeNumber() + "@gmail.com";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.vn";
		password = "123456";
		invalidPassword = "111111";

		homePage = PageGeneratorManager.getUserHomePage(driver);

		registerPage = homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void TC_01_Login_Empty_Data() {
		loginPage = homePage.clickToLoginLink();

		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@Test
	public void TC_02_Login_Invalid_Email() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void TC_03_Login_Not_Found_Email() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(notFoundEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnseccessfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void TC_04_Login_Existing_Email_Empty_Password() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnseccessfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void TC_05_Login_Existing_Email_Incorrect_Password() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(invalidPassword);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnseccessfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_06_Login_Valid_Email_Password() {

		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountDisplayed());

	}

	@AfterClass
	public void AfterClass() {
		driver.quit();

	}

}
