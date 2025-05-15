package Datman.tests;

import org.testng.annotations.Test;

public class TC04_AccountNotExists extends Objects {
    
    @Test
    public void tc04_AccountNotExists() throws InterruptedException{
        login_ref.loginToApp();
        dashboard_ref.dashBoardVerify();
        bankupdate_ref.updateAccountNotExists(); 
    }
}
