package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FirstTest {


    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver", "D:\\AutoQA\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://blazedemo.com");
        WebElement FindFlights =  driver.findElement(By.cssSelector("input.btn.btn-primary"));
        FindFlights.click();
//      assertTrue(driver.findElement(By.cssSelector("body")).isDisplayed());
        assertEquals("http://blazedemo.com/reserve.php", driver.getCurrentUrl());
//      driver.quit();
    }

}



