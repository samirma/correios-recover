package com.correios.recover.automator.recover.webclient;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author samir
 */
public abstract class Browser {

    protected WebDriver driver;
    protected JavascriptExecutor javascriptExecutor;
    
    private final String CHANGE_EVENT = "$('[name=%s]').change()";
    private final String BLUR_EVENT = "$('[name=%s]').blur()";

    public void loadPage(String url) {
        driver.get(url);
    }

    public WebElement findElementByName(final String name) {
        return driver.findElement(By.name(name));
    }

    public WebElement findElementByXPath(final String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public void blurByJavaScript(final String name) {
        javascriptExecutor.executeScript(CHANGE_EVENT, name);
        javascriptExecutor.executeScript(String.format(BLUR_EVENT, name));
    }
    

}
