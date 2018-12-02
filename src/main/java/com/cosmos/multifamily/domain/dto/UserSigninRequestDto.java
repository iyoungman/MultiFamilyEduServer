package com.cosmos.multifamily.domain.dto;

import com.cosmos.multifamily.domain.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 *UserSigninRequestDto
 *로그인Dto
 */

@Getter
@RequiredArgsConstructor
public class UserSigninRequestDto {

    private String userid;
    private String pw;

    public UserSigninRequestDto(String userid, String pw) {
        this.userid = userid;
        this.pw = pw;
    }

    public User toEntity() {
        return new User(userid, pw);
    }
}
