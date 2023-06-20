package javaBasic;

public class Topic_02_StringFomat {
	
	//14 page -> 14 locator
	public static String ORDERS_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Orders']";
	public static String CUSTOMER_INFO_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	public static String ADDRESSES_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static String DOWNLOADABLE_PRODUCT_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Downloadable products']";

	// 1 biến cho cả 14 page hoặc n page( fomat giống nhau chỉ khác nhau tên biến) 
	public static String DYNAMIC_SIDE_BAR_BY_PAGE_NAME = "//div[contains(@class,'account-navigation')]//a[text()='%s']";

	// 1 locator đại diện cho các page( header, sidebar, footer)
	public static String DYNAMIC_LINK_BY_PAGE_NAME = "//div[contains(@class,'%s')]//a[text()='%s']";
	

	// 1locator có 3-4-5-6 tham số động
	

	public static void man(String [] agrs) {
		clickToLink(DYNAMIC_SIDE_BAR_BY_PAGE_NAME, "Orders");
		clickToLink(DYNAMIC_SIDE_BAR_BY_PAGE_NAME, "Customer info");
		clickToLink(DYNAMIC_SIDE_BAR_BY_PAGE_NAME, "Addresses");
		clickToLink(DYNAMIC_SIDE_BAR_BY_PAGE_NAME, "Downloadable products");
		

		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "account-navigation", "Orders");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "account-navigation", "Customer info");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "account-navigation", "Addresses");
		clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "account-navigation", "Downloadable products");
	
	
	}
	public static void clickToSizeBarLink(String locator) {
		
	}
	// 1 tham số động
	public static void clickToLink(String dynamicLocator, String pageName) {
		String locator = String.format(dynamicLocator, pageName);
		
	}
	//2 tham số động
	public static void clickToLink(String dynamicLocator,String areaName, String pageName) {
		String locator = String.format(dynamicLocator, areaName, pageName);
		
	}
	//n tham số động
	public static void clickToLink(String dynamicLocator,String...params) {
		String locator = String.format(dynamicLocator, (Object[])params);
		
	}






}
