package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserHomePageUI;
import pageUIs.wordpress.UserPostDetailUI;

public class UserHomePO extends BasePage{
	 
		WebDriver driver;
		public UserHomePO(WebDriver driver) {
			this.driver = driver;
		}
		public UserPostDetailPO clickToPostTitle(String postTitle) {
			waitForElementClickable(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		    clickToElement(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		    return PageGeneartorManager.getuserPostDetailPage(driver);
		}
		public boolean isPostInforDisplayedWithPostTitle(String postTitle) {
			waitForElementVisible(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
			return isElementDisplayed(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		}
		public boolean isPostInforDisplayedWithPostBody(String postBody) {
			waitForElementVisible(driver, UserHomePageUI.POST_BODY_TEXT, postBody);
			return isElementDisplayed(driver, UserHomePageUI.POST_BODY_TEXT, postBody);
		}
		public boolean isPostInforDisplayedWithPostAuthor(String authorName) {
			waitForElementVisible(driver, UserHomePageUI.POST_AUTHOR_TEXT, authorName);
			return isElementDisplayed(driver, UserHomePageUI.POST_AUTHOR_TEXT, authorName);
		}
		
		public boolean isPostInforDisplayedWithPostCurrentDay(String postTitle, String currentDay) {
			waitForElementVisible(driver, UserHomePageUI.POST_CURRENT_DAY_TEXT_BY_POST_TITLE, postTitle,currentDay);
			return isElementDisplayed(driver, UserHomePageUI.POST_CURRENT_DAY_TEXT_BY_POST_TITLE, postTitle,currentDay);
		}
		public boolean isPostTitleUndisplayed(String editPostTitle) {
			return isElementUndisplayed(driver, UserHomePageUI.POST_TITLE_TEXT, editPostTitle);
		}
		public void enterToUserSearchTextbox(String editPostTitle) {
			waitForElementVisible(driver, UserHomePageUI.SEARCH_TEXTBOX,editPostTitle);
			senkeyToElement(driver, UserHomePageUI.SEARCH_TEXTBOX,editPostTitle);
		}
		public UserSearchPostPO clickToUserSeachButton() {
			waitForElementClickable(driver, UserHomePageUI.SEARCH_BUTTON);
			clickToElement(driver, UserHomePageUI.SEARCH_BUTTON);
			return PageGeneartorManager.getuserSearchPostPage(driver);
		}
}