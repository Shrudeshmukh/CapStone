package testing;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class LoginTest {

	
	 private AppiumDriver driver;
	 
	 @Before
		public void setUp() throws MalformedURLException {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "samsung SM-E225F");
			caps.setCapability("appPackage", "com.example.slotbook");
			caps.setCapability("appActivity", "com.example.slotbook.ui.LoginActivity");
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

			driver = new AndroidDriver(new URL("http://localhost:4723"), caps);
		}

	@Test
	public void testFunctionality() throws InterruptedException {
		
		System.out.println("Login page is visible");
		System.out.println("First Navigated to Registration Page");
		WebElement registerButton = driver.findElement(By.id("com.example.slotbook:id/btnRegister"));
		registerButton.click();
		
		Thread.sleep(2000);
		WebElement name = driver.findElement(By.id("com.example.slotbook:id/etName"));
		name.sendKeys("Admin");
		
	
		WebElement email = driver.findElement(By.id("com.example.slotbook:id/etEmail"));
		email.sendKeys("admin@gmail.com");
		
		WebElement password = driver.findElement(By.id("com.example.slotbook:id/etPassword"));
		password.sendKeys("123");
		
		
		Thread.sleep(2000);
        WebElement maleGender = driver.findElement(By.id("com.example.slotbook:id/rbMale"));
        maleGender.click();

        WebElement termsCheckbox = driver.findElement(By.id("com.example.slotbook:id/cbTerms"));
        termsCheckbox.click();
        
        Thread.sleep(2000);
		WebElement register = driver.findElement(By.id("com.example.slotbook:id/btnRegister"));
		register.click();
		
		System.out.println("Registration successfull");
		System.out.println("After Succesfull Registration Navigated Back to the Login Page");
		
		Thread.sleep(2000);
		

		WebElement validateEmail = driver.findElement(By.id("com.example.slotbook:id/etEmail"));
		validateEmail.sendKeys("admin@gmail.com");
		
		WebElement validatePassword = driver.findElement(By.id("com.example.slotbook:id/etPassword"));
		validatePassword.sendKeys("123");
		
		WebElement loginButton = driver.findElement(By.id("com.example.slotbook:id/btnLogin"));
		loginButton.click();

		Thread.sleep(2000);
		WebElement dashTitle = driver.findElement(By.id("com.example.slotbook:id/dashboardText"));
		if(dashTitle.isDisplayed()) {
			System.out.println("User login Successfull");
			System.out.println("Navigated from Login screen to Dashboard screen");
		}else {
			System.out.println("Login Failed");
		}
		
		
  
	}
	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	


	}

