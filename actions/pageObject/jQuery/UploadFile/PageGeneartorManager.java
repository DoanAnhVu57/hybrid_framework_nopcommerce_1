package pageObject.jQuery.UploadFile;

import org.openqa.selenium.WebDriver;

public class PageGeneartorManager {

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
		
	}
}
