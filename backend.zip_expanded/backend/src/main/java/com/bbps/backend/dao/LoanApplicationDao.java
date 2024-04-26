package com.bbps.backend.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bbps.backend.beans.LoanApplication;

public interface LoanApplicationDao  extends JpaRepository<LoanApplication, Integer> {

	@Query(value="select p from loan_application p where p.customer_id = :phone", nativeQuery=true)
	public List<LoanApplication> findByCustId(int phone);
}
