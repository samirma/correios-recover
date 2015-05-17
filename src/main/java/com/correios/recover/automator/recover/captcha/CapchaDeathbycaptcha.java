/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.correios.recover.automator.recover.captcha;


import com.correios.recover.automator.recover.webclient.Browser;
import com.correios.recover.automator.recover.webclient.actions.ClickAction;
import com.deathbycaptcha.Captcha;
import com.deathbycaptcha.Client;
import com.deathbycaptcha.HttpClient;
import com.deathbycaptcha.InvalidCaptchaException;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.annotation.PostConstruct;


public class CapchaDeathbycaptcha {

    public static Client clientInstance;

    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CapchaDeathbycaptcha.class);
    
    @PostConstruct
    public void init() throws IOException {

        if (clientInstance == null) {
            ClassLoader classLoader = "".getClass().getClassLoader();
            File file = new File(classLoader.getResource("captcha.properties").getFile());
            Properties prop = new Properties();
            prop.load(new FileInputStream(file));
            final String user = prop.getProperty("usr");
            final String password = prop.getProperty("password");
            clientInstance = (Client) new HttpClient(user, password);
        }
        
    }

    public Captcha obterCaptcha(final Browser browser) throws IOException, Exception, FileNotFoundException, InterruptedException {

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
                    System.out.printf("Imagem inválida, recarregando: %s \n", ec.getMessage());
                    Thread.sleep(500);
                }
            }

        } catch (Exception e) {
            logger.error("Error no captcha", e);
        } finally {
            if (f != null) {
                f.delete();
            }
        }

        return null;
    }

    public String obterString(Captcha captcha) {
        final String text = captcha.text;
        final String toUpperCase = text.toUpperCase().replaceAll(" ", "");
        logger.info("CAPTCHA Solved: " + toUpperCase);
        return toUpperCase;
    }



}
