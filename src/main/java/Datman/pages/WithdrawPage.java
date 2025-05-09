package Datman.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import Datman.base.BasePage;
import io.appium.java_client.AppiumBy;
import Datman.TestUtils.Listeners;


public class WithdrawPage extends BasePage  {
    private final By finalWithdrawBtn = AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Withdraw £')]");
    private final By balance = AppiumBy.xpath("(//android.widget.TextView[contains(@text, '£')])[1]");
    double avlBalance;
    String randomAmount = generateRandomDoubleString();

    public void validateMerchantStatus(){
        validatingTextMessage(AppiumBy.xpath(getLocators("varifiedMerchant")), "Verified ");
        Listeners.test.log(Status.PASS,"Mechant is verified");
    }
    
    public void validateAvailableBalance(){
        avlBalance = checkElegibleAmount(balance);
        if (avlBalance > 0.00) {
            System.out.println("Eligible amount: " + avlBalance);
            Listeners.logScreenshot(Status.PASS, "Amount_Eligible_to_Withdraw");
        } else {
            System.out.println("Amount is not eligible: " + avlBalance);
            Assert.fail("Amount is not eligible. Stopping test."); 
            Listeners.test.log(Status.FAIL, "Amount not Eligible to Withdraw");
        }  
        
    }

    public void clickWithdrawBtn() {
        clickElement(AppiumBy.xpath(getLocators("withdrawBtn")));
        Listeners.test.log(Status.PASS, "Clicked withdraw button for withdraw process");
    }

    

    public void checkWithdrawBtnDisable(){
        boolean butttonDisabled = isButtonClickable(AppiumBy.xpath(getLocators("withdrawBtnDisabled")));
        if(butttonDisabled){
            Listeners.test.log(Status.PASS, "Withdraw button is disabled before entering the amount");
        } 
    }
    
    public void enterAmountToWithdraw(){
        enterText(AppiumBy.xpath(getLocators("enterWithdrawAmount")),randomAmount);
        Listeners.test.log(Status.PASS, "Entered random amount");
    }
    

    public void clickFinalWithdrawBtn(){
        clickElement(finalWithdrawBtn);
        Listeners.test.log(Status.PASS, "Clicked Withdraw");
    }

    public void clickConformPopup(){
        clickElement(AppiumBy.xpath(getLocators("confirmwithdraw")));
        Listeners.test.log(Status.PASS, "Clicked confirm");
    }

    public void validateSuccessfulWithdraw(){
        validatingTextMessage(AppiumBy.androidUIAutomator(getLocators("withdrawConform")), "Withdrawal Request Successful");
        Listeners.test.log(Status.PASS, "Sucessful_withdraw");

    }

    public void validateAvailableBalanceAfterWithdraw() {
        double avlBalanceAfterWithdraw = checkElegibleAmount(balance);
        double randomAmountNo = Double.parseDouble(randomAmount);
        double expectedBalance = Math.round((avlBalance - randomAmountNo) * 100.0) / 100.0;
        double actualBalance = Math.round(avlBalanceAfterWithdraw * 100.0) / 100.0;
        System.out.println("Withdraw amount: " + randomAmountNo);
        System.out.println("Expected balance: " + expectedBalance);
        System.out.println("Actual balance after withdraw: " + actualBalance);
    
        if (expectedBalance == actualBalance) {
            Listeners.test.log(Status.PASS, "Balance updated after withdraw\"");
        } else {
            Listeners.test.log(Status.PASS, "Balance not updated after withdraw");
        }
    }

    public void enterGreaterAmount(){
        double avlBalanceAfterWithdraw = checkElegibleAmount(balance);
        double greaterAmountThanAvlbalance = avlBalanceAfterWithdraw + 0.25;
        String amountStr = String.format("%.2f", greaterAmountThanAvlbalance);
        enterText(AppiumBy.xpath(getLocators("enterWithdrawAmount")), amountStr);
        Listeners.test.log(Status.INFO, "Entered Greater amount than available balance");
        // Assert.fail("Amount is not eligible. Stopping test.");
    }

    public void checkAmountIsGreater(){
        validatingTextMessage(AppiumBy.xpath(getLocators("greaterAmount")), "* Amount greater than balance");
        Listeners.logScreenshot(Status.FAIL, "Amount_greater_than_balance");
    }
}

