package com.example.firstbankproject.domain.entity;

import com.example.firstbankproject.domain.enums.*;

import javax.persistence.*;
import java.time.*;
import java.util.*;

@Entity
@Table(name = "card_holder", uniqueConstraints = {
        @UniqueConstraint(name = "UQ_card_holder__passport_number", columnNames = {"passport_number"}),
        @UniqueConstraint(name = "UQ_card_holder__ssn", columnNames = {"ssn"}),
        @UniqueConstraint(name = "UQ_card_holder__email", columnNames = {"email"}),
        @UniqueConstraint(name = "UQ_card_holder__phone_number", columnNames = {"phone_number"})})
public class CardHolder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "passport_number", nullable = false)
    private String passportNumber;

    @Column(name = "ssn", nullable = false)
    private String ssn;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @OneToMany(mappedBy = "cardHolder", cascade = CascadeType.PERSIST)
    private List<Card> cards;

    @OneToMany(mappedBy = "cardHolder", cascade = CascadeType.PERSIST)
    private List<Account> accounts;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false, foreignKey = @ForeignKey(name = "FK_card_holder__address_id"))
    private Address address;

    public CardHolder() {
    }

    public CardHolder(Long id, String firstName, String lastName, LocalDate birthday,
                      String passportNumber, String ssn, String phoneNumber, String email,
                      Gender gender, List<Card> cards, List<Account> accounts, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.passportNumber = passportNumber;
        this.ssn = ssn;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.cards = cards;
        this.accounts = accounts;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CardHolder{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", passportNumber='" + passportNumber + '\'' +
                ", ssn='" + ssn + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", cards=" + cards +
                ", accounts=" + accounts +
                ", address=" + address +
                '}';
    }
}
