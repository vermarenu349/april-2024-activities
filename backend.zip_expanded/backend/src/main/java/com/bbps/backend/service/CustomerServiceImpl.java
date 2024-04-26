package com.bbps.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbps.backend.beans.Customer;
import com.bbps.backend.beans.Loan;
import com.bbps.backend.beans.LoanApplication;
import com.bbps.backend.dao.CustomerDao;
import com.bbps.backend.dao.LoanApplicationDao;
import com.bbps.backend.dao.LoanDao;
import com.bbps.backend.exception.CustomerNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	LoanDao loanDao;
	
	@Autowired
	LoanApplicationDao loanApplicationDao;
	
	@Override
	public Customer registerCustomer(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public String login(String email, String password) {
		
		try {
			customerDao.validateUser(email,password);
			
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			CustomerNotFoundException ex = 	new CustomerNotFoundException("Invalid User name and Password");
		return ex.toString();
		}
		return "Success";
	}

	@Override
	public List<Loan> getAllLoans() {
		return loanDao.findAll();
	}

	@Override
	public List<LoanApplication> getLoanStatus(int id) {
		return loanApplicationDao.findByCustId(id);
		
	}

	@Override
	public int getCustId(String email) {
		
		return customerDao.getCustId(email);
	}

	@Override
	public LoanApplication insertLoans(LoanApplication loanApp) {
		// TODO Auto-generated method stub
		return loanApplicationDao.save(loanApp);
	}

}
