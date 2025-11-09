package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class BillpayPage extends BasePage {

    @FindBy(xpath = "//div[@id='leftPanel']/ul/li[4]/a")
    private WebElement billPaypageclick;
    @FindBy(xpath = "//input[@name='payee.name']")
    private WebElement payeeName;
    @FindBy(xpath = "//input[@name='payee.address.street']")
    private WebElement adressPayee;
    @FindBy(xpath = "//input[@name='payee.address.city']")
    private WebElement cityPayee;
    @FindBy(xpath = "//input[@name='payee.address.state']")
    private WebElement statePayee;
    @FindBy(xpath = "//input[@name='payee.address.zipCode']")
    private WebElement zipCodePayee;
    @FindBy(xpath = "//input[@name='payee.phoneNumber']")
    private WebElement phoneNumber;
    @FindBy(xpath = "//input[@name='payee.accountNumber']")
    private WebElement account;
    @FindBy(xpath = "//input[@name='verifyAccount']")
    private WebElement verifyAccount;
    @FindBy(xpath = "//input[@name='amount']")
    private WebElement amountInput;
    @FindBy(xpath = "//select[@name='fromAccountId']")
    private WebElement formAccountselect;
    @FindBy(xpath = "//input[@type='button']")
    private WebElement sendPaymentBtn;
    @FindBy(xpath = "//div[@id='billpayResult']")
    private WebElement billpayText;
    @FindBy(xpath = "//span[@id='amount']")
    private WebElement amountVerifyText;
    @FindBy(xpath = "fromAccountId")
    private WebElement accountVerifyText;

    //AccountOverView Page
    @FindBy(xpath = "//div[@id='leftPanel']/ul/li[2]/a")
    private WebElement accountsOverviewbtn;
    // accountoverview.click/homepage
    @FindBy(xpath = "//tbody/tr/td/a")
    private WebElement accountClick;

    @FindBy(xpath = "//table[@id='transactionTable']/tbody/tr/td")
    private WebElement paymentDateverify1;
    @FindBy(xpath = "//table[@id='transactionTable']/tbody/tr/td/a")
    private WebElement paymentNameVerifiy1;
    @FindBy(xpath = "//table[@id='transactionTable']/tbody/tr/td[3]")
    private WebElement debitVerify1;

    @FindBy(xpath = "//table[@id='transactionTable']/tbody/tr[2]/td")
    private WebElement PaymentDateverify2;
    @FindBy(xpath = "//table[@id='transactionTable']/tbody/tr[2]/td/a")
    private WebElement paymentNameVerifiy2;
    @FindBy(xpath = "//table[@id='transactionTable']/tbody/tr[2]/td[3]")
    private WebElement DebitVerify2;

    @FindBy(xpath = "//table[@id='transactionTable']/tbody/tr[3]/td")
    private WebElement PaymentDateverify3;
    @FindBy(xpath = "//table[@id='transactionTable']/tbody/tr[3]/td/a")
    private WebElement paymentNameVerifiy3;
    @FindBy(xpath = "//table[@id='transactionTable']/tbody/tr[3]/td[3]")
    private WebElement DebitVerify3;

    public BillpayPage(WebDriver driver) {
        super(driver);
    }

    public void bilpaypage(){
        wait.until(ExpectedConditions.elementToBeClickable(billPaypageclick));
        billPaypageclick.click();
    }

    public void fillPayeeinfo(final String payeename, final String address,
                              final String city, final String state,
                              final String zipcode, final String phone) {

        sendKeysToElement(payeeName, payeename);
        sendKeysToElement(adressPayee, address);
        sendKeysToElement(cityPayee, city);
        sendKeysToElement(statePayee, state);
        sendKeysToElement(zipCodePayee, zipcode);
        sendKeysToElement(phoneNumber, phone);

    }

    public void sendAccountInfo(){
        account.sendKeys(formAccountselect.getText());
        verifyAccount.sendKeys(formAccountselect.getText());
    }
    public void fillAmountInput(String amount){
        amountInput.sendKeys(amount);
    }
    public void sendPay(){
        sendPaymentBtn.click();
    }

    public void verifyPaymentText(){
        wait.until(ExpectedConditions.visibilityOf(billpayText));
        Assert.assertTrue(billpayText.isDisplayed(),"Bill pay text is not visible");
        Assert.assertTrue(amountVerifyText.isDisplayed(),"Amount verify text is not visible");
        Assert.assertEquals(formAccountselect.getText(),accountVerifyText.getText(),"Account number is not equal");
    }
    public void clickOverViewpage(){
        accountsOverviewbtn.click();
        wait.until(ExpectedConditions.visibilityOf(account));
        account.click();
    }


    public void verifyPayment1(){
        wait.until(ExpectedConditions.visibilityOf(paymentDateverify1));
        Assert.assertTrue(paymentDateverify1.isDisplayed(),"Date of payment is not visible");
        Assert.assertTrue(paymentNameVerifiy1.isDisplayed(),"Name of payment is not visible");
        Assert.assertTrue(debitVerify1.isDisplayed(),"Debit of payment is not visible");
    }

    public void verifyPayment2(){
        Assert.assertTrue(PaymentDateverify2.isDisplayed(),"Date of payment is not visible");
        Assert.assertTrue(paymentNameVerifiy2.isDisplayed(),"Name of payment is not visible");
        Assert.assertTrue(DebitVerify2.isDisplayed(),"Debit of payment is not visible");
    }

    public void verifyPayment3(){
        Assert.assertTrue(PaymentDateverify3.isDisplayed(),"Date of payment is not visible");
        Assert.assertTrue(paymentNameVerifiy3.isDisplayed(),"Name of payment is not visible");
        Assert.assertTrue(DebitVerify3.isDisplayed(),"Debit of payment is not visible");
    }
}
