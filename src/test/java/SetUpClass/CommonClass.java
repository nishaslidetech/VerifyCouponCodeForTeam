package SetUpClass;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CommonClass extends BaseClass {

	WebDriver driver;

	String expected_Title = "Checkout";
	WebElement remove_Coupon;
	String success_Message;
	protected String price;
	WebElement Price;
	String delete_Coupon_Message;
	WebElement selectCheckBox;
	WebElement enterCouponCode;
	WebElement apply_Coupon;
	WebElement stripeOption;
	String actual_Title;
	WebElement payPalOption;
	String Summer35Value;
	String copyDeleteDiscountCoupon;

	public CommonClass(WebDriver driver) {

		this.driver = driver;
	}

	public void stripeOption() throws InterruptedException {

		try {

			stripeOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("stripeOption")))); // Thread.sleep(2000);
			js.executeScript("arguments[0].click();", stripeOption);

			// Apply coupon
			Thread.sleep(3000);

			if (!driver.findElements(By.xpath(OR.getProperty("remove_Coupon"))).isEmpty()) {
				removeCoupon();

			}

			selectCheckBox = BaseClass.elementToBeClickable(By.xpath(OR.getProperty("selectCheckBox")));
			js.executeScript("arguments[0].scrollIntoView();", selectCheckBox);
			selectCheckBox.click();
			Thread.sleep(3000);

			enterCouponCode = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("enterCouponCode"))));
			enterCouponCode.sendKeys("5OFF");

			apply_Coupon = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("apply_Coupon"))));
			// js.executeScript("arguments[0].click();",apply_Coupon);
			apply_Coupon.click();
			Thread.sleep(3000);

			// verify the success message
			success_Message = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("success_Message"))))
					.getText();
			System.out.println("success_Message = " + success_Message);
			Thread.sleep(4000);

			Assert.assertTrue("5off coupon is not applied successfully",
					success_Message.contains("Your coupon was successfully applied."));

		} catch (NoSuchElementException popup) {

		}
	}

	public void removeCoupon() throws InterruptedException {

		try {
			remove_Coupon = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("remove_Coupon")))); //
			Thread.sleep(3000);
			remove_Coupon.click();
			Thread.sleep(3000);

			// delete coupon message
			delete_Coupon_Message = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("delete_Coupon_Message"))))
					.getText();

			System.out.println("delete_Coupon_Message = " + delete_Coupon_Message);
			Thread.sleep(4000);

			Assert.assertTrue("5off coupon is not deleted successfully",
					delete_Coupon_Message.contains("Your coupon was successfully removed."));
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void payPalOPtion() throws InterruptedException {

		try {
			driver.navigate().refresh();
			Thread.sleep(6000);
			payPalOption = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("payPalOption"))));
			js.executeScript("arguments[0].click();", payPalOption);
			// payPalOption.click(); Thread.sleep(3000);

			if (!driver.findElements(By.xpath(OR.getProperty("remove_Coupon"))).isEmpty()) {
				removeCoupon();

			}
			// Apply coupon

			Thread.sleep(3000);
			selectCheckBox = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("selectCheckBox"))));
			Thread.sleep(3000);
			selectCheckBox.click();
			// js.executeScript("arguments[0].click();", selectCheckBox);

			enterCouponCode = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("enterCouponCode"))));
			enterCouponCode.sendKeys("5OFF");

			apply_Coupon = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("apply_Coupon"))));
			apply_Coupon.click();
			Thread.sleep(3000);

			// verify the success message
			success_Message = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("success_Message"))))
					.getText();
			Thread.sleep(3000);
			System.out.println("success_Message = " + success_Message);

			Assert.assertTrue("5off coupon is not applied successfully",
					success_Message.contains("Your coupon was successfully applied."));

			// assert condition

		} catch (

		NoSuchElementException popup) {

		}
	}

	public String verifyPrice() {

		try {
			Thread.sleep(3000);
			Price = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("verify_Price"))));
			js.executeScript("window.scrollBy(0,20)", "");
			// js.executeScript("arguments[0].scrollIntoView();", Price);
			price = Price.getText();
			System.out.println("Price = " + price);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return price;
	}

	public void verifyTitle() {

		actual_Title = driver.getTitle();
		System.out.println("Title = " + actual_Title);
		Assert.assertEquals("Title does not match", expected_Title, actual_Title);
	}

	public void navigatesBack() {
		driver.navigate().back();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public void signUp() {
		// create new email for sign up
		try {
			Thread.sleep(5000);
			int leftLimit = 97; // letter 'a'
			int rightLimit = 122; // letter 'z'
			int targetStringLength = 10;
			Random random = new Random();
			StringBuilder buffer = new StringBuilder(targetStringLength);
			for (int i = 0; i < targetStringLength; i++) {
				int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
				buffer.append((char) randomLimitedInt);
			}
			String generatedString = buffer.toString();

			System.out.println(generatedString);

			String full_email = "selenium.testing." + generatedString + "@gmail.com";
			System.out.println(full_email);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			Thread.sleep(2000);
			WebElement new_email_signup = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("new_email_signup"))));
			new_email_signup.sendKeys(full_email);
			Thread.sleep(1000);

			// enter name

			WebElement new_fname_signup = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("first_Name"))));

			new_fname_signup.sendKeys("Selenium");
			Thread.sleep(1000);

			WebElement new_lname_signup = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("last_Name"))));
			new_lname_signup.sendKeys("Testing");
			Thread.sleep(1000);

			// enter password
			WebElement new_pwd_signup = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("password_signup"))));
			new_pwd_signup.sendKeys("selenium@123");

			WebElement new_pwd1_signup = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("confirm_Password"))));
			new_pwd1_signup.sendKeys("selenium@123");
			Thread.sleep(3000);
			// sign up button
			WebElement new_btn_signup = wait
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OR.getProperty("new_btn_signup"))));
			Thread.sleep(3000);
			new_btn_signup.click();
			// js.executeScript("arguments[0].click();", new_btn_signup);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteAccount() {
		try {
			Thread.sleep(2000);
			WebElement account = driver.findElement(By.xpath(OR.getProperty("account")));
			js.executeScript("arguments[0].click();", account);
			Thread.sleep(3000);

			WebElement Delete_Account = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("Delete_Account"))));
			Thread.sleep(2000);
			js.executeScript("arguments[0].click();", Delete_Account);
			Thread.sleep(5000);

			WebElement radio_button = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("radio_button"))));
			Thread.sleep(4000);
			radio_button.click();
			Thread.sleep(1000);

			WebElement delete_Profile = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("delete_Profile"))));
			js.executeScript("arguments[0].scrollIntoView();", delete_Profile);
			delete_Profile.click();
			Thread.sleep(2000);
			WebElement continue_delete = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("continue_delete"))));
			js.executeScript("arguments[0].scrollIntoView();", continue_delete);
			continue_delete.click();
			Thread.sleep(4000);
			String verifyDeleteAccount = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("verifyDeleteAccount"))))
					.getText();
			Thread.sleep(3000);
			Assert.assertTrue("Account is not deleted",
					verifyDeleteAccount.contains("Your account has been deleted successfully."));
			System.out.println("your account delete successfully");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void copySummer35Coupon() {

		// copy the coupon code
		WebElement copySummer35 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("copySummer35"))));
		// copySummer35.click();
		Summer35Value = copySummer35.getAttribute("value");

		System.out.println("Summer35Value = " + Summer35Value);

		WebElement CloseSummer35Popup = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("CloseSummer35Popup"))));
		CloseSummer35Popup.click();

	}

	public void applySummer35Coupon() {
		try {
			if (!driver.findElements(By.xpath(OR.getProperty("remove_Coupon"))).isEmpty()) {
				removeCoupon();

			}
			WebElement selectDiscountRadionButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("selectCheckBox"))));
			Thread.sleep(3000);
			selectDiscountRadionButton.click();
			Thread.sleep(2000);

			WebElement enterCouponCode = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("enterCouponCode"))));
			System.out.println("Summer35Value2 = " + Summer35Value);
			Thread.sleep(2000);
			try {
				enterCouponCode.sendKeys(Summer35Value);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/*
			 * Actions actions = new Actions(driver); actions.sendKeys(Keys.TAB);
			 * actions.build().perform();
			 * 
			 * // Paste the Address in the Permanent Address field using CTRL + V
			 * actions.keyDown(Keys.CONTROL); actions.sendKeys("v");
			 * actions.keyUp(Keys.CONTROL); actions.build().perform();
			 */

			WebElement ApplyCoupon = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("apply_Coupon"))));
			ApplyCoupon.click();

			success_Message = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("success_Message"))))
					.getText();
			Thread.sleep(3000);
			System.out.println("success_Message = " + success_Message);

			Assert.assertTrue("summer35 coupon is not applied successfully",
					success_Message.contains("Your coupon was successfully applied."));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void signoutApplication() {

		try {
			WebElement signout = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("signout"))));
			Thread.sleep(2000);
			js.executeScript("arguments[0].click();", signout);

			Thread.sleep(3000);
			String verifySignOutMessage = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("verifySignOutMessage"))))
					.getText();

			System.out.print("logout= " + verifySignOutMessage);

			/*
			 * Assert.assertTrue("user is not logout from the application",
			 * verifySignOutMessage.contains("YOU ARE NOW LOGGED OUT"));
			 */
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void copyDeleteDiscountCoupon() {
		copyDeleteDiscountCoupon = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("copyDeleteDiscountCoupon"))))
				.getAttribute("value");

		WebElement i_LoveMyDisscount = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("iLoveMyDisscount"))));
		i_LoveMyDisscount.click();

	}

	public void applyDeleteDiscountCoupon() {
		try {

			if (!driver.findElements(By.xpath(OR.getProperty("remove_Coupon"))).isEmpty()) {
				removeCoupon();

			}
			WebElement selectDiscountRadionButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("selectCheckBox"))));
			selectDiscountRadionButton.click();
			Thread.sleep(4000);

			WebElement enterCouponCode = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("enterCouponCode"))));

			try {
				enterCouponCode.sendKeys(copyDeleteDiscountCoupon);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			WebElement ApplyCoupon = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("apply_Coupon"))));
			ApplyCoupon.click();
			Thread.sleep(2000);
			success_Message = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("success_Message"))))
					.getText();
			Thread.sleep(3000);
			System.out.println("success_Message = " + success_Message);

			Assert.assertTrue("40% Discount coupon is not applied successfully",
					success_Message.contains("Your coupon was successfully applied."));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void chatWindow() throws Throwable {

		try {
			WebElement iframe = driver.findElement(By.xpath("//iframe[@id = 'chat-widget' or @name = 'chat-widget']"));
			Thread.sleep(1000);
			boolean value = iframe.isDisplayed();
			System.out.println("value = " + value);
			if (value == true) {
				driver.switchTo().frame(iframe);
				WebElement chat1 = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//div[@role = 'main']//button[@aria-label = 'Minimize window']")));
				Thread.sleep(1000);
				chat1.click();
				Thread.sleep(1000);
				driver.switchTo().defaultContent();
				Thread.sleep(1000);
				driver.switchTo().parentFrame();
				Thread.sleep(3000);
			} else {

				System.out.println("chat window does not open");
			}
		} catch (NoSuchElementException NCP) {

		}
	}

}
