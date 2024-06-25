package pages;

import Objects.CreateCompanyObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateCompanyPage {
    WebDriver driver;
    WebDriverWait wait;
    CreateCompanyObject createCompanyObject;

    public CreateCompanyPage(WebDriver driver) {
        this.driver = driver;
        Duration timeout = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, timeout); // Initialize WebDriverWait with a timeout of 10 seconds
        createCompanyObject = new CreateCompanyObject();
    }

    public void waitLoading() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createCompanyObject.getSubmitBtn()));
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void uploadFile(String path) {
        WebElement fileUploadElement = wait.until(ExpectedConditions.visibilityOfElementLocated(createCompanyObject.getFileUpload()));
        fileUploadElement.sendKeys(path);
    }

    public void enterCompanyName(String name) {
        WebElement companyNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(createCompanyObject.getCompanyName()));
        companyNameElement.sendKeys(name);
    }

    public void enterCompanyDescription(String description) {
        WebElement companyDescriptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(createCompanyObject.getCompanyDescription()));
        companyDescriptionElement.sendKeys(description);
    }

    public void clickSubmit() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(createCompanyObject.getSubmitBtn()));
        submitButton.click();
    }
}
