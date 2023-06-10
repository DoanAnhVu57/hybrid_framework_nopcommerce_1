package commons;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {

	private long longTimeout =30;
	private short shortTimeout = 5;
	
	public void waitForAllElementVisible(WebDriver driver, List<WebElement> element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(element));
		
	}
	
	public void waitForElementInVisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForAllElementInVisible(WebDriver driver, List<WebElement> element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(element));
		
	}
	
	public void waitForElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
		
	}

	public void senkeyToElement(WebDriver driver, WebElement element,String textValue) {
		element.clear();
		element.sendKeys(textValue);
		
	}
	public String getElementText(WebDriver driver, WebElement element) {
		return element.getText();	
	}
	public boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
		
	}
}
