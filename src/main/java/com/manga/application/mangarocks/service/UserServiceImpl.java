package com.manga.application.mangarocks.service;

import com.manga.application.mangarocks.dto.GenericResponse;
import com.manga.application.mangarocks.dto.UserRegisterDTO;
import com.manga.application.mangarocks.exceptions.ValidationException;
import com.manga.application.mangarocks.mapper.UserMapper;
import com.manga.application.mangarocks.model.User;
import com.manga.application.mangarocks.repo.UserRepo;
import com.manga.application.mangarocks.mapper.ResponseBuilder;
import com.manga.application.mangarocks.utils.ValidationUtil;
import com.manga.application.mangarocks.validation.UserRegisterRequestValidation;
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
        return responseBuilder.getSuccessResponse("User registered successfully!!", HttpStatus.CREATED);
    }

    private void validateDuplicateUser(UserRegisterDTO userRegisterDTO) {
        if (userRepo.existsByUserName(userRegisterDTO.getUserName())) {
            throw new ValidationException("Username already exists");
        }
        if (userRepo.existsByEmail(userRegisterDTO.getEmail())) {
            throw new ValidationException("Email already exists");
        }
        if (userRepo.existsByMobile(userRegisterDTO.getMobile())) {
            throw new ValidationException("Mobile already exists");
        }
    }
}
