package com.shweta.qa.tests;

import com.shweta.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginRegressionTest extends BaseTest {

    @Test(priority = 1, description = "Verify application login workflow using functional credentials")
    public void verifyValidLoginFlow() {
        // Locate matching input components using custom locators
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='user-name']"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input.submit-button"));

        // Interact with UI DOM nodes
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        // Asset successful page navigation validation markers
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"), "Assertion Failed: Dashboard landing URL mismatch.");
        
        WebElement productHeader = driver.findElement(By.xpath("//span[@class='title']"));
        Assert.assertEquals(productHeader.getText(), "Products", "Assertion Failed: Product title text mismatch.");
    }

    @Test(priority = 2, description = "Verify boundary inline form validation on empty parameter submission")
    public void verifyEmptyCredentialsValidation() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        
        // Submit empty form fields directly to trigger validation boundaries
        loginButton.click();

        WebElement errorContainer = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String validationMessage = errorContainer.getText();
        
        Assert.assertTrue(validationMessage.contains("Username is required"), 
            "Assertion Failed: Fallback system validation message not encountered.");
    }
}
