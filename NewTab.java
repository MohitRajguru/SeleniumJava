package projects;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class NewTab {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
//		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//
//		WebElement footer = driver.findElement(By.cssSelector(".footer_top_agile_w3ls.gffoot.footer_style"));
//		WebElement column1 = footer.findElement(By.xpath("(//td//ul)[1]"));
//		List<WebElement> footerLinks = column1.findElements(By.tagName("a"));
//		System.out.println(footerLinks.size());
//
//		for (WebElement link : footerLinks) {
//			link.sendKeys(Keys.LEFT_CONTROL, Keys.ENTER);
//		}
//
//		Set<String> windows = driver.getWindowHandles();
//		Iterator<String> it = windows.iterator();
//
//		while (it.hasNext()) {
//			driver.switchTo().window(it.next());
//			System.out.println(driver.getTitle());
//		}

		driver.get("https://playvalorant.com/en-gb/");

		WebElement footer = driver.findElement(By.className("kkZ-FCyw-rrevdhBbjJNsg=="));
		System.out.println(footer.getText());

		List<WebElement> links = footer.findElements(By.tagName("a"));
		System.out.println(links.size());

		for (WebElement link : links) {
			link.sendKeys(Keys.chord(Keys.LEFT_CONTROL, Keys.ENTER));
		}

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

}
