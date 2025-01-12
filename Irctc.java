import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Irctc {

	public static void main(String[] args) {

		ChromeOptions op = new ChromeOptions();
		// disable notification parameter
		op.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(op);

		// implicit timeout
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.irctc.co.in/nget/train-search");

		driver.findElement(By.id("disha-banner-close")).click();

		// Explicit timeout
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.ng-tns-c57-8")));

		// FROM
		driver.findElement(By.cssSelector("input.ng-tns-c57-8")).sendKeys("Pune");
		driver.findElement(By.id("p-highlighted-option")).click();

		// To
		driver.findElement(By.cssSelector("input.ng-tns-c57-9")).sendKeys("mumbai");

		/*
		 * changed --> driver.findElements(By.id("pr_id_2_list")) to
		 * driver.findElements(By.xpath("//ul[@id='pr_id_2_list']/li")) because it was
		 * selecting incorrect option.
		 */

		List<WebElement> options = driver.findElements(By.xpath("//ul[@id='pr_id_2_list']/li"));
		for (WebElement option : options) {
			String optionText = option.getText();
			if (optionText.contains("CSMT")) {
				option.click();
				break;
			}
		}

		// ticket type --> general, tatkal, pwd etc.
		// ng-tns-c65-12 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted
		driver.findElement(By.className("ng-tns-c65-12")).click();
		driver.findElement(By.xpath("//li[@aria-label='TATKAL']")).click();

		// travel date
		driver.findElement(By.className("ng-tns-c58-10")).click();

		String month = driver.findElement(By.className("ui-datepicker-month")).getText();
		System.out.println(month);
		String year = driver.findElement(By.className("ui-datepicker-year")).getText();
		System.out.println(year);
		String expMonth = "January";
		String expYear = "2025";
//		String expDay = "10";  

		// Below method can be used for future dates like next month or year but, irctc
		// is not allowing/showing booking for aforementioned destinations
//		while (!(month.equals(expMonth) && year.equals(expYear))) {
//			driver.findElement(By.className("ui-datepicker-next-icon")).click();
//			month = driver.findElement(By.className("ui-datepicker-month")).getText();
//			year = driver.findElement(By.className("ui-datepicker-year")).getText();
//		}
//		hardcoded date as 17 below(not recommended, but will fix in further update)
		driver.findElement(By.xpath("//a[text()='17']")).click();

		// class of coach
		driver.findElement(By.className("ng-tns-c65-11")).click();
		driver.findElement(By.xpath("//span[text()='Vistadome AC (EV)']")).click();

		// submit
		driver.findElement(By.className("search_btn")).click();
		
		System.out.println("****************************************************************************");
		System.out.println("TEST IS COMPLTETED FOR NOW AS WE NEED TO LOGIN IN IRCTC FOR FURTHER ACTIONS!");
		System.out.println("****************************************************************************");
	}

}
