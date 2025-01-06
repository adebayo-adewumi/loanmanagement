package com.example.loanmanagement.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IContactRepository extends JpaRepository<Contact, UUID> {
}
