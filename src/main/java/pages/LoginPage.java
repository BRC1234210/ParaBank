package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @FindBy(xpath = "//div[@id='loginPanel']/p[2]")
    private WebElement registerBtn;

    public void clickRegisterBtn(){
        clickElement(registerBtn);
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
