package Datman.tests;

import org.testng.annotations.Test;

public class TC03_EnteredGreaterAmountTest extends Objects{
    
    @Test
    public void tc03_withdrawFailureTest(){
        login_ref.loginToApp();
        dashboard_ref.dashBoardVerify();
        withdraw_ref.withdrawProcessWithGreaterAmount();
    }
}
