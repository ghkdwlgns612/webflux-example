package com.example.userservicetraining.service;

import com.example.userservicetraining.dto.TransactionRequestDto;
import com.example.userservicetraining.dto.TransactionResponseDto;
import com.example.userservicetraining.dto.TransactionStatus;
import com.example.userservicetraining.entity.UserTransaction;
import com.example.userservicetraining.repository.UserRepository;
import com.example.userservicetraining.repository.UserTransactionRepository;
import com.example.userservicetraining.util.EntityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final UserTransactionRepository transactionRepository;

    private final UserRepository userRepository;

    public Mono<TransactionResponseDto> createTransaction(TransactionRequestDto requestDto) {
        return userRepository.updateUserBalance(requestDto.getUserId(), requestDto.getAmount())
                .filter(Boolean::booleanValue)
                .map(b -> EntityUtil.toEntity(requestDto))
                .flatMap(this.transactionRepository::save)
                .map(ut -> EntityUtil.toDto(requestDto, TransactionStatus.APPROVED))
                .defaultIfEmpty(EntityUtil.toDto(requestDto, TransactionStatus.DECLINED));
    }

    public Flux<UserTransaction> getByUserId(int userId) {
        return this.transactionRepository.findByUserId(userId);
    }
}
