package Datman.TestUtils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class WaitUtils  {
    private static final int TIMEOUT = 45;
    

    public static WebDriverWait getWebDriverWait(AppiumDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    public static WebElement waitForVisibility(AppiumDriver driver, By locator) {
        return getWebDriverWait(driver).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeClickable(AppiumDriver driver, By locator) {
        return getWebDriverWait(driver).until(ExpectedConditions.elementToBeClickable(locator));
    }
}



