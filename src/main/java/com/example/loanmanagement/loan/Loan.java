package com.example.loanmanagement.loan;

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
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private UUID customer_id;
    private Double amount;
    private String status;
    private Double repayment_amount;
    private LocalDateTime repayment_date;
    private Integer tenure;
    private UUID processed_by;
    private String rejection_reason;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
