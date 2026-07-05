package com.manga.application.mangarocks.mapper;

import com.manga.application.mangarocks.constants.UserConstant;
import com.manga.application.mangarocks.dto.UserRegisterDTO;
import com.manga.application.mangarocks.dto.UserSignInResponseDTO;
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

    public UserSignInResponseDTO toUserSignInResponse(User user) {
        return UserSignInResponseDTO.builder()
                .userId(user.getId())
                .userName(user.getUserName())
                .message(UserConstant.USER_SIGNED_IN_SUCCESSFULLY)
                .build();
    }
}
