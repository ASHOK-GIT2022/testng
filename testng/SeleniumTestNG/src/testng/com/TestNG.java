package testng.com;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestNG {
	
	public WebDriver driver;
	
	@BeforeClass
	public void login() throws InterruptedException {
		System.out.println("Login into the application");
		//System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");  
				System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/eclipse-workspace/SeleniumTestNG/src/driver/chromedriver.exe");  

				// Launch website 
		 driver=new ChromeDriver();  
		 driver.get("https://aspireapp.odoo.com");
				    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				    driver.manage().window().maximize();
					driver.findElement(By.xpath("//input[@id='login']")).sendKeys("user@aspireapp.com");
				    Thread.sleep(3000);
				    
				    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("@sp1r3app");
				    Thread.sleep(3000);
				    
				    driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
				    Thread.sleep(3000);
	}
	@AfterClass
	public void logout() {
		System.out.println("Logout from the application");
		driver.close();
		driver.quit();
	}
	@Test(priority= 0)
	public void Inventory() throws InterruptedException {
		System.out.println("Created Inventory");
		driver.findElement(By.xpath("//a[@id='result_app_1']//div[@class='o_app_icon']")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.cssSelector("span[data-section='120']")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//a[normalize-space()='Products']")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.cssSelector("button[title='Create record']")).click();
	    Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait (driver, 50);
	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='o_field_input_11']")));
	 // if element found then we will use- In this example I just called isDisplayed method
		boolean status = element.isDisplayed();
 
		// if else condition
		if (status) {
			System.out.println("===== WebDriver is visible======");
		} else {
			System.out.println("===== WebDriver is not visible======");
		}
		element.sendKeys("Ashok Test");
		
		driver.findElement(By.cssSelector("button[title='Save record']")).click();
	    Thread.sleep(3000); 
	    
	    driver.findElement(By.cssSelector("button[name='action_update_quantity_on_hand'] span")).click();
	    Thread.sleep(5000); 
	    
	    driver.findElement(By.xpath("//button[normalize-space()='Create']")).click();
	    Thread.sleep(6000);  
	    
	    driver.findElement(By.xpath("//input[@name='inventory_quantity']")).clear();
	    Thread.sleep(7000);
	    
	    driver.findElement(By.xpath("//input[@name='inventory_quantity']")).sendKeys("20.00");
	    Thread.sleep(7000);  
	    
	    driver.findElement(By.cssSelector("button[title='Save record']")).click();
	    Thread.sleep(8000);
	}
	@Test(priority= 1)
	public void ApplicationIcon() throws InterruptedException {
		System.out.println("Create Application");
		
		driver.findElement(By.xpath("//a[@title='Home menu']")).click();
	    Thread.sleep(3000); 
	    
	    driver.findElement(By.xpath("//a[@id='result_app_2']//div[@class='o_app_icon']")).click();
	    Thread.sleep(3000); 
	    
	    driver.findElement(By.xpath("//button[normalize-space()='Create']")).click();
	    Thread.sleep(3000); 
	}
	
	@Test(priority = 2)
	public void Manufacturing() throws InterruptedException {
		System.out.println("Create Manufacturing");
	driver.findElement(By.xpath("//tr[5]/td[2]/div/div/div/input[@type='text' and @class='o_input ui-autocomplete-input']")).sendKeys("Ashok Test");
    Thread.sleep(5000); 
    
	
	driver.findElement(By.xpath("//span[normalize-space()='Confirm']")).click();
    Thread.sleep(5000); 
    
    driver.findElement(By.cssSelector("button[class='btn btn-primary'] span")).click();
    Thread.sleep(5000); 
    
    driver.findElement(By.xpath("//span[normalize-space()='Ok']")).click();
    Thread.sleep(5000); 
    
    driver.findElement(By.xpath("//span[normalize-space()='Apply']")).click();
    Thread.sleep(5000); 
}
	}
	
  


