package com.pastbook.qa.test;

import com.pastbook.qa.ui.common.Constants;
import com.pastbook.qa.ui.functions.HomePage;
import com.pastbook.qa.ui.functions.Preview;
import com.pastbook.qa.ui.functions.SignIn;
import com.pastbook.qa.utils.BaseTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class PreviewTest extends BaseTest {

    @BeforeGroups("LoginSuccessfully")
    public void userSuccessfullyLoggedIn(){
        HomePage.navigateToSignInPopUp();
        SignIn.submitUsernameAndPasswordAndLogin("Johny449@mailinator.com", Constants.PAST_BOOK_PASSWORD);
    }

    @Test(groups ="LoginSuccessfully" )
    public void verifyUserNavigateToThePreviewPageAfterLogin(){
        softAssert.assertTrue(Preview.verifyOpenYouBookButtonIsDisplayed(), "Open Your Book Button is not displayed");
        softAssert.assertTrue(Preview.getWelcomeMessage().contains("Welcome back!"), "Welcome message is mismatch ");
        softAssert.assertEquals(Preview.getTitleOfPastBook(), Constants.PAST_BOOK_TITLE, "Past Book Title Mismatch ");
        softAssert.assertAll();

    }
}
