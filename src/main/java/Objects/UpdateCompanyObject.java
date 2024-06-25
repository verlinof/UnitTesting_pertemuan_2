package Objects;

import org.openqa.selenium.By;

public class UpdateCompanyObject {
    public By getFileUpload() {
        return By.id("file-upload");
    }

    public By getCompanyName() {
        return By.id("company-name");
    }

    public By getCompanyDescription() {
        return By.id("company-description");
    }

    public By getSubmitBtn() {
        return By.id("btn-submit");
    }
}
