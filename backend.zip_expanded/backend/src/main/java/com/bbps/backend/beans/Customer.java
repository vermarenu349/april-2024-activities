package com.bbps.backend.beans;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "customer")
public class Customer {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int customer_id;
 private String firstname;
 private String lastname;
 private String email_id;
 private String password;
 private String pan;
 private String phone;

 @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
 private LoanApplication la;

 

public int getCustomer_id() {
	return customer_id;
}



public void setCustomer_id(int employee_id) {
	this.customer_id = employee_id;
}



public String getFirstname() {
	return firstname;
}



public void setFirstname(String firstname) {
	this.firstname = firstname;
}



public String getLastname() {
	return lastname;
}



public void setLastname(String lastname) {
	this.lastname = lastname;
}



public String getEmail_id() {
	return email_id;
}



public void setEmail_id(String email_id) {
	this.email_id = email_id;
}



public String getPassword() {
	return password;
}



public void setPassword(String password) {
	this.password = password;
}



public String getPan() {
	return pan;
}



public void setPan(String pan) {
	this.pan = pan;
}



public String getPhone() {
	return phone;
}



public void setPhone(String phone) {
	this.phone = phone;
}



@Override
public String toString() {
	return "Customer [employee_id=" + customer_id + ", firstname=" + firstname + ", lastname=" + lastname
			+ ", email_id=" + email_id + ", password=" + password + ", pan=" + pan + ", phone=" + phone + "]";
}


 
 
}

