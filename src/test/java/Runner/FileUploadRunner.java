package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"StepDefinitions", "Hooks"},
        tags = "@Browser",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json"
        }
)
public class FileUploadRunner extends AbstractTestNGCucumberTests {}

