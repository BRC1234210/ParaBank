package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenNewAccountPage extends BasePage {

    @FindBy(xpath = " //div[@id='rightPanel']")
    private WebElement homePageText;

    @FindBy(xpath = "//div[@id='leftPanel']/ul/li/a")
    private WebElement openNewAccountBtn;

    @FindBy(xpath = "//div[@id='leftPanel']/ul/li/a")
    private WebElement openNewAccountText;

    @FindBy(xpath = "//select[@id='type']")
    private WebElement typeOfAccountDropdownMenu;

    @FindBy(xpath = "//select[@id='type']/option[1]")
    private WebElement accountOfChecking;

    @FindBy(xpath = "//select[@id='type']/option[2]")
    private WebElement accountOfSavings;

    @FindBy(xpath = "//div[@id='openAccountForm']/form/p[2]/b")
    private WebElement minimumBalanceRequiredText;

    @FindBy(xpath = "//input[@value='Open New Account']")
    private WebElement openNewAccountBtn2;

    @FindBy(xpath = "//input[@value='Open New Account']")
    private WebElement accountOpenedText;

    public OpenNewAccountPage(WebDriver driver) {
        super(driver);
    }

    public void verifyHomePage() {
        verifyDisplayed(homePageText, "Homepage is not visible");
    }

    public void clickOpenNewAccountButton() {
        clickElement(openNewAccountBtn);
    }

    public void verifyOpenNewAccountPage() {
        verifyDisplayed(openNewAccountText, "Open New Account Page is not visible");
    }

    public void clickTypeOfAccountDropdownMenu() {
        clickElement(typeOfAccountDropdownMenu);
    }

    public void clickCheckingSubmenu() {
        clickElement(accountOfChecking);
    }
    public void clickSavingsSubmenu() {
        clickElement(accountOfSavings);
    }

    public  void verifyMinBalanceText(){
        verifyDisplayed(minimumBalanceRequiredText,"Minimum Balance Text is not disappear.");
    }

    public void clickOpenNewAccountButton2(){
        clickElement(openNewAccountBtn2);
    }

    public void verifyAccountOpened(){
        verifyDisplayed(accountOpenedText,"New Account is not opened.");
    }
}
