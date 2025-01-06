package com.example.loanmanagement.otp;

import com.example.loanmanagement.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OTPService {

    private final IOTPRepository repository;
    private final PasswordEncoder passwordEncoder;

    public GenericResponse send(SendOTPRequest request) {
        if(request.getPhone() == null || request.getPhone().isEmpty()){
            return GenericResponse.builder()
                    .code(403)
                    .message("Phone number is required  ")
                    .build();
        }
        //send sms here

        var otp = OTP.builder()
                .phone(request.getPhone())
                .expiry_date(LocalDateTime.now().plusMinutes(5))
                .otp(passwordEncoder.encode("123456"))
                .build();

        repository.save(otp);

        return GenericResponse.builder()
                .code(200)
                .message("OTP sent successfully")
                .build();
    }

    public GenericResponse validate(ValidateOTPRequest request  ) {

        var otpRecord = repository.findOTPByPhone(request.getPhone());

        if(otpRecord == null){
            return GenericResponse.builder()
                    .code(403)
                    .message("OTP is invalid")
                    .build();
        }

        if(!passwordEncoder.matches(request.getOtp(), otpRecord.getOtp())){
            return GenericResponse.builder()
                    .code(403)
                    .message("OTP is invalid")
                    .build();
        }

        var currentDateTime = LocalDateTime.now();

        if(otpRecord.getExpiry_date().isBefore(currentDateTime)){
            return GenericResponse.builder()
                    .code(403)
                    .message("OTP has expired")
                    .build();
        }

        repository.delete(otpRecord);

        return GenericResponse.builder()
                .code(200)
                .message("OTP validation successful")
                .build();
    }
}