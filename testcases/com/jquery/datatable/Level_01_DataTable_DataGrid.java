package com.jquery.datatable;


import java.util.List;

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
	//@Test
	public void Table_03_Enter_To_Header() {
		
		homePage.getValueAllRowAtAllPage();
	}
	@Test
	public void Table_04_Enter_To_Textbox_At_Any_Row() {
		homePage.enterToTextboxByColumnNameAtRowNumber("Company","1","RED");
		homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person","1","NAM");
		homePage.enterToTextboxByColumnNameAtRowNumber("Order Placed","1","8");
		
		homePage.enterToTextboxByColumnNameAtRowNumber("Company","2","ED");
		homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person","2","NA");
		homePage.enterToTextboxByColumnNameAtRowNumber("Order Placed","2","6");
		
	}
	@Test
	public void Table_05_Action_At_Any_DropDown_Row() {
		homePage.clickLoadDataButton();
		
		homePage.enterToTextboxByColumnNameAtRowNumber("Company","1","RED");
		homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person","2","Kong");
		homePage.enterToTextboxByColumnNameAtRowNumber("Order Placed","3","6");
		homePage.selectDropdowByColumnNameAtRownumber("Country","4","Japan");
	
		//checkbox
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?","2");
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?","3");
		
		//uncheck
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?","1");
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?","4");
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?","5");
		
		
		//handle button
		homePage.clickToIconByRowNumber("1", "Insert Row Above");
		
		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		
		homePage.clickToIconByRowNumber("1", "Move Up");
		
		homePage.clickToIconByRowNumber("1", "Move Down");
		
		
		homePage.clickToIconByRowNumber("5", "Remove Current Row");
		homePage.clickToIconByRowNumber("4", "Remove Current Row");
		homePage.clickToIconByRowNumber("3", "Remove Current Row");
		homePage.clickToIconByRowNumber("2", "Remove Current Row");
		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		
	}
	@AfterClass
	public void AfterClass() {
		driver.quit();

	}

}

