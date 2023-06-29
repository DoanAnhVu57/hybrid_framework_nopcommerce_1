package pageObject.jQuery.UploadFile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.UploadFile.BasePageJqueryUI;
import pageUIs.jQuery.UploadFile.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_LOADED, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_NAME_LOADED, fileName);
		
	}

	public boolean isFileLinkUpLoadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_UP_LOADED_LINK, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_UP_LOADED_LINK, fileName);
	}

	public boolean isFileImgUpLoadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_UP_LOADED_IMG, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_UP_LOADED_IMG, fileName);
	}

	public void clickStartButton() {
		List<WebElement> startButtons = getListWebElement(driver, HomePageUI.START_BUTTON);
		for (WebElement startButton : startButtons) {
			startButton.click();
		}
	}

}
