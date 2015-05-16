package com.correios.recover.automator.recover.webclient.exceptions;

public class AlertException extends RuntimeException {

    public String alertMsg;

    public AlertException(final String alertMsg) {
        this.alertMsg = alertMsg;
    }

    public String getAlertMsg() {
        return alertMsg;
    }

    public void setAlertMsg(String alertMsg) {
        this.alertMsg = alertMsg;
    }

}
