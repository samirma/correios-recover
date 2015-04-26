/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.correios.recover.automator.recover.webclient.actions;

import com.correios.recover.automator.recover.webclient.Browser;

/**
 *
 * @author samir
 */
public abstract class WebAction {
    
    public void execute(final Browser browser){
        preExecuteAction(browser);
        executeAction(browser);
    }

    abstract void executeAction(Browser browser);

    public void preExecuteAction(Browser browser) {
        browser.checkAlertDialog();
    }

}
