
package com.correios.recover.automator.recover.webclient.exceptions;


public class WrongCaptchaException extends AlertException{

    public WrongCaptchaException(String alertMsg) {
        super(alertMsg);
    }

    public WrongCaptchaException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public WrongCaptchaException(Throwable thrwbl) {
        super(thrwbl);
    }

}
