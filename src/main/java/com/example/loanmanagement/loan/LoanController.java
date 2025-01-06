package com.example.loanmanagement.loan;

import com.example.loanmanagement.ratelimit.RateLimitService;
import com.example.loanmanagement.ratelimit.RateLimited;
import com.example.loanmanagement.shared.GenericResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/loan")
@Tag(name = "Loan", description = "This API handles customer loan application")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService service;

    @RateLimited
    @GetMapping("/eligibility/{customer_id}")
    public ResponseEntity<GenericResponse> checkEligibility(@PathVariable UUID customer_id) {

        var response = service.checkEligibility(customer_id);

        if(response.getCode() != 200) {
            return ResponseEntity.status(response.getCode()).body(response);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<GenericResponse> apply(@RequestBody LoanRequest request) {

        var response = service.apply(request);

        if(response.getCode() != 200) {
            return ResponseEntity.status(response.getCode()).body(response);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/approval")
    public ResponseEntity<GenericResponse> approve(@RequestBody LoanApprovalRequest request) {

        var response = service.approve(request);

        if(response.getCode() != 200) {
            return ResponseEntity.status(response.getCode()).body(response);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/rejection")
    public ResponseEntity<GenericResponse> reject(@RequestBody LoanRejectionRequest request) {

        var response = service.reject(request);

        if(response.getCode() != 200) {
            return ResponseEntity.status(response.getCode()).body(response);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/repayment")
    public ResponseEntity<GenericResponse> repay(@RequestBody LoanApprovalRequest request) {

        var response = service.repay(request);

        if(response.getCode() != 200) {
            return ResponseEntity.status(response.getCode()).body(response);
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/history/{customer_id}")
    public ResponseEntity<GenericResponse> history(@PathVariable UUID customer_id) {

        var response = service.history(customer_id);

        if(response.getCode() != 200) {
            return ResponseEntity.status(response.getCode()).body(response);
        }

        return ResponseEntity.ok(response);
    }
}
