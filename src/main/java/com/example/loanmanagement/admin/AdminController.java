package com.example.loanmanagement.admin;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@Tag(name = "Admin", description = "This API handles admin authentication and authorization on the app ")
public class AdminController {

    @PostMapping
    public ResponseEntity<?> create(@RequestBody String request) {
        return ResponseEntity.ok().build();
    }
}
