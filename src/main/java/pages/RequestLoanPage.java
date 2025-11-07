package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.security.cert.X509Certificate;

public class RequestLoanPage extends BasePage{

    @FindBy(xpath = "//div[@id='leftPanel']/ul/li[7]")
    private WebElement requestLoanButton;

    @FindBy(xpath = "//input[@id='amount']")
    private WebElement loanAmountSend;

    @FindBy(xpath = "//input[@id='downPayment']")
    private WebElement downPaymentSend;

    @FindBy(xpath = "//select[@id='fromAccountId']")
    private WebElement selectAccount;

    @FindBy(xpath = "//*[@id=\"requestLoanForm\"]/form/table/tbody/tr[4]/td[2]/input")
    private WebElement applyButton;

    @FindBy(xpath = "//div[@id='requestLoanResult']/h1")
    private WebElement requestLoanVerify;

    @FindBy(xpath = "//div[@id='loanRequestApproved']/p")
    private WebElement succesfullyVerify;

    @FindBy(xpath = "//a[@id='newAccountId']")
    private WebElement linkAccount;

    @FindBy(xpath = "//div[@id='accountDetails']/h1")
    private WebElement accountDetailsVerify;

    @FindBy(xpath = "//p[@id='noTransactions']/b")
    private WebElement noTransactionFoundVerify;

    @FindBy(xpath = "//div[@id='loanRequestDenied']/p")
    private WebElement verifyErrorMessage;

    public void clickRequestLoan(){
        clickElement(requestLoanButton);
    }
    public void clickApplyButton(){
        clickElement(applyButton);
    }
    public void clickLinkAccount(){
        clickElement(linkAccount);
    }

    public void fillLoan(String loan){
        sendKeysToElement(loanAmountSend,"50");
    }
    public void fillDown(String down){
        sendKeysToElement(downPaymentSend,"100");
    }
    public void fillInvalidLoan(){
        sendKeysToElement(loanAmountSend,"1000000");
    }
    public void fillInvalidDown(){
        sendKeysToElement(downPaymentSend,"10000");
    }

    public void selectAccount(){
        Select select=new Select(selectAccount);
        select.selectByIndex(0);
    }
    public void verifySuccessfully(){
        verifyDisplayed(succesfullyVerify,"Congratulations, your credit has been approved message did not appear.");
    }
    public void verifyRequest(){
        verifyDisplayed(requestLoanVerify,"request loan is not displayed");
    }

    public void verifyAccountDetailsAndNoTranscation(){
        verifyDisplayed(accountDetailsVerify,"account details is not displayed");
        verifyDisplayed(noTransactionFoundVerify,"no transaction text is not displayed");
    }
    public void verifyErrorPayment(){
        verifyDisplayed(verifyErrorMessage,"error message is not displayed");
    }


    public RequestLoanPage(WebDriver driver) {
        super(driver);
    }
}
