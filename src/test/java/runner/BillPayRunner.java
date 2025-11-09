package runner;

import hooks.Hooks;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


    @CucumberOptions(
            features = "src/test/resources/features/billPay.feature",
            glue = {"stepDefinitions", "hooks"},
            plugin = {"pretty", "html:target/cucumber-report.html",
                    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
            monochrome = true
    )


    public class BillPayRunner extends AbstractTestNGCucumberTests {
    }

