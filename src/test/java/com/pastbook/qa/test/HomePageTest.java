package com.pastbook.qa.test;

import com.pastbook.qa.ui.functions.HomePage;
import com.pastbook.qa.utils.BaseTest;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest {

    @Test
    public void verifyUserSuccessfullyNavigatesToHomePage() {
        softAssert.assertTrue(HomePage.isHamburgerButtonDisplay(), "Menu Hamburger Button is not displayed");
        softAssert.assertTrue(HomePage.isStartNowButtonDisplay(), "Start Now Button is not displayed");
        softAssert.assertTrue(HomePage.getHeaderText().contains("Create beautiful photo albums,"), "Header Text mismatch with homepage header");
        softAssert.assertAll();


    }
}
