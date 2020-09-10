package webelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageElements {

    @FindBy(tagName = "h1")
    public WebElement pageHeader;

    @FindBy(name = "fromPort")
    public WebElement fromCity;

    @FindBy(name = "toPort")
    public WebElement toCity;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submit;
}
