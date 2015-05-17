package com.correios.recover.model.test;

import com.correios.recover.model.recover.FormRecoverData;
import org.springframework.stereotype.Service;

@Service
public class RecoverDataUtil {

    public FormRecoverData getDumpWrongData() {
        FormRecoverDataTest recoverData = new FormRecoverDataTest();
        
        recoverData.setTrackerNumber("43546");

        recoverData.setSenderName("setSenderName");


        return recoverData;
    }
    
        public FormRecoverData getDumpData() {
        FormRecoverDataTest recoverData = new FormRecoverDataTest();
        
        recoverData.setTrackerNumber("43546");

        recoverData.setSenderName("DumpName");
        recoverData.setCnpj("setCnpj");
        recoverData.setPostalCode("setPostalCode");
        recoverData.setAddress("setAddress");
        recoverData.setSenderEmail("setSenderEmail@setSenderEmail.setSenderEmail");
        recoverData.setReceiverName("setReceiverName");
        recoverData.setCepOrder("setCepOrder");
        recoverData.setSenderName("setSenderName");
        recoverData.setReceiverAddressNumber("setReceiverAddressNumber");

        recoverData.setMotivationCode(148);
        recoverData.setMessage("msg");

        return recoverData;
    }

    public FormRecoverData getDumpDataOk() {
        FormRecoverDataTest recoverData = new FormRecoverDataTest();
        
        recoverData.setTrackerNumber("DJ221049061BR");

        recoverData.setSenderName("Tiago Araujo Carvalho");
        recoverData.setCnpj("09248608000104");
        recoverData.setPostalCode("22640972");
        recoverData.setAddress("RUA SENADOR DANTAS");
        recoverData.setSenderCity("Rio de Janeiro");
        recoverData.setSenderState("RJ");
        recoverData.setSenderAddressNumber("54");
        recoverData.setNeighborhood("Centro");
        recoverData.setSenderEmail("EduardoCunhaMelo@armyspy.com");
        recoverData.setReceiverName("Eduardo Cunha Melo");
        recoverData.setCepOrder("21840970");
        recoverData.setReceiverAddressNumber("54");
        recoverData.setReceiverNeighborhood("Centro");
        recoverData.setReceiverCity("Rio de Janeiro");
        recoverData.setReceiverState("RJ");

        recoverData.setMotivationCode(148);
        recoverData.setMessage("Prezado CORREIOS, quando um carteiro já sai pra entrega com atraso, o reembolso por atraso dever ser executado conforme a Lei nº 8.078 do Código Civil Brasileiro e item 2.2.8 do Termo de Condições Gerais, página 218 dos Correios. Sendo assim, solicitamos por favor o reembolso deste objeto. Temos um contrato vigente que, ao postar um objeto, aceitamos um prazo para que este chegue a uma agência ECT (quando a cidade não possui um número mínimo de habitantes para entrega porta a porta) e/ou ao destinatário quando possível, logo, caso este prazo venha a ser frustrado, entendemos que o pedido de reembolso é válido, EXCLUINDO qualquer culpa do destinatário, ou seja: buscando ou não o objeto na agência (conhecido como não procurado), assim como destinatário desconhecido no endereço (Objeto devolvido) ou endereço insuficiente para entrega, onde mais uma vez reforçamos: independente do destinatário receber ou não o objeto, quando um carteiro já sai pra entrega com atraso, o reembolso por atraso dever ser executado.");
       

        return recoverData;
    }

}
