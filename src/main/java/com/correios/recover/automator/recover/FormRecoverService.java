package com.correios.recover.automator.recover;

import com.correios.recover.automator.recover.repository.FormRecoverRepository;
import com.correios.recover.automator.recover.service.PiParser;
import com.correios.recover.model.recover.FormRecoverData;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormRecoverService {

    @Autowired
    private FormCorreios fc;

    @Autowired
    private PiParser piParser;
    
    @Autowired
    private FormRecoverRepository repository;

    public void loadForm() {
        fc.loadForm();
    }

    public boolean isFormReadyloaded() {
        return true;
    }

    public void setRecoverData(final FormRecoverData recoverData) {
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

    public boolean isPISaved() {
        return true;
    }

    public String getPINumber() {
        final String piNumber = fc.getPINumber();
        return piNumber;
    }

    public void processData(final FormRecoverData recoverData) {

        loadForm();

        setRecoverData(recoverData);

        fillTrackingCode();

        fillSenderFields();

        fillReceiverFields();

        fillDetailsFields();

        submitForm();

        final String piNumber = getPINumber();
        
        repository.savePi(piNumber, recoverData);

    }
    
    public List<FormRecoverData> getList(){
        return repository.getFormRecoverDataToProcess();
    }

}
