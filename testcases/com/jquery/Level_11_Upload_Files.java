package com.jquery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.UploadFile.HomePageObject;
import pageObject.jQuery.UploadFile.PageGeneartorManager;
import pageUIs.jQuery.UploadFile.HomePageUI;

public class Level_11_Upload_Files extends BaseTest {
	private WebDriver driver;
	String choGoldenFileName = "choGolden.jpg";
	String chohuskyFileName = "chohusky.jpg";
	String choPitbullFileName = "choPitbull.jpg";
	String chopoldleFileName = "chopoldle.jpg";
	String[] multipleFileName = { choGoldenFileName, chohuskyFileName, choPitbullFileName, chopoldleFileName };

	private HomePageObject homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		homePage = PageGeneartorManager.getHomePage(driver);
	}

	@Test
	public void Upload_01_One_File_Per_Time() {

		homePage.uploadMultipleFiles(driver, choGoldenFileName);

		Assert.assertTrue(homePage.isFileLoadedByName(choGoldenFileName));

		homePage.clickStartButton();

		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(choGoldenFileName));

		Assert.assertTrue(homePage.isFileImgUpLoadedByName(choGoldenFileName));

	}

	 @Test
	public void Upload_02_Multiple_File_Per_Time() {
		homePage.refreshCurrentPage(driver);

		homePage.uploadMultipleFiles(driver, multipleFileName);
		
		Assert.assertTrue(homePage.isFileLoadedByName(choGoldenFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(chohuskyFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(choPitbullFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(chopoldleFileName));

		homePage.clickStartButton();

		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(choGoldenFileName));
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(choGoldenFileName));
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(choGoldenFileName));
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(chopoldleFileName));

		Assert.assertTrue(homePage.isFileImgUpLoadedByName(choGoldenFileName));
		Assert.assertTrue(homePage.isFileImgUpLoadedByName(choGoldenFileName));
		Assert.assertTrue(homePage.isFileImgUpLoadedByName(choGoldenFileName));
		Assert.assertTrue(homePage.isFileImgUpLoadedByName(choGoldenFileName));
		Assert.assertTrue(homePage.isFileImgUpLoadedByName(chopoldleFileName));

	}

	@AfterClass
	public void AfterClass() {
		driver.quit();

	}

}
