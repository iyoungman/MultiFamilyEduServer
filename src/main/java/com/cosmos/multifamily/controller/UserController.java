package com.cosmos.multifamily.controller;

import com.cosmos.multifamily.domain.entity.User;
import com.cosmos.multifamily.domain.dto.UserSignupRequestDto;
import com.cosmos.multifamily.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 *UserController
 *사용자와 관련된 클래스
 */
@RestController
public class UserController {
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users/singup")
    public void signupUser(@RequestBody UserSignupRequestDto userSignupRequestDto) {
        User user = userSignupRequestDto.toEntity();
        userService.signupUser(user);
    }

    @GetMapping("/users/{userid}")
    public User findUserByUserid(@PathVariable("userid") String userId) {
        return userService.findUserByUserid(userId);
    }















    @GetMapping("/members/{userid}")//testid
    public User getMemberInfo(@PathVariable String userid) {
        logger.info("============================");
        if(userid == null){
            logger.info("null");
        } else {
            logger.info("not null"+ userid);
        }

        User user = userService.findUserByUserid(userid);
        return user;
    }


}
