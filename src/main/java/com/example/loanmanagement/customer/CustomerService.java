package com.example.loanmanagement.customer;

import com.example.loanmanagement.auth.AuthenticationService;
import com.example.loanmanagement.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;
import java.util.HashMap;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final ICustomerRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationService authService;
    private final AuthenticationManager authenticationManager;
    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    public GenericResponse register(RegisterRequest request) {
        try{
            var customerRecord = repository.findByCustomerPhoneAndEmail(request.getPhone(), request.getEmail());

            if(customerRecord != null) {
                return GenericResponse.builder()
                        .code(403)
                        .message("Customer with this phone number and email already exist")
                        .build();
            }

            var customer = Customer.builder()
                    .firstname(request.getFirstname())
                    .lastname(request.getLastname())
                    .phone(request.getPhone())
                    .email(request.getEmail())
                    .gender(request.getGender())
                    .address(request.getAddress())
                    .city(request.getCity())
                    .state(request.getState())
                    .bvn(request.getBvn())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .dob(request.getDob())
                    .education(request.getEducation())
                    .marital_status(request.getMarital_status())
                    .children(request.getChildren())
                    .religion(request.getReligion())
                    .build();

            repository.save(customer);

            return GenericResponse.builder()
                    .code(200)
                    .message("Customer created successfully")
                    .build();
        }
        catch (Exception e){
            String message = e.getMessage();
            String stackTrace = e.getStackTrace().toString();
            String fullErroMessage = "Message: "+ message + " ||| StackTrace: " +stackTrace;

            logger.error(fullErroMessage);

            return GenericResponse.builder()
                    .code(500)
                    .message("Something went wrong. Please try again")
                    .build();
        }
    }

    public GenericResponse login(LoginRequest request) {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getPhone(),
                            request.getPassword()
                    )
            );

            var customer = repository.findByPhone(request.getPhone()).orElseThrow();

            var accessToken = authService.generateToken(customer);
            var refreshToken = authService.generateRefreshToken(customer);

            HashMap<String, Object> tokenHashMap = new HashMap<>();
            tokenHashMap.put("accessToken", accessToken);
            tokenHashMap.put("refreshToken", refreshToken);

            return GenericResponse.builder()
                    .code(200)
                    .message("Login successful")
                    .data(tokenHashMap)
                    .build();
        }
        catch (Exception e){
            String message = e.getMessage();
            String stackTrace = e.getStackTrace().toString();
            String fullErroMessage = "Message: "+ message + " ||| StackTrace: " +stackTrace;

            logger.error(fullErroMessage);

            return GenericResponse.builder()
                    .code(500)
                    .message("Something went wrong. Please try again")
                    .build();
        }
    }

    public GenericResponse delete(UUID id) {

        repository.deleteById(id);

        return GenericResponse.builder()
                .code(200)
                .message("Account deleted successfully")
                .build();
    }
}