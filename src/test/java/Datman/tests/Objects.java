package Datman.tests;

import Datman.base.BasePage;
import Datman.senarios.BankDetailsUpdateSenario;
import Datman.senarios.DashboardSenario;
import Datman.senarios.DocumentUploadSenario;
import Datman.senarios.LoginSenario;
import Datman.senarios.WithdrawSenario;


public class Objects extends BasePage {
    LoginSenario login_ref = new LoginSenario();
    DashboardSenario dashboard_ref = new DashboardSenario();
    WithdrawSenario withdraw_ref = new WithdrawSenario();
    BankDetailsUpdateSenario bankupdate_ref = new BankDetailsUpdateSenario();
    DocumentUploadSenario document_ref = new DocumentUploadSenario();
}
