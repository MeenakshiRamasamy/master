package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import webelements.HomePageElements;

public class HomePage {

    private WebDriver driver;

    private final String headerText = "Welcome to the Simple Travel Agency!";

    HomePageElements elements = new HomePageElements();
    PropertiesFile properties = new PropertiesFile();

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, elements);
        driver.get(properties.getProperties().getProperty("pageUrl"));
    }

    public boolean validateHeader() {
        return elements.pageHeader.getText().equals(headerText);
    }

    public void selectFromCity(String departureCity) {
        Select depCitySelect = new Select(elements.fromCity);
        depCitySelect.selectByVisibleText(departureCity);
    }

    public void selectToCity(String destinationCity) {
        Select destCitySelect = new Select(elements.toCity);
        destCitySelect.selectByVisibleText(destinationCity);
    }

    public void submit() {
        elements.submit.click();
    }
}
