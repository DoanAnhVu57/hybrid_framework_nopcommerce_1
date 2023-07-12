package pageObject.jQuery.UploadFile;

import org.openqa.selenium.WebDriver;

import pageObject.facebook.LoginPageObject;


public class PageGeneartorManager {

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
		
	}

	public static HomePageObject getHomePage(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}

}
