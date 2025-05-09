package Datman.tests;

import org.testng.annotations.Test;

public class TC02_UpdatebankTest extends Objects {
    
    @Test
    public void tC02_UpdatebankTest() throws InterruptedException  {
        login_ref.loginToApp();
        dashboard_ref.dashBoardVerify();
        bankupdate_ref.updateBankDetails();
        document_ref.uploadDocumentSenario();  
    }
}
