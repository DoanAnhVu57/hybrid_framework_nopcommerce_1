package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminLoginUI;

public class AdminLoginPO extends BasePage{
 
	WebDriver driver;
	public AdminLoginPO(WebDriver driver) {
		this.driver = driver;
	}
	public void enterToUserNameTextbox(String AdminUserName) {
		waitForElementVisible(driver, AdminLoginUI.USERNAME_TEXTBOX);
		senkeyToElement(driver, AdminLoginUI.USERNAME_TEXTBOX, AdminUserName);
		
	}
	public void enterToPasswordTextbox(String AdminPassword) {
		waitForElementVisible(driver, AdminLoginUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, AdminLoginUI.PASSWORD_TEXTBOX, AdminPassword);
		
	}
	public AdminDashboardPO clickToLogInButton() {
		waitForElementClickable(driver, AdminLoginUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginUI.LOGIN_BUTTON);
		return PageGeneartorManager.getadminDashboardPage(driver);
	}
}
