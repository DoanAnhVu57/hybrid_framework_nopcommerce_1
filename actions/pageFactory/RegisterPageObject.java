package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePageFactory {

	private WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//UI
	@CacheLookup
	@FindBy(id="register-button")
	private  WebElement registerButton;
	@FindBy(id="FirstName-error")
	private  WebElement firstNameErrorMessage;
	@FindBy(id="LastName-error")
	private  WebElement lastNameErrorMessage;
	@FindBy(id="Email-error")
	private  WebElement emailErrorMessage;
	@FindBy(id="Password-error")
	private  WebElement passwordErrorMessage;
	@FindBy(id="ConfirmPassword-error")
	private  WebElement confirmPasswordErrorMessage;
	@FindBy(id="FirstName")
	private  WebElement firstNameTextbox;
	@FindBy(id="LastName")
	private  WebElement lastNameTextbox;
	@FindBy(id="Email")
	private  WebElement emailTextbox;
	@FindBy(id="Password")
	private  WebElement passwordTextbox;
	@FindBy(id="ConfirmPassword")
	private  WebElement confirmPasswordTextbox;
	@FindBy(xpath="ico-logout")
	private  WebElement loginButton;
	@FindBy(xpath="//div[@class='result']")
	private  WebElement registerSuccessMessage;
	@FindBy(xpath="//div[contains(@class,'message-error')]//li")
	private  WebElement existingEmailErrorMessage;
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getErrorMessageAtFirstNameTextbox() {
		waitForElementInVisible(driver, firstNameErrorMessage);
		return getElementText(driver, firstNameErrorMessage);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementInVisible(driver, emailErrorMessage);
		return getElementText(driver,emailErrorMessage);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementInVisible(driver, lastNameErrorMessage);
		return getElementText(driver, lastNameErrorMessage);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementInVisible(driver, passwordErrorMessage);
		return getElementText(driver, passwordErrorMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementInVisible(driver, confirmPasswordErrorMessage);
		return getElementText(driver, confirmPasswordErrorMessage);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementInVisible(driver, firstNameTextbox);
		senkeyToElement(driver, firstNameTextbox, firstName);
		
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementInVisible(driver, lastNameTextbox);
		senkeyToElement(driver, lastNameTextbox, lastName);
		
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementInVisible(driver, emailTextbox);
		senkeyToElement(driver, emailTextbox, emailAddress);		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementInVisible(driver, passwordTextbox);
		senkeyToElement(driver,passwordTextbox, password);		
	}

	public void inputToConfirmPasswordTextbox(String password) {
		waitForElementInVisible(driver, confirmPasswordTextbox);
		senkeyToElement(driver, confirmPasswordTextbox, password);		
	}

	public String getRegisterSuccessMessage() {
		waitForElementInVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}

	public void clickToLogoutButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
		
	}

	public String getErrorExistingEmailMessage() {
		waitForElementInVisible(driver,existingEmailErrorMessage);
		return getElementText(driver,existingEmailErrorMessage);
	}

}
