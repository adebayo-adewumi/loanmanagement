package com.example.loanmanagement.customer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CustomerRepositoryTest {

    @Autowired
    private ICustomerRepository repository;

    @Test
    public void findByCustomerId() {
        Customer customer = Customer.builder()
                .firstname("Adebola")
                .lastname("Segun")
                .phone("Segun")
                .email("b@b.com")
                .build();

        repository.save(customer);

        var response = repository.findByCustomerId(customer.getId());

        Assertions.assertThat(response).isNotNull();
    }

    @Test
    public void findByCustomerPhoneAndEmail() {
        Customer customer = Customer.builder()
                .firstname("bello")
                .lastname("yaya")
                .phone("08160302602")
                .email("a@a.com")
                .build();

        repository.save(customer);

        var response = repository.findByCustomerPhoneAndEmail(customer.getPhone(), customer.getEmail());

        Assertions.assertThat(response).isNotNull();
    }

}
