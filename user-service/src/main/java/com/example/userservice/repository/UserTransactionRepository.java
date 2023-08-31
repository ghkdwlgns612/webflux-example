package com.example.userservice.repository;

import com.example.userservice.entity.UserTransaction;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserTransactionRepository extends R2dbcRepository<UserTransaction, Integer> {

    @Query("select * from user_transaction " +
            "where user_id = :userId")
    Flux<UserTransaction> findByUserId(int userId);
}
