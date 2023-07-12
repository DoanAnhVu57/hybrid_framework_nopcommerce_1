package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.nopCommerce.User.LoginPageUI;

public class LoginPageObject extends BasePageFactory {

	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//UI
	@CacheLookup
	@FindBy(xpath="//button[contains(@class,'login-button')]")
	private WebElement loginButton;
	@FindBy(id="Email-error")
	private WebElement emailErrorMessage;
	@FindBy(xpath="//div[contains(@class,'validation-summary-errors')]")
	private WebElement unsuccessEmailErrorMessage;
	@FindBy(id="Email")
	private WebElement emailTextbox;
	@FindBy(id= "Password")
	private WebElement passwordTextbox;
	
	
	
	
	
	
	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
		
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementInVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public void inputToEmailTextbox(String invalidEmail) {
		waitForElementInVisible(driver, emailTextbox);
		senkeyToElement(driver, emailTextbox, invalidEmail);
		
	}

	public String getErrorMessageUnseccessfull() {
		waitForElementInVisible(driver, unsuccessEmailErrorMessage);
		return getElementText(driver, unsuccessEmailErrorMessage);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementInVisible(driver, passwordTextbox);
		senkeyToElement(driver, passwordTextbox, password);
		
	}

}
