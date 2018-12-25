package com.cosmos.multifamily.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

/**
 *User
 *사용자
 * unique : userid
 */
@Data
@Entity
@AllArgsConstructor
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

    @Transient
    private String response;

    public User(String _userid, String _pw, String _name, String _mobile) {
        this.userid = _userid;
        this.pw = _pw;
        this.name = _name;
        this.mobile = _mobile;
    }

}
