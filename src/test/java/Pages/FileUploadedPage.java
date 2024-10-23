package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadedPage extends BasePage {

    private final WebDriver driver;
    public FileUploadedPage(WebDriver driver) {
        super(By.xpath("//div//h3[normalize-space() = 'File Uploaded!']"), driver);
        this.driver = driver;
    }
}
