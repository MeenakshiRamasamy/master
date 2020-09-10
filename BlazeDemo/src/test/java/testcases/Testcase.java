package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webpages.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Testcase {

    private WebDriver driver;

    PropertiesFile properties = new PropertiesFile();

    private final String startCity = "Paris";
    private final String toCity = "London";


    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", properties.getProperties().getProperty("driverPath"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void verifyFlightDetails() {
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.validateHeader(), true);

        homePage.selectFromCity(startCity);
        homePage.selectToCity(toCity);
        homePage.submit();

        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        Assert.assertEquals(flightDetailsPage.getHeader(), "Flights from " + startCity + " to " + toCity + ":");
        Assert.assertEquals(flightDetailsPage.verifyPopulatedFlightDetails(), true, "Flight details populated");
    }

    @Test
    public void verifyFlightPrice() {
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.validateHeader(), true);

        homePage.selectFromCity(startCity);
        homePage.selectToCity(toCity);
        homePage.submit();

        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        String price = flightDetailsPage.chooseFlightByLowestPrice();

        FlightPurchasePage flightPurchasePage = new FlightPurchasePage(driver);
        Assert.assertEquals(flightPurchasePage.getPrice(), "Price: " + price);
    }

    @Test
    public void verifyPurchaseFlight() {
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.validateHeader(), true);

        homePage.selectFromCity(startCity);
        homePage.selectToCity(toCity);
        homePage.submit();

        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.chooseFlightByLowestPrice();

        FlightPurchasePage flightPurchasePage = new FlightPurchasePage(driver);
        flightPurchasePage.fillPersonalDetails(Arrays.asList(new String[]{"Test", "AddressTest", "CityTest", "StateTest", "12345"}));
        flightPurchasePage.fillPaymentDetails(Arrays.asList(new String[]{"American Express", "123", "8", "2020", "Test"}));
        flightPurchasePage.submit();

        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        Assert.assertEquals(confirmationPage.verifyConfirmationId(), true, "ConfirmationId is not empty");
    }

    @AfterTest
    public void close() {
        driver.close();
    }
}
