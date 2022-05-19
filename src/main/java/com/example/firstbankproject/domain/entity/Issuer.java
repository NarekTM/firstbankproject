package com.example.firstbankproject.domain.entity;

import com.example.firstbankproject.domain.enums.*;

import javax.persistence.*;

@Entity
@Table(name = "issuer", uniqueConstraints = {
        @UniqueConstraint(name = "UQ_issuer__full_name", columnNames = {"full_name"}),
        @UniqueConstraint(name = "UQ_issuer__bank_code", columnNames = {"bank_code"}),
        @UniqueConstraint(name = "UQ_issuer__swift_code", columnNames = {"swift_code"})})
public class Issuer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "bank_code", nullable = false)
    private String bankCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "bank_type", nullable = false)
    private BankType bankType;

    @Column(name = "swift_code", nullable = false)
    private String swiftCode;

    public Issuer() {
    }

    public Issuer(Long id, String fullName, String bankCode, BankType bankType, String swiftCode) {
        this.id = id;
        this.fullName = fullName;
        this.bankCode = bankCode;
        this.bankType = bankType;
        this.swiftCode = swiftCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public BankType getBankType() {
        return bankType;
    }

    public void setBankType(BankType bankType) {
        this.bankType = bankType;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    @Override
    public String toString() {
        return "Issuer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", bankType=" + bankType +
                ", swiftCode='" + swiftCode + '\'' +
                '}';
    }
}
