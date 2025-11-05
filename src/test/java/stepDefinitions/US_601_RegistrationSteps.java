package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import pages.TransferMoneyPage;
import utility.BaseDriver;

import java.util.List;
import java.util.Map;

public class US_601_RegistrationSteps {
    public Logger LOGGER = LogManager.getLogger(this.getClass());
    HomePage homePage;
    WebDriver driver;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    TransferMoneyPage transferMoneyPage;

    @When("Navigate to the webpage")
    public void navigate_to_the_webpage() {
            driver= BaseDriver.getDriver();
            loginPage=new LoginPage(driver);
            registrationPage = new RegistrationPage(driver);
            homePage = new HomePage(driver);
            transferMoneyPage = new TransferMoneyPage(driver);

            driver.get("https://parabank.parasoft.com/parabank/index.htm");
            LOGGER.info("Webpage opened");
    }


    @And("Fill the additional details")
    public void fillTheAdditionalDetails(DataTable dataTable) {
        List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);

        for(Map<String, String> row : data) {
            String field = row.get("field");
            String value = row.get("value");

            System.out.println(field + ":" + value);

            LOGGER.info("Registration fulfilled");
        }
    }

    @Then("Click Register button")
    public void clickRegisterButton() {
        registrationPage.clickRegisterBtn2();
        LOGGER.info("Registration Clicked");


    }

    @Then("Verify Registration is successful")
    public void verifyRegistrationIsSuccessful() {
        registrationPage.verifyWelcomeText();
        LOGGER.info("Welcome Message seen");
    }

    @Then("Click the Register Link")
    public void clickTheRegisterLink() {
        loginPage.clickOnBlankSpace();
        loginPage.clickRegisterLink();
    }
}

