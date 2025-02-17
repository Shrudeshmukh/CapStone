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

public class DashboardTest {

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
	public void testElements() throws InterruptedException {
		// for registration
		WebElement registerButton = driver.findElement(By.id("com.example.slotbook:id/btnRegister"));
		registerButton.click();

		Thread.sleep(2000);
		WebElement name = driver.findElement(By.id("com.example.slotbook:id/etName"));
		name.sendKeys("Admin");

		WebElement email = driver.findElement(By.id("com.example.slotbook:id/etEmail"));
		email.sendKeys("admin@gmail.com");

		WebElement password = driver.findElement(By.id("com.example.slotbook:id/etPassword"));
		password.sendKeys("123");

		WebElement register = driver.findElement(By.id("com.example.slotbook:id/btnRegister"));
		register.click();

		Thread.sleep(2000);
		WebElement validateEmail = driver.findElement(By.id("com.example.slotbook:id/etEmail"));
		validateEmail.sendKeys("admin@gmail.com");

		WebElement validatePassword = driver.findElement(By.id("com.example.slotbook:id/etPassword"));
		validatePassword.sendKeys("123");

		WebElement loginButton = driver.findElement(By.id("com.example.slotbook:id/btnLogin"));
		loginButton.click();

		Thread.sleep(2000);
		WebElement dashTitle = driver.findElement(By.id("com.example.slotbook:id/dashboardText"));
		if (dashTitle.isDisplayed()) {
			System.out.println("User login Successfull");
		} else {
			System.out.println("Login Failed");
		}

		WebElement techTracks = driver.findElement(By.id("com.example.slotbook:id/btnManageTracks"));
		if (techTracks.isDisplayed()) {
			System.out.println("Manage tech Tracks Button is displayed");
		} else {
			System.out.println("Manage tech tracks Button is not displayed");
		}

		WebElement bookedSlots = driver.findElement(By.id("com.example.slotbook:id/btnBookedSlots"));
		if (bookedSlots.isDisplayed()) {
			System.out.println("View Booked Slots Button is displayed");
		} else {
			System.out.println("View Booked slots is not disabled");
		}

		WebElement logoutButton = driver.findElement(By.id("com.example.slotbook:id/btnLogout"));
		if (logoutButton.isDisplayed()) {
			System.out.println("Logout Button is displayed");
		} else 
			System.out.println("Logout Button is not displayed");
		}
	

	@Test
	public void techTracknavigationTest() throws InterruptedException {
		// for registration
		WebElement registerButton = driver.findElement(By.id("com.example.slotbook:id/btnRegister"));
		registerButton.click();

		Thread.sleep(2000);
		WebElement name = driver.findElement(By.id("com.example.slotbook:id/etName"));
		name.sendKeys("Admin");

		WebElement email = driver.findElement(By.id("com.example.slotbook:id/etEmail"));
		email.sendKeys("admin@gmail.com");

		WebElement password = driver.findElement(By.id("com.example.slotbook:id/etPassword"));
		password.sendKeys("123");

		WebElement register = driver.findElement(By.id("com.example.slotbook:id/btnRegister"));
		register.click();

		// for login
		Thread.sleep(2000);
		WebElement validateEmail = driver.findElement(By.id("com.example.slotbook:id/etEmail"));
		validateEmail.sendKeys("admin@gmail.com");

		WebElement validatePassword = driver.findElement(By.id("com.example.slotbook:id/etPassword"));
		validatePassword.sendKeys("123");

		WebElement loginButton = driver.findElement(By.id("com.example.slotbook:id/btnLogin"));
		loginButton.click();

		Thread.sleep(2000);
		// for checking navigation from Dashboard to tech tracks activity
		WebElement trackNavigation = driver.findElement(By.id("com.example.slotbook:id/btnManageTracks"));
		trackNavigation.click();

		Thread.sleep(3000);
		WebElement title = driver.findElement(By.xpath("//android.widget.TextView[@text='JAVA']"));
		if (title.isDisplayed()) {
			System.out.println("Navigated from dashboard to Tech tracks activity");
		} else {
			System.out.println("Navigation failed");
		}
	}

	@Test
	public void logoutTesting() throws InterruptedException {
		// for registration
		WebElement registerButton = driver.findElement(By.id("com.example.slotbook:id/btnRegister"));
		registerButton.click();

		Thread.sleep(2000);
		WebElement name = driver.findElement(By.id("com.example.slotbook:id/etName"));
		name.sendKeys("Admin");

		WebElement email = driver.findElement(By.id("com.example.slotbook:id/etEmail"));
		email.sendKeys("admin@gmail.com");

		WebElement password = driver.findElement(By.id("com.example.slotbook:id/etPassword"));
		password.sendKeys("123");

		WebElement register = driver.findElement(By.id("com.example.slotbook:id/btnRegister"));
		register.click();

		// for login
		Thread.sleep(2000);
		WebElement validateEmail = driver.findElement(By.id("com.example.slotbook:id/etEmail"));
		validateEmail.sendKeys("admin@gmail.com");

		WebElement validatePassword = driver.findElement(By.id("com.example.slotbook:id/etPassword"));
		validatePassword.sendKeys("123");

		WebElement loginButton = driver.findElement(By.id("com.example.slotbook:id/btnLogin"));
		loginButton.click();

		Thread.sleep(2000);
		// for checking navigation from Dashboard to BookedSot Activity
		WebElement logout = driver.findElement(By.id("com.example.slotbook:id/btnLogout"));
		logout.click();

		Thread.sleep(2000);
		WebElement validation = driver.findElement(By.id("com.example.slotbook:id/btnLogin"));
		if(validation.isDisplayed()) {
			System.out.println("User Logged out  Successfully");
		}else {
			System.out.println("Logout Failed");
		}
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}