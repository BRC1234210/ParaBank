package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.TransferMoneyPage;
import utility.BaseDriver;
import utility.ConfigReader;

public class loginSteps {

    public Logger LOGGER = LogManager.getLogger(this.getClass());

    WebDriver driver;
    LoginPage loginPage;
    TransferMoneyPage transferMoneyPage;

    @When("navigate to the webpage")
    public void navigateToTheWebpage() {
        driver= BaseDriver.getDriver();
        loginPage=new LoginPage(driver);
        transferMoneyPage = new TransferMoneyPage(driver);


        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        LOGGER.info("Webpage opened");
    }

    @Then("enter the username and password")
    public void enterTheUsernameAndPassword() {
        loginPage.enterUsernameAndPassword(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
    }

    @Then("Click login button")
    public void clickLoginButton() {
        loginPage.clickLoginBtn();
    }

    @Then("verify Home Page Opened")
    public void verifyHomePageOpened() {
        loginPage.verifyInvalidMessage();
    }
}
