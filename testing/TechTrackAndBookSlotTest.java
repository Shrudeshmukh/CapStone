package testing;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TechTrackAndBookSlotTest {

    private AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        // Set up desired capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "samsung SM-E225F"); // Replace with your device name
        caps.setCapability("appPackage", "com.example.slotbook"); // Replace with your app package
        caps.setCapability("appActivity", "com.example.slotbook.ui.LoginActivity"); // Replace with your app's Login Activity
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        driver = new AndroidDriver(new URL("http://localhost:4723"), caps);
    }

    @Test
    public void testTechTrackAndBookSlot() throws InterruptedException {
        // Step 1: Register a new user (if needed)
        WebElement registerButton = driver.findElement(By.id("com.example.slotbook:id/btnRegister"));
        registerButton.click();

        // Wait for the registration fields to appear
        Thread.sleep(2000);  // Adjust this time based on the app's response time

        WebElement name = driver.findElement(By.id("com.example.slotbook:id/etName"));
        name.sendKeys("Admin");

        WebElement email = driver.findElement(By.id("com.example.slotbook:id/etEmail"));
        email.sendKeys("admin@gmail.com");

        WebElement password = driver.findElement(By.id("com.example.slotbook:id/etPassword"));
        password.sendKeys("123");

        WebElement register = driver.findElement(By.id("com.example.slotbook:id/btnRegister"));
        register.click();

        // Step 2: Login with registered credentials
        Thread.sleep(2000);  // Wait for login screen to load

        WebElement validateEmail = driver.findElement(By.id("com.example.slotbook:id/etEmail"));
        validateEmail.sendKeys("admin@gmail.com");

        WebElement validatePassword = driver.findElement(By.id("com.example.slotbook:id/etPassword"));
        validatePassword.sendKeys("123");

        WebElement loginButton = driver.findElement(By.id("com.example.slotbook:id/btnLogin"));
        loginButton.click();

        // Wait for the next screen to load and for the tech tracks to appear
        Thread.sleep(2000);  // Wait for tech track options to appear

        // Step 3: Verify Tech Tracks button is visible
        WebElement techTracksButton = driver.findElement(By.id("com.example.slotbook:id/btnManageTracks"));
        assertTrue("Tech Tracks button is not visible.", techTracksButton.isDisplayed());

        techTracksButton.click();

        // Wait for the tech track list to appear
        Thread.sleep(2000);  // Wait for tech track list to appear

        WebElement javaTechTrack = driver.findElement(By.xpath("//android.widget.TextView[@text='JAVA']"));
        javaTechTrack.click();

        // Wait for the available slots to appear
        Thread.sleep(2000);  // Wait for slot list to load

        WebElement slotRecyclerView = driver.findElement(By.id("com.example.slotbook:id/slotsRecyclerView"));
        assertTrue("Slots RecyclerView is not displayed.", slotRecyclerView.isDisplayed());

        // Step 4: Click on an available slot
        WebElement availableSlot = driver.findElement(By.xpath("//android.widget.TextView[@text='Available']")); // Modify this XPath based on actual slot time text
        assertTrue("Available Slot is not displayed.", availableSlot.isDisplayed());
        availableSlot.click();

        // Step 5: Verify that it redirects to BookSlotActivity
        WebElement bookSlotButton = driver.findElement(By.id("com.example.slotbook:id/btnBookSlot"));
        assertTrue("Book Slot button is not visible.", bookSlotButton.isDisplayed());

        // Step 6: Optionally, click on the Book Slot button to finalize booking
        bookSlotButton.click();

        // Wait for the confirmation message
        Thread.sleep(2000);  // Wait for the confirmation message

        // Verify the confirmation message
        WebElement confirmationMessage = driver.findElement(By.id("com.example.slotbook:id/confirmationMessage"));
        assertTrue("Booking confirmation message is not displayed.", confirmationMessage.isDisplayed());

        System.out.println("Successfully booked a slot for JAVA Tech Track.");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Quit the driver after test
        }
    }
}
