package pageObject.facebook;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static LoginPageObject getHomePage(WebDriver driver) {
		return new LoginPageObject(driver);
		
	}
}
