package com.bbps.backend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bbps.backend.beans.Customer;
import com.bbps.backend.beans.Loan;
import com.bbps.backend.beans.LoanApplication;
import com.bbps.backend.service.CustomerService;
import com.bbps.backend.service.OfficerService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/loanapp")
public class LoanController {
	
	@Autowired
	CustomerService customerService;

	@Autowired
	OfficerService officerService;
	
	@PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) {
        try {
            Customer registeredCustomer = customerService.registerCustomer(customer);
            return ResponseEntity.ok(registeredCustomer);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
	
	@PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
       
            String s = customerService.login(email, password);
           return s;
    }
	
	@PostMapping("/loginOff")
    public ResponseEntity<?> loginOff(@RequestParam String email, @RequestParam String password) {
        try {
            Customer customer = officerService.login(email, password);
            if (customer != null) {
                return ResponseEntity.ok(customer);
            } else {
                return ResponseEntity.badRequest().body("Invalid email or password");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
	
	@GetMapping("/loans")
    public ResponseEntity<?> viewLoans() {
        List<Loan> loanTypes = customerService.getAllLoans();
        		
        	//	Arrays.asList("Housing Loan", "Educational Loan", "Gold Loan", "Personal Loan", "Car Loan", "Business Loan");
        return ResponseEntity.ok(loanTypes);
    }
	
	@GetMapping("/loansStatus/{id}")
    public ResponseEntity<?> loansApplied(@PathVariable("id") int id) {
        List<LoanApplication> loanTypes = customerService.getLoanStatus( id);
        		
        	//	Arrays.asList("Housing Loan", "Educational Loan", "Gold Loan", "Personal Loan", "Car Loan", "Business Loan");
        return ResponseEntity.ok(loanTypes);
    }
	
	@PostMapping("/custId")
    public int findID(@RequestParam("email") String email) {
        int emailId = customerService.getCustId(email);
        		
        	//	Arrays.asList("Housing Loan", "Educational Loan", "Gold Loan", "Personal Loan", "Car Loan", "Business Loan");
        return emailId;
    }
	
	@PostMapping("/loanEntry")
    public ResponseEntity<?> registerCustomer(@RequestBody LoanApplication loanApp) {
        try {
        	LoanApplication loanAppList = customerService.insertLoans(loanApp);
            return ResponseEntity.ok(loanAppList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
	
}
