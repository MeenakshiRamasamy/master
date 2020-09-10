package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import webelements.FlightPurchasePageElements;

import java.util.List;


public class FlightPurchasePage {

    private WebDriver driver;

    FlightPurchasePageElements elements = new FlightPurchasePageElements();

    public FlightPurchasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, elements);
    }

    public String getPrice() {
        return elements.price.getText();
    }

    public void fillPersonalDetails(List<String> personalDetails) {
        elements.name.sendKeys(personalDetails.get(0));
        elements.address.sendKeys(personalDetails.get(1));
        elements.city.sendKeys(personalDetails.get(2));
        elements.state.sendKeys(personalDetails.get(3));
        elements.zipCode.sendKeys(personalDetails.get(4));
    }

    public void fillPaymentDetails(List<String> paymentDetails){
        Select typeOfCard = new Select(elements.cardType);
        typeOfCard.selectByVisibleText(paymentDetails.get(0));
        elements.creditCardNumber.sendKeys(paymentDetails.get(1));
        elements.creditCardMonth.sendKeys(paymentDetails.get(2));
        elements.creditCardYear.sendKeys(paymentDetails.get(3));
        elements.nameOnCard.sendKeys(paymentDetails.get(4));
    }

    public void submit() {
        elements.submit.click();
    }

}
