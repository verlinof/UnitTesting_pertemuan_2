package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateCompanyPage {
    WebDriver driver;
    WebDriverWait wait;

    public CreateCompanyPage(WebDriver driver) {
        this.driver = driver;
        Duration timeout = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, timeout); // Initialize WebDriverWait with a timeout of 10 seconds
    }

    By fileUpload = By.id("file-upload");
    By companyName = By.id("company-name");
    By companyDescription = By.id("company-description");
    By submitBtn = By.id("btn-submit");

    public void waitLoading() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitBtn));
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void uploadFile(String path) {
        WebElement fileUploadElement = wait.until(ExpectedConditions.visibilityOfElementLocated(fileUpload));
        fileUploadElement.sendKeys(path);
    }

    public void enterCompanyName(String name) {
        WebElement companyNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(companyName));
        companyNameElement.sendKeys(name);
    }

    public void enterCompanyDescription(String description) {
        WebElement companyDescriptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(companyDescription));
        companyDescriptionElement.sendKeys(description);
    }

    public void clickSubmit() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        submitButton.click();
    }
}
