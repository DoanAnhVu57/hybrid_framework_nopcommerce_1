package pageUIs.wordpress;

public class UserPostDetailUI {

	public static final String POST_TITLE_TEXT = "xpath=//article//h1[text()='%s']";
	public static final String POST_CURRENT_DATE_TEXT_BY_POSR_TITLE = "xpath=//article//header//h1[text()='%s']//following-sibling::div//time[text()='%s']";
	public static final String POST_BODY_TEXT = "xpath=//article//div//p[text()='%s']";
	public static final String POST_AUTHOR_TEXT = "xpath=//article//header//div//a[text()='%s']";
	
}
