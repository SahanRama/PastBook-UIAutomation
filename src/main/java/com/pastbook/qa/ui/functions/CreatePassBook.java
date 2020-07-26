package com.pastbook.qa.ui.functions;

import com.pastbook.qa.ui.pages.CreatePassBookPage;

public class CreatePassBook {
    private static CreatePassBookPage createPassBookPage = new CreatePassBookPage();

    private CreatePassBook() {
    }

    public static String getNewToTheApplicationMessage() {
        return createPassBookPage.getSuccessMessage();
    }
    public static String getHeaderText() {
        return createPassBookPage.getHeaderText();
    }

    public static void createAPassBook(String title) {
        createPassBookPage.typeTitle(title);
        createPassBookPage.clickCreateButton();
    }

    public static boolean isTitleTextBoxDisplayed(){
       return createPassBookPage.isTitleTextBoxDisplayed();
    }

    public static boolean isCreateButtonDisplayed(){
       return createPassBookPage.isCreateButtonDisplayed();
    }

}
