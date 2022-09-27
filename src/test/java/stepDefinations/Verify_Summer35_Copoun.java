package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SetUpClass.BaseClass;
import SetUpClass.CommonClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Verify_Summer35_Copoun extends BaseClass {
	CommonClass commonPage = new CommonClass(driver);

	String monthyPriceAferSummer35 = "$44.99";

	@Given("User is on Home Page and click on Signup button")
	public void user_is_on_home_page_and_click_on_signup_button() throws Throwable {
		Thread.sleep(3000);
		BaseClass.ClearBrowserCache();
		driver.get(AppURL);

		log.info("It's opening the website URL");
		BaseClass.ClearBrowserCache();
		WebElement signup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("Signup"))));
		signup.click();
		Thread.sleep(3000);
	}

	@Then("Create a new ueser")
	public void create_a_new_ueser() throws InterruptedException {

		// signup the application
		commonPage.signUp();

	}

	@Then("Click on free ppt and download one ppt")
	public void click_on_free_ppt_and_download_one_ppt() throws InterruptedException {

		try {

			Thread.sleep(3000);
			String URL = driver.getCurrentUrl();
			System.out.println("URL = " + URL);
		
			WebElement free_Stuff = elementToBeClickable(By.xpath(OR.getProperty("Free_Stuff")));
			Thread.sleep(3000);
			Actions action = new Actions(driver);
			action.moveToElement(free_Stuff).perform();
			Thread.sleep(3000);
			WebElement free_ppt = elementToBeClickable(By.xpath(OR.getProperty("Free_PPT")));
			action.moveToElement(free_ppt).click().perform();
			
			// download 1 ppt

			// select ppt under free stuff

			Thread.sleep(3000);
			System.out.println("locator = " + OR.getProperty("selectPPT1"));
			WebElement select_ppt = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("selectPPT1"))));
			js.executeScript("arguments[0].scrollIntoView(true);", select_ppt);

			select_ppt.click();
			Thread.sleep(3000);

			WebElement download = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("downloadPPT"))));
			download.click();
			Thread.sleep(3000);

			commonPage.navigatesBack();

		} catch (NoSuchElementException e) {

		}
	}

	@Then("Again download the another ppt")
	public void again_download_the_another_ppt() throws InterruptedException {
		Thread.sleep(3000);
		WebElement select_ppt = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("selectPPT2"))));
		select_ppt.click();

		WebElement download = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("downloadPPT"))));
		download.click();
		Thread.sleep(3000);
	}

	@Then("Copy and Paste the cpupon code and verify the code")
	public void copy_and_paste_the_cpupon_code_and_verify_the_code() {
		commonPage.copySummer35Coupon();

	}

	@Then("User will go the pricing page")
	public void user_will_go_the_pricing_page() throws InterruptedException {

		// user will navigates to the pricing page
		WebElement pricing = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("pricing"))));
		pricing.click();
		Thread.sleep(3000);

	}

	@Then("Click on join now option")
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

	@Then("Apply the discount coupon code")
	public void apply_the_discount_coupon_code() {

		// user will navigates to the checkout page. verify the checkout page
		commonPage.verifyTitle();

		commonPage.applySummer35Coupon();

	}

	@Then("Verify the price")
	public void verify_the_price() throws InterruptedException {
		String verify_price = commonPage.verifyPrice();
		System.out.println("verify_price = " + verify_price);
		Assert.assertEquals("Summer35coupon is not applied successfully", verify_price, monthyPriceAferSummer35);
		commonPage.removeCoupon();

	}

	@Then("Delete the user account")
	public void delete_the_user_account() {
		// delete the account
		commonPage.deleteAccount();
	}

	@Given("user is on home page click on sign in button")
	public void user_is_on_home_page_click_on_sign_in_button() {

		WebElement signin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("signin"))));
		signin.click();

	}

	@Then("Enter Username {string} and Password {string}")
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

	@Then("User should go to the pricing page")
	public void user_should_go_to_the_pricing_page() {

	}

	@Then("click on join Now option")
	public void click_on_join_Now_option() {

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

	@Then("Apply the discount coupon code {string}")
	public void apply_the_discount_coupon_code(String coupon) throws InterruptedException {

		if (!driver.findElements(By.xpath(OR.getProperty("remove_Coupon"))).isEmpty()) {
			commonPage.removeCoupon();

		}
		WebElement selectDiscountRadionButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("selectCheckBox"))));
		Thread.sleep(3000);
		selectDiscountRadionButton.click();
		Thread.sleep(2000);

		WebElement enterCouponCode = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("enterCouponCode"))));
		enterCouponCode.sendKeys(coupon);

	}

	@Then("verify the Price")
	public void verify_the_Price() {

		String verify_price = commonPage.verifyPrice();
		System.out.println("verify_price = " + verify_price);
		// Assert.assertEquals("Summer35coupon is not applied successfully",
		// verify_price, monthyPriceAferSummer35);

	}

	@Then("signout from the application")
	public void signout_from_the_application() {
		commonPage.signoutApplication();
	}

}
