package com.pastbook.qa.ui.pages;

import org.openqa.selenium.By;

public class PasswordPage extends BasePage{
    private By lblHeader = By.xpath("//h2");
    private By txtBoxNewPassword = By.xpath("//input[@name='user[password]']");
    private By txtBoxConfirmPassword = By.xpath("//input[@name='user[passwordConfirm]']");
    private By btnSavePassword = By.xpath("//button[text()='Save Password']");
    private By lnkBackToYourBook = By.xpath("//button[text()='‹ Back to your book']");
    private By saveSuccessMessage = By.xpath("//div[@class='alert alert-dismissable alert-success']");

    public String getHeaderText(){
        waitForElement(lblHeader,10);
        return driver.findElement(lblHeader).getText();
    }

    public void typeNewPassword(String newPassword){
        waitForElement(txtBoxNewPassword,10);
        driver.findElement(txtBoxNewPassword).sendKeys(newPassword);
    }

    public void typeConfirmPassword(String confirmPassword){
        driver.findElement(txtBoxConfirmPassword).sendKeys(confirmPassword);
    }

    public void clickSavePasswordButton(){
        driver.findElement(btnSavePassword).click();
    }

    public String getChangePasswordSuccessMessage(){
        waitForElement(saveSuccessMessage,10);
        return driver.findElement(saveSuccessMessage).getText();

    }
    public void clickBackToBookButton(){
        waitForElement(lnkBackToYourBook,10);
        driver.findElement(lnkBackToYourBook).click();
    }

}
