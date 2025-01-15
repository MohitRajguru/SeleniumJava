package projects;

// Importing necessary Selenium libraries
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesDragDrop {

	public static void main(String[] args) {
		
		// Initialize the WebDriver using ChromeDriver
		WebDriver driver = new ChromeDriver();
		
		// Maximize the browser window
		driver.manage().window().maximize();
		
		// Navigate to the specified URL
		driver.get("https://jqueryui.com/droppable/");
		
		// Switch to the iframe that contains the drag-and-drop elements
		// The iframe is located using its CSS selector (class "demo-frame")
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		
		// Locate the draggable element using its ID "draggable"
		WebElement drag = driver.findElement(By.id("draggable"));
		
		// Locate the droppable element using its ID "droppable"
		WebElement drop = driver.findElement(By.id("droppable"));
		
		// Create an Actions object to handle advanced interactions like drag-and-drop
		Actions act = new Actions(driver);
		
		// Perform the drag-and-drop action:
		// - Drag the "drag" element and drop it onto the "drop" element
		// - The `build()` method builds the action sequence, and `perform()` executes it
		act.dragAndDrop(drag, drop).build().perform();
		
		// Switch back to the default content (main HTML page) after performing actions inside the iframe
		driver.switchTo().defaultContent();
	}
}

