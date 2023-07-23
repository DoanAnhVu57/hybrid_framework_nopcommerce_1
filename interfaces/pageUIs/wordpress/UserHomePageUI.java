package pageUIs.wordpress;

public class UserHomePageUI {

	public static final String POST_TITLE_TEXT = "xpath=//article//header//a[text()='%s']";
	public static final String POST_CURRENT_DAY_TEXT_BY_POST_TITLE = "xpath=//article//h2//a[text()='%s']/parent::h2/following-sibling::div//time[text()='%s']";
	public static final String POST_BODY_TEXT = "xpath=//article//div//p[text()='%s']";
	public static final String POST_AUTHOR_TEXT = "xpath=//article//header//div//a[text()='%s']";
	public static final String SEARCH_TEXTBOX = "xpath=//aside[@id='secondary']/section/form/label/span[text()='Search for:']/following-sibling::input";
	public static final String SEARCH_BUTTON = "xpath=//aside[@class='widget-area']/section//form/input[@value='Search']";
	
	
}
