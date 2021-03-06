package com.alinatkachuk.springtask.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "data_debit_card")
public class DebitCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_balance")
    private double accountBalance;

    @Column(name = "card_number")
    private String cardNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "expiration_date")
    private Calendar expirationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "validity", columnDefinition="enum('one','three', 'five')")
    private DebitCardValidity validity;

    @Column(name = "ccv")
    private String ccv;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_system", columnDefinition="enum('visa','mastercard', 'belcard')")
    private PaymentSystem paymentSystem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "user_id")
    private User user;

    public Long getId() { return id; }
    public void setId (Long id) {
        this.id=id;
    }

    public double getAccountBalance() { return accountBalance; }
    public void setAccountBalance (double accountBalance) { this.accountBalance=accountBalance; }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber=cardNumber; }

    public Calendar getExpirationDate() { return expirationDate; }
    public void setExpirationDate(Calendar expirationDate) { this.expirationDate=expirationDate; }

    public DebitCardValidity getValidity() { return validity; }
    public void setValidity(DebitCardValidity validity) { this.validity=validity; }

    public String getCcv() { return ccv; }
    public void setCcv (String ccv) { this.ccv=ccv; }

    public PaymentSystem getPaymentSystem() { return paymentSystem; }
    public void setPaymentSystem (PaymentSystem paymentSystem) { this.paymentSystem=paymentSystem; }

    public User getUser() {
        return user;
    }
    public void setUser (User user) {
        this.user=user;
    }

    public String toString() {
        return  "Account balance: "+accountBalance+"\n"+
                "Card number: "+cardNumber+"\n"+
                "Expiration date: "+expirationDate+"\n"+
                "Validity: "+validity+"\n"+
                "CCV: "+ccv+"\n"+
                "Payment system: "+paymentSystem+"\n";
    }
}

