package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

public class PageGeneartorManager {
	public static AdminLoginPO getadminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}

	public static AdminDashboardPO getadminDashboardPage(WebDriver driver) {
		return new AdminDashboardPO(driver);
		
	}
	public static AdminPostAddNewPO getadminPostAddNewPage(WebDriver driver) {
		return new AdminPostAddNewPO(driver);
		
	}
	public static AdminPostSearchPO getadminPostSearchPage(WebDriver driver) {
		return new AdminPostSearchPO(driver);
		
	}
	public static UserHomePO getuserHomePage(WebDriver driver) {
		return new UserHomePO(driver);
		
	}
	public static UserPostDetailPO getuserPostDetailPage(WebDriver driver) {
		return new UserPostDetailPO(driver);
		
	}
	public static UserSearchPostPO getuserSearchPostPage(WebDriver driver) {
		return new UserSearchPostPO(driver);
		
	}
}
