package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import webelements.ConfirmationPageElements;

public class ConfirmationPage {

    private WebDriver driver;

    ConfirmationPageElements elements = new ConfirmationPageElements();

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, elements);
    }

    public boolean verifyConfirmationId() {
        return !elements.confirmationId.getText().equals("");
    }

}
