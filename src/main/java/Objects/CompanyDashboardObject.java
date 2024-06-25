package Objects;

import org.openqa.selenium.By;

public class CompanyDashboardObject {

    public By getCompanyLogo() {
        return By.xpath("//*[@class='company-logo']");
    }

    public By getDeleteButton(String id) {
        return By.id("btn-delete-" + id);
    }

    public By getConfirmDeleteButton() {
        return By.id("btn-confirm-delete");
    }
}
