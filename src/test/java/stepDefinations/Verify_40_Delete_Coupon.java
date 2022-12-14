package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SetUpClass.BaseClass;
import SetUpClass.CommonClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Verify_40_Delete_Coupon extends BaseClass {

	CommonClass commonPage = new CommonClass(driver);
	String monthyPriceAferDeleteDiscountCoupon = "$29.99";

	@Given("User is on Home Page then click on Signup button")
	public void user_is_on_home_page_then_click_on_signup_button() throws Throwable {
		Thread.sleep(3000);
		ClearBrowserCache();
		driver.get(AppURL);

		log.info("It's opening the website URL");
		ClearBrowserCache();
		WebElement signup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("Signup"))));
		signup.click();
		Thread.sleep(3000);
	}

	@Then("Creates a new ueser")
	public void creates_a_new_ueser() {
		// signup the application
		commonPage.signUp();

	}

	@Then("Click on account botton")
	public void click_on_account_botton() {
		try {
			Thread.sleep(2000);
			WebElement account = driver.findElement(By.xpath("//a[contains(.,'My Account')]"));
			js.executeScript("arguments[0].click();", account);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("Click on delete button")
	public void click_on_delete_button() {
		try {
			WebElement Delete_Account = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='clicking']")));
			Thread.sleep(2000);
			js.executeScript("arguments[0].click();", Delete_Account);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("select one of radio button and clcik on delete profile")
	public void select_one_of_radio_button_and_clcik_on_delete_profile() {
		try {
			WebElement radio_button = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='option1']")));
			Thread.sleep(4000);
			radio_button.click();
			Thread.sleep(1000);

			WebElement delete_Profile = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Delete Profile']")));
			js.executeScript("arguments[0].scrollIntoView();", delete_Profile);
			delete_Profile.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("copy the discount coupon code")
	public void copy_the_discount_coupon_code() {

		commonPage.copyDeleteDiscountCoupon();

	}

	@Then("User will go to the pricing page")
	public void user_will_go_to_the_pricing_page() {

	}

	@Then("Click on Join Now option")
	public void click_on_join_now_option() {
		try {
			WebElement joinNow = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("joinNow_Monthly"))));
			js.executeScript("arguments[0].scrollIntoView();", joinNow);
			joinNow.click();
			Thread.sleep(7000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@Then("Apply the Discount coupon code")
	public void apply_the_discount_coupon_code() {
		commonPage.verifyTitle();

		// apply the coupon
		commonPage.applyDeleteDiscountCoupon();
	}

	@Then("Verify the Price")
	public void verify_the_price() {

		String verify_price = commonPage.verifyPrice();
		System.out.println("verify_price = " + verify_price);
		Assert.assertEquals("Summer35coupon is not applied successfully", verify_price,
				monthyPriceAferDeleteDiscountCoupon);

	}

	@Then("Delete the user Account")
	public void delete_the_user_account() {
		// delete the account
		commonPage.deleteAccount();
	}

	@Given("user is on home page click on Sign in button")
	public void user_is_on_home_page_click_on_sign_in_button() {
		WebElement signin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("signin"))));
		signin.click();
	}

	@Then("enter Username {string} and Password {string}")
	public void enter_username_and_password(String username, String password) throws InterruptedException {

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

	@Then("User should go to the Pricing page")
	public void user_should_go_to_the_pricing_page() {

	}

	@Then("click on Join Now  option")
	public void click_on_Join_Now_option() {
		try {

			WebElement account = driver.findElement(By.xpath("//a[contains(.,'My Account')]"));
			js.executeScript("arguments[0].click();", account);
			Thread.sleep(3000);

			WebElement Delete_Account = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='clicking']")));
			Thread.sleep(2000);
			js.executeScript("arguments[0].click();", Delete_Account);

			WebElement radio_button = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='option1']")));
			Thread.sleep(4000);
			radio_button.click();
			Thread.sleep(1000);

			WebElement delete_Profile = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Delete Profile']")));
			js.executeScript("arguments[0].scrollIntoView();", delete_Profile);
			delete_Profile.click();
			Thread.sleep(2000);

			commonPage.copyDeleteDiscountCoupon();

			WebElement joinNow = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("joinNow_Monthly"))));
			js.executeScript("arguments[0].scrollIntoView();", joinNow);
			joinNow.click();
			Thread.sleep(7000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@Then("Apply the discount Coupon Code")
	public void Apply_the_discount_Coupon_Code() {
		commonPage.applyDeleteDiscountCoupon();
	}

	@Then("verify The Price")
	public void verify_the_Price() {

		String verify_price = commonPage.verifyPrice();
		Assert.assertEquals("40% is not applied successfully", verify_price,
				monthyPriceAferDeleteDiscountCoupon);

	}

	@Then("Signout from the application")
	public void signout_from_the_application() {
		commonPage.signoutApplication();
	}

}
