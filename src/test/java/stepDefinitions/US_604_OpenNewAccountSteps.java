package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.OpenNewAccountPage;
import utility.BaseDriver;

public class US_604_OpenNewAccountSteps {

    public Logger LOGGER = LogManager.getLogger(this.getClass());
    HomePage homePage;
    WebDriver driver;
    LoginPage loginPage;
    OpenNewAccountPage openNewAccountPage;


    @Given("User is on the Homepage")
    public void userIsOnTheHomepage() {
        driver= BaseDriver.getDriver();
        homePage=new HomePage(driver);
        loginPage=new LoginPage(driver);
        openNewAccountPage=new OpenNewAccountPage(driver);
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        openNewAccountPage.verifyHomePage();
        LOGGER.info("Homepage is visible.");
    }

    @When("User navigates to the {string} page")
    public void userNavigatesToThePage(String arg0) {
        openNewAccountPage.clickOpenNewAccountButton();
        openNewAccountPage.verifyOpenNewAccountPage();
        openNewAccountPage.clickTypeOfAccountDropdownMenu();
        LOGGER.info("Open New Button was clicked,Open New Account Page was visible and dropdown menü was clicked.");
    }

    @Then("User selects the account type:Checking")
    public void userSelectsTheAccountTypeChecking() {
        openNewAccountPage.clickCheckingSubmenu();
        LOGGER.info("Checking was selected.");
    }
    @Then("User selects the account type:Savings")
    public void userSelectsTheAccountTypeSavings() {
        openNewAccountPage.clickSavingsSubmenu();
        LOGGER.info("Savings was selected.");
    }

    @And("Verify user's amount of balance")
    public void verifyUserSAmountOfBalance() {
        openNewAccountPage.verifyMinBalanceText();
        LOGGER.info("Minimum amount balance text is visible.");
    }
    @And("Click on the {string} button")
    public void clickOnTheButton(String arg0) {
        openNewAccountPage.clickOpenNewAccountButton2();
        LOGGER.info("Open new Account Button was clicked.");
    }

    @Then("Verify that the new Checking account is successfully created")
    public void verifyThatTheNewAccountIsSuccessfullyCreated() {
openNewAccountPage.verifyAccountOpened();
    }

    @Then("Then Verify that the new Saving account is successfully created")
    public void thenVerifyThatTheNewSavingAccountIsSuccessfullyCreated() {
        openNewAccountPage.verifyAccountOpened();
    }

}
