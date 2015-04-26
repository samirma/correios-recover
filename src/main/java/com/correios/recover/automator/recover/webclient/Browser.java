package com.correios.recover.automator.recover.webclient;

import com.correios.recover.automator.recover.webclient.exceptions.AlertMsgException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author samir
 */
public abstract class Browser {

    protected WebDriver driver;
    protected JavascriptExecutor javascriptExecutor;

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
        throw new AlertMsgException(alertMsg);
    }

}
