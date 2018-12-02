package com.cosmos.multifamily.service;

import com.cosmos.multifamily.domain.entity.User;
import org.springframework.transaction.annotation.Transactional;

/**
 *UserService
 *
 */
@Transactional
public interface UserService {

    void signupUser(User user);

    User findUserByUserid(String userId);
}
