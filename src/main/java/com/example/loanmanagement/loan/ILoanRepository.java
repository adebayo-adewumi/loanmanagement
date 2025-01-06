package com.example.loanmanagement.loan;

import com.example.loanmanagement.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ILoanRepository extends JpaRepository<Loan, UUID> {
    @Query(value = "select o from Loan o where o.id = :id")
    Loan findByLoanId(UUID id);
}

