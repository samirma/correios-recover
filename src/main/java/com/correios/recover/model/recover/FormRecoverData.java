package com.correios.recover.model.recover;

public interface FormRecoverData {

    String getCepOrder();

    String getPostalCode();

    String getCnpj();

    String getTrackerNumber();

    String getSenderEmail();

    String getAddress();

    String getSenderName();

    Integer getId();

    Integer getMotivationCode();

    String getReceiverName();

    String getSenderAddressNumber();

    String getReceiverAddressNumber();

    String getNeighborhood();

    String getReceiverNeighborhood();

    String getSenderCity();

    String getSenderState();

    String getReceiverCity();

    String getReceiverState();

    String getMessage();

}
