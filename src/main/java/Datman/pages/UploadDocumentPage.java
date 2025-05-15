package Datman.pages;

import com.aventstack.extentreports.Status;

import Datman.TestUtils.Listeners;
import Datman.base.BasePage;
import io.appium.java_client.AppiumBy;

public class UploadDocumentPage extends BasePage {
    

    public void verifyUpdateDetailsBtnEnabled(){
        boolean isButtonEnabled = isButtonEnabled(AppiumBy.xpath(getLocators("updateDetailsBtn")));
        if(isButtonEnabled){
            Listeners.logScreenshot(Status.INFO, "Update_button_enabled");
        }
    }

    public void verifyUpdateDetailsBtnDisabled(){
        boolean isButtonDisabled =  isButtonEnabled(AppiumBy.androidUIAutomator(getLocators("updateDetailsBtnDisabled")));
        if(isButtonDisabled == false){
            Listeners.logScreenshot(Status.INFO, "Update_button_disabled");
        }
    }

    public void clickBankStatementUpload(){
        clickElement(AppiumBy.xpath(getLocators("bankStatementUpload")));
    }

    public void clickFilesOption(){
        clickElement(AppiumBy.xpath(getLocators("filesBtn")));
    }

    public void selectdocument(){
        clickElement(AppiumBy.xpath(getLocators("document")));
        Listeners.test.log(Status.INFO,"Document Selected");
    }

    public void verifyDocumentUploaded(){
        
    }

    public void clickUpdateDetailsBtn(){
        clickElement(AppiumBy.xpath(getLocators("updateDetailsBtn")));
    }

    public void clickTakeFicture(){
        clickElement(AppiumBy.xpath(getLocators("takePicture")));
    }

    public void clickAllowCamera(){
        clickElement(AppiumBy.androidUIAutomator(getLocators("allowCamera")));
    }

    public void clickShutter(){
        clickElement(AppiumBy.id(getLocators("shutterBtn")));
    }

    public void clickDonePicture(){
        clickElement(AppiumBy.xpath(getLocators("donePicture")));
    }

    public void clickCropPicture(){
        clickElement(AppiumBy.xpath(getLocators("cropPicture")));
    }

    public void verifyLargeSizefileAlert(){
        validatingTextMessage(AppiumBy.xpath(getLocators("largeSizeFile")), getLocators("largeSizeFileAlert"));
        Listeners.logScreenshot(Status.INFO, "filesize_lessthan_100kb");
    }

    public void verifyOtpPage(){
        validatingTextMessage(AppiumBy.xpath(getLocators("otpSent")), getLocators("otpSentAlert"));
        Listeners.logScreenshot(Status.PASS, "Redirected_To_OTP_Page");
    }
}
