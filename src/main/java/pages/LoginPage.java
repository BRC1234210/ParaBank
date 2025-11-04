package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//div[@class='login']/input[@type='text']")
    private WebElement usernameInput;

    @FindBy(xpath = "//div[@class='login']/input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[@class='login']/input[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@id='rightPanel']/p")
    private WebElement invalidMessage;

    @FindBy(xpath = "//*[@id='loginPanel']/p[2]/a")
    private WebElement registerLink;

    @FindBy(xpath = "//body[@onload='document.login.username.focus();']")
    private WebElement blank;

    public void clickOnBlankSpace(){
        clickElement(blank);
    }

    public void clickRegisterLink(){
       clickElement(registerLink);
    }


    public void enterUsernameAndPassword(final String username, final String password) {
        sendKeysToElement(usernameInput, username);
        sendKeysToElement(passwordInput, password);
    }

    public void clickLoginBtn(){
        clickElement(loginButton);
    }

    public void verifyInvalidMessage(){
        verifyDisplayed(invalidMessage,"Invalid message not displayed");
    }


    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
