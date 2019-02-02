package com.cosmos.multifamily.controller;

import com.cosmos.multifamily.model.dto.UserSignupRequestDto;
import com.cosmos.multifamily.model.entity.User;
import com.cosmos.multifamily.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Created by YoungMan on 2018-12-19.
 */

@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users/signup", method = RequestMethod.POST)
    public void signupUser(@RequestBody UserSignupRequestDto userSignupRequestDto) {
        userService.signupUser(userSignupRequestDto);
    }

    @GetMapping("/users/{userid}")
    public User findUserByUserid(@PathVariable("userid") String userId) {
        return userService.findUserByUserId(userId);
    }

    @GetMapping("/users/{userid}/level/{level}")
    public void convertToNextDay(@PathVariable("userid") String userId, @PathVariable("level") String level) {
        userService.convertToNextDay(userId,level);
    }

}
