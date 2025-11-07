package stepDefinitions;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.Serializers;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.RequestLoanPage;
import utility.BaseDriver;
import utility.ConfigReader;

public class US_607_RequestLoanSteps {

    public Logger LOGGER = LogManager.getLogger(this.getClass());
    WebDriver driver;
    HomePage homePage;
    RequestLoanPage requestLoanPage;

    @When("The user clicks on the {string} link")
    public void theUserClicksOnTheLink(String linkName) {
        driver = BaseDriver.getDriver();
        homePage = new HomePage(driver);
        requestLoanPage = new RequestLoanPage(driver);

        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        LOGGER.info("Linkname is clickable", linkName);
        homePage.requestLoanBtn();
    }

    @Then("The user enters values in the {string} and {string} fields")
    public void theUserEntersValuesInTheAndFields(String loan, String down) {
        requestLoanPage.fillLoan(loan);
        requestLoanPage.fillDown(down);
        LOGGER.info("Loan amount entered"+ loan+ "down amount entered"+  down);
    }

    @Then("The user selects an account number")
    public void theUserSelectsAnAccountNumber() {
        requestLoanPage.selectAccount();
        LOGGER.info("Bank account selected");
    }

    @Then("The user clicks the {string} button")
    public void theUserClicksTheButton(String Apply) {
        requestLoanPage.clickApplyButton();
        LOGGER.info("Apply button clicked", Apply);
    }


    @Then("The user verifies the message {string}")
    public void theUserVerifiesTheMessage(String acceptedMessage) {
        requestLoanPage.verifySuccessfully();
        LOGGER.info("Conguratilation text is displayed");
    }


    @Then("The user clicks on the link for the newly created credit account number")
    public void theUserClicksOnTheLinkForTheNewlyCreatedCreditAccountNumber() {
        requestLoanPage.clickLinkAccount();
        LOGGER.info("Link button is clicked");
    }


    @Then("The user then verifies the information in the “Account Details” section and confirms the “No transactions found” message.")
    public void theUserThenVerifiesTheInformationInTheAccountDetailsSectionAndConfirmsTheNoTransactionsFoundMessage() {
        requestLoanPage.verifyAccountDetailsAndNoTranscation();
        LOGGER.info("The data under account details and the message “no transaction found” appeared.");
    }


    @Then("The user enters the {string} as {string} and the {string} as {string}")
    public void theUserEntersTheAsAndTheAs(String loanAmount, String loanInput, String downAmount, String downInput) {
        requestLoanPage.fillInvalidLoan();
        requestLoanPage.fillInvalidDown();
        LOGGER.info("Loan amount entered" + loanAmount+"1.000.000 entered" + loanInput+ "10.000 entered"+ downInput+ "Down amount entered"+  downAmount);
    }



    @Then("The user verifies under the {string} heading that:")
    public void theUserVerifiesUnderTheHeadingThat(String request) {
        requestLoanPage.verifyRequest();
        LOGGER.info("The message “Credit Request Processed” appeared.");
    }



    @Then("The user verifies the error message {string}")
    public void theUserVerifiesTheErrorMessage(String errorMessage) {
        requestLoanPage.verifyErrorPayment();
        LOGGER.info("Error message is displayed", errorMessage);
    }


}
