package com.example.loanmanagement.otp;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OTP {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String phone;
    private String otp;
    private LocalDateTime expiry_date;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
