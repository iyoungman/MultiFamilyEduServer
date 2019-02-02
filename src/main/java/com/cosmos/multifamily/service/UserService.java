package com.cosmos.multifamily.service;

import com.cosmos.multifamily.model.dto.UserSignupRequestDto;
import com.cosmos.multifamily.model.entity.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by YoungMan on 2018-12-19.
 */

@Transactional
public interface UserService {

    void signupUser(UserSignupRequestDto userSignupRequestDto);

    User findUserByUserId(String userId);

    void convertToNextDay(String userId, String level);

}
