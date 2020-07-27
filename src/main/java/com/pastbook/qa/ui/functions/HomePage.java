package com.pastbook.qa.ui.functions;

import com.pastbook.qa.ui.pages.BasePage;
import com.pastbook.qa.ui.pages.HomePagePage;
import com.pastbook.qa.ui.utils.DriverSetupUtils;

public class HomePage {
    private static HomePagePage homepagePage = new HomePagePage();

    private HomePage() {
    }

    public static void openBrowser() {
        DriverSetupUtils.setDriverPath();
        BasePage.loadBrowser();
    }

    public static void navigateToSignInPopUp() {
        homepagePage.clickMenuButton();
        homepagePage.clickSignInButton();
        BasePage.switchToNewWindow();
    }

    public static void navigateToProfilePage() {
        homepagePage.clickMenuButton();
        homepagePage.clickProfileButton();
    }

    public static void signOutFromApplication() {
        homepagePage.clickMenuButton();
        homepagePage.clickSignOutButton();
    }

    public static boolean isStartNowButtonDisplay() {
        return homepagePage.isStartNowButtonDisplay();
    }

    public static boolean isHamburgerButtonDisplay() {
        return homepagePage.isHamburgerButtonDisplay();
    }

    public static String getHeaderText() {
        return homepagePage.getHeaderText();
    }

    public static void navigateToHomePage() {
       BasePage.navigateToHomePage();

    }

    public static void closeWindow() {
        homepagePage.closeWindow();
    }

    public static void closeBrowser() {
        homepagePage.closeBrowser();
    }


}
