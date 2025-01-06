package com.example.loanmanagement.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IAdminRepository extends JpaRepository<Admin, UUID> {}
