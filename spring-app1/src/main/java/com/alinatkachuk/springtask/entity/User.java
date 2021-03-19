package com.alinatkachuk.springtask.entity;

import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "data_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "birth_date")
	private Calendar birthDate;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition="enum('male','female')")
	private Gender gender;

	private String email;

	private String password;

	@OneToMany (mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "debit_card_id")
	private List<DebitCard> debitCard;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "loan_id")
	private List<Loan> loan;

	public long getId() { return id; }
	public void setId (long id) {
		this.id=id;
	}

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

	public List<DebitCard> getDebitCard() { return debitCard; }
	public void setDebitCard(List<DebitCard> debitCard) {
		this.debitCard=debitCard;
	}

	public List<Loan> getLoan() {
		return loan;
	}
	public void setLoan(List<Loan> loan) {
		this.loan=loan;
	}

	public String toString() {
		return  "Id: "+id+"\n"+
				"First name: "+firstName+"\n"+
				"Last name: "+lastName+"\n"+
				"Birth date: "+birthDate+"\n"+
				"Gender: "+gender+"\n"+
				"Email: "+email+"\n"+
				"Password: "+password+"\n";
	}

}

