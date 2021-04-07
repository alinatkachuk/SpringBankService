package com.alinatkachuk.springtask.entity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "data_loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_date")
    private Calendar registrationDate;

    private double sum;

    @Column(name = "interest_rate")
    private double interestRate;

    @Column(name = "loan_term")
    private int loanTerm;

    @Column(name = "monthly_payment")
    private double monthlyPayment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "user_id")
    private User user;

    public Long getId() { return id; }
    public void setId (Long id) {
        this.id=id;
    }

    public Calendar getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(Calendar registrationDate) {
        this.registrationDate=registrationDate;
    }

    public double getSum() {
        return sum;
    }
    public void setSum (double sum) { this.sum=sum; }

    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate (double interestRate) {
        this.interestRate=interestRate;
    }

    public int getLoanTerm() {
        return loanTerm;
    }
    public void setLoanTerm (int loanTerm) {
        this.loanTerm=loanTerm;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }
    public void setMonthlyPayment (double monthlyPayment) {
        this.monthlyPayment=monthlyPayment;
    }

    public User getUser() {
        return user;
    }
    public void setUser (User user) {
        this.user=user;
    }

    public Loan () { }
    public Loan (Long id, Calendar registrationDate, double sum, double interestRate, int loanTerm,
                 double monthlyPayment, User user) {
        this.id=id;
        this.registrationDate=registrationDate;
        this.sum=sum;
        this.interestRate=interestRate;
        this.loanTerm=loanTerm;
        this.monthlyPayment=monthlyPayment;
        this.user=user;
    }

    public String toString() {
        return "Registration date: "+registrationDate+"\n"+
                "Credit amount: "+sum+"\n"+
                "Interest rate: "+interestRate+"\n"+
                "Loan term: "+loanTerm+"\n"+
                "Monthly payment: "+monthlyPayment+"\n";
    }
}

