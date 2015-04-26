package com.correios.recover.automator.recover.webclient;

import com.correios.recover.automator.recover.FormCorreios;
import com.correios.recover.automator.recover.webclient.actions.ClickAction;
import com.correios.recover.automator.recover.webclient.actions.InputCombo;
import com.correios.recover.automator.recover.webclient.actions.PageLoader;
import com.correios.recover.automator.recover.webclient.actions.WebAction;
import com.correios.recover.model.recover.FormRecoverData;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormCorreiosWebClient implements FormCorreios {

    private final static List<WebAction> load;
    private final static List<WebAction> codeTracker;
    private final static List<WebAction> sender;
    private final static List<WebAction> recipient;
    private final static List<WebAction> details;
    
    @Autowired
    private Browser browser;

    static {
        load = new ArrayList<>();
        codeTracker = new ArrayList<>();
        sender = new ArrayList<>();
        recipient = new ArrayList<>();
        details = new ArrayList<>();

        load.add(new PageLoader("http://www2.correios.com.br/sistemas/falecomoscorreios/"));
        load.add(new InputCombo("tipo", "I"));
        load.add(new InputCombo("origem_objeto", "N"));
        load.add(new ClickAction("//*[@id=\"aceite\"]"));

    }


    private void executeActions(List<WebAction> actions) {
        
        actions.stream().forEach((action) -> {
            action.exec(browser);
        });

    }

    @Override
    public void loadForm() {
        executeActions(load);
    }

    @Override
    public boolean isFormReadyloaded() {
        return true;
    }

    @Override
    public void setRecoverData(FormRecoverData recoverData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fillTrackingCode() {
        executeActions(codeTracker);
    }

    @Override
    public void fillSenderFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fillRecipientFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fillDetailsFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void submitForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void submitPiNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
