package PaymentFlowAutomation.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PaymentFlowAutomation.base.TestBase;

public class PaymentPage extends TestBase{

	//PageFactory
	@FindBy(id = "amount")
	WebElement amount;

	@FindBy(className = "MuiButton-root")
	WebElement payNowButton;

	@FindBy(className = "MuiPaper-root")
	WebElement errorMessage;

	@FindBy(className = "MuiFormHelperText-root")
	WebElement invalidAmountError;

	@FindBy(id = "mySelect")
	WebElement language;

	@FindBy(linkText = "Payment pages docs")
	WebElement paymentPagesDocs;


	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}

	//Method to get page title

	public String getPageTitle() {

		return driver.getTitle();
	}

	//Method to get default amount

	public String getDefaultAmount() {

		return amount.getAttribute("value");
	}

	//Method to enter amount

	public String enterAmount(String newAmount) {

		amount.click();
		amount.sendKeys(Keys.chord(Keys.COMMAND,"a"),Keys.DELETE);
		amount.sendKeys(newAmount);
		return newAmount;

	}

	//Method to empty amount field and get pay now button state

	public Boolean emptyAmountfield() throws InterruptedException {

		amount.click();
		waitForWebElementToAppear(amount);
		amount.sendKeys(Keys.chord(Keys.COMMAND,"a"),Keys.DELETE);
		invalidAmountError.getText();

		Boolean payNowButtonState = payNowButton.isEnabled();
		return payNowButtonState;
	}

	public boolean getPayNowButtonState() {
		return payNowButton.isEnabled();
	}

	//Method to click on pay now button

	public void clickOnPayNowButton() {
		payNowButton.click();
	}

	public String getDefaultLanguage() {
		return language.getText();
	}

	public void viewDocs() {
		paymentPagesDocs.click();
	}
	
	public CheckoutPage goToCheckoutPage() {
		payNowButton.click();
		return new CheckoutPage();
	}

}
