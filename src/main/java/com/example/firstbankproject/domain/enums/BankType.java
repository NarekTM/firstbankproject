package com.example.firstbankproject.domain.enums;

public enum BankType {
    CENTRAL_BANK("Central"), COMMERCIAL_BANK("Commercial"),
    RETAIL_BANK("Retail"), INVESTMENT_BANK("Investment");

    private final String type;

    BankType(String type) {
        this.type = type;
    }

    public String getGenderName() {
        return type;
    }
}
