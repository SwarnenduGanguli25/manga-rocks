package com.manga.application.mangarocks.service;

import com.manga.application.mangarocks.constants.UserConstant;
import com.manga.application.mangarocks.dto.GenericResponse;
import com.manga.application.mangarocks.dto.UserRegisterDTO;
import com.manga.application.mangarocks.dto.UserSignInDTO;
import com.manga.application.mangarocks.exceptions.ValidationException;
import com.manga.application.mangarocks.mapper.UserMapper;
import com.manga.application.mangarocks.model.User;
import com.manga.application.mangarocks.repo.UserRepo;
import com.manga.application.mangarocks.mapper.ResponseBuilder;
import com.manga.application.mangarocks.utils.ValidationUtil;
import com.manga.application.mangarocks.validation.UserRegisterRequestValidation;
import com.manga.application.mangarocks.validation.UserSignInRequestValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private static final BCryptPasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ResponseBuilder responseBuilder;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseEntity<GenericResponse> registerUser(UserRegisterDTO userRegisterDTO) {
        ValidationUtil.validate(userRegisterDTO, UserRegisterRequestValidation.class);
        validateDuplicateUser(userRegisterDTO);

        User user = userMapper.toUser(userRegisterDTO, PASSWORD_ENCODER.encode(userRegisterDTO.getPassword()));
        userRepo.save(user);
        log.info("New user has been registered with id {}", user.getId());
        return responseBuilder.getSuccessResponse(UserConstant.USER_REGISTERED_SUCCESSFULLY, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<GenericResponse> signInUser(UserSignInDTO userSignInDTO) {
        ValidationUtil.validate(userSignInDTO, UserSignInRequestValidation.class);
        User user = userRepo.findByUserNameOrEmail(userSignInDTO.getUserIdentifier(), userSignInDTO.getUserIdentifier())
                .orElseThrow(() -> new ValidationException(UserConstant.INVALID_USERNAME_EMAIL_OR_PASSWORD));
        validatePassword(userSignInDTO.getPassword(), user.getPassword(), UserConstant.INVALID_USERNAME_EMAIL_OR_PASSWORD);
        return responseBuilder.getSuccessResponse(userMapper.toUserSignInResponse(user), HttpStatus.OK);
    }

    private void validateDuplicateUser(UserRegisterDTO userRegisterDTO) {
        if (userRepo.existsByUserName(userRegisterDTO.getUserName())) {
            throw new ValidationException(UserConstant.USERNAME_ALREADY_EXISTS);
        }
        if (userRepo.existsByEmail(userRegisterDTO.getEmail())) {
            throw new ValidationException(UserConstant.EMAIL_ALREADY_EXISTS);
        }
        if (userRepo.existsByMobile(userRegisterDTO.getMobile())) {
            throw new ValidationException(UserConstant.MOBILE_ALREADY_EXISTS);
        }
    }

    private void validatePassword(String rawPassword, String encodedPassword, String errorMessage) {
        if (!PASSWORD_ENCODER.matches(rawPassword, encodedPassword)) {
            throw new ValidationException(errorMessage);
        }
    }
}
