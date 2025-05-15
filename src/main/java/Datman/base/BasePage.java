package Datman.base;

import java.io.File;
import java.text.DecimalFormat;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Datman.TestUtils.WaitUtils;
import io.appium.java_client.AppiumBy;


public class BasePage extends WebLaunchTest {
    static Properties properties = new Properties();

    public static void clickElement(By element) {
        WaitUtils.waitForElementToBeClickable(driver, element).click();
        System.out.println("Clicked: "+ element.toString());  
    }

    public void enterText(By element, String text) {
        WaitUtils.waitForVisibility(driver, element).sendKeys(text);
    }

    public static void validatingTextMessage(By locator, String expectedMessage) {
        
        try {
            WebElement Message = WaitUtils.waitForVisibility(driver, locator);
            String actualMessage = Message.getText();
            Assert.assertEquals(actualMessage, expectedMessage, "The messages do not match!");
            System.out.println(expectedMessage.equals(actualMessage)+" :Expected message matched to actual message");
        } catch (Exception e) {
            System.out.println("Reason: " + e.getMessage());
            Assert.fail("Account is not verified. Stopping test.");
        }
        
    }   
    
    public double checkElegibleAmount(By locator){
        WebElement amountElement = WaitUtils.waitForVisibility(driver, locator);
        String amountText = amountElement.getText();
        String cleanedAmount = amountText.replace("£", "").replace(",", "").trim();
        double availableAmount = Double.parseDouble(cleanedAmount);
        return availableAmount;
    }

    public static String getLocators(String value) {
        try {
            File folder = new File("src/resources");
            File[] files = folder.listFiles((dir, name) -> name.endsWith(".properties"));
            if (files != null) {
                for (File file : files) {
                    FileInputStream input = new FileInputStream(file);
                    properties.load(input);
                    input.close();
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(value);
    }
    

    public boolean isButtonSlected(By locator) {
        try {
            WebElement button = WaitUtils.waitForVisibility(driver, locator);
            
            if ( button.isSelected()) {
                System.out.println("Button is clickable.");
                return true;
            }
             else {
                System.out.println("Button is not clickable, please enter required details.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Button is not clickable. Exception: " + e.getMessage());
            return false;
        }
    }

    public boolean isButtonEnabled(By locator) {
        try {
            WebElement button = WaitUtils.waitForVisibility(driver, locator);
            
            if ( button.isEnabled()) {
                System.out.println("Button is clickable.");
                return true;
            }
             else {
                System.out.println("Button is not clickable, please enter required details.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Button is not clickable. Exception: " + e.getMessage());
            return false;
        }
    }
    
    public static String generateRandomDoubleString() {
        double randomValue = 1 + (Math.random() * 4); // Generates from 1.00 to <5.00
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(randomValue);
    }

    public void scrollDown(String text) {
        WebElement scrollDown=WaitUtils.waitForVisibility(driver, AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" + ".scrollIntoView(new UiSelector().text(\"" + text + "\").instance(0));"));
        scrollDown.getLocation();
    }

    public void getThreeDigitSortCode(String sortCode){
        try {
                Thread.sleep(3000);
                WebElement threeDigitSortCode = WaitUtils.waitForVisibility(driver, AppiumBy.xpath(getLocators("lastThreeDigitSortcode")));
                String lastThreeDigitSortCode = threeDigitSortCode.getText();
                String lastThreeDigitNumber=lastThreeDigitSortCode.replaceAll("\\D", "");
                System.out.println("Last 3 digits of sort code: " + lastThreeDigitNumber);
                Assert.assertEquals(sortCode, lastThreeDigitNumber, "The messages do not match!");
                System.out.println("sortcode matched ->"+ sortCode + " : " + lastThreeDigitNumber);
        } catch (Exception e) {
                System.out.println(e.getMessage());
                Assert.fail("Fail, in getThreeDigitSortCode method,");
            }
        }
 
}

