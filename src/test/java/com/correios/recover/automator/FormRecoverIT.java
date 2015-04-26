/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.correios.recover.automator;

import com.correios.recover.automator.recover.FormRecoverService;
import com.correios.recover.CorreiosRecoverApplication;
import com.correios.recover.model.test.RecoverDataUtil;
import com.correios.recover.model.recover.FormRecoverData;
import org.apache.commons.lang3.StringUtils;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author samir
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CorreiosRecoverApplication.class)
public class FormRecoverIT {
    @Autowired
    private FormRecoverService formRecoverService;
    
    @Autowired
    private RecoverDataUtil dataUtil;
    
    
    public FormRecoverIT() {
    }
    
    @Before
    public void setUp() {
        
    }

    @Test
    public void testSucessifulService() {
        
        formRecoverService.loadForm();
        
        assertTrue(formRecoverService.isFormReadyloaded());
        
        FormRecoverData recoverData = dataUtil.getDumpData();
        formRecoverService.setRecoverData(recoverData);
        
        formRecoverService.fillTrackingCode();
        
        formRecoverService.fillSenderFields();
                
        formRecoverService.fillReceiverFields();
        
        formRecoverService.fillDetailsFields();
        
        formRecoverService.submitForm();
        
        formRecoverService.submitPiNumber();
        
        assertTrue(formRecoverService.isPISaved());
        
        assertTrue(StringUtils.isNumeric(formRecoverService.getPINumber()));
        
    }
    
}
