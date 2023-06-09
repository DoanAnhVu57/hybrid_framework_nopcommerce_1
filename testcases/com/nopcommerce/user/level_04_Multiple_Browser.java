package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.HomePageObject;
import pageObject.RegisterPageObject;

public class level_04_Multiple_Browser extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;

	private HomePageObject homePage;
	private RegisterPageObject registerPage;


	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.vn";
		password = "123456";

		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);
		
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		System.out.println("HomePage_ Step_01: Click to Register link");
		homePage.clickToRegisterLink();

		System.out.println("RegisterPage_Step_02: Click To Register Button");
		registerPage.clickToRegisterButton();

		System.out.println("RegisterPage_Step_03: Verify Error Message ");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		System.out.println("HomePage_ Step_01: Click to Register link");
		homePage.clickToRegisterLink();

		System.out.println("RegisterPage_Step_02: senkey data");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox("123@q2323#$$");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("RegisterPage_Step_03: Click To Register Button");
		registerPage.clickToRegisterButton();

		System.out.println("RegisterPage_Step_04: Verify error message");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void TC_03_Register_Success() {
		System.out.println("HomePage_ Step_01: Click to Register link");
		homePage.clickToRegisterLink();

		System.out.println("RegisterPage_Step_02: senkey data");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("RegisterPage_Step_03: Click To Register Button");
		registerPage.clickToRegisterButton();

		System.out.println("RegisterPage_Step_04: Verify error message success");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

//		System.out.println("RegisterPage_Step_05:Click Logout Button");
//		registerPage.clickToLogoutButton();

	}

	@Test
	public void TC_04_Register_Existing_Email() {
		System.out.println("HomePage_ Step_01: Click to Register link");
		homePage.clickToRegisterLink();

		System.out.println("RegisterPage_Step_02: senkey data");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("RegisterPage_Step_03: Click To Register Button");
		registerPage.clickToRegisterButton();

		System.out.println("RegisterPage_Step_04: Verify Error Message Existing Email");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(),"The specified email already exists");

	}

	@Test
	public void TC_05_Register_Password_Less_Than_6() {
		System.out.println("HomePage_ Step_01: Click to Register link");
		homePage.clickToRegisterLink();

		System.out.println("RegisterPage_Step_02: senkey data");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("1234");
		registerPage.inputToConfirmPasswordTextbox("1234");

		System.out.println("RegisterPage_Step_03: Click To Register Button");
		registerPage.clickToRegisterButton();

		System.out.println("RegistePage_Step_04: Verify Error Message");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void TC_06_Register_Invalid_Comfirm_Password() {
		System.out.println("HomePage_ Step_01: Click to Register link");
		homePage.clickToRegisterLink();

		System.out.println("RegisterPage_Step_02: senkey data");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("1234");

		System.out.println("RegisterPage_Step_03: Click To Register Button");
		registerPage.clickToRegisterButton();

		System.out.println("RegisterPage_Step_04: Verify error message at confirmpassword");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),
				"The password and confirmation password do not match.");

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
