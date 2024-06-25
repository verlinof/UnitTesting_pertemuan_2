package pages;

import Objects.ApplyObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplyPage {
    WebDriver driver;
    WebDriverWait wait;
    ApplyObject applyObject;

    public ApplyPage(WebDriver driver) {
        this.driver = driver;
        Duration timeout = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, timeout); // Initialize WebDriverWait with a timeout of 10 seconds
        applyObject = new ApplyObject();
    }

    By cvUrl = By.id("cvUrl");
    By portofolioUrl = By.id("portofolioUrl");
    By role = By.id("role");
    By submitBtn = By.id("btn-submit");

    public void waitLoading() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(applyObject.getSubmitBtn()));
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void enterCv(String cv) {
        WebElement cvElement = wait.until(ExpectedConditions.visibilityOfElementLocated(applyObject.getCvUrl()));
        cvElement.sendKeys(cv);
    }

    public void enterPortofolio(String porto) {
        WebElement portofolioElement = wait.until(ExpectedConditions.visibilityOfElementLocated(applyObject.getPortofolioUrl()));
        portofolioElement.sendKeys(porto);
    }

    public void selectRole(By id) {
        WebElement roleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(applyObject.getRole()));
        roleElement.click();

        WebElement selectItem = wait.until(ExpectedConditions.visibilityOfElementLocated(id));
        selectItem.click();
    }

    public void clickSubmit() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(applyObject.getSubmitBtn()));
        submitButton.click();
    }
}
