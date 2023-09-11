package CasstoneTask;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Scanario_02 {

	WebDriver driver;

	@BeforeTest
	public void launchApp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	//	driver.wait(4000);
	}
	@Test
	public void iphoneCell() {

		// Verify flipkart logo presence
		WebElement flipkartLogo = driver.findElement(By.xpath("//img[@title='Flipkart']"));
		if (flipkartLogo.isDisplayed()) {
			System.out.println("Flipkart is present on left side of the top");
		} else {
			System.out.println("Flipkart is not present on left side of the top");
		}
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"))
				.sendKeys("iphone 14", Keys.ENTER);
		WebElement searchResult = driver.findElement(By.cssSelector("._36fx1h._6t1WkM._3HqJxg"));
		searchResult.click();
		String exepectedTitle = driver.getTitle();
		if (exepectedTitle.contains("Contact | Automation Panda")) {
			System.out.println("Successfully navigated to the right page and title of the Page : " + exepectedTitle);
		} else {
			System.out.println("navigated to the right page is failed : " + exepectedTitle);
		}
		driver.findElement(By.xpath("//img[@alt='APPLE iPhone 14 (Midnight, 128 GB)']")).click();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}
}
