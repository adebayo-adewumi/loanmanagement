package com.example.loanmanagement.customer;

import com.example.loanmanagement.customer.Customer;
import com.example.loanmanagement.otp.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface ICustomerRepository extends JpaRepository<Customer, UUID> {
    @Query(value = "select o from Customer o where o.id = :id")
    Customer findByCustomerId(UUID id);

    Optional<Customer> findByPhone(String phone);

    @Query(value = "select o from Customer o where o.phone = :phone and o.email = :email")
    Customer findByCustomerPhoneAndEmail(String phone, String email);
}
