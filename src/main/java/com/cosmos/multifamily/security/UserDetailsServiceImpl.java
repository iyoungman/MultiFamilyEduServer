package com.cosmos.multifamily.security;

import com.cosmos.multifamily.domain.entity.User;
import com.cosmos.multifamily.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *UserDetailsServiceImpl
 *db에 저장된 사용자정보를 조회하는 클래스
 *보완 예정
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;
    private Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public org.springframework.security.core.userdetails.User loadUserByUsername(String userid) throws UsernameNotFoundException {
        User newUser = userRepository.findUserByUserid(userid);
        logger.info("newUser:" + newUser.getUserid());
        if (newUser == null) {
            throw new UsernameNotFoundException(userid);
        }
        return new org.springframework.security.core.userdetails.User(newUser.getUserid(), newUser.getPw(), AuthorityUtils.createAuthorityList("USER"));
    }
}
