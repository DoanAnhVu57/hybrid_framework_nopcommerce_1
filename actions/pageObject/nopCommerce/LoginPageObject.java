package pageObject.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePage{
  
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
		
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputToEmailTextbox(String invalidEmail) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, invalidEmail);
		
	}

	public String getErrorMessageUnseccessfull() {
		waitForElementVisible(driver, LoginPageUI.UNSECCESS_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.UNSECCESS_EMAIL_ERROR_MESSAGE);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public HomePageObject loginAsUser(String emailAddress, String password) {
		inputToEmailTextbox(emailAddress);
		inputToPasswordTextbox(password);
	    return clickToLoginButton();
		
	}

	
	
}