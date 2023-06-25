package pageObject.jQuery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

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
	

}
