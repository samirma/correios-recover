package com.correios.recover.automator.recover;

import com.correios.recover.model.recover.FormRecoverData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormRecoverService {

    @Autowired
    private FormCorreios fc;

    public void loadForm() {
        fc.loadForm();
    }

    public boolean isFormReadyloaded() {
        return true;
    }

    public void setRecoverData(FormRecoverData recoverData) {
        fc.loadRecoverData(recoverData);
    }

    public void fillTrackingCode() {
        fc.fillTrackingCode();
    }

    public void fillSenderFields() {
        fc.fillSenderFields();
    }

    public void fillReceiverFields() {
        fc.fillRecipientFields();

    }

    public void fillDetailsFields() {
        fc.fillDetailsFields();
    }

    public void submitForm() {
        fc.submitForm();
    }

    public void submitPiNumber() {
        fc.submitPiNumber();
    }

    public boolean isPISaved() {
        return true;
    }

    public String getPINumber() {
        return "123";
    }

}
