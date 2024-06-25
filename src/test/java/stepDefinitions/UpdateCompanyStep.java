package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CompanyDashboardPage;
import pages.UpdateCompanyPage;

import java.time.Duration;

public class UpdateCompanyStep {
    WebDriver driver;
    Duration timeout = Duration.ofSeconds(10);

    void setupChromeDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

//    @Given("User is logged in using admin account")
//    public void userLoggedIn() {
//        setupChromeDriver();
//        driver.get("http://localhost:3000/");
//
//        // Cast WebDriver to JavascriptExecutor
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        // Execute JavaScript directly in the browser context
//        js.executeScript("window.localStorage.setItem('token', '2|oiKe39tjBo7Wdznt0JrILMj7uRv3b5quPBSrNQyOd29e3aef');");
//        js.executeScript("window.localStorage.setItem('user', '{\"google_id\":\"105611254639936463385\",\"id\":1,\"name\":\"Verlino Raya Fajri\",\"email\":\"verlinorayafajri@mail.ugm.ac.id\",\"avatar\":\"https://lh3.googleusercontent.com/a/ACg8ocKJY3OEivwRoUh-XVx2uxn60zwgqATJ6NHgUahwAdAX71O5cQ=s96-c\",\"phone_number\":null,\"is_admin\":1}');");
//    }

//    @And("User navigated to the update company page")
//    public void userInCreateCompanyPage() {
//        driver.get("http://localhost:3000/admin/company-management/edit/1");
//    }
//
//    @When("User update the company with valid details")
//    public void userSubmitCompanyWithValidDetails() {
//        UpdateCompanyPage updateCompanyPage = new UpdateCompanyPage(driver);
//        updateCompanyPage.waitLoading();
//
//        updateCompanyPage.uploadFile("C:\\Users\\marim\\Documents\\Kuliah\\Semester 4\\Praktikum pengujian perangkat lunak\\softlancer_testing\\grab-logo.png");
//        updateCompanyPage.enterCompanyName("Expantrade Update Data");
//        updateCompanyPage.enterCompanyDescription("Expantrade Description");
//        updateCompanyPage.clickSubmit();
//    }
//
//    @Then("User should be redirected to all company page")
//    public void userShouldBeRedirectedToAllCompanyPage() throws InterruptedException {
//        CompanyDashboardPage companyDashboardPage = new CompanyDashboardPage(driver);
//        WebDriverWait wait = new WebDriverWait(driver, timeout);
//        Thread.sleep(5000);
////        WebElement toastContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast-container")));
////        Assert.assertNotNull(toastContainer);
//        Assert.assertEquals("http://localhost:3000/admin/company-management", companyDashboardPage.getUrl());
//        driver.quit();
//    }
}
