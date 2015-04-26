package com.correios.recover.automator.recover.webclient.actions;

import com.correios.recover.automator.recover.webclient.Browser;

public abstract class NameValueInput implements WebAction {

    protected String name;
    protected String value;

    public NameValueInput(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public void exec(Browser browser) {
    }

}
