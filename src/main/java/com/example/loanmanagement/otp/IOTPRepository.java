package com.example.loanmanagement.otp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface IOTPRepository extends JpaRepository<OTP, UUID> {
    @Query(value = "select o from OTP o where o.phone = :phone")
    OTP findOTPByPhone(String phone);
}
