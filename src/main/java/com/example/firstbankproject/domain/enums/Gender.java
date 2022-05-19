package com.example.firstbankproject.domain.enums;

public enum Gender {
    MALE("male"), FEMALE("female");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGenderName() {
        return gender;
    }
}
