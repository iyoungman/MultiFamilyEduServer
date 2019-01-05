package com.cosmos.multifamily.service.impl;

import com.cosmos.multifamily.domain.dto.UserSignupRequestDto;
import com.cosmos.multifamily.domain.entity.User;
import com.cosmos.multifamily.repository.UserRepository;
import com.cosmos.multifamily.service.UserService;
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
    //final변수는 생성자에서 초기화. 생성자는 클래스의 코드에서 유질하게 유지될수 있음을 보장, 메소드는 여러번 호출될 수 있다.
    private final UserRepository userRepository;
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void signupUser(UserSignupRequestDto userSignupRequestDto) throws ServiceException {
        User user = userSignupRequestDto.toEntity();
        userRepository.saveAndFlush(user);
    }

    @Override
    public User findUserByUserid(String userid) throws ServiceException {
        User user = userRepository.findUserByUserid(userid);
        return user;
    }

    @Override
    public void findAll() throws ServiceException {
        ArrayList objectList = userRepository.findAll();
    }



}
