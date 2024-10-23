package Pages;

import Hooks.BrowserHooks;
import Utility.JsonUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasePage
{
    private final By locator;
    private WebDriver driver;
    public BasePage(By locator, WebDriver driver)
    {
        this.locator = locator;
        this.driver = driver;
    }

    public void OpenUrl()
    {
        if(driver == null){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("incognito");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        driver.get("https://the-internet.herokuapp.com/upload");
    }

    public boolean IsPageOpned()
    {
        return driver.findElements(locator).size()>0;
    }


}
