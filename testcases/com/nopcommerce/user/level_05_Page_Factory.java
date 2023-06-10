package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePageFactory;
import commons.BaseTest;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.RegisterPageObject;

public class level_05_Page_Factory extends BaseTest{
	private WebDriver driver;
	private String firstName, lastName, invalidEmail, emailAddress, notFoundEmail, password,invalidPassword;

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;


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
		invalidPassword ="111111";

		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);

		System.out.println("Pre-Condition_ Step_01: Click to Register link");
		homePage.clickToRegisterLink();

		System.out.println("Pre-Condition_Step_02: senkey data");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Pre-Condition_Step_03: Click To Register Button");
		registerPage.clickToRegisterButton();

		System.out.println("Pre-Condition_Step_04: Verify error message success");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void TC_01_Login_Empty_Data() {
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@Test
	public void TC_02_Login_Invalid_Email() {
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void TC_03_Login_Not_Found_Email() {
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextbox(notFoundEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnseccessfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void TC_04_Login_Existing_Email_Empty_Password() {
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnseccessfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void TC_05_Login_Existing_Email_Incorrect_Password() {
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(invalidPassword);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageUnseccessfull(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_06_Login_Valid_Email_Password() {

		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountDisplayed());

	}

	@AfterClass
	public void AfterClass() {
		driver.quit();

	}

	public int generateFakeNumber() {
		Random ran = new Random();
		return ran.nextInt(9999);
	}

}
