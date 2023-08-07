package pageObject.saurceLab;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static LoginPO getloginPage(WebDriver driver) {
		return new LoginPO(driver) ;
	}
	public static ProductPO getproductPage(WebDriver driver) {
		return new ProductPO(driver) ;
	}
}
