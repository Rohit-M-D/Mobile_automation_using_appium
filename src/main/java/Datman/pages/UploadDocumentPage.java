package Datman.pages;

import com.aventstack.extentreports.Status;

import Datman.TestUtils.Listeners;
import Datman.base.BasePage;
import io.appium.java_client.AppiumBy;

public class UploadDocumentPage extends BasePage {
    

    public void verifyUpdateDetailsBtnEnabled(){
        isButtonClickable(AppiumBy.xpath(getLocators("updateDetailsBtn")));
    }

    public void clickBankStatementUpload(){
        clickElement(AppiumBy.xpath(getLocators("bankStatementUpload")));
    }

    public void clickFilesOption(){
        clickElement(AppiumBy.xpath(getLocators("filesBtn")));
    }

    public void selectdocument(){
        clickElement(AppiumBy.xpath(getLocators("document")));
    }

    public void clickUpdateDetailsBtn(){
        clickElement(AppiumBy.xpath(getLocators("updateDetailsBtn")));
    }

    public void verifyOtpPage(){
        validatingTextMessage(AppiumBy.xpath(getLocators("otpSent")), "OTP has been sent to mobile number");
        Listeners.logScreenshot(Status.PASS, "Redirected_To_OTP_Page");
    }
}
