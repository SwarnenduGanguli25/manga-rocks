package com.manga.application.mangarocks.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.manga.application.mangarocks.dto.GenericResponse;
import com.manga.application.mangarocks.dto.UserRegisterDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface UserController {

    @RequestMapping(value = "/user/register", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    ResponseEntity<GenericResponse> registerUser(@RequestBody UserRegisterDTO userRegisterDTO) throws JsonProcessingException;
}
