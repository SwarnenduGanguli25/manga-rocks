package com.manga.application.mangarocks.service;

import com.manga.application.mangarocks.dto.GenericResponse;
import com.manga.application.mangarocks.dto.UserRegisterDTO;
import com.manga.application.mangarocks.dto.UserSignInDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<GenericResponse> registerUser(UserRegisterDTO userRegisterDTO);

    ResponseEntity<GenericResponse> signInUser(UserSignInDTO userSignInDTO);
}
