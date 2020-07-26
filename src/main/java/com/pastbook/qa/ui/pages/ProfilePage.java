package com.pastbook.qa.ui.pages;

import org.openqa.selenium.By;

public class ProfilePage extends HomePagePage {
    private By lblHeader = By.xpath("//h2");
    private By txtBoxFirstName = By.xpath("//input[@name='user[firstname]']");
    private By txtLastName = By.xpath("//input[@name='user[lastname]']");
    private By btnSaveChanges = By.xpath("//button[text()='Save changes']");
    private By saveSuccessMessage = By.xpath("//div[@class='alert alert-dismissable alert-success']");
    private By linkUpdatePassword = By.xpath("//a[text()='Update your password »']");

    public String getHeader(){
        waitForElement(lblHeader,10);
        return driver.findElement(lblHeader).getText();
    }
    public void typeFirstName(String fName){
        waitForElement(txtBoxFirstName,10);
        driver.findElement(txtBoxFirstName).sendKeys(fName);
    }

    public void typeLastName(String lName){
        driver.findElement(txtLastName).sendKeys(lName);
    }

    public void clickSaveChangesButton(){
        driver.findElement(btnSaveChanges).click();
    }

    public String getProfileUpdateSuccessMessage(){
        waitForElement(saveSuccessMessage,8);
        return driver.findElement(saveSuccessMessage).getText();
    }

    public void clickUpdatePassword(){
        waitForElement(linkUpdatePassword,8);
        driver.findElement(linkUpdatePassword).click();
    }
}
