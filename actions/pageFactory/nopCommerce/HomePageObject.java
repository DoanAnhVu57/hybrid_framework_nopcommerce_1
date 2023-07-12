package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.nopCommerce.User.HomePageUI;

public class HomePageObject extends BasePageFactory {

	private WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//UI
	@CacheLookup
	@FindBy(xpath ="//a[@class='ico-register']")
	private WebElement registerLink;
	
	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement loginLink;
	
	@FindBy(xpath = "//a[@class='ico-account']")
	private WebElement myAccountLink;

	//Action
	public void clickToRegister() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, loginLink);
	}
	public void clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

	public boolean isMyAccountDisplayed() {
		waitForElementInVisible(driver, myAccountLink);
		return isElementDisplayed(driver, myAccountLink);
		
		
	}

}
