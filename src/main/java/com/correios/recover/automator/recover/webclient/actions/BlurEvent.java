
package com.correios.recover.automator.recover.webclient.actions;

import com.correios.recover.automator.recover.webclient.Browser;
import org.openqa.selenium.WebElement;


public class BlurEvent extends WebAction {
    private String name;

    public BlurEvent(String name) {
        this.name = name;
    }

    @Override
    void executeAction(Browser browser) {
        WebElement element = browser.findElementByName(name);
        browser.blur(element);
    }

}
