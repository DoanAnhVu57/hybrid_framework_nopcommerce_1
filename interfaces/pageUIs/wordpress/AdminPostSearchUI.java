package pageUIs.wordpress;

public class AdminPostSearchUI {

	public static final String ADD_NEW_BUTTON = "xpath=//a[@class='page-title-action' and text()='Add New']";
	public static final String POST_SEARCH_TEXTBOX = "xpath=//input[@id='post-search-input']";
	public static final String POST_SEARCH_BUTTON = "xpath=//input[@id='search-submit']";
	public static final String TABLE_HEADER_INDEX_BY_HEADER_NAME = "xpath=//table[contains(@class,'table-view-list posts')]/thead//th[@id='%s']/preceding-sibling::*";
	public static final String TABLE_ROW_VALUE_BY_HEADER_INDEX = "xpath=//table[contains(@class,'table-view-list posts')]/tbody/tr/*[%s]//a[text()='%s']";
	public static final String ROW_TABLE_DETAIL_BY_TITLE_NAME = "xpath=//table[contains(@class,'table-view-list posts')]/tbody/tr//a[@class='row-title'and text()='%s']";
	public static final String ROW_CHECKBOX_BY_TITLE_NAME = "xpath=//table[contains(@class,'table-view-list posts')]//tbody/tr/th/label[contains(text(),'%s')]/following-sibling::input";
	public static final String ACTION_DROPDOWN = "css=select#bulk-action-selector-top";
	public static final String APPLY_BUTTON = "css=input#doaction";
	public static final String MOVE_TO_TRASH_MESSAGE_DISPLAYED = "xpath=//div[@id='message']/p[text()='1 post moved to the Trash. ']";
	public static final String SEARCH_POST_TITLE_MESSAGE_DISPLAYED = "xpath=//table//tbody//tr/td[text()='%s']";
}
