package com.facebook.register;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.facebook.LoginPageObject;
import pageObject.jQuery.UploadFile.HomePageObject;
import pageObject.jQuery.UploadFile.PageGeneartorManager;
import pageUIs.jQuery.UploadFile.HomePageUI;

public class Level_13_Element_Undisplayed extends BaseTest {
	private WebDriver driver;

	private LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		loginPage = PageGeneartorManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickCreatNewAccountButton();
		verifyTrue(loginPage.isEmailTextboxDisplayed());
		
		loginPage.enterToEmailTextbox("autoFC@gmail.com");
		verifyTrue(loginPage.isConfirmEmailTextboxDisplayed());
	}

	@Test
	public void TC_02_Verify_Element_UnDisplayed_In_Dom() {
		loginPage.enterToEmailTextbox("");
		loginPage.sleepinsecond(3);
		verifyTrue(loginPage.isConfirmEmailTextboxUndisplayed());
		//verifyFalse(loginPage.isConfirmEmailTextboxDisplayed());

	}

	@Test
	public void TC_03_Verify_Element_UnDisplayed_Not_In_Dom() {
		loginPage.clickCloseIconAtRegisterForm();
		loginPage.sleepinsecond(3);

		verifyTrue(loginPage.isConfirmEmailTextboxUndisplayed());
	}

	@AfterClass
	public void AfterClass() {
		driver.quit();

	}

}
