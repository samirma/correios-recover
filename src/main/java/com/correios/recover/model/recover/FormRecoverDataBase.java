package com.correios.recover.model.recover;

import java.util.Objects;

public class FormRecoverDataBase implements FormRecoverData {

    protected Integer id;

    protected String cepOrder;

    protected String postalCode;

    protected String cnpj;

    protected String trackerNumber;

    protected String senderEmail;

    private String neighborhood;

    private String receiverNeighborhood;

    private String senderCity;
    private String senderState;

    private String receiverCity;
    private String receiverState;

    protected String address;

    protected String senderName;

    protected Integer motivationCode;

    protected String senderAddressNumber;

    protected String receiverName;

    protected String receiverAddressNumber;

    protected String message;

    @Override
    public String getCepOrder() {
        return cepOrder;
    }

    public void setCepOrder(String cepOrder) {
        this.cepOrder = cepOrder;
    }

    @Override
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String getTrackerNumber() {
        return trackerNumber;
    }

    public void setTrackerNumber(String trackerNumber) {
        this.trackerNumber = trackerNumber;
    }

    @Override
    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getMotivationCode() {
        return motivationCode;
    }

    public void setMotivationCode(Integer motivationCode) {
        this.motivationCode = motivationCode;
    }

    @Override
    public String getSenderAddressNumber() {
        return senderAddressNumber;
    }

    public void setSenderAddressNumber(String senderAddressNumber) {
        this.senderAddressNumber = senderAddressNumber;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    @Override
    public String getReceiverAddressNumber() {
        return receiverAddressNumber;
    }

    public void setReceiverAddressNumber(String receiverAddressNumber) {
        this.receiverAddressNumber = receiverAddressNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FormRecoverDataBase other = (FormRecoverDataBase) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * @return the neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * @param neighborhood the neighborhood to set
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * @return the receiverNeighborhood
     */
    public String getReceiverNeighborhood() {
        return receiverNeighborhood;
    }

    /**
     * @param receiverNeighborhood the receiverNeighborhood to set
     */
    public void setReceiverNeighborhood(String receiverNeighborhood) {
        this.receiverNeighborhood = receiverNeighborhood;
    }

    /**
     * @return the senderCity
     */
    public String getSenderCity() {
        return senderCity;
    }

    /**
     * @param senderCity the senderCity to set
     */
    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    /**
     * @return the senderState
     */
    public String getSenderState() {
        return senderState;
    }

    /**
     * @param senderState the senderState to set
     */
    public void setSenderState(String senderState) {
        this.senderState = senderState;
    }

    /**
     * @return the receiverCity
     */
    public String getReceiverCity() {
        return receiverCity;
    }

    /**
     * @param receiverCity the receiverCity to set
     */
    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    /**
     * @return the receiverState
     */
    public String getReceiverState() {
        return receiverState;
    }

    /**
     * @param receiverState the receiverState to set
     */
    public void setReceiverState(String receiverState) {
        this.receiverState = receiverState;
    }

}
