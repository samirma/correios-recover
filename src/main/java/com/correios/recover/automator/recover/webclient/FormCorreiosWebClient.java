package com.correios.recover.automator.recover.webclient;

import com.correios.recover.automator.recover.webclient.actions.BlurEvent;
import com.correios.recover.automator.recover.FormCorreios;
import com.correios.recover.automator.recover.webclient.actions.ClickAction;
import com.correios.recover.automator.recover.webclient.actions.InputSelect;
import com.correios.recover.automator.recover.webclient.actions.InputText;
import com.correios.recover.automator.recover.webclient.actions.PageLoader;
import com.correios.recover.automator.recover.webclient.actions.WebAction;
import com.correios.recover.automator.recover.webclient.exceptions.NotifyAlertException;
import com.correios.recover.model.recover.FormRecoverData;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormCorreiosWebClient implements FormCorreios {

    private static final Long DEFAULT_DELAY = 800l;
    private static final Logger LOGGER = Logger.getLogger(FormCorreiosWebClient.class.getName());

    private static final String CODIGO_OBJETO = "codigoObjeto";

    private final static List<WebAction> load;
    private final static List<WebAction> codeTracker;
    private final static List<WebAction> sender;
    private final static List<WebAction> receiver;
    private final static List<WebAction> details;

    @Autowired
    private Browser browser;

    static {
        load = new ArrayList<>();
        codeTracker = new ArrayList<>();
        sender = new ArrayList<>();
        receiver = new ArrayList<>();
        details = new ArrayList<>();

        load.add(new PageLoader("http://www2.correios.com.br/sistemas/falecomoscorreios/"));
        load.add(new InputSelect("tipo", "I"));
        load.add(new InputSelect("origem_objeto", "N"));
        load.add(new ClickAction("//*[@id=\"aceite\"]"));

    }

    private void executeActions(List<WebAction> actions) {

        for (WebAction action : actions) {
            try {
                action.execute(browser);
            } catch (NotifyAlertException ex) {
                continue;
            } catch (Exception ex) {
                throw ex;
            }

            sleep();
        }

    }

    private void sleep() {
        try {
            Thread.sleep(DEFAULT_DELAY);
        } catch (InterruptedException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void loadForm() {
        executeActions(load);
    }

    @Override
    public boolean isFormReadyloaded() {
        final boolean isNull = browser.findElementByName(CODIGO_OBJETO) != null;
        return isNull;
    }

    @Override
    public void setRecoverData(FormRecoverData recoverData) {

    }

    @Override
    public void fillTrackingCode() {
        executeActions(codeTracker);
    }

    @Override
    public void fillSenderFields() {
        executeActions(sender);
    }

    @Override
    public void fillRecipientFields() {
        executeActions(receiver);
    }

    @Override
    public void fillDetailsFields() {
        executeActions(details);
    }

    @Override
    public void submitForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void submitPiNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadRecoverData(FormRecoverData recoverData) {
        codeTracker.add(new InputText(CODIGO_OBJETO, recoverData.getTrackerNumber()));

        loadSenderActions(recoverData);
        loadReceiverAction(recoverData);
        loadDetailsAction(recoverData);

    }

    private void loadSenderActions(FormRecoverData recoverData) {

        sender.add(new InputText("nome", recoverData.getSenderName()));
        sender.add(new ClickAction("//*[@value=\"CNPJ\"]"));
        sender.add(new InputText("CPF_CNPJ", recoverData.getCnpj()));
        sender.add(new InputText("CEP", recoverData.getPostalCode()));
        sender.add(new BlurEvent("CEP"));
        sender.add(new InputText("endereco", recoverData.getAddress()));
        sender.add(new InputText("numero", recoverData.getSenderAddressNumber()));
        sender.add(new InputText("bairro", recoverData.getNeighborhood()));
        sender.add(new InputText("cidade", recoverData.getSenderCity()));
        sender.add(new InputText("UF", recoverData.getSenderState()));
        sender.add(new InputText("email", recoverData.getSenderEmail()));

    }

    private void loadReceiverAction(FormRecoverData recoverData) {

        receiver.add(new InputText("nomeDestino", recoverData.getReceiverName()));
        receiver.add(new InputText("CEPDestino", recoverData.getCepOrder()));
        receiver.add(new BlurEvent("CEPDestino"));
        receiver.add(new InputText("enderecoDestino", recoverData.getSenderName()));
        receiver.add(new InputText("numeroDestino", recoverData.getReceiverAddressNumber()));
        receiver.add(new InputText("bairroDestino", recoverData.getReceiverNeighborhood()));
        receiver.add(new InputText("cidadeDestino", recoverData.getReceiverCity()));
        receiver.add(new InputText("UFDestino", recoverData.getReceiverState()));
    }

    private void loadDetailsAction(FormRecoverData recoverData) {

        details.add(new ClickAction("//*[@value=\"113\"]"));
        details.add(new InputSelect("motivo", recoverData.getMotivationCode().toString()));
        //details.add(new InputSelect("msg", recoverData.getMessage()));

    }

}
