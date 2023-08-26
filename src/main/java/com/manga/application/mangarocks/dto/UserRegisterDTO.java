package com.manga.application.mangarocks.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.manga.application.mangarocks.annotation.Mask;
import com.manga.application.mangarocks.validation.UserRegisterRequestValidation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRegisterDTO {

    @JsonProperty("username")
    @Pattern(regexp = "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$", message = "Please provide username containing min eight characters to max twenty characters containing letters and numbers", groups = {UserRegisterRequestValidation.class})
    @NotBlank(message = "Please provide user Name", groups = {UserRegisterRequestValidation.class})
    private String userName;

    @JsonProperty("email")
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid email id", groups = {UserRegisterRequestValidation.class})
    @NotBlank(message = "Please provide email id", groups = {UserRegisterRequestValidation.class})
    @Mask
    private String email;

    @JsonProperty("mobile")
    @Pattern(regexp = "^[5-9][0-9]{9}$", message = "Please provide valid mobile number starting with 5-9", groups = {UserRegisterRequestValidation.class})
    @NotBlank(message = "Please provide mobile number", groups = {UserRegisterRequestValidation.class})
    @Mask
    private String mobile;

    @JsonProperty("password")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "Please provide password containing at least eight characters, with at least one number and containing both lower and uppercase letters and special characters", groups = {UserRegisterRequestValidation.class})
    @NotBlank(message = "Please provide valid password", groups = {UserRegisterRequestValidation.class})
    @Mask
    private String password;
}
