package com.jquery.datatable;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.HomePageObject;
import pageObject.jQuery.PageGeneratorManager;

public class Level_01_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;

	private HomePageObject homePage;
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName,appUrl);

		homePage = PageGeneratorManager.getHomePage(driver);
	}

	//@Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("5");
		homePage.sleepinsecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("5"));
		
		homePage.openPagingByPageNumber("7");
		homePage.sleepinsecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("7"));
		
		homePage.openPagingByPageNumber("16");
		homePage.sleepinsecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("16"));
		
		homePage.openPagingByPageNumber("18");
		homePage.sleepinsecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("18"));
	}

	//@Test
	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);
		
		homePage.enterToHeaderTextboxByLabel("Country","Mali");
		homePage.enterToHeaderTextboxByLabel("Females","6961327");
		homePage.enterToHeaderTextboxByLabel("Males","7931914");
		homePage.enterToHeaderTextboxByLabel("Total","14893230");
		
	}
	@Test
	public void Table_03_Enter_To_Header() {
		homePage.getValueAllRowAtAllPage();
	}
	@AfterClass
	public void AfterClass() {
		driver.quit();

	}

}

