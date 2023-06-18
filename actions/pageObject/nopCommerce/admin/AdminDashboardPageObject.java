package pageObject.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.Admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage{
	private WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isDashboardHeaderDisplayed() {
		waitForElementVisible(driver,  AdminDashboardPageUI.DASHBOARD_HEADER);
		return isElementDisplayed(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
	}
	
//	public AdminDashboardPageObject clickLogoutLink() {
//		waitForElementClickable(driver, AdminDashboardPageUI.LOGOUT_LINK);
//		clickToElement(driver, AdminDashboardPageUI.LOGOUT_LINK);
//		return PageGeneratorManager.getAdminDashboardPage(driver);
//	
//	}
//	
}
