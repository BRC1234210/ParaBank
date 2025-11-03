package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps {

    @When("Navigate to the webpage")
    public void navigate_to_the_webpage() {
        System.out.println("Web page is navigated");
    }

    @Then("Click the Register Link on the home page")
    public void clickTheRegisterLinkOnTheHomePage() {

    }

    @And("Fill the additional details")
    public void fillTheAdditionalDetails() {
    }

    @Then("Click Register button")
    public void clickRegisterButton() {
    }

    @Then("Verify Registration is successful")
    public void verifyRegistrationIsSuccessful() {
    }
}

