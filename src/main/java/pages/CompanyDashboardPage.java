package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompanyDashboardPage {
    WebDriver driver;
    WebDriverWait wait;

    public CompanyDashboardPage(WebDriver driver) {
        this.driver = driver;
        Duration timeout = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, timeout);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    By companyLogo = By.xpath("//*[@class='company-logo']");

    public void waitLoading() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(companyLogo));
    }
}
