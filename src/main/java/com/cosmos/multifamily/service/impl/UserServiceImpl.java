package com.cosmos.multifamily.service.impl;

import com.cosmos.multifamily.domain.dto.UserSignupRequestDto;
import com.cosmos.multifamily.domain.entity.User;
import com.cosmos.multifamily.exception.UserDefineException;
import com.cosmos.multifamily.repository.UserRepository;
import com.cosmos.multifamily.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2018-12-19.
 */

@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void signupUser(UserSignupRequestDto userSignupRequestDto) {
        try {
            User existingUser = userRepository.findUserByUserId(userSignupRequestDto.getUserId());
            if (existingUser == null) {
                User user = userSignupRequestDto.toEntity();
                userRepository.save(user);
            } else {
                throw new UserDefineException("Error");
            }
        } catch (Exception e) {
            throw new UserDefineException("Error");
        }
    }

    @Override
    public User findUserByUserId(String userId) {
        User user;

        try {
            user = userRepository.findUserByUserId(userId);
        } catch (Exception e) {
            throw new UserDefineException("Error");
        }
        return user;
    }

    @Override
    public void convertToNextDay(String userId, String level) {
        User user = userRepository.findUserByUserId(userId);
        user.setLevel(level);
        userRepository.save(user);
    }
}
