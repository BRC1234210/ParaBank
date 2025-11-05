package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateContactInfoPage extends BasePage {

    @FindBy(xpath = "//input[@id='customer.firstName']")
    private WebElement firstnameInput;

    @FindBy(xpath = "//input[@id='customer.lastName']")
    private WebElement lastnameInput;

    @FindBy(xpath = "//input[@id='customer.address.street']")
    private WebElement addressInput;

    @FindBy(xpath = "//input[@id='customer.address.city']")
    private WebElement cityInput;

    @FindBy(xpath = "//input[@id='customer.address.state']")
    private WebElement stateInput;

    @FindBy(xpath = "//input[@id='customer.address.zipCode']")
    private WebElement zipcodeInput;

    @FindBy(xpath = "//div[@id='updateProfileForm']/h1")
    private WebElement verifyUpdateProfileText;

    @FindBy(xpath = "//input[@class='button']")
    private WebElement updateProfileBtn;

    @FindBy(xpath = "//div[@id='updateProfileResult']/h1")
    private WebElement verifyProfileUpdatedText;


    public UpdateContactInfoPage(WebDriver driver) {
        super(driver);
    }
        public void fillFirstName (final String firstname){
            sendKeysToElement(firstnameInput, firstname);
        }
    public void fillLastName (final String lastname){
        sendKeysToElement(lastnameInput, lastname);
    }
    public void fillAddress (final String address){
        sendKeysToElement(addressInput, address);
    }
    public void fillCity (final String city){
        sendKeysToElement(cityInput, city);
    }
    public void fillState (final String state){
        sendKeysToElement(stateInput, state);
    }
    public void fillZipCode (final String zipCode){
        sendKeysToElement(zipcodeInput, zipCode);
    }
    public void verifyUpdateProfileText (){
        verifyDisplayed(verifyUpdateProfileText, "Text is not visible");
    }
    public void clickUpdateProfileBtn(){
        clickElement(updateProfileBtn);
    }
    public void verifyProfileUpdatedText (){
        verifyDisplayed(verifyProfileUpdatedText, "Text is not visible");
    }
}
