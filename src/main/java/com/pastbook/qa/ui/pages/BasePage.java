package com.pastbook.qa.ui.pages;

import com.pastbook.qa.ui.common.Constants;
import com.pastbook.qa.ui.utils.DriverSetupUtils;
import com.pastbook.qa.ui.utils.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected static WebDriver driver;
    private static String  mainWindow;

    public static void loadBrowser(){
        driver = DriverSetupUtils.getWebDriver(Constants.APP_BROWSER);
        driver.manage().window().maximize();
    }

    public static void navigateToHomePage(){
        driver.navigate().to(Constants.APP_URL);
    }

    public static void switchToNewWindow(){
        String  currentWindow = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
       mainWindow = currentWindow;
    }

    public void switchToMainWindow(){
        driver.switchTo().window(mainWindow);
    }

    public void closeBrowser(){
        driver.quit();
    }

    public void closeWindow(){
        driver.close();
        driver.switchTo().window(mainWindow);
    }

    public void waitForElement(By locator, int timeout) {
        new WebDriverWait(driver, timeout).until
                (ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForSeconds(int waitTimeInSeconds) {
        try {
            TimeUnit.SECONDS.sleep(waitTimeInSeconds);
        } catch (InterruptedException e) {
            LoggerUtil.logERROR("Interrupted Exception:", e);
            Thread.currentThread().interrupt();
        }
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static boolean isElementDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }

}
