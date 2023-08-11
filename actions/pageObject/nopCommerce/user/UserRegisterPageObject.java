package pageObject.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.User.HomePageUI;
import pageUIs.nopCommerce.User.RegisterPageUI;

public class UserRegisterPageObject extends BasePage{

	private WebDriver driver;
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to Register button")
	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getErrorMessageAtFirstNameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	@Step("Enter to Firstname textbox with is {0}")
	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
		
	}

	@Step("Enter to Lastname textbox with is {0}")
	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
		
	}

	@Step("Enter to Email textbox with is {0}")
	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);		
	}

	@Step("Enter to Password textbox with is {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);		
	}

	@Step("Enter to ConfirmPassword textbox with is {0}")
	public void inputToConfirmPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);		
	}

	@Step("Verify Register Success Mesaage")
	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public void clickToLogoutButton() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_BUTTON);
		clickToElement(driver, RegisterPageUI.LOGOUT_BUTTON);
		
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver,RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
		return getElementText(driver,RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
	}

	public UserHomePageObject clickLogoutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}



}
