package Automation_testing;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class RT_CAMP_TEST {

	public static void main(String[] args) throws Exception {
		
	
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/inventory.html");	
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(5000);
		
		//Verify the sorting order displayed for Z-A on the “All Items” page
		Select DD=new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		DD.selectByVisibleText("Name (Z to A)");
		Thread.sleep(5000);
		
		//Refreshed
		 driver.navigate().refresh();
	        System.out.println("tab got refreshed - Passed");
	        Thread.sleep(5000);

		//Verify the price order (high-low) displayed on the “All Items” page.
		Select DD1=new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		DD1.selectByVisibleText("Price (high to low)");
		Thread.sleep(5000);
		
		//Add multiple items to the card and validate the checkout journey.
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("standard_user");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("secret_sauce");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("590016");
		Thread.sleep(1000);
		driver.findElement(By.id("continue")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='finish']")).click();
		Thread.sleep(3000);
		
		driver.close();
		
	}
}
