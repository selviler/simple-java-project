package com.webtest.web.repository;

import com.webtest.web.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String username);
    UserEntity findByUsername(String username);

    UserEntity findFirstByUsername(String username);
}
