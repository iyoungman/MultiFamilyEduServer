package com.cosmos.multifamily.domain.dto;

import com.cosmos.multifamily.domain.entity.User;
import lombok.Getter;
import lombok.Setter;

/**
 *UserSignupRequestDto
 *회원가입Dto
 */
@Getter
@Setter
public class UserSignupRequestDto {

    private String userid;
    private String pw;
    private String name;
    private String mobile;

    public User toEntity() {
        return new User(userid, pw, name, mobile);
    }
}
