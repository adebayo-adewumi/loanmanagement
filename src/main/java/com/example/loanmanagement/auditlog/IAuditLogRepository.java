package com.example.loanmanagement.auditlog;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IAuditLogRepository extends JpaRepository<AuditLog, UUID> {}
