package webelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPageElements {

    @FindBy(xpath = "//tr//td[contains(text(), 'Id')]/following-sibling::td[1]")
    public WebElement confirmationId;
}
