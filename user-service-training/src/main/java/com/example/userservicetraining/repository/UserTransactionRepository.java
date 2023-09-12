package com.example.userservicetraining.repository;

import com.example.userservicetraining.entity.UserTransaction;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserTransactionRepository extends R2dbcRepository<UserTransaction, Integer> {

    Flux<UserTransaction> findByUserId(int userId);
}
