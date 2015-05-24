package com.correios.recover.automator.recover.service;

import com.correios.recover.CorreiosRecoverApplication;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CorreiosRecoverApplication.class)
public class PiParserTest {

    @Autowired
    private PiParser piParser;

    public PiParserTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testGetPIFromHtml() {
        final String html = getFile("pi/pi_sucess.html");
        
        final String pi = piParser.getPIFromHtml(html);
        
        assertEquals("33664529", pi);
        
    }

    private String getFile(String fileName) {

        String result = "";

        ClassLoader classLoader = getClass().getClassLoader();
        try {
            result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }

}
