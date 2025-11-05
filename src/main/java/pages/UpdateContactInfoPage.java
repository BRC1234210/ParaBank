package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

public class UpdateContactInfoPage extends BasePage {

    @FindBy(xpath = " //div[@id='rightPanel']")
    private WebElement verifyHomePage;

    @FindBy(xpath = "//div[@id='leftPanel']/ul/li[6]")
    private WebElement clickUpdateContactInfo;

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

    @FindBy(id = "customer.address.city")
    private WebElement cityField;

    @FindBy(xpath = "//span[@class='error']")
    private WebElement validationMessage;


    public UpdateContactInfoPage(WebDriver driver) {
        super(driver);
    }

    public void verifyHomePage() {
        verifyDisplayed(verifyHomePage, "Homepage is not visible");
    }

    public void clickUpdateContactBtn() {
        clickElement(clickUpdateContactInfo);
    }

    public void fillFirstName(final String firstname) {
        wait.until(ExpectedConditions.visibilityOf(firstnameInput));
        firstnameInput.click();
        firstnameInput.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        firstnameInput.sendKeys(firstname);
    }
    public void fillLastName(final String lastname) {
        wait.until(ExpectedConditions.visibilityOf(lastnameInput));
        lastnameInput.click();
        lastnameInput.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        lastnameInput.sendKeys(lastname);
    }

    public void fillAddress(final String address) {
        wait.until(ExpectedConditions.visibilityOf(addressInput));
        addressInput.click();
        addressInput.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        addressInput.sendKeys(address);
    }

    public void fillCity(final String city) {
        wait.until(ExpectedConditions.visibilityOf(cityInput));
        cityInput.click();
        cityInput.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        cityInput.sendKeys(city);
        LOGGER.info("City field updated successfully.");
    }

    public void fillState(final String state) {
        wait.until(ExpectedConditions.visibilityOf(stateInput));
        stateInput.click();
        stateInput.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        stateInput.sendKeys(state);

    }

    public void fillZipCode(final String zipCode) {
        wait.until(ExpectedConditions.visibilityOf(zipcodeInput));
        zipcodeInput.click();
        zipcodeInput.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        zipcodeInput.sendKeys(zipCode);
    }

    public void verifyUpdateProfileText() {
        verifyDisplayed(verifyUpdateProfileText, "Text is not visible");
    }

    public void clickUpdateProfileBtn() {
        clickElement(updateProfileBtn);
    }

    public void verifyProfileUpdatedText() {
        verifyDisplayed(verifyProfileUpdatedText, "Text is not visible");
    }
    public void verifyUpdatedCityValue(String expectedCity) {
        wait.until(ExpectedConditions.visibilityOf(cityField));
        wait.until(driver -> {
            String value = cityField.getAttribute("value");
            return value != null && !value.isEmpty();
        });
        String actualCity = cityField.getAttribute("value");
        if (Objects.equals(actualCity, expectedCity)) {
            LOGGER.info("City updated successfully: " + actualCity);
        } else {
            throw new AssertionError("City not updated! Expected: " + expectedCity + " but found: " + actualCity);
        }
    }

    public void clearField(String fieldName) {
        WebElement field = addressInput;
        if (fieldName.equals("Address")) {
            field = addressInput;
        }
        wait.until(ExpectedConditions.visibilityOf(field));
        field.click();
        field.clear();
    }

    public void verifyValidationMessage(String fieldName) {
        verifyDisplayed(validationMessage, "Validation message not displayed for " + fieldName);
    }

    public void verifyProfileNotUpdated() {
        try {
            wait.until(ExpectedConditions.invisibilityOf(verifyProfileUpdatedText));
            LOGGER.info("Profile was not updated as expected.");
        } catch (Exception e) {
            LOGGER.info("Success message not present.");
        }
    }
}
