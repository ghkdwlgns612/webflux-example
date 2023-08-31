package com.example.userservice.util;

import com.example.userservice.dto.TransactionRequestDto;
import com.example.userservice.dto.TransactionResponseDto;
import com.example.userservice.dto.TransactionStatus;
import com.example.userservice.dto.UserDto;
import com.example.userservice.entity.User;
import com.example.userservice.entity.UserTransaction;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

public class EntityDtoUtil {

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
