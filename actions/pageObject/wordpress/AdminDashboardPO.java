package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminDashboardUI;
import pageUIs.wordpress.AdminLoginUI;

public class AdminDashboardPO extends BasePage{

	WebDriver driver;

	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostSearchPO clickToPostMenuLink() {
		waitForElementClickable(driver, AdminDashboardUI.POSTS_MENU_LINK);
		clickToElement(driver, AdminDashboardUI.POSTS_MENU_LINK);
		return PageGeneartorManager.getadminPostSearchPage(driver);
	}
}
