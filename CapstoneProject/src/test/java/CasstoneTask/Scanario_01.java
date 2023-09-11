package CasstoneTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Scanario_01 {
	
	WebDriver driver;

	@BeforeTest
	public void launch() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/");
		driver.manage().window().maximize();
	}

	@Test
	public void testApp() {
		driver.findElement(By.xpath("//a[normalize-space()='Contact']")).click();
		System.out.println(driver.getTitle());
		String pageTitle = driver.getTitle();
		if (pageTitle.contains("Contact | Automation Panda")) {
			System.out.println("Title is correct : " + pageTitle);
		} else {
			System.out.println("title is incorrect : " + pageTitle);
		}
		driver.findElement(By.xpath("//input[@id='g3-name']")).sendKeys("Mahesh Reddy");
		driver.findElement(By.xpath("//input[@id='g3-email']")).sendKeys("maheshreddy2254@gmail.com");
		driver.findElement(By.xpath("//textarea[@id='contact-form-comment-g3-message']"))
				.sendKeys("this is the automationpanda website");
		driver.findElement(By.xpath("//strong[normalize-space()='Contact Me']")).click();

		// Verify Text message sent

		WebElement textmessage = driver.findElement(By.xpath("//h4[@id='contact-form-success-header']"));
		boolean isSearchTextBoxPresent = textmessage.isDisplayed();
		System.out.println("Text message is sussuccfully sended to email: " + isSearchTextBoxPresent);
	}

	@AfterTest
	private void tearDown() {
		driver.quit();
	}

}
