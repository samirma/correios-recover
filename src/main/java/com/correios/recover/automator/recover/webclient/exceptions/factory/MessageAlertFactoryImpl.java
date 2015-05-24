package com.correios.recover.automator.recover.webclient.exceptions.factory;

import com.correios.recover.automator.recover.webclient.exceptions.AlertException;
import com.correios.recover.automator.recover.webclient.exceptions.NotifyAlertException;
import com.correios.recover.automator.recover.webclient.exceptions.StopIterationExcepition;
import com.correios.recover.automator.recover.webclient.exceptions.WrongCaptchaException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class MessageAlertFactoryImpl implements MessageAlertFactory {

    private final List<String> notifyStrings = new ArrayList<>();
    private final List<String> stopIterationsStrings = new ArrayList<>();
    private final List<String> criticalStrings = new ArrayList<>();

    @PostConstruct
    public void init() {
        stopIterationsStrings.add("Verificar código digitado");
    }

    @Override
    public AlertException getAlertException(final String message) {
        AlertException excepetion = null;
        if (isNotifyExeption(message)) {
            excepetion = new NotifyAlertException(message);
        } else if (isStopIterationException(message)){
            excepetion = new StopIterationExcepition(message);
        } else if (StringUtils.contains(message, "digo de segurança incorreto")) {
            excepetion = new WrongCaptchaException(message);
        }
        
        return excepetion;
    }

    private boolean isNotifyExeption(final String message) {

        return simpleCheckList(message, notifyStrings);
    }

    private boolean isStopIterationException(final String message) {

        return simpleCheckList(message, stopIterationsStrings);

    }

    
    private boolean simpleCheckList(final String message, final List<String> strings) {
        boolean isNotifyExeption = false;
        for (String string : strings) {
            if (message.contains(string)) {
                isNotifyExeption = true;
                break;
            }
        }
        return isNotifyExeption;
    }

}
