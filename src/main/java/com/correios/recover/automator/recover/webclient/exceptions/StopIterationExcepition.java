
package com.correios.recover.automator.recover.webclient.exceptions;


public class StopIterationExcepition extends AlertException {

    public StopIterationExcepition(String alertMsg) {
        super(alertMsg);
    }

    public StopIterationExcepition(String message, Exception ex) {
        super(message, ex);
    }

}
