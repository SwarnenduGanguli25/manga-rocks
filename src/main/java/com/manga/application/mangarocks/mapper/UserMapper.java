package com.manga.application.mangarocks.mapper;

import com.manga.application.mangarocks.dto.UserRegisterDTO;
import com.manga.application.mangarocks.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUser(UserRegisterDTO userRegisterDTO, String encodedPassword) {
        return User.builder()
                .userName(userRegisterDTO.getUserName())
                .email(userRegisterDTO.getEmail())
                .mobile(userRegisterDTO.getMobile())
                .password(encodedPassword)
                .build();
    }
}
