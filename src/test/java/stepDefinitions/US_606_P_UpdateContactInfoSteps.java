package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.*;
import utility.BaseDriver;
import utility.ConfigReader;

public class US_606_P_UpdateContactInfoSteps {

    public Logger LOGGER = LogManager.getLogger(this.getClass());
    HomePage homePage;
    WebDriver driver;
    LoginPage loginPage;
    UpdateContactInfoPage updateContactInfoPage;

    @Given("the user is on the Home Page")
    public void theUserIsOnTheHomePage() {
        driver= BaseDriver.getDriver();
        loginPage=new LoginPage(driver);
        homePage = new HomePage(driver);
        updateContactInfoPage = new UpdateContactInfoPage(driver);

        updateContactInfoPage.verifyHomePage();
        LOGGER.info("Homepage is visible successfully.");
    }
    @When("the user navigates to the {string} page")
    public void theUserNavigatesToThePage(String arg0) {
        updateContactInfoPage.clickUpdateContactBtn();
        LOGGER.info("Update Contact Button clicked successfully.");
    }
    @Then("the Update Profile fields should be visible")
    public void theUpdateProfileFieldsShouldBeVisible() {
        updateContactInfoPage.verifyUpdateProfileText();
        LOGGER.info("Update Profile text is visible successfully.");
    }

    @When("the user updates the contact information")
    public void theUserUpdatesTheContactInformation() {
        updateContactInfoPage.fillFirstName(ConfigReader.getProperty("firstname"));
        updateContactInfoPage.fillLastName(ConfigReader.getProperty("lastname"));
        updateContactInfoPage.fillAddress(ConfigReader.getProperty("address"));
        updateContactInfoPage.fillCity(ConfigReader.getProperty("city"));
        updateContactInfoPage.fillState(ConfigReader.getProperty("state"));
        updateContactInfoPage.fillZipCode(ConfigReader.getProperty("zipcode"));
        LOGGER.info("All contact information updated successfully.");
    }

    @And("clicks the {string} button")
    public void clicksTheButton(String arg0) {
        updateContactInfoPage.clickUpdateProfileBtn();
        LOGGER.info("Update Profile button clicked successfully.");
    }

    @Then("a success message should be displayed")
    public void aSuccessMessageShouldBeDisplayed() {
        updateContactInfoPage.verifyProfileUpdatedText();
        LOGGER.info("Profile Updated text is verified successfully.");
    }
    @When("the user navigates to the {string} page again")
    public void theUserNavigatesToThePageAgain(String arg0) {
        updateContactInfoPage.clickUpdateContactBtn();
        LOGGER.info("Update Contact Button clicked again successfully.");
    }
    @And("the updated information should appear in the profile")
    public void theUpdatedInformationShouldAppearInTheProfile() {
        String expectedCity = ConfigReader.getProperty("city");
        updateContactInfoPage.verifyUpdatedCityValue(expectedCity);
        LOGGER.info("Updated information appear int the profile successfully.");
    }
    @When("the user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        homePage.logOutButton();
        LOGGER.info("Logout button clicked successfully.");
        loginPage.enterUsernameAndPassword(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
        loginPage.clickLoginBtn();
        LOGGER.info("Login button clicked again successfully.");
    }
    @Then("the updated contact info should persist")
    public void theUpdatedContactInfoShouldPersist() {
        updateContactInfoPage.clickUpdateContactBtn();
        updateContactInfoPage.verifyUpdatedCityValue(ConfigReader.getProperty("city"));
    }

    @And("clears the {string} field")
    public void clearsTheField(String fieldName) {
        updateContactInfoPage.clearField(fieldName);
        LOGGER.info(fieldName + " field cleared successfully.");
    }

    @Then("a validation message should appear for the {string} field")
    public void aValidationMessageShouldAppearForTheField(String fieldName) {
        updateContactInfoPage.verifyValidationMessage(fieldName);
        LOGGER.info("Validation message verified for " + fieldName + " field.");
    }

    @And("the contact information should not be updated")
    public void theContactInformationShouldNotBeUpdated() {
        updateContactInfoPage.verifyProfileNotUpdated();
        LOGGER.info("Contact information was not updated as expected.");
    }

}
