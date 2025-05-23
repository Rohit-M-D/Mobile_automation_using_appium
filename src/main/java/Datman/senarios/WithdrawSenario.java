package Datman.senarios;

import Datman.pages.WithdrawPage;

public class WithdrawSenario {
    static WithdrawPage wp = new WithdrawPage();

    public static void withdrawProcess() {
        wp.validateAvailableBalance();
        wp.validateMerchantStatus();
        wp.clickWithdrawBtn();
        wp.checkWithdrawBtnDisable();
        wp.enterAmountToWithdraw();
        wp.checkWithdrawBtnEnable();
        wp.clickFinalWithdrawBtn();
        wp.clickConformPopup();
        wp.validateSuccessfulWithdraw();
    }

    public void withdrawProcessWithBalanceUpdate() {
        wp.validateAvailableBalance();
        wp.validateMerchantStatus();
        wp.clickWithdrawBtn();
        wp.checkWithdrawBtnDisable();
        wp.enterAmountToWithdraw();
        wp.checkWithdrawBtnEnable();
        wp.clickFinalWithdrawBtn();
        wp.clickConformPopup();
        wp.validateSuccessfulWithdraw();
        wp.validateAvailableBalanceAfterWithdraw();
    }

    public void withdrawProcessWithGreaterAmount() {
        wp.validateAvailableBalance();
        wp.validateMerchantStatus();
        wp.clickWithdrawBtn();
        wp.checkWithdrawBtnDisable();
        wp.enterGreaterAmount();
        wp.checkAmountIsGreater();
    }
    public void withdrawProcessWithPayout() {
        wp.validateAvailableBalance();
        wp.validateMerchantStatus();
        wp.clickWithdrawBtn();
        wp.checkWithdrawBtnDisable();
        wp.enterAmountToWithdraw();
        wp.checkWithdrawBtnEnable();
        wp.clickFinalWithdrawBtn();
        wp.clickConformPopup();
        wp.validateSuccessfulWithdraw();
        wp.validateAvailableBalanceAfterWithdraw();
        wp.clickPayout();
        wp.clickPendingBtn();
        wp.verifyLastTransaction();
    }
}
