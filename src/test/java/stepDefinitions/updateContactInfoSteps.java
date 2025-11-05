package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.UpdateContactInfoPage;
import utility.ConfigReader;


public class updateContactInfoSteps {
    WebDriver driver;
    UpdateContactInfoPage updateContactInfoPage;
    public Logger LOGGER = LogManager.getLogger(this.getClass());

    @When("the user verifies the Update Profile form fields are displayed: First Name, Last Name, Address, City, State, Zip Code")
    public void theUserVerifiesTheUpdateProfileFormFieldsAreDisplayedFirstNameLastNameAddressCityStateZipCode() {
        updateContactInfoPage.verifyUpdateProfileText();
        LOGGER.info("the Update Profile form fields are displayed");
    }

    @And("the user updates contact information with:")
    public void theUserUpdatesContactInformationWith() {
            updateContactInfoPage.fillFirstName(ConfigReader.getProperty("firstname"));
            LOGGER.info("Firstname input changed.");
    }

    @And("the user clicks the {string} button")
    public void theUserClicksTheButton(String arg0) {
        updateContactInfoPage.clickUpdateProfileBtn();
        LOGGER.info("Update Profile button clicked.");
    }

    @Then("a success confirmation message should be displayed")
    public void aSuccessConfirmationMessageShouldBeDisplayed() {
         updateContactInfoPage.verifyProfileUpdatedText();
         LOGGER.info("Profile Updated text is visible.");
    }

    @And("the left panel or profile summary should reflect the updated contact information")
    public void theLeftPanelOrProfileSummaryShouldReflectTheUpdatedContactInformation() {

    }

    @When("the user logs out")
    public void theUserLogsOut() {

    }

    @And("the user logs in again with username {string} and password {string}")
    public void theUserLogsInAgainWithUsernameAndPassword(String arg0, String arg1) {

    }

    @Then("the profile page should display the persisted contact information:")
    public void theProfilePageShouldDisplayThePersistedContactInformation() {

    }

    @When("the user navigates to {string} page")
    public void theUserNavigatesToPage(String arg0) {

    }

    @And("the user clears the {string} field")
    public void theUserClearsTheField(String arg0) {

    }

    @Then("a validation message should be displayed for the {string} field")
    public void aValidationMessageShouldBeDisplayedForTheField(String arg0) {

    }

    @And("the contact information should not be updated")
    public void theContactInformationShouldNotBeUpdated() {

    }
}
