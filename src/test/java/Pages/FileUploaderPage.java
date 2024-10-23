package Pages;

import Hooks.BrowserHooks;
import Utility.JsonUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;

public class FileUploaderPage extends BasePage {

    private final WebDriver driver;
    public FileUploaderPage(WebDriver driver) {
        super(By.xpath("//div//h3[normalize-space() = 'File Uploader']"), driver);
        this.driver = driver;
    }


    By fileInput = By.xpath("//form//input[@id='file-upload']");
    By uploadButton = By.xpath("//form//input[@id='file-submit']");

    public void uploadFile(String fileName) {
        String fullPath = Paths.get("src/Files/", fileName).toAbsolutePath().toString();
        driver.findElement(fileInput).sendKeys(fullPath);
    }


    public void clickOnUpload()
    {
        driver.findElement(uploadButton).click();
    }
}
