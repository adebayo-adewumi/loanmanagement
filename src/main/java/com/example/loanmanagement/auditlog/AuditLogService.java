package com.example.loanmanagement.auditlog;

import com.example.loanmanagement.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuditLogService {

    private final IAuditLogRepository repository;

    public void log(String action, String entity, UUID entityId, UUID performedBy, String oldValue, String newValue) {

        var auditLog = AuditLog.builder()
                .action(action)
                .entity(entity)
                .entityId(entityId)
                .performed_by(performedBy)
                .old_value(oldValue)
                .new_value(newValue)
                .build();

        repository.save(auditLog);
    }
}