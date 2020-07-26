package com.pastbook.qa.ui.pages;

import org.openqa.selenium.By;

public class CreatePassBookPage extends BasePage {
    private By lblWelcomeMessage = By.xpath("//div[@class='content alert alert-dismissable alert-success']");
    private By headerText = By.xpath("//h1");
    private By txtBoxTitleName =By.xpath("//input[@name='title']");
    private By btnCreate =By.xpath("//*[@id='create-button']");

    public String getSuccessMessage(){
        waitForElement(lblWelcomeMessage,30);
        return driver.findElement(lblWelcomeMessage).getText();
    }
    public String getHeaderText(){
        return driver.findElement(headerText).getText();
    }

    public void typeTitle(String name){
        waitForElement(txtBoxTitleName,30);
        driver.findElement(txtBoxTitleName).sendKeys(name);
    }

    public void clickCreateButton(){
        driver.findElement(btnCreate).click();
    }

     public boolean isTitleTextBoxDisplayed(){
        waitForElement(txtBoxTitleName,15);
        return isElementDisplayed(txtBoxTitleName);
     }
     public boolean isCreateButtonDisplayed(){
         waitForElement(btnCreate,15);
        return isElementDisplayed(btnCreate);
     }


}
