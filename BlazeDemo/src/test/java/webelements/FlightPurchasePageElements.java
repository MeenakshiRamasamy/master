package webelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightPurchasePageElements {

    @FindBy(xpath = "//p[3]")
    public WebElement price;

    @FindBy(id = "inputName")
    public WebElement name;

    @FindBy(id = "address")
    public WebElement address;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "state")
    public WebElement state;

    @FindBy(id = "zipCode")
    public WebElement zipCode;

    @FindBy(id = "cardType")
    public WebElement cardType;

    @FindBy(id = "creditCardNumber")
    public WebElement creditCardNumber;

    @FindBy(id = "creditCardMonth")
    public WebElement creditCardMonth;

    @FindBy(id = "creditCardYear")
    public WebElement creditCardYear;

    @FindBy(id = "nameOnCard")
    public WebElement nameOnCard;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submit;
}
