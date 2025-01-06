package com.example.loanmanagement.auth;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAuthTokenRepository extends JpaRepository<AuthToken, UUID> {

    @Query(value = "select at from AuthToken at inner join Customer c on at.user_id = c.id where c.id = :id and (at.expired = 0 or at.revoked = 0)")
    List<AuthToken> findAllValidTokenByUser(UUID id);

    Optional<AuthToken> findByToken(String token);
}