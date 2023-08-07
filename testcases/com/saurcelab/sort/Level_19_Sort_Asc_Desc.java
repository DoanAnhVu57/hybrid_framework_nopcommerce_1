package com.saurcelab.sort;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.saurceLab.LoginPO;
import pageObject.saurceLab.PageGeneratorManager;
import pageObject.saurceLab.ProductPO;

    public class Level_19_Sort_Asc_Desc extends BaseTest {
    	
		private WebDriver driver;
		String UserName, Password;

		private LoginPO loginPage;
		private ProductPO productPage;

		@Parameters({ "browser", "appUrl" })
		@BeforeClass
		public void beforeClass(String browserName, String saurcelabUrl) {
			driver = getBrowserDriver(browserName, saurcelabUrl);

			UserName = "standard_user";
			Password = "secret_sauce";

			log.info("Pre-condition - Step 01: Open Login Page");
			loginPage = PageGeneratorManager.getloginPage(driver);

			log.info("Pre-condition - Step 02: Enter to UserName textbox");
			loginPage.enterToUserNameTextbox(UserName);

			log.info("Pre-condition - Step 03: Enter to Password textbox");
			loginPage.enterToPasswordTextbox(Password);

			log.info("Pre-condition - Step 04: Click to Login button");
			productPage = loginPage.clickToLoginButton();

		}

		@Test
		public void Sort_01_Name() {
			//Ascending
			productPage.selectItemInProductSortDropdown("Name (A to Z)");

			Assert.assertTrue(productPage.isProductNameSortByAscending());
			
			//Descending
			productPage.selectItemInProductSortDropdown("Name (Z to A)");
			
			Assert.assertTrue(productPage.isProductNameSortByDescending());
		}

		@Test
		public void Sort_02_Price() {
			//Ascending
			productPage.selectItemInProductSortDropdown("Price (low to high)");
			
			Assert.assertTrue(productPage.isProductPriceSortByAscending());

			//Descending
			productPage.selectItemInProductSortDropdown("Price (high to low)");
			
			Assert.assertTrue(productPage.isProductPriceSortByDescending());

		}

		@AfterClass(alwaysRun = true)
		public void AfterClass() {
			closeBrowserDriver();

		}

	}
