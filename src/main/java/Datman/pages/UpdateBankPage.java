package Datman.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.Status;
import com.google.common.collect.ImmutableMap;

import Datman.TestUtils.Listeners;
import Datman.TestUtils.WaitUtils;
import Datman.base.BasePage;
import io.appium.java_client.AppiumBy;

public class UpdateBankPage extends BasePage {

    public void scrollDown(String text) {
        try{
            WebElement scrollDown = WaitUtils.waitForVisibility(driver, AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".scrollIntoView(new UiSelector().text(\"" + text + "\").instance(0));"));
            scrollDown.getLocation();
            System.out.println("Scrolling down");
        }
          catch (Exception e) {
                System.out.println("Scroll failed: " + e.getMessage());
        }
    }

    public void swipeUp() {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 500, // X coordinate for the swipe (center of the screen horizontally)
                "top", 1000, // Starting Y coordinate
                "width", 200, // Width of swipeable area (not as important for vertical swipe)
                "height", 800, // Height of swipeable area (defines vertical range)
                "direction", "up", // Swipe upwards
                "percent", 0.75 // Swipe 75% of the vertical area
        ));
    }

    
    public void clickSettingsBtn(){
        clickElement(AppiumBy.xpath(getLocators("settingsBtn")));
        Listeners.test.log(Status.PASS, "Clicked Settings Button");
    }

    public void clickUpdateBankDetailsBtn(){
        clickElement(AppiumBy.xpath(getLocators("updateBankDetailsBtn")));
        Listeners.test.log(Status.PASS, "Clicked Update Bank details Button");
    }

    public void checkUpdateButtonDisbled(){
        boolean isButtonDisabled = isButtonSlected(AppiumBy.androidUIAutomator(getLocators("updateBtnDisabled")));
        if(isButtonDisabled == false){
            Listeners.logScreenshot(Status.PASS, "Update_disabled_aftet_entering_details");
        }
    }

    public void checkUpdateButtonEnabled(){
        boolean isButtonEnabled = isButtonEnabled(AppiumBy.xpath(getLocators("updateBtnEnabled")));
        if(isButtonEnabled){
            Listeners.logScreenshot(Status.PASS, "Update_enabled_aftet_entering_details");
        }
    }

    public void verifyLastThreeDigitSortCode(String sortCode){
        getThreeDigitSortCode(sortCode);
    }

    public void enterExstitingSortCode(String sortCode){
        enterText(AppiumBy.xpath(getLocators("exstitingSortCode")), sortCode);
    }

    public void enterExstitingAccountNo(String accNo){
        enterText(AppiumBy.xpath(getLocators("exstitingAccountNo")), accNo);
    }

    public void enterWrongNewSortCode(String wrongSortcode){
        enterText(AppiumBy.xpath(getLocators("newSortCode")), wrongSortcode);
    }

    public void verifyWrongDigitSortcode(){
        validatingTextMessage(AppiumBy.xpath(getLocators("sixDigitSortcode")), getLocators("sixDigitSortcodeAlert"));
        Listeners.logScreenshot(Status.INFO, "enter_6_digit_sortcode");
    }

    public void enterNewSortCode(String newSort){
        enterText(AppiumBy.xpath(getLocators("newSortCode")), newSort);
    }

    public void enterAccountHolderName(String accHoldername){
        enterText(AppiumBy.xpath(getLocators("accountHolderName")), accHoldername);
    }

    public void enterNewAccountNo(String newAccNo){
        enterText(AppiumBy.xpath(getLocators("newAccountNo")), newAccNo);
    }

    public void confirmNewAccountNo(String confirmAccNo){
        enterText(AppiumBy.xpath(getLocators("confirmNewAccountNo")), confirmAccNo);
    }

    public void enterNameofBank(String bankName ){
        enterText(AppiumBy.xpath(getLocators("nameofBank")), bankName);
    }
    
    public void clickUpdateBtn(){
        clickElement(AppiumBy.xpath(getLocators("updateBtnEnabled")));
    }

    public void clickOverrideBtn(){
        clickElement(AppiumBy.xpath(getLocators("overrideBtn")));
    }

    public void verifyAccountNumberDigits(){
        validatingTextMessage(AppiumBy.xpath(getLocators("enterEightDigitAccNo")), getLocators("enterEightDigitAccNoAlert"));
        Listeners.logScreenshot(Status.INFO, "enter_8_digitno");
    }

    public void varifyAccountNumberMismatch(){
        validatingTextMessage(AppiumBy.xpath(getLocators("accountNumberMismatch")), getLocators("accountNumberMismatchAlert"));
        Listeners.logScreenshot(Status.INFO, "account_no_mismatch");
    }

    public void verifyAccountExists(){
        validatingTextMessage(AppiumBy.xpath(getLocators("accountnotExists")), getLocators("accountDoesnotExists"));
        Listeners.logScreenshot(Status.INFO, "account_not_exists");
    }
}


