package Datman.tests;

import org.testng.annotations.Test;


public class TC01_WithdrawFlowTest extends Objects {
    

    @Test
    public void tC01_WithdrawFlowTest()  {  
        
        login_ref.loginToApp();
        dashboard_ref.dashBoardVerify();
        withdraw_ref.withdrawProcessWithBalanceUpdate();

    }    
}
