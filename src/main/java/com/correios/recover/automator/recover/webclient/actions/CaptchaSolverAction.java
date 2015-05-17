
package com.correios.recover.automator.recover.webclient.actions;

import com.correios.recover.automator.recover.webclient.Browser;


public class CaptchaSolverAction extends InputText{

    public CaptchaSolverAction(String name, String value) {
        super(name, value);
    }

    @Override
    void executeAction(Browser browser) {
        value = browser.getCapthaString();
        super.executeAction(browser);
    }

}
