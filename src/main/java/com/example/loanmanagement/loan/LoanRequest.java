package com.example.loanmanagement.loan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {

    private UUID customer_id;
    private double amount;
    private LocalDateTime repayment_date;
    private double repayment_amount;
    private Integer tenure;
}
