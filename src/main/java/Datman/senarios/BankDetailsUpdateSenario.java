package Datman.senarios;

import Datman.pages.UpdateBankPage;

public class BankDetailsUpdateSenario {
       UpdateBankPage uptbank = new UpdateBankPage();

       public void updateSimpleBankDetails() throws InterruptedException {
              uptbank.clickSettingsBtn();
              uptbank.clickUpdateBankDetailsBtn();
              Thread.sleep(3000);
              uptbank.scrollDown("Update");
              uptbank.swipeUp();
              uptbank.checkUpdateButtonDisbled();
              uptbank.verifyLastThreeDigitSortCode("323");
              uptbank.enterExstitingSortCode("232323");
              uptbank.enterExstitingAccountNo("23232323");
              uptbank.enterNewSortCode("232323");
              uptbank.enterAccountHolderName("test");
              uptbank.enterNewAccountNo("23232322");
              uptbank.confirmNewAccountNo("23232322");
              uptbank.enterNameofBank("uk");
              uptbank.checkUpdateButtonEnabled();
              uptbank.clickUpdateBtn();
              uptbank.clickUpdateBtn();
              uptbank.clickOverrideBtn();
       }

       public void updateBankDetails() throws InterruptedException {
              uptbank.clickSettingsBtn();
              uptbank.clickUpdateBankDetailsBtn();
              Thread.sleep(3000);
              uptbank.scrollDown("Update");
              uptbank.swipeUp();
              uptbank.checkUpdateButtonDisbled();
              uptbank.verifyLastThreeDigitSortCode("323");
              uptbank.enterExstitingSortCode("232323");
              uptbank.enterExstitingAccountNo("23232323");
              uptbank.enterWrongNewSortCode("23232");
              uptbank.verifyWrongDigitSortcode();
              uptbank.enterNewSortCode("232323");
              uptbank.enterAccountHolderName("test");
              uptbank.enterNewAccountNo("2323232");
              uptbank.verifyAccountNumberDigits();
              uptbank.enterNewAccountNo("23232325");
              uptbank.confirmNewAccountNo("23232324");
              uptbank.varifyAccountNumberMismatch();
              uptbank.enterNewAccountNo("23232321");
              uptbank.confirmNewAccountNo("23232321");
              uptbank.enterNameofBank("uk-test-bank");
              uptbank.checkUpdateButtonEnabled();
              uptbank.clickUpdateBtn();
              uptbank.clickUpdateBtn();
              uptbank.clickOverrideBtn();
       }

       public void updateAccountNotExists() throws InterruptedException {
              uptbank.clickSettingsBtn();
              uptbank.clickUpdateBankDetailsBtn();
              Thread.sleep(3000);
              uptbank.scrollDown("Update");
              uptbank.checkUpdateButtonDisbled();
              uptbank.verifyLastThreeDigitSortCode("323");
              uptbank.enterExstitingSortCode("232323");
              uptbank.enterExstitingAccountNo("23232323");
              uptbank.enterNewSortCode("232324");
              uptbank.enterAccountHolderName("test");
              uptbank.enterNewAccountNo("23232325");
              uptbank.enterNewAccountNo("23232324");
              uptbank.confirmNewAccountNo("23232324");
              uptbank.enterNameofBank("uk-bank");
              uptbank.checkUpdateButtonEnabled();
              uptbank.clickUpdateBtn();
              uptbank.clickUpdateBtn();
              uptbank.verifyAccountExists();
       }

}
