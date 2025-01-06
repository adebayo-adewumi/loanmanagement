package com.example.loanmanagement.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerRequest {
    private UUID customer_id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String city;
    private String state;
}
