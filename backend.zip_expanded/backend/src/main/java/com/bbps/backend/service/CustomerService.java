package com.bbps.backend.service;

import java.util.List;

import com.bbps.backend.beans.Customer;
import com.bbps.backend.beans.Loan;
import com.bbps.backend.beans.LoanApplication;

public interface CustomerService {

	Customer registerCustomer(Customer customer);

	String login(String email, String password);

	List<Loan> getAllLoans();

	List<LoanApplication> getLoanStatus(int id);

	int getCustId(String email);

	LoanApplication insertLoans(LoanApplication loanApp);

}
