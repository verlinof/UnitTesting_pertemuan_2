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
import pages.ApplyPage;
import pages.HomePage;

import java.time.Duration;


public class ApplyJobSteps {
    WebDriver driver;
    Duration timeout = Duration.ofSeconds(5);
    void setupChromeDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("User is logged in")
    public void userLogedIn() {
        setupChromeDriver();
        driver.get("http://localhost:3000/");

        // Cast WebDriver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Execute JavaScript directly in the browser context
        js.executeScript("window.localStorage.setItem('token', '2|oiKe39tjBo7Wdznt0JrILMj7uRv3b5quPBSrNQyOd29e3aef');");
        js.executeScript("window.localStorage.setItem('user', '{\"google_id\":\"105611254639936463385\",\"id\":1,\"name\":\"Verlino Raya Fajri\",\"email\":\"verlinorayafajri@mail.ugm.ac.id\",\"avatar\":\"https://lh3.googleusercontent.com/a/ACg8ocKJY3OEivwRoUh-XVx2uxn60zwgqATJ6NHgUahwAdAX71O5cQ=s96-c\",\"phone_number\":null,\"is_admin\":1}');");
    }


    @And("User navigated to the application page")
    public void userInApplyJobPage() {
        driver.get("http://localhost:3000/apply-job/2/apply");
    }

    @When("User submit the application form with valid details")
    public void userSubmitApplicationWithValidDetails() {
        ApplyPage applyPage = new ApplyPage(driver);

        applyPage.waitLoading();

        applyPage.enterPortofolio("https://www.verlinofajri.xyz/");
        applyPage.enterCv("https://www.verlinofajri.xyz/");
        By id = By.id("7");
        applyPage.selectRole(id);

        applyPage.clickSubmit();
    }

    @Then("User should see a success message Success Applying project")
    public void successMessage() {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement toastContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast-container")));
        Assert.assertNotNull(toastContainer);
        HomePage homePage = new HomePage(driver);
        driver.quit();
    }

    @When("User submit the application form with invalid details")
    public void user_submit_the_application_form_with_invalid_details() {
        // Write code here that turns the phrase above into concrete actions
        ApplyPage applyPage = new ApplyPage(driver);

        applyPage.waitLoading();

        applyPage.enterPortofolio("https://www.verlinofajri.xyz/");
        applyPage.enterCv("https://www.verlinofajri.xyz/");

        applyPage.clickSubmit();
    }

    @Then("User should see a error message Please fill all the fields")
    public void user_should_see_a_error_message_please_fill_all_the_fields() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement toastContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast-container")));
        Assert.assertTrue(toastContainer.getText().contains("Please fill all the fields"));
        driver.quit();
        throw new io.cucumber.java.PendingException();
    }
}
