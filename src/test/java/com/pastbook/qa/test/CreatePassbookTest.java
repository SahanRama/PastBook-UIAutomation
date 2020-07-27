package com.pastbook.qa.test;

import com.pastbook.qa.ui.functions.*;
import com.pastbook.qa.utils.BaseTest;
import org.testng.annotations.Test;

public class CreatePassbookTest extends BaseTest {

    @Test(groups = "EmailGenerate")
    public void verifyElementsInTheCreatePastBookPage() {
        HomePage.navigateToSignInPopUp();
        SignIn.submitNewEmailAndNavigateToMainWindow(email);
        softAssert.assertTrue(CreatePassBook.isTitleTextBoxDisplayed(),"Title Text box is not displayed");
        softAssert.assertEquals(CreatePassBook.getHeaderText(),"Create your PastBook in 1 minute!", "Create passbook Header mismatch");
        softAssert.assertTrue(CreatePassBook.isCreateButtonDisplayed(),"Create Button is not displayed");
        softAssert.assertAll();


    }
}
