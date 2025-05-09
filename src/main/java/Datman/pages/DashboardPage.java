package Datman.pages;


import com.aventstack.extentreports.Status;

import Datman.TestUtils.Listeners;
import Datman.base.BasePage;
import io.appium.java_client.AppiumBy;

public class DashboardPage extends BasePage {
    
    public void clickAllowNotification(){
        clickElement(AppiumBy.id(getLocators("allowBtn")));
        Listeners.test.log(Status.PASS, "Allow notification");
    }

    public void clickAllowLocation(){
        clickElement(AppiumBy.id(getLocators("locationBtn")));
        Listeners.test.log(Status.PASS, "Allow location");
    }

    public void clickCancelBoimetric(){
        clickElement(AppiumBy.xpath(getLocators("cancelBoimetric")));
        Listeners.test.log(Status.PASS, "Biometric");
    }
}
