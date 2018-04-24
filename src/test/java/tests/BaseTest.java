package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait webDriverWait;
    int timeout = 10;


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "D:\\AutoQA\\chromedriver.exe");

        ChromeOptions option = new ChromeOptions();
        driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, timeout);
        driver.get("http://blazedemo.com");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}