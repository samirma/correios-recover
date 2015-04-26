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
    }

    public void fillTrackingCode() {
    }

    public void fillSenderFields() {
    }

    public void fillRecipientFields() {
    }

    public void fillDetailsFields() {
    }

    public void submitForm() {
    }

    public void submitPiNumber() {
    }

    public boolean isPISaved() {
        return true;
    }

    public String getPINumber() {
        return "123";
    }

}
