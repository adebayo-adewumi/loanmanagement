package com.example.loanmanagement.auditlog;

import jakarta.persistence.*;
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
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String action;
    private String entity;
    private UUID entityId;
    private UUID performed_by;
    private String old_value;
    private String new_value;
    private LocalDateTime created_at;

    // Getters and setters

    @PrePersist
    public void prePersist() {
        this.created_at = LocalDateTime.now();
    }
}
