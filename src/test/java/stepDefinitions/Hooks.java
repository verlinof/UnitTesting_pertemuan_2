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
    public static ExtentTest test;

    @BeforeAll
    static void setUpDriver(String testTitle) {
        extent = ExtentReportManagement.getInstance(testTitle);
        if(driver != null) {
            return;
        }
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        test = extent.createTest(testTitle);
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

        test.log(Status.INFO, "Browser closed");
        extent.flush();
    }
}
