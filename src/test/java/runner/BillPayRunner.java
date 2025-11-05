package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class BillPayRunner {
    @CucumberOptions(
            features = "src/test/resources/features/billPay.feature",
            glue = {"stepDefinitions", "hooks"},
            plugin = {"pretty", "html:target/cucumber-report.html",
                    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
            monochrome = true
    )


    public class TestRunner extends AbstractTestNGCucumberTests {
    }
}
