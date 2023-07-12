package pageObject.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage{
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickCreatNewAccountButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public boolean isEmailTextboxDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUI.EMAIL_TEXTBOX);
	}

	public boolean isConfirmEmailTextboxDisplayed() {
		return isElementDisplayed(driver, LoginPageUI.CONFIRM_EMAIL_TEXTBOX);
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForAllElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
		
	}

	public void clickCloseIconAtRegisterForm() {
		waitForElementClickable(driver, LoginPageUI.CLOSE_ICON);
		clickToElement(driver, LoginPageUI.CLOSE_ICON);
	}

	public boolean isConfirmEmailTextboxUndisplayed() {
		return isElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_TEXTBOX);
	}

}
