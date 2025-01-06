package com.example.loanmanagement.otp;

import com.example.loanmanagement.ratelimit.RateLimitService;
import com.example.loanmanagement.shared.GenericResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/otp")
@RequiredArgsConstructor
@Tag(name = "OTP", description = "This API handles generation, sending and validation of OTP(One Time Password)")
public class OTPController {

    private final OTPService service;
    private final RateLimitService rateLimitService;

    @PostMapping
    public ResponseEntity<GenericResponse> send(
            @RequestBody SendOTPRequest request
    ) {
        rateLimitService.executeWithRateLimit();

        var response = service.send(request);

        if(response.getCode() != 200) {
            return ResponseEntity.status(response.getCode()).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/validation")
    public ResponseEntity<GenericResponse> validate(
            @RequestBody ValidateOTPRequest request
    ) {
        rateLimitService.executeWithRateLimit();

        return ResponseEntity.ok(service.validate(request));
    }

}
