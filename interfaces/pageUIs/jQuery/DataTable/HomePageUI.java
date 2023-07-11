package pageUIs.jQuery.DataTable;

public class HomePageUI {

	public static final String PAGINATION_PAGE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL= "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String PAGINATION_PAGE_BY_NUMBER_ACTIVE= "xpath=//li[@class='qgrd-pagination-page']/a[@class='qgrd-pagination-page-link active'and text()='%s']";
	public static final String TOTAL_PAGINATION = "xpath=//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page']";
	public static final String PAGINATION_PAGE_INDEX = "xpath=//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page'][%s]/a";
	public static final String ALL_ROW_EACH_PAGE = "xpath=//tbody/tr";

	
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/th[text()='%s']/preceding-sibling::th"; 
	public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input"; 
	
	//Select
	public static final String DROP_DOWN_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr['%s']/td['%s']//select"; 
	//Check box
	public static final String CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]//input[@type='checkbox']"; 


	public static final String LOAD_DATA_BUTTON = "xpath=//button[@id='load']";
	
	 
	public static final String ICON_NAME_BY_NUMBER = "xpath=//tbody/tr[%s]//button[@title='%s']";
	
	

}
