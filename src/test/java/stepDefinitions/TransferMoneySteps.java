package stepDefinitions;

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

public class TransferMoneySteps {

    public Logger LOGGER = LogManager.getLogger(this.getClass());
    HomePage homePage;
    WebDriver driver;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    TransferMoneyPage transferMoneyPage;


    @When("Click Transfer Funds")
    public void clickTransferFunds() {
        driver= BaseDriver.getDriver();
        loginPage=new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        homePage = new HomePage(driver);
        transferMoneyPage = new TransferMoneyPage(driver);

        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        LOGGER.info("Webpage opened");

        homePage.clicktransferFundsLink();
    }

    @Then("Fill amount and choose accounts")
    public void fillAmountAndChooseAccounts() {
        transferMoneyPage.enterAmount();
        transferMoneyPage.moneyTransfer();
    }

    @Then("Click Transfer Button")
    public void clickTransferButton() {
        transferMoneyPage.clickTransferButton();
    }

    @Then("Check Transfer Message")
    public void checkTransferMessage() {
        transferMoneyPage.TransferCompleteMessage();
    }

    @When("Click Find Transactions")
    public void clickFindTransactions() {
        homePage.clicktransferFundsLink();
    }

    @Then("Complete Find Transactions Section")
    public void completeFindTransactionsSection() {
        transferMoneyPage.CompleteFindTransaction();
    }

    @Then("Check Transaction Results")
    public void checkTransactionResults() {
        transferMoneyPage.TransactionResultsText();
    }
}
