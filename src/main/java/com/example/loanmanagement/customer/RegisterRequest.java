package com.example.loanmanagement.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotNull(message = "Firstname cannot be null")
    @Size(min = 3, max = 50, message = "Firstname must be between 3 and 50 characters")
    private String firstname;

    @NotNull(message = "Lastname cannot be null")
    @Size(min = 3, max = 50, message = "Firstname must be between 3 and 50 characters")
    private String lastname;

    @NotNull(message = "Phone Number cannot be null")
    @Size(min = 11, max = 13, message = "Phone Number must be between 11 and 13 characters")
    private String phone;

    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Gender cannot be null")
    @Size(min = 11, max = 13, message = "Gender must be between 3 and 50 characters")
    private String gender;

    private String picture;

    @NotNull(message = "address cannot be null")
    @Size(min = 3, max = 50, message = "address must be between 3 and 50 characters")
    private String address;

    @NotNull(message = "City cannot be null")
    @Size(min = 3, max = 50, message = "City must be between 3 and 50 characters")
    private String city;

    @NotNull(message = "State cannot be null")
    @Size(min = 3, max = 50, message = "State must be between 3 and 50 characters")
    private String state;

    @NotNull(message = "BVN cannot be null")
    @Size(min = 11, max = 13, message = "BVN must be between 11 and 13 characters")
    private String bvn;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 50, message = "Password must be between 8 and 50 characters")
    private String password;

    @NotNull(message = "Date of Birth cannot be null")
    @Size(min = 3, max = 50, message = "Date of Birth must be between 3 and 50 characters")
    private String dob;

    @NotNull(message = "Education cannot be null")
    @Size(min = 3, max = 50, message = "Education must be between 3 and 50 characters")
    private String education;

    @NotNull(message = "Marital Status cannot be null")
    @Size(min = 3, max = 50, message = "Marital Status must be between 3 and 50 characters")
    private String marital_status;

    @NotNull(message = "Children cannot be null")
    @Size(min = 3, max = 50, message = "Children must be between 3 and 50 characters")
    private String children;

    @NotNull(message = "Religion cannot be null")
    @Size(min = 3, max = 50, message = "Religion must be between 3 and 50 characters")
    private String religion;
}
