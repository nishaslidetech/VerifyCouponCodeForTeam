package stepDefinations;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;

public class rough {
	static WebDriver driver;
	public static JavascriptExecutor js;
	public static FileInputStream fis;
	public static WebDriverWait wait;
	static WebElement search_field;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
		wait = new WebDriverWait(driver, 30);
		js = (JavascriptExecutor) driver;

		driver.get("https://www.slidegeeks.com/");

	

		try {
			Thread.sleep(3000);
			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search-input']")));
			search_field.clear();
			search_field.sendKeys("HR");
			Thread.sleep(3000);


			// click on "hr report" in left navigation

			WebElement hr_Budget = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[1]/div[1]/div[1]/ul[1]/li[6]/a[1]")));
			hr_Budget.click();
			Thread.sleep(3000);
		

			// Clear the search field and enter "Management" on sli listing page
			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search-input']")));
			search_field.clear();
			search_field.sendKeys("Software");
			Thread.sleep(3000);
			
			search_field.clear();
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WebDriverManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// div[@class = 'container listing-container sli_generic_container']//ul//li[4]
		driver.navigate().refresh();
		Thread.sleep(4000);
		WebElement selectPpt = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")));
		js.executeScript("arguments[0].click();", selectPpt);
		Thread.sleep(3000);
		
		driver.navigate().back();
		Thread.sleep(3000);

	}
}
