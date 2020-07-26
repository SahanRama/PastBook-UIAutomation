package com.pastbook.qa.ui.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePagePage extends BasePage{

    private By buttonHamburger = By.xpath("//*[@class='icon-hamburger-animated']");
    private By buttonSignIn = By.xpath("//a[text()='Sign in']");
    private By buttonProfile = By.xpath("//a[text()='Profile']");
    private By buttonSignOut = By.xpath("//a[text()='Sign out']");
    private By buttonStartNow = By.xpath("//a[text()='Start now']");
    private By header = By.xpath("//h1");


    public void clickMenuButton(){
        waitForElement(buttonHamburger,30);
        driver.findElement(buttonHamburger).click();
    }

    public void clickSignInButton(){
        driver.findElement(buttonSignIn).click();
    }

    public void clickProfileButton(){
        driver.findElement(buttonProfile).click();
    }

    public void clickSignOutButton(){
        waitForElement(buttonSignOut,10);
        driver.findElement(buttonSignOut).click();
    }
    public boolean isStartNowButtonDisplay() {
        waitForElement(buttonStartNow,10);
        return isElementDisplayed(buttonStartNow);
    }
    public boolean isHamburgerButtonDisplay() {
        return isElementDisplayed(buttonHamburger);
    }

    public String getHeaderText(){
        waitForElement(header,10);
        return driver.findElement(header).getText();
    }





}
