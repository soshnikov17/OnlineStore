package com.example.OnlineStore.service;

import com.example.OnlineStore.dto.UserDto;
import com.example.OnlineStore.entity.User;
import com.example.OnlineStore.exception.DataValidationException;
import com.example.OnlineStore.mapper.UserMapper;
import com.example.OnlineStore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserDto save(UserDto user) {
        validate(user);
        User entity = userMapper.toEntity(user);
        return userMapper.toDto(userRepository.save(entity));
    }

    private void validate(UserDto user) {
        if (user == null) {
            throw new DataValidationException("User is empty!");
        }
    }

    ;
}
