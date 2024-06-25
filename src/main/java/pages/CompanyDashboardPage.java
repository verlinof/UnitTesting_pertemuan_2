package pages;

import Objects.CompanyDashboardObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompanyDashboardPage {
    WebDriver driver;
    WebDriverWait wait;
    CompanyDashboardObject companyDashboardObject;

    public CompanyDashboardPage(WebDriver driver) {
        this.driver = driver;
        Duration timeout = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, timeout);
        companyDashboardObject = new CompanyDashboardObject();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void waitLoading() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(companyDashboardObject.getCompanyLogo()));
    }

    public void clickDeleteButton(String id) {
        WebElement deleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(companyDashboardObject.getDeleteButton(id)));
        deleteButton.click();
    }

    public void clickConfirmDeleteButton() {
        WebElement confirmDeleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(companyDashboardObject.getConfirmDeleteButton()));
        confirmDeleteButton.click();
    }


}
