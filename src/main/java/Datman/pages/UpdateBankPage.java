package Datman.pages;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import Datman.TestUtils.Listeners;
import Datman.TestUtils.WaitUtils;
import Datman.base.BasePage;
import io.appium.java_client.AppiumBy;

public class UpdateBankPage extends BasePage {

    public void scrollDown(String text) {
        WebElement scrollDown=WaitUtils.waitForVisibility(driver, AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" + ".scrollIntoView(new UiSelector().text(\"" + text + "\").instance(0));"));
        scrollDown.getLocation();
    }

    public void clickSettingsBtn(){
        clickElement(AppiumBy.xpath(getLocators("settingsBtn")));
        Listeners.test.log(Status.PASS, "Clicked Settings Button");
    }

    public void clickUpdateBankDetailsBtn(){
        clickElement(AppiumBy.xpath(getLocators("updateBankDetailsBtn")));
        Listeners.test.log(Status.PASS, "Clicked Update Bank details Button");
    }

    public void checkUpdateButoonIsDisbled(){
        isButtonClickable(AppiumBy.xpath(getLocators("updateBtn")));
        Listeners.logScreenshot(Status.PASS, "Update_button_disabled");
    }

    public void verifyLastThreeDigitSortCode(){
        getThreeDigitSortCode("323");
    }

    public void enterExstitingSortCode(String sortCode){
        enterText(AppiumBy.xpath(getLocators("exstitingSortCode")), sortCode);
    }

    public void enterExstitingAccountNo(String accNo){
        enterText(AppiumBy.xpath(getLocators("exstitingAccountNo")), accNo);
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
        clickElement(AppiumBy.xpath(getLocators("updateBtn")));
    }

    public void clickOverrideBtn(){
        clickElement(AppiumBy.xpath(getLocators("overrideBtn")));
    }

    public void verifyAccountNumberDigits(){
        validatingTextMessage(AppiumBy.xpath(getLocators("enterEightDigitAccNo")), "Please enter 8 digit account number");
        Listeners.logScreenshot(Status.PASS, "enter_8_digitno");
    }

    public void varifyAccountNumberMismatch(){
        validatingTextMessage(AppiumBy.xpath(getLocators("accountNumberMismatch")), "Your account numbers do not match");
        Listeners.logScreenshot(Status.PASS, "account_no_mismatch");
    }
}


