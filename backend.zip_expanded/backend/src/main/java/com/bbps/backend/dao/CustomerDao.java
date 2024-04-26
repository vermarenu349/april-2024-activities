package com.bbps.backend.dao;


import com.bbps.backend.beans.*;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CustomerDao extends JpaRepository<Customer, Integer>{
	
	@Query("SELECT c FROM Customer c WHERE c.email_id = :email AND c.password = :password")
	Optional<Customer> validateUser( String email,String password);

	@Query("SELECT c.customer_id FROM Customer c WHERE c.email_id = :email")
	int getCustId(String email);
}
