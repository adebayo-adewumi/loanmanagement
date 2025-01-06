package com.example.loanmanagement.customer;

import com.example.loanmanagement.ratelimit.RateLimitService;
import com.example.loanmanagement.shared.GenericResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
@Tag(name = "Customer", description = "This API handles all activities of a customer in the application")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;
    private final RateLimitService rateLimitService;

    @PostMapping
    public ResponseEntity<GenericResponse> register(@RequestBody RegisterRequest request) {
        var response = service.register(request);

        if(response.getCode() != 200) {
            return ResponseEntity.status(response.getCode()).body(response);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<GenericResponse> login(@RequestBody LoginRequest request) {
        var response = service.login(request);

        if(response.getCode() != 200) {
            return ResponseEntity.status(response.getCode()).body(response);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/contact")
    public ResponseEntity<GenericResponse> addContact(@RequestBody ContactRequest request) {
        var response = service.addContacts(request);

        if(response.getCode() != 200) {
            return ResponseEntity.status(response.getCode()).body(response);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/employer")
    public ResponseEntity<GenericResponse> addEmployer(@RequestBody EmployerRequest request) {
        var response = service.addEmployer(request);

        if(response.getCode() != 200) {
            return ResponseEntity.status(response.getCode()).body(response);
        }

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse> delete(@PathVariable UUID id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
