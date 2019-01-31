package com.cosmos.multifamily.service;

import com.cosmos.multifamily.domain.dto.UserSignupRequestDto;
import com.cosmos.multifamily.domain.entity.User;
import org.springframework.transaction.annotation.Transactional;

/**
 *UserService
 *
 */
@Transactional
public interface UserService {

    void signupUser(UserSignupRequestDto userSignupRequestDto);

    User findUserByUserid(String userId);

    void convertToNextDay(String userid, String level);

}
