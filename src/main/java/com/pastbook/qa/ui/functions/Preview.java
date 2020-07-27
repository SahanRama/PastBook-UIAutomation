package com.pastbook.qa.ui.functions;

import com.pastbook.qa.ui.pages.PreviewPage;

public class Preview {
    private static PreviewPage previewPage = new PreviewPage();
    private Preview(){}

    public static boolean verifyOpenYouBookButtonIsDisplayed(){
       return previewPage.isOpenYourBookButtonVisible();
    }

    public static String getTitleOfPastBook(){
        return previewPage.getTitleOfThePastBook();
    }

    public static String getWelcomeMessage(){
        return previewPage.getWelcomeMessage();
    }
}
