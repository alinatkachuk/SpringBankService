package com.alinatkachuk.springtask.entity;

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

    @Column(name = "expiration_date")
    private Calendar expirationDate;

    private String ccv;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition="enum('visa','mastercard', 'belcard')")
    private PaymentSystem paymentSystem;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "user_id")
    private User user;

    public long getId() { return id; }
    public void setId (Long id) {
        this.id=id;
    }

    public double getAccountBalance() { return accountBalance; }
    public void setAccountBalance (double accountBalance) { this.accountBalance=accountBalance; }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber=cardNumber; }

    public Calendar getExpirationDate() { return expirationDate; }
    public void setExpirationDate(Calendar expirationDate) { this.expirationDate=expirationDate; }

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
        return  "Id: "+id+"\n"+
                "Account balance: "+accountBalance+"\n"+
                "Card number: "+cardNumber+"\n"+
                "Expiration date: "+expirationDate+"\n"+
                "CCV: "+ccv+"\n"+
                "Payment system: "+paymentSystem+"\n";
    }
}

