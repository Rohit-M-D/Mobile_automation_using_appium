package Datman.tests;

import org.testng.annotations.Test;

public class TC05_LargeSizefileTest extends Objects {
    

    @Test
    public void tc05_LargeSizefileTest() throws InterruptedException{
        login_ref.loginToApp();
        dashboard_ref.dashBoardVerify();
        bankupdate_ref.updateSimpleBankDetails();
        document_ref.uploadPictureSenario();
    }
}
