package com.correios.recover.automator.recover.webclient.actions;

import com.correios.recover.automator.recover.webclient.Browser;
import org.openqa.selenium.WebElement;


public class InputText extends NameValueInput {

    public InputText(String name, String value) {
        super(name, value);
    }

    @Override
    void executeAction(Browser browser) {
        WebElement element = browser.findElementByName(name);
        element.click();
        element.sendKeys(getValue());
    }

}
