package SetUpClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties config = new Properties();
	public static Properties OR = new Properties();

	public static Logger log = Logger.getLogger(BaseClass.class);

	public static JavascriptExecutor js;
	public static FileInputStream fis;
	public static WebDriverWait wait;
	public static WebDriver driver;
	public static String browser;
	public static String AppURL;

	static String ecpected_Title = "Checkout";
	static WebElement remove_Coupon;
	static String success_Message;
	protected static String price;
	static WebElement Price;
	static String delete_Coupon_Message;
	static WebElement selectCheckBox;
	static WebElement enterCouponCode;
	static WebElement apply_Coupon;
	static WebElement stripeOption;
	static String actual_Title;
	static WebElement payPalOption;
	static String Summer35Value;
	static String copyDeleteDiscountCoupon;

	@BeforeClass
	public static void before_Class() throws Exception {

		/*
		 * PropertyConfigurator .configure(System.getProperty("user.dir") +
		 * "\\src\\test\\resources\\teamProperties\\log4j.properties");
		 */

		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\teamProperties\\Config.properties");

			config.load(fis);
			log.info("Config file loaded !!!");
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\teamProperties\\OR.properties");
			OR.load(fis);
			log.info("OR file loaded !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AppURL = config.getProperty("App_url");

		if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {
			browser = System.getenv("browser");
			System.out.println("env browser = " + browser);

		} else {
			browser = config.getProperty("browser");
			System.out.println("config browser = " + browser);
		}

		config.setProperty("browser", browser);

		System.out.println("setProperty browser = " + browser);

		if ((config.getProperty("browser").equals("chrome"))) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, 50);
			js = (JavascriptExecutor) driver;
			Thread.sleep(1000);
		}
		// if (browser.equalsIgnoreCase("firefox"))

		// if (browser.equalsIgnoreCase("chrome"))
		else if ((config.getProperty("browser").equals("firefox"))) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 50);
			js = (JavascriptExecutor) driver;
			Thread.sleep(1000);
		} else if ((config.getProperty("browser").equals("edge"))) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 50);
			js = (JavascriptExecutor) driver;
			Thread.sleep(1000);
		}

		else {

			System.out.println("platform does not provide");
		}

	}

	public static void ClearBrowserCache() throws Throwable {

		driver.manage().deleteAllCookies();
		Thread.sleep(4000); // wait 4 seconds to clear cookies.
		driver.navigate().refresh();
		Thread.sleep(4000);
	}

	public static WebElement elementToBeClickable(By locator) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				// Check for condition in every 2 seconds
				.pollingEvery(Duration.ofSeconds(2))
				// Till time out i.e. 30 seconds
				.withTimeout(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static WebElement precenceOfElement(By locator) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				// Check for condition in every 2 seconds
				.pollingEvery(Duration.ofSeconds(2))
				// Till time out i.e. 30 seconds
				.withTimeout(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	@AfterClass
	public static void after_Class() throws InterruptedException {
		Thread.sleep(2000);

		if (driver != null) {
			// driver.quit(); // ->> don't want to close the browser
			Thread.sleep(2000);
		}

	}

}
