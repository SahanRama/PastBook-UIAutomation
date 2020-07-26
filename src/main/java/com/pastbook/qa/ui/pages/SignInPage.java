package com.pastbook.qa.ui.pages;

import org.openqa.selenium.By;

public class SignInPage extends HomePagePage {
    private By linkUseEmail = By.xpath("//a[text()='or use email »']");
    private By linkConnectFaceBook = By.xpath("//a[text()='Connect with Facebook']");
    private By txtBoxEmail = By.xpath("//input[@name='email']");
    private By txtBoxPassword = By.xpath("//input[@name='password']");
    private By buttonSubmit = By.xpath("//button[@type='submit']");
    private By lblErrorMessage = By.xpath("//*[@id='message-wrong-password']");
    private By txtBoxfacebookEmail = By.xpath("//*[@id='email']");
    private By txtBoxfacebookPassword = By.xpath("//*[@id='pass']");
    private By btnFBLogin = By.xpath("//*[@id='loginbutton']");

    public void clickUserEmailLink() {
        driver.findElement(linkUseEmail).click();
    }

    public void typeEmail(String email) {
        waitForElement(txtBoxEmail, 10);
        driver.findElement(txtBoxEmail).sendKeys(email);
    }

    public void typePassword(String password) {
        waitForElement(txtBoxPassword, 15);
        driver.findElement(txtBoxPassword).sendKeys(password);
    }

    public void clickSubmitButton() {
        waitForElement(buttonSubmit, 15);
        driver.findElement(buttonSubmit).click();
        waitForSeconds(3);
    }

    public void clickConnectWithFacebookLink(){
        waitForElement(linkConnectFaceBook,10);
        driver.findElement(linkConnectFaceBook).click();
    }

    public void typeFaceBookEmail(String fbEmail){
        waitForElement(txtBoxfacebookEmail, 15);
        driver.findElement(txtBoxfacebookEmail).sendKeys(fbEmail);
    }
    public void typeFaceBookPassword(String fbPassword){
        waitForElement(txtBoxfacebookPassword, 15);
        driver.findElement(txtBoxfacebookPassword).sendKeys(fbPassword);
    }
    public void clickLoginToFaceBook(){
        waitForElement(btnFBLogin,10);
        driver.findElement(btnFBLogin).click();
    }

    public String getErrorMessage() {
        return driver.findElement(lblErrorMessage).getText();
    }

    public boolean isFacebookLoginButtonDisplay() {
        return isElementDisplayed(linkConnectFaceBook);
    }
    public boolean isUseEmailButtonDisplay() {
        return isElementDisplayed(linkUseEmail);
    }
    public boolean isEmailTextBoxDisplay() {
        return isElementDisplayed(txtBoxEmail);
    }
    public boolean isSubmitButtonDisplay() {
        return isElementDisplayed(txtBoxEmail);
    }



}
