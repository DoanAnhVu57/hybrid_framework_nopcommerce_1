package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserPostDetailUI;

public class UserPostDetailPO extends BasePage{
	 
		WebDriver driver;
		public UserPostDetailPO(WebDriver driver) {
			this.driver = driver;
		}
		public boolean isPostInforDisplayedWithPostTitle(String postTitle) {
			waitForElementVisible(driver,UserPostDetailUI.POST_TITLE_TEXT,postTitle);
			return isElementDisplayed(driver,UserPostDetailUI.POST_TITLE_TEXT,postTitle);
		}
		public boolean isPostInforDisplayedWithPostBody(String postBody) {
			waitForElementVisible(driver,UserPostDetailUI.POST_BODY_TEXT,postBody);
			return isElementDisplayed(driver,UserPostDetailUI.POST_BODY_TEXT,postBody);
		}
		public boolean isPostInforDisplayedWithPostAuthor( String authorName) {
			waitForElementVisible(driver,UserPostDetailUI.POST_AUTHOR_TEXT, authorName);
			return isElementDisplayed(driver,UserPostDetailUI.POST_AUTHOR_TEXT, authorName);
		}
		public boolean isPostInforDisplayedWithPostCurrentDay(String postTitle, String currentDay) {
			waitForElementVisible(driver,UserPostDetailUI.POST_CURRENT_DATE_TEXT_BY_POSR_TITLE,postTitle,currentDay);
			return isElementDisplayed(driver,UserPostDetailUI.POST_CURRENT_DATE_TEXT_BY_POSR_TITLE,postTitle,currentDay);
		}
		
}