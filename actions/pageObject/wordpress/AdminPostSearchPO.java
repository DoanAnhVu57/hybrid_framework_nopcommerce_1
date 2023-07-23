package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostAddNewUI;
import pageUIs.wordpress.AdminPostSearchUI;

public class AdminPostSearchPO extends BasePage{
  
	WebDriver driver;
	public AdminPostSearchPO(WebDriver driver) {
		this.driver = driver;
	}
	public AdminPostAddNewPO clickToAddNewButton() {
		waitForElementClickable(driver, AdminPostSearchUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostSearchUI.ADD_NEW_BUTTON);
		return PageGeneartorManager.getadminPostAddNewPage(driver);
	}
	public void enterToSearchTextbox(String postTitle) {
		waitForElementVisible(driver, AdminPostSearchUI.POST_SEARCH_TEXTBOX);
		senkeyToElement(driver, AdminPostSearchUI.POST_SEARCH_TEXTBOX, postTitle);
		
	}
	public boolean isPostSearchTableDisplayed(String headerID, String cellvalue) {
		int headerIndex = getElementSize(driver, AdminPostSearchUI.TABLE_HEADER_INDEX_BY_HEADER_NAME, headerID) + 1;
		waitForElementVisible(driver, AdminPostSearchUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex),cellvalue);
		return isElementDisplayed(driver, AdminPostSearchUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex),cellvalue);
	}
	public void clickToSearchPostsButton() {
		waitForElementClickable(driver, AdminPostSearchUI.POST_SEARCH_BUTTON);
		clickToElement(driver, AdminPostSearchUI.POST_SEARCH_BUTTON);
	}
	public AdminPostAddNewPO clickToPostTitleLink(String postTitle) {
		waitForElementClickable(driver, AdminPostSearchUI.ROW_TABLE_DETAIL_BY_TITLE_NAME,postTitle);
		clickToElement(driver, AdminPostSearchUI.ROW_TABLE_DETAIL_BY_TITLE_NAME,postTitle);
		return PageGeneartorManager.getadminPostAddNewPage(driver);
	}
	public void selectPostCheckboxByTitle(String editPostTitle) {
		waitForElementClickable(driver, AdminPostSearchUI.ROW_CHECKBOX_BY_TITLE_NAME,editPostTitle);
		checkToDefaultCheckboxOrRadio(driver, AdminPostSearchUI.ROW_CHECKBOX_BY_TITLE_NAME,editPostTitle);
	}
	public void clickToApplyButton() {
		waitForElementClickable(driver, AdminPostSearchUI.APPLY_BUTTON);
		clickToElement(driver, AdminPostSearchUI.APPLY_BUTTON);
	}
	public void selectTextItemInActionDropdow(String dropdownItem) {
		waitForElementClickable(driver, AdminPostSearchUI.ACTION_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminPostSearchUI.ACTION_DROPDOWN, dropdownItem);
	}
	public boolean isMoveToTrashMessageDisplayed(String message) {
		waitForElementVisible(driver, AdminPostSearchUI.MOVE_TO_TRASH_MESSAGE_DISPLAYED,message);
		return isElementDisplayed(driver, AdminPostSearchUI.MOVE_TO_TRASH_MESSAGE_DISPLAYED, message);
	}
	public boolean isNoPostsFoundMessageDispayed(String message) {
		waitForElementVisible(driver, AdminPostSearchUI.SEARCH_POST_TITLE_MESSAGE_DISPLAYED,message);
		return isElementDisplayed(driver, AdminPostSearchUI.SEARCH_POST_TITLE_MESSAGE_DISPLAYED, message);
	}

}
