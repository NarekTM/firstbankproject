package com.example.firstbankproject.domain.enums;

public enum CardProcessingNetwork {
    VISA("Visa"), MASTER_CARD("Master Card"), AMERICAN_EXPRESS("American Express");

    private final String network;

    CardProcessingNetwork(String network) {
        this.network = network;
    }

    public String getGenderName() {
        return network;
    }
}
