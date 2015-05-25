package com.correios.recover.automator.recover;

import com.correios.recover.model.recover.FormRecoverData;

public interface FormCorreios {
    
    public void loadForm();

    public boolean isFormReadyloaded();

    public void setRecoverData(FormRecoverData recoverData);

    public void fillTrackingCode();

    public void fillSenderFields();

    public void fillRecipientFields();

    public void fillDetailsFields();

    public void submitForm();

    public void loadRecoverData(FormRecoverData recoverData);

    public String getPINumber();

}
