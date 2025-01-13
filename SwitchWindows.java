package projects;

// Importing necessary Java and Selenium libraries
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindows {

	public static void main(String[] args) {

		// Launching the browser using ChromeDriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // Maximizing the browser window
		driver.get("https://en.wikipedia.org/wiki/Wonders_of_the_World"); // Navigating to the Wikipedia URL

		// Finding the link for 'Great Wall of China' and opening it in a new tab
		WebElement element = driver.findElement(By.xpath("//li/a[@title='Great Wall of China']"));
		element.sendKeys(Keys.CONTROL, Keys.ENTER); // Using CONTROL+ENTER to open the link in a new tab

		// Retrieving all open window handles (IDs)
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator(); // Iterating through the window handles
		String parentId = it.next(); // Storing the ID of the main (parent) window
		String childId = it.next(); // Storing the ID of the newly opened tab (child window)
		driver.switchTo().window(childId); // Switching to the new tab

		// Retrieving the text of the 'Kumbhalgarh' element
		String wall = driver.findElement(By.xpath("//li /a[@title='Kumbhalgarh']")).getText();
		driver.switchTo().window(parentId); // Switching back to the main window

		// Entering the retrieved text into the search bar
		driver.findElement(By.className("cdx-text-input__input")).sendKeys(wall);
		driver.findElement(By.cssSelector("button.cdx-button.cdx-search-input__end-button")).click(); // Clicking the
																										// search button
	}
}
