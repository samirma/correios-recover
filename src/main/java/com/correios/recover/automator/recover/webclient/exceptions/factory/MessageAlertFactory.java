
package com.correios.recover.automator.recover.webclient.exceptions.factory;

import com.correios.recover.automator.recover.webclient.exceptions.AlertException;


public interface MessageAlertFactory {

    public AlertException getAlertException(final String message);

}
