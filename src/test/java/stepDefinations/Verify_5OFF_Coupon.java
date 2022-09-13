package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SetUpClass.BaseClass;
import SetUpClass.CommonClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.junit.Assert;

public class Verify_5OFF_Coupon extends BaseClass {
	CommonClass commonPage = new CommonClass(driver);
	String verify_price;
	WebElement joinNow;

	String monthy_Price = "$47.49";
	String semi_Annual_Price = "$142.49";
	String annual_Price = "$237.49";
	String annual_Custom_Design_Price = "$284.99";
	String annual_4_user_Licence_Price = "$569.99";
	String annual_20_user_Licence_Price = "$1,519.99";
	String annual_unlimted_user_Licence_Price = "$2,849.99";
	String annual_15_user_education_Licence_Price = "$949.99";
	String annual_unlimted_user_education_Licence_Price = "$1,899.99";

	@Given("User is on Home Page and click on Login button")

	public void User_is_on_Home_Page_and_click_on_Login_button() throws Throwable {
		Thread.sleep(3000);
		driver.get(AppURL);

		log.info("It's opening the website URL");
		BaseClass.ClearBrowserCache();
		WebElement signin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("signin"))));
		signin.click();
		Thread.sleep(3000);

	}

	@Then("Enter username {string} and passwordi {string}")
	public void Enter_username_and_passwordi(String username, String password) throws InterruptedException {
		Thread.sleep(4000);
		try {
			WebElement email = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("email-Address"))));
			email.sendKeys(username);

			WebElement password_field = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("password"))));
			password_field.sendKeys(password);
			Thread.sleep(2000);
			WebElement login_btn = BaseClass.elementToBeClickable(By.xpath(OR.getProperty("login_Btn")));
			login_btn.click();
			Thread.sleep(3000);
			if (!driver.findElements(By.xpath(OR.getProperty("logon_Pop-Up"))).isEmpty()) {
				WebElement approve = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("approve_Btn"))));
				approve.click();
			}
			Thread.sleep(4000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("click on join now monthly option")
	public void click_on_join_now_monthly_option() throws InterruptedException {

		try {
			joinNow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("joinNow_Monthly"))));
			js.executeScript("arguments[0].scrollIntoView();", joinNow);
			joinNow.click();
			Thread.sleep(7000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	@Then("verify that user should be on checkout page")
	public void verify_that_user_should_be_on_checkout_page() {

		commonPage.verifyTitle();

	}

	@Then("select the radio button for coupon code and stripe option")
	public void select_the_radio_button_for_coupon_code_and_stripe_option() throws InterruptedException {

		commonPage.stripeOption();

	}

	@Then("verify the price for stripe option")
	public void verify_the_price_for_stripe_option() {

		verify_price = commonPage.verifyPrice();

		Assert.assertTrue("5off coupon is not applied successfully", verify_price.equals(monthy_Price));

	}

	@Then("remove the coupon code")
	public void remove_the_coupon_code() throws InterruptedException {

		commonPage.removeCoupon();

	}

	@Then("again select the radio button for coupon code and paypal option")
	public void again_select_the_radio_button_for_coupon_code_and_paypal_option() throws InterruptedException {

		commonPage.payPalOPtion();

	}

	@Then("verify the price for paypal")
	public void verify_the_price_for_paypal() {

		verify_price = commonPage.verifyPrice();

		Assert.assertTrue("5off coupon is not applied successfully", verify_price.equals(monthy_Price));

	}

	@Then("remove the coupon code and check the message")
	public void remove_the_coupon_code_and_check_the_message() throws InterruptedException {

		commonPage.removeCoupon();

	}

	@Then("navigates back to the pricing page")
	public void navigates_back_to_the_pricing_page() throws InterruptedException {
		commonPage.navigatesBack();
	}

	@Then("click on join now semi Annual option")
	public void click_on_join_now_semi_annual_option() throws InterruptedException {

		joinNow = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("indiviaual_semi_Annual"))));
		js.executeScript("arguments[0].scrollIntoView();", joinNow);
		joinNow.click();
		Thread.sleep(4000);

	}

	@Then("Verify that user should be on checkout page")
	public void Verify_that_user_should_be_on_checkout_page() {

		commonPage.verifyTitle();

	}

	@Then("Select the radio button for coupon code and stripe option")
	public void Select_the_radio_button_for_coupon_code_and_stripe_option() throws InterruptedException {

		commonPage.stripeOption();

	}

	@Then("verify the price for stripe options")
	public void verifsy_the_price_for_stripe_options() {

		verify_price = commonPage.verifyPrice();

		Assert.assertTrue("5off coupon is not applied successfully", verify_price.equals(semi_Annual_Price));

	}

	@Then("remove the applied coupon code")
	public void remove_the_applied_coupon_code() throws InterruptedException {

		commonPage.removeCoupon();
	}

	@Then("Again select the radio button for coupon code and paypal option")
	public void Again_select_the_radio_button_for_coupon_code_and_paypal_option() throws InterruptedException {

		commonPage.payPalOPtion();

	}

	@Then("Verify the price for paypal")
	public void Verify_the_price_for_paypal() {

		verify_price = commonPage.verifyPrice();

		Assert.assertTrue("5off coupon is not applied successfully", verify_price.equals(semi_Annual_Price));

	}

	@Then("Remove the coupon code and check the message")
	public void Remove_the_coupon_code_and_check_the_message() throws InterruptedException {
		Thread.sleep(2000);
		commonPage.removeCoupon();

	}

	@Then("navigates back to the Pricing Page")
	public void navigates_back_to_the_Pricing_Page() throws InterruptedException {

		commonPage.navigatesBack();

	}

	@Then("click on join now Annual option")
	public void click_on_join_now_annual_option() throws InterruptedException {

		WebElement joinNow = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("induvidulal_annual"))));
		joinNow.click();
		Thread.sleep(4000);

	}

	@Then("verify that user should be on Checkout page")
	public void verify_that_user_should_be_on_Checkout_page() {

		commonPage.verifyTitle();

	}

	@Then("select the radio button for coupon code and Stripe option")
	public void select_the_radio_button_for_coupon_code_and_Stripe_option() throws InterruptedException {

		commonPage.stripeOption();

	}

	@Then("Verify the price for stripe option")
	public void Verify_the_price_for_stripe_option() {

		verify_price = commonPage.verifyPrice();

		Assert.assertTrue("5off coupon is not applied successfully", verify_price.equals(annual_Price));

	}

	@Then("Remove the coupon code")
	public void Remove_the_coupon_code() throws InterruptedException {

		commonPage.removeCoupon();

	}

	@Then("again Select the radio button for coupon code and paypal option")
	public void again_Select_the_radio_button_for_coupon_code_and_paypal_option() throws InterruptedException {

		commonPage.payPalOPtion();

	}

	@Then("verify The price for paypal")
	public void verify_The_price_for_paypal() {

		verify_price = commonPage.verifyPrice();

		Assert.assertTrue("5off coupon is not applied successfully", verify_price.equals(annual_Price));

	}

	@Then("remove The coupon code and check the message")
	public void remove_The_coupon_code_and_check_the_message() throws InterruptedException {
		Thread.sleep(2000);
		commonPage.removeCoupon();

	}

	@Then("navigates back to the pricing pages")
	public void navigates_back_to_the_pricing_pages() throws InterruptedException {
		commonPage.navigatesBack();
	}

	@Then("click on join now Annual+Design option")
	public void click_on_join_now_annual_design_option() throws InterruptedException {

		joinNow = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("individual_Annual+Design"))));
		joinNow.click();
		Thread.sleep(4000);

	}

	@Then("verify that user should be on checkout Page")
	public void verify_that_user_should_be_on_checkout_Page() {

		commonPage.verifyTitle();

	}

	@Then("select the Radio button for coupon code and stripe option")
	public void select_the_Radio_button_for_coupon_code_and_stripe_option() throws InterruptedException {

		commonPage.stripeOption();

	}

	@Then("verify the Price for stripe option")
	public void verify_the_Price_for_stripe_option() {

		verify_price = commonPage.verifyPrice();

		Assert.assertTrue("5off coupon is not applied successfully", verify_price.equals(annual_Custom_Design_Price));

	}

	@Then("Remove the Coupon code")
	public void Remove_the_Coupon_code() throws InterruptedException {

		commonPage.removeCoupon();

	}

	@Then("again select The radio button for coupon code and paypal option")
	public void again_select_The_radio_button_for_coupon_code_and_paypal_option() throws InterruptedException {

		commonPage.payPalOPtion();

	}

	@Then("verify the Price for paypal")
	public void verify_the_Price_for_paypal() {

		verify_price = commonPage.verifyPrice();
		System.out.println("verify_price= " +verify_price); 
		Assert.assertTrue("5off coupon is not applied successfully", verify_price.equals(annual_Custom_Design_Price));

	}

	@Then("remove the Coupon code and check the message")
	public void remove_the_Coupon_code_and_check_the_message() throws InterruptedException {

		commonPage.removeCoupon();

	}

	@Then("Navigates Back to the Pricing Page")
	public void Navigates_Back_to_the_Pricing_Page() throws InterruptedException {
		driver.navigate().refresh();
		commonPage.navigatesBack();
	}

	@Then("select Business Team option")
	public void select_business_team_option() throws Throwable {
		Thread.sleep(3000);
		WebElement businessTeam = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("businessTeam"))));
		businessTeam.click();
		Thread.sleep(4000);
	}

	@Then("click on join now Annual four user licence option")
	public void click_on_join_now_Annual_four_user_licence_option() throws InterruptedException {
		joinNow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("annual_4_User_Lience"))));
		joinNow.click();
		Thread.sleep(4000);
	}

	@Then("verify that user should be on Checkout Page")
	public void verify_that_user_should_be_on_Checkout_Page() {
		commonPage.verifyTitle();
	}

	@Then("Select the Radio button for coupon code and stripe option")
	public void Select_the_Radio_button_for_coupon_code_and_stripe_option() throws InterruptedException {
		commonPage.stripeOption();
	}

	@Then("verify the price for stripe Option")
	public void verify_the_price_for_stripe_Option() {
		verify_price = commonPage.verifyPrice();

		Assert.assertTrue("5off coupon is not applied successfully",
				verify_price.equals(annual_4_user_Licence_Price));
	}

	@Then("Remove the Coupon Code")
	public void Remove_the_Coupon_Code() throws InterruptedException {
		commonPage.removeCoupon();
	}

	@Then("again select the Radio button for coupon code and paypal option")
	public void again_select_the_Radio_button_for_coupon_code_and_paypal_option() throws InterruptedException {
		commonPage.payPalOPtion();
	}

	@Then("verify the price For paypal")
	public void verify_the_price_For_paypal() {
		verify_price = commonPage.verifyPrice();
		Assert.assertTrue("5off coupon is not applied successfully",
				verify_price.equals(annual_4_user_Licence_Price));
	}

	@Then("remove the coupon Code and check the message")
	public void remove_the_coupon_Code_and_check_the_message() throws InterruptedException {
		commonPage.removeCoupon();
	}

	@Then("Navigates back to the pricing page")
	public void Navigates_back_to_the_pricing_page() throws InterruptedException {
		commonPage.navigatesBack();
		WebElement businessTeam = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("businessTeam"))));
		businessTeam.click();
	}

	@Then("click on join now Annual twenty user licence option")
	public void click_on_join_now_annual_twenty_user_licence_option() throws InterruptedException {
		joinNow = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("annual_20_User_Lience"))));
		joinNow.click();
		Thread.sleep(4000);
	}

	@Then("Verify that user should be on Checkout page")
	public void Verify_that_user_should_be_on_Checkout_page() {
		commonPage.verifyTitle();

	}

	@Then("select the radio button for Coupon Code and stripe option")
	public void select_the_radio_button_for_Coupon_Code_and_stripe_option() throws InterruptedException {
		commonPage.stripeOption();
	}

	@Then("verify the price For Stripe option")
	public void verify_the_price_For_Stripe_option() {
		verify_price = commonPage.verifyPrice();

		Assert.assertTrue("5off coupon is not applied successfully",
				verify_price.equals(annual_20_user_Licence_Price));
	}

	@Then("remove the Applied coupon code")
	public void remove_the_Applied_coupon_code() throws InterruptedException {
		commonPage.removeCoupon();
	}

	@Then("again select the radio button For coupon code and paypal option")
	public void again_select_the_radio_button_For_coupon_code_and_paypal_option() throws InterruptedException {
		commonPage.payPalOPtion();
	}

	@Then("verify the price for Paypal")
	public void verify_the_price_for_Paypal() {
		verify_price = commonPage.verifyPrice();

		Assert.assertTrue("5off coupon is not applied successfully",
				verify_price.equals(annual_20_user_Licence_Price));
	}

	@Then("remove the coupon code nd Check the message")
	public void remove_the_coupon_code_nd_check_the_message() throws InterruptedException {
		commonPage.removeCoupon();
	}

	@Then("navigates Back to the pricing page")
	public void navigates_Back_to_the_pricing_page() throws InterruptedException {
		commonPage.navigatesBack();
		WebElement businessTeam = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("businessTeam"))));
		businessTeam.click();
	}

	@Then("click on join now unlimted user licence option")
	public void click_on_join_now_unlimted_user_licence_option() throws InterruptedException {
		joinNow = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("annual_unlimted_User_Lience"))));
		joinNow.click();
		Thread.sleep(4000);
	}

	@Then("Verify that user should be on Checkout Page")
	public void Verify_that_user_should_be_on_Checkout_Page() {
		commonPage.verifyTitle();

	}

	@Then("Select the Radio button for Coupon code and stripe option")
	public void Select_the_Radio_button_for_Coupon_code_and_stripe_option() throws InterruptedException {
		commonPage.stripeOption();
	}

	@Then("Verify the price for Stripe option")
	public void Verify_the_price_for_Stripe_option() {
		verify_price = commonPage.verifyPrice();

		Assert.assertTrue("5off coupon is not applied successfully",
				verify_price.equals(annual_unlimted_user_Licence_Price));
	}

	@Then("remove the Applied coupon")
	public void remove_the_applied_coupon() throws InterruptedException {
		commonPage.removeCoupon();
	}

	@Then("again select the radio button for Coupon code and paypal option")
	public void again_select_the_radio_button_for_Coupon_code_and_paypal_option() throws InterruptedException {
		commonPage.payPalOPtion();
	}

	@Then("Verify the price for Paypal")
	public void Verify_the_price_for_Paypal() {
		verify_price = commonPage.verifyPrice();

		Assert.assertTrue("5off coupon is not applied successfully",
				verify_price.equals(annual_unlimted_user_Licence_Price));
	}

	@Then("remove the coupon code and check the Message")
	public void remove_the_coupon_code_and_check_the_Message() throws InterruptedException {
		commonPage.removeCoupon();
	}

	@Then("navigates back To the pricing page")
	public void navigates_back_To_the_pricing_page() throws InterruptedException {
		commonPage.navigatesBack();
	}

	@Then("select Education option")
	public void select_education_option() throws Throwable {
		
		WebElement education = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("education"))));
		education.click();

	}

	@Then("click on join now Annual user licence option")
	public void click_on_join_now_annual_user_licence_option() throws InterruptedException {
		joinNow = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("annual_20_User_education_Lience"))));
		joinNow.click();
		Thread.sleep(4000);

	}

	@Then("Verify That user should be on checkout page")
	public void Verify_That_user_should_be_on_checkout_page() {
		commonPage.verifyTitle();

	}

	@Then("Select the radio button for coupon code and Stripe OPtion")
	public void select_the_radio_button_for_coupon_code_and_stripe_OPtion() throws InterruptedException {
		commonPage.stripeOption();
	}

	@Then("Verify the Price For Stripe Option")
	public void Verify_the_Price_For_Stripe_Option() {
		verify_price = commonPage.verifyPrice();

		Assert.assertTrue("5off coupon is not applied successfully",
				verify_price.equals(annual_15_user_education_Licence_Price));
	}

	@Then("Remove the coupon")
	public void remove_the_coupon() throws InterruptedException {
		commonPage.removeCoupon();
	}

	@Then("again select the radio button for coupon Code and paypal option")
	public void again_select_the_radio_button_for_coupon_Code_and_paypal_option() throws InterruptedException {
		commonPage.payPalOPtion();
	}

	@Then("Verify The price for paypal")
	public void Verify_The_price_for_paypal() {
		verify_price = commonPage.verifyPrice();
		Assert.assertTrue("5off coupon is not applied successfully",
				verify_price.equals(annual_15_user_education_Licence_Price));
	}

	@Then("Remove the coupon code and check the Message")
	public void Remove_the_coupon_code_and_check_the_Message() throws InterruptedException {
		commonPage.removeCoupon();
	}

	@Then("navigates back to The pricing page")
	public void navigates_back_to_The_pricing_page() throws InterruptedException {
		commonPage.navigatesBack();
		WebElement education = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("education"))));
		education.click();

	}

	@Then("click on join now unlimted users licence option")
	public void click_on_join_now_unlimted_users_licence_option() throws InterruptedException {
		joinNow = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(OR.getProperty("annual_unlimited_institute_wides_Lience"))));
		joinNow.click();
		Thread.sleep(4000);

	}

	@Then("Verify That User Should be on checkout page")
	public void Verify_That_User_Should_be_on_checkout_page() {
		commonPage.verifyTitle();

	}

	@Then("select The Radio button For coupon code and stripe option")
	public void select_The_Radio_button_for_coupon_code_and_stripe_option() throws InterruptedException {
		commonPage.stripeOption();
	}

	@Then("verify the Prices for stripe options")
	public void verify_the_prices_for_stripe_options() {
		verify_price = commonPage.verifyPrice();
		Assert.assertTrue("5off coupon is not applied successfully",
				verify_price.equals(annual_unlimted_user_education_Licence_Price));
	}

	@Then("remove The Applied Coupon Code")
	public void remove_the_Applied_Coupon_Code() throws InterruptedException {
		commonPage.removeCoupon();
	}

	@Then("again select the radio button for coupon code and Paypal option")
	public void again_select_the_radio_button_for_coupon_code_and_Paypal_option() throws InterruptedException {
		commonPage.payPalOPtion();
	}

	@Then("Verify The Price for Paypal")
	public void Verify_the_Price_for_Paypal() {
		verify_price = commonPage.verifyPrice();
		Assert.assertTrue("5off coupon is not applied successfully",
				verify_price.equals(annual_unlimted_user_education_Licence_Price));
	}

	@Then("Remove the Coupon code and check the Message")
	public void Remove_the_Coupon_code_and_check_the_Message() throws InterruptedException {
		commonPage.removeCoupon();
	}

	@Then("navigates back to the Pricing page")
	public void navigates_back_to_the_Pricing_page() throws InterruptedException {
		commonPage.signoutApplication();
	}

}
