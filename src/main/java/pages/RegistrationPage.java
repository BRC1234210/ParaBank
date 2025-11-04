package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{


    @FindBy(id= "customer.firstName")
    private WebElement firstnameInput;

    @FindBy(id= "customer.lastName")
    private WebElement lastnameInput;

    @FindBy(id= "customer.address.street")
    private WebElement adressInput;

    @FindBy(id= "customer.address.city")
    private WebElement cityInput;

    @FindBy(id= "customer.address.state")
    private WebElement stateInput;

    @FindBy(id= "customer.address.zipCode")
    private WebElement zipcodeInput;

    @FindBy(id= "customer.phoneNumber")
    private WebElement phoneInput;

    @FindBy(id= "customer.ssn")
    private WebElement ssnInput;

    @FindBy(id= "customer.username")
    private WebElement usernameInput;

      @FindBy(id= "customer.password")
    private WebElement passwordInput;

      @FindBy(id= "repeatedPassword")
    private WebElement confirmInput;

     @FindBy(xpath = "//form[@id='customerForm']//input[@value='Register']")
    private WebElement registerBtn2;

     @FindBy(xpath = "//*[@id='rightPanel']/p")
     private WebElement welcomeText;


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void fillInRegisterMask(final String firstname, final String lastname, final String address, final String city, final String state, final String zipcode, final String phone, final String ssn, final String username, final String password, final String confirm){

        sendKeysToElement(firstnameInput, firstname);
        sendKeysToElement(lastnameInput, lastname);
        sendKeysToElement(adressInput, address);
        sendKeysToElement(cityInput, city);
        sendKeysToElement(stateInput, state);
        sendKeysToElement(zipcodeInput, zipcode);
        sendKeysToElement(ssnInput, ssn);
        sendKeysToElement(usernameInput, username);
        sendKeysToElement(passwordInput, password);
        sendKeysToElement(confirmInput, confirm);
    }
    public void clickRegisterBtn2 () {
        Actions actions = new Actions(driver);
        actions.moveToElement(registerBtn2).click().perform();

    }
    public void verifyWelcomeText (){
        verifyDisplayed(welcomeText, "Error message");

    }

}
