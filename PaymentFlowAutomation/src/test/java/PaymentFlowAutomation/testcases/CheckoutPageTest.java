package PaymentFlowAutomation.testcases;

import java.time.Duration;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PaymentFlowAutomation.base.TestBase;
import PaymentFlowAutomation.pages.CheckoutPage;
import PaymentFlowAutomation.pages.PaymentPage;

public class CheckoutPageTest extends TestBase {

	PaymentPage paymentPage;
	CheckoutPage checkoutPage;
	String defAmount;

	public CheckoutPageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws InterruptedException {
		initialization();
		paymentPage = new PaymentPage();
		defAmount = paymentPage.getDefaultAmount();
		checkoutPage = paymentPage.goToCheckoutPage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	//Verify Pay Now by selecting PayNow from wallets
//	@Test
//	public void selectPayNowWallet() throws InterruptedException {
//		checkoutPage.selectWallets();
//		checkoutPage.payUsingPayNowWallet();
//		checkoutPage.clickOnPayNow();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		System.out.println(driver.getTitle());
//	}

	//Verify Pay Now by selecting Atome option from BNPL
	@Test
	public void selectbnplPaymentOption() throws InterruptedException {
		checkoutPage.selectbnpl();
		checkoutPage.payUsingAtomeBNPL();
		checkoutPage.clickOnPayNow();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String paymentFail = checkoutPage.atomePaymentFailedPopup();
		System.out.println(paymentFail);
	}

	//Verify checkout amount is same as in the payment page
//	@Test
//	public void validateCheckoutAmount() throws InterruptedException {
//		String checkoutAmt = "";
//
//		Thread.sleep(3000);
//		System.out.println(checkoutPage.getAmount());
//		String[] checkoutAmts = (checkoutPage.getAmount().split(" ")[1]).split("\\.");
//		if(checkoutAmts.length > 1 && String.valueOf(Math.round(Float.valueOf(checkoutAmts[1]))).equals("0")) {
//			checkoutAmt = checkoutAmts[0];
//		}else  {
//			checkoutAmt = checkoutPage.getAmount().split(" ")[1];
//		}
//
//		Assert.assertEquals(checkoutAmt, defAmount);
//	}

	//Verify Pay Now button by not selecting any payment option
//	@Test
//	public void payNowWithoutPaymentOption() {
//		String defAlertMsg = "Please select a payment option!";
//		checkoutPage.clickOnPayNow();
//		String invalidAlertMsg = checkoutPage.showAlert();
//		Assert.assertEquals(invalidAlertMsg, defAlertMsg);
//	}

	//Verify Pay Now button by not entering credit card number completely
//	@Test
//	public void enterCreditcardNumb() throws InterruptedException {
//
//		String defPaymentFailedAlert = "Payment Failed!";
//		checkoutPage.selectCreditCard();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//		checkoutPage.clickOnCardNumb("1111");
//		checkoutPage.clickOnPayNow();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//		String payFailAlrt = checkoutPage.showPaymentFailedAlert();
//		Assert.assertEquals(payFailAlrt, defPaymentFailedAlert);
//	}

//	@AfterMethod
//	public void closeBrowser() {
//		driver.quit();
//	}
}
