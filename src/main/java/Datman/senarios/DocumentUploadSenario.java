package Datman.senarios;

import Datman.pages.UploadDocumentPage;

public class DocumentUploadSenario {
    UploadDocumentPage udp = new UploadDocumentPage();

    public void uploadDocumentSenario() throws InterruptedException{
        udp.verifyUpdateDetailsBtnDisabled();
        udp.clickBankStatementUpload();
        udp.clickFilesOption();
        udp.selectdocument();
        Thread.sleep(9000);
        udp.verifyUpdateDetailsBtnEnabled();
        udp.clickUpdateDetailsBtn();
        udp.verifyOtpPage();
    
    }

    public void uploadPictureSenario() throws InterruptedException{
        udp.verifyUpdateDetailsBtnEnabled();
        udp.clickBankStatementUpload();
        udp.clickTakeFicture();
        udp.clickAllowCamera();
        udp.clickShutter();
        udp.clickDonePicture();
        udp.clickCropPicture();
        udp.verifyLargeSizefileAlert();
    }
}
