package com.pastbook.qa.ui.functions;

import com.pastbook.qa.ui.pages.ProfilePage;

public class Profile {
    private static ProfilePage profilePage = new ProfilePage();
    private Profile(){}

    public static void changeFirstNameAndLastName(String firstName,String lastName){
        profilePage.typeFirstName(firstName);
        profilePage.typeLastName(lastName);
        profilePage.clickSaveChangesButton();
    }

    public static String  getHeaderText(){
        return profilePage.getHeader();
    }

    public static String getSuccessMessage(){
        return profilePage.getProfileUpdateSuccessMessage();
    }

    public static void navigateToChangePassword(){
        profilePage.clickUpdatePassword();
    }
}
