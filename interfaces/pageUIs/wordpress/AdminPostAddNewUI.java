package pageUIs.wordpress;

public class AdminPostAddNewUI {

	public static final String ADD_TITLE_TEXTBOX = "css=h1.wp-block-post-title";
	public static final String ADD_BODY_BUTTON = "xpath=//p[@class='block-editor-default-block-appender__content']";
	public static final String ADD_BODY_TEXTBOX = "css=p.block-editor-rich-text__editable";
	public static final String PUBLISH_BUTTON = "xpath=//button[@type='button' and text()='Publish']";
	public static final String UPDATE_BUTTON = "xpath=//button[@type='button' and text()='Update']";
	public static final String POST_PUBLISHED_OR_UPDATED_MESSAGE = "xpath=//div[@class='components-snackbar__content' and text()='%s']";
}
