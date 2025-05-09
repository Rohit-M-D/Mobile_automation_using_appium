package Datman.senarios;

import Datman.pages.UploadDocumentPage;

public class DocumentUploadSenario {
    static UploadDocumentPage udp = new UploadDocumentPage();

    public void uploadDocumentSenario() throws InterruptedException{
        udp.verifyUpdateDetailsBtnEnabled();
        udp.clickBankStatementUpload();
        udp.clickFilesOption();
        udp.selectdocument();
        Thread.sleep(9000);
        udp.clickUpdateDetailsBtn();
        udp.verifyOtpPage();
    
    }
}
