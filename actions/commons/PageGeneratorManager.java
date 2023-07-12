package commons;

import org.openqa.selenium.WebDriver;

import pageObject.nopCommerce.admin.AdminDashboardPageObject;
import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObject.nopCommerce.user.UserAddressesPageObject;
import pageObject.nopCommerce.user.UserCustomerInfoPageObject;
import pageObject.nopCommerce.user.UserDownloadableProductsPageObject;
import pageObject.nopCommerce.user.UserHomePageObject;
import pageObject.nopCommerce.user.UserLoginPageObject;
import pageObject.nopCommerce.user.UserOrdersPageObject;
import pageObject.nopCommerce.user.UserRegisterPageObject;
import pageObject.nopCommerce.user.UserRewardPointsPageObject;

public class PageGeneratorManager {

	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
		
	}
	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
		
	}
	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
		
	}
	public static UserCustomerInfoPageObject getUserCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPageObject(driver);
		
	}
	public static UserDownloadableProductsPageObject getUserDownloadableProductsPage(WebDriver driver) {
		return new UserDownloadableProductsPageObject(driver);
	}
	public static UserOrdersPageObject getUserOrdersPagePage(WebDriver driver) {
		return new UserOrdersPageObject(driver);
	}
	public static UserRewardPointsPageObject getUserRewardPointsPage(WebDriver driver) {
		return new UserRewardPointsPageObject(driver);
	}
	public static UserAddressesPageObject getUserAddressesPage(WebDriver driver) {
		return new UserAddressesPageObject(driver);
	}
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	
	}
	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	
	}
	
	
}
