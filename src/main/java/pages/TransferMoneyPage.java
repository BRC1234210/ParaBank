package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TransferMoneyPage extends BasePage {

    @FindBy(xpath = "//div[@id='leftPanel']//a[@href='transfer.htm']")
    private WebElement TransferFundsLink;

    @FindBy(xpath = "//form[@id='transferForm']//input[@id='amount']")
    private WebElement amountBox;

    @FindBy(xpath = "//select[@id='fromAccountId']")
    private WebElement fromAccount;

    @FindBy(xpath = "//select[@id='toAccountId']")
    private WebElement toAccount;

    @FindBy(xpath = "//input[@value='Transfer']")
    private WebElement transferButton;

    @FindBy(xpath = "//div[@id='showResult']/h1")
    private WebElement TransferCompleteText;

    @FindBy(xpath = "//div[@id='leftPanel']//a[@href='findtrans.htm']")
    private WebElement FindTransactionLink;

    @FindBy(xpath = "//select[@id='accountId']")
    private WebElement SelectAccountId;

    @FindBy(xpath = "//input[@id='amount']")
    private WebElement EnterFindAmount;

    @FindBy(xpath = "//button[@id='findByAmount']")
    private WebElement FindTransactionBtn;

    @FindBy(xpath = "//div[@id='resultContainer']/h1")
    private WebElement TransactonResults;

    public void TransactionResultsText(){
        verifyDisplayed(TransferCompleteText, "Transaction Results not visible");
    }
    public void ClickFindTransactionButton(){
        clickElement(FindTransactionBtn);
    }

    public void clickFindTransactionLink(){
        clickElement(FindTransactionLink);
    }

    public void CompleteFindTransaction() {
        Select select = new Select(SelectAccountId);
        select.getFirstSelectedOption();
        clickElement(EnterFindAmount);
        sendKeysToElement(EnterFindAmount, "50");

    }

    public void TransferCompleteMessage() {
        verifyDisplayed(TransferCompleteText, "Transfer Complete Message is not seen");
    }

    public void clickTransferButton() {
        clickElement(transferButton);
    }

    public void moneyTransfer() {
        Select select = new Select(fromAccount);
        select.getFirstSelectedOption();
        Select select1 = new Select(toAccount);
        select1.selectByIndex(1);
    }

    public void enterAmount() {
        clickElement(amountBox);
        sendKeysToElement(amountBox, "50");
    }

    public TransferMoneyPage(WebDriver driver) {
        super(driver);
    }

    public void clickTransferFunds() {
        clickElement(TransferFundsLink);
    }
}
