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
@Table(name = "loan")
public class Loan {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int loan_id;
 private String loan_type;
 
 @OneToOne(mappedBy = "loan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
 private LoanApplication loanapp;
 
public int getLoan_id() {
	return loan_id;
}
public void setLoan_id(int loan_id) {
	this.loan_id = loan_id;
}
public String getLoan_type() {
	return loan_type;
}
public void setLoan_type(String loan_type) {
	this.loan_type = loan_type;
}
@Override
public String toString() {
	return "Loan [loan_id=" + loan_id + ", loan_type=" + loan_type + "]";
}
 

 
}
