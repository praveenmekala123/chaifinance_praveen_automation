package PaymentFlowAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PaymentFlowAutomation.base.TestBase;

public class CheckoutPage extends TestBase {

	@FindBy(xpath="(//span[@class='totalAmountCount'])[1]")
	WebElement checkoutAmount;

	@FindBy(id="savedPaymentOptionWeb")
	WebElement getSavedCards;

	@FindBy(id="PayNowButtonWeb")
	WebElement checkoutButton;

	@FindBy(id="walletlang")
	WebElement selectWallet;

	@FindBy(id="bnpllang")
	WebElement bnpl;

	@FindBy(id="creditcardlang")
	WebElement creditCard;

	@FindBy(id="CardNumber")
	WebElement cardNumber;

	@FindBy(id="OMISE-OMISE_PAYNOW")
	WebElement selectPayNowWallet;

	@FindBy(id="ATOME-ATOME_BNPL")
	WebElement selectAtome;
	
	@FindBy(className="statusMessage")
	WebElement atomePaymentFail;

	@FindBy(id="invalidOptionAlert")
	WebElement alert;

	@FindBy(id="paymentFailedId")
	WebElement paymentFailedAlert;


	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}

	//Method to click on wallets
	public void selectWallets() {
		selectWallet.click();
	}

	//Method to click on BNPL
	public void selectbnpl() {
		bnpl.click();
	}

	//Method to select credit card
	public void selectCreditCard() {
		creditCard.click();
	}

	//Method to click on card number field
	public void clickOnCardNumb(String cardNumb) {
		cardNumber.sendKeys(cardNumb);
	}

	//Method to click on Pay Now button
	public void clickOnPayNow() {
		checkoutButton.click();
	}

	//Method to select PayNow wallet
	public void payUsingPayNowWallet() {
		selectPayNowWallet.click();
	}

	//Method to select Atome BNPL 
	public void payUsingAtomeBNPL() {
		selectAtome.click();
	}
	
	public String atomePaymentFailedPopup() {
		return atomePaymentFail.getText();
	}

	//Method to get the amount in the checkout page
	public String getAmount() {
		String amtValue = checkoutAmount.getText();
		return amtValue;
	}

	//Method to show invalid option alert
	public String showAlert() {
		return alert.getText();
	}

	//Method to show payment failed alert
	public String showPaymentFailedAlert() {
		return paymentFailedAlert.getText();
	}
}
