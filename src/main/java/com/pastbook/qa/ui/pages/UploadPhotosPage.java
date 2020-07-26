package com.pastbook.qa.ui.pages;

import com.pastbook.qa.ui.utils.LoggerUtil;
import org.openqa.selenium.By;

import java.io.IOException;

public class UploadPhotosPage extends HomePagePage {
    private By headerText = By.xpath("//h1/text()");
    private By btnUploadYourPictures = By.xpath("//a[@class='btn btn-lg btn-primary']");
    private By btnSelectFilesToUpload = By.xpath("//div[@class='fsp-drop-area__title fsp-text__title']");
    private By btnUploadPopUp = By.xpath("//span[@title='Upload']");
    private By imgTwoPerPage = By.xpath("//img[@title='Two per page']");
    private By btnContinue = By.xpath("//button[@style='display: inline-block;']");
    private By lblMyDevices = By.xpath("//span[text()=' My Device ']");

    public void clickUploadYourPhotosButton() {
        waitForElement(btnUploadYourPictures, 5);
        driver.findElement(btnUploadYourPictures).click();
    }

    public String getHeaderText() {
        waitForElement(headerText, 5);
        return driver.findElement(headerText).getText();
    }

    public void clickSelectFilesToUploadButton() {
        waitForElement(lblMyDevices, 10);
        driver.findElement(btnSelectFilesToUpload).click();
        waitForSeconds(3);

        String currentDirectory = System.getProperty("user.dir");
        try {
            Process upload = Runtime.getRuntime().exec("src/main/resources/scripts/FileUploadScript.exe" + " " + currentDirectory + "\\src\\main\\resources\\uploads\\");
            upload.waitFor();

        } catch (IOException | InterruptedException e) {
            LoggerUtil.logERROR("Unable to Read file:", e);
            Thread.currentThread().interrupt();

        }

    }

    public void clickUploadFilesButtonInPopup() {
        waitForElement(btnUploadPopUp, 10);
        driver.findElement(btnUploadPopUp).click();
        waitForSeconds(20);
    }

    public void clickOnTwoImagesToAppearButtonAndContinue() {
        waitForElement(imgTwoPerPage, 60);
        driver.findElement(imgTwoPerPage).click();
        driver.findElement(btnContinue).click();

    }

}
