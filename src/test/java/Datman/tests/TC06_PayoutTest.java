package Datman.tests;

import org.testng.annotations.Test;

public class TC06_PayoutTest extends Objects {
    
    @Test
    public void tc06_PayoutTest(){
        login_ref.loginToApp();
        dashboard_ref.dashBoardVerify();
        withdraw_ref.withdrawProcessWithPayout();
    }
}
