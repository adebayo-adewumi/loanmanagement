package com.example.loanmanagement.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private String gender;
    private String picture;
    private String address;
    private String city;
    private String state;
    private String bvn;
    private String password;
    private String dob;
    private String education;
    private String marital_status;
    private String children;
    private String religion;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
