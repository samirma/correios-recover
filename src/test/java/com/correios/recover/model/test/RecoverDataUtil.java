package com.correios.recover.model.test;

import com.correios.recover.model.recover.FormRecoverData;
import org.springframework.stereotype.Service;

@Service
public class RecoverDataUtil {

    public FormRecoverData getDumpData() {
        FormRecoverDataTest recoverData = new FormRecoverDataTest();
        
        recoverData.setTrackerNumber("43546");

        recoverData.setSenderName("setSenderName");
        recoverData.setCnpj("setCnpj");
        recoverData.setPostalCode("setPostalCode");
        recoverData.setAddress("setAddress");
        recoverData.setSenderEmail("setSenderEmail@setSenderEmail.setSenderEmail");
        recoverData.setReceiverName("setReceiverName");
        recoverData.setCepOrder("setCepOrder");
        recoverData.setSenderName("setSenderName");
        recoverData.setReceiverAddressNumber("setReceiverAddressNumber");

        recoverData.setMotivationCode(111);
        recoverData.setMessage("msg");

        return recoverData;
    }

}
