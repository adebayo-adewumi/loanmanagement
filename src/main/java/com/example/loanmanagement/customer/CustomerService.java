package com.example.loanmanagement.customer;

import com.example.loanmanagement.customer.Customer;
import com.example.loanmanagement.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final ICustomerRepository repository;
    private final PasswordEncoder passwordEncoder;

    public GenericResponse register(RegisterRequest request) {

        var customer = Customer.builder()
                        .firstname(request.getFirstname())
                        .lastname(request.getLastname())
                        .phone(request.getPhone())
                        .email(request.getEmail())
                        .gender(request.getGender())
                        .address(request.getAddress())
                        .city(request.getCity())
                        .state(request.getState())
                        .bvn(passwordEncoder.encode(request.getBvn()))
                        .password(passwordEncoder.encode(request.getPassword()))
                        .dob(request.getDob())
                        .education(request.getEducation())
                        .marital_status(request.getMarital_status())
                        .children(request.getChildren())
                        .religion(request.getReligion())
                        .build();

        repository.save(customer);

        return GenericResponse.builder()
                .code(200)
                .message("Customer created successfully")
                .build();
    }
}
