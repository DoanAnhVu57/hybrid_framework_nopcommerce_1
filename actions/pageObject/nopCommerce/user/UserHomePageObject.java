package pageObject.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.User.CustomerInfoPageUI;
import pageUIs.nopCommerce.User.HomePageUI;

public class UserHomePageObject extends BasePage {

	private WebDriver driver;
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	@Step("Navigate To Register Page")
	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);

	}

	@Step("Navigate To Login Page")
	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	@Step("Verify is My Account Displayed")
	public boolean isMyAccountDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
		
		
	}

	@Step("Navigate To My Account Page ")
	public UserCustomerInfoPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, CustomerInfoPageUI.MY_ACCOUNT_LINK);
		clickToElement(driver,  CustomerInfoPageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
		
	}
}
