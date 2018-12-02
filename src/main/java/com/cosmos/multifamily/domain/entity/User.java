package com.cosmos.multifamily.domain.entity;

import lombok.Data;

import javax.persistence.*;

/**
 *User
 *사용자
 * unique : userid
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userid;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String mobile;

    @Column(nullable = false)
    private String level = "1";

    @Column(nullable = false)
    private String count = "0";

    public User(String userid, String pw) {
        this.userid = userid;
        this.pw = pw;
    }

    public User(String userid, String pw, String name, String mobile) {
        this.userid = userid;
        this.pw = pw;
        this.name = name;
        this.mobile = mobile;
    }
}
