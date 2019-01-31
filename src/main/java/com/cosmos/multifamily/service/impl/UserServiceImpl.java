package com.cosmos.multifamily.service.impl;

import com.cosmos.multifamily.domain.dto.UserSignupRequestDto;
import com.cosmos.multifamily.domain.entity.User;
import com.cosmos.multifamily.exception.UserDefineException;
import com.cosmos.multifamily.repository.UserRepository;
import com.cosmos.multifamily.service.UserService;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * UserServiceImpl
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
            User existingUser = userRepository.findUserByUserid(userSignupRequestDto.getUserid());
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
    public User findUserByUserid(String userid) {
        User user = null;
        try {
            user = userRepository.findUserByUserid(userid);
        } catch (Exception e) {
            throw new UserDefineException("Error");
        }
        return user;
    }

    @Override
    public void convertToNextDay(String userid, String level) {
        User user = userRepository.findUserByUserid(userid);
        user.setLevel(level);
        userRepository.saveAndFlush(user);
    }
}
