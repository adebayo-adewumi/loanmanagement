package com.example.loanmanagement.loan;

import com.example.loanmanagement.customer.ICustomerRepository;
import com.example.loanmanagement.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final ILoanRepository repository;
    private final ICustomerRepository customerRepository;

    public GenericResponse checkEligibility(UUID customer_id) {

        var customerRecord = customerRepository.findByCustomerId(customer_id);

        if(customerRecord == null) {
            return GenericResponse.builder()
                    .code(403)
                    .message("Customer does not exist")
                    .build();
        }

        //check credit score
        var creditScore = 800;

        if(customerRecord.getBvn() == null && creditScore < 800){
            return GenericResponse.builder()
                    .code(403)
                    .message("We cannot offer you loan at the moment. Improve your credit score.")
                    .build();
        }

        //calculate interest rate
        var loanAmount = 10000;
        var tenure = 14;
        var interestRate = 0.1;
        var interest = (10000 * interestRate) * tenure/365;
        var repaymentAmount = loanAmount + interest;
        var repaymentDate = LocalDateTime.now().plusDays(13);

        //round to 3 decimal places
        BigDecimal bd = new BigDecimal(repaymentAmount);
        bd = bd.setScale(2, RoundingMode.HALF_UP); // Round to 2 decimal places
        double roundedValue = bd.doubleValue();

        HashMap<String, Object> loanOffer = new HashMap<>();
        loanOffer.put("loanAmount", loanAmount);
        loanOffer.put("tenure", tenure);
        loanOffer.put("repaymentAmount", roundedValue);
        loanOffer.put("repaymentDate", repaymentDate);


        return GenericResponse.builder()
                .code(200)
                .message("Loan offer successful")
                .data(loanOffer)
                .build();
    }

    public GenericResponse apply(LoanRequest request) {
        var loan = Loan.builder()
                .customer_id(request.getCustomer_id())
                .amount(request.getAmount())
                .tenure(request.getTenure())
                .repayment_amount(request.getRepayment_amount())
                .repayment_date(request.getRepayment_date())
                .build();

        loan.setStatus(LoanStatus.PENDING.toString());

        repository.save(loan);

        return GenericResponse.builder()
                .code(200)
                .message("Loan application successful")
                .build();
    }

    public GenericResponse approve(LoanApprovalRequest request) {
        var loanRecord = repository.findByLoanId(request.getId());

        if(loanRecord == null) {
            return GenericResponse.builder()
                    .code(403)
                    .message("Loan does not exist")
                    .build();
        }

        loanRecord.setStatus(LoanStatus.APPROVED.toString());
        loanRecord.setProcessed_by(request.getAdmin_id());
        loanRecord.setUpdated_at(LocalDateTime.now());

        repository.save(loanRecord);

        return GenericResponse.builder()
                .code(200)
                .message("Loan approved successful")
                .build();
    }

    public GenericResponse reject(LoanRejectionRequest request) {
        var loanRecord = repository.findByLoanId(request.getId());

        if(loanRecord == null) {
            return GenericResponse.builder()
                    .code(403)
                    .message("Loan does not exist")
                    .build();
        }

        loanRecord.setStatus(LoanStatus.REJECTED.toString());
        loanRecord.setRejection_reason(request.getReason());
        loanRecord.setProcessed_by(request.getAdmin_id());
        loanRecord.setUpdated_at(LocalDateTime.now());

        repository.save(loanRecord);

        return GenericResponse.builder()
                .code(200)
                .message("Loan rejected successful")
                .build();
    }

    public GenericResponse repay(LoanApprovalRequest request) {
        var loanRecord = repository.findByLoanId(request.getId());

        if(loanRecord == null) {
            return GenericResponse.builder()
                    .code(403)
                    .message("Loan does not exist")
                    .build();
        }

        loanRecord.setStatus(LoanStatus.REPAID.toString());
        loanRecord.setProcessed_by(request.getAdmin_id());
        loanRecord.setUpdated_at(LocalDateTime.now());

        repository.save(loanRecord);

        return GenericResponse.builder()
                .code(200)
                .message("Loan repayment successful")
                .build();
    }

    public GenericResponse history(UUID customer_id) {
        var loanRecord = repository.findById(customer_id);

        return GenericResponse.builder()
                .code(200)
                .message("Loan records successful")
                .data(loanRecord)
                .build();
    }
}
