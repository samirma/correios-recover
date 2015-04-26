
package com.correios.recover.automator.recover.webclient.actions;

import com.correios.recover.automator.recover.webclient.Browser;


public class PageLoader extends WebAction{
    private String url;
    
    public PageLoader(final String url) {
        this.url = url;
    }

    @Override
    void executeAction(Browser browser) {
        browser.loadPage(url);
    }



}
