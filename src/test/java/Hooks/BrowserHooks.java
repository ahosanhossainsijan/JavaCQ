package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserHooks {
    private static WebDriver driver;

    @Before("@Browser")
    public void beforeScenarioWithTag() {
        getDriver();
    }

    @Before(order = 1)
    public void openBrowser() {
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();*/
    }

    @After
    public void closeBrowser() {
        if(driver != null){
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        if(driver == null){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("incognito");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }
}
