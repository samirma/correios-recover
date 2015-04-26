package com.correios.recover.automator.recover.webclient.browsers;

import com.correios.recover.automator.recover.webclient.Browser;
import javax.annotation.PostConstruct;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Service;

@Service("firefox")
public class Firefox extends Browser{

    @PostConstruct
    public void init() {
        driver = new FirefoxDriver();
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    
}
