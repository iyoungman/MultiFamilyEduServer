package com.cosmos.multifamily.controller;

import com.cosmos.multifamily.domain.dto.UserSignupRequestDto;
import com.cosmos.multifamily.domain.entity.User;
import com.cosmos.multifamily.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * UserController
 * 사용자와 관련된 클래스
 */
@RestController
public class UserController {
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users/signup", method = RequestMethod.POST)
    public void signupUser(@RequestBody UserSignupRequestDto userSignupRequestDto) {
        userService.signupUser(userSignupRequestDto);
    }

    @GetMapping("/users/{userid}")
    public User findUserByUserid(@PathVariable("userid") String userId) {
        return userService.findUserByUserid(userId);
    }

    @GetMapping("/users/{userid}/level/{level}")// level = nextlevel , 최종 level 처리는 클라이언트에서
    public void convertToNextDay(@PathVariable("userid") String userId, @PathVariable("level") String level) {
        userService.convertToNextDay(userId,level);
    }


}
