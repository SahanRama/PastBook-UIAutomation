package com.pastbook.qa.ui.utils;


import com.pastbook.qa.ui.common.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetupUtils {
    private DriverSetupUtils(){}

    public static void setDriverPath() {
        if(Constants.APP_BROWSER.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chrome_driver/chromedriver");
        }else{
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/firefox_driver/geckodriver");
        }
    }


    public static WebDriver getWebDriver(String browserType) {
        WebDriver driver;
        if (browserType.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }

        return driver;
    }
}
