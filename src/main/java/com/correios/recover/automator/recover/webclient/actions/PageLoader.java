
package com.correios.recover.automator.recover.webclient.actions;

import com.correios.recover.automator.recover.webclient.Browser;


public class PageLoader implements WebAction{
    private String url;
    
    public PageLoader(final String url) {
        this.url = url;
    }

    @Override
    public void exec(Browser browser) {
        browser.loadPage(url);
    }



}
