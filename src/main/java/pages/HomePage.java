package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//div[@id='leftPanel']/ul/li/a")
    private WebElement openNewAccountBtn;

    @FindBy(xpath = "//div[@id='leftPanel']/ul/li[2]/a")
    private WebElement accountsOverviewbtn;

    @FindBy(xpath = "//div[@id='leftPanel']//a[@href='transfer.htm']")
    private WebElement TransferFundsLink;

    @FindBy(xpath = "//div[@id='leftPanel']/ul/li[4]/a")
    private WebElement billPayBtn;

    @FindBy(xpath = "//div[@id='leftPanel']//a[@href='findtrans.htm']")
    private WebElement FindTransactionLink;

    @FindBy(xpath = "//div[@id='leftPanel']/ul/li[6]/a")
    private WebElement updateContactInfoBtn;

    @FindBy(xpath = "//div[@id='leftPanel']/ul/li[7]/a")
    private WebElement requestLoanBtn;

    @FindBy(xpath = "//div[@id='leftPanel']/ul/li[8]/a")
    private WebElement logOutBtn;

    @FindBy(xpath = "//div[@id='showOverview']/h1")
    private WebElement verifyAccountOverview;

    public void overviewVerify(){
        verifyDisplayed(verifyAccountOverview,"account overview is displayed");
    }

    public void openNewAccountButton(){
        clickElement(openNewAccountBtn);
    }

    public void accountOverviewButton(){
        clickElement(accountsOverviewbtn);
    }

    public void clicktransferFundsLink(){
        clickElement(TransferFundsLink);
    }

    public void billPayButton(){
        clickElement(billPayBtn);
    }

    public void clickfindTransactionLink(){
        clickElement(FindTransactionLink);
    }

    public void updateContactInfoBtn(){
        clickElement(updateContactInfoBtn);
    }
    public void requestLoanBtn(){
        clickElement(requestLoanBtn);
    }

    public void logOutButton(){
        clickElement(logOutBtn);
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
