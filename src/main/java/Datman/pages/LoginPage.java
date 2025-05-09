package Datman.pages;

import com.aventstack.extentreports.Status;
import Datman.TestUtils.Listeners;
import Datman.base.BasePage;
import io.appium.java_client.AppiumBy;

public class LoginPage extends BasePage {

    public void clickLoginWithEmail() {
        clickElement(AppiumBy.xpath(getLocators("loginWithEmail")));
        Listeners.test.log(Status.PASS, "clicked loginWithEmailAndPassword Button");
    }

    public void enterUsername() {
        String username = getLocators("username");
        enterText(AppiumBy.androidUIAutomator(getLocators("usernameField")), username);
        Listeners.test.log(Status.PASS, "Entered Username");
    }

    public void enterPassword() {
        String password = getLocators("password");
        enterText(AppiumBy.androidUIAutomator(getLocators("passField")), password);
        Listeners.test.log(Status.PASS, "Entered Password");
    }

    public void clickLogin() {
        clickElement(AppiumBy.xpath(getLocators("loginClick")));
        Listeners.test.log(Status.PASS, "Clicked Login Button");
    }
}
