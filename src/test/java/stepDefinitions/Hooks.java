package stepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest createCompanytest;
    public static ExtentTest updateCompanytest;
    public static ExtentTest deleteCompanytest;
    public static ExtentTest applyJobtest;

    @BeforeAll
    static void setUpDriver(String testTitle) {
        extent = ExtentReportManagement.getInstance(testTitle);
        if(driver != null) {
            return;
        }
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        if(testTitle.equals("Apply Job Test")) {
            applyJobtest = extent.createTest("Apply Job");
        }
        createCompanytest = extent.createTest("Create Company Test");
        updateCompanytest = extent.createTest("Update Company Test");
        deleteCompanytest = extent.createTest("Delete Company Test");
    }

    public static WebDriver getDriver(String testTitle) {
        if(driver == null) {
            setUpDriver(testTitle);
        }
        return driver;
    }

    @AfterAll
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
//        applyJobtest.pass("Browser Closed");
//        createCompanytest.pass("Browser Closed");
//        updateCompanytest.pass("Browser Closed");
//        deleteCompanytest.pass("Browser Closed");

        extent.flush();
    }
}
