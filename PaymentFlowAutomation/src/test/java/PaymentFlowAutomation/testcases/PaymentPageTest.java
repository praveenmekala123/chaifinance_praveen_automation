package PaymentFlowAutomation.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Assert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PaymentFlowAutomation.base.TestBase;
import PaymentFlowAutomation.pages.CheckoutPage;
import PaymentFlowAutomation.pages.PaymentPage;

public class PaymentPageTest extends TestBase {

	PaymentPage paymentPage;
	CheckoutPage checkoutPage;

	public PaymentPageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws InterruptedException {
		initialization();
		paymentPage = new PaymentPage();

	}

	//Verify payment page title
	@Test
	public void verifyPaymentPageTitle() {

		String paymentPageTitle = "CHAIPort";
		Assert.assertEquals(paymentPageTitle, paymentPage.getPageTitle());
	}

	//Verify the PayNow button without changing the default value
	@Test
	public void clickOnPayNow() {

		String defaultAmountValue = paymentPage.getDefaultAmount();

		if(defaultAmountValue.length()>0) {
			checkoutPage = paymentPage.goToCheckoutPage();
		}	
	}

	//Verify amount field is clickable or not
	@Test
	public void verifyEditingAmountField() {

		String defaultAmount = paymentPage.getDefaultAmount();
		String newAmount = paymentPage.enterAmount((defaultAmount)+5);


		Assert.assertEquals(newAmount, defaultAmount);
	}

	//Verify editing default amount
	@Test
	public void verifyEditingDefaultAmount() {

		paymentPage.enterAmount("1000");
		paymentPage.clickOnPayNowButton();
	}

	//Verify the Pay Now button state after clearing the amount field
	@Test
	public void makeAmountFieldEmpty() throws InterruptedException {
		Boolean buttonState = true;

		paymentPage.emptyAmountfield();
		Assert.assertEquals(paymentPage.emptyAmountfield(), buttonState);
	}	

	//Verify the Pay Now button state after entering a value less than 1
	@Test
	public void amounttLessThan1() {
		Boolean buttonState = false;

		paymentPage.enterAmount("0");
		boolean state = paymentPage.getPayNowButtonState();

		Assert.assertEquals(state, buttonState);
	}

	//Verify the default selected language 
	@Test
	public void verifyDefaultLanguage() {
		String defaultLanguage = "Singapore";

		Assert.assertEquals(paymentPage.getDefaultLanguage(), defaultLanguage);
	}

	//Verify payment pages docs link
	@Test
	public void verifyDocs() {

		paymentPage.viewDocs();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
