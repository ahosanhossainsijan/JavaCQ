package StepDefinitions;

import Hooks.BrowserHooks;
import Pages.FileUploadedPage;
import Pages.FileUploaderPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FileUploadSteps {

    private WebDriver driver;
    private FileUploaderPage fileUploaderPage;
    private FileUploadedPage fileUploadedPage;

    public FileUploadSteps() {
        if(BrowserHooks.getDriver() == null){
            System.out.println("Null");
        }
        driver = BrowserHooks.getDriver();
    }

    @Given("I open the URL and the file uploader page is opened")
    public void OpenTheUrlAndFileUploaderPageIsOpened() {
        fileUploaderPage = new FileUploaderPage(driver);
        fileUploaderPage.OpenUrl();
        Assert.assertTrue(fileUploaderPage.IsPageOpned(), "Page is not opened");
    }

    @When("I upload the file {string}")
    public void UploadTheFile(String filename) {
        fileUploaderPage.uploadFile(filename);
    }

    @When("I click on the Upload button")
    public void ClickOnTheUploadButton() {
        fileUploaderPage.clickOnUpload();
    }

    @Then("The file should be uploaded successfully")
    public void FileIsUploaded() {
        fileUploadedPage = new FileUploadedPage(driver);
        Assert.assertTrue(fileUploadedPage.IsPageOpned(), "File is not uploaded");
    }
}
