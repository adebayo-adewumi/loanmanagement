package com.example.loanmanagement.otp;

import com.example.loanmanagement.shared.GenericResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/otp")
@RequiredArgsConstructor
@Tag(name = "OTP", description = "This API handles generation, sending and validation of OTP(One Time Password)")
public class OTPController {

    private final OTPService service;

    @PostMapping
    public ResponseEntity<GenericResponse> send(
            @RequestBody SendOTPRequest request
    ) {
        return ResponseEntity.ok(service.send(request));
    }

    @PostMapping("/validation")
    public ResponseEntity<GenericResponse> validate(
            @RequestBody ValidateOTPRequest request
    ) {
        return ResponseEntity.ok(service.validate(request));
    }

}
