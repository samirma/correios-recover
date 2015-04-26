
package com.correios.recover.automator.recover.webclient.actions;

import com.correios.recover.automator.recover.webclient.Browser;


public class ClickAction implements WebAction{
    private String xpath;
    

    public ClickAction(String xpath) {
        this.xpath = xpath;
    }

    @Override
    public void exec(Browser browser) {
        
    }

}
