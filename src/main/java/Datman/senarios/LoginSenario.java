package Datman.senarios;

import Datman.pages.LoginPage;

public class LoginSenario  {

    LoginPage lp = new LoginPage();

    public void loginToApp() {
        lp.clickLoginWithEmail();
        lp.enterUsername();
        lp.enterPassword();
        lp.clickLogin();
    }
}
