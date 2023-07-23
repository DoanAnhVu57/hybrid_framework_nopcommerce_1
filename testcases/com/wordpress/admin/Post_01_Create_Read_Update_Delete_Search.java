package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.wordpress.AdminDashboardPO;
import pageObject.wordpress.AdminLoginPO;
import pageObject.wordpress.AdminPostAddNewPO;
import pageObject.wordpress.AdminPostSearchPO;
import pageObject.wordpress.PageGeneartorManager;
import pageObject.wordpress.UserHomePO;
import pageObject.wordpress.UserPostDetailPO;
import pageObject.wordpress.UserSearchPostPO;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	private WebDriver driver;
	private AdminLoginPO adminLoginPage;
	private AdminDashboardPO adminDashboardPage;
	private AdminPostAddNewPO adminPostAddNewPage;
	private AdminPostSearchPO adminPostSearchPage;
	private UserHomePO userHomePage;
	private UserPostDetailPO userPostDetail;
	private UserSearchPostPO userSearchPostPage;
	int randomNumber = generateFakeNumber();
	String PostTitle = "Live Coding Title"+ randomNumber;
	String PostBody = "Live Coding Body"+randomNumber;
	String EditPostTitle = "Edit Title"+ randomNumber;
	String EditPostBody = "Edit Body"+randomNumber;
	
	String NothingFoundMessage ="Nothing Found";
	String AdminUserName = "automationfc";
	String AdminPassword = "automationfc";
	String authorName = "automationfc";
	String searchPostUrl;
	String adminUrl, endUserUrl;
	String currentDay = getCurrentDay();

	@Parameters({"browser", "urlAdmin", "urlUser"})
	@BeforeClass
	public void beforeClass(String browserName , String adminUrl, String endUserUrl) {
		log.info("Pre-Condition - Step 01: Open Browser and Admin Site");
		this.adminUrl = adminUrl;
		this.endUserUrl = endUserUrl;
		driver = getBrowserDriver(browserName, this.adminUrl);
		adminLoginPage = PageGeneartorManager.getadminLoginPage(driver);
	
		log.info("Pre-Condition - Step 02: Enter to User Name with value: " + AdminUserName);
		adminLoginPage.enterToUserNameTextbox(AdminUserName);
		
		log.info("Pre-Condition - Step 03: Enter to Password with value: " + AdminPassword);
		adminLoginPage.enterToPasswordTextbox(AdminPassword);
		
		log.info("Pre-Condition - Step 04: Click to Log In button");
		adminDashboardPage = adminLoginPage.clickToLogInButton();
		
	}

	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create-Posts - Step 01: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();
		
		log.info("Create-Posts - Step 02:Get 'Search Post' page Url");
		searchPostUrl = adminPostSearchPage.getPageUrl(driver);
		
		log.info("Create-Posts - Step 03: Click to 'Add New'button");
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();
		
		log.info("Create-Posts - Step 04: Enter to post title");
		adminPostAddNewPage.enterToPostTitle(PostTitle);
		
		log.info("Create-Posts - Step 05: Enter to body");
		adminPostAddNewPage.enterToPostBody(PostBody);
		
		log.info("Create-Posts - Step 06: Click to 'Publish' button");
		adminPostAddNewPage.clickToPublishButton();
		
		log.info("Create-Posts - Step 07: Verify message 'Post Published' isDisplayed");
		verifyTrue(adminPostAddNewPage.isPostPublishOrUpdatedMessageDisplayed("Post published."));
	}

	@Test
	public void Post_02_Search_View_Post() {
		log.info("Search-Posts - Step 01: Open 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostUrl(searchPostUrl);

		log.info("Search-Posts - Step 02: Enter 'Search' textbox");
		adminPostSearchPage.enterToSearchTextbox(PostTitle);
		
		log.info("Search-Posts - Step 03: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostsButton();
		
		log.info("Search-Posts - Step 04: Verify Search table contains '"+ PostTitle + " '");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title",PostTitle));
		
		log.info("Search-Posts - Step 05: Verify Search table contains"+ authorName);
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author",authorName));
		
		log.info("Search-Posts - Step 06: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);
		
		log.info("Search-Posts - Step 07: Verify Post info Displayed at Home Page");
		verifyTrue(userHomePage.isPostInforDisplayedWithPostTitle(PostTitle));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostBody(PostBody));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostAuthor(authorName));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostCurrentDay(PostTitle,currentDay));
		
		log.info("Search-Posts - Step 08: Click to Post title");
		userPostDetail = userHomePage.clickToPostTitle(PostTitle);
		
		log.info("Search-Posts - Step 09: Verify Post info Displayed at Post Detail page");
		verifyTrue(userPostDetail.isPostInforDisplayedWithPostTitle(PostTitle));
		verifyTrue(userPostDetail.isPostInforDisplayedWithPostBody(PostBody));
		verifyTrue(userPostDetail.isPostInforDisplayedWithPostAuthor(authorName));
		verifyTrue(userPostDetail.isPostInforDisplayedWithPostCurrentDay(PostTitle,currentDay));
	}
	
	@Test
	public void Post_03_Edit_Post() {
		log.info("Edit-Post - Step 01: Open AdminUrl site");
		adminDashboardPage  = userPostDetail.openAdminUrlSite(driver, this.adminUrl);
		
		log.info("Edit - Step 02: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();
		
		log.info("Edit - Step 03: Enter 'Search' textbox");
		adminPostSearchPage.enterToSearchTextbox(PostTitle);
		
		log.info("Edit - Step 04: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostsButton();
		
		log.info("Edit - Step 05: Click to Post Title Link and Navigate to Edit Post Page");
		adminPostAddNewPage = adminPostSearchPage.clickToPostTitleLink(PostTitle);
		
		log.info("Edit-Posts - Step 06: Enter to post title");
		adminPostAddNewPage.enterToPostTitle(EditPostTitle);
		
		log.info("Edit-Posts - Step 07: Enter to body");
		adminPostAddNewPage.enterToEditPostBody(EditPostBody);
		
		log.info("Edit-Posts - Step 08: Click to 'Update' button");
		adminPostAddNewPage.clickToUpdateButton();
		
		log.info("Edit-Posts - Step 09: Verify message 'Post Updated' isDisplayed");
		verifyTrue(adminPostAddNewPage.isPostPublishOrUpdatedMessageDisplayed("Post updated."));
		
		log.info("Edit-Posts - Step 10: Open 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostUrl(searchPostUrl);

		log.info("Edit-Posts - Step 11: Enter 'Search' textbox");
		adminPostSearchPage.enterToSearchTextbox(EditPostTitle);
		
		log.info("Edit-Posts - Step 12: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostsButton();
		
		log.info("Edit-Posts - Step 13: Verify Search table contains '"+ EditPostTitle + " '");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title",EditPostTitle));
		
		log.info("Edit-Posts - Step 14: Verify Search table contains"+ authorName);
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author",authorName));
		
		log.info("Edit-Posts - Step 15: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);
		
		log.info("Edit-Posts - Step 16: Verify Post info Displayed at Home Page");
		verifyTrue(userHomePage.isPostInforDisplayedWithPostTitle(EditPostTitle));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostBody(EditPostBody));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostAuthor(authorName));
		verifyTrue(userHomePage.isPostInforDisplayedWithPostCurrentDay(EditPostTitle,currentDay));
		
		log.info("Edit-Posts - Step 17: Click to Post title");
		userPostDetail = userHomePage.clickToPostTitle(EditPostTitle);
		
		log.info("Edit-Posts - Step 18: Verify Post info Displayed at Post Detail page");
		verifyTrue(userPostDetail.isPostInforDisplayedWithPostTitle(EditPostTitle));
		verifyTrue(userPostDetail.isPostInforDisplayedWithPostBody(EditPostBody));
		verifyTrue(userPostDetail.isPostInforDisplayedWithPostAuthor(authorName));
		verifyTrue(userPostDetail.isPostInforDisplayedWithPostCurrentDay(EditPostTitle,currentDay));
	}
	
	@Test
	public void Post_04_Delete_Post() {
		log.info("Delete-Post - Step 01: Open AdminUrl site");
		adminDashboardPage  = userPostDetail.openAdminUrlSite(driver, this.adminUrl);
		
		log.info("Delete-Post - Step 02: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();
		
		log.info("Delete-Post - Step 03: Enter 'Search' textbox");
		adminPostSearchPage.enterToSearchTextbox(EditPostTitle);
		
		log.info("Delete-Post - Step 04: Click to 'Search Posts' button");
		adminPostSearchPage.clickToSearchPostsButton();
		
		log.info("Delete-Post - Step 05: Select Post Detail checkbox");
		adminPostSearchPage.selectPostCheckboxByTitle(EditPostTitle);
		
		log.info("Delete-Post - Step 06: Select 'Move To Trash' item in Dropdow");
		adminPostSearchPage.selectTextItemInActionDropdow("Move to Trash");
		
		log.info("Delete-Post - Step 07: Click to Apply button");
		adminPostSearchPage.clickToApplyButton();
		
		log.info("Delete-Post - Step 08: Verify Message '1 post moved on the trash' isDisplay");
		verifyTrue(adminPostSearchPage.isMoveToTrashMessageDisplayed("1 post moved to the Trash. "));
		
		log.info("Delete-Post - Step 09: Enter to Search Textbox");
		adminPostSearchPage.enterToSearchTextbox(EditPostTitle);
		
		log.info("Delete-Post - Step 10: Click to Search Posts button");
		adminPostSearchPage.clickToSearchPostsButton();
		
		log.info("Delete-Post - Step 11: Verify Message 'No posts found. ' isDisplay");
		verifyTrue(adminPostSearchPage.isNoPostsFoundMessageDispayed("No posts found."));
		
		log.info("Delete-Post - Step 12: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);
		
		log.info("Delete-Post - Step 13: Verify Post Title Undisplay");
		verifyTrue(userHomePage.isPostTitleUndisplayed(EditPostTitle));
		
		log.info("Delete-Post - Step 14: Enter Post Title to Search Textbox");
		userHomePage.enterToUserSearchTextbox(EditPostTitle);
		
		log.info("Delete-Post - Step 15: Click to Search Button");
		userSearchPostPage = userHomePage.clickToUserSeachButton();
		
		log.info("Delete-Post - Step 16: Verify message 'Nothing Found' isdisplayed");
		verifyTrue(userSearchPostPage.isNothingFoundMessageDisplayed(NothingFoundMessage));
		
		
		
		
	}
	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		closeBrowserDriver();

	}

}