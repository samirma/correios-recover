package com.correios.recover.automator.recover.webclient;

import com.correios.recover.automator.recover.webclient.exceptions.AlertException;
import com.correios.recover.automator.recover.webclient.exceptions.factory.MessageAlertFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author samir
 */
public abstract class Browser {

    protected WebDriver driver;
    protected JavascriptExecutor javascriptExecutor;

    @Autowired
    protected MessageAlertFactory alertFactory;

    public void loadPage(String url) {
        driver.get(url);
    }

    public WebElement findElementByName(final String name) {
        return driver.findElement(By.name(name));
    }

    public WebElement findElementByXPath(final String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public void checkAlertDialog() {
        String alertMsg = null;
        try {
            final Alert alert = driver.switchTo().alert();
            alertMsg = alert.getText();
            alert.accept();
        } catch (NoAlertPresentException e) {
            return;
        }
        throw alertFactory.getAlertException(alertMsg);
    }

    public void blur(WebElement element) {
        javascriptExecutor.executeScript("arguments[0].onblur();", element);
    }

}
