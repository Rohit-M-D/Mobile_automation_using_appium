package Datman.senarios;

import Datman.pages.DashboardPage;

public class DashboardSenario {
    DashboardPage dp = new DashboardPage();

    public void dashBoardVerify(){
        dp.clickAllowNotification();
        dp.clickAllowLocation();
        dp.clickCancelBoimetric();
    }
}
