package stepDefinitions;

import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import utility.BaseDriver;

public class US_603_BillPaySteps {
    public Logger LOGGER = LogManager.getLogger(this.getClass());

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;

    @Then("Click bill pay button")
    public void click_bill_pay_button() {
 driver= BaseDriver.getDriver();
 homePage.billPayButton();
    }
    @Then("Fill the payee information")
    public void fill_the_payee_information(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }
    @Then("Click read account number")
    public void click_read_account_number() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("fill the account inputs")
    public void fill_the_account_inputs() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("click the send payment button")
    public void click_the_send_payment_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Verify the payment is successful")
    public void verify_the_payment_is_successful() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
