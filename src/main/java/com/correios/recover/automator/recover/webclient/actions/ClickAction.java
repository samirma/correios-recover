
package com.correios.recover.automator.recover.webclient.actions;

import com.correios.recover.automator.recover.webclient.Browser;
import org.openqa.selenium.WebElement;


public class ClickAction extends WebAction{
    private String xpath;

    public ClickAction(String xpath) {
        this.xpath = xpath;
    }

    @Override
    void executeAction(Browser browser) {
        final WebElement element = browser.findElementByXPath(xpath);
        element.click();
    }

}
