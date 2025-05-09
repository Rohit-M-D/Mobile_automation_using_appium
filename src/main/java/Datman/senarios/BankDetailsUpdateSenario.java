package Datman.senarios;

import Datman.pages.UpdateBankPage;

public class BankDetailsUpdateSenario {
    UpdateBankPage uptbank = new UpdateBankPage();

    public void updateBankDetails() throws InterruptedException {
           uptbank.clickSettingsBtn();
           uptbank.clickUpdateBankDetailsBtn();
           Thread.sleep(3000);
           uptbank.scrollDown("Update");
           uptbank.checkUpdateButoonIsDisbled();
           uptbank.verifyLastThreeDigitSortCode();
           uptbank.enterExstitingSortCode("232323");
           uptbank.enterExstitingAccountNo("23232323");
           uptbank.enterNewSortCode("232323");
           uptbank.enterAccountHolderName("test");
           uptbank.enterNewAccountNo("2323232");
           uptbank.verifyAccountNumberDigits();
           uptbank.enterNewAccountNo("23232325");
           uptbank.confirmNewAccountNo("23232324");
           uptbank.varifyAccountNumberMismatch();
           uptbank.enterNewAccountNo("23232324");
           uptbank.confirmNewAccountNo("23232324");
           uptbank.enterNameofBank("uk");
           uptbank.clickUpdateBtn();
           uptbank.clickUpdateBtn();
           uptbank.clickOverrideBtn();
    }

}
