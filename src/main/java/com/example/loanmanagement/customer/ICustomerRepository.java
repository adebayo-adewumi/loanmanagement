package com.example.loanmanagement.customer;

import com.example.loanmanagement.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ICustomerRepository extends JpaRepository<Customer, UUID> {
}
