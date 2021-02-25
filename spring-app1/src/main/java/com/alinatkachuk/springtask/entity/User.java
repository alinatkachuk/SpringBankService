package com.alinatkachuk.springtask.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class User<DebitCart, Loan> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private Calendar birthDate;
	private Gender gender;
	private String email;
	private String password;
	private ArrayList<BankService> bankService;
	private ArrayList<DebitCart> debitCart;
	private ArrayList<Loan> loan;

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName (String firstName) {
		this.firstName=firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName (String lastName) {
		this.lastName=lastName;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Calendar birthDate) {
		this.birthDate=birthDate;
	}

	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender=gender;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}

	public ArrayList<DebitCart> getDebitCart() {
		return debitCart;
	}
	public void setDebitCart(ArrayList<DebitCart> debitCart) {
		this.debitCart=debitCart;
	}

	public ArrayList<Loan> getLoan() {
		return loan;
	}
	public void setLoan(ArrayList<Loan> loan) {
		this.loan=loan;
	}

	public String toString() {
		return "First name: "+firstName+"\n"+
				"Last name: "+lastName+"\n"+
				"Birth date: "+birthDate+"\n"+
				"Gender: "+gender+"\n"+
				"Email: "+email+"\n"+
				"Password: "+password+"\n";
	}
}

