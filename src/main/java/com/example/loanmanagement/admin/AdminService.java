package com.example.loanmanagement.admin;

import com.example.loanmanagement.customer.Customer;
import com.example.loanmanagement.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final IAdminRepository repository;
    private final PasswordEncoder passwordEncoder;
}