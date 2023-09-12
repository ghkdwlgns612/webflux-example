package com.example.userservicetraining.service;

import com.example.userservicetraining.dto.UserDto;
import com.example.userservicetraining.repository.UserRepository;
import com.example.userservicetraining.util.EntityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Flux<UserDto> getAllUsers() {
        return this.userRepository.findAll()
                .map(EntityUtil::toDto);
    }

    public Mono<UserDto> getById(Integer id) {
        return this.userRepository.findById(id)
                .map(EntityUtil::toDto);
    }

    public Mono<UserDto> createUser(Mono<UserDto> userDtoMono) {
        return userDtoMono
                .map(EntityUtil::toEntity)
                .flatMap(this.userRepository::save)
                .map(EntityUtil::toDto);
    }

    public Mono<UserDto> updateUser(Integer id, Mono<UserDto> userDtoMono) {
        return this.userRepository.findById(id)
                .flatMap(u -> userDtoMono
                        .doOnNext(ut -> ut.setId(u.getId()))
                        .map(EntityUtil::toEntity)
                        .flatMap(this.userRepository::save)
                )
                .map(EntityUtil::toDto);
    }

    public Mono<UserDto> deleteUser(Integer id) {
        return this.userRepository.findById(id)
                .doOnNext(u -> this.userRepository.deleteById(id))
                .map(EntityUtil::toDto);
    }
}
