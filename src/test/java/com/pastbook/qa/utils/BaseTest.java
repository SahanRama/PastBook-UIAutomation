package com.pastbook.qa.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pastbook.qa.ui.functions.HomePage;
import com.pastbook.qa.ui.functions.utils.Utils;
import com.pastbook.qa.ui.utils.LoggerUtil;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;


public class BaseTest {
    protected SoftAssert softAssert;
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest test;
    protected String email;

    @BeforeGroups("EmailGenerate")
    public void emailGenerate() {
        this.email = Utils.generateEmail();
    }

    @BeforeClass
    public void openHomePage() {
        HomePage.openBrowser();
    }


    @BeforeMethod
    public void navigateToHomePage() {
        HomePage.navigateToHomePage();
    }

    @BeforeMethod()
    public void initializeSoftAssert() {
        this.softAssert = new SoftAssert();
    }

    @AfterClass
    public void closeBrowser() {
        HomePage.closeBrowser();
    }


    @BeforeClass(alwaysRun = true)
    public void initiateReport(ITestContext ctx) {
        String testClassName = this.getClass().getName().split("tests.")[0].split("\\.")[this.getClass().getName().split("tests.")[0].split("\\.").length - 1];
        // htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output" + ctx.getCurrentXmlTest().getName().toUpperCase() + ".html");
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + testClassName + ".html");
        htmlReporter.config().setDocumentTitle("PastBook Test Report : " + ctx.getCurrentXmlTest().getName().toUpperCase() + " suite");
        htmlReporter.config().setReportName(ctx.getCurrentXmlTest().getName().toUpperCase() + " Testing");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        String testClassName = this.getClass().getName().split("tests.")[0].split("\\.")[this.getClass().getName().split("tests.")[0].split("\\.").length - 1];
        LoggerUtil.log("============ Test Class : " + testClassName + " ============");
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method) {
        LoggerUtil.log("----------- Test Method :" + method.getName() + " -----------");
        test = extent.createTest(method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
                LoggerUtil.log("====== TEST PASSED =====");
                break;
            case ITestResult.FAILURE:
                test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());
                LoggerUtil.log("====== TEST FAILED =====");
                break;
            case ITestResult.SKIP:
                test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
                LoggerUtil.log("====== TEST SKIPPED =====");
                break;
            default:
                throw new RuntimeException("====== Invalid status ======");
        }
    }

    @AfterClass
    public void endReport() {
        extent.flush();
    }
}
