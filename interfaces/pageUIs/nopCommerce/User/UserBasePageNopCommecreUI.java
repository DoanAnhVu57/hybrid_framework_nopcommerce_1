package pageUIs.nopCommerce.User;

public class UserBasePageNopCommecreUI {
	public static final String ORDERS_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Orders']";
	public static final String CUSTOMER_INFO_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	public static final String ADDRESSES_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static final String DOWNLOADABLE_PRODUCT_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Downloadable products']";
	public static final String REWARD_POINTS_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	
	
	public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(),'%s')]/following-sibling::input";
	public static final String DYNAMIC_SELECT_DROPDOW_BY_NAME = "xpath=//select[@name='%s']";
	
	
	
	public static final String LOGOUT_LINK_USER = "Css=[class='ico-logout']";
	public static final String LOGOUT_LINK_ADMIN = "xpath=//a[text()='Logout']";
	
}
