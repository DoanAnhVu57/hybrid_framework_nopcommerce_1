package commons;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObject.nopCommerce.user.UserAddressesPageObject;
import pageObject.nopCommerce.user.UserDownloadableProductsPageObject;
import pageObject.nopCommerce.user.UserHomePageObject;
import pageObject.nopCommerce.user.UserOrdersPageObject;
import pageObject.nopCommerce.user.UserRewardPointsPageObject;
import pageObject.wordpress.AdminDashboardPO;
import pageObject.wordpress.AdminPostSearchPO;
import pageObject.wordpress.PageGeneartorManager;
import pageObject.wordpress.UserHomePO;
import pageUIs.jQuery.UploadFile.BasePageJqueryUI;
import pageUIs.nopCommerce.User.UserBasePageNopCommecreUI;

public class BasePage {

	public static BasePage getBasePageObject() {
		return new BasePage();

	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
		// openPageUrl(https://demo.nopcommerce.com/)
	}

	public String getpageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getpageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();

	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();

	}

	public void refreshCurrentPage(WebDriver driver) {

		driver.navigate().refresh();

	}
	public Set<Cookie> getAllCookie(WebDriver driver){

		return driver.manage().getCookies();
	}
	public void setCookie(WebDriver driver, Set<Cookie> cookies) {

		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
			
		}
		sleepinsecond(3);
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();

	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();

	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();

	}

	public void senkeyToAlaert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);

	}

	public void switchToWindowByID(WebDriver driver, String windowID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		// Duyệt qua các giá trị trong all windown
		for (String id : allWindowIDs) {
			// Kiểm tra đk nếu như khác vs WindownID truyền vào thì switch
			if (!id.equals(windowID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String tabTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			String actuaTitle = driver.getTitle();
			if (actuaTitle.equals(tabTitle)) {
				break;
			}
		}
	}

	public void closeAllTabWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
				break;
			}
			driver.switchTo().window(parentID);
		}
	}

	private By getByLocator(String locatorType) {
		By by = null;
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));

		} else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=")
				|| locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));

		} else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=")
				|| locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));

		} else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));

		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=")
				|| locatorType.startsWith("Xpath=")) {
			by = By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("Locator Type is not suppored");
		}
		return by;
	}

	public String getDynamicXpath(String locatorType, String... dynamicValue) {
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
			locatorType = String.format(locatorType, (Object[]) dynamicValue);
		}
		return locatorType;
	}

	public WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));

	}

	public void clickToElement(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}

	public void clickToElement(WebDriver driver, String locatorType, String... dynamicValue) {
		getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)).click();
	}

	public void senkeyToElement(WebDriver driver, String locatorType, String textValue) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(textValue);
		
	}
	
	public void clearValueInElementByDeleteKey(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

	}

	public void senkeyToElement(WebDriver driver, String locatorType, String textValue, String... dynamicValue) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValue));
		element.clear();
		element.sendKeys(textValue);

	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByVisibleText(textItem);

	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem,
			String... dynamicValue) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)));
		select.selectByVisibleText(textItem);

	}

	public String getSelectItemDefaultDropdown(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();

	}

	public boolean isDropdownMultiple(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();

	}

	public void selectItemInDropdown(WebDriver driver, String parentXpath, String childXpath, String ExpectedTextItem) {

		getWebElement(driver, parentXpath).click();
		sleepinsecond(1);

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		List<WebElement> allTtems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));

		for (WebElement item : allTtems) {
			if (item.getText().trim().equals(ExpectedTextItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				item.click();

				break;
			}
		}
	}

	public void sleepinsecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName) {
		return getWebElement(driver, locatorType).getAttribute(attributeName);
		
	}
	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName, String... dynamicValue) {
		return getWebElement(driver,  getDynamicXpath(locatorType, dynamicValue)).getAttribute(attributeName);

	}

	public String getElementText(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText();
	}

	public String getElementText(WebDriver driver, String locatorType, String... dynamicValue) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)).getText();
	}

	public String getElementCssvalue(WebDriver driver, String locatorType, String propertyName) {
		return getWebElement(driver, locatorType).getCssValue(propertyName);
	}

	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();

	}

	public int getElementSize(WebDriver driver, String locatorType) {
		return getListWebElement(driver, locatorType).size();
	}

	public int getElementSize(WebDriver driver, String locatorType, String... dynamicValue) {
		return getListWebElement(driver, getDynamicXpath(locatorType, dynamicValue)).size();
	}

	public void checkToDefaultCheckboxOrRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void checkToDefaultCheckboxOrRadio(WebDriver driver, String locatorType, String... dynamicValue) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValue));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckbox(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckbox(WebDriver driver, String locatorType, String... dynamicValue) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValue));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locatorType) {
		try {
			return getWebElement(driver, locatorType).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public boolean isElementDisplayed(WebDriver driver, String locatorType, String... dynamicValue) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)).isDisplayed();

	}
	
	public boolean isElementUndisplayed(WebDriver driver, String locator){
		overrideGlobalTimeout(driver, 5);
		List<WebElement> elements = getListWebElement(driver,locator);
		
		overrideGlobalTimeout(driver, 30);
		if (elements.size()==0) {
			return true;
		}else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		}else
			return false;
		
	}
	public boolean isElementUndisplayed(WebDriver driver, String locator, String... dynamicValue){
		overrideGlobalTimeout(driver, 5);
		List<WebElement> elements = getListWebElement(driver,getDynamicXpath(locator, dynamicValue));
		
		overrideGlobalTimeout(driver, 30);
		if (elements.size()==0) {
			return true;
		}else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		}else
			return false;
		
	}

	public void overrideGlobalTimeout(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	public boolean isElementEnable(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();

	}

	public boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();

	}

	public void switchToFrameIframe(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));

	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoveMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}
	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key, String... dynamicValue) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)), key).perform();
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepinsecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	public void scrollToElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

	public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, locatorType));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		final JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, locatorType));
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (Boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, locatorType));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType, String... dynamicValue) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (Boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, getDynamicXpath(locatorType, dynamicValue)));
		return status;

	}

	public void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}

	public void waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValue))));
	}

	public void waitForAllElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));

	}

	public void waitForAllElementVisible(WebDriver driver, String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValue))));

	}

	public void waitForElementInVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}

	public void waitForElementInVisible(WebDriver driver, String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions
				.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValue))));
	}

	public void waitForAllElementInVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locatorType)));

	}

	public void waitForAllElementInVisible(WebDriver driver, String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions
				.invisibilityOfAllElements(getListWebElement(driver, getDynamicXpath(locatorType, dynamicValue))));

	}

	public void waitForElementClickable(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}

	public void waitForElementClickable(WebDriver driver, String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(
				ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValue))));
	}

	public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
		String filePath = GlobalConstants.UPLOAD_FILE;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getWebElement(driver, BasePageJqueryUI.UPLOAD_FILE).sendKeys(fullFileName);
	}

	public UserAddressesPageObject openAddressesPage(WebDriver driver) {
		waitForElementClickable(driver, UserBasePageNopCommecreUI.ADDRESSES_LINK);
		clickToElement(driver, UserBasePageNopCommecreUI.ADDRESSES_LINK);
		return PageGeneratorManager.getUserAddressesPage(driver);
	}

	public UserOrdersPageObject openOrdersPage(WebDriver driver) {
		waitForElementClickable(driver, UserBasePageNopCommecreUI.ORDERS_LINK);
		clickToElement(driver, UserBasePageNopCommecreUI.ORDERS_LINK);
		return PageGeneratorManager.getUserOrdersPagePage(driver);
	}

	public UserRewardPointsPageObject openRewardPointsPage(WebDriver driver) {
		waitForElementClickable(driver, UserBasePageNopCommecreUI.REWARD_POINTS_LINK);
		clickToElement(driver, UserBasePageNopCommecreUI.REWARD_POINTS_LINK);
		return PageGeneratorManager.getUserRewardPointsPage(driver);
	}

	public UserDownloadableProductsPageObject openDownloadableProductsPage(WebDriver driver) {
		waitForElementClickable(driver, UserBasePageNopCommecreUI.DOWNLOADABLE_PRODUCT_LINK);
		clickToElement(driver, UserBasePageNopCommecreUI.DOWNLOADABLE_PRODUCT_LINK);
		return PageGeneratorManager.getUserDownloadableProductsPage(driver);
	}

	// Dynamic1/　Tối ưu bài học Dynamic
	public BasePage openPageAtMyAccountByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, UserBasePageNopCommecreUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, UserBasePageNopCommecreUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		switch (pageName) {
		case "Addresses":
			return PageGeneratorManager.getUserAddressesPage(driver);
		case "Orders":
			return PageGeneratorManager.getUserOrdersPagePage(driver);
		case "Reward Points":
			return PageGeneratorManager.getUserRewardPointsPage(driver);
		case "Downloadable products":
			return PageGeneratorManager.getUserDownloadableProductsPage(driver);

		default:
			throw new RuntimeException("Invalid page name at My account area.");
		}
	}

	// Dynamic2/ Pattern Object
	public void openPageAtMyAccount(WebDriver driver, String pageName) {
		waitForElementClickable(driver, UserBasePageNopCommecreUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, UserBasePageNopCommecreUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
	}

	/** Enter to dynamic textbox by ID
	 * @param driver
	 * @param textbox ID
	 * @param value
	 * @author VU AD
	 */
	public void inputToTextboxByID(WebDriver driver, String textboxID, String value) {
		waitForElementVisible(driver, UserBasePageNopCommecreUI.DYNAMIC_TEXTBOX_ID, textboxID);
		senkeyToElement(driver, UserBasePageNopCommecreUI.DYNAMIC_TEXTBOX_ID, value, textboxID);
	}

	public void clickToButtonText(WebDriver driver,String buttonText) {
		waitForElementClickable(driver, UserBasePageNopCommecreUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		clickToElement(driver, UserBasePageNopCommecreUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
	}
	public void clickToRadioButtonByLabel(WebDriver driver, String radioButtonLabelName) {
		waitForElementClickable(driver, UserBasePageNopCommecreUI.DYNAMIC_RADIO_BUTTON_BY_LABEL, radioButtonLabelName);
		checkToDefaultCheckboxOrRadio(driver, UserBasePageNopCommecreUI.DYNAMIC_RADIO_BUTTON_BY_LABEL, radioButtonLabelName);
	}

	public void selectToDropdowByName(WebDriver driver, String dropdownAttributeName, String itemValue) {
		waitForElementClickable(driver, UserBasePageNopCommecreUI.DYNAMIC_SELECT_DROPDOW_BY_NAME, dropdownAttributeName);
		selectItemInDefaultDropdown(driver, UserBasePageNopCommecreUI.DYNAMIC_SELECT_DROPDOW_BY_NAME, itemValue, dropdownAttributeName);
	}
	
	public void clickToCheckboxButtonByLabel(WebDriver driver, String checkboxButtonLabelName) {
		waitForElementClickable(driver, UserBasePageNopCommecreUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxButtonLabelName);
		checkToDefaultCheckboxOrRadio(driver, UserBasePageNopCommecreUI.DYNAMIC_CHECKBOX_BY_LABEL, checkboxButtonLabelName);
		
	}

	public String getTextboxValue(WebDriver driver, String textboxID) {
		waitForElementVisible(driver, UserBasePageNopCommecreUI.DYNAMIC_TEXTBOX_ID, textboxID);
		return getElementAttribute(driver, UserBasePageNopCommecreUI.DYNAMIC_TEXTBOX_ID, "value", textboxID);
		
	}
	//Switch Role
	public UserHomePageObject clickLoginLinkAtUserPage(WebDriver driver) {
		waitForElementClickable(driver, UserBasePageNopCommecreUI.LOGOUT_LINK_USER);
		clickToElement(driver, UserBasePageNopCommecreUI.LOGOUT_LINK_USER);
		return PageGeneratorManager.getUserHomePage(driver);

	}

	public AdminLoginPageObject clickLoginLinkAtAdminPage(WebDriver driver) {
		waitForElementClickable(driver, UserBasePageNopCommecreUI.LOGOUT_LINK_ADMIN);
		clickToElement(driver, UserBasePageNopCommecreUI.LOGOUT_LINK_ADMIN);
		return PageGeneratorManager.getAdminLoginPage(driver);

	}

	public UserHomePO openEndUserSite(WebDriver driver, String endUserUrl) {
		openPageUrl(driver,endUserUrl);
		return pageObject.wordpress.PageGeneartorManager.getuserHomePage(driver);
	}
	
	public AdminDashboardPO openAdminUrlSite(WebDriver driver, String adminUrl) {
		openPageUrl(driver, adminUrl);
		return pageObject.wordpress.PageGeneartorManager.getadminDashboardPage(driver);
	}
	private int longTimeout = 30;
	private short shortTimeout = 5;

}
