package com.bbps.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbps.backend.beans.Loan;

public interface LoanDao extends JpaRepository<Loan, Integer> {

}
