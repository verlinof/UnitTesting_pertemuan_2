package pages;

import Objects.UpdateCompanyObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UpdateCompanyPage {
    WebDriver driver;
    WebDriverWait wait;
    UpdateCompanyObject updateCompanyObject;

    public UpdateCompanyPage(WebDriver driver) {
        this.driver = driver;
        Duration timeout = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, timeout);
        updateCompanyObject = new UpdateCompanyObject();
    }

    public void waitLoading() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(updateCompanyObject.getSubmitBtn()));
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void uploadFile(String path) {
        WebElement fileUploadElement = wait.until(ExpectedConditions.visibilityOfElementLocated(updateCompanyObject.getFileUpload()));
        fileUploadElement.sendKeys(path);
    }

    public void enterCompanyName(String name) {
        WebElement companyNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(updateCompanyObject.getCompanyName()));
        companyNameElement.sendKeys(name);
    }

    public void enterCompanyDescription(String description) {
        WebElement companyDescriptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(updateCompanyObject.getCompanyDescription()));
        companyDescriptionElement.sendKeys(description);
    }

    public void clickSubmit() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(updateCompanyObject.getSubmitBtn()));
        submitButton.click();
    }
}
