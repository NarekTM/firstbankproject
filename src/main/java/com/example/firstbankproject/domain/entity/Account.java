package com.example.firstbankproject.domain.entity;

import com.example.firstbankproject.domain.enums.*;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "iban", nullable = false)
    private String iban;

    @Column(name = "account_balance", columnDefinition = "float default 0.00", precision = 12, scale = 2)
    private Double accountBalance;

    @Column(name = "currency", nullable = false)
    private Currency currency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issuer_id", nullable = false, foreignKey = @ForeignKey(name = "FK_account_issuer_id"))
    private Issuer issuer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_holder_id", nullable = false, foreignKey = @ForeignKey(name = "FK_account__card_holder_id"))
    private CardHolder cardHolder;

    public Account() {
    }

    public Account(Long id, String iban, Double accountBalance, Issuer issuer, CardHolder cardHolder) {
        this.id = id;
        this.iban = iban;
        this.accountBalance = accountBalance;
        this.issuer = issuer;
        this.cardHolder = cardHolder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    public CardHolder getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(CardHolder cardHolder) {
        this.cardHolder = cardHolder;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", iban='" + iban + '\'' +
                ", accountBalance=" + accountBalance +
                ", issuer=" + issuer +
                ", cardHolder=" + cardHolder +
                '}';
    }
}
