package pages;

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

    public ApplyPage(WebDriver driver) {
        this.driver = driver;
        Duration timeout = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, timeout); // Initialize WebDriverWait with a timeout of 10 seconds
    }

    By cvUrl = By.id("cvUrl");
    By portofolioUrl = By.id("portofolioUrl");
    By role = By.id("role");
    By submitBtn = By.id("btn-submit");

    public void waitLoading() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitBtn));
    }

    public String getUrl() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    public void enterCv(String cv) {
        WebElement cvElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cvUrl));
        cvElement.sendKeys(cv);
    }

    public void enterPortofolio(String porto) {
        WebElement portofolioElement = wait.until(ExpectedConditions.visibilityOfElementLocated(portofolioUrl));
        portofolioElement.sendKeys(porto);
    }

    public void selectRole() {
        WebElement roleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(role));
        Select select = new Select(roleElement);
        select.getAllSelectedOptions();
        select.selectByIndex(1);
    }

    public void clickSubmit() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        submitButton.click();
    }
}
