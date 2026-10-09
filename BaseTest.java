package com.shweta.qa.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Automatically download and configure the matching Chrome binary architecture
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        
        driver = new ChromeDriver(options);
        
        // Define global synchronization implicit wait rules
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Launch baseline targeted environment
        driver.get("https://saucedemo.com");
    }

    @AfterMethod
    public void tearDown() {
        // Prevent resource memory leakage by terminating open driver instances securely
        if (driver != null) {
            driver.quit();
        }
    }
}
