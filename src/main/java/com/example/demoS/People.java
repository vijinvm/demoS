package com.example.demoS;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class People {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String firstname;
private String lastname;
private LocalDate birthdate;
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="bank_id")
private Bank bank;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public LocalDate getBirthdate() {
	return birthdate;
}
public void setBirthdate(LocalDate birthdate) {
	this.birthdate = birthdate;
}
public Bank getBank() {
	return bank;
}
public void setBank(Bank bank) {
	this.bank = bank;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
}
