package com.correios.recover.model.recover;


public interface FormRecoverData {

    /**
     * @return the cepOrder
     */
    String getCepOrder();

    /**
     * @return the cepPost
     */
    String getPostalCode();

    /**
     * @return the cnpj
     */
    String getCnpj();

    /**
     * @return the codigoDeRegistro
     */
    String getTrackerNumber();

    /**
     * @return the emailParaContato
     */
    String getSenderEmail();

    /**
     * @return the endereco
     */
    String getAddress();

    /**
     * @return the enderecoDoDestinatario
     */
    String getEnderecoDoDestinatario();

    /**
     * @return the id
     */
    Integer getId();

    /**
     * @return the motivoDaSolicitacao
     */
    Integer getMotivoDaSolicitacao();

    /**
     * @return the nomeCompletoDoRemetente
     */
    String getNomeCompletoDoRemetente();

    /**
     * @return the nomeDoDestinatario
     */
    String getNomeDoDestinatario();

    /**
     * @return the numero
     */
    String getNumero();

    /**
     * @return the numeroDoDestinatario
     */
    String getNumeroDoDestinatario();

    /**
     * @return the observacao
     */
    String getObservacao();
    
}
