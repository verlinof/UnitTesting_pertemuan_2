package stepDefinitions;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CompanyDashboardPage;
import pages.CreateCompanyPage;
import pages.UpdateCompanyPage;

import java.time.Duration;

public class CompanyManagementStep {
    static WebDriver driver;
    Duration timeout = Duration.ofSeconds(10);

    @BeforeClass
    public static void setupChromeDriver() {
        driver = Hooks.getDriver("Company Management");
    }

    @Given("Admin is logged in using admin account")
    public void userLoggedIn() {
        setupChromeDriver();
        driver.get("http://localhost:3000/");

        // Cast WebDriver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Execute JavaScript directly in the browser context
        js.executeScript("window.localStorage.setItem('token', '2|oiKe39tjBo7Wdznt0JrILMj7uRv3b5quPBSrNQyOd29e3aef');");
        js.executeScript("window.localStorage.setItem('user', '{\"google_id\":\"105611254639936463385\",\"id\":1,\"name\":\"Verlino Raya Fajri\",\"email\":\"verlinorayafajri@mail.ugm.ac.id\",\"avatar\":\"https://lh3.googleusercontent.com/a/ACg8ocKJY3OEivwRoUh-XVx2uxn60zwgqATJ6NHgUahwAdAX71O5cQ=s96-c\",\"phone_number\":null,\"is_admin\":1}');");
        Hooks.test.log(Status.INFO, "User logged in using admin account");
    }

    @Given("Admin navigated to the create company page")
    public void userInCreateCompanyPage() {
        driver.get("http://localhost:3000/admin/company-management/add-company");
        Hooks.test.log(Status.INFO, "Admin navigated to the create company page");
    }

    @When("Admin submit the company form with valid details")
    public void userSubmitCompanyWithValidDetails() {
        CreateCompanyPage createCompanyPage = new CreateCompanyPage(driver);

        createCompanyPage.waitLoading();

        createCompanyPage.uploadFile("C:\\Users\\marim\\Documents\\Kuliah\\Semester 4\\Praktikum pengujian perangkat lunak\\softlancer_testing\\expantrade_logo.png");
        createCompanyPage.enterCompanyName("Expantrade");
        createCompanyPage.enterCompanyDescription("Expantrade Description");
        createCompanyPage.clickSubmit();

        Hooks.test.log(Status.INFO, "Admin submit the company form with valid details");
    }

    @Then("Admin should see a success message Success Creating Company")
    public void userShouldSeeASuccessMessageSuccessCreatingCompany() {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement toastContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast-container")));
            Assert.assertNotNull(toastContainer);

            Hooks.test.log(Status.PASS, "The success message exists");
        } catch (AssertionError e) {
            Hooks.test.log(Status.FAIL, "The success message does not exist");
        }
    }

    @Given("Admin navigated to the update company page")
    public void userInUpdateCompanyPage() {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        driver.get("http://localhost:3000/admin/company-management/all-company");
        WebElement editBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit-1")));

        editBtn.click();
        Hooks.test.log(Status.INFO, "Admin navigated to the update company page");
    }

    @When("Admin update the company with valid details")
    public void userUpdateCompanyWithValidDetails() {
        UpdateCompanyPage updateCompanyPage = new UpdateCompanyPage(driver);
        updateCompanyPage.waitLoading();

        updateCompanyPage.uploadFile("C:\\Users\\marim\\Documents\\Kuliah\\Semester 4\\Praktikum pengujian perangkat lunak\\softlancer_testing\\grab-logo.png");
        updateCompanyPage.enterCompanyName("Expantrade Update Data");
        updateCompanyPage.enterCompanyDescription("Expantrade Description");
        updateCompanyPage.clickSubmit();

        Hooks.test.log(Status.INFO, "Admin update the company with valid details");
    }

    @Then("Admin should be redirected to all company page")
    public void userShouldBeRedirectedToAllCompanyPage() throws InterruptedException {
        CompanyDashboardPage companyDashboardPage = new CompanyDashboardPage(driver);
        Thread.sleep(3000);
        try {
           Assert.assertEquals("http://localhost:3000/admin/company-management/all-company", companyDashboardPage.getUrl());
            Hooks.test.log(Status.PASS, "Admin redirected to all company page");
        } catch (AssertionError e) {
            Hooks.test.log(Status.FAIL, "Failed to redirected to all company page");
        }
//        driver.quit();
    }

    @Given("Admin navigated to the all company page")
    public void userNavigatedToTheAllCompanyPage() {
        driver.get("http://localhost:3000/admin/company-management/all-company");
        Hooks.test.log(Status.INFO, "Admin navigated to the all company page");
    }


    @And("Admin click the delete button on company")
    public void userClickTheDeleteButtonOnCompany() {
        CompanyDashboardPage companyDashboardPage = new CompanyDashboardPage(driver);
        companyDashboardPage.clickDeleteButton("15");
        Hooks.test.log(Status.INFO, "Admin click the delete button on company");
    }

    @When("Admin click the confirm delete button")
    public void userClickTheConfirmDeleteButton() {
        CompanyDashboardPage companyDashboardPage = new CompanyDashboardPage(driver);
        companyDashboardPage.clickConfirmDeleteButton();
        Hooks.test.log(Status.INFO, "Admin click the confirm delete button");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
