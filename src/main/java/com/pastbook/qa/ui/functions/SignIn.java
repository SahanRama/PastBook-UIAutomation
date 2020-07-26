package com.pastbook.qa.ui.functions;

import com.pastbook.qa.ui.pages.SignInPage;

public class SignIn {
    private static SignInPage signInPage = new SignInPage();
    private SignIn(){}

    public static void clickUseEmailLink(){
        signInPage.clickUserEmailLink();
    }
    public static void submitNewEmailAndNavigateToMainWindow(String email){
        submitEmail(email);
        signInPage.switchToMainWindow();
    }

    public static void submitUsernameAndPasswordAndLogin(String email, String  password){
        submitEmail(email);
        submitPassword(password);
        signInPage.switchToMainWindow();
    }

    public static void submitEmail(String email){
        clickUseEmailLink();
        signInPage.typeEmail(email);
        signInPage.clickSubmitButton();
    }

    public static void submitPassword(String password){
        signInPage.typePassword(password);
        signInPage.clickSubmitButton();
    }

    public static void loginWithFaceBook(String username, String password){
        signInPage.clickConnectWithFacebookLink();
        signInPage.typeFaceBookEmail(username);
        signInPage.typeFaceBookPassword(password);
        signInPage.clickLoginToFaceBook();
        signInPage.switchToMainWindow();
    }

    public static String getErrorMessage(){
        return signInPage.getErrorMessage();
    }

    public static boolean isFacebookLoginButtonDisplay(){
        return signInPage.isFacebookLoginButtonDisplay();
    }
    public static boolean isUseEmailButtonDisplay(){
        return signInPage.isUseEmailButtonDisplay();
    }
    public static boolean isEmailTextBoxDisplay(){
        return signInPage.isEmailTextBoxDisplay();
    }
    public static boolean isSubmitButtonDisplay(){
        return signInPage.isSubmitButtonDisplay();
    }


}
