import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class Main {
	
	public static void main (String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "/Users/georgexu/Desktop/libraries/geckodriver");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		
		Scanner scanner= new Scanner(System.in);
		System.out.println("---UBC SSC LOGIN INFO---");
		
		//get username info
		System.out.print("Enter your SSC username: ");
		String username = scanner.next();
		
		//get password info
		System.out.print("Enter your SSC password: ");
		String password = scanner.next();
		
		System.out.println("program will start in 5 seconds");
		try {
		Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
			
		// initialize	
		try {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://upassbc.translink.ca/");
		Thread.sleep(5000);
		
		Select dropdown = new Select(driver.findElement(By.id("PsiId")));
		dropdown.selectByIndex(4);
		driver.findElement(By.id("goButton")).click();
		
		WebElement uusername = driver.findElement(By.id("j_username"));	
		uusername.sendKeys(username);
		
		WebElement ppassword = driver.findElement(By.id("password"));
		ppassword.sendKeys(password);
		
		driver.findElement(By.className("ui-button")).click();
		
		driver.findElement(By.xpath("//*[id= 'checkbox']")).click();
		driver.findElement(By.id("request_pass")).click();
		} catch(Exception e){
			System.out.println(e);
			}
	}
}
