package com.example.userservice.repository;

import com.example.userservice.entity.User;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends R2dbcRepository<User, Integer> {

    @Modifying
    @Query("update users " +
            "set balance = balance - :amount " +
            "where id = :userId " +
            "and balance >= :amount")
    Mono<Boolean> updateUserBalance(int userId, int amount);
}
