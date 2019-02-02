package com.cosmos.multifamily.repository;


import com.cosmos.multifamily.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by YoungMan on 2019-01-01.
 */

public interface UserRepository extends JpaRepository<User, String> {

    User findUserByUserId(String userId);
}
