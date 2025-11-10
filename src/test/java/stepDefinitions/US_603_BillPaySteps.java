package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.BillpayPage;
import utility.BaseDriver;

public class US_603_BillPaySteps {
    public Logger LOGGER = LogManager.getLogger(this.getClass());

    BillpayPage billpayPage;

    public US_603_BillPaySteps() {
        this.billpayPage = new BillpayPage(BaseDriver.getDriver());
    }

    @Given("User is on the Bill Pay page")
    public void user_is_on_the_bill_pay_page() {
        BaseDriver.getDriver().get("https://parabank.parasoft.com/parabank/billpay.htm");
        LOGGER.info("Navigated to Bill Pay page");
    }

    @Then("Click bill pay button")
    public void click_bill_pay_button() {
        billpayPage.bilpaypage();
        LOGGER.info("Bill Pay button clicked");
    }

    @Then("Fill the payee information {string} {string} {string} {string} {string} {string}")
    public void fill_the_payee_information(String payeename, String address,
                                           String city, String state,
                                           String zipcode, String phone) {
        billpayPage.fillPayeeinfo(payeename, address, city, state, zipcode, phone);
        LOGGER.info("Payee information filled - Name: " + payeename + ", City: " + city);
    }

    @Then("fill the account inputs")
    public void fill_the_account_inputs() {
        billpayPage.sendAccountInfo();
        LOGGER.info("Account info filled successfully");
    }

    @Then("fill the amount input {string}")
    public void fillTheAmountInput(String amount) {
        billpayPage.fillAmountInput(amount);
        LOGGER.info("Amount filled successfully");
    }

    @Then("click the send payment button")
    public void click_the_send_payment_button() {
        billpayPage.sendPay();
        LOGGER.info("Send payment button clicked");
    }

    @Then("Verify the payment is successful")
    public void verify_the_payment_is_successful() {
        billpayPage.verifyPaymentText();
        LOGGER.info("Payment verification completed");
    }

    @Then("click the Account OverView Page")
    public void click_the_account_over_view_page() {
        billpayPage.clickOverViewpage();
    }
    @Then("verify payment1")
    public void verify_payment1() {
        billpayPage.verifyPayment1();
    }
    @Then("verify payment2")
    public void verify_payment2() {
        billpayPage.verifyPayment2();
    }

    @Then("verify payment3")
    public void verify_payment3() {
       billpayPage.verifyPayment3();
    }

    @Then("click Logout button")
    public void clickLogoutButton() {
        billpayPage.logOut();
    }
}