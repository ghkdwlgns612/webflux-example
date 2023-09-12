package com.example.userservicetraining.util;

import com.example.userservicetraining.dto.TransactionRequestDto;
import com.example.userservicetraining.dto.TransactionResponseDto;
import com.example.userservicetraining.dto.TransactionStatus;
import com.example.userservicetraining.dto.UserDto;
import com.example.userservicetraining.entity.User;
import com.example.userservicetraining.entity.UserTransaction;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EntityUtil {
    public static UserDto toDto(User user) {
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

    public static User toEntity(UserDto dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return user;
    }

    public static UserTransaction toEntity(TransactionRequestDto requestDto) {
        UserTransaction transaction = new UserTransaction();
        transaction.setUserId(requestDto.getUserId());
        transaction.setAmount(requestDto.getAmount());
        transaction.setTransactionDate(LocalDateTime.now());
        return transaction;
    }

    public static TransactionResponseDto toDto(TransactionRequestDto dto, TransactionStatus status) {
        TransactionResponseDto responseDto = new TransactionResponseDto();
        responseDto.setAmount(dto.getAmount());
        responseDto.setUserId(dto.getUserId());
        responseDto.setStatus(status);
        return responseDto;
    }
}
