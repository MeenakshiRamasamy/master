package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import webelements.FlightDetailsPageElements;


public class FlightDetailsPage {

    private WebDriver driver;

    FlightDetailsPageElements elements = new FlightDetailsPageElements();

    public FlightDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, elements);
    }

    public String getHeader() {
        return elements.pageHeader.getText();
    }

    public boolean verifyPopulatedFlightDetails() {
        boolean populated = false;
        for (WebElement row : elements.flightOptions) {
            for(WebElement col : row.findElements(By.tagName("td"))) {
                populated = !col.getText().equals("");
            }
        }
        return populated;
    }

    public String chooseFlightByLowestPrice() {
        int index = 0;
        for (int i = 0; i < (elements.prices.size() - 1); i++) {
            index = (Float.parseFloat(elements.prices.get(index).getText().substring(1)) <
                    Float.parseFloat(elements.prices.get(i+1).getText().substring(1))) ? index : i+1;
        }
        String price = elements.prices.get(index).getText().substring(1);
        elements.chooseFlightOption.get(index).click();
        return price;
    }

}
