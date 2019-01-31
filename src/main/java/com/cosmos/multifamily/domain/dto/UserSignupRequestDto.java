package com.cosmos.multifamily.domain.dto;

import com.cosmos.multifamily.domain.entity.User;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by YoungMan on 2018-12-19.
 */

@Getter
@Setter
public class UserSignupRequestDto {

    private String userId;
    private String userPw;
    private String name;
    private String mobile;

    public User toEntity() {
        return User.builder()
                .userId(userId)
                .userPw(userPw)
                .name(name)
                .mobile(mobile)
                .build();
    }
}
