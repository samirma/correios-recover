/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.correios.recover.automator.recover.captcha;

import com.correios.recover.automator.recover.webclient.Browser;
import com.correios.recover.automator.recover.webclient.actions.ClickAction;
import com.correios.recover.automator.recover.webclient.exceptions.StopIterationExcepition;
import com.correios.recover.automator.recover.webclient.exceptions.factory.MessageAlertFactory;
import com.deathbycaptcha.Captcha;
import com.deathbycaptcha.Client;
import com.deathbycaptcha.HttpClient;
import com.deathbycaptcha.InvalidCaptchaException;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CapchaDeathbycaptcha")
public class CapchaDeathbycaptcha implements CaptchaSolver {

    public Client clientInstance;

    @Autowired
    protected MessageAlertFactory alertFactory;

    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CapchaDeathbycaptcha.class);

    @PostConstruct
    public void init() throws IOException {

        if (clientInstance == null) {
            ClassLoader classLoader = this.getClass().getClassLoader();
            File file = new File(classLoader.getResource("captcha.properties").getFile());
            Properties prop = new Properties();
            prop.load(new FileInputStream(file));
            final String user = prop.getProperty("usr");
            final String password = prop.getProperty("password");
            clientInstance = (Client) new HttpClient(user, password);
        }

    }

    private Captcha getCaptcha(final Browser browser) throws IOException, Exception, FileNotFoundException, InterruptedException {

        Client client = clientInstance;

        final String reload = "/html/body/div/div[3]/div[2]/div/div/div[2]/div[2]/div[3]/form/div[4]/div/div/div/span[2]/span[16]/label/div/img";

        File f = null;
        try {
            Captcha captcha = null;
            for (int i = 0; i < 10; i++) {
                try {

                    f = browser.takeScreenshot();

                    captcha = client.decode(f, 120);

                    if (null != captcha) {

                        return captcha;

                    }

                } catch (InvalidCaptchaException ec) {
                    new ClickAction(reload).execute(browser);
                    logger.error(ec);
                    StopIterationExcepition stop = new StopIterationExcepition(ec.getMessage());
                    throw stop;
                }
            }

        } catch (Exception e) {
            logger.error(e);
        } finally {
            if (f != null) {
                f.delete();
            }
        }

        return null;
    }

    private String getResult(Captcha captcha) {
        final String text = captcha.text;
        final String toUpperCase = text.toUpperCase().replaceAll(" ", "");
        return toUpperCase;
    }

    @Override
    public String solve(Browser aThis) {
        String result = null;
        try {
            final Captcha captcha = getCaptcha(aThis);
            result = getResult(captcha);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }

        return result;
    }


}
