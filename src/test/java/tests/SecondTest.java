package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class SecondTest extends BaseTest {


    private String cardName = "Matthew McConaughey";
    private String address = " 8 Beacon St.";
    private String city = "Washington";
    private String state = "Washington DC";
    private String zipCode = "178178";
    private String cardMonth = "11";
    private String cardYear = "2020";
    private String cardNumber = "1111222233335555";
    private String valueId = "Id";
    private String valueStatus = "Status";
    private String valueAmount = "Amount";


    @Test
    public void test() {


        WebElement departureCity = driver.findElement(By.cssSelector("select:nth-child(1) > option:nth-child(1)"));
        String valueDepartureCity = departureCity.getText();

        WebElement destinationCity = driver.findElement(By.cssSelector("select:nth-child(4) > option:nth-child(1)"));
        String valueDestinationCity = destinationCity.getText();

        //WebElement FindFlights = driver.findElement(By.cssSelector("div > input"));
        //FindFlights.click();
        driver.findElement(By.cssSelector("div > input")).click();

        assertEquals("http://blazedemo.com/reserve.php", driver.getCurrentUrl());

        WebElement inputFromPort = driver.findElement(By.cssSelector("th:nth-child(4)"));
        WebElement inputToPort = driver.findElement(By.cssSelector("th:nth-child(5)"));

        assertEquals("Departs: " + valueDepartureCity, inputFromPort.getText(),
                "Error: departs is incorrect.");
        assertEquals("Arrives: " + valueDestinationCity, inputToPort.getText(),
                "Error:  arrives is incorrect.");


        String valueFlight = driver.findElement(By.cssSelector("tr:nth-child(4) > td:nth-child(3)")).getText();
        //String valueFlight = Flight.getText();

        String valueAirline = driver.findElement(By.cssSelector("tr:nth-child(4) > td:nth-child(4)")).getText();
        //String valueAirline = Airline.getText();

        String Price = driver.findElement(By.cssSelector(" tr:nth-child(4) > td:nth-child(7)")).getText();
        float valuePrice = Float.parseFloat(Price.replace("$", ""));

        //WebElement chooseThisFlight = driver.findElement(By.cssSelector("tr:nth-child(4) > td:nth-child(2)"));
        //chooseThisFlight.click();
        driver.findElement(By.cssSelector("tr:nth-child(4) > td:nth-child(2)")).click();


        WebElement flightNumber = driver.findElement(By.cssSelector("p:nth-child(3)"));
        WebElement  airline= driver.findElement(By.cssSelector("p:nth-child(2)"));
        WebElement  price = driver.findElement(By.cssSelector("p:nth-child(4)"));

        assertEquals("Flight Number: " + valueFlight, flightNumber.getText(),
                "Error: flight number is incorrect.");
        assertEquals("Airline: " + valueAirline, airline.getText(), "Error:  airline is incorrect.");
        assertEquals("Price: " + valuePrice, price.getText(), "Error:  price is incorrect.");


        driver.findElement(By.cssSelector("#inputName")).sendKeys(cardName);
        driver.findElement(By.cssSelector("#address")).sendKeys(address);
        driver.findElement(By.cssSelector("#city")).sendKeys(city);
        driver.findElement(By.cssSelector("#state")).sendKeys(state);
        driver.findElement(By.cssSelector("#zipCode")).sendKeys(zipCode);
        int randomCardType = new Random().nextInt(3);
        new Select(driver.findElement(By.cssSelector("#cardType"))).selectByIndex(randomCardType);
        driver.findElement(By.cssSelector("#creditCardNumber")).sendKeys(cardNumber);
        WebElement creditCardMonth = driver.findElement(By.cssSelector("#creditCardMonth"));
        creditCardMonth.clear();
        creditCardMonth.sendKeys(cardMonth);
        WebElement creditCardYear = driver.findElement(By.cssSelector("#creditCardYear"));
        creditCardYear.clear();
        creditCardYear.sendKeys(cardYear);
        driver.findElement(By.cssSelector("#nameOnCard")).sendKeys(cardName);

        String pTotalCost = driver.findElement(By.cssSelector("p:nth-child(7) > em")).getText();
        String purTaxes = driver.findElement(By.cssSelector("p:nth-child(5)")).getText();
        String purPrice = driver.findElement(By.cssSelector("p:nth-child(4)")).getText();
        Double pdTaxes = Double.parseDouble(purTaxes.replace("Arbitrary Fees and Taxes:", ""));
        Double pdPrice = Double.parseDouble(purPrice.replace("Price:", ""));
        assertEquals(String.valueOf(pdTaxes + pdPrice),pTotalCost);

        driver.findElement(By.cssSelector("div:nth-child(12) > div > input")).click();


        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));

            assertEquals(valueId, driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(1)")).getText(),
                "Error:  ID not found on page.");
        assertEquals(valueStatus, driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(1)")).getText(),
                "Error:  Status not found on page.");
        assertEquals(valueAmount, driver.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(1)")).getText(),
                "Error:  Amount not found on page.");

        WebElement purchaseCardNum = driver.findElement(By.cssSelector("tr:nth-child(4) > td:nth-child(2)"));
        String quartile4 = purchaseCardNum.getText().replace("x", "");
        assertTrue(cardNumber.contains(quartile4), "Error: the fourth quartile does not match.");

    }
}