package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage {
private WebDriver driver;
	

	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAccountLink() {
		waitForElementClickable(driver, MyDashboardPageUI.ACCOUNT_LINK);
		clickToElement(driver, MyDashboardPageUI.ACCOUNT_LINK);
		
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, MyDashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, MyDashboardPageUI.LOGOUT_LINK);
		
		
	}

	public String getRegisterMessage() {
		waitForElementVisible(driver, MyDashboardPageUI.REGISTER_MESSAGE);
		return getElementText(driver,MyDashboardPageUI.REGISTER_MESSAGE );
	}

	public String getLoginSuccessMessage() {
		waitForElementVisible(driver, MyDashboardPageUI.MY_DASHBOARD_MESSAGE);
		return getElementText(driver, MyDashboardPageUI.MY_DASHBOARD_MESSAGE);
	}

	
		
	}


