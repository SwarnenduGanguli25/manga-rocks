package com.manga.application.mangarocks.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manga.application.mangarocks.dto.GenericResponse;
import com.manga.application.mangarocks.dto.UserRegisterDTO;
import com.manga.application.mangarocks.dto.UserSignInDTO;
import com.manga.application.mangarocks.service.UserService;
import com.manga.application.mangarocks.utils.MaskingUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manga/v1")
@Slf4j
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    private final ObjectMapper maskingObjectMapper = MaskingUtil.getMaskingObjectMapper();

    @Override
    public ResponseEntity<GenericResponse> registerUser(UserRegisterDTO userRegisterDTO) throws JsonProcessingException {
        log.info("User Registration Request {}", maskingObjectMapper.writeValueAsString(userRegisterDTO));
        return userService.registerUser(userRegisterDTO);
    }

    @Override
    public ResponseEntity<GenericResponse> signInUser(UserSignInDTO userSignInDTO) throws JsonProcessingException {
        log.info("User Sign In Request {}", maskingObjectMapper.writeValueAsString(userSignInDTO));
        return userService.signInUser(userSignInDTO);
    }
}
