package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostAddNewUI;

public class AdminPostAddNewPO extends BasePage {

	WebDriver driver;

	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToPostTitle(String postTitle) {
		waitForElementVisible(driver, AdminPostAddNewUI.ADD_TITLE_TEXTBOX);
		senkeyToElement(driver, AdminPostAddNewUI.ADD_TITLE_TEXTBOX, postTitle);
	}

	public void enterToPostBody(String postBody) {
		waitForElementClickable(driver, AdminPostAddNewUI.ADD_BODY_BUTTON);
		clickToElement(driver, AdminPostAddNewUI.ADD_BODY_BUTTON);
		
		waitForElementVisible(driver, AdminPostAddNewUI.ADD_BODY_TEXTBOX);
		senkeyToElement(driver, AdminPostAddNewUI.ADD_BODY_TEXTBOX, postBody);
		
	}
	public void enterToEditPostBody(String editPostBody) {
		waitForElementClickable(driver, AdminPostAddNewUI.ADD_BODY_TEXTBOX);
		clickToElement(driver, AdminPostAddNewUI.ADD_BODY_TEXTBOX);
		
		waitForElementVisible(driver, AdminPostAddNewUI.ADD_BODY_TEXTBOX);
		clearValueInElementByDeleteKey(driver, AdminPostAddNewUI.ADD_BODY_TEXTBOX);
		senkeyToElement(driver, AdminPostAddNewUI.ADD_BODY_TEXTBOX, editPostBody);
		
	}

	public void clickToPublishButton() {
		waitForElementClickable(driver, AdminPostAddNewUI.PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewUI.PUBLISH_BUTTON);
	}
	public void clickToUpdateButton() {
		waitForElementClickable(driver, AdminPostAddNewUI.UPDATE_BUTTON);
		clickToElement(driver, AdminPostAddNewUI.UPDATE_BUTTON);
	}

	public boolean isPostPublishOrUpdatedMessageDisplayed(String postPublishedMessage) {
		waitForElementVisible(driver, AdminPostAddNewUI.POST_PUBLISHED_OR_UPDATED_MESSAGE, postPublishedMessage);
		return isElementDisplayed(driver, AdminPostAddNewUI.POST_PUBLISHED_OR_UPDATED_MESSAGE, postPublishedMessage);
		
	}

	public AdminPostSearchPO openSearchPostUrl(String searchPostUrl) {
		openPageUrl(driver, searchPostUrl);
		return PageGeneartorManager.getadminPostSearchPage(driver);
		
	}
}
