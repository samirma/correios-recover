package com.correios.recover.automator.recover.webclient;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author samir
 */
public class Browser {

    protected WebDriver driver;

    public void loadPage(String url) {
        driver.get(url);
    }
}
