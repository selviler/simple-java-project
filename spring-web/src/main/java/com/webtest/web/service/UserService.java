package com.webtest.web.service;

import com.webtest.web.dto.RegistrationDto;
import com.webtest.web.models.UserEntity;
import jakarta.validation.constraints.NotEmpty;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);
    UserEntity findByEmail(String email);
    UserEntity findByUserName(String username);
}
