package webelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FlightDetailsPageElements {

    @FindBy(tagName = "h3")
    public WebElement pageHeader;

    @FindBy(xpath = "//input[@type='submit']")
    public List<WebElement> chooseFlightOption;

    @FindBy(xpath = "//table//tbody//tr")
    public List<WebElement> flightOptions;

    @FindBy(xpath = "//table//tbody//tr//td[6]")
    public List<WebElement> prices;
}
