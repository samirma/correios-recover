package com.correios.recover.automator.recover.webclient.exceptions;

public class AlertMsgException extends RuntimeException {

    public String alertMsg;

    public AlertMsgException(final String alertMsg) {
        this.alertMsg = alertMsg;
    }

    public String getAlertMsg() {
        return alertMsg;
    }

    public void setAlertMsg(String alertMsg) {
        this.alertMsg = alertMsg;
    }

}
