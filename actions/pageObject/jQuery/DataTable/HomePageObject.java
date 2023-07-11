package pageObject.jQuery.DataTable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.DataTable.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		
	}

	public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		senkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER_ACTIVE, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER_ACTIVE, pageNumber);
	}

	//site: https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/
	public List<String> getValueAllRowAtAllPage() {
		int tolalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.print("Totalsize = "+tolalPage);
		
		List<String>allRowValuesAllPage = new ArrayList<String>();
		
		//Duyệt qua tấc cả các Page number(paging)
		for (int index = 1; index <= tolalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_INDEX, String.valueOf(index));
		}
		
		List<WebElement>allRowEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_EACH_PAGE);
		//Get text của mỗi row của mỗi Page
		for (WebElement eachRow : allRowEachPage) {
			allRowValuesAllPage.add(eachRow.getText());
		} 
		
		
		
		//in all các giá trị của row ra
		for (String  value : allRowValuesAllPage) {
			System.err.println("---------------------");
			System.err.println(value);
		}
		return allRowValuesAllPage;
	}

	//site: https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/
	//Enter
	public void enterToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber, String valueToEnter) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME,columnName) +1;
		
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber,String.valueOf(columnIndex) );
		senkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToEnter, rowNumber,String.valueOf(columnIndex));
	}

	//select
	public void selectDropdowByColumnNameAtRownumber(String columnName, String rowNumber, String valueToSelect) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME,columnName) +1;
	
		waitForElementClickable(driver, HomePageUI.DROP_DOWN_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber,String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.DROP_DOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToSelect, rowNumber,String.valueOf(columnIndex));
	
	}

	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME,columnName) +1;
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber,String.valueOf(columnIndex));
		checkToDefaultCheckboxOrRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber,String.valueOf(columnIndex));
	}
		public void uncheckToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver,HomePageUI.COLUMN_INDEX_BY_NAME,columnName) +1;
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber,String.valueOf(columnIndex));
		uncheckToDefaultCheckbox(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX,rowNumber,String.valueOf(columnIndex));
	}

		public void clickLoadDataButton() {
			waitForElementClickable(driver, HomePageUI.LOAD_DATA_BUTTON);
			clickToElement(driver, HomePageUI.LOAD_DATA_BUTTON);
		}

		public void clickToIconByRowNumber(String rowNumber, String iconName) {
			waitForElementClickable(driver,HomePageUI.ICON_NAME_BY_NUMBER,rowNumber, iconName);
			clickToElement(driver,HomePageUI.ICON_NAME_BY_NUMBER,rowNumber, iconName);
		
		}
	

}
