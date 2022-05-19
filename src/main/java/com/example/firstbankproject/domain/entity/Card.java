package com.example.firstbankproject.domain.entity;

import com.example.firstbankproject.domain.enums.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Table;
import java.time.*;

@Entity
@Table(name = "card",
        uniqueConstraints = @UniqueConstraint(name = "UQ_card__card_number", columnNames = {"card_number"}))
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_type", nullable = false)
    private CardType cardType;

    @Column(name = "credit_balance", columnDefinition = "float default 0.00", precision = 12, scale = 2)
    private Double creditBalance;

    @Column(name = "card_number", nullable = false, length = 16)
    private String cardNumber;

    @Column(name = "expiration_date", nullable = false)
    private LocalDate expirationDate;

    @Column(name = "cvc", nullable = false)
    private String cvc;

    @Column(name = "pin", nullable = false)
    private String pin;

    @Column(name = "card_status", nullable = false)
    private CardStatus cardStatus;

    @Column(name = "card_processing_network", nullable = false)
    private CardProcessingNetwork cardProcessingNetwork;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_holder_id", nullable = false, foreignKey = @ForeignKey(name = "FK_card__card_holder_id"))
    private CardHolder cardHolder;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false, foreignKey = @ForeignKey(name = "FK_card_account_id"))
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issuer_id", nullable = false, foreignKey = @ForeignKey(name = "FK_card_issuer_id"))
    private Issuer issuer;

    public Card() {
    }

    public Card(Long id, CardType cardType, Double creditBalance, String cardNumber,
                LocalDate expirationDate, String cvc, String pin, CardStatus cardStatus,
                CardHolder cardHolder, Account account, Issuer issuer) {
        this.id = id;
        this.cardType = cardType;
        this.creditBalance = creditBalance;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvc = cvc;
        this.pin = pin;
        this.cardStatus = cardStatus;
        this.cardHolder = cardHolder;
        this.account = account;
        this.issuer = issuer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Double getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(Double creditBalance) {
        this.creditBalance = creditBalance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public CardHolder getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(CardHolder cardHolder) {
        this.cardHolder = cardHolder;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardType=" + cardType +
                ", creditBalance=" + creditBalance +
                ", cardNumber='" + cardNumber + '\'' +
                ", expirationDate=" + expirationDate +
                ", cvc='" + cvc + '\'' +
                ", pin='" + pin + '\'' +
                ", cardStatus=" + cardStatus +
                ", cardHolder=" + cardHolder +
                ", account=" + account +
                ", issuer=" + issuer +
                '}';
    }
}
