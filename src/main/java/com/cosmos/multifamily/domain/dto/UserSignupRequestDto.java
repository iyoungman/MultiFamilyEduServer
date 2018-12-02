package com.cosmos.multifamily.domain.dto;

import com.cosmos.multifamily.domain.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 *UserSignupRequestDto
 *회원가입Dto
 */
@Getter
@RequiredArgsConstructor
public class UserSignupRequestDto {

    private String userid;
    private String pw;
    private String name;
    private String mobile;

    public UserSignupRequestDto(String userid, String pw, String name, String mobile) {
        this.userid = userid;
        this.pw = pw;
        this.name = name;
        this.mobile = mobile;
    }

    public User toEntity() {
        return new User(userid, pw, name, mobile);
    }

}
